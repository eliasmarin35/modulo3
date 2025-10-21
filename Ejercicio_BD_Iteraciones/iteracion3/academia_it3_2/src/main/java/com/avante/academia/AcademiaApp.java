/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.avante.academia;

import com.avante.academia.model.Alumno;
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
        //Curso curso;
        Alumno alumno;
        
        //String query = "SELECT id, nombre, fecha_inicio, fecha_fin FROM cursos;";
        String query = """
            SELECT
                a.id, a.nombre, a.apellidos, email, a.curso_id, c.nombre
            FROM
                alumnos a
                INNER JOIN cursos c ON a.curso_id=c.id
            ORDER BY
               1 ASC
            ;
        """;
        
        try (
            Connection conn = Driver.getInstance().getConnection();
            
            // OPCIONAL: si se hubiera creado un método estático para devolver
            //           la conexión, podríamos usarlo sin llamar a getInstance
            // Connection conn = Driver.getConnectionStatic();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
        ) {
            while (rs.next()) {              
                // Si hemos anyadido @Builder a nuestro modelo
                alumno = Alumno.builder()
                        .id(rs.getInt(1))
                        .nombre(rs.getString(2))
                        .apellidos(rs.getString(3))
                        .email(rs.getString(4))
                        .curso_id(rs.getInt(5))
                        .curso_nombre(rs.getString(6))
                        .build();
                
                
                // Tambien se podria obetner un Date generico y pasar a LocalDate
                //fecInicio = rs.getDate(3).toLocalDate();
                System.out.println(alumno);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException("Error SQL: " + e.getMessage());
        }
    }
}
