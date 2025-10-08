/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.coleccioneslistas;

import com.avante.coleccioneslistas.logica.Alumno;
import com.avante.coleccioneslistas.logica.MiLista;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jprof
 */
public class EjemploList {

    public static void main(String[] args) {
        // Variables
        List<Alumno> alumnos;

        // 1.- Usarla con ArrayList
        System.out.println("\n===> 1.- Uso de list con ArrayList");

        alumnos = new ArrayList<>();
        alumnos.add(new Alumno(67, "Maria"));
        alumnos.add(new Alumno(6, "Luis"));
        alumnos.add(new Alumno(45, "Ale"));

        for (Alumno a : alumnos) {
            System.out.println(a);
        }

        // 2.- Usarla con LinkedList
        System.out.println("\n===> 2.- Uso de list con LinkedList");

        alumnos = new LinkedList<>();
        alumnos.add(new Alumno(76, "Mario"));
        alumnos.add(new Alumno(4, "Luisa"));
        alumnos.add(new Alumno(54, "Alejandra"));

        for (Alumno a : alumnos) {
            System.out.println(a);
        }

        // 3.- Utilizar una implementacion propia
        // Esto va a fallar porque la implementacion de MiLista solo esta
        //      indicada con excepciones "UnsupportedOperationException"
        try {
            System.out.println("\n===> 3.- Uso de list con implementacion propia (MiLista).");

            alumnos = new MiLista<>();
            alumnos.add(new Alumno(76, "Mario"));
            alumnos.add(new Alumno(4, "Luisa"));
            alumnos.add(new Alumno(54, "Alejandra"));

            for (Alumno a : alumnos) {
                System.out.println(a);
            }
        } catch (UnsupportedOperationException E) {
            System.err.println("Las operaciones de MiLista no estan implementadas");
        }

    }

}
