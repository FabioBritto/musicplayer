package br.com.fabiobritto.musicplayer.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fabiobritto.musicplayer.model.Musica;
import br.com.fabiobritto.musicplayer.model.enums.Estilo;

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
		try {
			String SQL = "SELECT * FROM tbmusica ORDER BY titulo";
			PreparedStatement st = dataSource.getConnection().prepareStatement(SQL);
			ResultSet rs = st.executeQuery();
			List<Object> lista = new ArrayList<>();
			
			while(rs.next()) {
				Musica musica = new Musica();
				musica.setId(rs.getInt("idMusica"));
				musica.setTitulo(rs.getString("titulo"));
				musica.setArtista(rs.getString("artista"));
				musica.setAlbum(rs.getString("album"));
				musica.setEstilo(Estilo.valueOf(rs.getInt("estilo")));
				musica.setLinkMP3(rs.getString("linkMP3"));
				lista.add(musica);
			}
			return lista;
		}
		catch(SQLException e) {
			System.out.println("ERRO AO RECUPERAR ACERVO DE MÚSICAS: " + e.getMessage());
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
