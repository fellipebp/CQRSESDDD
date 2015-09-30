package projeto.tcc.dominio.eventos.musica;

import java.io.Serializable;
import java.util.UUID;

import projeto.tcc.dominio.entidades.musica.Musica;
import projeto.tcc.dominio.eventos.Evento;

public class MusicaAdicionadaEvento implements Evento, Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7929264690665248399L;
	private String nomeMusica;
	private UUID aggregateId;
	private Long version;
	
	public MusicaAdicionadaEvento(UUID aggregateId, String nomeMusica, Long version) {
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
	public Long getVersion() {
		return this.version;
	}


	@Override
	public Class<?> getClazz() {
		return Musica.class;
	}

}
