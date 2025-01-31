package br.com.fabiobritto.musicplayer.model;

import java.io.Serializable;
import java.util.Objects;

import br.com.fabiobritto.musicplayer.model.enums.Estilo;

public class Musica implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String titulo;
	private String artista;
	private String album;
	private Estilo estilo;
	private String linkMP3;
	
	public Musica() {
	}
	
	public Musica(Integer id, String titulo, String artista, String album, Estilo estilo, String linkMP3) {
		this.id = id;
		this.titulo = titulo;
		this.artista = artista;
		this.album = album;
		this.estilo = estilo;
		this.linkMP3 = linkMP3;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public Estilo getEstilo() {
		return estilo;
	}

	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}

	public String getLinkMP3() {
		return linkMP3;
	}

	public void setLinkMP3(String linkMP3) {
		this.linkMP3 = linkMP3;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Musica other = (Musica) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Musica [id=" + id + ", titulo=" + titulo + ", artista=" + artista + ", album=" + album + ", estilo="
				+ estilo + ", linkMP3=" + linkMP3 + "]";
	}
}
