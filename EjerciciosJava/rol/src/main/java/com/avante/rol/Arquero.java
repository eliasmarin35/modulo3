package com.avante.rol;




public class Arquero extends Personaje {

    // Constante específica para el Mago
    public static final int ATAQUE_ARQUERO = 35;
        
    // Constructor que llama al constructor de la clase padre
    public Arquero(String nombre) {
        super(nombre, 100, 35); // defensa arquero 35
    }

    // Implementación obligatoria del método abstracto atacar
    @Override
    public void atacar(Personaje objetivo, Personaje origen) {
        if (origen.vida > 0) {
            System.out.println(this.nombre + " lanza una flecha a  " + objetivo.getNombre() + "!");
            if (ATAQUE_ARQUERO < origen.defensa) {
                objetivo.recibirDano(-(ATAQUE_ARQUERO - origen.defensa));
            }else{
                objetivo.recibirDano(ATAQUE_ARQUERO - origen.defensa);
            }
        }else{
            System.out.println(origen.nombre + "esta muerto y no puede atacar. ");
        }
        
    }
}