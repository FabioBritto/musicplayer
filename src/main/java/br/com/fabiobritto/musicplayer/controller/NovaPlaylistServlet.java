package br.com.fabiobritto.musicplayer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabiobritto.musicplayer.model.Usuario;


@WebServlet("/novaplaylist")
public class NovaPlaylistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NovaPlaylistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
		String pagina = "/index.html";
		if(usuario != null) {
			pagina = "/novaplaylist.jsp";
		}
		else {
			
		}
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

}
