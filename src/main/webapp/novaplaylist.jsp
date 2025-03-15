<!DOCTYPE html>
<jsp:useBean id="Usuario" type="br.com.fabiobritto.musicplayer.model.Usuario" scope="session"></jsp:useBean>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Music Player - Fabio Britto</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

  </head>
  <body>
  
	  <div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<p id="creditos" align="right"> Developed by Fabio Britto</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12" align="center">
				<img src="images/logo-fabio-britto.jpg"  width="75%">
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
					<h3 class="text-center">
						Music Player - Sua Playlist na WEB
					</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<h4 class="text-center">
					Crie sua Playlist, ${Usuario.nomeUsuario}
				</h4>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-2">
					</div>
					<div class="col-md-8">
						<form role="form" action="efetivaplaylist" method="POST">
						
							<div class="form-group">		 
								<label for="playlistNome">
									Nome da Playlist
								</label>
								<input type="text" class="form-control" id="playlistNome" name="txtNomePlaylist"/>
							</div>
							
							<button type="submit" class="btn btn-primary">
								Criar Playlist
							</button>
							
						</form>
					</div>
					<div class="col-md-2">
					</div>
				</div>
			</div>
		</div>
	</div>

    

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
  </body>
</html>