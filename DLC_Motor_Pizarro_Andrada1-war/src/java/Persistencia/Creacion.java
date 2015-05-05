package Persistencia;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//import org.sqlite.SQLiteConfig;
import org.sqlite.*;

/**
 *
 * @author Andrada - Simoncelli
 */
public class Creacion {

    static Connection conn;

    public static synchronized Connection getConexion() {
        try {
            Class.forName("org.sqlite.JDBC");

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);
            conn = DriverManager.getConnection("jdbc:sqlite:dlc_vocabulario", config.toProperties());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void crearTablas() {
        Connection c = getConexion();
        Statement stat = null;
        try {
            stat = c.createStatement();

            stat.executeUpdate("CREATE TABLE IF NOT EXISTS [DOCUMENTOS] ( "
                    + "[nombre] VARCHAR(150)  NOT NULL PRIMARY KEY "
                    + ");");

            stat.executeUpdate("CREATE TABLE IF NOT EXISTS [PALABRAS] ( "
                    + "[palabra] VARCHAR(100)  NOT NULL PRIMARY KEY, "
                    + "[cantidad] INTEGER  NULL "
                    + ");");

            stat.executeUpdate("CREATE TABLE IF NOT EXISTS [PALABRASXDOCUMENTOS] ( "
                    + "[palabra] VARCHAR(100)  NULL,"
                    + "[nombre] VARCHAR(150)  NULL, "
                    + "PRIMARY KEY ([palabra],[nombre]) "
                    + " FOREIGN KEY([palabra]) REFERENCES [PALABRAS]([palabra]) "
                    + " FOREIGN KEY([nombre]) REFERENCES [DOCUMENTOS]([nombre]) "
                    + ");");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Creacion.cerrarConexion();
        }
    }

    public static void cerrarConexion() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}