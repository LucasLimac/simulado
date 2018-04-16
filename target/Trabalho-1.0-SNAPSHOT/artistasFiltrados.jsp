<%-- 
    Document   : artistasFiltrados
    Created on : 12/04/2018, 19:37:03
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
        <c:if test="${not empty msgFiltro}">
        <div class="alert alert-primary alert-dismissible mt-5 mr-5 ml-5">
            <a href="#" class="close fade in" data-dismiss="alert" aria-label="close">&times;</a>
            <strong>Parabéns!</strong> ${msgFiltro}
          </div>
        </c:if>
        
   
                                  
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
          <c:if test="${not empty filtro}">
                <c:forEach items="${ filtro}" var="b" >

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
                <input type="submit" class="btn btn-primary small col-sm-1" id="botao" value="Voltar"  onclick="location.href='http://localhost:8080/Trabalho/tabelaArtista.jsp'">
            </div>
        
              <p class="mt-5 mb-3 text-muted offset-md-5">&copy; Lucas Lima - 2018</p>

    </body>
</html>
