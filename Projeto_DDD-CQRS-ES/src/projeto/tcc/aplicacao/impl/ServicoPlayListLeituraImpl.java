package projeto.tcc.aplicacao.impl;

import java.util.List;

import projeto.tcc.aplicacao.ServicoPlayListLeitura;
import projeto.tcc.dominio.entidades.musica.PlayList;
import projeto.tcc.infraestrutura.armazenamento.repositorio.impl.RepositorioUsuarioImpl;

public class ServicoPlayListLeituraImpl implements ServicoPlayListLeitura{


	@Override
	public List<PlayList> buscarPlayLists(String aggregateID) {
		return new RepositorioUsuarioImpl().getListaPlayList(aggregateID);
	}
	
	@Override
	public List<PlayList> buscarPlayListsPorEventos(String aggregateID) {
		return new RepositorioUsuarioImpl().getPlayListsPorEventos(aggregateID);
	}

//	@Override
//	public PlayList buscarPlayList(String aggregateID) {
//		return new RepositorioUsuarioImpl().getPlayList(aggregateID);
//	}
	



	
}