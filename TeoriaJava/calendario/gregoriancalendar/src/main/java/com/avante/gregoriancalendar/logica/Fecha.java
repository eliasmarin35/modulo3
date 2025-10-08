
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.gregoriancalendar.logica;

import java.util.GregorianCalendar;

/**
 *
 * @author jprof
 */
public class Fecha {
    private int dia;
    private int mes;
    private int anyo;
    
    public Fecha(int d, int m, int a) {
        this.dia = d;
        this.mes = m;
        this.anyo = a;
    }
    
    public String toString () {
        return String.format("%02d/%02d/%04d",this.dia,this.mes,this.anyo);
    }
    
    public static void printGc (GregorianCalendar gc) {
        System.out.printf("%02d/%02d/%04d",
                gc.get(GregorianCalendar.DAY_OF_MONTH),
                gc.get(GregorianCalendar.MONTH),
                gc.get(GregorianCalendar.YEAR)
        );
    }
    
    public void addDias(int n) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(GregorianCalendar.DAY_OF_MONTH,this.dia);
        gc.set(GregorianCalendar.MONTH, this.mes);
        gc.set(GregorianCalendar.YEAR, this.anyo);
        
        gc.add(GregorianCalendar.DAY_OF_MONTH, n);
        
        this.dia = gc.get(GregorianCalendar.DAY_OF_MONTH);
        this.mes = gc.get(GregorianCalendar.MONTH);
        this.anyo = gc.get(GregorianCalendar.YEAR);
    }

    
    // ==== GETTERS AND SETTERS ====
    /**
     * @return the dia
     */
    public int getDia() {
        return dia;
    }

    /**
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @return the anyo
     */
    public int getAnyo() {
        return anyo;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * @param anyo the anyo to set
     */
    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }
}
