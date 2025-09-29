/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.rpg.logica;

/**
 *
 * @author Juan Manuel
 */
public abstract class Personaje {
    private int vida = 100;
    private String nombre = "[..X..]";
    
    
    public Personaje (String nombre) {
        this.nombre = nombre.trim();
        
        System.out.printf("** He creado un %s de nombre %s.\n\n",
            this.getProfesion(),
            this.nombre
        );
    }
    
    
    /**
     * Esté método devuelve la profesión del personaje
     * 
     * @return la profesión del personaje 
     */
    public abstract String getProfesion(); 
    
    protected abstract int getAtaque();
    
    protected abstract int getDefensa();
    
    private boolean estaMuerto () {
        return this.vida <= 0;
    }
    
    private void recibeDanyo (int danyo) {
        this.vida = Math.max(0, this.vida - danyo);
    }
    
    private int calculaDanyo(Personaje contri) {
        return Math.max(0, this.getAtaque() - contri.getDefensa());
    }
    
    /**
     * Este método simula el ataque del objecto hacia otro Personaje.
     * 
     * @param contri El Personaje al que se ataca 
     */
    public void ataca(Personaje contri) {
        int danyo = 0;
       
        // Mensaje de intento de ataque
        System.out.printf(
            "[%s:%d] %s ataca a [%s:%d] %s.\n",
                this.getProfesion(),
                this.vida,
                this.nombre,
                contri.getProfesion(),
                contri.vida,
                contri.nombre
        );
        
        if (this.estaMuerto()) {
            System.out.printf(
                "=> %s está muerto y NO PUEDE ATACAR.",
                this.nombre
            );
        }
        else {
            if (contri.estaMuerto()) {
                System.out.printf(
                    "=> %s está muerto y NO SIRVE DE NADA ATACARLE.",
                    contri.nombre
                );
            }
            else {
                // Resolución del daño
                danyo = this.calculaDanyo(contri);

                // Aplicamos el daño
                contri.recibeDanyo(danyo);

                // Mostrar como queda la vida despues del ataque
                System.out.printf(
                    "=> %s recibe %d de daño y se queda con %d de vida.",
                    contri.nombre,
                    danyo,
                    contri.vida
                );
            }
        }
        
        System.out.println("\n");
    }
}
