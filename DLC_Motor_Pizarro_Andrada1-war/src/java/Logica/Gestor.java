/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.Persistencia;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Emiliano Andrada
 */
public class Gestor {
    
    Persistencia p;
    
    
    public Gestor(){
        p=new Persistencia();
    }
    
    /*
    buscarFrase devuelve una lista de los R documentos más relevantes para la consulta q ingresada.
    */
    
    /*
    Recibe como parámetro una consulta q, y se realiza lo siguiente:
        1 - Se ordenan los terminos de la consulta de menor a mayor nr (cantidad de documentos en los que aparecen).
        2 - Se busca la lista de posteo de cada término de la consulta y se guarda en una lista.
        3 - Se obtienen los R documentos relevantes para la consulta recorriendo el vector que contiene las listas de posteo. 
        4 - Se rankean los documentos del resultado anterior a partir de la fórmula tf * log(N/nr). 
    */
    
    public ArrayList<ArrayList> buscarFrase(String q, int r) throws SQLException{
        
        //busco un vector con las palabras de la consulta. Cada elemento es un objeto palabra con su correspondiente nr.  
        Palabra[] qOrder = p.orderQ(q); 
        
        /**
         * habrá que recorrer el vector. Cada elemento de postList será una lista de posteo, 
         * cuya posición en el vector coincide con la posición en el vector de la consulta 
         * ordenada de menor a mayor nr. Cada lista de posteo es una lista de objetos Documento. 
         */
        ArrayList[] postList = p.getListaPosteo(qOrder);
        
        /*
        Se recorre el vector postList y cada elemento para conocer los R documentos relevantes. 
        Se crea para cada uno un objeto documento, luego se le aplicará el valor del ranking. 
        */
        Documento[] documentos = new Documento[r];
        
        for(int i=0; i<postList.length; i++){
            if(postList[i].size()>r){
                for(int j=0; j<postList[i].size(); j++){
                    
                }
            }
            
            else{
                
            }
            
        }
        
        
        return null;
    }
    
    public int[] rankearDocumentos(){
        
        return null;
    }
}
