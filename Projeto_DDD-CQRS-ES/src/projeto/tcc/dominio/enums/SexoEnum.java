package projeto.tcc.dominio.enums;

public enum SexoEnum {

	MASCULINO("M", "Masculino"),
	FEMININO("F", "Feminino");
	
	
	private SexoEnum(String sgSexo, String deSexo){
		this.sgSexo = sgSexo;
		this.deSexo = deSexo;
	}
	
	private String sgSexo;
	private String deSexo;
	
	public String getSgSexo() {
		return sgSexo;
	}
	public void setSgSexo(String sgSexo) {
		this.sgSexo = sgSexo;
	}
	public String getDeSexo() {
		return deSexo;
	}
	public void setDeSexo(String deSexo) {
		this.deSexo = deSexo;
	}
	
}
