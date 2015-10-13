package projeto.tcc.infraestrutura.armazenamento.repositorio;

import java.util.List;

import projeto.tcc.dominio.entidades.musica.PlayList;
import projeto.tcc.dominio.entidades.usuario.Usuario;

public interface RepositorioUsuario {
	
	Usuario getUsuarioPorAggregateID(String aggregateID);
	
	//outros m�todos omitidos
	
	Usuario getUsuario(String id); 
	
	Usuario getUsuarioPorCPF(String CPF); 
	
	String existeUsuarioComEsseLogin(String login); 

	List<PlayList> getPlayListsPorEventos(String aggregateID); 
	
	List<PlayList> getListaPlayList(String aggregateID); 

}
