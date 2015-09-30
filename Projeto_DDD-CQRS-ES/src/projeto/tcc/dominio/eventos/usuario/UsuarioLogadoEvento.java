package projeto.tcc.dominio.eventos.usuario;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import projeto.tcc.dominio.entidades.usuario.Usuario;
import projeto.tcc.dominio.eventos.Evento;

public class UsuarioLogadoEvento implements  Evento, Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7012748516611245990L;
	private UUID aggregateId;
	private Date dtLogin;
	private Long version;
	
	public UsuarioLogadoEvento() {
	}
	
	public UsuarioLogadoEvento(UUID aggregateId,String login, String senha, Date dtLogin, Long version){
		this.aggregateId = aggregateId;
		this.dtLogin = dtLogin;
		this.version = version;
	}


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

	@Override
	public Long getVersion() {
		return this.version;
	}

	@Override
	public Class<?> getClazz() {
		return Usuario.class;
	}


	

}
