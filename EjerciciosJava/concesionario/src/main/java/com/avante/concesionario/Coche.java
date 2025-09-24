/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.concesionario;

/**
 *
 * @author cursodesarrollo
 */
public class Coche extends Vehiculo {
    
    public Coche() {}
    
    public Coche(String matricula,int deposito){
        super(matricula, deposito);
   }
    
    @Override
    public void imprimirEstado() {
        System.out.print("Coche: ");
        super.imprimirEstado();
    }
}
