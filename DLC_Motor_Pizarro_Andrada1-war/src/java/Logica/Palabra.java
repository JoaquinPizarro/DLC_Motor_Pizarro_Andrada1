/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Emiliano Andrada
 */
public class Palabra {
    
    private String palabra;
    private int tfMax;
    private int nr;
    
    public Palabra(){}
    
    public Palabra(String p){
        this.palabra=p;
        this.nr=0;
        this.tfMax=0;
    }
    
    public Palabra(String p, int nr, int tfMax){
        this.palabra=p;
        this.nr=nr;
        this.tfMax=tfMax;
    }

    /**
     * @return the palabra
     */
    public String getPalabra() {
        return palabra;
    }

    /**
     * @param palabra the palabra to set
     */
    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    /**
     * @return the tfMax
     */
    public int getTfMax() {
        return tfMax;
    }

    /**
     * @param tfMax the tfMax to set
     */
    public void setTfMax(int tfMax) {
        this.tfMax = tfMax;
    }

    /**
     * @return the nr
     */
    public int getNr() {
        return nr;
    }

    /**
     * @param nr the nr to set
     */
    public void setNr(int nr) {
        this.nr = nr;
    }
}
