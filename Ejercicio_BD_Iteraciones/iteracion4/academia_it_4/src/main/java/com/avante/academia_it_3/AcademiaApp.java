/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.academia_it_3;

import com.avante.academia_it_3.model.CursoRepository;

/**
 *
 * @author jprof
 */
public class AcademiaApp {
    public static void main (String[] args) {
        CursoRepository repo = new CursoRepository();
        
        repo.listAll().stream()
                .forEach(System.out::println);
    }
}
