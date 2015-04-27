package projeto.tcc.interfaceusuario;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projeto.tcc.aplicacao.ServicoUsuario;
import projeto.tcc.comandos.FazerLoginComando;

@Named
@ApplicationScoped
public class LoginUsuarioBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7918764410608856865L;
	@Inject
	private ServicoUsuario servicoUsuario;
//	private ServicoUsuarioImplFacade servicoUsuarioImplFacade = new ServicoUsuarioImplFacade();
	private String login;
	private String senha;
	
	public String logar(){
		servicoUsuario.logarUsuario(new FazerLoginComando(login,senha)); 
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
