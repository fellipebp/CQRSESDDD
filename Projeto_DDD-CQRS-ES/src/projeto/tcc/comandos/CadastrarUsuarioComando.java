package projeto.tcc.comandos;

import java.util.UUID;

public class CadastrarUsuarioComando implements Comando {

	
	private UUID usuarioUID;
	private String login;
	private String senha;
	
	public CadastrarUsuarioComando(UUID usuarioUID , String login, String senha) {
		this.usuarioUID = usuarioUID;
		this.login = login;
		this.senha = senha;
	}
	
	@Override
	public UUID aggregateId() {
		// TODO Auto-generated method stub
		return null;
	}

	public UUID getUsuarioUID() {
		return usuarioUID;
	}

	public void setUsuarioUID(UUID usuarioUID) {
		this.usuarioUID = usuarioUID;
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

}
