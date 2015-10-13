package projeto.tcc.aplicacao.comandos;

import projeto.tcc.infraestrutura.armazenamento.ArmazenadorEventos;
import projeto.tcc.interfaceusuario.comandos.Comando;

public class PosProcessadorComandos {

	public static synchronized void validaVersaoComando(Comando comando) 
			throws VersaoComandoInvalidaException {
		
		String aggregateID = comando.aggregateId().toString();
		Long ultimaVersaoAgregado = ArmazenadorEventos.getUltimaVersaoAgregado(aggregateID);
		if (!comando.getVersion().equals(ultimaVersaoAgregado)){
			throw new VersaoComandoInvalidaException();
		}
	}

}
