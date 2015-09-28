package projeto.tcc.aplicacao.comandos;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import projeto.tcc.dominio.entidades.usuario.Usuario;
import projeto.tcc.dominio.eventos.EventoProcessador;
import projeto.tcc.dominio.eventos.musica.PlayListAdicionadaEvento;
import projeto.tcc.dominio.eventos.usuario.UsuarioCadastradoEvento;
import projeto.tcc.infraestrutura.armazenamento.repositorio.impl.RepositorioUsuarioImpl;
import projeto.tcc.interfaceusuario.comandos.CadastrarUsuarioComando;
import projeto.tcc.interfaceusuario.comandos.Comando;

public class ProcessadorCadastrarUsuarioComando implements ProcessadorComandos{

	@Override
	public void execute(Comando comando) throws Exception {
		CadastrarUsuarioComando cadastrarUsuarioComando = (CadastrarUsuarioComando) comando; 
//		Usuario usuario = new RepositorioUsuarioImpl().getUsuarioPorCPF(cadastrarUsuarioComando.getCpf());
		
		Map<String, Object> valores = new HashMap<String, Object>();
		valores.put("login", cadastrarUsuarioComando.getLogin());
		valores.put("senha", cadastrarUsuarioComando.getSenha());
		valores.put("nome", cadastrarUsuarioComando.getNome());
		valores.put("cpf", cadastrarUsuarioComando.getCpf());
		valores.put("email", cadastrarUsuarioComando.getEmail());
		
		Usuario usuario = new Usuario().criarCadastro(valores);
		
		PosProcessadorComandos.validaVersaoComando(comando);
		UUID idOne = UUID.randomUUID();
		EventoProcessador eventoProcessador = new EventoProcessador();
		eventoProcessador.processarEvento((new UsuarioCadastradoEvento(cadastrarUsuarioComando.aggregateId(),cadastrarUsuarioComando.getVersion(), usuario)));
		eventoProcessador.processarEvento((new PlayListAdicionadaEvento(cadastrarUsuarioComando.aggregateId(),idOne, "Default", 0)));
		eventoProcessador.processarAggregado(cadastrarUsuarioComando.aggregateId(), Usuario.class, cadastrarUsuarioComando.getVersion());
	}

}
