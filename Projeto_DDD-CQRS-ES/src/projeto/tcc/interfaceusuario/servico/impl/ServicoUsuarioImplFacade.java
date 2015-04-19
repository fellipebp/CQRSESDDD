package projeto.tcc.interfaceusuario.servico.impl;

import javax.inject.Inject;

import projeto.tcc.aplicacao.ServicoUsuario;
import projeto.tcc.dominio.Usuario;
import projeto.tcc.interfaceusuario.servico.ServicoUsuarioFacade;

public class ServicoUsuarioImplFacade  implements ServicoUsuarioFacade{
	
	@Inject
	private ServicoUsuario servicoUsuario;

	@Override
	public void logar(String login, String senha) {
		servicoUsuario.logar(new Usuario(login, senha));
	}
}
