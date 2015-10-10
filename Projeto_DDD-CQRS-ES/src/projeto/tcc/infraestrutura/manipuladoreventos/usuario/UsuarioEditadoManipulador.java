package projeto.tcc.infraestrutura.manipuladoreventos.usuario;

import java.sql.Connection;

import projeto.tcc.dominio.eventos.Evento;
import projeto.tcc.dominio.eventos.usuario.UsuarioEditadoEvento;
import projeto.tcc.infraestrutura.Conexao;
import projeto.tcc.infraestrutura.IAssinante;

import com.mysql.jdbc.PreparedStatement;

public class UsuarioEditadoManipulador implements IAssinante<Evento>{
	
	public UsuarioEditadoManipulador() {
		// TODO Auto-generated constructor stub
	}
	
	public UsuarioEditadoManipulador(UsuarioEditadoEvento evento) {
		trata(evento);
	}
	
	public void trata(UsuarioEditadoEvento evento) {
		insereViews(evento);
	
	}

	private void insereViews(UsuarioEditadoEvento usuarioEditadoEvento) {
		Connection conexao = Conexao.getConectionReader();
		try {
			PreparedStatement pstmt = null;
			pstmt = (PreparedStatement) conexao.prepareStatement("update  " +
					"dadosusuario SET senha = ?, nome = ?, CPF = ?, email = ? " +
					"WHERE aggregateID = ?");
			pstmt.setString(1, usuarioEditadoEvento.getSenha());
			pstmt.setString(2, usuarioEditadoEvento.getNome());
			pstmt.setString(3, usuarioEditadoEvento.getCPF());
			pstmt.setString(4, usuarioEditadoEvento.getEmail());
			pstmt.setString(5, usuarioEditadoEvento.getAggregateId().toString());
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
	public void getPublicacao(Evento arg) {
		if (arg instanceof UsuarioEditadoEvento) {
			insereViews((UsuarioEditadoEvento) arg);
		}
	}

}
