package projeto.tcc.infraestrutura;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
					"123");
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

}
