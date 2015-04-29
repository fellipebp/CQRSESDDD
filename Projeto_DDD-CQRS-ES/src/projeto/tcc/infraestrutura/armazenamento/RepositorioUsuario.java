package projeto.tcc.infraestrutura.armazenamento;

import projeto.tcc.dominio.Usuario;
import projeto.tcc.eventos.usuario.UsuarioCadastradoEvento;

public interface RepositorioUsuario {
	
	Usuario getUsuario(String id); 
	
	void processarUsuarioCadastradoEvento(UsuarioCadastradoEvento e) throws Exception;

}
