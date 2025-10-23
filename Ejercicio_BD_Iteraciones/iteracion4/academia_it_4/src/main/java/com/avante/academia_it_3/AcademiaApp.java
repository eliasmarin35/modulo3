/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.academia_it_3;

import com.avante.academia_it_3.model.Curso;
import com.avante.academia_it_3.model.CursoRepository;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

/**
 *
 * @author jprof
 */
public class AcademiaApp {
    public static void main (String[] args) {
        CursoRepository repo = new CursoRepository();
        
        Curso curso = Curso.builder()
                .nombre("mi curso")
                .fecha_inicio(LocalDate.of(2025, Month.MARCH, 25))
                .fecha_fin(LocalDate.of(2025, Month.APRIL, 30))
                .build();
                
        repo.insert(curso);
        
        repo.listAll().stream()
                .forEach(System.out::println);
    }
}
