package projeto.tcc.infraestrutura.armazenamento;

import projeto.tcc.dominio.Usuario;

public interface RepositorioUsuario {
	
	Usuario getUsuario(String id); 

}
