package projeto.tcc.dominio.enums;

public enum MusicasEnum {
	
	
	ORAPPAMEDEIXA(1,"O Rappa Me Deixa.mp3"),ORAPPAMINHAALMA(2,"O Rappa Minha Alma.mp3"),TESTE(3,"teste.mp3"),THEBEATLESHEYJUDES(4,"The_Beatles-Hey_Jude.mp3");
	
	
	private String nomeMusica;
	private int id;
	
	MusicasEnum(int id, String nomeMusica){
		this.id = id;
		this.nomeMusica = nomeMusica;
	}
	
	public static MusicasEnum getNome(String nome) {
	    for(MusicasEnum e : values()) {
	        if(e.nomeMusica.equalsIgnoreCase(nome)) return e;
	    }
	    return null;
	 }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	 

}
