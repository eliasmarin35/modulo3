/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.avante.academia;

import com.avante.academia.model.Curso;
import com.avante.academia.model.Driver;
import java.sql.Connection;
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
        Curso curso;
        
        String query = "SELECT id, nombre, fecha_inicio, fecha_fin FROM cursos;";
        
        try (
            Connection conn = Driver.getInstance().getConnection();
            
            // OPCIONAL: si se hubiera creado un método estático para devolver
            //           la conexión, podríamos usarlo sin llamar a getInstance
            // Connection conn = Driver.getConnectionStatic();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
        ) {
            while (rs.next()) {
                curso = new Curso();
                curso.setId(rs.getInt(1));
                curso.setNombre(rs.getString(2));
                curso.setFecha_inicio(rs.getObject(3,LocalDate.class));
                curso.setFecha_fin(rs.getObject(4,LocalDate.class));
                
                /*
                // Si hemos anyadido @Builder a nuestro modelo
                curso = Curso.builder()
                        .id(rs.getInt(1))
                        .nombre(rs.getString(2))
                        .fecha_inicio(rs.getObject(3,LocalDate.class))
                        .fecha_fin(rs.getObject(4, LocalDate.class))
                        .build();
                */
                
                
                // Tambien se podria obetner un Date generico y pasar a LocalDate
                //fecInicio = rs.getDate(3).toLocalDate();
                System.out.println(curso);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException("Error SQL: " + e.getMessage());
        }
    }
}
