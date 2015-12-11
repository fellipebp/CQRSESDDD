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
		Long version = ControladorVersao.getProximaVersao();
		EventoProcessador eventoProcessador = new EventoProcessador();
		eventoProcessador.processarEvento((new MusicaAdicionadaEvento((UUID)valores.get("aggregateIDPlayList"), (String)valores.get("nomeMusica"), version,version)));
	}

}