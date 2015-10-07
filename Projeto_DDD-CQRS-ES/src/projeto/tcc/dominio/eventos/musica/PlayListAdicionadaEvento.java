package projeto.tcc.dominio.eventos.musica;

import java.io.Serializable;
import java.util.UUID;

import projeto.tcc.dominio.entidades.musica.PlayList;
import projeto.tcc.dominio.eventos.Evento;

public class PlayListAdicionadaEvento implements Evento, Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7929264690665248399L;
	private String nomePlayList;
	private UUID aggregateId;
	private UUID playListId;
	private Long version;
	private Long groupVersion;
	
	public PlayListAdicionadaEvento(UUID aggregateId, UUID playListId, String nomePlayList, Long version, Long groupVersion) {
		this.aggregateId = aggregateId;
		this.playListId = playListId;
		this.nomePlayList = nomePlayList;
		this.version = version;
		this.groupVersion = groupVersion;
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
	public Long getVersion() {
		return this.version;
	}


	public UUID getPlayListId() {
		return playListId;
	}


	@Override
	public Class<?> getClazz() {
		return PlayList.class;
	}


	@Override
	public Long getGroupVersion() {
		return this.groupVersion;
	}

}
