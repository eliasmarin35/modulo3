/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.pruebaconexionbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jprof
 */
public class DriverDB {
    private final String protocol = "jdbc:postgresql";
    private final String host = "localhost";
    private final String database = "app_pruebaconjdbc";
    private final String username = "app_pruebaconjdbc";
    private final String password = "12345";
    
    private final int port = 5432;
    
    private final String url;
    
    private static DriverDB instance = null;
    
    private DriverDB () {
        this.url = String.format("%s://%s:%d/%s",protocol,host,port,database);
    }
    
    /**
     * Singleton method: getInstance
     * @return 
     */
    public static DriverDB getInstance () {
        if ( DriverDB.instance == null ) {
            DriverDB.instance = new DriverDB();
        }
        
        return DriverDB.instance;
    }
    
    /**
     * Método que devuelve una conexión inicializada a la base de datos
     * @return la conexion
     */
    public Connection getConnection () throws SQLException {
        return DriverManager.getConnection(this.url,this.username,this.password);
    }
}
