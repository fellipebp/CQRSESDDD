package projeto.tcc.infraestrutura.armazenamento.impl;


import java.sql.ResultSet;
import java.sql.SQLException;

import projeto.tcc.dominio.Usuario;
import projeto.tcc.dominio.eventos.usuario.UsuarioCadastradoEvento;
import projeto.tcc.infraestrutura.Conexao;
import projeto.tcc.infraestrutura.EventStore;
import projeto.tcc.infraestrutura.armazenamento.RepositorioUsuario;

import com.mysql.jdbc.PreparedStatement;

public class RepositorioUsuarioImpl implements RepositorioUsuario{

	
	@Override
	public Usuario getUsuario(String id) {
		return null;
	}
	
	
	public void processarUsuarioCadastradoEvento(UsuarioCadastradoEvento e) throws Exception{
		EventStore.salvarEvento(e);
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
	public Usuario getUsuarioPorLogin(String login) {
		Usuario usuario = null;
		try {
			
			PreparedStatement pstmt =  (PreparedStatement)Conexao.getConectionReader().prepareStatement("SELECT * from baseleitura.dadosusuario where login = ?");
			pstmt.setString(1, login);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				usuario = new Usuario();
				usuario.setCPF(rs.getString("CPF"));
				usuario.setDataNascimento(rs.getDate("dataNascimento"));
				usuario.setEmail(rs.getString("email"));
				usuario.setId(rs.getInt("id"));
				usuario.setLogin(login);
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setSexo(rs.getString("sexo"));
				usuario.setAggregateID(rs.getString("aggregateID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
	}


}
