package projeto.tcc.interfaceusuario;

import java.io.Serializable;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import projeto.tcc.dominio.Usuario;
import projeto.tcc.eventos.EventoProcessador;
import projeto.tcc.eventos.usuario.UsuarioCadastradoEvento;
import projeto.tcc.interfaceusuario.servico.ServicoUsuarioFacade;

@ManagedBean
@ViewScoped
public class CriarUsuarioBean implements Serializable{
	
	@Inject
	private ServicoUsuarioFacade servicoUsuarioFacade;
	private static final long serialVersionUID = 5029033187840615480L;
	private Usuario usuario;
	private UsuarioCadastradoEvento usuarioEvento;
	private EventoProcessador eP;
	
	@PostConstruct 
	public void init() {	
		usuario = new Usuario();
		eP = new EventoProcessador();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String criarUsuario() throws Exception{
		UUID idOne = UUID.randomUUID();
		usuarioEvento = new UsuarioCadastradoEvento("teste", usuario);
		eP.processar(usuarioEvento);
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário cadastrado com sucesso", null);
		FacesContext.getCurrentInstance().addMessage("messageGenerica", facesMessage);
		return "criarUsuario.xhtml?faces-redirect=true";
		
	}
		
}
