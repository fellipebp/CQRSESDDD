package projeto.tcc.infraestrutura;

import projeto.tcc.dominio.eventos.Evento;
import projeto.tcc.dominio.eventos.usuario.UsuarioCadastradoEvento;
import projeto.tcc.dominio.eventos.usuario.UsuarioLogadoEvento;

public class ManipuladorEventos {
	
	
	public void trata(Evento evento){
		
		if(evento instanceof UsuarioCadastradoEvento){
			new UsuarioCadastradoManipulador(evento);
		}
		else if(evento instanceof UsuarioLogadoEvento){
			new UsuarioLogadoManipulador(evento);
		}
		
		
		
	}

}
