package projeto.tcc.interfaceusuario.controle;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import projeto.tcc.aplicacao.ServicoUsuarioEscrita;
import projeto.tcc.aplicacao.ServicoUsuarioLeitura;
import projeto.tcc.dominio.entidades.musica.Musica;
import projeto.tcc.interfaceusuario.servico.impl.ServicoMusicaFacadeImpl;

@Named
@ConversationScoped
public class OuvirMusicaBean implements Serializable {

	private static final long serialVersionUID = -6673863557198240345L;
	//@Inject 
	//private ServicoMusicaFacade  servicoMusicaFacade;
	
	private ServicoMusicaFacadeImpl servicoMusicaFacade = new ServicoMusicaFacadeImpl();
	private List<Musica> listaMusicas;
	
	@PostConstruct
	public void init(){
		listarMusicas();
	}
	
	public void listarMusicas() {
		listaMusicas = servicoMusicaFacade.listarTodasMusicas();
	}
	
	public void listarFavoritos() {
	}
	
	
	public void alterarSenha(){
		
	}
	
	public void sair(){
		
	}

	public List<Musica> getListaMusicas() {
		return listaMusicas;
	}

	public void setListaMusicas(List<Musica> listaMusicas) {
		this.listaMusicas = listaMusicas;
	}

}
