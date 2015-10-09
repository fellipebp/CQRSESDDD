package projeto.tcc.aplicacao.comandos.processador;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import projeto.tcc.aplicacao.comandos.ProcessadorComandos;
import projeto.tcc.dominio.eventos.EventoProcessador;
import projeto.tcc.dominio.eventos.musica.MusicaAdicionadaFavoritosEvento;
import projeto.tcc.infraestrutura.ControlerVersionValidator;
import projeto.tcc.interfaceusuario.comandos.AdicionarMusicaComando;
import projeto.tcc.interfaceusuario.comandos.AdicionarMusicaFavoritosComando;
import projeto.tcc.interfaceusuario.comandos.Comando;

public class ProcessadorAdicionarMusicaFavoritoComando implements ProcessadorComandos{

	@Override
	public void execute(Comando comando) throws Exception {
		AdicionarMusicaFavoritosComando adicionarMusicaFavoritoComando = (AdicionarMusicaFavoritosComando) comando; 
		
		Map<String, Object> valores = new HashMap<String, Object>();
		valores.put("aggregateID", adicionarMusicaFavoritoComando.aggregateId());
		valores.put("nomeMusica", adicionarMusicaFavoritoComando.getMusica().getNome());

		Long version = ControlerVersionValidator.getProximaVersao();
		EventoProcessador eventoProcessador = new EventoProcessador();
		eventoProcessador.processarEvento((new MusicaAdicionadaFavoritosEvento((UUID)valores.get("aggregateID"), (String)valores.get("nomeMusica"), version,version)));
		//eventoProcessador.processarAggregado(adicionarMusicaComando.aggregateId(), PlayList.class, adicionarMusicaComando.getVersion());
	}

}