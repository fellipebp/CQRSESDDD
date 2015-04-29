package projeto.tcc.infraestrutura;

import projeto.tcc.eventos.Evento;

public class SincronizadorFontesDados {
	
	public void execute(){
		try {
			Evento evento = new Conexao().recuperaEvento(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
