<!DOCTYPE html>
<jsp:useBean id="Usuario" type="br.com.fabiobritto.musicplayer.model.Usuario" scope="session"/>
<jsp:useBean id="Playlist" type="br.com.fabiobritto.musicplayer.model.Playlist" scope="session"/>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Music Player - Fabio Britto DEV</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

  </head>
  <body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<p id="creditos" align="right">Developed by Fabio Britto</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12" align="center">
				<img src="images/logo-fabio-britto.jpg" width="75%">
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<h3 class="text-center">Music Player - Sua Playlist na WEB</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<h4 class="text-center">Detalhes da Playlist</h4>
			</div>
		</div>

		<div class="row" id="menu">
			<div class="col-md-2">
			&nbsp;
			</div>
			<div class="col-md-8">
				<ul class="nav">
					<li class="nav-item" >
						<a class="nav-link" href="#">Nova Playlist              </a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="playlists">Minhas Playlists              </a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">Upload de Músicas              </a>
					</li>
				</ul>
			</div>
			<div class="col-md-2">
				&nbsp;
			</div>
		</div>
		
		<div class="row">
			<div col="col-md-2">&nbsp;</div>
			<div col="col-md-8">
				<h4>${Playlist.titulo}</h4>
			</div>
			<div col="col-md-2">&nbsp;</div>
		</div>
		
		<c:forEach var="Musica" items="${Playlist.musicas}">
			<div class="row">
				<div col="col-md-2">&nbsp;</div>
				<div col="col-md-8">
				
					<span class="tituloMusica">
						${Musica.titulo}
					</span>
					<span class="artista">
						${Musica.artista} (Album: ${Musica.album})
					</span>
					
				</div>
				<div col="col-md-2">&nbsp;</div>
				
			</div>
		</c:forEach>

	</div>


	<script src="js/jquery.min.js"></script>
	  <script src="js/bootstrap.min.js"></script>
	  <script src="js/scripts.js"></script>
  </body>
</html>