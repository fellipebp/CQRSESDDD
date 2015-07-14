package projeto.tcc.dominio.entidades.seguranca;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import projeto.tcc.dominio.entidades.auditoria.Auditoria;
import projeto.tcc.dominio.entidades.usuario.Usuario;
import projeto.tcc.dominio.eventos.EventoProcessador;
import projeto.tcc.dominio.eventos.usuario.UsuarioDeslogadoEvento;
import projeto.tcc.dominio.eventos.usuario.UsuarioLogadoEvento;
import projeto.tcc.infraestrutura.armazenamento.repositorio.impl.RepositorioUsuarioImpl;
import projeto.tcc.interfaceusuario.comandos.DeslogarComando;
import projeto.tcc.interfaceusuario.comandos.FazerLoginComando;

public class Seguranca {
	
	protected List<Auditoria> listaAuditoria;
	
	public Seguranca() {
		listaAuditoria = new ArrayList<>();
	}
	
	
	public String logar(FazerLoginComando comandoLogin) throws Exception {
		RepositorioUsuarioImpl repositorioUsuarioImpl = new RepositorioUsuarioImpl();
		String aggregateID = repositorioUsuarioImpl.existeUsuarioComEsseLogin(comandoLogin.getLogin());
		Usuario usuarioBase = repositorioUsuarioImpl.getUsuarioPorAggregateID(aggregateID);
		if (usuarioBase !=null && comandoLogin.getSenha().equals(usuarioBase.getSenha())) {
			new EventoProcessador().processarEvento(new UsuarioLogadoEvento(UUID.fromString(usuarioBase.getAggregateID()), usuarioBase.getLogin(), usuarioBase.getSenha(),new Date(), 0));
			return aggregateID;
		}
		//TODO criar exceção especifica
		throw new RuntimeException("Usuário ou senha inválidos");
		
	}
	
	
	public boolean deslogar(DeslogarComando deslogarComando) throws Exception{
		if (deslogarComando.getAggregateID() !=null) {
			UsuarioDeslogadoEvento ude = new UsuarioDeslogadoEvento((UUID)deslogarComando.getAggregateID(), new Date());
			new EventoProcessador().processarEvento(ude);
			return true;
		}
		return false;
	}

}
