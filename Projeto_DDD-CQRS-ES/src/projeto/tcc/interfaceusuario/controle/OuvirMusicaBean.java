package projeto.tcc.interfaceusuario.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import projeto.tcc.aplicacao.ServicoUsuarioEscrita;
import projeto.tcc.dominio.entidades.musica.Musica;
import projeto.tcc.interfaceusuario.comandos.AdicionarMusicaComando;
import projeto.tcc.interfaceusuario.servico.ServicoMusicaFacade;

@Named
@ViewScoped
public class OuvirMusicaBean implements Serializable {

	private static final long serialVersionUID = -6673863557198240345L;
	@Inject
	private ServicoMusicaFacade servicoMusicaFacade;
	
	@Inject	private ServicoUsuarioEscrita servicoUsuarioEscrita;
	private List<Musica> listaMusicas;
	private List<String> musicas;
	private boolean tocando;
	private String nomeMusicaTemp;
	private HttpServletRequest request;

	@PostConstruct
	public void init() {
		request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
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
	
	public void adicionarMusica(Musica musica){
		try{
		Object aggregateIDObject = request.getSession().getAttribute("aggregateID");
		servicoUsuarioEscrita.adicionarMusica(new AdicionarMusicaComando((UUID.fromString(String.valueOf(aggregateIDObject))),musica.getNome()));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Música adicionada com sucesso"));
		}catch(Exception e){
				FacesContext fc = FacesContext.getCurrentInstance();
				fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Ocorreu um erro ao adicionar a musica", null));
		}
		
		
	}

	public List<Musica> getListaMusicas() {
		return listaMusicas;
	}

	public void setListaMusicas(List<Musica> listaMusicas) {
		this.listaMusicas = listaMusicas;
	}

}
