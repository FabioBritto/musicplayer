package br.com.fabiobritto.musicplayer.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fabiobritto.musicplayer.model.Usuario;

public class UsuarioDAO implements GenericDAO {
	
	private DataSource dataSource;
	
	public UsuarioDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void create(Object o) {
		try {
			if(o instanceof Usuario) {
				Usuario usuario = (Usuario)o;
				String SQL = "INSERT INTO tbUsuario VALUES (null, ?, ?, ?)";
				PreparedStatement st = dataSource.getConnection().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
				st.setString(2, usuario.getNomeUsuario());
				st.setString(3, usuario.getEmail());
				st.setString(4, usuario.getSenha());
				
				int rowsAffected = st.executeUpdate();
				
				if(rowsAffected != 0) {
					ResultSet rs = st.getGeneratedKeys();
					
					if(rs.next()) {
						usuario.setId(rs.getInt(1));
					}
					rs.close();
				}
				st.close();

			}
			else {
				throw new RuntimeException("OBJETO INVÁLIDO!");
			}
		}
		catch(SQLException e) {
			System.out.println("ERRO AO CRIAR USUARIO: " + e.getMessage());
		}
	}
	
	/*
	 * É como se eu passasse como parâmetro, um usuário incompleto. Portanto, ao confirmar
	 * que se trata de uma instância de USUARIO, eu o trato como um usuarioIncompleto para
	 * fazer a busca de todos os USUÁRIOS que atendam os requisitos
	 */
	public List<Object> read(Object o) {
		try {
			if(o instanceof Usuario) {
				Usuario usuarioIncompleto = (Usuario)o;
				String SQL = "SELECT * FROM tbUsuario WHERE email = ? AND senha = ?";
				PreparedStatement st = dataSource.getConnection().prepareStatement(SQL);
				st.setString(1, usuarioIncompleto.getEmail());
				st.setString(2, usuarioIncompleto.getSenha());
				ResultSet rs = st.executeQuery();
				
				List<Object> resultado = new ArrayList<>();
				
				while(rs.next()) {
					Usuario usuario = new Usuario();
					usuario.setId(rs.getInt("idUsuario"));
					usuario.setNomeUsuario(rs.getString("nomeUsuario"));
					usuario.setEmail(rs.getString("email"));
					usuario.setSenha(rs.getString("senha"));
					
					resultado.add(usuario);
				}
				
				st.close();
				rs.close();
				
				return resultado;
			}
			else {
				throw new RuntimeException("OBJETO INVÁLIDO!");
			}
		}
		catch(SQLException e) {
			System.out.println("ERRO AO RECUPERAR USUARIO: " + e.getMessage());
		}
		return null;
	}
	
	public void update(Object o) {
		
	}
	
	public void delete(Object o) {
		
	}
	
}
