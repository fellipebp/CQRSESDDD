package projeto.tcc.aplicacao;

import projeto.tcc.interfaceusuario.comandos.CadastrarUsuarioComando;
import projeto.tcc.interfaceusuario.comandos.FazerLoginComando;

public interface ServicoUsuario {

	public void logarUsuario(FazerLoginComando fazerLoginComando)  throws Exception;
	public void cadastrarUsuario(CadastrarUsuarioComando cadastrarUsuarioComando);

}
