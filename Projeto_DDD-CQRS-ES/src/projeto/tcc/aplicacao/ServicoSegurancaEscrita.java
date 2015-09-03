package projeto.tcc.aplicacao;

import projeto.tcc.interfaceusuario.comandos.DeslogarComando;
import projeto.tcc.interfaceusuario.comandos.FazerLoginComando;

public interface ServicoSegurancaEscrita {
	
	void logarUsuario(FazerLoginComando fazerLoginComando) throws Exception;
	void deslogarUsuario(DeslogarComando deslogarComando) throws Exception;
	String existeUsuarioComEsseLogin(FazerLoginComando fazerLoginComando)throws Exception;
}
