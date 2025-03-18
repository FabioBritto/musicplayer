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
import br.com.fabiobritto.musicplayer.dao.PlaylistDAO;

/**
 * Servlet implementation class IncluirNaPlaylistServlet
 */
@WebServlet("/incluirnaplaylist")
public class IncluirNaPlaylistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncluirNaPlaylistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "/result.jsp";
		DataSource dataSource = new DataSource();
		try {
			int idPlaylist = Integer.parseInt(request.getParameter("idPlaylist"));
			int idMusica = Integer.parseInt(request.getParameter("idMusica"));
			PlaylistDAO plDAO = new PlaylistDAO(dataSource);
	
			if(plDAO.createMusicaPlaylist(idPlaylist, idMusica)) {
				
			}
			else {
				request.setAttribute("strRESULT", "ERRO");
			}
			dataSource.getConnection().close();
			
			
			
			request.setAttribute("strRESULT", "OK");
		}
		catch(Exception e) {
			if(dataSource != null) {
				try {
					dataSource.getConnection().close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			System.out.println("ERRO AO INSERIR: " + e.getMessage());
			request.setAttribute("strRESULT", "ERRO");
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}
}
