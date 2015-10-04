//package projeto.tcc.infraestrutura.armazenamento.repositorio.impl;
//
//
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//import projeto.tcc.dominio.entidades.musica.PlayList;
//import projeto.tcc.dominio.entidades.usuario.RestauradorAtributosUsuario;
//import projeto.tcc.dominio.eventos.Evento;
//import projeto.tcc.dominio.eventos.musica.PlayListAdicionadaEvento;
//import projeto.tcc.infraestrutura.Conexao;
//import projeto.tcc.infraestrutura.armazenamento.ArmazenadorEventos;
//import projeto.tcc.infraestrutura.armazenamento.repositorio.RepositorioPlaylist;
//
//import com.mysql.jdbc.PreparedStatement;
//
//public class RepositorioPlaylistImpl implements RepositorioPlaylist{
//	
//	private static final Logger LOGGER = Logger.getLogger(RepositorioPlaylistImpl.class.getName());
//
//	
//
//	@Override
//	public PlayList getPlaylistPorAggregateID(String aggregateID) {
//		try {
//			List<Evento> eventos = ArmazenadorEventos.recuperaEventos(aggregateID);
//			if (!eventos.isEmpty()) {
//				return this.constroiEntidade(eventos);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//	private PlayList constroiEntidade(List<Evento> history) 	{
//		Method method;
//		RestauradorAtributosUsuario restauradorAtributosUsuario = new RestauradorAtributosUsuario();
//		try {
//			for (Evento evento : history) {
//				method = restauradorAtributosUsuario.getClass().getMethod("aplicaMudanca", evento.getClass());
//				method.invoke(restauradorAtributosUsuario, evento);
//			}
//		} catch (SecurityException e) {
//			LOGGER.log(Level.SEVERE, e.getMessage());
//		} catch (NoSuchMethodException e) {
//			LOGGER.log(Level.SEVERE, e.getMessage());
//		} catch (IllegalAccessException e) {
//			LOGGER.log(Level.SEVERE, e.getMessage());
//		} catch (IllegalArgumentException e) {
//			LOGGER.log(Level.SEVERE, e.getMessage());
//		} catch (InvocationTargetException e) {
//			LOGGER.log(Level.SEVERE, e.getMessage());
//		}
//		return restauradorAtributosPlaylist.getPlaylist();
//	}
//	
//	public List<PlayList> recuperarMinhasPlaylists(String aggregateID) {
//		List<PlayList> minhasPlaylists = new ArrayList<PlayList>();
//		try {
//			
//			ResultSet rs = pstmt.executeQuery();
//		
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return minhasPlaylists;
//	}
//
//	//Ainda sendo construido
//	@Override
//	public List<UUID> getAggregatePlayList(String aggregateID) {
//		Method method;
//		RestauradorAtributosUsuario restauradorAtributosUsuario = new RestauradorAtributosUsuario();
//		try {
//			List<Evento> eventos = ArmazenadorEventos.recuperaEventos(aggregateID);
//			if (!eventos.isEmpty()) {
//				
//				for(Evento evento : eventos) {
//					if(evento instanceof PlayListAdicionadaEvento){
//						method = restauradorAtributosUsuario.getClass().getMethod("aplicaMudanca", evento.getClass());
//						method.invoke(restauradorAtributosUsuario, evento);
//						break;
//					}
//				}
//				
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return restauradorAtributosUsuario.getUsuario().getAggregateIDPlayList();
//	}
//
//}