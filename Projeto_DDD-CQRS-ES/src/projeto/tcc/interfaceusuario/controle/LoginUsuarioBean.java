package projeto.tcc.interfaceusuario.controle;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import projeto.tcc.aplicacao.ServicoUsuarioEscrita;
import projeto.tcc.aplicacao.ServicoUsuarioLeitura;
import projeto.tcc.interfaceusuario.comandos.FazerLoginComando;
import projeto.tcc.interfaceusuario.dto.FazerLoginDTO;

@Named
@SessionScoped
public class LoginUsuarioBean implements Serializable {

	private static final long serialVersionUID = -7918764410608856865L;
	@Inject
	private ServicoUsuarioEscrita servicoUsuarioEscrita;
	@Inject
	private FazerLoginDTO fazerLoginDTO;
	
	public String logar(){
		try {
			FazerLoginComando fazerLoginComando = new FazerLoginComando(fazerLoginDTO);
			String aggregateID = servicoUsuarioEscrita.logarUsuario(fazerLoginComando);
			salvaAggregateIDNaSessao(aggregateID);
			return "app/ouvirMusica.xhtml?faces-redirect=true";
		} catch (Exception e) {
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, e.getMessage(), null));
		} 
		return "";
	}

	private void salvaAggregateIDNaSessao(String aggregateID) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("aggregateID",aggregateID);
	}
	

	public FazerLoginDTO getFazerLoginDTO() {
		return fazerLoginDTO;
	}

	public void setFazerLoginDTO(FazerLoginDTO fazerLoginDTO) {
		this.fazerLoginDTO = fazerLoginDTO;
	}




}
