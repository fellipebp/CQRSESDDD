package projeto.tcc.interfaceusuario.comandos;

import java.util.UUID;

public class DeslogarComando implements Comando {

	
	private Object aggregateID;
	
	public DeslogarComando(Object aggregateID) {
		this.aggregateID = aggregateID;
	}
	
	@Override
	public UUID aggregateId() {
		return null;
	}

	public Object getAggregateID() {
		return aggregateID;
	}

	public void setAggregateID(UUID aggregateID) {
		this.aggregateID = aggregateID;
	}

	@Override
	public Integer getVersion() {
		// TODO Auto-generated method stub
		return null;
	}

}
