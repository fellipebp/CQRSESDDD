package projeto.tcc.infraestrutura.armazenamento.repositorio.impl;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import projeto.tcc.dominio.entidades.musica.Musica;
import projeto.tcc.infraestrutura.Conexao;
import projeto.tcc.infraestrutura.armazenamento.repositorio.RepositorioMusica;

import com.mysql.jdbc.PreparedStatement;

public class RepositorioMusicaImpl implements RepositorioMusica, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3647627396726747058L;

	@Override
	public List<Musica> listarTodasMusicas() {
		List<Musica> musicas = new ArrayList<>();

		URL resource = this.getClass().getClassLoader()
				.getResource("../../resources/music/");
		try {
			Musica musica;
			File diretorio = new File(resource.toURI());
			File[] listFiles = diretorio.listFiles();
			for (File file2 : listFiles) {
				musica = new Musica();
				musica.setNome(file2.getName());
				musica.setConteudo(Files.readAllBytes(Paths.get(file2
						.getAbsolutePath())));
				musicas.add(musica);
			}
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		return musicas;
	}

	@Override
	public Musica recuperaMusicaPeloNome(String nome) {
		URL resource = this.getClass().getClassLoader()
				.getResource("../../resources/music/" + nome);
		Musica musica = null;
		try {
			File arquivoMusica = new File(resource.toURI());
			musica = new Musica();
			musica.setNome(arquivoMusica.getName());
			musica.setConteudo(Files.readAllBytes(Paths.get(arquivoMusica
					.getAbsolutePath())));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		return musica;
	}

	public Set<Musica> recuperarMinhasMusicas(String aggregateID) {
		Set<Musica> minhasMusicas = new HashSet<Musica>();
		try {

			PreparedStatement pstmt = (PreparedStatement) Conexao
					.getConectionReader()
					.prepareStatement(
							"SELECT * from baseleitura.musicasusuario where aggregateId = ?");
			pstmt.setString(1, aggregateID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Musica musica = new Musica();
				musica.setNome(rs.getString("nome"));
					minhasMusicas.add(musica);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return minhasMusicas;
	}
}
