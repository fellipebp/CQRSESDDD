package projeto.tcc.infraestrutura.armazenamento.repositorio;

import projeto.tcc.dominio.entidades.usuario.Usuario;
import projeto.tcc.dominio.eventos.usuario.UsuarioCadastradoEvento;

public interface RepositorioUsuario {
	
	Usuario getUsuario(String id); 
	
	Usuario getUsuarioPorCPF(String CPF); 
	
	Usuario getUsuarioPorAggregateID(String aggregateID);
	
	String existeUsuarioComEsseLogin(String login); 
	
	String getAggregatePlayList(String aggregateID); 
	
	void processarUsuarioCadastradoEvento(UsuarioCadastradoEvento e) throws Exception;

}
