package projeto.tcc.interfaceusuario.servico.impl;

import java.io.Serializable;

import javax.inject.Inject;

import projeto.tcc.aplicacao.ServicoUsuario;
import projeto.tcc.aplicacao.impl.ServicoUsuarioImpl;
import projeto.tcc.dominio.Usuario;
import projeto.tcc.interfaceusuario.servico.ServicoUsuarioFacade;


public class ServicoUsuarioImplFacade  implements ServicoUsuarioFacade, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6927806326900858283L;
	//@Inject
	//private ServicoUsuario servicoUsuario;
	private ServicoUsuarioImpl servicoUsuario= new ServicoUsuarioImpl();

	@Override
	public void logar(String login, String senha) {
		servicoUsuario.logar(new Usuario(1,login, senha));
	}
}
