package projeto.tcc.aplicacao.comandos.processador;


import java.util.HashMap;
import java.util.Map;

import projeto.tcc.aplicacao.comandos.ProcessadorComandos;
import projeto.tcc.dominio.entidades.musica.PlayList;
import projeto.tcc.dominio.eventos.EventoProcessador;
import projeto.tcc.dominio.eventos.musica.PlayListAdicionadaEvento;
import projeto.tcc.infraestrutura.ControladorVersao;
import projeto.tcc.interfaceusuario.comandos.Comando;
import projeto.tcc.interfaceusuario.comandos.CriarPlayListComando;

public class ProcessadorCriarPlayListComando implements ProcessadorComandos{

	@Override
	public void execute(Comando comando) throws Exception {
		CriarPlayListComando criarPlayListComando = (CriarPlayListComando) comando; 
//		PosProcessadorComandos.validaVersaoComando(comando);
		Map<String, Object> valores = new HashMap<String, Object>();
		valores.put("nomePlayList", criarPlayListComando.getNome());
		valores.put("listaPlayList", criarPlayListComando.getMinhasPlayList());
		new PlayList().criarPlayList(valores);
		EventoProcessador eventoProcessador = new EventoProcessador();
		Long version = ControladorVersao.getProximaVersao();
		eventoProcessador.processarEvento((new PlayListAdicionadaEvento(criarPlayListComando.aggregateId(),criarPlayListComando.getPlayListUID(), criarPlayListComando.getNome(),version,version)));
		//eventoProcessador.processarAggregado(criarPlayListComando.aggregateId(), PlayList.class, criarPlayListComando.getVersion());
	}

}