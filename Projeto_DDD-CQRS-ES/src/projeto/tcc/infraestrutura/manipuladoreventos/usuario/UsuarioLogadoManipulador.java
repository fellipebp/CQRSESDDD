package projeto.tcc.infraestrutura.manipuladoreventos.usuario;

import projeto.tcc.dominio.eventos.Evento;
import projeto.tcc.dominio.eventos.usuario.UsuarioLogadoEvento;

public class UsuarioLogadoManipulador {

	private Evento evento;
	
	
	public UsuarioLogadoManipulador(UsuarioLogadoEvento evento) {
		trata(evento);
	}
	
	public void trata(UsuarioLogadoEvento evento) {
		System.out.println("oi");
	
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}
