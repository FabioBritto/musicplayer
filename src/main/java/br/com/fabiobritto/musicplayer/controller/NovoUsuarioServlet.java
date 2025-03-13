package br.com.fabiobritto.musicplayer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novousuario")
public class NovoUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NovoUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/novousuario.jsp");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/novousuario.jsp");
		System.out.println("Estou no NovoUsuarioServlet");
		dispatcher.forward(request, response);
		
		//response.sendRedirect(request.getContextPath() + "/novousuario.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/novousuario.jsp");
		System.out.println("Estou no NovoUsuarioServlet");
		dispatcher.forward(request, response);
		
		//response.sendRedirect(request.getContextPath() + "/novousuario.jsp");
	}
}
