package com.zoologico.animales;

public class Leon extends Animal {

    public Leon(String nombre, int edad) {
        // Llama al constructor de la clase padre (Animal)
        super(nombre, edad, "Carnívoro");
    }

    // Método propio de Leon
    public void rugir() {
        System.out.println(getNombre() + " está rugiendo: ¡ROAR!");
    }

    // Sobrescribe el método comer()
    @Override
    public void comer() {
        System.out.println(getNombre() + ", que es " + this.tipoAlimentacion + ", está comiendo carne.");
    }
}