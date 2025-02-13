package br.com.fabiobritto.musicplayer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabiobritto.musicplayer.dao.DataSource;
import br.com.fabiobritto.musicplayer.dao.UsuarioDAO;
import br.com.fabiobritto.musicplayer.model.Usuario;

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
		Usuario usuarioIncompleto = new Usuario();
		usuarioIncompleto.setEmail(email);
		usuarioIncompleto.setSenha(senha);
		
		DataSource ds;
		
		String pagina ="/error.jsp";
		
		try {
			ds = new DataSource();
			UsuarioDAO usuarioDAO = new UsuarioDAO(ds);
			List<Object> resultado = usuarioDAO.read(usuarioIncompleto);
			
			if(resultado != null && resultado.size() > 0) {
				request.getSession().setAttribute("Usuario", resultado.get(0));
				pagina = "/myaccount.jsp";
			}
			else {
				request.setAttribute("erroSTR", "Usuario / Senha Inválidos!");
			}
			ds.getConnection().close();
		}
		catch(Exception e) {
			request.setAttribute("erroSTR", "Erro ao recuperar!");
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}
}
