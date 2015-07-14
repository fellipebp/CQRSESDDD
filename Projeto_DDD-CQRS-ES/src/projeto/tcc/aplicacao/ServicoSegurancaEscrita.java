package projeto.tcc.aplicacao;

import projeto.tcc.interfaceusuario.comandos.DeslogarComando;
import projeto.tcc.interfaceusuario.comandos.FazerLoginComando;

public interface ServicoSegurancaEscrita {
	
	String logarUsuario(FazerLoginComando fazerLoginComando) throws Exception;
	boolean deslogarUsuario(DeslogarComando deslogarComando) throws Exception;
}
