package projeto.tcc.interfaceusuario.servico.impl;

import java.io.Serializable;
import java.util.List;

import projeto.tcc.aplicacao.ServicoMusicaLeitura;
import projeto.tcc.aplicacao.impl.ServicoMusicaLeituraImpl;
import projeto.tcc.dominio.entidades.musica.Musica;
import projeto.tcc.interfaceusuario.servico.ServicoMusicaFacade;

public class ServicoMusicaFacadeImpl implements ServicoMusicaFacade, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4264297695373742679L;
	private ServicoMusicaLeituraImpl servicoMusica = new ServicoMusicaLeituraImpl();
	@Override
	public List<Musica> listarTodasMusicas() {
		return servicoMusica.listarTodasMusicas();
	}
	@Override
	public Musica carregaMusicaPorNome(String nome) {
		return servicoMusica.carregaMusicaPorNome(nome);
	}


}
