package projeto.tcc.interfaceusuario;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import projeto.tcc.dominio.Usuario;
import projeto.tcc.eventos.EventoProcessador;
import projeto.tcc.eventos.usuario.UsuarioCadastradoEvento;

@ManagedBean
@ViewScoped
public class CriarUsuarioBean implements Serializable{
	
	
	private static final long serialVersionUID = 5029033187840615480L;
	private Usuario usuario;
	private UsuarioCadastradoEvento usuarioEvento;
	private EventoProcessador eP;
	
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
	
	public String criarUsuario() throws Exception{
		
		
		usuarioEvento = new UsuarioCadastradoEvento(1, "teste", usuario);
		eP.processar(usuarioEvento);
		
		return null;
		
	}
		
}
