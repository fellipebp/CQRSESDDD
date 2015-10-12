package projeto.tcc.dominio.entidades.usuario;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.swing.text.MaskFormatter;

import projeto.tcc.dominio.PerfilEnums;
import projeto.tcc.dominio.entidades.musica.PlayList;
import projeto.tcc.dominio.exception.UsuarioJaRegistradoException;
import projeto.tcc.dominio.exception.UsuarioMenorIdadeException;
import projeto.tcc.dominio.exception.UsuarioNaoRegistradoException;
import projeto.tcc.dominio.exception.UsuarioOuSenhaInvalidosException;
import projeto.tcc.infraestrutura.armazenamento.repositorio.impl.RepositorioUsuarioImpl;
import projeto.tcc.interfaceusuario.comandos.FazerLoginComando;


public class Usuario  implements Serializable {
	
	/**
	 * 
	 */
	private static final Logger LOGGER = Logger.getLogger(Usuario.class.getName());

	
	private static final long serialVersionUID = 1L;
	protected int id;
	protected String login;
	protected String senha;
	protected String nome;
	protected String CPF;
	protected String email;
	protected Date dataNascimento;
	protected Date dataUltimoLogin;
	protected String sexo;
	protected String aggregateID;
	protected List<PlayList> playlists;
	protected PerfilUsuario perfilUsuario;
	
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
	
	public Usuario criarCadastro(Map<String, Object> valores) throws Exception {
			
			Usuario usuario = new RepositorioUsuarioImpl().getUsuarioPorCPF(String.valueOf(valores.get("cpf")));
			if(usuario != null){
				throw new UsuarioJaRegistradoException("Já existe um usuário cadastrado com esse cpf.");
			}
			
			Date dtNascimento = new Date(Long.parseLong(valores.get("dtNascimento").toString()));
			Calendar dtNascimentoC = Calendar.getInstance();
			dtNascimentoC.setTime(dtNascimento);
			Calendar dtAtual = Calendar.getInstance();
			if(dtAtual.get(Calendar.YEAR) - dtNascimentoC.get(Calendar.YEAR) < 18){
				throw new UsuarioMenorIdadeException("É necessário ter mais de 18 anos para utilizar o aplicativo.");
			}
			
			usuario = new Usuario();
			usuario.setLogin(String.valueOf(valores.get("login")));
			usuario.setSenha(String.valueOf(valores.get("senha")));
			usuario.setNome(String.valueOf(valores.get("nome")));
			usuario.setCPF( String.valueOf(valores.get("cpf")));
			usuario.setEmail(String.valueOf(valores.get("email")));
			usuario.setPerfil(Integer.parseInt(valores.get("cdPerfil").toString()));
			return usuario;
		}
		
	
	public void logar(Map<String, Object> valores) throws Exception {
		RepositorioUsuarioImpl repositorioUsuarioImpl = new RepositorioUsuarioImpl();
		Usuario usuarioBase = repositorioUsuarioImpl.getUsuarioPorAggregateID(String.valueOf(valores.get("aggregateID")));
		
		if (usuarioBase ==null || !	String.valueOf(valores.get("senha")).equals(usuarioBase.getSenha())) {
			throw new UsuarioOuSenhaInvalidosException("Usuário ou senha inválidos.");
		}
	}
	
	
	public String existeUsuarioComEsseLogin(FazerLoginComando fazerLoginComando)throws Exception{
		 RepositorioUsuarioImpl repositorioUsuarioImpl = new RepositorioUsuarioImpl();
		 String aggregateID = repositorioUsuarioImpl.existeUsuarioComEsseLogin(fazerLoginComando.getLogin());
		 if (aggregateID == null || aggregateID =="") {
			throw new UsuarioNaoRegistradoException("Não existe nenhum usuário registrado com este login.");
		 }
		 return aggregateID;
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
		

	public void editarInformacoes(Map<String, Object> valores) throws Exception {
		this.setLogin(String.valueOf(valores.get("login")));
		this.setSenha(String.valueOf(valores.get("senha")));
		this.setNome(String.valueOf(valores.get("nome")));
		this.setCPF( String.valueOf(valores.get("cpf")));
		this.setEmail(String.valueOf(valores.get("email")));
		this.setPerfil(Integer.parseInt(valores.get("cdPerfil").toString()));
//		usuario.setAggregateID(usuarioComando.aggregateId().toString());
		
	}

	
	public List<PlayList> getPlayLists() {
				return playlists;
	}
	
	public void setPlayLists(List<PlayList> playlists) {
			this.playlists = playlists;
 	}

	public Integer getCdPerfil(){
		return this.perfilUsuario.getCdPerfil();
	}
	
	public void setPerfil(Integer cdPerfil){
		PerfilEnums perfil = PerfilEnums.getEnumByCdPerfil(cdPerfil);
		this.perfilUsuario = new PerfilUsuario(this.aggregateID, perfil.getCdPerfil(), perfil.getDescricao(),perfil.getValor());
	}

}
