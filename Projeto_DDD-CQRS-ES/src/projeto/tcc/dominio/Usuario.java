package projeto.tcc.dominio;

import projeto.tcc.eventos.UsuarioCadastrado;


public class Usuario {
	
	private String login;
	private String senha;
	
	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}
	
	public Usuario() {
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
	public void cuidarCadastro(UsuarioCadastrado uc) {
		this.login = uc.getUsuario().getLogin();
		this.senha = uc.getUsuario().getSenha();
		System.out.println(login+" ,"+senha);
	}
	
		

}
