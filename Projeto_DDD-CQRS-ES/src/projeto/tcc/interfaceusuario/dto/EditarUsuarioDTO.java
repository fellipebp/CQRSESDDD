package projeto.tcc.interfaceusuario.dto;

import java.io.Serializable;

public class EditarUsuarioDTO implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6142650016392378500L;
	private String nome;
	private String cpf;
	private String email;
	private Integer cdPerfil;
	
	private Long version;
	
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


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Integer getCdPerfil() {
		return cdPerfil;
	}

	public void setCdPerfil(Integer cdPerfil) {
		this.cdPerfil = cdPerfil;
	}

}
