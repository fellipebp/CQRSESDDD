package projeto.tcc.dominio.eventos.musica;

import java.util.UUID;

import projeto.tcc.dominio.entidades.musica.Musica;
import projeto.tcc.dominio.eventos.Evento;

public class MusicaRemovidaEvento implements Evento {

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
		return Musica.class;
	}

}
