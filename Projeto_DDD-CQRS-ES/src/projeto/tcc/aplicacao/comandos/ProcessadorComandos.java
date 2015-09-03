package projeto.tcc.aplicacao.comandos;

import projeto.tcc.interfaceusuario.comandos.Comando;

public interface ProcessadorComandos {
	
	void execute(Comando comando) throws Exception;

}
