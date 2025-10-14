/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.pruebaconexionjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jprof
 */
public class DBConnectionDriver {
    private String username;
    private String password;
    private String host;
    private String port;
    private String dbname;

    private String url = null;
            
    public DBConnectionDriver(String un, String pass, String h, String port, String dbn) {
    	this.username = un;
    	this.password = pass;
    	this.host = h;
    	this.port = port;
    	this.dbname = dbn;
    }

    private void updateUrl () {
    	this.url = String.format(
		"jdbc:postgresql://%s:%s/%s",
    		this.host,
    		this.port,
    		this.dbname
	);

	System.out.printf(
                "La cadena de conexión se construyó:\n\t%s\n",
                this.url);
    }

    private boolean checkUrl () {
    	return this.url != null;
    }
    
    public Connection connection() throws SQLException {
        Connection conn = null; 
        conn = DriverManager.getConnection(this.url(),this.username, this.password);
        return conn;
    }

    // ---> GETTERS
    private String url() {
    	if (!this.checkUrl()) {
		this.updateUrl();
	}

	return this.url;
    }

    private String username() {
    	return this.username;
    }

    private String pasword() {
    	return this.password;
    }
}
