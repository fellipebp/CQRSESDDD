package projeto.tcc.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import projeto.tcc.dominio.eventos.EventoProcessador;
import projeto.tcc.dominio.eventos.usuario.UsuarioCadastradoEvento;
import projeto.tcc.dominio.eventos.usuario.UsuarioLogadoEvento;
import projeto.tcc.infraestrutura.armazenamento.impl.RepositorioUsuarioImpl;
import projeto.tcc.interfaceusuario.comandos.CadastrarUsuarioComando;
import projeto.tcc.interfaceusuario.comandos.FazerLoginComando;


public class Usuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String login;
	private String senha;
	private String nome;
	private String CPF;
	private String email;
	private Date dataNascimento;
	private String sexo;
	private String aggregateID;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
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
	public void cuidarCadastro(CadastrarUsuarioComando usuario) throws Exception {
//		if (StringUtils.isNullOrEmpty(usuario.getCpf()) || StringUtils.isNullOrEmpty(usuario.getNome())
//				|| StringUtils.isNullOrEmpty(usuario.getLogin()) || !StringUtils.isNullOrEmpty(usuario.getSenha())) {
//			//throw new erro. Nao pode ser gerado o evento pois nao atendeu a regra de negocio
//		}
		
		new EventoProcessador().processar((new UsuarioCadastradoEvento(usuario.aggregateId(),usuario.getLogin(),usuario.getSenha())));
//		new RepositorioUsuarioImpl().processarUsuarioCadastradoEvento((new UsuarioCadastradoEvento(usuario.aggregateId(),usuario.getLogin(),usuario.getSenha())));
	}
	
	
	public void logar(FazerLoginComando comandoLogin) throws Exception {
		Usuario usuarioBase = new RepositorioUsuarioImpl().getUsuarioPorLogin(comandoLogin.getLogin());
		if (usuarioBase !=null && comandoLogin.getSenha().equals(usuarioBase.getSenha())) {
			new EventoProcessador().processar(new UsuarioLogadoEvento(UUID.fromString(usuarioBase.getAggregateID()), usuarioBase,new Date()));
			return;
		}
		//TODO criar exceção especifica
		throw new RuntimeException("Usuário ou senha inválidos");
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAggregateID() {
		return aggregateID;
	}

	public void setAggregateID(String aggregateID) {
		this.aggregateID = aggregateID;
	}
		

}
