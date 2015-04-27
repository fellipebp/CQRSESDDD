package projeto.tcc.eventos.usuario;

import java.io.Serializable;
import java.util.UUID;

import projeto.tcc.eventos.Evento;

public class UsuarioCadastradoEvento implements Evento, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UUID usuarioUID;
	private String login;
	private String senha;
	
	public UsuarioCadastradoEvento(UUID usuarioUID, String login, String senha) {
		this.usuarioUID = usuarioUID;
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UUID getUsuarioUID() {
		return usuarioUID;
	}

	public void setUsuarioUID(UUID usuarioUID) {
		this.usuarioUID = usuarioUID;
	}
	
//	public void Processar() {
//		usuario.cuidarCadastro(this);
//		
//	}






	

}
