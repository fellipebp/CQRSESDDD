package projeto.tcc.interfaceusuario.comandos;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import projeto.tcc.interfaceusuario.dto.CriarUsuarioDTO;

public class CadastrarUsuarioComando implements Comando {

	
	private UUID usuarioUID;
	private String login;
	private String senha;
	private String cpf;
	private String nome;
	private String email;
	private Date dtNascimento;
	private String sgSexo;
	private Integer cdPerfil;
	
	private Long version;
	
	public CadastrarUsuarioComando(UUID usuarioUID , CriarUsuarioDTO usuarioDTO) {
		this.usuarioUID = usuarioUID;
		this.login = usuarioDTO.getLogin();
		this.senha = usuarioDTO.getSenha();
		this.cpf = usuarioDTO.getCpf();
		this.nome = usuarioDTO.getNome();
		this.email = usuarioDTO.getEmail();
		this.cdPerfil = usuarioDTO.getCdPerfil();
		this.dtNascimento = usuarioDTO.getDtNascimento();
		this.sgSexo = usuarioDTO.getSgSexo();
		this.version = 0L;
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
		this.cpf = cpf.replaceAll("[.-]", "");
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
		return this.version;
	}


	public Integer getCdPerfil() {
		return cdPerfil;
	}


	public void setCdPerfil(Integer cdPerfil) {
		this.cdPerfil = cdPerfil;
	}


	public Date getDtNascimento() {
		return dtNascimento;
	}


	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}


	public String getSgSexo() {
		return sgSexo;
	}


	public void setSgSexo(String sgSexo) {
		this.sgSexo = sgSexo;
	}

}
