/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.Documento;
import Logica.Palabra;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emiliano Andrada
 */
public class Persistencia {
    
        Connection conn;
        PreparedStatement getFrases;
        PreparedStatement glp;
        PreparedStatement ordenar;
        PreparedStatement buscartf;
    
    
     public void AbrirConexionBD() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:tsb_vocabulario.s3db");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
// Recibe un vector con los términos ordenados de la consulta. En base a ello, obtiene la lista de posteo para cada término. 
  public ArrayList[] getListaPosteo(Palabra[] q) throws SQLException{

      ArrayList[] postList = new ArrayList[q.length];
      this.AbrirConexionBD();

      for(int i=0; i< q.length; i++){
          glp = conn.prepareStatement("Select nombreDoc from palabrasxdocumento where palabra=?");
          glp.setString(1, q[i].getPalabra());
          ResultSet rs = glp.executeQuery();
          ArrayList<Documento> docs = new ArrayList<Documento>();

          while(rs.next()){
            String nombreDoc = rs.getString(1);
            Documento d = new Documento(nombreDoc);
            docs.add(d);
          }
          postList[i] = docs;
      }	
        this.CerrarConexionBD();
        return postList;
    }
  
    // ordena una consulta q de menor a mayor nr. 
    //Devuelve un vector donde cada indice corresponde a un término en la consulta. 
    public Palabra[] orderQ(String q) throws SQLException{
        
        this.AbrirConexionBD();
        //Se divide mediante Split de la clase String a la consulta, en un array.
        String[] orderQ = q.split(" ");
        Palabra[] frase = new Palabra[orderQ.length];
        
        for(int i=0; i<frase.length; i++){
            ordenar = conn.prepareStatement("SELECT nr from palabras where palabra=?");
            ordenar.setString(1, orderQ[i]);
            ResultSet rs = ordenar.executeQuery();
            while(rs.next()){
                Palabra p = new Palabra(orderQ[i], rs.getInt(1), 0); 
                frase[i] = p;
            }
        }
        frase = this.ordenar(frase);

        //El resultado es el vector palabras, cada indice es un objeto del tipo Palabra. Está ordenado de menor a mayor nr. 
        this.CerrarConexionBD();
        return frase;
    }
    
    public Palabra[] ordenar(Palabra[] q){
        boolean ordenado = false;
        Palabra aux;
        int i, j, n = q.length;
        for(i=0; i<n-1 && !ordenado; i++){
            ordenado=true;
            for(j=0; j<n-i-1; j++){
                if(q[j].getNr() > q[j+1].getNr()){
                    ordenado=false;
                    aux=q[j];
                    q[j] = q[j+1];
                    q[j+1]=aux;
                }
            }
        }
        return q;
    }
    
    //para un documento i y una palabra t, se obtiene el TF (frecuencia del termino) en este documento
    public int getTF (String i, String t) throws SQLException{
        
        int tf=-1;
        this.AbrirConexionBD();
        buscartf=conn.prepareStatement("count * from palabrasxdocumentos WHERE nombre=? AND palabra=?");
        buscartf.setString(1, i);
        buscartf.setString(2, t);
        ResultSet rs=buscartf.executeQuery();
        tf=rs.getInt(1);
        
        this.CerrarConexionBD();
        
        return tf;
    }
    
    public void CerrarConexionBD() {
        try {
            this.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
