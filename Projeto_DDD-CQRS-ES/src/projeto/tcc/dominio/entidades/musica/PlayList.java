package projeto.tcc.dominio.entidades.musica;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import projeto.tcc.aplicacao.impl.ServicoPlayListEscritaImpl;
import projeto.tcc.dominio.eventos.EventoProcessador;
import projeto.tcc.dominio.eventos.musica.MusicaAdicionadaEvento;
import projeto.tcc.dominio.eventos.musica.MusicaTocadaEvento;
import projeto.tcc.dominio.eventos.musica.PlayListAdicionadaEvento;
import projeto.tcc.interfaceusuario.comandos.AdicionarMusicaComando;
import projeto.tcc.interfaceusuario.comandos.CriarPlayListComando;
import projeto.tcc.interfaceusuario.comandos.TocarMusicaComando;

public class PlayList implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4406930874998196493L;
	private String nome;
	private List<Musica> musicas;
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

	public List<Musica> getMusica() {
		return musicas;
	}

	public void setMusica(List<Musica> musicas) {
		this.musicas = musicas;
	}
	
	public void adicionarMusica(AdicionarMusicaComando adicionarMusicaComando, Set<Musica> minhasMusicas, Musica musica, Object aggregateIDObject) throws Exception {
		
		if(adicionarMusicaComando.aggregateId() == null){
			UUID agregadoRand = UUID.randomUUID();
			adicionarMusicaComando.setPlaylistID(agregadoRand);
			criarPlayList(new CriarPlayListComando((UUID.fromString(String.valueOf(aggregateIDObject))),(UUID.fromString(String.valueOf(agregadoRand))), "Default"));
		}
		
		if(!minhasMusicas.contains(musica))
		new EventoProcessador().processarEvento((new MusicaAdicionadaEvento(adicionarMusicaComando.aggregateId(), adicionarMusicaComando.getNomeMusica(), 0)));
		else
			throw new RuntimeException("Você já possui essa música");
		
	}
	
	public void tocarMusica(TocarMusicaComando tocarMusicaComando) throws Exception {
		new EventoProcessador().processarEvento((new MusicaTocadaEvento(tocarMusicaComando.aggregateId(), tocarMusicaComando.getNomeMusica(),  0)));
		
	}
	
	public void criarPlayList(CriarPlayListComando criarPlayListComando)throws Exception {
		new EventoProcessador().processarEvento((new PlayListAdicionadaEvento(criarPlayListComando.aggregateId(),criarPlayListComando.getPlayListUID(), criarPlayListComando.getNome(), 0)));
	}

	public List<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
	}

}
