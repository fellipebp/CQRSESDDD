package projeto.tcc.interfaceusuario.controle;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import projeto.tcc.aplicacao.ServicoMusicaLeitura;
import projeto.tcc.aplicacao.ServicoUsuarioEscrita;
import projeto.tcc.dominio.entidades.musica.Musica;
import projeto.tcc.interfaceusuario.comandos.AdicionarMusicaComando;
import projeto.tcc.interfaceusuario.comandos.TocarMusicaComando;
import projeto.tcc.interfaceusuario.servico.ServicoMusicaFacade;

@Named
@ViewScoped
public class OuvirMusicaBean implements Serializable {

	private static final long serialVersionUID = -6673863557198240345L;
	@Inject
	private ServicoMusicaFacade servicoMusicaFacade;
	
	@Inject	private ServicoUsuarioEscrita servicoUsuarioEscrita;
	@Inject	private ServicoMusicaLeitura servicoMusicaLeitura;
	private List<Musica> listaMusicas;
	private Set<Musica> minhasMusicas;
	private boolean tocando;
	private String nomeMusicaTemp;
	private HttpSession sessao;
	

	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
	    sessao = (HttpSession) facesContext.getExternalContext().getSession(true);       
		tocando = false;
		nomeMusicaTemp = "";
	}

	public void listarMusicas() {
		this.listaMusicas = servicoMusicaFacade.listarTodasMusicas();

	}

	public void listarMinhasMusicas() {
		Object aggregateIDObject = sessao.getAttribute("aggregateID");
		minhasMusicas = servicoMusicaLeitura.listarMinhasMusicas(String.valueOf(aggregateIDObject));
	}

	public void listarFavoritos() {
	}

	public void alterarSenha() {

	}

	public void sair() {

	}

	public void tocarMusica(Musica musica) {
		Object aggregateIDObject = sessao.getAttribute("aggregateID");
		if (musica.getNome().equals(nomeMusicaTemp) && tocando == true) {
			System.out.println("musica pausada: " + musica.getNome());
			this.tocando = false;
		} else {
			this.tocando = true;
			System.out.println("musica tocando: " + musica.getNome());
			servicoUsuarioEscrita.tocarMusica(new TocarMusicaComando((UUID.fromString(String.valueOf(aggregateIDObject))),musica.getNome()));
			this.nomeMusicaTemp = musica.getNome();
		}
	}
	
	/**
	 * @param musica
	 */
	public void adicionarMusica(Musica musica){
		try{
		Object aggregateIDObject = sessao.getAttribute("aggregateID");
		if(!minhasMusicas.contains(musica)){
		servicoUsuarioEscrita.adicionarMusica(new AdicionarMusicaComando((UUID.fromString(String.valueOf(aggregateIDObject))),musica.getNome()));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Música adicionada com sucesso"));
		}
		else
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Você já possui essa música"));
		
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

	public Set<Musica> getMinhasMusicas() {
		return minhasMusicas;
	}

	public void setMinhasMusicas(Set<Musica> minhasMusicas) {
		this.minhasMusicas = minhasMusicas;
	}

}
