package projeto.tcc.infraestrutura.manipuladoreventos.musica;

import java.sql.Connection;

import projeto.tcc.dominio.eventos.Evento;
import projeto.tcc.dominio.eventos.musica.PlayListAdicionadaEvento;
import projeto.tcc.infraestrutura.Conexao;
import projeto.tcc.infraestrutura.Subscriber;

import com.mysql.jdbc.PreparedStatement;

public class PlayListAdicionadaManipulador implements Subscriber<Evento>{

	
	public PlayListAdicionadaManipulador() {
		// TODO Auto-generated constructor stub
	}
	
	public PlayListAdicionadaManipulador(PlayListAdicionadaEvento evento) {
		trata(evento);
	}
	
	public void trata(PlayListAdicionadaEvento evento) {
		insereViews(evento);
	
	}

	private void insereViews(PlayListAdicionadaEvento playListAdicionadaEvento) {
		Connection conexao = Conexao.getConectionReader();
		try {
			PreparedStatement pstmt1 = null;
			pstmt1 = (PreparedStatement) conexao.prepareStatement("insert into " +
					"playlistsusuario(aggregateIDUsuario,aggregateIDPlayList,nome) " +
					"values(?,?,?)", 
					PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt1.setString(1, playListAdicionadaEvento.getAggregateId().toString());
			pstmt1.setString(2, playListAdicionadaEvento.getPlayListId().toString());
			pstmt1.setString(3, playListAdicionadaEvento.getNomePlayList());
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
	public void getPublication(Evento arg) {
		if (arg instanceof PlayListAdicionadaEvento) {
			insereViews((PlayListAdicionadaEvento) arg);
		}
		
	}


}
