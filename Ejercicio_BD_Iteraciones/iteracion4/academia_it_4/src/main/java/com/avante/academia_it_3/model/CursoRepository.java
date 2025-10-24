/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.academia_it_3.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.management.RuntimeErrorException;

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
        String sql = "INSERT INTO cursos (nombre,fecha_inicio,fecha_fin) VALUES (?,?,?);";
        
        try (
                Connection conn = Driver.getInstance().getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setString(1,c.getNombre());
            stmt.setObject(2,c.getFecha_inicio());
            stmt.setObject(3,c.getFecha_fin());
            
            stmt.execute();
        }
        catch (SQLException e) {
            throw new RuntimeException("Error insertando un curso.\n" + e.getMessage());
        }
    }
    
    public Curso retrieve(int id) {
        Curso curso = null;
        
        String sql="SELECT id, nombre, fecha_inicio, fecha_fin FROM cursos WHERE id=?;";
        
        try (
            Connection conn = Driver.getInstance().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
        
            while (rs.next()) {
                curso = Curso.builder()
                        .id(rs.getInt(1))
                        .nombre(rs.getString(2))
                        .fecha_inicio(rs.getObject(3,LocalDate.class))
                        .fecha_fin(rs.getObject(4,LocalDate.class))
                        .build();
            }

            rs.close();
        }
        catch (SQLException e) {
            throw new RuntimeException("Error recuperando el curso.\n" + e.getMessage());
        }
        
        return curso;
    }
    
    public int update(int id, Curso curso) {
        int numrows=0;
        
        String sql = """
            UPDATE
                cursos
            SET
                nombre=?,
                fecha_inicio=?,
                fecha_fin=?
            WHERE
                id=?
            ;
        """;
        
        try (
                Connection conn = Driver.getInstance().getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setString(1,curso.getNombre());
            stmt.setObject(2,curso.getFecha_inicio());
            stmt.setObject(3,curso.getFecha_fin());
            stmt.setInt(4, id);
            
            numrows = stmt.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException("Error actualizando un curso.\n" + e.getMessage());
        }
        
        return numrows;
    }
}
