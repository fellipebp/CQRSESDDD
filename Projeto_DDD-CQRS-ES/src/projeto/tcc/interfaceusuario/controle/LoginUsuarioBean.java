package projeto.tcc.interfaceusuario.controle;

import java.io.Serializable;
import java.util.UUID;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import projeto.tcc.aplicacao.ServicoUsuarioEscrita;
import projeto.tcc.infraestrutura.ControlerVersionValidator;
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
			fazerLoginComando.setAggregateID(UUID.fromString(String.valueOf(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("aggregateID"))));
			servicoUsuarioEscrita.logarUsuario(fazerLoginComando);
			return "app/ouvirMusica.xhtml?faces-redirect=true";
		} catch (Exception e) {
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, e.getMessage(), null));
		} 
		return "";
	}
	
	
	public String continuar(){
		try {
			FazerLoginComando fazerLoginComando = new FazerLoginComando(fazerLoginDTO);
			String aggregateID = servicoUsuarioEscrita.existeUsuarioComEsseLogin(fazerLoginComando);
			salvaAggregateIDNaSessao(aggregateID);
			this.fazerLoginDTO.setVersion(ControlerVersionValidator.getUltimaVersaoAgregado(aggregateID));
			return "loginUsuarioSenha.xhtml?faces-redirect=true";
		} catch (Exception e) {
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, e.getMessage(), null));
		} 
		return "";
	}
	
	
	public String deslogar(){
		try {
			HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
//			DeslogarComando deslogarComando = new DeslogarComando(request.getSession().getAttribute("aggregateID"));
//			servicoSegurancaEscrita.deslogarUsuario(deslogarComando);
			request.getSession().invalidate();
			return "loginUsuario.xhtml?faces-redirect=true";
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
