package projeto.tcc.dominio.entidades.auditoria;

import java.util.Date;
import java.util.List;

public class Auditoria {
	
	protected String aggregateID;
	private List<String> eventos;
	protected Date dtLogin;
	protected Date dtLogoff;
	
	
	public Auditoria() {
	}
	
	public Auditoria(String aggregateID, List<String> eventos, Date dtLogin, Date dtLogoff) {
		this.aggregateID = aggregateID;
		this.eventos = eventos;
		this.dtLogin =  dtLogin;
		this.dtLogoff = dtLogin;
	}
	
	
	public String getAggregateID() {
		return aggregateID;
	}
	public void setAggregateID(String aggregateID) {
		this.aggregateID = aggregateID;
	}
	public Date getDtLogoff() {
		return dtLogoff;
	}
	public void setDtLogoff(Date dtLogoff) {
		this.dtLogoff = dtLogoff;
	}
	public Date getDtLogin() {
		return dtLogin;
	}
	public void setDtLogin(Date dtLogin) {
		this.dtLogin = dtLogin;
	}

	public List<String> getEventos() {
		return eventos;
	}

	public void setEventos(List<String> eventos) {
		this.eventos = eventos;
	}

}
