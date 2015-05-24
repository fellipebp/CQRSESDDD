package projeto.tcc.infraestrutura;

import java.sql.Connection;

import projeto.tcc.dominio.eventos.Evento;
import projeto.tcc.dominio.eventos.usuario.UsuarioCadastradoEvento;

import com.mysql.jdbc.PreparedStatement;

public class UsuarioLogadoManipulador {

	private Evento evento;
	
	
	public UsuarioLogadoManipulador(Evento evento) {
		this.setEvento(evento);
	}
	
	public void trata(UsuarioCadastradoEvento evento) {
		System.out.println("oi");
	
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}
