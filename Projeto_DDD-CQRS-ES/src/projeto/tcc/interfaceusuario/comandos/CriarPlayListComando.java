package projeto.tcc.interfaceusuario.comandos;

import java.util.UUID;


public class CriarPlayListComando implements Comando {

	
	private UUID playListUID;
	private UUID aggregateID;
	private String nome;
	
	public CriarPlayListComando(UUID aggregateID, UUID playListUID , String nome) {
		this.aggregateID = aggregateID;
		this.playListUID = playListUID;
		this.nome = nome;
	}
	
	
	@Override
	public UUID aggregateId() {
		return aggregateID;
	}


	@Override
	public Long getVersion() {
		// TODO Auto-generated method stub
		return null;
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



}
