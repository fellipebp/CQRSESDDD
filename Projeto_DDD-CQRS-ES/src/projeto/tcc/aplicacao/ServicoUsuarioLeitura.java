package projeto.tcc.aplicacao;

import projeto.tcc.dominio.Usuario;


public interface ServicoUsuarioLeitura {

	Usuario getUsuarioPorAggregateID(String aggregateID);

}
