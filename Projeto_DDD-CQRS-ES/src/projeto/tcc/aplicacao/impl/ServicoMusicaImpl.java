package projeto.tcc.aplicacao.impl;

import java.io.Serializable;
import java.util.List;

import projeto.tcc.aplicacao.ServicoMusica;
import projeto.tcc.dominio.Musica;
import projeto.tcc.infraestrutura.armazenamento.impl.RepositorioMusicaImpl;

public class ServicoMusicaImpl implements ServicoMusica, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5992327488947705463L;
	//@Inject
	//private RepositorioMusica repositorioMusica
	private RepositorioMusicaImpl repositorioMusica = new RepositorioMusicaImpl();

	@Override
	public List<Musica> listarTodasMusicas() {
		return repositorioMusica.listarTodasMusicas();
	}

	public Musica carregaMusicaPorNome(String nome) {
		return repositorioMusica.recuperaMusicaPeloNome(nome);
	}

}
