package projeto.tcc.interfaceusuario;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import projeto.tcc.dominio.Usuario;

@ManagedBean
@ViewScoped
public class CriarUsuarioBean implements Serializable{
	
	
	private static final long serialVersionUID = 5029033187840615480L;
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
	
	public void criarUsuario(ActionEvent actionEvent){
		//FIXME chamar serviço?
	}
		
}
