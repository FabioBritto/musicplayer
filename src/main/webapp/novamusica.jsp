<!DOCTYPE html>
<jsp:useBean id="Usuario"
	type="br.com.fabiobritto.musicplayer.model.Usuario" scope="session"></jsp:useBean>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Music Player - Fabio Britto</title>

<meta name="description"
	content="Source code generated using layoutit.com">
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
				<h4 class="text-center">Faça o Upload de sua música,
					${Usuario.nomeUsuario}</h4>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-8">
						<form role="form" action="uploadmusica" method="POST" enctype="multipart/form-data">

							<div class="form-group">
								<label for="artista"> Artista </label> <input type="text"
									class="form-control" id="artista" name="txtArtista" />
							</div>

							<div class="form-group">
								<label for="nomeMusica"> Nome da Música </label> <input
									type="text" class="form-control" id="nomemusica" name="txtNomeMusica" />
							</div>

							<div class="form-group">
								<label for="album"> Álbum </label> <input type="text"
									class="form-control" id="album" name="txtAlbum" />
							</div>

							<div class="form-group">
								<label for="estilo"> Estilo </label> <select id="estilo" name="txtEstilo">
									<option value="1">POP</option>
									<option value="2">GOSPEL</option>
									<option value="3">ROCK</option>
									<option value="4">CLÁSSICO</option>
									<option value="5">SERTANEJO</option>
									<option value="6">COUNTRY</option>
								</select>
							</div>

							<div class="form-group">
								<label for="fileMP3"> Arquivo MP3 para Upload </label>
								<input type="file" class="form-control-file" id="FileMP3" name="fileMP3"/>
							</div>

							<button type="submit" class="btn btn-primary">Upload de Música</button>

						</form>
						<br></br>
					</div>
					<div class="col-md-2"></div>
				</div>
			</div>
		</div>
	</div>



	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>