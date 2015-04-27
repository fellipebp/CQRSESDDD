package projeto.tcc.aplicacao.impl;

import projeto.tcc.aplicacao.ServicoUsuario;
import projeto.tcc.comandos.CadastrarUsuarioComando;
import projeto.tcc.comandos.FazerLoginComando;
import projeto.tcc.dominio.Usuario;

public class ServicoUsuarioImpl implements ServicoUsuario {

	private Usuario usuario;

	@Override
	public void logarUsuario(FazerLoginComando fazerLoginComando) {
	
		usuario = new Usuario();
		usuario.logar(fazerLoginComando);
	}

	@Override
	public void cadastrarUsuario(CadastrarUsuarioComando cadastrarUsuarioComando) {
		usuario = new Usuario();
		usuario.cuidarCadastro(cadastrarUsuarioComando);
		
	}
}
