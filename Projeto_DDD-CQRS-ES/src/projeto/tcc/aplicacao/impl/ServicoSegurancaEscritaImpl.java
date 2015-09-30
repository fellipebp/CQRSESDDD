//package projeto.tcc.aplicacao.impl;
//
//import java.io.Serializable;
//
//import projeto.tcc.aplicacao.ServicoSegurancaEscrita;
//import projeto.tcc.aplicacao.comandos.ProcessadorCadastrarUsuarioComando;
//import projeto.tcc.aplicacao.comandos.ProcessadorLoginUsuarioComando;
//import projeto.tcc.aplicacao.comandos.ProcessadorLogoffUsuarioComando;
//import projeto.tcc.dominio.entidades.seguranca.Seguranca;
//import projeto.tcc.interfaceusuario.comandos.DeslogarComando;
//import projeto.tcc.interfaceusuario.comandos.FazerLoginComando;
//
//public class ServicoSegurancaEscritaImpl implements ServicoSegurancaEscrita, Serializable {
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	private Seguranca seguranca;
//
//	@Override
//	public void logarUsuario(FazerLoginComando fazerLoginComando)
//			throws Exception {
//		try {
//			new ProcessadorLoginUsuarioComando().execute(fazerLoginComando);
//		} catch (Exception e) {
//			throw new RuntimeException(e.getMessage());
//		}
//	}
//	
//	@Override
//	public void deslogarUsuario(DeslogarComando deslogarComando) {
//		try {
//			new ProcessadorLogoffUsuarioComando().execute(deslogarComando);
//		} catch (Exception e) {
//			throw new RuntimeException(e.getMessage());
//		}
//	}
//	
//	
//	@Override
//	public String existeUsuarioComEsseLogin(FazerLoginComando fazerLoginComando)
//			throws Exception {
//		seguranca = new Seguranca();
//		try {
//			return seguranca.existeUsuarioComEsseLogin(fazerLoginComando);
//		} catch (Exception e) {
//			throw new RuntimeException(e.getMessage());
//		}
//	}
//
//}
