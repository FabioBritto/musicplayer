package br.com.fabiobritto.musicplayer.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabiobritto.musicplayer.dao.DataSource;
import br.com.fabiobritto.musicplayer.dao.UsuarioDAO;
import br.com.fabiobritto.musicplayer.model.Usuario;

@WebServlet("/efetivacadastro")
public class EfetivaCadastroServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public EfetivaCadastroServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pagina = "/error.jsp";
		
		String nome = request.getParameter("txtNome");
		String email = request.getParameter("txtEmail");
		String senha = request.getParameter("txtSenha");
		
		Usuario usuario = new Usuario();
		usuario.setNomeUsuario(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		
		DataSource dataSource;
		UsuarioDAO usuarioDAO;
		
		try {
			dataSource = new DataSource();
			usuarioDAO = new UsuarioDAO(dataSource);
			usuarioDAO.create(usuario);
			
			dataSource.getConnection().close();
			pagina = "/myaccount.jsp";
		}
		catch(SQLException e) {
			System.out.println("Erro ao fechar conexão: " + e.getMessage());
			request.setAttribute("erroMSG", "Error ao criar nova conta de usuário!");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		if(usuario.getId() != 0) {
			request.getSession().setAttribute("Usuario", usuario);
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

}