package projeto.tcc.eventos;

import java.io.Serializable;

public abstract class Evento implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idAgregado;
	private int versao;

	public abstract void Processar();

	public int getIdAgregado() {
		return idAgregado;
	}

	public void setId(int idAgregado) {
		this.idAgregado = idAgregado;
	}

	public int getVersao() {
		return versao;
	}

	public void setVersao(int versao) {
		this.versao = versao;
	}
	
}
