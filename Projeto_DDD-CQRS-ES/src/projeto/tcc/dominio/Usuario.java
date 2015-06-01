package projeto.tcc.dominio;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.text.MaskFormatter;

import projeto.tcc.dominio.eventos.EventoProcessador;
import projeto.tcc.dominio.eventos.usuario.UsuarioCadastradoEvento;
import projeto.tcc.dominio.eventos.usuario.UsuarioEditadoEvento;
import projeto.tcc.dominio.eventos.usuario.UsuarioLogadoEvento;
import projeto.tcc.infraestrutura.armazenamento.repositorio.impl.RepositorioUsuarioImpl;
import projeto.tcc.interfaceusuario.comandos.CadastrarUsuarioComando;
import projeto.tcc.interfaceusuario.comandos.EditarUsuarioComando;
import projeto.tcc.interfaceusuario.comandos.FazerLoginComando;


public class Usuario  implements Serializable {
	
	/**
	 * 
	 */
	private static final Logger LOGGER = Logger.getLogger(Usuario.class.getName());

	
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
	
	//private listaEventos (mudancas)

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
	
	public String getCPFFormatado() {
		MaskFormatter mask;
		try {
			mask = new MaskFormatter("###.###.###-##");
			mask.setValueContainsLiteralCharacters(false);
			return mask.valueToString(CPF);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "";
	}

	public void setCPF(String cPF) {
		CPF = cPF.replaceAll("[.-]", "");;
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
	public void criarCadastro(CadastrarUsuarioComando usuarioComando) throws Exception {
		Usuario usuario = new RepositorioUsuarioImpl().getUsuarioPorCPF(usuarioComando.getCpf());
		if(usuario != null){
			//TODO criar exceção especifica
			throw new RuntimeException("Já existe um usuário com esse cpf");
		}
		usuario = new Usuario();
		usuario.setLogin(usuarioComando.getLogin());
		usuario.setSenha(usuarioComando.getSenha());
		usuario.setNome(usuarioComando.getNome());
		usuario.setCPF( usuarioComando.getCpf());
		usuario.setEmail( usuarioComando.getEmail());
//		usuario.setAggregateID(usuarioComando.aggregateId().toString());
		new EventoProcessador().processar((new UsuarioCadastradoEvento(usuarioComando.aggregateId(), usuario)));
	}
	
	
	public String logar(FazerLoginComando comandoLogin) throws Exception {
		RepositorioUsuarioImpl repositorioUsuarioImpl = new RepositorioUsuarioImpl();
		String aggregateID = repositorioUsuarioImpl.existeUsuarioComEsseLogin(comandoLogin.getLogin());
		Usuario usuarioBase = repositorioUsuarioImpl.getUsuarioPorAggregateID(aggregateID);
		if (usuarioBase !=null && comandoLogin.getSenha().equals(usuarioBase.getSenha())) {
			new EventoProcessador().processar(new UsuarioLogadoEvento(UUID.fromString(usuarioBase.getAggregateID()), usuarioBase,new Date()));
			return aggregateID;
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
		
	
	public void aplicaMudanca(UsuarioLogadoEvento usuarioLogadoEvento){
		 Usuario usuario = usuarioLogadoEvento.getUsuario();
		 this.setCPF(usuario.getCPF());
		 this.setDataNascimento(usuario.getDataNascimento());
		 this.setEmail(usuario.getEmail());
		 this.setId(usuario.getId());
		 this.setLogin(usuario.getLogin());
		 this.setNome(usuario.getNome());
		 this.setSenha(usuario.getSenha());
		 this.setSexo(usuario.getSexo());
		
	}
	
	public void aplicaMudanca(UsuarioCadastradoEvento usuarioCadastradoEvento){
		try {
			this.setLogin(usuarioCadastradoEvento.getLogin());
			this.setSenha(usuarioCadastradoEvento.getSenha());
			this.setNome(usuarioCadastradoEvento.getNome());
			this.setCPF(usuarioCadastradoEvento.getCPF());
			this.setEmail(usuarioCadastradoEvento.getEmail());
			this.setAggregateID(usuarioCadastradoEvento.getAggregateId().toString());
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
	}

	public void editarInformacoes(EditarUsuarioComando editarUsuarioComando) throws Exception {
		Usuario usuario = new Usuario();
		usuario.setLogin(editarUsuarioComando.getLogin());
		usuario.setSenha(editarUsuarioComando.getSenha());
		usuario.setNome(editarUsuarioComando.getNome());
		usuario.setCPF( editarUsuarioComando.getCpf());
		usuario.setEmail( editarUsuarioComando.getEmail());
//		usuario.setAggregateID(usuarioComando.aggregateId().toString());
		new EventoProcessador().processar((new UsuarioEditadoEvento(editarUsuarioComando.aggregateId(), usuario)));
		
	}
	



}
