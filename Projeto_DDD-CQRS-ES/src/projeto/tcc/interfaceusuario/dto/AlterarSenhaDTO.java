package projeto.tcc.interfaceusuario.dto;

import java.io.Serializable;

public class AlterarSenhaDTO implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8644310680366630304L;
	private String senhaAtual;
	private String senhaNova;
	private Long version;
	
	public AlterarSenhaDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public String getSenhaNova() {
		return senhaNova;
	}
	public void setSenhaNova(String senhaNova) {
		this.senhaNova = senhaNova;
	}
	public String getSenhaAtual() {
		return senhaAtual;
	}
	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}
	
	
	
}
