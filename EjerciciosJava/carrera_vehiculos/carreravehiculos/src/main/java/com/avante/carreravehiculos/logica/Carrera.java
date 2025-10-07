/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.carreravehiculos.logica;

import java.util.Scanner;

/**
 *
 * @author jprof
 */
public class Carrera {
    // ==== ATRIBUTOS =====
    
    /**
     * Numero de jugadores
     */
    private int numJugadores = 0;
    
    /**
     * Distancia en metros
     */
    private int distancia = -1;
    
    /**
     * El array de vehiculos que representa a los participantes.
     */
    private Vehiculo[] participantes;
    
    /**
     * El ganador de la categoría de coches
     */
    private String ganadorCoche="[desierto]";
    
    private boolean hayGanadorCoche = false;
    
    /**
     * El ganador de la categoría de motos
     */
    private String ganadorMoto="[desierto]";
    
    private boolean hayGanadorMoto = false;
    
    /**
     * El ganador de la categoría de bicicletas
     */
    private String ganadorBicicleta="[desierto]";
    
    private boolean hayGanadorBicileta = false;
    
    
    // ==== CONSTRUCTORES =====
    /**
     * Constructor
     * 
     * @param num el número de participantes
     * @param distancia la distancia de la carrera
     */
    public Carrera (int num, int distancia) {
        this.numJugadores = num;
        this.distancia = distancia;
        
        // Se puede crear un array de una clase abstracta, siempre y cuando
        //    los valores del array sean instancias de las clases concretas
        //    hijas de la abstracta.
        this.participantes = new Vehiculo[this.numJugadores];
        
        // Se puede ejecutar un metodo estático sobre una clase abstracta
        //     porque no se ha creado ningún objeto de la misma
        Vehiculo.setDistanciaTotal(this.distancia);
    }
    
    /**
     * Metodo de entrada de la partida
     * @param scan scanner de texto para pedir datos de entrada
     */
    public void jugar(Scanner scan) {
        // VARS
        int jugadoresAcabados = this.numJugadores;
        int numIteracion = 1;
        
        // inicializo jugadores
        inicializaJugadores(scan);
        
        // bucle
        while (jugadoresAcabados > 0) {
            System.out.printf("\n******* Iteracion: %d\n", numIteracion++);
            
            for (Vehiculo v : this.participantes) {
                if ( v.avanza() ) {
                    jugadoresAcabados--;
                    
                    switch (v.getTipoVehiculo()) {
                        case "coche":
                            if (!this.hayGanadorCoche) {
                                ganadorCoche=v.getNombre();
                                this.hayGanadorCoche = true;
                            }
                            break;
                            
                        case "moto":
                            if (!this.hayGanadorMoto) {
                                ganadorMoto=v.getNombre();
                                this.hayGanadorMoto = true;
                            }
                            break;
                        case "bicicleta":
                            if (!this.hayGanadorBicileta) {
                                ganadorBicicleta=v.getNombre();
                                this.hayGanadorBicileta = true;
                            }
                            break;
                    }
                }
            }
        }
        
        // Publicamos los ganadores
        System.out.println("\n\n==================");
        System.out.printf("El ganador en la categoria de coches es: %s\n", this.ganadorCoche);
        System.out.printf("El ganador en la categoria de motos es: %s\n", this.ganadorMoto);
        System.out.printf("El ganador en la categoria de bicicletas es: %s\n", this.ganadorBicicleta);
    }
    
    /**
     * Inicializa todos los jugadores por teclado
     * @param scan scanner de texto para pedir los datos
     */
    private void inicializaJugadores (Scanner scan) {
        // VARS
        String nombre;
        Vehiculo vehiculo;
        
        // LOGICA
        for (int i=0; i<this.numJugadores; i++) {
            nombre = pedirNombreJugador(scan, i+1);
            vehiculo = pedirVehiculo(scan, i+1, nombre);
            
            this.participantes[i] = vehiculo;
        }
    }
    
    /**
     * Pide por teclado el nombre del jugador
     * 
     * @param scan el scanner de texto para poder leer el teclado
     * @param num el índice del jugador
     * @return el nombre del jugador que el usuario ha introducido
     */
    private String pedirNombreJugador (Scanner scan, int num) {
        // VARS
        String texto="";
        
        // LOGICA
        while (texto.equals("")) {
            System.out.printf("Introduzca el nombre del jugador %d:\n> ", num);
            texto = scan.nextLine().trim();
            System.out.println("");

            if (texto.equals("")) {
                System.out.println("El texto introducido no es un nombre válido.\n");
            }
        }
        
        return texto;
    }
    
    /**
     * Pide el vehículo del jugador
     * 
     * @param scan el scanner de texto para leer el teclado
     * @param num el índice del jugador
     * @param nombre el nombre del jugador
     * @return el objeto Vehiculo creado
     */
    private Vehiculo pedirVehiculo (Scanner scan, int num, String nombre) {
        // VARS
        String texto="";
        Vehiculo vehiculo=null;
        
        // LOGICA
        while (vehiculo == null) {
            System.out.printf("Introduzca el tipo de vehículo del jugador %d:\n(coche|bicicleta|moto) > ",num);
            texto = scan.nextLine().trim().toLowerCase();
            System.out.println("");

            switch (texto) {
                case "coche":
                    vehiculo = new Coche(nombre);
                    break;
                    
                case "moto":
                    vehiculo = new Moto(nombre);
                    break;
                    
                case "bicicleta":
                    vehiculo = new Bicicleta(nombre);
                    break;
                    
                default:
                    System.out.println("El texto introducido no es un nombre válido.\n");
                    break;
            }
        }
        
        return vehiculo;
    }   
}
