package projeto.tcc.eventos.musica;

import java.io.Serializable;

import projeto.tcc.dominio.Musica;
import projeto.tcc.eventos.Evento;

public class MusicaTocadaEvento extends Evento implements Serializable {
	
	private Musica musica;
	//mais algum atributo?

	private static final long serialVersionUID = 1L;

	@Override
	public void Processar() {
		getMusica().tocar(this);
	}

	public Musica getMusica() {
		return musica;
	}

	public void setMusica(Musica musica) {
		this.musica = musica;
	}

}
