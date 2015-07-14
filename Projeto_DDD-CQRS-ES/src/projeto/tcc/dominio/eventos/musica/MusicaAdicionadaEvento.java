package projeto.tcc.dominio.eventos.musica;

import java.io.Serializable;
import java.util.UUID;

import projeto.tcc.dominio.eventos.Evento;

public class MusicaAdicionadaEvento implements Evento, Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7929264690665248399L;
	private String nomeMusica;
	private UUID aggregateId;
	private Integer version;
	
	public MusicaAdicionadaEvento(UUID aggregateId, String nomeMusica, Integer version) {
		this.aggregateId = aggregateId;
		this.nomeMusica = nomeMusica;
		this.version = version;
	}
	

	public String getNomeMusica() {
		return nomeMusica;
	}

	public void setNomeMusica(String nomeMusica) {
		this.nomeMusica = nomeMusica;
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
