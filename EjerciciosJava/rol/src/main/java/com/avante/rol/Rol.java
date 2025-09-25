

package com.avante.rol;
import java.util.Scanner;


public class Rol {

    public static void main(String[] args) {
        
        // Creamos instancias de las clases hijas
        Guerrero guarrero = new Guerrero("John Snow");
        Mago maguito = new Mago("Harry Potter");

        System.out.println(guarrero.getNombre() + " (Vida: " + guarrero.getVida() + ")");
        System.out.println(maguito.getNombre() + " (Vida: " + maguito.getVida() + ")");
        System.out.println("------------------------------------");

        // Atacamos
        
        maguito.atacar(guarrero, maguito);
        guarrero.atacar(maguito, guarrero);
        maguito.atacar(guarrero, maguito);
        maguito.atacar(guarrero, maguito);
        maguito.atacar(guarrero, maguito);
        maguito.atacar(guarrero, maguito);
        maguito.atacar(guarrero, maguito);
        maguito.atacar(guarrero, maguito);
        maguito.atacar(guarrero, maguito);
        maguito.atacar(guarrero, maguito);
        guarrero.atacar(maguito, guarrero);


        System.out.println("------------------------------------");
        System.out.println("Fin del combate.");
        System.out.println(guarrero.getNombre() + " - Vida final: " + guarrero.getVida());
        System.out.println(maguito.getNombre() + " - Vida final: " + maguito.getVida());
    }
}