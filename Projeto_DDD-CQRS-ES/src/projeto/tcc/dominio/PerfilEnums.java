package projeto.tcc.dominio;

public enum PerfilEnums {
	
	GRATUITO(1, "Gratuito - Acesso limitado aos recursos do aplicativo sem pagar nada.",0.0),
	INTERMEDIARIO(2, "Intermediario - Acesso ilimitado aos recursos do aplicativo, porém sem suporte. Valor de R$35.", 35.0),
	ILIMITADO(3, "Ilimitado - Acesso ilimitado aos recursos do aplicativo com suporte 24hs. Valor de R$60.", 60.0);
	
	
	private Integer cdPerfil;
	private String descricao;
	private Double valor;
	
	private PerfilEnums() {
	}

	private PerfilEnums(Integer cdPerfil, String descricao, Double valor) {
		this.cdPerfil = cdPerfil;
		this.descricao = descricao;
		this.valor = valor;
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
	
	public static PerfilEnums getEnumByCdPerfil(Integer cdPerfil){
		for (PerfilEnums perfilEnum : PerfilEnums.values()) {
			if (perfilEnum.getCdPerfil().equals(cdPerfil)) {
				return perfilEnum;
			}
		}
		return null;
	}
	
	

}
