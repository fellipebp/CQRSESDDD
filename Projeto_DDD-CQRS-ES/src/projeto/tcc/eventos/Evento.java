package projeto.tcc.eventos;

import java.io.Serializable;

public abstract class Evento implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public abstract void Processar();
	
}
