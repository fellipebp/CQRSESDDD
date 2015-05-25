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
import projeto.tcc.interfaceusuario.comandos.CadastrarUsuarioComando;
import projeto.tcc.interfaceusuario.dto.CriarUsuarioDTO;

@Named
@ConversationScoped
public class EditarUsuarioBean implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Inject	private ServicoUsuarioEscrita servicoUsuarioLeitura;
	
	
	@PostConstruct
	    public void init(){
	     // servicoUsuarioLeitura.editarUsuario();
	    }

	
	public String criarUsuario() throws Exception{
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario editado com sucesso"));
		return "";
		
	}
		
}
