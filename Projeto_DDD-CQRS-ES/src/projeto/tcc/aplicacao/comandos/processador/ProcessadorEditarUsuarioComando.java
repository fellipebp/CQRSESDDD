package projeto.tcc.aplicacao.comandos.processador;

import java.util.HashMap;
import java.util.Map;

import projeto.tcc.aplicacao.comandos.PosProcessadorComandos;
import projeto.tcc.aplicacao.comandos.ProcessadorComandos;
import projeto.tcc.dominio.entidades.usuario.Usuario;
import projeto.tcc.dominio.eventos.EventoProcessador;
import projeto.tcc.dominio.eventos.usuario.UsuarioEditadoEvento;
import projeto.tcc.infraestrutura.ControlerVersionValidator;
import projeto.tcc.infraestrutura.armazenamento.repositorio.impl.RepositorioUsuarioImpl;
import projeto.tcc.interfaceusuario.comandos.Comando;
import projeto.tcc.interfaceusuario.comandos.EditarUsuarioComando;

public class ProcessadorEditarUsuarioComando implements ProcessadorComandos {

	@Override
	public void execute(Comando comando) throws Exception {
		EditarUsuarioComando editarUsuarioComando = (EditarUsuarioComando) comando;
		Usuario usuario = new RepositorioUsuarioImpl().getUsuarioPorAggregateID(editarUsuarioComando.aggregateId().toString());
		
		Map<String, Object> valores = new HashMap<String, Object>();
		valores.put("login", editarUsuarioComando.getLogin());
		valores.put("senha", editarUsuarioComando.getSenha());
		valores.put("nome", editarUsuarioComando.getNome());
		valores.put("cpf", editarUsuarioComando.getCpf());
		valores.put("email", editarUsuarioComando.getEmail());
		valores.put("cdPerfil", editarUsuarioComando.getCdPerfil());
		
		usuario.editarInformacoes(valores);
		
		PosProcessadorComandos.validaVersaoComando(editarUsuarioComando);
		Long version = ControlerVersionValidator.getProximaVersao();
		EventoProcessador eventoProcessador = new EventoProcessador();
		eventoProcessador.processarEvento((new UsuarioEditadoEvento(editarUsuarioComando.aggregateId(), usuario, version, version)));
	}

}
