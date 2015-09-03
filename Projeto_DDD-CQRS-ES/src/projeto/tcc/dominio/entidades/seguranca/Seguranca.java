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
import projeto.tcc.infraestrutura.ControlerVersionValidator;
import projeto.tcc.infraestrutura.armazenamento.repositorio.impl.RepositorioUsuarioImpl;
import projeto.tcc.interfaceusuario.comandos.DeslogarComando;
import projeto.tcc.interfaceusuario.comandos.FazerLoginComando;

public class Seguranca {
	
//	protected Map<String,Auditoria> mapAuditoria;
	
	public Seguranca() {
//		mapAuditoria = new HashMap<>();
	}
	
	
	public void logar(Map<String, Object> valores) throws Exception {
		RepositorioUsuarioImpl repositorioUsuarioImpl = new RepositorioUsuarioImpl();
		Usuario usuarioBase = repositorioUsuarioImpl.getUsuarioPorAggregateID(String.valueOf(valores.get("aggregateID")));
		
		if (usuarioBase ==null || !	String.valueOf(valores.get("senha")).equals(usuarioBase.getSenha())) {
			//TODO criar exceção especifica
			throw new RuntimeException("Usuário ou senha inválidos");
		}
	}
	
	
	public String existeUsuarioComEsseLogin(FazerLoginComando fazerLoginComando)throws Exception{
		 RepositorioUsuarioImpl repositorioUsuarioImpl = new RepositorioUsuarioImpl();
		 String aggregateID = repositorioUsuarioImpl.existeUsuarioComEsseLogin(fazerLoginComando.getLogin());
		 if (aggregateID == null || aggregateID =="") {
			throw new RuntimeException("Não existe nenhum usuário registrado com este CPF.");
		 }
		 return aggregateID;
	}
	
	public void deslogar(Map<String, Object> valores) throws Exception{
		if (valores.get("aggregateID") ==null) {
			throw new RuntimeException("Não existe nenhum usuário registrado com este CPF.");
		}
//		Auditoria auditoria = this.mapAuditoria.get(deslogarComando.getAggregateID());
//		auditoria.setDtLogoff(new Date());
//		eventoProcessador.processarEvento(
//				new AuditoriaRegistradaEvento(UUID.fromString(auditoria.getAggregateID()), auditoria.getDtLogin(), auditoria.getDtLogoff(), auditoria.getEventos(), 0));
//		this.mapAuditoria.remove(auditoria.getAggregateID());
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
