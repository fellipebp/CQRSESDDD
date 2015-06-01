package projeto.tcc.interfaceusuario.controle;

import java.io.Serializable;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import projeto.tcc.aplicacao.ServicoUsuarioEscrita;
import projeto.tcc.aplicacao.ServicoUsuarioLeitura;
import projeto.tcc.dominio.Usuario;
import projeto.tcc.interfaceusuario.comandos.EditarUsuarioComando;
import projeto.tcc.interfaceusuario.dto.EditarUsuarioDTO;

@Named
@ConversationScoped
public class EditarUsuarioBean implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Inject	private ServicoUsuarioEscrita servicoUsuarioEscrita;
	@Inject	private ServicoUsuarioLeitura servicoUsuarioLeitura;
	private EditarUsuarioDTO usuarioDTO;
	
	private HttpServletRequest request;
	
	
	@PostConstruct
	public void init() {
		request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		Usuario usuario = servicoUsuarioLeitura.getUsuarioPorAggregateID(String
				.valueOf(request.getSession().getAttribute("aggregateID")));
		setUsuarioDTO(new EditarUsuarioDTO());
		getUsuarioDTO().setCpf(usuario.getCPF());
		// usuarioDTO.setDataNascimento(usuario.getDataNascimento());
		getUsuarioDTO().setEmail(usuario.getEmail());
		getUsuarioDTO().setLogin(usuario.getLogin());
		getUsuarioDTO().setNome(usuario.getNome());
		getUsuarioDTO().setSenha(usuario.getSenha());
	}

	
	public String editarUsuario() throws Exception{
		Object aggregateIDObject = request.getSession().getAttribute("aggregateID");
		servicoUsuarioEscrita.editarInformacoesUsuario(new EditarUsuarioComando(UUID.fromString(String.valueOf(aggregateIDObject)), usuarioDTO));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario editado com sucesso"));
		return "";
		
	}
	
	public String voltar(){
		return "ouvirMusica.xhtml?faces-redirect=true";
	}
	
	
	public String visualizarMinhasInformacoes(){
		return "minhasInformacoes.xhtml?faces-redirect=true";
	}


	public EditarUsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}


	public void setUsuarioDTO(EditarUsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}
		
}
