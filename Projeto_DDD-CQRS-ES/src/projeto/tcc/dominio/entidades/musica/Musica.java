package projeto.tcc.dominio.entidades.musica;

import java.io.Serializable;

import projeto.tcc.dominio.eventos.musica.MusicaTocadaEvento;



public class Musica implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1151302597338295392L;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Musica other = (Musica) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
}
