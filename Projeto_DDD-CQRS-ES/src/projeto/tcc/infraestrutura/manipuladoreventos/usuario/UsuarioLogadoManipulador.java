package projeto.tcc.infraestrutura.manipuladoreventos.usuario;

import java.sql.Connection;
import java.sql.Date;

import com.mysql.jdbc.PreparedStatement;

import projeto.tcc.dominio.eventos.Evento;
import projeto.tcc.dominio.eventos.usuario.UsuarioCadastradoEvento;
import projeto.tcc.dominio.eventos.usuario.UsuarioLogadoEvento;
import projeto.tcc.infraestrutura.Conexao;

public class UsuarioLogadoManipulador {

	public UsuarioLogadoManipulador(UsuarioLogadoEvento evento) {
		trata(evento);
	}
	
	public void trata(UsuarioLogadoEvento evento) {
		insereViews(evento);
	
	}

	private void insereViews(UsuarioLogadoEvento usuarioLogadoEvento) {
		Connection conexao = Conexao.getConectionReader();
		try {
			PreparedStatement pstmt1 = null;
			pstmt1 = (PreparedStatement) conexao.prepareStatement("insert into " +
					"auditoriaLoginUsuario(aggregateID,login,acao, data) " +
					"values(?,?,?, ?)", 
					PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt1.setString(1, usuarioLogadoEvento.getAggregateId().toString());
			pstmt1.setString(2, usuarioLogadoEvento.getLogin());
			pstmt1.setString(3, "logou");
			pstmt1.setDate(4,new Date(usuarioLogadoEvento.getDtLogin().getTime()));
			pstmt1.executeUpdate();
			pstmt1.close();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}finally{
			Conexao.fechaConexao();
		}
	}

}
