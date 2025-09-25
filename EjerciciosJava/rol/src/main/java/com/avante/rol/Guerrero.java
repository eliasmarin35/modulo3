package com.avante.rol;



public class Guerrero extends Personaje {

    // Constante específica para el Guerrero
    public static final int ATAQUE_GUERRERO = 25;
    
    // Constructor que llama al constructor de la clase padre
    public Guerrero(String nombre) {
        super(nombre,100,50); // defensa guerrero 50
    }

    // Implementación obligatoria del método abstracto atacar
    @Override
    public void atacar(Personaje objetivo, Personaje origen) {
        if (origen.vida > 0) {
            System.out.println(this.nombre + " ataca con su espada a " + objetivo.getNombre() + "!");
            if (ATAQUE_GUERRERO < origen.defensa) {
                objetivo.recibirDano(-(ATAQUE_GUERRERO - origen.defensa));
            }else{
                objetivo.recibirDano(ATAQUE_GUERRERO - origen.defensa);
            }
        }else{
            System.out.println(origen.nombre + "esta muerto y no puede atacar. ");
        }
        
    }
}