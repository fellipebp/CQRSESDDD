package projeto.tcc.aplicacao.comandos.processador;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import projeto.tcc.aplicacao.comandos.PosProcessadorComandos;
import projeto.tcc.aplicacao.comandos.ProcessadorComandos;
import projeto.tcc.dominio.entidades.usuario.Usuario;
import projeto.tcc.dominio.eventos.EventoProcessador;
import projeto.tcc.dominio.eventos.usuario.UsuarioCadastradoEvento;
import projeto.tcc.dominio.eventos.usuario.UsuarioLogadoEvento;
import projeto.tcc.infraestrutura.ControladorVersao;
import projeto.tcc.infraestrutura.armazenamento.repositorio.impl.RepositorioUsuarioImpl;
import projeto.tcc.interfaceusuario.comandos.Comando;
import projeto.tcc.interfaceusuario.comandos.FazerLoginComando;

public class ProcessadorLoginUsuarioComando implements ProcessadorComandos {

	@Override
	public void execute(Comando comando) throws Exception {
		FazerLoginComando fazerLoginComando = (FazerLoginComando) comando;
		
		RepositorioUsuarioImpl repositorioUsuarioImpl = new RepositorioUsuarioImpl();
		Usuario usuarioBase = repositorioUsuarioImpl.getUsuarioPorAggregateID(fazerLoginComando.getAggregateID().toString());
		
		
		Map<String, Object> valores = new HashMap<String, Object>();
		valores.put("aggregateID", fazerLoginComando.getAggregateID());
		valores.put("senha", fazerLoginComando.getSenha());
		
		
		//CAREGAR USUARIO
		usuarioBase.logar(valores);
		
		PosProcessadorComandos.validaVersaoComando(comando);
		
		Long version = ControladorVersao.getProximaVersao();
		new EventoProcessador().processarEvento(new UsuarioLogadoEvento(UUID.fromString(usuarioBase.getAggregateID()), usuarioBase.getLogin(), usuarioBase.getSenha(),new Date(), version, version));
	}

}
