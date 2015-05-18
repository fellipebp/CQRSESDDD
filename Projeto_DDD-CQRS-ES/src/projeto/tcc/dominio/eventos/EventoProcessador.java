package projeto.tcc.dominio.eventos;


import projeto.tcc.infraestrutura.ArmazenadorEventos;

public class EventoProcessador  {
	
	
	public void processar(Evento e) throws Exception{
		ArmazenadorEventos.salvarEvento(e);
	}

}
