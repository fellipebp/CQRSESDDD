package projeto.tcc.interfaceusuario.comandos;

import java.util.UUID;

import projeto.tcc.interfaceusuario.dto.FazerLoginDTO;

public class FazerLoginComando implements Comando {
	
	private UUID usuarioUID;
	private String login;
	private String senha;
	
	public FazerLoginComando(FazerLoginDTO fazerLoginDTO) {
		this.login = fazerLoginDTO.getLogin();
		this.senha = fazerLoginDTO.getSenha();
	}
	

	@Override
	public UUID aggregateId() {
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
