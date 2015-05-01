package projeto.tcc.infraestrutura.armazenamento;

import projeto.tcc.dominio.Usuario;
import projeto.tcc.dominio.eventos.usuario.UsuarioCadastradoEvento;

public interface RepositorioUsuario {
	
	Usuario getUsuario(String id); 
	
	Usuario getUsuarioPorCPF(String CPF); 
	
	Usuario getUsuarioPorLogin(String login); 
	
	void processarUsuarioCadastradoEvento(UsuarioCadastradoEvento e) throws Exception;

}
