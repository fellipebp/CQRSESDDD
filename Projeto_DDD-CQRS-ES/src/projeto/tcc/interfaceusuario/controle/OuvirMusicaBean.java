package projeto.tcc.interfaceusuario.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projeto.tcc.dominio.entidades.musica.Musica;
import projeto.tcc.interfaceusuario.servico.ServicoMusicaFacade;

@Named
@ViewScoped
public class OuvirMusicaBean implements Serializable {

	private static final long serialVersionUID = -6673863557198240345L;
	@Inject
	private ServicoMusicaFacade servicoMusicaFacade;
	private List<Musica> listaMusicas;
	private List<String> musicas;
	private boolean tocando;
	private String nomeMusicaTemp;

	@PostConstruct
	public void init() {
		tocando = false;
		nomeMusicaTemp = "";
	}

	public void listarMusicas() {
		this.listaMusicas = servicoMusicaFacade.listarTodasMusicas();

	}

	public void listarMinhasMusicas() {
		// temp
		musicas = new ArrayList<String>();
		musicas.add("O Rappa Me Deixa.mp3");
		musicas.add("O Rappa Minha Alma.mp3");
	}

	public void listarFavoritos() {
	}

	public void alterarSenha() {

	}

	public void sair() {

	}

	public void tocarMusica(Musica musica) {
		if (musica.getNome().equals(nomeMusicaTemp) && tocando == true) {
			System.out.println("musica pausada: " + musica.getNome());
			this.tocando = false;
		} else {
			this.tocando = true;
			System.out.println("musica tocando: " + musica.getNome());
			this.nomeMusicaTemp = musica.getNome();
		}
	}

	public List<Musica> getListaMusicas() {
		return listaMusicas;
	}

	public void setListaMusicas(List<Musica> listaMusicas) {
		this.listaMusicas = listaMusicas;
	}

}
