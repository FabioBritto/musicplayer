package br.com.fabiobritto.musicplayer.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabiobritto.musicplayer.dao.DataSource;
import br.com.fabiobritto.musicplayer.dao.PlaylistDAO;
import br.com.fabiobritto.musicplayer.model.Playlist;
import br.com.fabiobritto.musicplayer.model.Usuario;


@WebServlet("/playlists")
public class PlaylistsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PlaylistsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "/index.html";
		try {
			Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
			if(usuario.getPlaylists() == null) {
				DataSource dataSource = new DataSource();
				PlaylistDAO plDAO = new PlaylistDAO(dataSource);
				List<Object> lista = plDAO.read(usuario.getId());
				dataSource.getConnection().close();
				if(lista != null) {
					List<Playlist> myPlaylists = new ArrayList<>();
					for(Object o : lista) {
						Playlist novaPl = (Playlist)o;
						novaPl.setUsuario(usuario);
						myPlaylists.add(novaPl);	
					}
					usuario.setPlaylist(myPlaylists);
				}
			}
			request.getSession().setAttribute("Usuario", usuario);
			pagina = "/myplaylists.jsp";
		}
		catch(Exception e) {
			System.out.println("Erro ao recuperar playlists (servlet): " + e.getMessage());
		}
		
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

}
