package projeto.tcc.dominio.eventos.usuario;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import projeto.tcc.dominio.Usuario;
import projeto.tcc.dominio.eventos.Evento;

public class UsuarioLogadoEvento implements Evento, Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7012748516611245990L;
	private UUID aggregateId;
	private Usuario usuario;
	private Date dtLogin;
	
	public UsuarioLogadoEvento() {
	}
	
	public UsuarioLogadoEvento(UUID aggregateId, Usuario usuario, Date dtLogin){
		this.aggregateId = aggregateId;
		this.usuario = usuario;
		this.dtLogin = dtLogin;
	}

//	@Override
//	public void Processar() {
//		usuario.logar(this);
//		
//	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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


	

}
