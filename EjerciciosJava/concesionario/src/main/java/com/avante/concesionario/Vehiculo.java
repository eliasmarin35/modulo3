/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.concesionario;

/**
 *
 * @author cursodesarrollo
 */
public class Vehiculo {
    private String   matricula;
    private int      deposito;
    
    public Vehiculo () {}
    
    public Vehiculo (String matricula, int deposito) {
        this.setMatricula(matricula);
        this.setDeposito(deposito);
    }
   
    protected void repostar() {
        setDeposito(100);
    }

    protected void consumir(int porcentaje) {
        if ((this.deposito - porcentaje) < 0) {
            
            this.deposito = 0;
        } else {
        
            this.deposito -= porcentaje;
        }
    }
    /**
     * Imrpime el estado del vehiculo
     * 
     */
    protected void imprimirEstado() {
        System.out.println("Vehiculo con matricula "+this.matricula+" le queda de deposito  "+this.deposito);
    }

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        if ( matricula == null ) {
            throw new Error("La matricula no puede ser nula.");
        }
        
        matricula = matricula.strip();
        
        this.matricula = matricula;
    }

    /**
     * @return the deposito
     */
    public int getDeposito() {
        return deposito;
    }

    /**
     * @param deposito the deposito to set
     */
    public void setDeposito(int deposito) {
        if (deposito < 0) {
           System.err.println("El deposito no puede ser menor que 0, lo dejamos en 0.");
           deposito=0;
        }
        
        if (deposito > 100) {
           System.err.println("El deposito no puede ser mayor que 100, lo dejamos en 100");
           deposito=100;
        }
        this.deposito = deposito;
    }
    
}
