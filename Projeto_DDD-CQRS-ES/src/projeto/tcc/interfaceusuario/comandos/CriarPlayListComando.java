package projeto.tcc.interfaceusuario.comandos;

import java.util.List;
import java.util.UUID;

import projeto.tcc.dominio.entidades.musica.PlayList;


public class CriarPlayListComando implements Comando {

	
	private UUID playListUID;
	private UUID aggregateID;
	private String nome;
	private Integer version;
	private List<PlayList>minhasPlayList;
	
	public CriarPlayListComando(UUID aggregateID, UUID playListUID , String nome, List<PlayList> minhasPlayList) {
		this.aggregateID = aggregateID;
		this.playListUID = playListUID;
		this.minhasPlayList = minhasPlayList;
		this.nome = nome;
		this.version = 0;
	}
	
	
	@Override
	public UUID aggregateId() {
		return aggregateID;
	}


	@Override
	public Integer getVersion() {
		// TODO Auto-generated method stub
		return version;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public UUID getPlayListUID() {
		return playListUID;
	}


	public List<PlayList> getMinhasPlayList() {
		return minhasPlayList;
	}


	public void setMinhasPlayList(List<PlayList> minhasPlayList) {
		this.minhasPlayList = minhasPlayList;
	}



}
