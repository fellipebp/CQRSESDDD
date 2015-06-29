package projeto.tcc.dominio.eventos.usuario;

import java.util.Date;
import java.util.UUID;

import projeto.tcc.dominio.eventos.Evento;

public class UsuarioDeslogadoEvento implements Evento{
	
	private UUID aggregateID;
	private String login;
	private Date dtDeslogin;
	private Integer version;

	public UsuarioDeslogadoEvento(UUID aggregateID, Date data) {
		this.aggregateID = aggregateID;
		this.dtDeslogin = data;
	}

	@Override
	public UUID getAggregateId() {
		return aggregateID;
	}

	public Date getDtDeslogin() {
		return dtDeslogin;
	}

	public void setDtDeslogin(Date dtDeslogin) {
		this.dtDeslogin = dtDeslogin;
	}


	public void setAggregateID(UUID aggregateID) {
		this.aggregateID = aggregateID;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public Integer getVersion() {
		return this.version;
	}

}
