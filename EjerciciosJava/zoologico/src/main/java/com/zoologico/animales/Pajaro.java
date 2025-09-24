package com.zoologico.animales;

public class Pajaro extends Animal {

    public Pajaro(String nombre, int edad) {
        super(nombre, edad, "Granívoro");
    }

    // Método propio de Pajaro
    public void volar() {
        System.out.println(getNombre() + " está volando alto.");
    }
    
    // Sobrescribe el método comer()
    @Override
    public void comer() {
        System.out.println(getNombre() + ", que es " + tipoAlimentacion + ", está comiendo semillas.");
    }
}