package projeto.tcc.dominio.eventos.musica;

import java.util.UUID;

import projeto.tcc.dominio.eventos.Evento;

public class MusicaAdicionadaEvento implements Evento{

	@Override
	public UUID getAggregateId() {
		return null;
	}

}
