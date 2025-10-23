/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.academia_it_3.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jprof
 */
public class CursoRepository {
    public List<Curso> listAll () {
        List<Curso> listaCursos = new ArrayList<>();
        Curso curso =null;
        String sql = "SELECT id, nombre, fecha_inicio, fecha_fin FROM cursos;";
        
        try (
                Connection conn = Driver.getInstance().getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs  = stmt.executeQuery(sql);
        ) {
            while (rs.next()) {
                curso = new Curso();
                curso.setId(rs.getInt("id"));
                curso.setNombre(rs.getString("nombre"));
                curso.setFecha_inicio(rs.getObject("fecha_inicio", LocalDate.class));
                curso.setFecha_fin(rs.getObject("fecha_fin", LocalDate.class));
                
                listaCursos.add(curso);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException("Error listando cursos.\n" + e.getMessage());
        }
        
        return listaCursos;
    }
    
    public void insert(Curso c) {
        
    }
}
