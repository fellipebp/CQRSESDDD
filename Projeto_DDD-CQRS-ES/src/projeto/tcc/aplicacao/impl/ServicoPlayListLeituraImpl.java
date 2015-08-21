package projeto.tcc.aplicacao.impl;

import java.util.UUID;

import projeto.tcc.aplicacao.ServicoPlayListLeitura;
import projeto.tcc.infraestrutura.armazenamento.repositorio.impl.RepositorioUsuarioImpl;

public class ServicoPlayListLeituraImpl implements ServicoPlayListLeitura{


	// Ainda sendo construido
	@Override
	public UUID buscarAgregadoPlayList(String aggregateID) {
		return new RepositorioUsuarioImpl().getAggregatePlayList(aggregateID);
	}
	



	
}
