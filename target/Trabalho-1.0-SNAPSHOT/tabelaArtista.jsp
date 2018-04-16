<%-- 
    Document   : tabelaArtista
    Created on : 09/04/2018, 20:17:48
    Author     : Lucas Lima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.cefetrj.psw.trabalho.Artista"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabela Artista</title>
        
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    
       
    </head>
    <body>
        <c:if test="${not empty msgExcluir}">
        <div class="alert alert-danger alert-dismissible mt-5 mr-5 ml-5">
            <a href="#" class="close fade in" data-dismiss="alert" aria-label="close">&times;</a>
            Pronto, <strong>${msgExcluir}</strong> foi excluído com sucesso!
          </div>
        </c:if>
        
        <c:if test="${not empty msgCadastro}">
        <div class="alert alert-success alert-dismissible mt-5 mr-5 ml-5">
            <a href="#" class="close fade in" data-dismiss="alert" aria-label="close">&times;</a>
            Parabéns! <strong>${msgCadastro}</strong> foi cadastrado com sucesso!
          </div>
        </c:if>
        
        <form class="text-center mb-0 mt-5 table-info form-inline" action="FiltrarServlet" method="GET">
                <h1 class="h3 mb-2 mt-2 font-weight-light ml-5 mr-5" id="titulo">Filtro</h1>
                <label class="sr-only " >Nome Artístico: </label><input id="myInput" type="text" class="form-control-sm ml-5 mr-5 col-sm-2" placeholder="Pesquise pelo nome" name="nomeArtistico" value="${ param.nomeArtistico }" />
                <label class="sr-only">Estilo Musical:</label> <select class="form-control-sm col-sm-2 mr-5" name="estiloMusical">
					<option value="" selected>Pesquise por estilo</option> 
					<option value="Rock">Rock</option>
                                        <option value="Pop" >Pop</option>
					<option value="Outros">Outros</option>
				  </select>
                                  
                                  
                                    <input type="submit" class="btn btn-primary btn-block btn-sm col-sm-2" value="Filtrar" />

                                  
                                
	</form>
                                  
        <table id="myTable" class="table table-info table-bordered table-hover table-striped " >
        <thead>
          <tr>
            <th class="font-weight-bold" scope="col">ID</th>
            <th scope="col">Nome Artístico</th>
            <th scope="col">Banda</th>
            <th scope="col">Anos de Carreira</th>
            <th scope="col">Estilo Musical</th>
            <th scope="col">Excluir</th>
          </tr>
        </thead>
        <tbody>
          <c:if test="${not empty a}">
                <c:forEach items="${ a}" var="b" >

                <tr>
                    <td class="font-weight-bold" >${b.id}</td>
                    <td>${b.artista}</td>
                    <td>${b.banda}</td>
                    <td>${b.anos}</td>
                    <td>${b.estiloMusical}</td>
                    <td><a class="btn btn-sm btn-danger btn-block" href="ExcluirArtista?id=${b.id}" >Excluir</td>

                    
               



                </tr>
                </c:forEach>
           </c:if>
         
          
        </tbody>
        
      </table>
        <br>
            <div class=" col offset-md-5">
                <input type="submit" class="btn btn-primary small col-sm-1" id="botao" value="Novo Artista"  onclick="location.href='http://localhost:8080/Trabalho/artista.jsp'">
            </div>
        
              <p class="mt-5 mb-3 text-muted offset-md-5">&copy; Lucas Lima - 2018</p>

    </body>
</html>

