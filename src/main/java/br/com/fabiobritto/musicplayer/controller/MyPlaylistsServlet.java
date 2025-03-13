package br.com.fabiobritto.musicplayer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabiobritto.musicplayer.model.Usuario;

/**
 * Servlet implementation class MyPlaylistsServer
 */
@WebServlet("/myplaylists")
public class MyPlaylistsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPlaylistsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paginaRetorno;
		
		Usuario usuario = (Usuario) (request.getSession().getAttribute("Usuario"));
		
		if(usuario == null) {
			paginaRetorno = "/index.html";
		}
		else {
			paginaRetorno = "/myplaylists.jsp";
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaRetorno);
		dispatcher.forward(request, response);
	}
}
