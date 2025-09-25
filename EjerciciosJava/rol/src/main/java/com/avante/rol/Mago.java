package com.avante.rol;



public class Mago extends Personaje {

    // Constante específica para el Mago
    public static final int ATAQUE_MAGO = 45;
        
    // Constructor que llama al constructor de la clase padre
    public Mago(String nombre) {
        super(nombre,100,25); // defensa mago 25
    }

    // Implementación obligatoria del método abstracto atacar
    @Override
    public void atacar(Personaje objetivo, Personaje origen) {
        if (origen.vida > 0) {
            System.out.println(this.nombre + " lanza una bola de fuego a " + objetivo.getNombre() + "!");
            if (ATAQUE_MAGO < origen.defensa) {
                objetivo.recibirDano(-(ATAQUE_MAGO - origen.defensa));
            }else{
                objetivo.recibirDano(ATAQUE_MAGO - origen.defensa);
            }
        }else{
            System.out.println(origen.nombre + "esta muerto y no puede atacar. ");
        }
        
    }
}