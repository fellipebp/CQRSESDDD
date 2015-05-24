package projeto.tcc.infraestrutura.armazenamento;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import projeto.tcc.dominio.eventos.Evento;
import projeto.tcc.infraestrutura.Conexao;
import projeto.tcc.infraestrutura.Publicador;

import com.mysql.jdbc.PreparedStatement;

public class ArmazenadorEventos {
	
	private static Connection connection;

	public static void salvarEvento(Evento evento) {
		connection = Conexao.getConectionEventSource();
		try {
			PreparedStatement pstmt1 = null;
			pstmt1 = (PreparedStatement) connection.prepareStatement(
					"insert into eventstore(agregateid,events) values(?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);

			// set input parameters
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(evento);
			oos.flush();
			oos.close();
			bos.close();
			byte[] dadosEvento = bos.toByteArray();
			pstmt1.setString(1, evento.getAggregateId().toString());
			pstmt1.setObject(2, dadosEvento);
			pstmt1.executeUpdate();
			// get the generated key for the id
			pstmt1.close();
			System.out.println("writeJavaObject: done serializing: ");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}finally{
			Conexao.fechaConexao();
		}
		
		new Publicador().adicionaEvento(evento);
		
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
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				byte[] buf = rs.getBytes("events");
				if (buf != null) {
					objectIn = new ObjectInputStream(new ByteArrayInputStream(buf));
					evento = (Evento) objectIn.readObject();
					System.out.println("Deserialization Successful."+ "\nDeserialized Class: "+ evento.getClass().getName());	
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
