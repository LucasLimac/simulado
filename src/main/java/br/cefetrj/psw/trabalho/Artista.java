/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetrj.psw.trabalho;

import java.util.Objects;

/**
 *
 * @author Lucas Lima
 * versão 1.0
 */


public class Artista {
    private String artista;
    private String banda;
    private String anos;
    private String estiloMusical;
    private int id;
   
    /**
     * Construtor da classe Artista
     * 
     * @param artista nome do artista
     * @param banda do artista
     * @param anos de carreira do artista
     * @param estiloMusical do artista
     */

    public Artista(String artista, String banda, String anos, String estiloMusical) {
        this.artista = artista;
        this.banda = banda;
        this.anos = anos;
        this.estiloMusical = estiloMusical;
    }

   

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    /**
     * Equals comparando pelo nome e estiloMusical
     * 
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Artista other = (Artista) obj;
        if (!Objects.equals(this.artista, other.artista)) {
            return false;
        }
        if (!Objects.equals(this.estiloMusical, other.estiloMusical)) {
            return false;
        }
        return true;
    }
    
    

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public String getAnos() {
        return anos;
    }

    public void setAnos(String anos) {
        this.anos = anos;
    }

    public String getEstiloMusical() {
        return estiloMusical;
    }

    public void setEstiloMusical(String estiloMusical) {
        this.estiloMusical = estiloMusical;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
            
            
}
