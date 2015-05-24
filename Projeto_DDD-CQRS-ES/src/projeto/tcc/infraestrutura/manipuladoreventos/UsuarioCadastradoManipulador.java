package projeto.tcc.infraestrutura.manipuladoreventos;

import java.sql.Connection;

import projeto.tcc.dominio.eventos.Evento;
import projeto.tcc.dominio.eventos.usuario.UsuarioCadastradoEvento;
import projeto.tcc.infraestrutura.Conexao;

import com.mysql.jdbc.PreparedStatement;

public class UsuarioCadastradoManipulador implements ManipuladorEventos{

	@Override
	public void trata(Evento evento) {
		UsuarioCadastradoEvento usuarioCadastradoEvento = (UsuarioCadastradoEvento) evento;
		insereViews(usuarioCadastradoEvento);
	
	}

	private void insereViews(UsuarioCadastradoEvento usuarioCadastradoEvento) {
		Connection conexao = Conexao.getConectionReader();
		try {
			PreparedStatement pstmt1 = null;
			pstmt1 = (PreparedStatement) conexao.prepareStatement("insert into " +
					"dadosusuario(aggregateID,login, senha, nome, CPF, email) " +
					"values(?,?,?,?,?,?)", 
					PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt1.setString(1, usuarioCadastradoEvento.getAggregateId().toString());
			pstmt1.setString(2, usuarioCadastradoEvento.getLogin());
			pstmt1.setString(3, usuarioCadastradoEvento.getSenha());
			pstmt1.setString(4, usuarioCadastradoEvento.getNome());
			pstmt1.setString(5, usuarioCadastradoEvento.getCPF());
			pstmt1.setString(6, usuarioCadastradoEvento.getEmail());
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
