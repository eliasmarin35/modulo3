/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.avante.paresonones.logica;

/**
 *
 * @author jprof
 */
public enum ParesNonesEnum {
    PARES("pares") {
        @Override
        public ParesNonesEnum getContrario() {
            return ParesNonesEnum.NONES;
        }        
    },
    NONES("nones") {
        @Override
        public ParesNonesEnum getContrario() {
            return ParesNonesEnum.PARES;
        }        
    },
    ERROR("error") {
        @Override
        public ParesNonesEnum getContrario() {
            return ParesNonesEnum.ERROR;
        }        
    };
    
    private String texto;
    
    private ParesNonesEnum(String t) {
        this.texto = t;
    }
    
    @Override
    public String toString() {
        return this.texto;
    }
    
    public static ParesNonesEnum paresNonesTexto(String t) {
        ParesNonesEnum resultado;
        
        t = t.trim().toUpperCase();
        
        switch(t) {
            case "PARES":
                resultado = ParesNonesEnum.PARES;
                break;
            case "NONES":
                resultado = ParesNonesEnum.NONES;
                break;
            default:
                resultado = ParesNonesEnum.ERROR;
                break;
        }
        
        return resultado;
    }
    
    public abstract ParesNonesEnum getContrario ();
}
