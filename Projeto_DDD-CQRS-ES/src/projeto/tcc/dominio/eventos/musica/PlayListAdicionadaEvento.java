package projeto.tcc.dominio.eventos.musica;

import java.io.Serializable;
import java.util.UUID;

import projeto.tcc.dominio.eventos.Evento;

public class PlayListAdicionadaEvento implements Evento, Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7929264690665248399L;
	private String nomePlayList;
	private UUID aggregateId;
	private Integer version;
	
	public PlayListAdicionadaEvento(UUID aggregateId, String nomePlayList, Integer version) {
		this.aggregateId = aggregateId;
		this.nomePlayList = nomePlayList;
		this.version = version;
	}
	

	public String getNomePlayList() {
		return nomePlayList;
	}

	public void setNomePlayList(String nomePlayList) {
		this.nomePlayList = nomePlayList;
	}

	public void setAggregateId(UUID aggregateId) {
		this.aggregateId = aggregateId;
	}


	public UUID getAggregateId() {
		return aggregateId;
	}


	@Override
	public Integer getVersion() {
		return this.version;
	}

}
