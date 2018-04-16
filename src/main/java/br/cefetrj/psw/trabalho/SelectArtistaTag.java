/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetrj.psw.trabalho;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Lucas Lima
 */
public class SelectArtistaTag extends SimpleTagSupport {
   private String estiloMusical;

    @Override
    public void doTag() throws JspException, IOException {
        String selectHtml = 
        "<select  class='form-control' id='inputEstilo' name = 'estiloMusical'>" +
        "   <option value=''>Selecione um estilo..</option>" +
        "   <option value='Rock' " + ("Rock".equals(estiloMusical) ? "selected": "") + " >Rock</option>" +
        "   <option value='Pop' " + ("Pop".equals(estiloMusical) ? "selected": "") + " >Pop</option>" +
        "   <option value='Outros' " + ("Outros".equals(estiloMusical) ? "selected": "") + " >Outros</option>" +
        "</select>";
        getJspContext().getOut().print(selectHtml);
    }

    public String getEstiloMusical() {
        return estiloMusical;
    }

    public void setEstiloMusical(String estiloMusical) {
        this.estiloMusical = estiloMusical;
    }

   
    
    
   
}

