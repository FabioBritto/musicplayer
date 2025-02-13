package br.com.fabiobritto.musicplayer.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.fabiobritto.musicplayer.model.Musica;
import br.com.fabiobritto.musicplayer.model.Playlist;
import br.com.fabiobritto.musicplayer.model.Usuario;
import br.com.fabiobritto.musicplayer.model.enums.Estilo;

public class UsuarioDAO implements GenericDAO {

	public void create(Object o) {
		
	}
	
	public List<Object> read(Object o) {
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setNomeUsuario("Fabio Britto");
		usuario.setEmail("fabio.tritono@gmail.com");
		usuario.setSenha("fabiobritto");
		
		List<Playlist> playlists = new ArrayList<>();
		Playlist playlistA = new Playlist();
		playlistA.setId(1);
		playlistA.setTitulo("Música Clássica");
		
		List<Musica> musicasPLA = new ArrayList<>();
		Musica musicaA = new Musica();
		musicaA.setId(1);
		musicaA.setTitulo("Clair de Lune");
		musicaA.setArtista("Claude Debussy");
		musicaA.setAlbum("As mais mais da França");
		musicaA.setEstilo(Estilo.CLASSICO);
		musicaA.setLinkMP3("musicas/clairDeLune.mp3");
		
		musicasPLA.add(musicaA);
		playlistA.setMusicas(musicasPLA);
		playlists.add(playlistA);
		usuario.setPlaylist(playlists);
		
		List<Object> resultadoBusca = new ArrayList<>();
		
		resultadoBusca.add(usuario);
		
		return resultadoBusca;
	}
	
	public void update(Object o) {
		
	}
	
	public void delete(Object o) {
		
	}
	
}
