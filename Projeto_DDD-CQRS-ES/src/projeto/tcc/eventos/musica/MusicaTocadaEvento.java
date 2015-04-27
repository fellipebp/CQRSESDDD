package projeto.tcc.eventos.musica;


import projeto.tcc.dominio.Musica;
import projeto.tcc.eventos.Evento;

public class MusicaTocadaEvento implements Evento {
	
	private Musica musica;
	//mais algum atributo?


//	@Override
//	public void Processar() {
//		getMusica().tocar(this);
//	}

	public Musica getMusica() {
		return musica;
	}

	public void setMusica(Musica musica) {
		this.musica = musica;
	}

}
