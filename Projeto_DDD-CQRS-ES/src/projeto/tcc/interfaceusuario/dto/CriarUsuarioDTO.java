package projeto.tcc.interfaceusuario.dto;

import java.io.Serializable;

public class CriarUsuarioDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7230063928513707051L;
	private String nome;
	private String cpf;
	private String login;
	private String senha;
	private String email;
	
	public CriarUsuarioDTO() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
