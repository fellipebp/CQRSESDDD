package projeto.tcc.eventos;


import projeto.tcc.infraestrutura.Conexao;

public class EventoProcessador  {
	
	private Conexao conexao = new Conexao();
	
	public void processar(Evento e) throws Exception{
		conexao.salvarEvento(e);
	}

}
