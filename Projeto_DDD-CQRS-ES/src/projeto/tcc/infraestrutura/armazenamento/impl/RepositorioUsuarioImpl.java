package projeto.tcc.infraestrutura.armazenamento.impl;


import projeto.tcc.dominio.Usuario;
import projeto.tcc.eventos.usuario.UsuarioCadastradoEvento;
import projeto.tcc.infraestrutura.Conexao;
import projeto.tcc.infraestrutura.armazenamento.RepositorioUsuario;

public class RepositorioUsuarioImpl implements RepositorioUsuario{

	private Conexao conexao = new Conexao();
	
	@Override
	public Usuario getUsuario(String id) {
		return null;
	}
	
	
	public void processarUsuarioCadastradoEvento(UsuarioCadastradoEvento e) throws Exception{
		conexao.getConectionEventSource();
		conexao.salvarEvento(e);
	}


}
