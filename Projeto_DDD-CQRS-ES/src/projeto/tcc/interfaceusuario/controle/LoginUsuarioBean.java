package projeto.tcc.interfaceusuario.controle;

import java.io.Serializable;
import java.util.UUID;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import projeto.tcc.aplicacao.ServicoSegurancaEscrita;
import projeto.tcc.aplicacao.ServicoUsuarioEscrita;
import projeto.tcc.aplicacao.ServicoUsuarioLeitura;
import projeto.tcc.interfaceusuario.comandos.DeslogarComando;
import projeto.tcc.interfaceusuario.comandos.FazerLoginComando;
import projeto.tcc.interfaceusuario.dto.FazerLoginDTO;

@Named
@SessionScoped
public class LoginUsuarioBean implements Serializable {

	private static final long serialVersionUID = -7918764410608856865L;
	@Inject
	private ServicoSegurancaEscrita servicoSegurancaEscrita;
	@Inject
	private FazerLoginDTO fazerLoginDTO;
	
	public String logar(){
		try {
			FazerLoginComando fazerLoginComando = new FazerLoginComando(fazerLoginDTO);
			fazerLoginComando.setAggregateID(UUID.fromString(String.valueOf(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("aggregateID"))));
			servicoSegurancaEscrita.logarUsuario(fazerLoginComando);
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
			String aggregateID = servicoSegurancaEscrita.existeUsuarioComEsseLogin(fazerLoginComando);
			salvaAggregateIDNaSessao(aggregateID);
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
			DeslogarComando deslogarComando = new DeslogarComando(request.getSession().getAttribute("aggregateID"));
			boolean ok = servicoSegurancaEscrita.deslogarUsuario(deslogarComando);
			if (ok) {
				request.getSession().invalidate();
			}
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
