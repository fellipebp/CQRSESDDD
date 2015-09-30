package projeto.tcc.dominio.eventos;

import java.util.UUID;


public interface Evento  {

	UUID getAggregateId();
	Long getVersion();
	Class<?> getClazz();
	
}
