package projeto.tcc.interfaceusuario;

import java.io.Serializable;
import java.util.UUID;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import projeto.tcc.aplicacao.ServicoUsuario;
import projeto.tcc.comandos.CadastrarUsuarioComando;

@ManagedBean
@ViewScoped
public class CriarUsuarioBean implements Serializable{
	
	private static final long serialVersionUID = 5029033187840615480L;
	private String login;
	private String senha;
	@Inject
	ServicoUsuario servicoUsuario;
	
	
	public String criarUsuario() throws Exception{
		
		UUID idOne = UUID.randomUUID();

		servicoUsuario.cadastrarUsuario(new CadastrarUsuarioComando(idOne, login, senha));
		return null;
		
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
		
}
