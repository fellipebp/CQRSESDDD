package projeto.tcc.interfaceusuario.servico.impl;

import java.io.Serializable;
import java.util.List;

import projeto.tcc.aplicacao.ServicoMusica;
import projeto.tcc.aplicacao.impl.ServicoMusicaImpl;
import projeto.tcc.dominio.Musica;
import projeto.tcc.interfaceusuario.servico.ServicoMusicaFacade;

public class ServicoMusicaFacadeImpl implements ServicoMusicaFacade, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4264297695373742679L;
	//@Inject
	//private ServicoMusica servicoMusica;
	private ServicoMusicaImpl servicoMusica = new ServicoMusicaImpl();
	@Override
	public List<Musica> listarTodasMusicas() {
		return servicoMusica.listarTodasMusicas();
	}
	@Override
	public Musica carregaMusicaPorNome(String nome) {
		return servicoMusica.carregaMusicaPorNome(nome);
	}


}
