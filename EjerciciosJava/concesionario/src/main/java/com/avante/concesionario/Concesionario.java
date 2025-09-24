/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.avante.concesionario;

/**
 *
 * @author cursodesarrollo
 */
public class Concesionario {

    public static void main(String[] args) {
        // Creamos un coche con el deposito lleno
        Vehiculo miCoche = new Coche("1234_ABC",100);
        
        // Consumimos un 35 %
        miCoche.consumir(35);
        
        // CHECK: el consumo se ha reflejado
        miCoche.imprimirEstado();
        
        /**********************************/
        
        // Creamos una moto con el deposito lleno
        Vehiculo miMoto = new Moto();
        
        // Consumimos un 20 %
        miMoto.consumir(20);
        
        // CHECK: el consumo se ha reflejado
        miMoto.imprimirEstado();
    }
}
