package projeto.tcc.aplicacao;

import projeto.tcc.interfaceusuario.comandos.AdicionarMusicaComando;
import projeto.tcc.interfaceusuario.comandos.CriarPlayListComando;
import projeto.tcc.interfaceusuario.comandos.TocarMusicaComando;

public interface ServicoPlayListEscrita {

	void adicionarMusica(AdicionarMusicaComando adicionarMusicaComando);
	
	void criarPlayList(CriarPlayListComando criarPlayListComando);
	
	void tocarMusica(TocarMusicaComando adicionarMusicaComando);
	
}
