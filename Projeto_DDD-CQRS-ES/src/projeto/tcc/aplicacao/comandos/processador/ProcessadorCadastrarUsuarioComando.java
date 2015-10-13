package projeto.tcc.aplicacao.comandos.processador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import projeto.tcc.aplicacao.comandos.PosProcessadorComandos;
import projeto.tcc.aplicacao.comandos.ProcessadorComandos;
import projeto.tcc.dominio.entidades.usuario.Usuario;
import projeto.tcc.dominio.eventos.Evento;
import projeto.tcc.dominio.eventos.EventoProcessador;
import projeto.tcc.dominio.eventos.musica.PlayListAdicionadaEvento;
import projeto.tcc.dominio.eventos.usuario.UsuarioCadastradoEvento;
import projeto.tcc.infraestrutura.ControladorVersao;
import projeto.tcc.interfaceusuario.comandos.CadastrarUsuarioComando;
import projeto.tcc.interfaceusuario.comandos.Comando;

public class ProcessadorCadastrarUsuarioComando implements ProcessadorComandos{

	@Override
	public void execute(Comando comando) throws Exception {
		CadastrarUsuarioComando cadastrarUsuarioComando = (CadastrarUsuarioComando) comando; 
		Map<String, Object> valores = constroiMapaParametros(cadastrarUsuarioComando);
		
		Usuario usuario = new Usuario().criarCadastro(valores);
		
		PosProcessadorComandos.validaVersaoComando(comando);
		
		List<Evento> eventos = new ArrayList<>();
		EventoProcessador eventoProcessador = new EventoProcessador();
		Long version = ControladorVersao.getProximaVersao();
		
		UUID usuarioID = cadastrarUsuarioComando.aggregateId();
		UUID musicaID = UUID.randomUUID();
		
		UsuarioCadastradoEvento usuarioCadastradoEvento = 
				new UsuarioCadastradoEvento(usuarioID,version, usuario, version);
		PlayListAdicionadaEvento playListAdicionadaEvento = 
				new PlayListAdicionadaEvento(usuarioID,musicaID, "Default", ControladorVersao.getProximaVersao(), version);	
		eventos.add(usuarioCadastradoEvento);
		eventos.add(playListAdicionadaEvento);
		eventoProcessador.processarEventos(eventos);
	}

	private Map<String, Object> constroiMapaParametros(CadastrarUsuarioComando cadastrarUsuarioComando) {
		Map<String, Object> valores = new HashMap<String, Object>();
		valores.put("login", cadastrarUsuarioComando.getLogin());
		valores.put("senha", cadastrarUsuarioComando.getSenha());
		valores.put("nome", cadastrarUsuarioComando.getNome());
		valores.put("cpf", cadastrarUsuarioComando.getCpf());
		valores.put("email", cadastrarUsuarioComando.getEmail());
		valores.put("dtNascimento", cadastrarUsuarioComando.getDtNascimento().getTime());
		valores.put("sgSexo", cadastrarUsuarioComando.getSgSexo());
		valores.put("cdPerfil", cadastrarUsuarioComando.getCdPerfil());
		return valores;
	}

}
