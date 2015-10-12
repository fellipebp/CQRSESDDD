package projeto.tcc.dominio.enums;

public enum MusicasEnum {
	
	
	ORAPPAMEDEIXA("O Rappa Me Deixa.mp3"),ORAPPAMINHAALMA("O Rappa Minha Alma.mp3"),TESTE("teste.mp3"),THEBEATLESHEYJUDES("The_Beatles-Hey_Jude.mp3");
	
	
	private String nomeMusica;
	
	MusicasEnum(String nomeMusica){
		this.nomeMusica = nomeMusica;
	}
	
	public static MusicasEnum getNome(String nome) {
	    for(MusicasEnum e : values()) {
	        if(e.nomeMusica.equalsIgnoreCase(nome)) return e;
	    }
	    return null;
	 }
	 

}
