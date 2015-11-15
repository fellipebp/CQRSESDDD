package projeto.tcc.infraestrutura.manipuladoreventos.usuario;

import java.sql.Connection;

import com.mysql.jdbc.PreparedStatement;

import projeto.tcc.dominio.eventos.Evento;
import projeto.tcc.dominio.eventos.usuario.SenhaAlteradaEvento;
import projeto.tcc.dominio.eventos.usuario.UsuarioEditadoEvento;
import projeto.tcc.infraestrutura.Conexao;
import projeto.tcc.infraestrutura.IAssinante;


public class SenhaAlteradaManipulador implements IAssinante<Evento> {

	private void insereViews(SenhaAlteradaEvento senhaAlteradaEvento) {
		Connection conexao = Conexao.getConectionReader();
		try {
			PreparedStatement pstmt = null;
			pstmt = (PreparedStatement) conexao.prepareStatement("update  " +
					"dadosusuario SET senha = ? " +
					"WHERE aggregateID = ?");
			pstmt.setString(1, senhaAlteradaEvento.getSenha());
			pstmt.setString(2, senhaAlteradaEvento.getAggregateId().toString());
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
	public void getPublicacao(Evento argumento) {
		if (argumento instanceof SenhaAlteradaEvento) {
			insereViews((SenhaAlteradaEvento)argumento);
		}
		
	}

}
