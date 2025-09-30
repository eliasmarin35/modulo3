/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.ppt.logica;

import java.util.Scanner;

/**
 *
 * @author Juan Manuel
 */
public class PPT {
    /************ ATRIBUTOS **************/
    
    private Scanner scan = null;
    
    private String nombreJ1 = "J1";
    private String nombreJ2 = "J2";
    
    private int puntosJ1 = 0;
    private int puntosJ2 = 0;
    
    private int numRonda  = 0;
    
    private int maxRondas = 3;
    private int ganaRonda = -10000;


    /************ CONSTRUCTOR **********/
    
    public PPT () {
        this.inicializaGanaRonda();
    }
    
    public PPT (String n1, String n2, int rondas) {
        this.nombreJ1 = n1;
        this.nombreJ2 = n2;
        this.maxRondas = Math.max(1, rondas);
        
        this.inicializaGanaRonda();
    }
    
    
    /************ METODOS **************/
    @Override
    public String toString() {
        return String.format(
 """
 Datos de la Partida:
    J1 = %s
    J2 = %s
    Num. Rondas = %s
    Gana Rondas = %s
""",
            this.nombreJ1,
            this.nombreJ2,
            this.maxRondas,
            this.ganaRonda
        );
    }
   
   private void inicializaGanaRonda () {
       this.ganaRonda = (int) Math.floor(
            ( this.maxRondas / 2.0 ) + 1.0
       );
   }
    
   private void infoRonda () {
        System.out.printf("\nAl final de la ronda %d estos son los resultados:\n", this.numRonda);
        System.out.printf("\t%s: %d puntos\n", this.nombreJ1, this.puntosJ1);
        System.out.printf("\t%s: %d puntos\n", this.nombreJ2, this.puntosJ2);
    }
    
    private String pedirJugada(int jugador) {
        // VARIABLES
        String jugada = "";
        boolean ok = false;
        String nombre = (jugador == 1) ? this.nombreJ1 : this.nombreJ2;
        
        // LOGICA
        
        while (!ok) {
            // pedir datos de jugada al jugador
            System.out.printf("\n\n%s, escribe tu jugada:\npiedra | papel | tijera > ", nombre);
            jugada = this.scan.nextLine();
        
            // limpiamos el texto en jugado
            jugada = jugada.trim().toLowerCase();
        
            // Comprobar que la entrada es correcta
            if (
                   jugada.equals("piedra")
                || jugada.equals("papel")
                || jugada.equals("tijera")
            ) {
                ok = true;
            } 
            else {
                System.out.println("No has escrito una jugada correcta.");
            }
        }
        
        // RETURN la jugada que ha introducido el jugador
        return jugada;
    }
    
    private void calculaGanadorRonda (String jugadaJ1, String jugadaJ2) {
        // VARS
        int ganador = 0;
        
        // Logica
        
        // Ver quien gana
        if (jugadaJ1.equals("piedra")) {
            if (jugadaJ2.equals("papel")) {
                ganador = 2;
            }
            else if (jugadaJ2.equals("tijera")) {
                ganador = 1;
            }
        }
        else if (jugadaJ1.equals("papel")) {
            if (jugadaJ2.equals("piedra")) {
                ganador = 1;
            }
            else if (jugadaJ2.equals("tijera")) {
                ganador = 2;
            }
        }
        else if (jugadaJ1.equals("tijera")) {
            if (jugadaJ2.equals("piedra")) {
                ganador = 2;
            }
            else if (jugadaJ2.equals("papel")) {
                ganador = 1;
            }        
        }
        
        // Sumar los puntos al marcador
        switch (ganador) {
            case 1:
                this.puntosJ1++;
                break;
            case 2:
                this.puntosJ2++;
                break;
        }
        
        // Escribir por pantalla los datos  
        System.out.println("");
        
        if (ganador == 0) {
            System.out.println("Ha habido un empate.");
        }
        else {
            System.out.printf("Ha ganado el %s.\n\n", (ganador==1) ? this.nombreJ1 : this.nombreJ2);
        }
    }
    
    private void ronda () {
        // VARIABLES
        String jugadaJ1 = "";
        String jugadaJ2 = "";
        
        // LOGICA
        System.out.printf("\n\n-----> RONDA %d.\n", this.numRonda-1);
        jugadaJ1 = this.pedirJugada(1);
        jugadaJ2 = this.pedirJugada(2);
        
        this.calculaGanadorRonda(jugadaJ1, jugadaJ2);        
    }
    
    
    public void jugar () {
        // VARS
        int ganador = 0;
        
        // Inicio el scanner
        this.scan = new Scanner(System.in);
        
        // Imprimo detalles del juego
        System.out.println("Vamos a jugra a Piedra Papel o Tijera\n");
        System.out.printf("Ganará el mejor de %s rondas.\n", this.maxRondas);
        System.out.printf("O lo que es lo mismo, el primero que llegue a %d puntos.\n\n", this.ganaRonda);
        System.out.printf("Si hay un empate despues de las %d rondas, se seguirá jugando hasta que alguien gane.\n\n", this.maxRondas);
        
        // inicio mi numero de ronda
        this.numRonda = 1;
   
        
        // Jugamos rondas hasta que haya un ganador
        while ( ganador == 0 ) {
            // jugar la ronda
            this.ronda();
            this.infoRonda();
        
            // hay ganador ????
            if ( this.numRonda < this.maxRondas ) {
                // Si estamos en la parte de "El mejor de X rondas"
                if (this.puntosJ1 >= this.ganaRonda) {
                    ganador = 1;
                }
                else if (this.puntosJ2 >= this.ganaRonda) {
                    ganador = 2;
                }
            }
            else {
                // Si estamos en la parte de la muerte súbita
                if ( this.puntosJ1 > this.puntosJ2 ){
                    ganador = 1;
                }
                else if ( this.puntosJ2 > this.puntosJ1 ) {
                    ganador = 2;
                }
            }
            
            // incremento la ronda
            this.numRonda++;
        }
        
        
        // Mostramos el ganador
        System.out.println("\n\n=============> RESULTADO");
        System.out.printf("\tDespues de %d rondas... ",this.numRonda);
        
        
        switch (ganador) {
            case 0:
                System.out.println("ha habido un empate.");    
                break;
            case 1:
                System.out.printf("ha ganado %s.\n",this.nombreJ1);    
                break;
            case 2:
                System.out.printf("ha ganado %s.\n", this.nombreJ2);    
                break;
        }
     
        // Cierro el scanner
        this.scan.close();
    }
}
