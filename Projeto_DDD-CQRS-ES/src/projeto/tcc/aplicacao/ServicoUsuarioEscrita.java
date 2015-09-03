package projeto.tcc.aplicacao;

import projeto.tcc.interfaceusuario.comandos.CadastrarUsuarioComando;
import projeto.tcc.interfaceusuario.comandos.EditarUsuarioComando;

public interface ServicoUsuarioEscrita {

//	String logarUsuario(FazerLoginComando fazerLoginComando) throws Exception;
	
	//outros métodos omitidos
	void cadastrarUsuario(CadastrarUsuarioComando cadastrarUsuarioComando);

	void editarInformacoesUsuario(EditarUsuarioComando editarUsuarioComando);
	
//	boolean deslogarUsuario(DeslogarComando deslogarComando);

}
