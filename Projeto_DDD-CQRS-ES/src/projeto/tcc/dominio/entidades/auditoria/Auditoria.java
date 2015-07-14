package projeto.tcc.dominio.entidades.auditoria;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Auditoria {
	
	protected UUID aggregateID;
	protected List<String> acao;
	protected Date dtLogin;
	protected Date dtLogoff;
	
	public Auditoria(UUID aggregateID, List<String> acao, Date dtLogin, Date dtLogoff) {
		this.aggregateID = aggregateID;
		this.acao = acao;
		this.dtLogin =  dtLogin;
		this.dtLogoff = dtLogin;
	}
	
	
	public UUID getAggregateID() {
		return aggregateID;
	}
	public void setAggregateID(UUID aggregateID) {
		this.aggregateID = aggregateID;
	}
	public List<String> getAcao() {
		return acao;
	}
	public void setAcao(List<String> acao) {
		this.acao = acao;
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
	

}
