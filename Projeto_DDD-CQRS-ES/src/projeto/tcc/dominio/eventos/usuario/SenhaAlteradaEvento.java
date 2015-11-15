package projeto.tcc.dominio.eventos.usuario;

import java.util.UUID;

import projeto.tcc.dominio.entidades.usuario.Usuario;
import projeto.tcc.dominio.eventos.Evento;

public class SenhaAlteradaEvento implements Evento {
	
	private UUID aggregateID;
	private Long version;
	private Long groupVersion;
	
	private String senha;
	
	public SenhaAlteradaEvento(UUID aggregateID, String senhaNova, Long version, Long groupVersion) {
		this.aggregateID = aggregateID;
		this.senha = senhaNova;
		this.version = version;
		this.groupVersion = groupVersion;
	}

	@Override
	public UUID getAggregateId() {
		return aggregateID;
	}

	@Override
	public Long getVersion() {
		return version;
	}

	@Override
	public Long getGroupVersion() {
		return groupVersion;
	}

	@Override
	public Class<?> getClazz() {
		return Usuario.class;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
