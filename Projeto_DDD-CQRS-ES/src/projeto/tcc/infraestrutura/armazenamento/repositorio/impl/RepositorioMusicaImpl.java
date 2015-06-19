package projeto.tcc.infraestrutura.armazenamento.repositorio.impl;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import projeto.tcc.dominio.entidades.musica.Musica;
import projeto.tcc.infraestrutura.armazenamento.repositorio.RepositorioMusica;

public class RepositorioMusicaImpl implements RepositorioMusica, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3647627396726747058L;

	@Override
	public List<Musica> listarTodasMusicas() {
		List<Musica> musicas = new ArrayList<>();
		
		URL resource = this.getClass().getClassLoader().getResource("../../resources/music/");
		try {
			Musica musica;
			File diretorio = new File(resource.toURI());
			File[] listFiles = diretorio.listFiles();
			for (File file2 : listFiles) {
				musica = new Musica();
				musica.setNome(file2.getName());
				musica.setConteudo(Files.readAllBytes(Paths.get(file2.getAbsolutePath())));
				musicas.add(musica);
			}
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		return musicas;
	}

	@Override
	public Musica recuperaMusicaPeloNome(String nome) {
		URL resource = this.getClass().getClassLoader().getResource("../../resources/music/"+nome);
		Musica musica = null;
		try {
			File arquivoMusica = new File(resource.toURI());
			musica = new Musica();
			musica.setNome(arquivoMusica.getName());
			musica.setConteudo(Files.readAllBytes(Paths.get(arquivoMusica.getAbsolutePath())));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		return musica;
	}

}
