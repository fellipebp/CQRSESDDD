package projeto.tcc.dominio.entidades.musica;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import projeto.tcc.dominio.eventos.EventoProcessador;
import projeto.tcc.dominio.eventos.musica.MusicaAdicionadaEvento;
import projeto.tcc.dominio.eventos.musica.MusicaTocadaEvento;
import projeto.tcc.interfaceusuario.comandos.TocarMusicaComando;

public class PlayList implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4406930874998196493L;
	private String nome;
	private String aggregateID;
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
	
	public PlayList adicionarMusica(Map<String, Object> valores) throws Exception {
		PlayList playList = new PlayList();
//		if(adicionarMusicaComando.aggregateId() == null){ //Se for null, é por que ele ainda não possui uma playlist.
//			UUID agregadoRand = UUID.randomUUID();
//			adicionarMusicaComando.setPlaylistID(agregadoRand);
//			criarPlayList(new CriarPlayListComando((UUID.fromString(String.valueOf(adicionarMusicaComando.getAggregateIDObject()))),(UUID.fromString(String.valueOf(agregadoRand))), "Default"));
//		}
//		
		new EventoProcessador().processarEvento((new MusicaAdicionadaEvento((UUID)valores.get("aggregateIDPlayList"), (String)valores.get("nomeMusica"), 0L)));
		return playList;
	}
	
	public void tocarMusica(TocarMusicaComando tocarMusicaComando) throws Exception {
		new EventoProcessador().processarEvento((new MusicaTocadaEvento(tocarMusicaComando.aggregateId(), tocarMusicaComando.getNomeMusica(),  0L)));
		
	}
	
	public void criarPlayList(Map<String, Object> valores)throws Exception {
		
		List<PlayList> minhasPlayLists = (List<PlayList>)valores.get("listaPlayList");
		for(PlayList playListTmp : minhasPlayLists){
			if(playListTmp.getNome().equalsIgnoreCase((String)valores.get("nomePlayList"))){
				throw new RuntimeException("Essa PlayList já existe");
			}
		}
		
	}

	public List<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
	}

	public String getAggregateID() {
		return aggregateID;
	}

	public void setAggregateID(String aggregateID) {
		this.aggregateID = aggregateID;
	}

}