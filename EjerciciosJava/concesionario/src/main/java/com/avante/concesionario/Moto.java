/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.concesionario;

/**
 *
 * @author cursodesarrollo
 */
public class Moto extends Vehiculo{
    public Moto() {
        super("[MATRICULA]",100);
    }
    
    public Moto(String matricula,int deposito){
        super(matricula, deposito);
    }
    
    @Override
    public void imprimirEstado() {
        System.out.print("Moto: ");
        super.imprimirEstado();
    }
}
