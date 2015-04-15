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
	private String nome;
	private String CPF;
	
	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}
	
	public Usuario() {
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
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
