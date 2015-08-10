package projeto.tcc.dominio.eventos.usuario;

import java.io.Serializable;
import java.util.UUID;

import projeto.tcc.dominio.entidades.usuario.Usuario;
import projeto.tcc.dominio.eventos.Evento;


public class UsuarioCadastradoEvento implements  Evento, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UUID aggregateId;
	private String login;
	private String senha;
	private String CPF;
	private String nome;
	private String email;
	private Integer version;
	
	public UsuarioCadastradoEvento(UUID aggregateId,Integer version, Usuario usuario) {
		this.aggregateId = aggregateId;
		this.login = usuario.getLogin();
		this.senha = usuario.getSenha();
		this.CPF = usuario.getCPF();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.version = version;
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






	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public UUID getAggregateId() {
		return aggregateId;
	}

	public void setAggregateId(UUID aggregateId) {
		this.aggregateId = aggregateId;
	}



	public String getCPF() {
		return CPF;
	}



	public void setCPF(String cPF) {
		CPF = cPF;
	}



	@Override
	public Integer getVersion() {
		return this.version;
	}




//	public void Processar() {
//		usuario.cuidarCadastro(this);
//		
//	}






	

}
