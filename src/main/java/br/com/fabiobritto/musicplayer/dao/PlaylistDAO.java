package br.com.fabiobritto.musicplayer.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fabiobritto.musicplayer.model.Playlist;

public class PlaylistDAO implements GenericDAO {
	
	private DataSource dataSource;
	
	public PlaylistDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(Object o) {
		try {
			if(o instanceof Playlist) {
				Playlist playlist = (Playlist) o;
				String SQL = "INSERT INTO tbplaylist VALUES (null, ?, ?)";
				PreparedStatement st = dataSource.getConnection().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
				
				st.setString(1, playlist.getTitulo());
				st.setInt(2, playlist.getUsuario().getId());
				
				int rowsAffected = st.executeUpdate();
				
				if(rowsAffected != 0) {
					ResultSet rs = st.getGeneratedKeys();
					
					if(rs.next()) {
						playlist.setId(rs.getInt(1));
					}
					rs.close();
				}
				st.close();
			}
			else {
				throw new RuntimeException("OBJETO INVÁLIDO");
			}
		}
		catch(SQLException e) {
			System.out.println("ERRO AO CRIAR PLAYLIST (DA0)");
		}
		
	}

	@Override
	public List<Object> read(Object o) {
		try {
			String SQL = "SELECT * FROM tbplaylist WHERE idUsuario = ?";
			Integer idUsuario = (Integer)o;
			PreparedStatement st = dataSource.getConnection().prepareStatement(SQL);
			st.setInt(1, idUsuario);
			ResultSet rs = st.executeQuery();
			
			List<Object> playlists = new ArrayList<>();
			while(rs.next()) {
				Playlist pl = new Playlist();
				pl.setId(rs.getInt("idPlaylist"));
				pl.setTitulo(rs.getString("titulo"));
				playlists.add(pl);	
			}
			rs.close();
			st.close();
			return playlists;
		}
		catch(SQLException e) {
			System.out.println("ERRO AO RECUPERAR PLAYLISTS: " + e.getMessage());
			return null;
		}
	}

	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub
		
	}

}
