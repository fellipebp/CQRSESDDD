package projeto.tcc.eventos.usuario;

import java.util.Date;

import projeto.tcc.dominio.Usuario;
import projeto.tcc.eventos.Evento;

public class UsuarioLogadoEvento implements Evento {
	
	

	
	private Usuario usuario;
	private Date dtLogin;
	
	public UsuarioLogadoEvento() {
	}
	
	public UsuarioLogadoEvento(Usuario usuario, Date dtLogin){
		this.usuario = usuario;
		this.dtLogin = dtLogin;
	}

//	@Override
//	public void Processar() {
//		usuario.logar(this);
//		
//	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getDtLogin() {
		return dtLogin;
	}

	public void setDtLogin(Date dtLogin) {
		this.dtLogin = dtLogin;
	}
	

}
