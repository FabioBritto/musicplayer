package br.com.fabiobritto.musicplayer.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nomeUsuario;
	private String email;
	private String senha;
	
	private List<Playlist> playlists;
	
	public Usuario() {
	}
	
	public Usuario(Integer id, String nomeUsuario, String email, String senha) {
		this.id = id;
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public List<Playlist> getPlaylists(){
		return playlists;
	}
	
	public void setPlaylist(List<Playlist> playlist) {
		this.playlists = playlist;
	}
	
	public void addPlaylists(Playlist playlist) {
		playlists.add(playlist);
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
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nomeUsuario=" + nomeUsuario + ", email=" + email + ", senha=" + senha + "]";
	}
}
