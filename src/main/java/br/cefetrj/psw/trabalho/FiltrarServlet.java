/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetrj.psw.trabalho;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *Classe para Filtrar um Artista
 * 
 * @author Lucas Lima
 */
@WebServlet(name = "FiltrarServlet", urlPatterns = {"/FiltrarServlet"})
public class FiltrarServlet extends HttpServlet {
    /**
     * 
     * Metodo que vai filtrar o artista desejado pelo nome ou estilo e despachar para a tabela filtrada
     * 
     * @param request um objeto HttpServletRequest que contém a solicitação feita pelo cliente do servlet.
     * @param response um objeto HttpServletResponse que contém a resposta que o servlet envia para o cliente
     * @throws ServletException se o pedido do POST não puder ser tratado
     * @throws IOException se um erro de entrada ou saída for detectado quando o servlet manipula o pedido
     */
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeArtistico = (String)request.getParameter("nomeArtistico");
		String estiloMusical = (String)request.getParameter("estiloMusical");
		
		ArrayList<Artista> artistas = (ArrayList<Artista>) request.getServletContext().getAttribute("a");
		
		List<Artista> artistasFiltrados = new ArrayList<Artista>();
                
                
		
		if(artistas != null){
                    for (int i = 0; i < artistas.size(); i++) {
                                    if(artistas.get(i).getArtista().trim().equals(nomeArtistico))  {
                                        artistasFiltrados.add(artistas.get(i));
                                    }
                                    if(artistas.get(i).getEstiloMusical().trim().equals(estiloMusical)){
                                        artistasFiltrados.add(artistas.get(i));
                                    }
                        
                    }
			
			
		}
		
		request.getServletContext().setAttribute("filtro", artistasFiltrados);
                request.setAttribute("msgFiltro", "A tabela foi filtrada!");
		
		request.getRequestDispatcher("/artistasFiltrados.jsp").forward(request, response);
		
	}
    

}
