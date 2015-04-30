package projeto.tcc.interfaceusuario;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projeto.tcc.aplicacao.ServicoUsuario;
import projeto.tcc.comandos.FazerLoginComando;
import projeto.tcc.interfaceusuario.dto.FazerLoginDTO;

@Named
@SessionScoped
public class LoginUsuarioBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7918764410608856865L;
	@Inject
	private ServicoUsuario servicoUsuario;
//	private ServicoUsuarioImplFacade servicoUsuarioImplFacade = new ServicoUsuarioImplFacade();
//	@Inject
	private FazerLoginDTO fazerLoginDTO;
	
	
	public String logar(){
		servicoUsuario.logarUsuario(new FazerLoginComando(fazerLoginDTO)); 
		 return "ouvirMusica.xhtml?faces-redirect=true";
	}


	public FazerLoginDTO getFazerLoginDTO() {
		return fazerLoginDTO;
	}


	public void setFazerLoginDTO(FazerLoginDTO fazerLoginDTO) {
		this.fazerLoginDTO = fazerLoginDTO;
	}



}
