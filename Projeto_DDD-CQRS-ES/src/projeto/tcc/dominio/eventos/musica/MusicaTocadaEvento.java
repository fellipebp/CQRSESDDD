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


	
	public MusicaTocadaEvento(UUID aggregateId, String nomeMusica) {
		this.aggregateId = aggregateId;
		this.nomeMusica = nomeMusica;
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



}
