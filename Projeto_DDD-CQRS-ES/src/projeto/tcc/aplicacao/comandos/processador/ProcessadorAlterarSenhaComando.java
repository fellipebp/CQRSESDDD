package projeto.tcc.aplicacao.comandos.processador;

import java.util.HashMap;
import java.util.Map;

import projeto.tcc.aplicacao.comandos.PosProcessadorComandos;
import projeto.tcc.aplicacao.comandos.ProcessadorComandos;
import projeto.tcc.dominio.entidades.usuario.Usuario;
import projeto.tcc.dominio.eventos.EventoProcessador;
import projeto.tcc.dominio.eventos.usuario.SenhaAlteradaEvento;
import projeto.tcc.dominio.eventos.usuario.UsuarioEditadoEvento;
import projeto.tcc.infraestrutura.ControladorVersao;
import projeto.tcc.infraestrutura.armazenamento.repositorio.impl.RepositorioUsuarioImpl;
import projeto.tcc.interfaceusuario.comandos.AlterarSenhaComando;
import projeto.tcc.interfaceusuario.comandos.Comando;

public class ProcessadorAlterarSenhaComando implements ProcessadorComandos {

	@Override
	public void execute(Comando comando) throws Exception {
		AlterarSenhaComando alterarSenhaComando = (AlterarSenhaComando) comando;
		
		Usuario usuario = new RepositorioUsuarioImpl().getUsuarioPorAggregateID(alterarSenhaComando.aggregateId().toString());
		
		Map<String, Object> valores = new HashMap<String, Object>();
		valores.put("senhaAtual", alterarSenhaComando.getSenhaAtual());
		valores.put("senhaNova", alterarSenhaComando.getSenhaNova());
		
		usuario.alterarSenha(valores);
		
		PosProcessadorComandos.validaVersaoComando(alterarSenhaComando);
		Long version = ControladorVersao.getProximaVersao();
		EventoProcessador eventoProcessador = new EventoProcessador();
		eventoProcessador.processarEvento((new SenhaAlteradaEvento(alterarSenhaComando.aggregateId(), alterarSenhaComando.getSenhaNova(), version, version)));

	}

}
