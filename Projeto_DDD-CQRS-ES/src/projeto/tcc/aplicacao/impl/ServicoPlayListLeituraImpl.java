package projeto.tcc.aplicacao.impl;

import projeto.tcc.aplicacao.ServicoPlayListLeitura;
import projeto.tcc.infraestrutura.armazenamento.repositorio.impl.RepositorioUsuarioImpl;

public class ServicoPlayListLeituraImpl implements ServicoPlayListLeitura{


	// Ainda sendo construido
	@Override
	public String buscarAgregadoPlayList(String aggregateID) {
		 new RepositorioUsuarioImpl().getAggregatePlayList(aggregateID);
		
		return null;
		
	}
	



	
}
