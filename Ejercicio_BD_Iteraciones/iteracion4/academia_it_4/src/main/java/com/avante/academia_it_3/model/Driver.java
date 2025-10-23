/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.academia_it_3.model;

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
public class Driver {
    private final String url;
    private final String username;
    private final String pass;
    
    private static Driver instance;
    
    private Driver() {
        Properties prop = new Properties();
        
        try (
            InputStream is = Driver.class.getClassLoader().getResourceAsStream("./config.properties");
        ) {
            prop.load(is);
        }
        catch (IOException e) {
            throw new RuntimeException("Hay un error leyendo el fichero de configuración.\n" + e.getMessage());
        }
        
        this.url = prop.getProperty("db.url");
        this.username = prop.getProperty("db.username");
        this.pass = prop.getProperty("db.password");
    }
    
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(this.url, this.username, this.pass);
    }
    
    public static Driver getInstance() {
        if (instance == null) {
            instance = new Driver();
        }
        
        return instance;
    }
}
