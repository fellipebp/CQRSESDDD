package projeto.tcc.dominio.entidades.usuario;

import java.io.Serializable;

//FIXME VERIFICAR VISIBILIDADE
public class PerfilUsuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1210603334654237181L;
	private String aggregateID;
	private Integer cdPerfil;
	private String descricao;
	private Double valor;
	
	
	public PerfilUsuario() {
	}
	
	public PerfilUsuario(String aggregateID, Integer cdPerfil, String descricao, Double valor) {
		super();
		this.aggregateID = aggregateID;
		this.cdPerfil = cdPerfil;
		this.descricao = descricao;
		this.valor = valor;
	}




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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
	
	

}
