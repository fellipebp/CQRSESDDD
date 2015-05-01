package projeto.tcc.aplicacao.impl;

import java.io.Serializable;

import projeto.tcc.aplicacao.ServicoUsuario;
import projeto.tcc.dominio.Usuario;
import projeto.tcc.interfaceusuario.comandos.CadastrarUsuarioComando;
import projeto.tcc.interfaceusuario.comandos.FazerLoginComando;

public class ServicoUsuarioImpl implements ServicoUsuario, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario;

	@Override
	public void logarUsuario(FazerLoginComando fazerLoginComando) {
		usuario = new Usuario();
		try {
			usuario.logar(fazerLoginComando);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void cadastrarUsuario(CadastrarUsuarioComando cadastrarUsuarioComando) {
		usuario = new Usuario();
		try {
			usuario.cuidarCadastro(cadastrarUsuarioComando);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
