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
import br.com.fabiobritto.musicplayer.dao.MusicaDAO;
import br.com.fabiobritto.musicplayer.model.Usuario;

@WebServlet("/recuperamusicas")
public class RecuperaMusicasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RecuperaMusicasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "/error.jsp";
		try {
			Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
			if(usuario != null) {
				DataSource dataSource = new DataSource();
				MusicaDAO musicaDAO = new MusicaDAO(dataSource);
				List<Object> lista = musicaDAO.read(null);
				if(lista != null) {
					String idPlaylist = request.getParameter("idplaylist");
					request.setAttribute("idPlaylist", idPlaylist);
					request.setAttribute("ListaMusicas", lista);
					pagina = "/minhasmusicas.jsp";
				}
				else {
					request.setAttribute("erroSTR", "ERRO AO RECUPERAR MÚSICA DO BANCO DE DADOS");
					
				}
				dataSource.getConnection().close();
			}
			else {
				request.setAttribute("erroSTR", "ERRO! USUÁRIO NÃO LOGADO");
			}
		}
		catch(Exception e) {
			System.out.println("ERRO AO MONTAR PÁGINA DE MÚSICAS " + e.getMessage());
			request.setAttribute("erroSTR", "ERRO AO MONTAR PÁGINA DE MÚSICAS");
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

}
