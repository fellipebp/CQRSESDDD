package projeto.tcc.aplicacao;

import projeto.tcc.interfaceusuario.comandos.AlterarSenhaComando;
import projeto.tcc.interfaceusuario.comandos.CadastrarUsuarioComando;
import projeto.tcc.interfaceusuario.comandos.DeslogarComando;
import projeto.tcc.interfaceusuario.comandos.EditarUsuarioComando;
import projeto.tcc.interfaceusuario.comandos.FazerLoginComando;

public interface ServicoUsuarioEscrita {

	
	void cadastrarUsuario(CadastrarUsuarioComando cadastrarUsuarioComando);

	void editarInformacoesUsuario(EditarUsuarioComando editarUsuarioComando);
	
	void logarUsuario(FazerLoginComando fazerLoginComando) throws Exception;
	String existeUsuarioComEsseLogin(FazerLoginComando fazerLoginComando)throws Exception;
	
	void alterarSenha(AlterarSenhaComando alterarSenhaComando) throws Exception;

}
