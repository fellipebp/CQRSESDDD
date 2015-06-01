package projeto.tcc.dominio.eventos.usuario;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import projeto.tcc.dominio.Usuario;
import projeto.tcc.dominio.eventos.Evento;

public class UsuarioEditadoEvento implements Evento, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UUID aggregateId;
	private Usuario usuario;
	private Date dtAlteracao;
	
	public UsuarioEditadoEvento(UUID aggregateID, Usuario usuario) {
		this.usuario = usuario;
		this.aggregateId = aggregateID;
		this.dtAlteracao = new Date();
				
	}

	@Override
	public UUID getAggregateId() {
		return aggregateId;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
