/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Juaco
 */
public class BDVocabulario extends HttpServlet {

    Connection conexion = null;
    Statement sentenciaSQL = null;
    ResultSet cdr= null;
    
    public void init(ServletConfig config) throws ServletException
    {
    super.init(config);
    try{
        //cargo y registro controlador
        String controlador = "org.sqlite.JDBC";
        Class.forName(controlador).newInstance();
        //conecto con la BD
        conexion = DriverManager.getConnection("jdbc:sqlite:dlc_vocabulario");
        //crear sentencia sql
        sentenciaSQL = conexion.createStatement();
    }catch(ClassNotFoundException e){
        System.out.println("No se cargo el controlador:"+e.getMessage());
    
    
    }   catch (SQLException ex) {
            Logger.getLogger(BDVocabulario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(BDVocabulario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BDVocabulario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

   
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BDVocabulario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BDVocabulario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        
        try {
            //realizar una consulta sql
            cdr= sentenciaSQL.executeQuery("SELECT * "+"FROM palabras");
            
            //mostrar resultados obtenidos
            out.println("<html><head><title>Palabras</title></head>");
            out.println("<body>");
            //tabla 
            out.println("table width=100% border=1");
            //Cabeceras
            out.println("<tr>");
            out.println("<th>Palabra</th><th>Nombre</th>");
            out.println("</tr>");
            //Filas
            while(cdr.next()){
            out.println("<tr>");
            out.println("<td width=40%>"+cdr.getString(1)+"</td>");
            out.println("<td width=40%>"+cdr.getString(2)+"</td>");
        }
        
            out.println("</table>");
            out.println("</body></html>");
        } catch (SQLException ex) {
            Logger.getLogger(BDVocabulario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    
    
    
    }
    public void destroy()
    {
    try{
    if(cdr!=null)cdr.close();
    if(sentenciaSQL !=null)sentenciaSQL.close();
    if(conexion !=null)conexion.close();
    }catch(SQLException ignorada)
    {}
    
    
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
