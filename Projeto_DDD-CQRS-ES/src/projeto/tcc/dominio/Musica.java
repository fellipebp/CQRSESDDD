package projeto.tcc.dominio;

import projeto.tcc.eventos.musica.MusicaTocadaEvento;


public class Musica {
	
	private String nome;
	private Long duracao;
	private byte[] conteudo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getDuracao() {
		return duracao;
	}
	public void setDuracao(Long duracao) {
		this.duracao = duracao;
	}
	public byte[] getConteudo() {
		return conteudo;
	}
	public void setConteudo(byte[] conteudo) {
		this.conteudo = conteudo;
	}
	
	public void tocar(MusicaTocadaEvento musicaTocadaEvento){
		//reproduzir bytes
		//musicaTocadaEvento.getMusica();
	}
	
}
