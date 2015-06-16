package projeto.tcc.dominio.entidades.usuario;

import java.util.logging.Level;
import java.util.logging.Logger;

import projeto.tcc.dominio.eventos.usuario.UsuarioCadastradoEvento;
import projeto.tcc.dominio.eventos.usuario.UsuarioEditadoEvento;
import projeto.tcc.dominio.eventos.usuario.UsuarioLogadoEvento;

public class RestauradorAtributosUsuario {
	
	private static final Logger LOGGER = Logger.getLogger(RestauradorAtributosUsuario.class.getName());
	private Usuario usuario;
	
	public RestauradorAtributosUsuario() {
		this.usuario = new Usuario();
	}
	
	public void aplicaMudanca(UsuarioLogadoEvento usuarioLogadoEvento){
		 this.usuario.aggregateID = usuarioLogadoEvento.getAggregateId().toString();
		 this.usuario.login = usuarioLogadoEvento.getLogin();
		 this.usuario.senha = usuarioLogadoEvento.getSenha();
		
	}
	
	public void aplicaMudanca(UsuarioCadastradoEvento usuarioCadastradoEvento){
		try {
			this.usuario.login = usuarioCadastradoEvento.getLogin();
			this.usuario.senha = usuarioCadastradoEvento.getSenha();
			this.usuario.nome = usuarioCadastradoEvento.getNome();
			this.usuario.CPF = usuarioCadastradoEvento.getCPF();
			this.usuario.email = usuarioCadastradoEvento.getEmail();
			this.usuario.aggregateID = usuarioCadastradoEvento.getAggregateId().toString();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
	}
	
	
	public void aplicaMudanca(UsuarioEditadoEvento usuarioEditadoEvento){
		try {
			this.usuario.login = usuarioEditadoEvento.getUsuario().getLogin();
			this.usuario.senha = usuarioEditadoEvento.getUsuario().getSenha();
			this.usuario.nome = usuarioEditadoEvento.getUsuario().getNome();
			this.usuario.CPF = usuarioEditadoEvento.getUsuario().getCPF();
			this.usuario.email = usuarioEditadoEvento.getUsuario().getEmail();
			this.usuario.aggregateID = usuarioEditadoEvento.getAggregateId().toString();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
