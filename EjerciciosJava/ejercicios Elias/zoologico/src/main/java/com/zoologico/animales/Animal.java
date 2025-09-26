package com.zoologico.animales;

public class Animal {
    // Atributos privados
    private String nombre;
    private int edad;

    // Atributo protegido para ser usado por las clases hijas
    protected String tipoAlimentacion;

    // Constructor público
    public Animal(String nombre, int edad, String tipoAlimentacion) {
        this.nombre = nombre;
        this.edad = edad;
        this.tipoAlimentacion = tipoAlimentacion;
    }

    // Método público
    public void comer() {
        System.out.println(this.nombre + " está comiendo.");
    }
    
    // Getters públicos
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}