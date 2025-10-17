/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.pruebaconexionbd;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author jprof
 */
public class DriverDB {
    private final String protocol;
    private final String host;
    private final String database;
    private final String username;
    private final String password;
    private final String port;
    private final String url;
    
    private static final String CONFIG="./config.properties"; 
    
    private static DriverDB instance = null;
    
    private DriverDB () {
        // Objeto properties
        Properties prop = new Properties();
        
        // Leer el fichero de propiedades
        try (
            // Accedemos al archivo de propiedades
            InputStream in = getClass().getClassLoader().getResourceAsStream(DriverDB.CONFIG);
        ) {
            prop.load(in);
        }
        catch (IOException e) {
            throw new RuntimeException(
                "No se puede leer la configuración.\n" + e.getMessage());
        }
        
        // Inicializar las variables con las propiedades
        this.protocol = prop.getProperty("db.protocol");
        this.host = prop.getProperty("db.host");
        this.port = prop.getProperty("db.port");
        this.database = prop.getProperty("db.database");
        this.username = prop.getProperty("db.username");
        this.password = prop.getProperty("db.password");
        
        // Se construye la URL
        this.url = String.format("%s://%s:%s/%s",protocol,host,port,database);
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
