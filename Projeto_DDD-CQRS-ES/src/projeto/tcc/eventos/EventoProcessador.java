package projeto.tcc.eventos;


import projeto.tcc.infraestrutura.Conexao;

public class EventoProcessador  {
	
	private Conexao conexao = new Conexao();
	
	public void processar(Evento e) throws Exception{
		e.Processar();
//		log.add(e); // AQUI VC SALVA NO BANCO AO INVES DE ADICIONAR NA LISTA
		conexao.getConection();
		conexao.writeJavaObject(e);
	}

}
