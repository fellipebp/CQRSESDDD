package projeto.tcc.infraestrutura.manipuladoreventos;

import projeto.tcc.dominio.eventos.Evento;

public interface ManipuladorEventos {
	
	
	void trata(Evento evento);

}
