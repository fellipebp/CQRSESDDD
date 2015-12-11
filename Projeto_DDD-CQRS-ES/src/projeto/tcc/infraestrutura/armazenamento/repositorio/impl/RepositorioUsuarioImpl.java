package projeto.tcc.infraestrutura.armazenamento.repositorio.impl;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import projeto.tcc.dominio.entidades.musica.PlayList;
import projeto.tcc.dominio.entidades.usuario.RestauradorAtributosUsuario;
import projeto.tcc.dominio.entidades.usuario.Usuario;
import projeto.tcc.dominio.eventos.Evento;
import projeto.tcc.dominio.eventos.musica.PlayListAdicionadaEvento;
import projeto.tcc.dominio.eventos.usuario.UsuarioCadastradoEvento;
import projeto.tcc.infraestrutura.Conexao;
import projeto.tcc.infraestrutura.armazenamento.ArmazenadorEventos;
import projeto.tcc.infraestrutura.armazenamento.repositorio.RepositorioUsuario;

import com.mysql.jdbc.PreparedStatement;

public class RepositorioUsuarioImpl implements RepositorioUsuario{
	
	private static final Logger LOGGER = Logger.getLogger(RepositorioUsuarioImpl.class.getName());

	
	@Override
	public Usuario getUsuario(String id) {
		return null;
	}

	@Override
	public Usuario getUsuarioPorCPF(String CPF) {
		Usuario usuario = null;
		try {
			
			PreparedStatement pstmt =  (PreparedStatement)Conexao.getConectionReader().prepareStatement("SELECT * from baseleitura.dadosusuario where CPF = ?");
			pstmt.setString(1, CPF);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				usuario = new Usuario();
				usuario.setCPF(CPF);
				usuario.setDataNascimento(rs.getDate("dataNascimento"));
				usuario.setEmail(rs.getString("email"));
				usuario.setId(rs.getInt("id"));
				usuario.setLogin(rs.getString("login"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setSenha(rs.getString("sexo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
	}


	@Override
	public String existeUsuarioComEsseLogin(String login) {
		String aggregateID = null;
		try {
			
			PreparedStatement pstmt =  (PreparedStatement)Conexao.getConectionReader().prepareStatement("SELECT aggregateID from baseleitura.dadosusuario where login = ?");
			pstmt.setString(1, login);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				aggregateID = rs.getString("aggregateID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return aggregateID;
	}

	@Override
	public Usuario getUsuarioPorAggregateID(String aggregateID) {
		try {
			List<Evento> eventos = ArmazenadorEventos.recuperaEventos(aggregateID);
			if (!eventos.isEmpty()) {
				return this.constroiEntidade(eventos);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private Usuario constroiEntidade(List<Evento> history) 	{
		Method method;
		RestauradorAtributosUsuario restauradorAtributosUsuario = new RestauradorAtributosUsuario();
		try {
			for (Evento evento : history) {
				method = restauradorAtributosUsuario.getClass().getMethod("aplicaMudanca", evento.getClass());
				method.invoke(restauradorAtributosUsuario, evento);
			}
		} catch (SecurityException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		} catch (NoSuchMethodException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		} catch (IllegalAccessException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		} catch (IllegalArgumentException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		} catch (InvocationTargetException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		return restauradorAtributosUsuario.getUsuario();
	}


	@Override
	public List<PlayList> getPlayListsPorEventos(String aggregateID) {
		Method method;
		RestauradorAtributosUsuario restauradorAtributosUsuario = new RestauradorAtributosUsuario();
		try {
			List<Evento> eventos = ArmazenadorEventos.recuperaEventos(aggregateID);
			if (!eventos.isEmpty()) {
				
				for(Evento evento : eventos) {
					if(evento instanceof PlayListAdicionadaEvento){
						method = restauradorAtributosUsuario.getClass().getMethod("aplicaMudanca", evento.getClass());
						method.invoke(restauradorAtributosUsuario, evento);
					}
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return restauradorAtributosUsuario.getUsuario().getPlayLists();
	}
	
	@Override
	public List<PlayList> getListaPlayList(String aggregateID) {
		List<PlayList>playlists = null;
		PlayList playlist = null;
		try {
			playlists = new ArrayList<PlayList>();
			PreparedStatement pstmt =  (PreparedStatement)Conexao.getConectionReader().prepareStatement("SELECT aggregateIDPlayList, nome from baseleitura.playlistsusuario where aggregateIDUsuario = ?");
			pstmt.setString(1, aggregateID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				playlist = new PlayList();
				playlist.setAggregateID(rs.getString("aggregateIDPlayList"));
				playlist.setNome(rs.getString("nome"));
				playlists.add(playlist);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return playlists;
	}


	@Override
	public int getNivelAcessoUsuario(String aggregateID) {
		PreparedStatement pstmt;
		int nivelAcesso = 0;
		try {
			pstmt = (PreparedStatement)Conexao.getConectionReader().prepareStatement("SELECT cdPerfil from baseleitura.dadosusuario where aggregateID = ?");
			pstmt.setString(1, aggregateID);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				nivelAcesso = rs.getInt("cdPerfil");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nivelAcesso;
	}

}
