package projeto.tcc.eventos;

import java.util.ArrayList;
import java.util.List;

public class EventoProcessador {
	
	List<UsuarioCadastrado> log = new ArrayList<UsuarioCadastrado>();
	
	public void processar(UsuarioCadastrado e){
		e.Processar();
		log.add(e);
	}

}
