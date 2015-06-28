package projeto.tcc.aplicacao.impl;

import java.io.Serializable;

import projeto.tcc.aplicacao.ServicoUsuarioEscrita;
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
	public String logarUsuario(FazerLoginComando fazerLoginComando) throws Exception{
		usuario = new Usuario();
		try {
			return usuario.logar(fazerLoginComando);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	@Override
	public boolean deslogarUsuario(DeslogarComando deslogarComando) {
		usuario = new Usuario();
		try {
			return usuario.deslogar(deslogarComando);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}


	//outros métodos omitidos
	
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

	@Override
	public void adicionarMusica(AdicionarMusicaComando adicionarMusicaComando) {
		usuario = new Usuario();
		try {
			usuario.adicionarMusica(adicionarMusicaComando);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void tocarMusica(TocarMusicaComando tocarMusicaComando) {
		usuario = new Usuario();
		try {
			usuario.tocarMusica(tocarMusicaComando);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}
