package projeto.tcc.interfaceusuario.comandos;

import java.util.UUID;

import projeto.tcc.interfaceusuario.dto.EditarUsuarioDTO;

public class EditarUsuarioComando implements Comando {

	
	private UUID usuarioUID;
	private String login;
	private String senha;
	private String cpf;
	private String nome;
	private String email;
	
	public EditarUsuarioComando(UUID usuarioUID, EditarUsuarioDTO editarUsuarioDTO) {
		this.senha =  editarUsuarioDTO.getSenha();
		this.cpf = editarUsuarioDTO.getCpf();
		this.nome = editarUsuarioDTO.getNome();
		this.email  = editarUsuarioDTO.getEmail();
		this.usuarioUID = usuarioUID;
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
	public Integer getVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
