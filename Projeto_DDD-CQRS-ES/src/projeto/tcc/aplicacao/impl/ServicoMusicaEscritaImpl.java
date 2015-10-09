package projeto.tcc.aplicacao.impl;

import projeto.tcc.aplicacao.ServicoMusicaEscrita;
import projeto.tcc.aplicacao.comandos.processador.ProcessadorAdicionarMusicaFavoritoComando;
import projeto.tcc.interfaceusuario.comandos.AdicionarMusicaFavoritosComando;

public class ServicoMusicaEscritaImpl implements ServicoMusicaEscrita{

	@Override
	public void adicionarMusicaFavoritos(
			AdicionarMusicaFavoritosComando adicionarMusicaFavoritosComando) {
		try{
			new ProcessadorAdicionarMusicaFavoritoComando().execute(adicionarMusicaFavoritosComando);
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}

}
