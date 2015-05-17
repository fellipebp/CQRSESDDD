package projeto.tcc.infraestrutura;

import projeto.tcc.dominio.eventos.Evento;

public interface ManipuladorEventos {
	
	
	void trata(Evento evento);

}
