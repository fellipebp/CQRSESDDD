package projeto.tcc.dominio.eventos.musica;


import java.io.Serializable;
import java.util.UUID;

import projeto.tcc.dominio.entidades.musica.Musica;
import projeto.tcc.dominio.eventos.Evento;

public class MusicaTocadaEvento implements Evento, Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6204840125591633059L;
	private UUID aggregateId;
	private String nomeMusica;
	private Long version;
	private Long groupVersion;

	
	public MusicaTocadaEvento(UUID aggregateId, String nomeMusica, Long version, Long groupVersion) {
		this.aggregateId = aggregateId;
		this.nomeMusica = nomeMusica;
		this.version = version;
		this.groupVersion =groupVersion;
	}



	public UUID getAggregateId() {
		return aggregateId;
	}



	public void setAggregateId(UUID aggregateId) {
		this.aggregateId = aggregateId;
	}



	public String getNomeMusica() {
		return nomeMusica;
	}



	public void setNomeMusica(String nomeMusica) {
		this.nomeMusica = nomeMusica;
	}



	@Override
	public Long getVersion() {
		return this.version;
	}



	@Override
	public Class<?> getClazz() {
		return Musica.class;
	}



	@Override
	public Long getGroupVersion() {
		return this.groupVersion;
	}



}
