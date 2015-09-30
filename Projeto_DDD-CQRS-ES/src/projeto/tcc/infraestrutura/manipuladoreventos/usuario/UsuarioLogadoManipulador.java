package projeto.tcc.infraestrutura.manipuladoreventos.usuario;

import java.sql.Connection;
import java.sql.Date;

import com.mysql.jdbc.PreparedStatement;

import projeto.tcc.dominio.eventos.Evento;
import projeto.tcc.dominio.eventos.usuario.UsuarioCadastradoEvento;
import projeto.tcc.dominio.eventos.usuario.UsuarioLogadoEvento;
import projeto.tcc.infraestrutura.Conexao;
import projeto.tcc.infraestrutura.Subscriber;

public class UsuarioLogadoManipulador implements Subscriber<Evento> {

	
	public UsuarioLogadoManipulador() {
		// TODO Auto-generated constructor stub
	}
	public UsuarioLogadoManipulador(UsuarioLogadoEvento evento) {
		trata(evento);
	}
	
	public void trata(UsuarioLogadoEvento evento) {
		insereViews(evento);
	}

	private void insereViews(UsuarioLogadoEvento usuarioLogadoEvento) {
		Connection conexao = Conexao.getConectionReader();
		try {
			PreparedStatement pstmt = null;
			pstmt = (PreparedStatement) conexao.prepareStatement("update  " +
					"dadosusuario SET dataUltimoLogin = ?" +
					"WHERE aggregateID = ?");
			pstmt.setDate(1, new Date(usuarioLogadoEvento.getDtLogin().getTime()));
			pstmt.setString(2, usuarioLogadoEvento.getAggregateId().toString());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}finally{
			Conexao.fechaConexao();
		}
	}

	@Override
	public void getPublication(Evento arg) {
		if (arg instanceof UsuarioLogadoEvento) {
			insereViews((UsuarioLogadoEvento) arg);
		}
	}

}
