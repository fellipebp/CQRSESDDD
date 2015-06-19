package projeto.tcc.dominio.entidades.musica;

import java.util.logging.Logger;

import projeto.tcc.dominio.entidades.usuario.RestauradorAtributosUsuario;
import projeto.tcc.dominio.entidades.usuario.Usuario;

public class RestauradorAtributosMusica {
	
	private static final Logger LOGGER = Logger.getLogger(RestauradorAtributosUsuario.class.getName());
	private Musica musica;
	
	public RestauradorAtributosMusica() {
		this.musica = new Musica();
	}

}
