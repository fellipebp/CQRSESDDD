package projeto.tcc.dominio.eventos.usuario;

import java.util.UUID;

import projeto.tcc.dominio.eventos.Evento;

public class UsuarioDeslogadoEvento implements Evento{

	@Override
	public UUID getAggregateId() {
		return null;
	}

}
