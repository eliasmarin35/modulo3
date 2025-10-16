/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.avante.pruebaconexionbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jprof
 */
public class PruebaConexionBD {

    public static void main(String[] args) throws SQLException {
        String url="jdbc:postgresql://localhost:5432/app_pruebaconjdbc";
        String usuario="app_pruebaconjdbc";
        String contrasenya="12345";
        String sql;
        String nombre;
        Double salario;
       
        Connection conn = DriverManager.getConnection(url,usuario,contrasenya);
        
        sql = "SELECT * FROM empleados";
     
        // Statement es un comando sql para ejecutar en la Base de Datos
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
     
        // resulsent.next() prepara el result set para devolver los datos de
        //    la siguiente fila. Si hay fila devuelve true, y si no devuelve
        //    false
        while (rs.next()) {
            nombre = rs.getString("nombre");
            salario = rs.getDouble("salario");
            
            System.out.printf("Nombre: %s, Salario: %f\n",nombre,salario);
        }
        
        rs.close();
        stmt.close();
        conn.close();
    }
}
