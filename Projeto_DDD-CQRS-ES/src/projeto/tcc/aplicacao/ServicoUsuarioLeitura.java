package projeto.tcc.aplicacao;

import projeto.tcc.dominio.entidades.usuario.Usuario;


public interface ServicoUsuarioLeitura {

	Usuario getUsuarioPorAggregateID(String aggregateID);

}
