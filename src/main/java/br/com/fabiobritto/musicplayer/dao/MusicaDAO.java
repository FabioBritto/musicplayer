package br.com.fabiobritto.musicplayer.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.com.fabiobritto.musicplayer.model.Musica;

public class MusicaDAO implements GenericDAO {

	private DataSource dataSource;
	
	public MusicaDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void create(Object o) {
		try {
			if(o instanceof Musica) {
				Musica musica = (Musica)o;
				String SQL = "INSERT INTO tbmusica VALUES (null, ?, ?, ?, ?, ?)";
				PreparedStatement st = dataSource.getConnection().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
				System.out.println(musica);
				st.setString(1, musica.getTitulo());
				st.setString(2, musica.getArtista());
				st.setString(3, musica.getAlbum());
				st.setInt(4, musica.getEstilo().getValue());
				st.setString(5, musica.getLinkMP3());
				
				int rowsAffected = st.executeUpdate();
				
				if(rowsAffected > 0) {
					ResultSet rs = st.getGeneratedKeys();
					
					if(rs.next()) {
						musica.setId(rs.getInt(1));
					}
					rs.close();
				}
				st.close();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Object> read(Object o) {
		// TODO Auto-generated method stub
		return null;
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
