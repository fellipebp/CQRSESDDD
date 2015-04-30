package projeto.tcc.interfaceusuario;

import java.io.Serializable;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projeto.tcc.aplicacao.ServicoUsuario;
import projeto.tcc.comandos.CadastrarUsuarioComando;
import projeto.tcc.interfaceusuario.dto.CriarUsuarioDTO;

@Named
@ConversationScoped
public class CriarUsuarioBean implements Serializable{
	
	private static final long serialVersionUID = 5029033187840615480L;
	@Inject
	private CriarUsuarioDTO usuarioDTO;
	
	@Inject	ServicoUsuario servicoUsuario;
	
	
	private String login;
	private String senha;
	
	@PostConstruct
	    public void init(){
	      
	    }

	
	public String criarUsuario() throws Exception{
		UUID idOne = UUID.randomUUID();
		servicoUsuario.cadastrarUsuario(new CadastrarUsuarioComando(idOne,usuarioDTO));
		return null;
		
	}


	public CriarUsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}


	public void setUsuarioDTO(CriarUsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
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
		
}
