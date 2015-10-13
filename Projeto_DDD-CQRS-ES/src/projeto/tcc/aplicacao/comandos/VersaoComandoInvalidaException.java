package projeto.tcc.aplicacao.comandos;

public class VersaoComandoInvalidaException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public VersaoComandoInvalidaException() {
		super("Houveram alterações durante o processamento de sua requisição. Recarrega e tente novamente.");
	}

}
