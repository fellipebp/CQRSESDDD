package projeto.tcc.aplicacao.impl;

import java.util.Set;

import projeto.tcc.aplicacao.ServicoPlayListEscrita;
import projeto.tcc.dominio.entidades.musica.Musica;
import projeto.tcc.dominio.entidades.musica.PlayList;
import projeto.tcc.interfaceusuario.comandos.AdicionarMusicaComando;
import projeto.tcc.interfaceusuario.comandos.CriarPlayListComando;
import projeto.tcc.interfaceusuario.comandos.TocarMusicaComando;

public class ServicoPlayListEscritaImpl implements ServicoPlayListEscrita{

	private PlayList playList;
	
	@Override
	public void adicionarMusica(AdicionarMusicaComando adicionarMusicaComando, Set<Musica> minhasMusicas, Musica musica) {
		playList = new PlayList();
		try {
			playList.adicionarMusica(adicionarMusicaComando, minhasMusicas, musica);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}
	
	@Override
	public void tocarMusica(TocarMusicaComando tocarMusicaComando) {
		playList = new PlayList();
		try {
			playList.tocarMusica(tocarMusicaComando);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}

	@Override
	public void criarPlayList(CriarPlayListComando criarPlayListComando) {
		playList = new PlayList();
		try {
			playList.criarPlayList(criarPlayListComando);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}

	
}
