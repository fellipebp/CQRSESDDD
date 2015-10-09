package projeto.tcc.interfaceusuario.comandos;

import java.util.UUID;

import projeto.tcc.dominio.entidades.musica.Musica;


public class AdicionarMusicaFavoritosComando implements Comando {
	
	private UUID aggregateID;
	private Musica musica;
	private Long version;
	
	public AdicionarMusicaFavoritosComando(UUID aggregateID, Musica musica) {
		this.aggregateID = aggregateID;
		this.musica = musica;
		this.version = 0l;
	}
	

	@Override
	public UUID aggregateId() {
		return aggregateID;
	}

	public void setPlaylistID(UUID playListUID) {
		this.aggregateID = playListUID;
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