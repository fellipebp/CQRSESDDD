package projeto.tcc.comandos;

import java.util.UUID;

public class FazerLoginComando implements Comando {
	
	private UUID usuarioUID;
	private String login;
	private String senha;
	
	public FazerLoginComando(String login, String senha) {
		this.login = login;
		this.senha = senha;
		
	}
	

	@Override
	public UUID aggregateId() {
		// TODO Auto-generated method stub
		return usuarioUID;
	}


	public UUID getLoginID() {
		return usuarioUID;
	}


	public void setLoginID(UUID usuarioUID) {
		this.usuarioUID = usuarioUID;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}

}
