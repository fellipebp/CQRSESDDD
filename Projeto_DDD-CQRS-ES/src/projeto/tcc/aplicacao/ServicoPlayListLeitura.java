package projeto.tcc.aplicacao;

import java.util.List;

import projeto.tcc.dominio.entidades.musica.PlayList;


public interface ServicoPlayListLeitura {

	
	List<PlayList> buscarPlayLists(String aggregateID);
	List<PlayList> buscarPlayListsPorEventos(String aggregateID);
}
