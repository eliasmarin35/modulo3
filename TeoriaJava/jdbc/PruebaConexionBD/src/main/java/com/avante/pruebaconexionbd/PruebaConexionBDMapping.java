/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.avante.pruebaconexionbd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jprof
 */
public class PruebaConexionBDMapping {

    public static void main(String[] args) {
        String   nombre;
        Double   salario;
        Empleado em;
         
        DriverDB driver = DriverDB.getInstance();

        try (
                Connection conn = driver.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT id, nombre, salario FROM empleados;");
        ) {
            // resulsent.next() prepara el result set para devolver los datos de
            //    la siguiente fila. Si hay fila devuelve true, y si no devuelve
            //    false
            while (rs.next()) {
                em = new Empleado(
                   rs.getInt(1),
                   rs.getString(2),
                   rs.getDouble(3)
                );
                
                System.out.println(em);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Ha habido un error en la BD");
        }
    }
}
