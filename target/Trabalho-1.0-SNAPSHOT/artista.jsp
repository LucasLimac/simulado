<%-- 
    Document   : artista
    Created on : 09/04/2018, 19:18:23
    Author     : Lucas Lima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="selects" uri="WEB-INF/estilomusical.tld"%>


<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Portal do Artista </title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">
    <style>
        #inputEstilo{
            height:45px;      
        }
        
    </style>
    
  </head>
  
  <body class="text-center">
      
            
      
      <form class="form-signin" action="ArtistaServidor" method="POST">
      <img class="mb-4 mt-5" src="http://www.autismacceptancemonth.com/wp-content/uploads/logos-media-downloads/ASAN-logo-icon.png" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal" id="titulo">Portal do Artista</h1>
      
      <label for="inputArtista" class="sr-only">Nome Artístico</label>
      <input type="text" id="inputArtista" class="form-control" name="artista" value="${artista}" placeholder="Nome do artista" required autofocus>
      
      <label for="inputBanda" class="sr-only">Banda</label>
      <input type="text" id="inputBanda" class="form-control" name="banda" value="${banda}" placeholder="Banda do artista" > 
      
      <label for="inputAnos" class="sr-only has-sucess">Anos de carreira</label>
      <input type="text" id="inputAnos" class="form-control" name="anos" value="${anos}" placeholder="Anos de carreira do artista" required> 
      
      <label for="inputEstilo" class="sr-only m">Estilo</label>
      
      <selects:SelectArtistaTag estiloMusical="${estiloMusical}"/> <br> ${erroEstiloMusical}
      
      
      <div class="checkbox mb-3">
          <br>
                <h8>${erroArtista}</h8>
                <h8>${erroBanda}</h8>
                <h8>${erroAnos}</h8>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit" data-toggle="tooltip" title="Clique para enviar">Enviar</button>
      <p class="mt-5 mb-3 text-muted">&copy; Lucas Lima - 2018</p>
    </form>
  </body>
</html>
