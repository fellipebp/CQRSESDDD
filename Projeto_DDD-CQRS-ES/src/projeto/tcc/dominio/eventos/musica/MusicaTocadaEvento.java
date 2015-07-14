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
	private Integer version;

	
	public MusicaTocadaEvento(UUID aggregateId, String nomeMusica, Integer version) {
		this.aggregateId = aggregateId;
		this.nomeMusica = nomeMusica;
		this.version = version;
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
	public Integer getVersion() {
		return this.version;
	}



}
