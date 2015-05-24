package projeto.tcc.aplicacao;

import projeto.tcc.interfaceusuario.comandos.CadastrarUsuarioComando;
import projeto.tcc.interfaceusuario.comandos.FazerLoginComando;

public interface ServicoUsuarioEscrita {
	
	 void logarUsuario(FazerLoginComando fazerLoginComando)  throws Exception;
	 void cadastrarUsuario(CadastrarUsuarioComando cadastrarUsuarioComando);

}
