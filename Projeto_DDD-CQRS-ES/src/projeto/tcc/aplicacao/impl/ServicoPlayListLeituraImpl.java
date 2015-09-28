package projeto.tcc.aplicacao.impl;

import java.util.List;

import projeto.tcc.aplicacao.ServicoPlayListLeitura;
import projeto.tcc.dominio.entidades.musica.PlayList;
import projeto.tcc.infraestrutura.armazenamento.repositorio.impl.RepositorioUsuarioImpl;

public class ServicoPlayListLeituraImpl implements ServicoPlayListLeitura{


	@Override
	public List<PlayList> buscarAgregadoPlayList(String aggregateID) {
		return new RepositorioUsuarioImpl().getAggregatePlayList(aggregateID);
	}

//	@Override
//	public PlayList buscarPlayList(String aggregateID) {
//		return new RepositorioUsuarioImpl().getPlayList(aggregateID);
//	}
	



	
}
