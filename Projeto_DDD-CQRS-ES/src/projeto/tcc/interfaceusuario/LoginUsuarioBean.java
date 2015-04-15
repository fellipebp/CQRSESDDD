package projeto.tcc.interfaceusuario;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import projeto.tcc.dominio.Usuario;

@ManagedBean
@ViewScoped
public class LoginUsuarioBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7918764410608856865L;
	private Usuario usuario;
	
	@PostConstruct 
	public void init() {	
		usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void logar(ActionEvent actionEvent){
		//FIXME A principio nenhuma entidade loga, devemos chamar um serviço 
		//que deverá produzir um evento, não?
	}

}
