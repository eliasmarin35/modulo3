/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.ahorcado;

/**
 *
 * @author Curso Desarrollo
 */
public class Juego {
    
    public static String palabraSecreta;
    public static char[] palabraAdivinada;
    public int intentos;
    
    public Juego(String palabra){
        
        this.palabraSecreta = palabra.toUpperCase();
        this.intentos = 6;
        
        // inicializa la palabra que tenemos que adiinar con "_"
        this.palabraAdivinada = new char[palabraSecreta.length()];
        for (int i = 0; i < palabraAdivinada.length; i++) {
            palabraAdivinada[i] = '_';
            
        }
        System.out.println(palabraAdivinada);
    }
    
        
    public void CompruebaAcierto(char letra){
        // Aqui comprobamos letra dada y subimos intento
        for (int i = 0; i < palabraAdivinada.length; i++) {
            if (palabraSecreta.charAt(i) == letra ){
                intentos = intentos - 1;
                palabraAdivinada[i] = letra;
            }else{
                intentos = intentos - 1;
                System.out.println("Palabra Incorrecta. ");
            }
        }
    }
    
    public boolean FinJuego(int maxIntentos){
        // comprobara condiciones de juego y las modificara para que
        // el programa principal finalice el juego.
        if (maxIntentos > 6) {
            System.out.println("Fin de partida ! maximo de Intetos alcanzado ! ");
            return true;
            
        }else{
            return false;
        }
        
    }
    
  
}   


