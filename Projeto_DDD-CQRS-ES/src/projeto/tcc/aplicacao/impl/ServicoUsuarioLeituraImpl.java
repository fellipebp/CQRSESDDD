package projeto.tcc.aplicacao.impl;

import java.io.Serializable;
import java.util.UUID;

import projeto.tcc.aplicacao.ServicoUsuarioLeitura;
import projeto.tcc.dominio.entidades.usuario.Usuario;
import projeto.tcc.infraestrutura.armazenamento.repositorio.impl.RepositorioUsuarioImpl;

public class ServicoUsuarioLeituraImpl implements ServicoUsuarioLeitura, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8902163096950935775L;

	@Override
	public Usuario getUsuarioPorAggregateID(String aggregateID) {
		return new RepositorioUsuarioImpl().getUsuarioPorAggregateID(aggregateID);
	}

	@Override
	public int getNivelAcessoUsuario(String aggregateID) {
		return new RepositorioUsuarioImpl().getNivelAcessoUsuario(aggregateID);
	}


}
