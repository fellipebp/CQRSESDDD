package projeto.tcc.dominio.eventos;


import projeto.tcc.infraestrutura.Armazenador;

public class EventoProcessador  {
	
	
	public void processar(Evento e) throws Exception{
		Armazenador.salvarEvento(e);
	}

}
