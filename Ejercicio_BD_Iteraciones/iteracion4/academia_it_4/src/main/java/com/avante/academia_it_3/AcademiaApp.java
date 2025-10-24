/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.academia_it_3;

import com.avante.academia_it_3.model.Curso;
import com.avante.academia_it_3.model.CursoRepository;
import java.time.LocalDate;
import java.time.Month;


/**
 *
 * @author jprof
 */
public class AcademiaApp {
    public static void main (String[] args) {
        CursoRepository repo = new CursoRepository();
        
        // Listar
        repo.listAll().stream()
                .forEach(System.out::println);
        System.out.println("");
        
        // Datos para modificar el curso 4
        Curso curso = new Curso();
        curso.setNombre("Curso Actualizado Por segunda vez");
        curso.setFecha_inicio(LocalDate.of(2023, Month.MARCH, 25));
        curso.setFecha_fin(LocalDate.of(2023, Month.APRIL, 30));
        
        
        // Modifico el curso 4
        int numrows=repo.update(4, curso);
        System.out.printf("Se han modificado %d filas.\n\n",numrows);
        
        
        // Listar
        repo.listAll().stream()
                .forEach(System.out::println);
        System.out.println("");
    }
}
