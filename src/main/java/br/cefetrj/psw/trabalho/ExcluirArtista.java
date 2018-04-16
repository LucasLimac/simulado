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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *Classe para excluir um Artista
 * 
 * @author Lucas Lima
 */
@WebServlet(name = "ExcluirArtista", urlPatterns = {"/ExcluirArtista"})
public class ExcluirArtista extends HttpServlet {

    
    /**
     * 
     * Metodo que vai excluir o artista e depois resetar os ids dos posteriores
     * 
     * @param req um objeto HttpServletRequest que contém a solicitação feita pelo cliente do servlet.
     * @param resp um objeto HttpServletResponse que contém a resposta que o servlet envia para o cliente
     * @throws ServletException se o pedido do POST não puder ser tratado
     * @throws IOException se um erro de entrada ou saída for detectado quando o servlet manipula o pedido
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Artista> a = (ArrayList<Artista>) req.getServletContext().getAttribute("a");
        int id = Integer.parseInt(req.getParameter("id"));
        /**
         * se existir artista na lista ele exclui o artista com o id desejado
         */
        if(a!=null){
            Artista x = a.get(id);      
            req.setAttribute("msgExcluir", (String)x.getArtista());
            for (int i = 0; i < a.size(); i++) {
                if (a.get(i).getId()==id) {
                    a.remove(id);
                    break;
                }
            }
            
            /**
             * resetando os ids após a remoção.
             */
            for (int i = id; i < a.size(); i++) {
                    a.get(i).setId((a.get(i).getId())-1);
                
            }
            
            
            req.getServletContext().setAttribute("a", a);
            req.getRequestDispatcher("/tabelaArtista.jsp").forward(req, resp);
        }
        else{
            req.getRequestDispatcher("/artista.jsp").forward(req, resp);
        }
        
    }

    

}
