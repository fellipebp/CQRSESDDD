package projeto.tcc.dominio.entidades.perfilusuario;

import java.io.Serializable;

public class PerfilUsuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1210603334654237181L;
	private String aggregateID;
	private Integer cdPerfil;
	private String descricao;
	
	
	
	public String getAggregateID() {
		return aggregateID;
	}
	public void setAggregateID(String aggregateID) {
		this.aggregateID = aggregateID;
	}
	public Integer getCdPerfil() {
		return cdPerfil;
	}
	public void setCdPerfil(Integer cdPerfil) {
		this.cdPerfil = cdPerfil;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
	

}
