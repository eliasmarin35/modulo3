/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.avante.academia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

/**
 *
 * @author jprof
 */
public class AcademiaApp {
    public static void main(String[] args) {
        int id;
        String nombre;
        LocalDate fecInicio, fecFin;
        
        String query = "SELECT id, nombre, fecha_inicio, fecha_fin FROM cursos;";
        
        try (
            Connection conn = Driver.getInstance().getConnection();
            
            // OPCIONAL: si se hubiera creado un método estático para devolver
            //           la conexión, podríamos usarlo sin llamar a getInstance
            //Connection conn = Driver.getConnectionStatic();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
        ) {
            while (rs.next()) {
                id = rs.getInt(1);
                nombre = rs.getString(2);
                fecInicio = rs.getObject(3,LocalDate.class);
                fecFin = rs.getObject(4,LocalDate.class);

                // Tambien se podria obetner un Date generico y pasar a LocalDate
                //fecInicio = rs.getDate(3).toLocalDate();

                System.out.printf("%d - %s [de %s a %s].\n",
                        id, nombre, fecInicio, fecFin
                );
            }
        }
        catch (SQLException e) {
            throw new RuntimeException("Error SQL: " + e.getMessage());
        }
    }
}
