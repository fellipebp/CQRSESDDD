package projeto.tcc.aplicacao.comandos;

import projeto.tcc.infraestrutura.armazenamento.ArmazenadorEventos;
import projeto.tcc.interfaceusuario.comandos.Comando;

public class PosProcessadorComandos {

	public static synchronized void validaVersaoComando(Comando comando) {
		Long ultimaVersaoAgregado = ArmazenadorEventos.getUltimaVersaoAgregado(comando.aggregateId().toString());
		if (!comando.getVersion().equals(ultimaVersaoAgregado)){
			//TODO CRIAR EXCEÇÃO ESPECÍFICA
			throw new RuntimeException();
		}
	}

}
