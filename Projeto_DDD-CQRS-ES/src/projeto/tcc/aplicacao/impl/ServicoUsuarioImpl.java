package projeto.tcc.aplicacao.impl;

import java.util.Date;

import projeto.tcc.aplicacao.ServicoUsuario;
import projeto.tcc.dominio.Usuario;
import projeto.tcc.eventos.usuario.UsuarioLogadoEvento;

public class ServicoUsuarioImpl implements ServicoUsuario {

	@Override
	public void logar(Usuario usuario) {
		new UsuarioLogadoEvento(usuario, new Date()).Processar();
	}
}
