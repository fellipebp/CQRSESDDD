
package projeto.tcc.infraestrutura.manipuladoreventos.musica;

import java.sql.Connection;

import projeto.tcc.dominio.eventos.Evento;
import projeto.tcc.dominio.eventos.musica.MusicaAdicionadaEvento;
import projeto.tcc.dominio.eventos.usuario.UsuarioCadastradoEvento;
import projeto.tcc.infraestrutura.Conexao;
import projeto.tcc.infraestrutura.IAssinante;

import com.mysql.jdbc.PreparedStatement;

public class MusicaAdicionadaManipulador implements IAssinante<Evento>{

	
	private void insereViews(MusicaAdicionadaEvento musicaAdicionadaEvento) {
		Connection conexao = Conexao.getConectionReader();
		try {
			PreparedStatement pstmt1 = null;
			pstmt1 = (PreparedStatement) conexao.prepareStatement("insert into " +
					"musicasusuario(aggregateID,nome, duracao) " +
					"values(?,?,?)", 
					PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt1.setString(1, musicaAdicionadaEvento.getAggregateId().toString());
			pstmt1.setString(2, musicaAdicionadaEvento.getNomeMusica());
			pstmt1.setString(3, null);
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
		if (arg instanceof MusicaAdicionadaEvento) {
			insereViews((MusicaAdicionadaEvento) arg);
		}
		
	}


}
