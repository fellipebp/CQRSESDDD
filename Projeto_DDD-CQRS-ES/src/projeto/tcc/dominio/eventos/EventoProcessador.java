package projeto.tcc.dominio.eventos;


import projeto.tcc.infraestrutura.EventStore;

public class EventoProcessador  {
	
	
	public void processar(Evento e) throws Exception{
		EventStore.salvarEvento(e);
	}

}
