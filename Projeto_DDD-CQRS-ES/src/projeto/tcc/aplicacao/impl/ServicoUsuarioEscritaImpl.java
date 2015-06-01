package projeto.tcc.aplicacao.impl;

import java.io.Serializable;

import projeto.tcc.aplicacao.ServicoUsuarioEscrita;
import projeto.tcc.dominio.Usuario;
import projeto.tcc.interfaceusuario.comandos.CadastrarUsuarioComando;
import projeto.tcc.interfaceusuario.comandos.EditarUsuarioComando;
import projeto.tcc.interfaceusuario.comandos.FazerLoginComando;

public class ServicoUsuarioEscritaImpl implements ServicoUsuarioEscrita, Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7673302045438349809L;
	private Usuario usuario;

	@Override
	public String logarUsuario(FazerLoginComando fazerLoginComando) throws Exception{
		usuario = new Usuario();
		try {
			return usuario.logar(fazerLoginComando);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void cadastrarUsuario(CadastrarUsuarioComando cadastrarUsuarioComando) {
		usuario = new Usuario();
		try {
			usuario.criarCadastro(cadastrarUsuarioComando);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void editarInformacoesUsuario(EditarUsuarioComando editarUsuarioComando) {
		usuario = new Usuario();
		try {
			usuario.editarInformacoes(editarUsuarioComando);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
