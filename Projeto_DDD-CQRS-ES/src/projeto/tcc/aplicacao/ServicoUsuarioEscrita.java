package projeto.tcc.aplicacao;

import projeto.tcc.interfaceusuario.comandos.AdicionarMusicaComando;
import projeto.tcc.interfaceusuario.comandos.CadastrarUsuarioComando;
import projeto.tcc.interfaceusuario.comandos.DeslogarComando;
import projeto.tcc.interfaceusuario.comandos.EditarUsuarioComando;
import projeto.tcc.interfaceusuario.comandos.FazerLoginComando;
import projeto.tcc.interfaceusuario.comandos.TocarMusicaComando;

public interface ServicoUsuarioEscrita {

	String logarUsuario(FazerLoginComando fazerLoginComando) throws Exception;
	
	//outros métodos omitidos
	void cadastrarUsuario(CadastrarUsuarioComando cadastrarUsuarioComando);

	void editarInformacoesUsuario(EditarUsuarioComando editarUsuarioComando);
	
	void adicionarMusica(AdicionarMusicaComando adicionarMusicaComando);
	
	void tocarMusica(TocarMusicaComando adicionarMusicaComando);

	boolean deslogarUsuario(DeslogarComando deslogarComando);

}
