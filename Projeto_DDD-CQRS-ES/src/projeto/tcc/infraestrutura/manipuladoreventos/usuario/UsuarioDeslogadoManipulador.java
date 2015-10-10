package projeto.tcc.infraestrutura.manipuladoreventos.usuario;

import java.sql.Connection;
import java.sql.Date;

import projeto.tcc.dominio.eventos.Evento;
import projeto.tcc.dominio.eventos.usuario.UsuarioDeslogadoEvento;
import projeto.tcc.infraestrutura.Conexao;
import projeto.tcc.infraestrutura.IAssinante;

import com.mysql.jdbc.PreparedStatement;

public class UsuarioDeslogadoManipulador implements IAssinante<Evento> {
	public UsuarioDeslogadoManipulador() {
		// TODO Auto-generated constructor stub
	}
	
	public UsuarioDeslogadoManipulador(UsuarioDeslogadoEvento evento) {
		trata(evento);
	}
	
	public void trata(UsuarioDeslogadoEvento evento) {
		insereViews(evento);
	
	}

	private void insereViews(UsuarioDeslogadoEvento usuarioDeslogadoEvento) {
		Connection conexao = Conexao.getConectionReader();
		try {
			PreparedStatement pstmt1 = null;
			pstmt1 = (PreparedStatement) conexao.prepareStatement("insert into " +
					"auditoriaLoginUsuario(aggregateID,login, acao, data) " +
					"values(?,?,?)", 
					PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt1.setString(1, usuarioDeslogadoEvento.getAggregateId().toString());
			pstmt1.setString(2, usuarioDeslogadoEvento.getLogin());
			pstmt1.setString(3, "deslogou");
			pstmt1.setDate(4,new Date(usuarioDeslogadoEvento.getDtDeslogin().getTime()));
			pstmt1.executeUpdate();
			pstmt1.close();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}finally{
			Conexao.fechaConexao();
		}
	}

	@Override
	public void getPublicacao(Evento arg) {
		if (arg instanceof UsuarioDeslogadoEvento) {
			insereViews((UsuarioDeslogadoEvento) arg);
		}
	}

}
