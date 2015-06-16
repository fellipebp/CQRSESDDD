package projeto.tcc.aplicacao.impl;

import java.io.Serializable;
import java.util.List;

import projeto.tcc.aplicacao.ServicoMusicaLeitura;
import projeto.tcc.dominio.entidades.musica.Musica;
import projeto.tcc.infraestrutura.armazenamento.repositorio.impl.RepositorioMusicaImpl;

public class ServicoMusicaLeituraImpl implements ServicoMusicaLeitura, Serializable {

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
