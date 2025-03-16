package br.com.fabiobritto.musicplayer.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabiobritto.musicplayer.dao.DataSource;
import br.com.fabiobritto.musicplayer.dao.MusicaDAO;
import br.com.fabiobritto.musicplayer.model.Musica;
import br.com.fabiobritto.musicplayer.model.enums.Estilo;

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
				String artista = request.getParameter("txtArtista");
				String nomeMusica = request.getParameter("txtNomeMusica");
				String album = request.getParameter("txtAlbum");
				Estilo estilo = Estilo.valueOf(Integer.parseInt(request.getParameter("txtEstilo")));
				
				InputStream arquivoOriginal = request.getPart("fileMP3").getInputStream();
				String nomeArquivoOriginal = request.getPart("fileMP3").getSubmittedFileName();
				String nomeArquivo = getServletContext().getRealPath("/") + "/musicas/" + request.getPart("fileMP3").getSubmittedFileName();
				FileOutputStream arquivoMP3 = new FileOutputStream(nomeArquivo);
				
				byte b[] = new byte[1024];
				while(arquivoOriginal.available() > 0) {
					arquivoOriginal.read(b);
					arquivoMP3.write(b);
				}
				arquivoOriginal.close();
				arquivoMP3.close();
				
				Musica musica = new Musica();
				musica.setAlbum(album);
				musica.setTitulo(nomeMusica);
				musica.setArtista(artista);
				musica.setEstilo(estilo);
				musica.setLinkMP3("musicas/" + nomeArquivoOriginal);
				
				DataSource dataSource = new DataSource();
				
				MusicaDAO musicaDAO = new MusicaDAO(dataSource);
				musicaDAO.create(musica);
				dataSource.getConnection().close();
				
				pagina = "/myaccount.jsp";
				
			}
			catch(Exception e) {
				pagina = "/error.jsp";
				e.printStackTrace();
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
