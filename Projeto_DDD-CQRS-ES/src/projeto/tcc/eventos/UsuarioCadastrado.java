package projeto.tcc.eventos;

public class UsuarioCadastrado {
	
	private int id;
	private String motivo;
	
	public UsuarioCadastrado(int id, String motivo) {
		this.id = id;
		this.motivo = motivo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	

}
