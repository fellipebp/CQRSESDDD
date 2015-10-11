package projeto.tcc.interfaceusuario.controle;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import projeto.tcc.MusicasEnum;
import projeto.tcc.aplicacao.ServicoMusicaEscrita;
import projeto.tcc.aplicacao.ServicoMusicaLeitura;
import projeto.tcc.aplicacao.ServicoPlayListEscrita;
import projeto.tcc.aplicacao.ServicoPlayListLeitura;
import projeto.tcc.dominio.entidades.musica.Musica;
import projeto.tcc.dominio.entidades.musica.PlayList;
import projeto.tcc.interfaceusuario.comandos.AdicionarMusicaComando;
import projeto.tcc.interfaceusuario.comandos.AdicionarMusicaFavoritosComando;
import projeto.tcc.interfaceusuario.comandos.CriarPlayListComando;
import projeto.tcc.interfaceusuario.comandos.TocarMusicaComando;
import projeto.tcc.interfaceusuario.servico.ServicoMusicaFacade;

@Named
@ViewScoped
public class OuvirMusicaBean implements Serializable {

	private static final long serialVersionUID = -6673863557198240345L;
	@Inject
	private ServicoMusicaFacade servicoMusicaFacade;
	
	@Inject	private ServicoPlayListEscrita servicoPlayListEscrita;
	@Inject	private ServicoPlayListLeitura servicoPlayListLeitura;
	@Inject	private ServicoMusicaLeitura servicoMusicaLeitura;
	@Inject	private ServicoMusicaEscrita servicoMusicaEscrita;
	private List<Musica> listaMusicas;
	private Set<Musica> minhasMusicas;
	private Set<Musica> minhasMusicasFavorito;
	private Musica musicaSelecionada;
	private HttpSession sessao;
	private boolean todasMusicasStatus;
	private boolean minhasMusicasStatus;
	private boolean minhasMusicasPlayListStatus;
	private boolean minhasMusicasFavoritoStatus;
	private Object aggregateIDObject;
	private List<PlayList> minhasPlayLists;
	private String agregadoPlayListSelecionada;
	private String nomePlayList;
	

	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
	    sessao = (HttpSession) facesContext.getExternalContext().getSession(true);     
	    aggregateIDObject = sessao.getAttribute("aggregateID");
		setTodasMusicasStatus(false);
		setMinhasMusicasStatus(false);
		setMinhasMusicasPlayListStatus(false);
		setMinhasMusicasFavoritoStatus(false);
		
	}

	public String listarMusicas() {
		this.listaMusicas = servicoMusicaFacade.listarTodasMusicas();
		setTodasMusicasStatus(true);
		setMinhasMusicasStatus(false);
		setMinhasMusicasPlayListStatus(false);
		setMinhasMusicasFavoritoStatus(false);
		return null;

	}

	public void listarMinhasMusicasPlayList(String aggregateID) {
		minhasMusicas = servicoMusicaLeitura.listarMinhasMusicas(aggregateID);
		setTodasMusicasStatus(false);
		setMinhasMusicasStatus(false);
		setMinhasMusicasPlayListStatus(true);
		setMinhasMusicasFavoritoStatus(false);
	}
	
	public String listarMinhasPlayList() {
		minhasPlayLists = servicoPlayListLeitura.buscarPlayLists(aggregateIDObject.toString());
		setMinhasMusicasPlayListStatus(true);
		setTodasMusicasStatus(false);
		setMinhasMusicasStatus(false);
		setMinhasMusicasFavoritoStatus(false);
		return null;
	}
	
	public String listarMinhasMusicasFavorito(){
		minhasMusicasFavorito = servicoMusicaLeitura.listarMinhasMusicasFavorito(aggregateIDObject.toString());
		setTodasMusicasStatus(false);
		setMinhasMusicasStatus(false);
		setMinhasMusicasPlayListStatus(false);
		setMinhasMusicasFavoritoStatus(true);
		return null;
	}
	
	
	public void criarPlayList(){
		try{
		UUID agregado = UUID.randomUUID();
		servicoPlayListEscrita.criarPlayList(new CriarPlayListComando(UUID.fromString(String.valueOf(aggregateIDObject)),agregado, nomePlayList, minhasPlayLists));
		minhasPlayLists = servicoPlayListLeitura.buscarPlayListsPorEventos(aggregateIDObject.toString());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("PlayList adicionada com sucesso"));
		}catch (Exception e) {
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, e.getMessage(), null));
		} 
		
	}

	public void adicionarMusicaFavoritos(Musica musica) {
		try{
		
		servicoMusicaEscrita.adicionarMusicaFavoritos(new AdicionarMusicaFavoritosComando(UUID.fromString(String.valueOf(aggregateIDObject)), musica));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Música adicionada com sucesso"));
		}catch (Exception e) {
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, e.getMessage(), null));
		} 
	}

	public void alterarSenha() {

	}

	public void sair() {

	}

	
	public void playMusicaPlayList(){
		FacesContext context = FacesContext.getCurrentInstance();
	    Map<String,String> params = context.getExternalContext().getRequestParameterMap();
	    String[] parts = params.get("param1").split("/");
	    System.out.println("música tocando:"+ parts[6]);
		servicoPlayListEscrita.tocarMusica(new TocarMusicaComando((UUID.fromString(String.valueOf(aggregateIDObject))),parts[6]));
		
		
	}
	
	public void playMusicaPublica(Musica musica){
	    System.out.println("música tocando:"+ musica.getNome());
	    System.out.println("música tocando:"+ MusicasEnum.getNome(musica.getNome()));
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
	public void atualizarModalAdicionarMusica(Musica musica){
		try{
	
		minhasPlayLists = servicoPlayListLeitura.buscarPlayLists(aggregateIDObject.toString());
		this.musicaSelecionada = musica;
		
		}catch (Exception e) {
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, e.getMessage(), null));
		} 
		
		
	}
	
	public void adicionarMusica(){
		try{
		servicoPlayListEscrita.adicionarMusica(new AdicionarMusicaComando(UUID.fromString(agregadoPlayListSelecionada), musicaSelecionada));
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
		return agregadoPlayListSelecionada;
	}

	public void setAgregadoPlayList(String agregadoPlayList) {
		this.agregadoPlayListSelecionada = agregadoPlayList;
	}

	public boolean isMinhasMusicasPlayListStatus() {
		return minhasMusicasPlayListStatus;
	}

	public void setMinhasMusicasPlayListStatus(boolean minhasMusicasPlayListStatus) {
		this.minhasMusicasPlayListStatus = minhasMusicasPlayListStatus;
	}

	public String getNomePlayList() {
		return nomePlayList;
	}

	public void setNomePlayList(String nomePlayList) {
		this.nomePlayList = nomePlayList;
	}

	public Set<Musica> getMinhasMusicasFavorito() {
		return minhasMusicasFavorito;
	}

	public void setMinhasMusicasFavorito(Set<Musica> minhasMusicasFavorito) {
		this.minhasMusicasFavorito = minhasMusicasFavorito;
	}

	public boolean isMinhasMusicasFavoritoStatus() {
		return minhasMusicasFavoritoStatus;
	}

	public void setMinhasMusicasFavoritoStatus(boolean minhasMusicasFavoritoStatus) {
		this.minhasMusicasFavoritoStatus = minhasMusicasFavoritoStatus;
	}

}