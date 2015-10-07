package projeto.tcc.infraestrutura.armazenamento.repositorio;

import java.util.List;

import projeto.tcc.dominio.entidades.musica.PlayList;
import projeto.tcc.dominio.entidades.usuario.Usuario;

public interface RepositorioUsuario {
	
	Usuario getUsuario(String id); 
	
	Usuario getUsuarioPorCPF(String CPF); 
	
	Usuario getUsuarioPorAggregateID(String aggregateID);
	
	String existeUsuarioComEsseLogin(String login); 

	List<PlayList> getPlayListsPorEventos(String aggregateID); 
	
	List<PlayList> getListaPlayList(String aggregateID); 

	//PlayList getPlayList(String aggregateID);
	
	//	void processarUsuarioCadastradoEvento(UsuarioCadastradoEvento e) throws Exception;

}
