package projeto.tcc.infraestrutura.armazenamento.repositorio;

import java.util.List;

import projeto.tcc.dominio.entidades.musica.PlayList;
import projeto.tcc.dominio.eventos.Evento;

public interface RepositorioPlaylist {
	
	 PlayList getPlaylistPorAggregateID(String aggregateID);
	
	 PlayList constroiEntidade(List<Evento> history) ;

}