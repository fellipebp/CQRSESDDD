package projeto.tcc.infraestrutura.armazenamento;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import projeto.tcc.dominio.eventos.Evento;
import projeto.tcc.infraestrutura.Conexao;
import projeto.tcc.infraestrutura.Publicador;
import projeto.tcc.infraestrutura.manipuladoreventos.usuario.MusicaAdicionadaManipulador;
import projeto.tcc.infraestrutura.manipuladoreventos.usuario.UsuarioCadastradoManipulador;
import projeto.tcc.infraestrutura.manipuladoreventos.usuario.UsuarioDeslogadoManipulador;
import projeto.tcc.infraestrutura.manipuladoreventos.usuario.UsuarioEditadoManipulador;
import projeto.tcc.infraestrutura.manipuladoreventos.usuario.UsuarioLogadoManipulador;

import com.mysql.jdbc.PreparedStatement;

public class ArmazenadorEventos {
	
	private static Publicador publicador;
	private static Connection connection;

	  static {
	      publicador = new Publicador();
	      carregaSubscribers();
	  }
	  
	
	private static void carregaSubscribers() {
		publicador.subscriber(new MusicaAdicionadaManipulador());
		publicador.subscriber(new UsuarioCadastradoManipulador());
		publicador.subscriber(new UsuarioDeslogadoManipulador());
		publicador.subscriber(new UsuarioEditadoManipulador());
		publicador.subscriber(new MusicaAdicionadaManipulador());
		publicador.subscriber(new UsuarioLogadoManipulador());
	}


	public static void salvarEvento(Evento evento) {
		connection = Conexao.getConectionEventSource();
		if (evento.getAggregateId() != null && evento.getVersion() != null) {

			try {
//				if (!versaoEhValida(evento.getVersion(),evento.getAggregateId())) {
					// FIXME CRIAR EXCEÇÃO ESPECIFICA
//					throw new RuntimeException("Versao Incorreta");
//				}
				PreparedStatement pstmt1 = null;
				pstmt1 = (PreparedStatement) connection
						.prepareStatement("insert into eventstore(agregateid,events, version) values(?,?,?)",
								PreparedStatement.RETURN_GENERATED_KEYS);
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(bos);
				oos.writeObject(evento);
				oos.flush();
				oos.close();
				bos.close();
				byte[] dadosEvento = bos.toByteArray();
				pstmt1.setString(1, evento.getAggregateId().toString());
				pstmt1.setObject(2, dadosEvento);
				pstmt1.setInt(3, evento.getVersion());
				pstmt1.executeUpdate();
				pstmt1.close();
			} catch (Exception e) {
				e.printStackTrace();
				return;
			} finally {
				Conexao.fechaConexao();
			}

			publicador.publicaEvento(evento);
		}
	}

	
	public static void salvarAggregado(UUID aggregateID, Class<?> clazz, Integer version) {
		connection = Conexao.getConectionEventSource();
		try {
			PreparedStatement pstmt2 = null;
			pstmt2 = (PreparedStatement) connection.prepareStatement(
					"insert into aggregates(aggregate_id,type, version) values(?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);

			pstmt2.setString(1, aggregateID.toString());
			pstmt2.setString(2, clazz.getName());
			pstmt2.setInt(3, version);
			pstmt2.executeUpdate();
			pstmt2.close();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}finally{
			Conexao.fechaConexao();
		}
		
	}
	
	private static boolean versaoEhValida(Integer version, UUID aggregateID){
		Integer versaoEsperada= 0;
		try {

			PreparedStatement pstmt = (PreparedStatement) Conexao
					.getConectionEventSource()
					.prepareStatement(
							"SELECT version from eventsource.aggregates where aggregate_id = ?");
			pstmt.setString(1, aggregateID.toString());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				versaoEsperada = rs.getInt("version")+1;
			}
			if (version == versaoEsperada) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
		
	}

	public static List<Evento> recuperaEventos(String id) {
		List<Evento> eventos = new ArrayList<>();
		Evento evento = null;
		ObjectInputStream objectIn = null;
		connection = Conexao.getConectionEventSource();
		try {
			PreparedStatement pstmt = (PreparedStatement) connection
					.prepareStatement("select events from eventstore where agregateid = ?");
			pstmt.setString(1, id);
			
//			PreparedStatement pstmt = (PreparedStatement) connection
//					.prepareStatement("select events from eventstore where agregateid = ? order by version");
//			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				byte[] buf = rs.getBytes("events");
				if (buf != null) {
					objectIn = new ObjectInputStream(new ByteArrayInputStream(buf));
					evento = (Evento) objectIn.readObject();
					eventos.add(evento);
				}
				
			}
			return eventos;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			Conexao.fechaConexao();
		}
		return null;
	}
	


	
	
}
