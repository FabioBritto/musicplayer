package br.com.fabiobritto.musicplayer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabiobritto.musicplayer.dao.DataSource;
import br.com.fabiobritto.musicplayer.dao.PlaylistDAO;
import br.com.fabiobritto.musicplayer.model.Playlist;

@WebServlet("/playlistdetails")
public class PlaylistDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PlaylistDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "/error.jsp";
		
		if(request.getSession().getAttribute("Usuario") != null) {
			try {
				DataSource dataSource = new DataSource();
				PlaylistDAO playlistDAO = new PlaylistDAO(dataSource);
				Playlist playlist = playlistDAO.readPlaylistDetailsById(Integer.parseInt(request.getParameter("id")));
				if(playlist != null) {
					request.getSession().setAttribute("Playlist", playlist);
					pagina = "/playlistdetails.jsp";
				}
				else {
					request.setAttribute("erroSTR", "ERRO AO RECUPERAR DETALHES DA PLAYLIST(SERVLET)");
				}
			}
			catch(Exception e) {
				request.setAttribute("erroSTR", "ERRO INESPERADO");
			}
		}
		else {
			request.setAttribute("erroSTR", "VOCÊ NÃO ESTÁ LOGADO");
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}
}
