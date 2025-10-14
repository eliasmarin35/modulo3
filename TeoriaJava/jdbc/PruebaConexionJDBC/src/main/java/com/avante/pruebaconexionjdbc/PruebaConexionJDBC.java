/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.avante.pruebaconexionjdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jprof\
 */
public class PruebaConexionJDBC {

    public static void main(String[] args) {
        DBConnectionDriver drv = new DBConnectionDriver(
            "app_pruebaconjdbc",
            "12345",
            "localhost",
            "5432",
            "app_pruebaconjdbc"
        );
        
        
        Connection conn = null;
        
        String nombre;
        double salario;
        
        try {
            conn = drv.connection();
        
            Statement st = conn.createStatement();
            
            ResultSet rs = st.executeQuery("SELECT nombre, salario FROM empleados");
            
            while (rs.next()) {
                nombre = rs.getString("nombre");
                salario = rs.getDouble("salario");
                
                System.out.printf("Nombre: %s, Salario: %f\n",nombre,salario);
            }
            
            System.out.println("Conectado con exito!");
        }
        catch (SQLException e) {
            System.err.printf(
                "Ha habido un error con la conexion a la BD:\n%s\n",
                 e.getMessage()
            );
        }
        finally {
            if ( conn != null) {
                try {
                    conn.close();
                }
                catch (SQLException e) {
                   System.err.printf(
                        "Ha habido un error cerrando la conexión con la BD:\n%s\n",
                        e.getMessage()
                    );
                }
            }
            else {
                System.err.println("Ha ocrrido un error SQL y la conexión no se había establecido");
            }
        }
    }
}
