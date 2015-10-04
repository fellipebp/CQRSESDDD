package projeto.tcc.interfaceusuario.comandos;

import java.util.UUID;

import projeto.tcc.dominio.entidades.musica.Musica;


public class AdicionarMusicaComando implements Comando {
	
	private UUID playListUID;
	private Musica musica;
	private Long version;
	
	public AdicionarMusicaComando(UUID playListUID, Musica musica) {
		this.playListUID = playListUID;
		this.musica = musica;
		this.version = 0l;
	}
	

	@Override
	public UUID aggregateId() {
		return playListUID;
	}

	public void setPlaylistID(UUID playListUID) {
		this.playListUID = playListUID;
	}




	@Override
	public Long getVersion() {
		// TODO Auto-generated method stub
		return version;
	}


	public Musica getMusica() {
		return musica;
	}


	public void setMusica(Musica musica) {
		this.musica = musica;
	}




}