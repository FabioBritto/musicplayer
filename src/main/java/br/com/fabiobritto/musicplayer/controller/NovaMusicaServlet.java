package br.com.fabiobritto.musicplayer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/novamusica")
public class NovaMusicaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NovaMusicaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "/error.jsp";
		if(request.getSession().getAttribute("Usuario") != null) {
			pagina = "/novamusica.jsp";	
		}
		else {
			request.setAttribute("erroSTR", "ERRO: USUÁRIO NÃO CONECTADO");
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

}
