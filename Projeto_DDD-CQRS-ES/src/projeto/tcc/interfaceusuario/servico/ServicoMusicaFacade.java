package projeto.tcc.interfaceusuario.servico;

import java.util.List;

import projeto.tcc.dominio.entidades.musica.Musica;

public interface ServicoMusicaFacade {
	
	List<Musica> listarTodasMusicas();

	Musica carregaMusicaPorNome(String nome);

}
