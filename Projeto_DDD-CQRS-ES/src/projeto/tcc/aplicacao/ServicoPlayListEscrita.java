package projeto.tcc.aplicacao;

import java.util.Set;

import projeto.tcc.dominio.entidades.musica.Musica;
import projeto.tcc.interfaceusuario.comandos.AdicionarMusicaComando;
import projeto.tcc.interfaceusuario.comandos.TocarMusicaComando;

public interface ServicoPlayListEscrita {

	void adicionarMusica(AdicionarMusicaComando adicionarMusicaComando, Set<Musica> minhasMusicas, Musica musica);
	
	void tocarMusica(TocarMusicaComando adicionarMusicaComando);
	
}
