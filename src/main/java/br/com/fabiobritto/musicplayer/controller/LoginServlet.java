package br.com.fabiobritto.musicplayer.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       


	/**
	 * Como para este Servlet os dados serão recebidos via FORMULÁRIO,
	 * o método utilizado será o doPost
	 * 
	 * Através do método POST, quando é enviado um FORMULÁRIO, é mandado:
	 * <Chave,Valor>. Exemplo: <txtEmail, "fabio.tritono@gmail.com">
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("RECEBIDO EMAIL: " + request.getParameter("txtEmail"));
		System.out.println("RECEBIDO SENHA: " + request.getParameter("txtSenha"));
		
	}

}
