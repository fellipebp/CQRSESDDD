package projeto.tcc.interfaceusuario.comandos;

import java.util.UUID;


public class TocarMusicaComando implements Comando {
	
	private UUID usuarioUID;
	private String nomeMusica;
	private int idMusica;
	
	public TocarMusicaComando(UUID usuarioUID, String nomeMusica, int idMusica) {
		this.usuarioUID = usuarioUID;
		this.nomeMusica = nomeMusica;
		this.idMusica = idMusica;
	}
	

	@Override
	public UUID aggregateId() {
		return usuarioUID;
	}

	
	public UUID getLoginID() {
		return usuarioUID;
	}


	public void setLoginID(UUID usuarioUID) {
		this.usuarioUID = usuarioUID;
	}


	public String getNomeMusica() {
		return nomeMusica;
	}


	public void setNomeMusica(String nomeMusica) {
		this.nomeMusica = nomeMusica;
	}


	@Override
	public Long getVersion() {
		// TODO Auto-generated method stub
		return 0l;
	}


	public int getIdMusica() {
		return idMusica;
	}


	public void setIdMusica(int idMusica) {
		this.idMusica = idMusica;
	}



}