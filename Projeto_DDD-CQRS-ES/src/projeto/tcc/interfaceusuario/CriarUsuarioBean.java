package projeto.tcc.interfaceusuario;

import java.io.Serializable;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import projeto.tcc.aplicacao.ServicoUsuario;
import projeto.tcc.comandos.CadastrarUsuarioComando;
import projeto.tcc.interfaceusuario.dto.CriarUsuarioDTO;

@ManagedBean
@ViewScoped
public class CriarUsuarioBean implements Serializable{
	
	private static final long serialVersionUID = 5029033187840615480L;
	@Inject 
	private CriarUsuarioDTO usuarioDTO;
	@Inject
	ServicoUsuario servicoUsuario;
	
	public String criarUsuario() throws Exception{
		UUID idOne = UUID.randomUUID();
		servicoUsuario.cadastrarUsuario(new CadastrarUsuarioComando(idOne, usuarioDTO));
		return null;
		
	}


	public CriarUsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}


	public void setUsuarioDTO(CriarUsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}
		
}
