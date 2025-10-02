/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.avante.enumsimple.logica;

/**
 *
 * @author Juan Manuel
 */
public enum DiaSemanaInt {
    MON("Monday","Lunes") {
        @Override
        public int getHorasCurro() {
            return 6;
        }
    },
    
    TUE("Tuesday","Martes") {
        private int horas=10;
        
        @Override
        public int getHorasCurro() {
            return horas;
        }
    },
    
    WED("Wednesday","Miércoles") {
        @Override
        public int getHorasCurro() {
            return 10;
        }
    },
    
    THU("Thursday","Jueves") {
        @Override
        public int getHorasCurro() {
            return 9;
        }
    },
    
    FRI("Friday","Viernes") {
        @Override
        public int getHorasCurro() {
            return 6;
        }
    },
    
    SAT("Saturday","Sábado") {
        @Override
        public int getHorasCurro() {
            return 0;
        }
    },
    
    SUN("Sunday","Domingo") {
        @Override
        public int getHorasCurro() {
            return 0;
        }
    };
    
    private String nombreIngles;
    private String nombreEspanol;
    
    private DiaSemanaInt() {}
    
    private DiaSemanaInt(String nI, String nE) {
        this.nombreIngles = nI;
        this.nombreEspanol = nE;
    }
    
    public String getIngles() {
        return this.nombreIngles;
    }
    
    public String getEspanyol() {
        return this.nombreEspanol;
    }
    
    public abstract int getHorasCurro();
    
    @Override
    public String toString() {
        return String.format("Día %s.", this.nombreEspanol);
    } 
    
    
    
    
}
