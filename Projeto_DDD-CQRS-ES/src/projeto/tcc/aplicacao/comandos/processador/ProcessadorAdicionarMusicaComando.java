package projeto.tcc.aplicacao.comandos.processador;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import projeto.tcc.aplicacao.comandos.ProcessadorComandos;
import projeto.tcc.dominio.entidades.musica.PlayList;
import projeto.tcc.dominio.entidades.usuario.Usuario;
import projeto.tcc.dominio.eventos.EventoProcessador;
import projeto.tcc.dominio.eventos.musica.MusicaAdicionadaEvento;
import projeto.tcc.dominio.eventos.usuario.UsuarioCadastradoEvento;
import projeto.tcc.infraestrutura.ControladorVersao;
import projeto.tcc.interfaceusuario.comandos.AdicionarMusicaComando;
import projeto.tcc.interfaceusuario.comandos.Comando;
import projeto.tcc.interfaceusuario.comandos.CriarPlayListComando;

public class ProcessadorAdicionarMusicaComando implements ProcessadorComandos{

	@Override
	public void execute(Comando comando) throws Exception {
		AdicionarMusicaComando adicionarMusicaComando = (AdicionarMusicaComando) comando; 
		
		Map<String, Object> valores = new HashMap<String, Object>();
		valores.put("aggregateIDPlayList", adicionarMusicaComando.aggregateId());
		valores.put("nomeMusica", adicionarMusicaComando.getMusica().getNome());
		
		
//		if(adicionarMusicaComando.aggregateId() == null){ //Se for null, é por que ele ainda não possui uma playlist.
//			UUID agregadoRand = UUID.randomUUID();
//			throw new RuntimeException("Você não possui uma playlist");
//			adicionarMusicaComando.setPlaylistID(agregadoRand);
//			new PlayList().criarPlayList(new CriarPlayListComando((UUID.fromString(String.valueOf(adicionarMusicaComando.getAggregateIDObject()))),(UUID.fromString(String.valueOf(agregadoRand))), "Default"));
//		}
		
		
//		new Usuario().adicionarMusicaNaPlayList(valores);// Acho que é assim que deveria ser feito.
// 		PlayList playlist = new PlayList().adicionarMusica(valores);
		
//		PosProcessadorComandos.validaVersaoComando(comando);
		Long version = ControladorVersao.getProximaVersao();
		EventoProcessador eventoProcessador = new EventoProcessador();
		eventoProcessador.processarEvento((new MusicaAdicionadaEvento((UUID)valores.get("aggregateIDPlayList"), (String)valores.get("nomeMusica"), version,version)));
		//eventoProcessador.processarAggregado(adicionarMusicaComando.aggregateId(), PlayList.class, adicionarMusicaComando.getVersion());
	}

}