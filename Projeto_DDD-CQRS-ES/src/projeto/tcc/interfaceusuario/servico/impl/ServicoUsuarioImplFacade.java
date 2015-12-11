package projeto.tcc.interfaceusuario.servico.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


import projeto.tcc.aplicacao.ServicoUsuarioLeitura;
import projeto.tcc.aplicacao.impl.ServicoUsuarioLeituraImpl;
import projeto.tcc.dominio.entidades.usuario.Usuario;
import projeto.tcc.interfaceusuario.servico.ServicoUsuarioFacade;

//@ApplicationScoped
public class ServicoUsuarioImplFacade  implements ServicoUsuarioFacade, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6927806326900858283L;
	private ServicoUsuarioLeituraImpl servicoUsuario = new ServicoUsuarioLeituraImpl();

	@Override
	public void logar(String login, String senha) {
//		servicoUsuario.logar(new Usuario(1,login, senha));
	}
}
