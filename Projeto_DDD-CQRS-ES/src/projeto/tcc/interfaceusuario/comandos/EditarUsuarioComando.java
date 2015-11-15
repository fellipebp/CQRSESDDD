package projeto.tcc.interfaceusuario.comandos;

import java.util.UUID;

import projeto.tcc.interfaceusuario.dto.EditarUsuarioDTO;

public class EditarUsuarioComando implements Comando {

	
	private UUID usuarioUID;
	private String cpf;
	private String nome;
	private String email;
	
	private Integer cdPerfil;
	
	private Long version;
	
	public EditarUsuarioComando(UUID usuarioUID, EditarUsuarioDTO editarUsuarioDTO) {
		this.cpf = editarUsuarioDTO.getCpf();
		this.nome = editarUsuarioDTO.getNome();
		this.email  = editarUsuarioDTO.getEmail();
		this.usuarioUID = usuarioUID;
		this.cdPerfil = editarUsuarioDTO.getCdPerfil();
		this.version = editarUsuarioDTO.getVersion();
	}
	
	@Override
	public UUID aggregateId() {
		return getUsuarioUID();
	}

	public UUID getUsuarioUID() {
		return usuarioUID;
	}

	public void setUsuarioUID(UUID usuarioUID) {
		this.usuarioUID = usuarioUID;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public Long getVersion() {
		return version;
	}

	public Integer getCdPerfil() {
		return cdPerfil;
	}

	public void setCdPerfil(Integer cdPerfil) {
		this.cdPerfil = cdPerfil;
	}
	
}
