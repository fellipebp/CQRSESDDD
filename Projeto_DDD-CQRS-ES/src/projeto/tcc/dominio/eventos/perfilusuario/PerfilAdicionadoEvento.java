package projeto.tcc.dominio.eventos.perfilusuario;

import java.io.Serializable;
import java.util.UUID;

import projeto.tcc.dominio.entidades.usuario.PerfilUsuario;
import projeto.tcc.dominio.entidades.usuario.Usuario;
import projeto.tcc.dominio.eventos.Evento;

public class PerfilAdicionadoEvento implements Evento, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6531058589845932466L;

	@Override
	public UUID getAggregateId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getClazz() {
		// TODO Auto-generated method stub
		return PerfilUsuario.class;
	}

}
