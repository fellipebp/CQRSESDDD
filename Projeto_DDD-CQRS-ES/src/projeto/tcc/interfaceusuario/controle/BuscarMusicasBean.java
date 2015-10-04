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

import projeto.tcc.aplicacao.ServicoPlayListEscrita;
import projeto.tcc.aplicacao.ServicoPlayListLeitura;
import projeto.tcc.dominio.entidades.musica.Musica;
import projeto.tcc.dominio.entidades.musica.PlayList;
import projeto.tcc.interfaceusuario.comandos.AdicionarMusicaComando;
import projeto.tcc.interfaceusuario.comandos.TocarMusicaComando;
import projeto.tcc.interfaceusuario.servico.ServicoMusicaFacade;

@Named
@ViewScoped
public class BuscarMusicasBean implements Serializable {

	private static final long serialVersionUID = -6673863557198240345L;
	@Inject
	private ServicoMusicaFacade servicoMusicaFacade;
	
	@Inject	private ServicoPlayListEscrita servicoPlayListEscrita;
	@Inject	private ServicoPlayListLeitura servicoPlayListLeitura;
	private List<Musica> listaMusicas;
	private Set<Musica> minhasMusicas;
	private Musica musicaSelecionada;
	private HttpSession sessao;
	private boolean todasMusicasStatus;
	private boolean minhasMusicasStatus;
	private Object aggregateIDObject;
	private List<PlayList> minhasPlayLists;
	private String agregadoPlayList;
	

	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
	    sessao = (HttpSession) facesContext.getExternalContext().getSession(true);     
	    aggregateIDObject = sessao.getAttribute("aggregateID");
//	    minhasPlayLists = servicoPlayListLeitura.buscarAgregadoPlayList(aggregateIDObject.toString());//Ainda sendo trabalhado
//		minhasMusicas = servicoMusicaLeitura.listarMinhasMusicas(String.valueOf(agregadoPlayList));
		setTodasMusicasStatus(false);
		setMinhasMusicasStatus(false);
		
	}

	public String listarMusicas() {
		this.listaMusicas = servicoMusicaFacade.listarTodasMusicas();
		setTodasMusicasStatus(true);
		setMinhasMusicasStatus(false);
		return null;

	}

	public String listarMinhasMusicas() {
//		minhasMusicas = servicoMusicaLeitura.listarMinhasMusicas(String.valueOf(agregadoPlayList));
		setTodasMusicasStatus(false);
		setMinhasMusicasStatus(true);
		return null;
	}

	public void listarFavoritos() {
	}

	public void alterarSenha() {

	}

	public void sair() {

	}

	
	public void playMusica(Musica musica){
		
		System.out.println("musica tocando: " + musica.getNome());
		servicoPlayListEscrita.tocarMusica(new TocarMusicaComando((UUID.fromString(String.valueOf(aggregateIDObject))),musica.getNome()));
		
		
	}
	
	
	public void pauseMusica(Musica musica){
		
		System.out.println("musica pausada: " + musica.getNome());
	}
	
//	public void tocarMusica(Musica musica) {
//		if (musica.getNome().equals(nomeMusicaTemp) && tocando == true) {
//			System.out.println("musica pausada: " + musica.getNome());
//			this.tocando = false;
//		} else {
//			this.tocando = true;
//			System.out.println("musica tocando: " + musica.getNome());
//			servicoPlayListEscrita.tocarMusica(new TocarMusicaComando((UUID.fromString(String.valueOf(aggregateIDObject))),musica.getNome()));
//			this.nomeMusicaTemp = musica.getNome();
//		}
//	}
	
	/**
	 * @param musica
	 */
	public void atualizarModal(Musica musica){
		try{
	
		minhasPlayLists = servicoPlayListLeitura.buscarAgregadoPlayList(aggregateIDObject.toString());
		this.musicaSelecionada = musica;
		
		}catch (Exception e) {
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, e.getMessage(), null));
		} 
		
		
	}
	
	public void adicionarMusica(){
		try{
		servicoPlayListEscrita.adicionarMusica(new AdicionarMusicaComando(UUID.fromString(agregadoPlayList), musicaSelecionada));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Música adicionada com sucesso"));
			
		}catch (Exception e) {
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, e.getMessage(), null));
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

	public boolean isTodasMusicasStatus() {
		return todasMusicasStatus;
	}

	public void setTodasMusicasStatus(boolean todasMusicasStatus) {
		this.todasMusicasStatus = todasMusicasStatus;
	}

	public boolean isMinhasMusicasStatus() {
		return minhasMusicasStatus;
	}

	public void setMinhasMusicasStatus(boolean minhasMusicasStatus) {
		this.minhasMusicasStatus = minhasMusicasStatus;
	}


	public List<PlayList> getMinhasPlayLists() {
		return minhasPlayLists;
	}

	public void setMinhasPlayLists(List<PlayList> minhasPlayLists) {
		this.minhasPlayLists = minhasPlayLists;
	}

	public Musica getMusica() {
		return musicaSelecionada;
	}

	public void setMusica(Musica musica) {
		this.musicaSelecionada = musica;
	}

	public String getAgregadoPlayList() {
		return agregadoPlayList;
	}

	public void setAgregadoPlayList(String agregadoPlayList) {
		this.agregadoPlayList = agregadoPlayList;
	}

}