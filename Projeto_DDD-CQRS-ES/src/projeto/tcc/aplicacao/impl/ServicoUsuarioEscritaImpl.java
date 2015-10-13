package projeto.tcc.aplicacao.impl;

import java.io.Serializable;
import java.util.Set;

import projeto.tcc.aplicacao.ServicoUsuarioEscrita;
import projeto.tcc.aplicacao.comandos.processador.ProcessadorCadastrarUsuarioComando;
import projeto.tcc.aplicacao.comandos.processador.ProcessadorEditarUsuarioComando;
import projeto.tcc.aplicacao.comandos.processador.ProcessadorLoginUsuarioComando;
import projeto.tcc.dominio.entidades.musica.Musica;
import projeto.tcc.dominio.entidades.usuario.Usuario;
import projeto.tcc.interfaceusuario.comandos.AdicionarMusicaComando;
import projeto.tcc.interfaceusuario.comandos.CadastrarUsuarioComando;
import projeto.tcc.interfaceusuario.comandos.DeslogarComando;
import projeto.tcc.interfaceusuario.comandos.EditarUsuarioComando;
import projeto.tcc.interfaceusuario.comandos.FazerLoginComando;
import projeto.tcc.interfaceusuario.comandos.TocarMusicaComando;

public class ServicoUsuarioEscritaImpl implements ServicoUsuarioEscrita, Serializable{
	
	private static final long serialVersionUID = -7673302045438349809L;
	private Usuario usuario;

	
	@Override
	public void cadastrarUsuario(CadastrarUsuarioComando cadastrarUsuarioComando) {
		try {
			new ProcessadorCadastrarUsuarioComando().execute(cadastrarUsuarioComando);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}

	@Override
	public void editarInformacoesUsuario(EditarUsuarioComando editarUsuarioComando) {
		try {
			new ProcessadorEditarUsuarioComando().execute(editarUsuarioComando);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	@Override
	public void logarUsuario(FazerLoginComando fazerLoginComando)
			throws Exception {
		try {
			new ProcessadorLoginUsuarioComando().execute(fazerLoginComando);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	
	@Override
	public String existeUsuarioComEsseLogin(FazerLoginComando fazerLoginComando)
			throws Exception {
		usuario = new Usuario();
		try {
			return usuario.existeUsuarioComEsseLogin(fazerLoginComando);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
