package projeto.tcc.aplicacao.comandos;

import projeto.tcc.infraestrutura.armazenamento.ArmazenadorEventos;
import projeto.tcc.interfaceusuario.comandos.Comando;

public class PosProcessadorComandos {

	static synchronized void validaVersaoComando(Comando comando) {
		Integer proximaVersaoAgregado = ArmazenadorEventos.getProximaVersaoAgregado(comando.aggregateId().toString());
		if (comando.getVersion() != proximaVersaoAgregado) {
			//TODO CRIAR EXCEÇÃO ESPECÍFICA
			throw new RuntimeException();
		}
	}

}
