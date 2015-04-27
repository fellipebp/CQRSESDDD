package projeto.tcc.aplicacao;

import projeto.tcc.comandos.CadastrarUsuarioComando;
import projeto.tcc.comandos.FazerLoginComando;

public interface ServicoUsuario {

	public void logarUsuario(FazerLoginComando fazerLoginComando);
	public void cadastrarUsuario(CadastrarUsuarioComando cadastrarUsuarioComando);

}
