package projeto.tcc.infraestrutura;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import projeto.tcc.eventos.Evento;
import projeto.tcc.eventos.usuario.UsuarioCadastradoEvento;

import com.mysql.jdbc.PreparedStatement;

public class Conexao {

	Connection connection;
	String query = "select * from aggregates where aggregate_id = ?";


	public void getConection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}

		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/eventsource", "root", "mysql");


		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}

	}

	public void salvarEvento(Evento evento) throws Exception {

		PreparedStatement pstmt1 = null;
		
		
	
			 pstmt1 = (PreparedStatement) connection
					.prepareStatement(
							"insert into eventstore(aggregate_id,evento) values(?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS);
		

		// set input parameters
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(evento);
		oos.flush();
		oos.close();
		bos.close();
		byte[] dadosEvento = bos.toByteArray();
		pstmt1.setInt(1, 1);
		pstmt1.setObject(2, dadosEvento);
		pstmt1.executeUpdate();

		// get the generated key for the id
		pstmt1.close();

		System.out.println("writeJavaObject: done serializing: ");
	}

	public Object readJavaObject(long id) throws Exception {
		PreparedStatement pstmt = (PreparedStatement) connection
				.prepareStatement("select dados_evento from eventstore where id_event_store = ?");
		pstmt.setLong(1, id);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		byte[] buf = rs.getBytes("dados_evento");
		ObjectInputStream objectIn = null;
		if (buf != null)
			objectIn = new ObjectInputStream(new ByteArrayInputStream(buf));
		UsuarioCadastradoEvento object = (UsuarioCadastradoEvento) objectIn
				.readObject();
		String className = object.getClass().getName();
		rs.close();
		pstmt.close();
		System.out.println("Deserialization Successful." 
				+ "\nDeserialized Class: " + className);
		return object;
	}

}
