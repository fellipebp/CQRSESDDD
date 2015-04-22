package projeto.tcc.infraestrutura.armazenamento;

import java.util.List;

import projeto.tcc.dominio.Musica;

public interface RepositorioMusica {
	
	 List<Musica> listarTodasMusicas();

}
