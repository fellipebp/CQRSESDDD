package projeto.tcc.dominio.eventos;


import java.util.UUID;

import projeto.tcc.infraestrutura.armazenamento.ArmazenadorEventos;

public class EventoProcessador  {
	
	public EventoProcessador() {
	}
	
	public void processarEvento(Evento e) throws Exception{
		ArmazenadorEventos.salvarEvento(e);
	}
	
	public void processarAggregado(UUID aggregateID, Class<?> clazz, Integer version) throws Exception{
		ArmazenadorEventos.salvarAggregado(aggregateID, clazz, version);
	}

}
