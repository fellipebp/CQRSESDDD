package projeto.tcc.aplicacao.impl;

import java.io.Serializable;

import projeto.tcc.aplicacao.ServicoSegurancaEscrita;
import projeto.tcc.dominio.entidades.seguranca.Seguranca;
import projeto.tcc.interfaceusuario.comandos.DeslogarComando;
import projeto.tcc.interfaceusuario.comandos.FazerLoginComando;

public class ServicoSegurancaEscritaImpl implements ServicoSegurancaEscrita, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Seguranca seguranca;

	@Override
	public String logarUsuario(FazerLoginComando fazerLoginComando)
			throws Exception {
		seguranca = new Seguranca();
		try {
			String logar = seguranca.logar(fazerLoginComando);
			return logar;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	@Override
	public boolean deslogarUsuario(DeslogarComando deslogarComando) {
		seguranca = new Seguranca();
		try {
			return seguranca.deslogar(deslogarComando);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	
	@Override
	public String existeUsuarioComEsseLogin(FazerLoginComando fazerLoginComando)
			throws Exception {
		seguranca = new Seguranca();
		try {
			String logar = seguranca.existeUsuarioComEsseLogin(fazerLoginComando);
			//necessario buscar versao do evento relacionado ao login aqui???
			return logar;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
