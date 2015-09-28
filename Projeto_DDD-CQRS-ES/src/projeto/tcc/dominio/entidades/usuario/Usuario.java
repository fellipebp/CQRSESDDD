package projeto.tcc.dominio.entidades.usuario;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

import javax.swing.text.MaskFormatter;

import projeto.tcc.dominio.entidades.musica.PlayList;
import projeto.tcc.dominio.eventos.EventoProcessador;
import projeto.tcc.dominio.eventos.usuario.UsuarioEditadoEvento;
import projeto.tcc.infraestrutura.armazenamento.repositorio.impl.RepositorioUsuarioImpl;
import projeto.tcc.interfaceusuario.comandos.CadastrarUsuarioComando;
import projeto.tcc.interfaceusuario.comandos.EditarUsuarioComando;


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
	protected String sexo;
	protected String aggregateID;
	protected List<PlayList> playlists;
	
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
		
		//REPOSITORIO FICA RESPONSAVEL POR TRATAR A CACHE
		//PEDE O REPOSITORIO PARA CARREGAR O OBJETO, PROCESSO O NEGOCIO E ANTES DE GERAR O EVENTO VERIFICA SE A VERSAO DO OBJETO EM QUESTAO ESTÁ IGUAL AO QUE ESTÁ NA CACHE
		//SE NAO ESTIVER, SIGNIFICA QUE ALGUEM PROCESSOU E GEROU A VERSAO ANTES
//		Usuario usuario = new RepositorioUsuarioImpl().getUsuarioPorCPF(usuarioComando.getCpf());
//		if (ControlerVersionValidator.jaExisteIDAgregadoNaCache(usuarioComando.aggregateId().toString())) {
//			throw new RuntimeException("Ocorreram alterações durante o processamento da sua operação. Tente novamente.");
//		}
//		ControlerVersionValidator.adicionaIDAgregagadoNaCache(usuarioComando.aggregateId().toString());
//		
//		if(usuario != null){
//			throw new RuntimeException("Já existe um usuário com esse cpf");
//		}
//		usuario = new Usuario();
//		usuario.setLogin(usuarioComando.getLogin());
//		usuario.setSenha(usuarioComando.getSenha());
//		usuario.setNome(usuarioComando.getNome());
//		usuario.setCPF( usuarioComando.getCpf());
//		usuario.setEmail( usuarioComando.getEmail());
//		EventoProcessador eventoProcessador = new EventoProcessador();
//		eventoProcessador.processarEvento((new UsuarioCadastradoEvento(usuarioComando.aggregateId(),usuarioComando.getVersion(), usuario)));
//		eventoProcessador.processarAggregado(usuarioComando.aggregateId(), Usuario.class, usuarioComando.getVersion());
	}
	
	
	public Usuario criarCadastro(Map<String, Object> valores) throws Exception {
			
			//REPOSITORIO FICA RESPONSAVEL POR TRATAR A CACHE
			//PEDE O REPOSITORIO PARA CARREGAR O OBJETO, PROCESSO O NEGOCIO E ANTES DE GERAR O EVENTO VERIFICA SE A VERSAO DO OBJETO EM QUESTAO ESTÁ IGUAL AO QUE ESTÁ NA CACHE
			//SE NAO ESTIVER, SIGNIFICA QUE ALGUEM PROCESSOU E GEROU A VERSAO ANTES
			Usuario usuario = new RepositorioUsuarioImpl().getUsuarioPorCPF(String.valueOf(valores.get("cpf")));
			if(usuario != null){
				throw new RuntimeException("Já existe um usuário com esse cpf");
			}
			usuario = new Usuario();
			usuario.setLogin(String.valueOf(valores.get("login")));
			usuario.setSenha(String.valueOf(valores.get("senha")));
			usuario.setNome(String.valueOf(valores.get("nome")));
			usuario.setCPF( String.valueOf(valores.get("cpf")));
			usuario.setEmail(String.valueOf(valores.get("email")));
			return usuario;
		}
		
//	
//	public String logar(FazerLoginComando comandoLogin) throws Exception {
//		RepositorioUsuarioImpl repositorioUsuarioImpl = new RepositorioUsuarioImpl();
//		String aggregateID = repositorioUsuarioImpl.existeUsuarioComEsseLogin(comandoLogin.getLogin());
//		Usuario usuarioBase = repositorioUsuarioImpl.getUsuarioPorAggregateID(aggregateID);
//		if (usuarioBase !=null && comandoLogin.getSenha().equals(usuarioBase.getSenha())) {
//			new EventoProcessador().processarEvento(new UsuarioLogadoEvento(UUID.fromString(usuarioBase.getAggregateID()), usuarioBase.getLogin(), usuarioBase.getSenha(),new Date(),0));
//			return aggregateID;
//		}
//		//TODO criar exceção especifica
//		throw new RuntimeException("Usuário ou senha inválidos");
//		
//	}
//	
//	
//	public boolean deslogar(DeslogarComando deslogarComando) throws Exception{
//		if (deslogarComando.getAggregateID() !=null) {
//			UsuarioDeslogadoEvento ude = new UsuarioDeslogadoEvento((UUID)deslogarComando.getAggregateID(), new Date());
//			new EventoProcessador().processarEvento(ude);
//			return true;
//		}
//		return false;
//	}
//	

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
		

	public void editarInformacoes(EditarUsuarioComando editarUsuarioComando) throws Exception {
		Usuario usuario = new Usuario();
		usuario.setLogin(editarUsuarioComando.getLogin());
		usuario.setSenha(editarUsuarioComando.getSenha());
		usuario.setNome(editarUsuarioComando.getNome());
		usuario.setCPF( editarUsuarioComando.getCpf());
		usuario.setEmail( editarUsuarioComando.getEmail());
//		usuario.setAggregateID(usuarioComando.aggregateId().toString());
		EventoProcessador eventoProcessador = new EventoProcessador();
		eventoProcessador.processarEvento((new UsuarioEditadoEvento(editarUsuarioComando.aggregateId(), usuario)));
		eventoProcessador.processarAggregado(editarUsuarioComando.aggregateId(), Usuario.class, editarUsuarioComando.getVersion());
		
		
	}

	public List<PlayList> getPlayLists() {
		return playlists;
	}

	public void setPlayLists(List<PlayList> playlists) {
		this.playlists = playlists;
	}


}
