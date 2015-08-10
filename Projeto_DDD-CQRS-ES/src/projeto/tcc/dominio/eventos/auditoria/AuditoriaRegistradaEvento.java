package projeto.tcc.dominio.eventos.auditoria;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import projeto.tcc.dominio.eventos.Evento;

public class AuditoriaRegistradaEvento implements Evento {
	
	private UUID aggregateID;
	private Date dtLogin;
	private Date dtLoggof;
	private List<String> eventos;
	private Integer version;
	
	
	public AuditoriaRegistradaEvento(UUID aggregateID, Date dtLogin, Date dtLoggof, List<String> eventos, Integer version) {
		this.aggregateID = aggregateID;
		this.dtLogin = dtLogin;
		this.dtLoggof = dtLoggof;
		this.eventos = eventos;
		this.version = version;
	}
	
	public UUID getAggregateID() {
		return aggregateID;
	}
	public void setAggregateID(UUID aggregateID) {
		this.aggregateID = aggregateID;
	}
	public Date getDtLogin() {
		return dtLogin;
	}
	public void setDtLogin(Date dtLogin) {
		this.dtLogin = dtLogin;
	}
	public Date getDtLoggof() {
		return dtLoggof;
	}
	public void setDtLoggof(Date dtLoggof) {
		this.dtLoggof = dtLoggof;
	}

	public List<String> getEventos() {
		return eventos;
	}

	public void setEventos(List<String> eventos) {
		this.eventos = eventos;
	}

	@Override
	public UUID getAggregateId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getVersion() {
		return null;
	}

	
	
}
