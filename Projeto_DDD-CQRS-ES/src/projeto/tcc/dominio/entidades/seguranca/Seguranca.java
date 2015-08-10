package projeto.tcc.dominio.entidades.seguranca;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import projeto.tcc.dominio.entidades.auditoria.Auditoria;
import projeto.tcc.dominio.entidades.usuario.Usuario;
import projeto.tcc.dominio.eventos.Evento;
import projeto.tcc.dominio.eventos.EventoProcessador;
import projeto.tcc.dominio.eventos.auditoria.AuditoriaRegistradaEvento;
import projeto.tcc.dominio.eventos.usuario.UsuarioDeslogadoEvento;
import projeto.tcc.dominio.eventos.usuario.UsuarioLogadoEvento;
import projeto.tcc.infraestrutura.armazenamento.repositorio.impl.RepositorioUsuarioImpl;
import projeto.tcc.interfaceusuario.comandos.DeslogarComando;
import projeto.tcc.interfaceusuario.comandos.FazerLoginComando;

public class Seguranca {
	
//	protected Map<String,Auditoria> mapAuditoria;
	
	public Seguranca() {
//		mapAuditoria = new HashMap<>();
	}
	
	
	public String logar(FazerLoginComando comandoLogin) throws Exception {
		RepositorioUsuarioImpl repositorioUsuarioImpl = new RepositorioUsuarioImpl();
		Usuario usuarioBase = repositorioUsuarioImpl.getUsuarioPorAggregateID(comandoLogin.getAggregateID().toString());
		if (usuarioBase !=null && comandoLogin.getSenha().equals(usuarioBase.getSenha())) {
			new EventoProcessador().processarEvento(
					new UsuarioLogadoEvento(UUID.fromString(usuarioBase.getAggregateID()), usuarioBase.getLogin(), usuarioBase.getSenha(),new Date(), comandoLogin.getVersion()));
//			Auditoria auditoria = new Auditoria();
//			auditoria.setDtLogin(new Date());
//			auditoria.setAggregateID(usuarioBase.getAggregateID());
			return comandoLogin.getAggregateID().toString();
		}
		
		//TODO criar exceção especifica
		throw new RuntimeException("Usuário ou senha inválidos");
		
	}
	
	
	public String existeUsuarioComEsseLogin(FazerLoginComando fazerLoginComando)throws Exception{
		 RepositorioUsuarioImpl repositorioUsuarioImpl = new RepositorioUsuarioImpl();
		 String aggregateID = repositorioUsuarioImpl.existeUsuarioComEsseLogin(fazerLoginComando.getLogin());
		 if (aggregateID == null || aggregateID =="") {
			throw new RuntimeException("Não existe nenhum usuário registrado com este CPF.");
		 }
		 return aggregateID;
	}
	
	public boolean deslogar(DeslogarComando deslogarComando) throws Exception{
		if (deslogarComando.getAggregateID() !=null) {
			UsuarioDeslogadoEvento ude = new UsuarioDeslogadoEvento((UUID)deslogarComando.getAggregateID(), new Date());
			EventoProcessador eventoProcessador = new EventoProcessador();
			eventoProcessador.processarEvento(ude);
//			Auditoria auditoria = this.mapAuditoria.get(deslogarComando.getAggregateID());
//			auditoria.setDtLogoff(new Date());
//			eventoProcessador.processarEvento(
//					new AuditoriaRegistradaEvento(UUID.fromString(auditoria.getAggregateID()), auditoria.getDtLogin(), auditoria.getDtLogoff(), auditoria.getEventos(), 0));
//			this.mapAuditoria.remove(auditoria.getAggregateID());
			return true;
		}
		return false;
	}
	
	
//	public void registraAuditoria(Evento evento){
//		if (this.mapAuditoria.containsKey(evento.getAggregateId())) {
//			Auditoria auditoria = this.mapAuditoria.get(evento.getAggregateId());
//			auditoria.getEventos().add(evento.getClass().getCanonicalName());
//			this.mapAuditoria.put(auditoria.getAggregateID(), auditoria);
//		}
//		throw new RuntimeException("Ocorreu um erro no processamento da sua ação. Relogue e tente novamente.");
//	}
}
