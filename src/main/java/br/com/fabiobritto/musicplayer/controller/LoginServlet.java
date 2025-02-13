package br.com.fabiobritto.musicplayer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabiobritto.musicplayer.dao.UsuarioDAO;

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
		String email = request.getParameter("txtEmail");
		String senha = request.getParameter("txtSenha");
		String pagina;
		
		List<Object> resultado;
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		resultado = usuarioDAO.read(null);
		
		if(resultado.size() > 0) {
			
			request.getSession().setAttribute("Usuario", resultado.get(0));
			
			pagina = "/myaccount.jsp";
		}
		else {
			pagina = "/error.jsp";
			request.setAttribute("erroSTR", "Email / Senha não encontrados!");
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
		
	}

}
