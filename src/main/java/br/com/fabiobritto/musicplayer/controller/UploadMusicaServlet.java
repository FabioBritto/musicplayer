package br.com.fabiobritto.musicplayer.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/uploadmusica")
@MultipartConfig(maxFileSize=20848820, maxRequestSize=418018841)
public class UploadMusicaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UploadMusicaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "/error.jsp";
		if(request.getSession().getAttribute("Usuario") != null) {
			pagina = "/novamusica.jsp";
			try {
				Collection<Part> partes = request.getParts();
				for(Part p : partes) {
					System.out.println("Formulário contém: " + p.getName());
				}
				
			}
			catch(Exception e) {
				System.out.println("Exception");
				request.setAttribute("erroSTR", "ERRO: UPLOAD FALHOU");
			}
		}
		else {
			request.setAttribute("erroSTR", "ERRO: USUÁRIO NÃO CONECTADO");
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

}
