package projeto.tcc.aplicacao.impl;

import projeto.tcc.aplicacao.ServicoPlayListEscrita;
import projeto.tcc.aplicacao.comandos.processador.ProcessadorAdicionarMusicaComando;
import projeto.tcc.aplicacao.comandos.processador.ProcessadorCriarPlayListComando;
import projeto.tcc.aplicacao.comandos.processador.ProcessadorTocarMusicaComando;
import projeto.tcc.interfaceusuario.comandos.AdicionarMusicaComando;
import projeto.tcc.interfaceusuario.comandos.CriarPlayListComando;
import projeto.tcc.interfaceusuario.comandos.TocarMusicaComando;

public class ServicoPlayListEscritaImpl implements ServicoPlayListEscrita{

	
	@Override
	public void adicionarMusica(AdicionarMusicaComando adicionarMusicaComando) {
		try {
			new ProcessadorAdicionarMusicaComando().execute(adicionarMusicaComando);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}
	
	@Override
	public void tocarMusica(TocarMusicaComando tocarMusicaComando) {
		try {
			new ProcessadorTocarMusicaComando().execute(tocarMusicaComando);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}

	@Override
	public void criarPlayList(CriarPlayListComando criarPlayListComando) {
		try {
			new ProcessadorCriarPlayListComando().execute(criarPlayListComando);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}

	
}