package projeto.tcc.interfaceusuario;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import projeto.tcc.aplicacao.impl.ServicoUsuarioImpl;
import projeto.tcc.interfaceusuario.servico.ServicoUsuarioFacade;
import projeto.tcc.interfaceusuario.servico.impl.ServicoUsuarioImplFacade;

@ManagedBean
@ViewScoped
public class LoginUsuarioBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7918764410608856865L;
	@Inject
	private ServicoUsuarioFacade servicoUsuarioFacade;
	private String login;
	private String senha;
	
	public String logar(){
		servicoUsuarioFacade.logar(getLogin(), getSenha());
		 return "ouvirMusica.xhtml?faces-redirect=true";
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}

}
