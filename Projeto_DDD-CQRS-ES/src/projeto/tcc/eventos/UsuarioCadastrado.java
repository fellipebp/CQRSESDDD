package projeto.tcc.eventos;

import projeto.tcc.dominio.Usuario;

public class UsuarioCadastrado {
	
	private int id;
	private String comentario;
	private Usuario usuario;
	
	public UsuarioCadastrado(int id, String comentario, Usuario usuario) {
		this.id = id;
		this.comentario = comentario;
		this.usuario = usuario;
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

	public void Processar() {
		usuario.cuidarCadastro(this);
		
	}
	

}
