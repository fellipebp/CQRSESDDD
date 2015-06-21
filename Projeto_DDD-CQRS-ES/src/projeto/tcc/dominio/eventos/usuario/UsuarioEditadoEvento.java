package projeto.tcc.dominio.eventos.usuario;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import projeto.tcc.dominio.entidades.usuario.Usuario;
import projeto.tcc.dominio.eventos.Evento;

public class UsuarioEditadoEvento implements Evento, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UUID aggregateId;
	private String senha;
	private String CPF;
	private String nome;
	private String email;
	private Date dtAlteracao;
	
	
	public UsuarioEditadoEvento(UUID aggregateID, Usuario usuario) {
		this.aggregateId = aggregateID;
		this.dtAlteracao = new Date();
		this.senha = usuario.getSenha();
		this.CPF = usuario.getCPF();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
				
	}

	@Override
	public UUID getAggregateId() {
		return aggregateId;
	}
	
	

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
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

	public Date getDtAlteracao() {
		return dtAlteracao;
	}

	public void setDtAlteracao(Date dtAlteracao) {
		this.dtAlteracao = dtAlteracao;
	}

	public void setAggregateId(UUID aggregateId) {
		this.aggregateId = aggregateId;
	}

}
