package projeto.tcc.aplicacao;

import java.util.List;

import projeto.tcc.dominio.entidades.musica.PlayList;


public interface ServicoPlayListLeitura {

	
	List<PlayList> buscarAgregadoPlayList(String aggregateID);
}
