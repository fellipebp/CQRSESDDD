package projeto.tcc.infraestrutura.manipuladoreventos;

import projeto.tcc.dominio.eventos.Evento;
import projeto.tcc.dominio.eventos.usuario.UsuarioCadastradoEvento;
import projeto.tcc.dominio.eventos.usuario.UsuarioEditadoEvento;
import projeto.tcc.dominio.eventos.usuario.UsuarioLogadoEvento;
import projeto.tcc.infraestrutura.manipuladoreventos.usuario.UsuarioCadastradoManipulador;
import projeto.tcc.infraestrutura.manipuladoreventos.usuario.UsuarioEditadoManipulador;
import projeto.tcc.infraestrutura.manipuladoreventos.usuario.UsuarioLogadoManipulador;

public class ManipuladorEventos {
	
	
	public void trata(Evento evento){
		
		if(evento instanceof UsuarioCadastradoEvento){
			new UsuarioCadastradoManipulador((UsuarioCadastradoEvento)evento);
		}
		else if(evento instanceof UsuarioLogadoEvento){
			new UsuarioLogadoManipulador((UsuarioLogadoEvento)evento);
		}
		
		else if(evento instanceof UsuarioEditadoEvento){
			new UsuarioEditadoManipulador((UsuarioEditadoEvento)evento);
		}
		
	}

}