package br.com.fabiobritto.musicplayer.controller;

import java.io.IOException;
import java.util.ArrayList;

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

@WebServlet("/efetivaplaylist")
public class EfetivaPlaylistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EfetivaPlaylistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "/index.html";
		try {
			Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
			if(usuario != null) {
				Playlist novaPlaylist = new Playlist();
				novaPlaylist.setTitulo(request.getParameter("txtNomePlaylist"));
				novaPlaylist.setUsuario(usuario);
				DataSource dataSource = new DataSource();
				PlaylistDAO playlistDAO = new PlaylistDAO(dataSource);
				playlistDAO.create(novaPlaylist);
				dataSource.getConnection().close();
				if(usuario.getPlaylists() == null) {
					usuario.setPlaylist(new ArrayList<Playlist>());
				}
				usuario.getPlaylists().add(novaPlaylist);
				request.getSession().setAttribute("Usuario", usuario);
				pagina = "/myplaylists.jsp";	
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("erroSTR", "ERRO GRAVE AO CRIAR PLAYLIST");
			pagina = "/error.jsp";
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

}
