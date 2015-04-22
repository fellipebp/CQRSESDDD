package projeto.tcc.infraestrutura.armazenamento;

import java.util.List;

import projeto.tcc.eventos.Evento;

public interface RepositorioEvento {
	
	
	void armazenar(Evento evento);
	
	void armazenar(List<Evento> eventos);
}
