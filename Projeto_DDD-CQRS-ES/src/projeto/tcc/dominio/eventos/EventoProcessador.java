package projeto.tcc.dominio.eventos;


import projeto.tcc.infraestrutura.Conexao;

public class EventoProcessador  {
	
	
	public void processar(Evento e) throws Exception{
		Conexao.salvarEvento(e);
	}

}
