package projeto.tcc.interfaceusuario.dto;

import java.io.Serializable;

public class FazerLoginDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7676555359721621926L;
	private String login;
	private String senha;
	
	public FazerLoginDTO() {
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
