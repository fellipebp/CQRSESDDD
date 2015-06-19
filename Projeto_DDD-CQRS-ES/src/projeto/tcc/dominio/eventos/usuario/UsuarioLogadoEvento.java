package projeto.tcc.dominio.eventos.usuario;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import projeto.tcc.dominio.entidades.usuario.Usuario;
import projeto.tcc.dominio.eventos.Evento;

public class UsuarioLogadoEvento implements Evento, Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7012748516611245990L;
	private UUID aggregateId;
	private String login;
	private String senha;
	private Date dtLogin;
	
	public UsuarioLogadoEvento() {
	}
	
	public UsuarioLogadoEvento(UUID aggregateId,String login, String senha, Date dtLogin){
		this.aggregateId = aggregateId;
		this.dtLogin = dtLogin;
		this.senha = senha;
	}

//	@Override
//	public void Processar() {
//		usuario.logar(this);
//		
//	}


	public Date getDtLogin() {
		return dtLogin;
	}

	public void setDtLogin(Date dtLogin) {
		this.dtLogin = dtLogin;
	}

	public UUID getAggregateId() {
		return aggregateId;
	}

	public void setAggregateId(UUID aggregateId) {
		this.aggregateId = aggregateId;
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
