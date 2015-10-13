package projeto.tcc.dominio.eventos;

import java.util.List;

import projeto.tcc.infraestrutura.armazenamento.ArmazenadorEventos;

public class EventoProcessador  {
	
	
	public void processarEvento(Evento e) throws Exception{
		ArmazenadorEventos.salvarEvento(e);
	}
	
	public void processarEventos(List<Evento> evs) throws Exception{
		ArmazenadorEventos.salvarEventos(evs);
	}

}
