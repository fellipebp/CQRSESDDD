package projeto.tcc.eventos.usuario;

import java.io.Serializable;

import projeto.tcc.dominio.Usuario;
import projeto.tcc.eventos.Evento;

public class UsuarioCadastradoEvento extends Evento implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String comentario;
	private Usuario usuario;
	
	public UsuarioCadastradoEvento(int id, String comentario, Usuario usuario) {
		this.id = id;
		this.comentario = comentario;
		this.usuario = usuario;
	}
	
	public void Processar() {
		usuario.cuidarCadastro(this);
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	

}
