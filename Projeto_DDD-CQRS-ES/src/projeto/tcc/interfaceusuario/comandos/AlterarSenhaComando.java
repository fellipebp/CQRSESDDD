package projeto.tcc.interfaceusuario.comandos;

import java.util.UUID;

import projeto.tcc.interfaceusuario.dto.AlterarSenhaDTO;

public class AlterarSenhaComando implements Comando {
	
	private UUID usuarioUID;
	private String senhaAtual;
	private String senhaNova;
	
	private Long version;
	
	
	public AlterarSenhaComando(UUID aggregateID, AlterarSenhaDTO alterarSenhaDTO) {
		this.usuarioUID = aggregateID;
		this.senhaAtual =  alterarSenhaDTO.getSenhaAtual();
		this.senhaNova = alterarSenhaDTO.getSenhaNova();
		this.version = alterarSenhaDTO.getVersion();
	}

	@Override
	public UUID aggregateId() {
		return usuarioUID;
	}

	@Override
	public Long getVersion() {
		return version;
	}

	public String getSenhaAtual() {
		return senhaAtual;
	}

	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}

	public String getSenhaNova() {
		return senhaNova;
	}

	public void setSenhaNova(String senhaNova) {
		this.senhaNova = senhaNova;
	}

}
