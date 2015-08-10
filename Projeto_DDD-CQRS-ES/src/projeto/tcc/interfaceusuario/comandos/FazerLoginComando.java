package projeto.tcc.interfaceusuario.comandos;

import java.util.UUID;

import projeto.tcc.interfaceusuario.dto.FazerLoginDTO;

public class FazerLoginComando implements Comando {
	
	private UUID aggregateID;
	private String login;
	private String senha;
	private Integer version;
	
	public FazerLoginComando(FazerLoginDTO fazerLoginDTO) {
		this.login = fazerLoginDTO.getLogin();
		this.senha = fazerLoginDTO.getSenha();
		this.version = fazerLoginDTO.getVersion();
	}
	

	@Override
	public UUID aggregateId() {
		return getAggregateID();
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


	@Override
	public Integer getVersion() {
		return this.version;
	}


	public UUID getAggregateID() {
		return aggregateID;
	}


	public void setAggregateID(UUID aggregateID) {
		this.aggregateID = aggregateID;
	}


}
