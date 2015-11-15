package projeto.tcc.interfaceusuario.controle;

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
import projeto.tcc.infraestrutura.ControladorVersao;
import projeto.tcc.interfaceusuario.comandos.AlterarSenhaComando;
import projeto.tcc.interfaceusuario.dto.AlterarSenhaDTO;
import java.io.Serializable;


@Named
@ConversationScoped
public class AlterarSenhaBean implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 849777013397299495L;
	@Inject	private ServicoUsuarioEscrita servicoUsuarioEscrita;
	@Inject	private ServicoUsuarioLeitura servicoUsuarioLeitura;
	
	private AlterarSenhaDTO alterarSenhaDTO;

	private HttpServletRequest request;
	
	public AlterarSenhaBean() {
	}
	
	
	@PostConstruct
	public void init() {
		request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		alterarSenhaDTO = new AlterarSenhaDTO();
		String aggregateID = String.valueOf(request.getSession().getAttribute("aggregateID"));
		alterarSenhaDTO.setVersion(ControladorVersao.getUltimaVersaoAgregado(aggregateID));
	}

	public AlterarSenhaDTO getAlterarSenhaDTO() {
		return alterarSenhaDTO;
	}

	public void setAlterarSenhaDTO(AlterarSenhaDTO alterarSenhaDTO) {
		this.alterarSenhaDTO = alterarSenhaDTO;
	}
	
	public String alterarSenha(){
		Object aggregateIDObject = request.getSession().getAttribute("aggregateID");
		try {
			servicoUsuarioEscrita.alterarSenha(new AlterarSenhaComando(UUID.fromString(String.valueOf(aggregateIDObject)), alterarSenhaDTO));
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Senha alterada com sucesso"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";

	}
	
	public String abrirAlteracaoSenha(){
		return "alterarSenha.xhtml?faces-redirect=true";
	}
	
	public String voltar(){
		return "ouvirMusica.xhtml?faces-redirect=true";
	}

}
