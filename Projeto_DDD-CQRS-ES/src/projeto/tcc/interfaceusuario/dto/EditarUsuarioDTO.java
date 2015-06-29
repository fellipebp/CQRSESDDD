package projeto.tcc.interfaceusuario.dto;

import java.io.Serializable;

public class EditarUsuarioDTO implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6142650016392378500L;
	private String nome;
	private String cpf;
	private String senha;
	private String email;
	private Integer version;
	
	public EditarUsuarioDTO() {
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

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
