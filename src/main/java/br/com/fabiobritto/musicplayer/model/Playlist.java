package br.com.fabiobritto.musicplayer.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Playlist implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String titulo;
	
	private List<Musica> musicas;
	
	private Usuario usuario;
	
	public Playlist() {
	}
	
	public Playlist(Integer id, String titulo) {
		this.id = id;
		this.titulo = titulo;
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
	
	public List<Musica> getMusicas(){
		return musicas;
	}
	
	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		Playlist other = (Playlist) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Playlist [id=" + id + ", titulo=" + titulo + ", musicas=" + musicas + ", usuario=" + usuario + "]";
	}
}
