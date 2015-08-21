package projeto.tcc.interfaceusuario.comandos;

import java.util.UUID;


public class AdicionarMusicaComando implements Comando {
	
	private UUID playListUID;
	private String nomeMusica;
	
	public AdicionarMusicaComando(UUID playListUID, String nomeMusica) {
		this.playListUID = playListUID;
		this.nomeMusica = nomeMusica;
	}
	

	@Override
	public UUID aggregateId() {
		return playListUID;
	}

	public void setPlaylistID(UUID playListUID) {
		this.playListUID = playListUID;
	}


	public String getNomeMusica() {
		return nomeMusica;
	}


	public void setNomeMusica(String nomeMusica) {
		this.nomeMusica = nomeMusica;
	}


	@Override
	public Integer getVersion() {
		// TODO Auto-generated method stub
		return null;
	}





}
