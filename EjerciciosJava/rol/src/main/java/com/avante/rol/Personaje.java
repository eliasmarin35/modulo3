package com.avante.rol;



public abstract class Personaje {

    protected String nombre;
    protected int vida;
    protected int defensa;

    // Constructor para inicializar los atributos básicos
    public Personaje(String nombre, int vida, int defensa) {
        this.nombre = nombre;
        this.vida = vida;
        this.defensa = defensa;
    }

    // Método abstracto: cada subclase DEBE implementar su propia lógica de ataque
    public abstract void atacar(Personaje objetivo, Personaje origen);

    // Calculamos el daño recibido y lo devolvemos
    public void recibirDano(int cantidad) {
        
        if (this.vida <= 0) {
            this.vida = 0;
            System.out.println("El jugador esta muerto no puede recibir dano. ");
            
        }else{
            this.vida -= cantidad;
            System.out.println(this.nombre + " recibe " + cantidad + " de dano. Vida restante: " + this.vida);
        }
        
    }

    // Getters para acceder a la información del personaje
    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }
}