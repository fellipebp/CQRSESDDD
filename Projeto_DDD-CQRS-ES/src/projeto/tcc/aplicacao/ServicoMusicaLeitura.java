package projeto.tcc.aplicacao;

import java.util.List;
import java.util.Set;

import projeto.tcc.dominio.entidades.musica.Musica;

public interface ServicoMusicaLeitura {
	
	List<Musica> listarTodasMusicas();
	
	Set<Musica> listarMinhasMusicas(String aggregateID);
	Set<Musica> listarMinhasMusicasFavorito(String aggregateID);
}
