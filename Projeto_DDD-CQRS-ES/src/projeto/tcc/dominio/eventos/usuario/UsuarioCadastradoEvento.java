package projeto.tcc.dominio.eventos.usuario;

import java.io.Serializable;
import java.util.UUID;

import projeto.tcc.dominio.eventos.Evento;


public class UsuarioCadastradoEvento implements Evento, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UUID aggregateId;
	private String login;
	private String senha;
	
	public UsuarioCadastradoEvento(UUID aggregateId, String login, String senha) {
		this.aggregateId = aggregateId;
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

	public UUID getAggregateId() {
		return aggregateId;
	}

	public void setAggregateId(UUID aggregateId) {
		this.aggregateId = aggregateId;
	}


//	public void Processar() {
//		usuario.cuidarCadastro(this);
//		
//	}






	

}
