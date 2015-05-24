package projeto.tcc.infraestrutura.manipuladoreventos;

import projeto.tcc.dominio.eventos.Evento;
import projeto.tcc.dominio.eventos.usuario.UsuarioCadastradoEvento;
import projeto.tcc.dominio.eventos.usuario.UsuarioLogadoEvento;
import projeto.tcc.infraestrutura.UsuarioLogadoManipulador;

public class ManipuladorEventos {
	
	
	public void trata(Evento evento){
		
		if(evento instanceof UsuarioCadastradoEvento){
			new UsuarioCadastradoManipulador((UsuarioCadastradoEvento)evento);
		}
		else if(evento instanceof UsuarioLogadoEvento){
			new UsuarioLogadoManipulador((UsuarioLogadoEvento)evento);
		}
		
		
		
	}

}