package projeto.tcc.interfaceusuario.controle;

import java.io.Serializable;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import projeto.tcc.aplicacao.ServicoUsuarioEscrita;
import projeto.tcc.aplicacao.ServicoUsuarioLeitura;
import projeto.tcc.dominio.PerfilEnums;
import projeto.tcc.interfaceusuario.comandos.CadastrarUsuarioComando;
import projeto.tcc.interfaceusuario.dto.CriarUsuarioDTO;

@Named
@ConversationScoped
public class CriarUsuarioBean implements Serializable{
	
	private static final long serialVersionUID = 5029033187840615480L;
	@Inject
	private CriarUsuarioDTO usuarioDTO;
	
	@Inject	private ServicoUsuarioEscrita servicoUsuarioEscrita;
	
	
	private String login;
	private String senha;
	
	@PostConstruct
	public void init(){
	      
	}

	
	public String criarUsuario() throws Exception{
		try{
		UUID idOne = UUID.randomUUID();
		servicoUsuarioEscrita.cadastrarUsuario(new CadastrarUsuarioComando(idOne,usuarioDTO));
		FacesContext context = FacesContext.getCurrentInstance();
		context.getCurrentInstance().addMessage(null, new FacesMessage("Usuario cadastrado com sucesso"));
		context.getExternalContext().getFlash().setKeepMessages(true);
		return "/xhtml/loginUsuarioCPF.xhtml?faces-redirect=true";
		}catch (Exception e) {
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, e.getMessage(), null));
		} 
		return "";
		
	}
	
	public PerfilEnums[] getPerfis(){
		return PerfilEnums.values();
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
