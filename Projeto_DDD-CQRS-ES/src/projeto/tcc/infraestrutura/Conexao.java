package projeto.tcc.infraestrutura;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import projeto.tcc.dominio.eventos.Evento;


import com.mysql.jdbc.PreparedStatement;

public class Conexao {

	private static final String EVENTSOURCE = "jdbc:mysql://localhost:3306/eventsource";
	private static final String BASELEITURA = "jdbc:mysql://localhost:3306/baseleitura";
	private static Connection connection;
	String query = "select * from aggregates where aggregate_id = ?";

	public static Connection getConectionEventSource() {
		carregaDriver();
		try {
			connection = DriverManager.getConnection(EVENTSOURCE, "root",
					"123");

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;
		}

		verificaConexao();
		return connection;

	}

	private static void verificaConexao() {
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}

	public static Connection getConectionReader() {
		carregaDriver();
		try {
			connection = DriverManager.getConnection(BASELEITURA, "root",
					"mysql");
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;
		}
		verificaConexao();
		return connection;
	}

	private static void carregaDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}
	}

	public static void salvarEvento(Evento evento) {
		getConectionEventSource();
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
			fechaConexao();
		}
		
		//new SincronizadorFontesDados(evento).run();
	}

	public static Evento recuperaEvento(String id) {
		getConectionEventSource();
		try {
			PreparedStatement pstmt =  (PreparedStatement)connection.prepareStatement("select events from eventstore where agregateid = ?");
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			byte[] buf = rs.getBytes("events");
			ObjectInputStream objectIn = null;
			if (buf != null){
				objectIn = new ObjectInputStream(new ByteArrayInputStream(buf));
			}
			Evento evento = (Evento) objectIn.readObject();
			String className = evento.getClass().getName();
			rs.close();
			pstmt.close();
			System.out.println("Deserialization Successful."+ "\nDeserialized Class: " + className);
			return evento;
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			fechaConexao();
		}
		return null;
	}

	private static void fechaConexao() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
