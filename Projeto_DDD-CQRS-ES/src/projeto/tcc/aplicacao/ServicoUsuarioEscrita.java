package projeto.tcc.aplicacao;

import projeto.tcc.interfaceusuario.comandos.CadastrarUsuarioComando;
import projeto.tcc.interfaceusuario.comandos.EditarUsuarioComando;
import projeto.tcc.interfaceusuario.comandos.FazerLoginComando;

public interface ServicoUsuarioEscrita {

	String logarUsuario(FazerLoginComando fazerLoginComando) throws Exception;
	
	//outros métodos omitidos
	void cadastrarUsuario(CadastrarUsuarioComando cadastrarUsuarioComando);

	void editarInformacoesUsuario(EditarUsuarioComando editarUsuarioComando);

}
