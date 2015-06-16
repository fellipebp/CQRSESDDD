package projeto.tcc.infraestrutura.armazenamento.repositorio;

import java.util.List;

import projeto.tcc.dominio.entidades.musica.Musica;

public interface RepositorioMusica {
	
	 List<Musica> listarTodasMusicas();

	 Musica recuperaMusicaPeloNome(String nome);
}
