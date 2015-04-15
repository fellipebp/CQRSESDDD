package projeto.tcc.dominio;

import java.io.Serializable;

import projeto.tcc.eventos.UsuarioCadastradoEvento;


public class Usuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String login;
	private String senha;
	
	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}
	
	public Usuario() {
		// TODO Auto-generated constructor stub
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
	public void cuidarCadastro(UsuarioCadastradoEvento uc) {
		this.login = uc.getUsuario().getLogin();
		this.senha = uc.getUsuario().getSenha();
		System.out.println(login+" ,"+senha);
	}
	
		

}
