/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.pruebasingleton;

/**
 * Ejemplo de clase Singleton.
 * 
 * Un Singleton es una clase que solo permite un unico objeto instanciado.
 * 
 * La instanciación del objeto se lleva a cabo por la propia clase.
 * 
 * El resto, lo único que hace es pedirle a la clase una referencia a ese único
 *    objeto, y ya la clase lo instanciará si no lo estaba ya.
 * 
 * Durante todo el ciclo de vida de la Aplicación la instancia de la clase
 *    permanera inicializada y accesible por el resto del código.
 * 
 * @author jprof
 */
public class AlumnoSingleton {

    private int    numero;
    private String nombre;
    
    // Unica instancia de la clase
    private static AlumnoSingleton instance;

    // Constructor privado para que nadie pueda crear instancias de la clase
    //   (solo la misma clase).
    private AlumnoSingleton() {}
    
    @Override
    public String toString() {
        return String.format("[%d: %s]",numero,nombre);
    }
    
    public void set(int num, String name) {
        this.numero = num;
        this.nombre = name;
    }
    
    // ESte metodo estatico es el que da acceso a la unica instancia de nuestra
    //    clase
    public static AlumnoSingleton getInstance() {
        if (AlumnoSingleton.instance == null) {
            AlumnoSingleton.instance = new AlumnoSingleton();
        }
        
        return AlumnoSingleton.instance;
    }
}
