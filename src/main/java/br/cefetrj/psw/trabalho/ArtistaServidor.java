/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetrj.psw.trabalho;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *Classe que vai receber os parametros do Artista, verificar se são válidos, criar um lista e adicionar o artista na lista
 * 
 * @author Lucas Lima
 * version 1.0
 */
@WebServlet(name = "ArtistaServidor", urlPatterns = {"/ArtistaServidor"})
public class ArtistaServidor extends HttpServlet {

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    try{
                   
        String artista = (String)req.getParameter("artista");
        String banda = (String)req.getParameter("banda");
        String anos = (String)req.getParameter("anos"); 
        String estiloMusical = (String)req.getParameter("estiloMusical");
        
        
  
    
           /**
            * boolean para ver se o form tá preenchido corretamente
            */
           boolean valido = true;
           

           
           /**
            * if e else para verificar se o nome do artista está até 30 caracteres
            * se não estiver set uma mensagem de erro do Artista
            */
           
           if(artista.length() <= 30 ){
                    
               req.setAttribute("artista", artista);
               
           }
           
            else{
                req.setAttribute("erroArtista", "O nome do artista deve ter até 30 caracteres:");
                valido = false;
            } 
           /**
            * if e else para verificar se a banda está com tamanho de até 40 caracteres
            * se não estiver set uma mensagem de erro da Banda
            */
           
           if( banda.length() <= 40){
                    
               req.setAttribute("banda", banda);
               
           }
           
            else{
                req.setAttribute("artista", artista);
                req.setAttribute("erroBanda", "O nome da Banda deve ser até 40 caracteres:");
                valido = false;
            } 
           
           /**
            * if e else para verificar se o Anos de Carreira está até 99 anos
            * se não estiver set uma mensagem de erro dos anos de carreira
            */
           try{
                if( Integer.parseInt(anos) <= 99 ){

                    req.setAttribute("anos", anos);

                }

                 else{
                     req.setAttribute("artista", artista);
                     req.setAttribute("erroAnos", "Os anos de carreira deve ser até 99 anos:");
                     valido = false;
                 } 
           }catch(NumberFormatException e){
                     req.setAttribute("erroAnos", "Os anos de carreira deve ser números:");
                     valido = false;
           }
           
            /**
            * if e else para verificar se o estiloMusical está vazio
            * se estiver set uma mensagem de erro do Estilo
            */
           
           
           if( estiloMusical == "" ){
               
                req.setAttribute("artista", artista);
                 req.setAttribute("erroEstiloMusical", "O estilo deve ser selecionado:");
                 valido = false;
      
               
           }
           
            else{
                    req.setAttribute("estiloMusical", estiloMusical);

            } 
           
           
           
           
           /**
            * se o form for valido ele adiciona na lista
            * se não volta para o formulario
            */
           
           
           
           if(valido){
                ArrayList<Artista> a = new ArrayList<>();
                Artista ator = new Artista(artista, banda, anos, estiloMusical);
                
                if (req.getServletContext().getAttribute("a")==null) {
                    ator.setId(0);
                    a.add(ator);
                    req.getServletContext().setAttribute("a", a);
                }else {
                    a = (ArrayList<Artista>) req.getServletContext().getAttribute("a");
                    ator.setId(a.size());
                    a.add(ator);
                    req.getServletContext().setAttribute("a", a);
                }
                
                req.setAttribute("msgCadastro", artista);
                req.getRequestDispatcher("/tabelaArtista.jsp").forward(req, resp);
                
                
                
           }
           else{
               req.getRequestDispatcher("/artista.jsp").forward(req, resp);
           }
           

        
         
        }catch(Exception e){
            e.printStackTrace();
            resp.getWriter().print("Foi encontradao algum erro no sistema!");
        }    
    }

   

}
