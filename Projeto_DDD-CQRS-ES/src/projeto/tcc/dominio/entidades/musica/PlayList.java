package projeto.tcc.dominio.entidades.musica;

import java.io.Serializable;
import java.util.Set;

import projeto.tcc.dominio.eventos.EventoProcessador;
import projeto.tcc.dominio.eventos.musica.MusicaAdicionadaEvento;
import projeto.tcc.dominio.eventos.musica.MusicaTocadaEvento;
import projeto.tcc.interfaceusuario.comandos.AdicionarMusicaComando;
import projeto.tcc.interfaceusuario.comandos.TocarMusicaComando;

public class PlayList implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4406930874998196493L;
	private String nome;
	private Musica musica;
	
	public PlayList() {
		// TODO Auto-generated constructor stub
	}
	
	public PlayList(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Musica getMusica() {
		return musica;
	}

	public void setMusica(Musica musica) {
		this.musica = musica;
	}
	
	public void adicionarMusica(AdicionarMusicaComando adicionarMusicaComando, Set<Musica> minhasMusicas, Musica musica) throws Exception {
		if(!minhasMusicas.contains(musica))
		new EventoProcessador().processarEvento((new MusicaAdicionadaEvento(adicionarMusicaComando.aggregateId(), adicionarMusicaComando.getNomeMusica(), 0)));
		else
			throw new RuntimeException("Você já possui essa música");
		
	}
	
	public void tocarMusica(TocarMusicaComando tocarMusicaComando) throws Exception {
		new EventoProcessador().processarEvento((new MusicaTocadaEvento(tocarMusicaComando.aggregateId(), tocarMusicaComando.getNomeMusica(),  0)));
		
	}

}
