/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.avante;

/**
 
 * @author Juan Manuel
 */
public class DiasMesAnyo {

    public static void main(String[] args) {
        // VARS
        String mes="";
        int anyo=0;
        int dias=0;
        boolean ok=true;
        
        // CUERPO
        
        // Comprobamos que al menos hay 2 argumentos de entrada
        if (args.length < 2) {
            // ERR
            System.err.println("Al menos me hacen falta dos argumentos.");
            ok=false;
        }
        
        // Si no hubiera println, todo el if de arriba es equivalente a esta
        //    asignacion
        // ok=(args.length > 1);
        
        // Recuperamos los datos a partir de los argumentos de entrada
        if (ok) {
            mes=args[0];
            
            try {
                anyo=Integer.parseInt(args[1]);
            }
            catch (NumberFormatException err) {
                // ERR
                ok=false;
            }
        }
        
        // Calcular el número de dias 
        if (ok) {
            dias = diasMesAnyo(mes,anyo);
            
            // Si la variable "mes" no es un mes de verdad, la función
            //     va a devoler -1.
            // Sabiendo eso, podemos poner ok a false si el numero de dias
            //     es menor que 0.
            ok = dias > 0;
        }
    
        if (ok) {
            System.out.println("El mes "+ mes +" del año "+ anyo +" tiene "+ dias +" días.");
        }
    }
    
    /**
     * Esta funcion devuelve el numero de dias que tiene un mes de un año
     * 
     * @param mes Cadena de texto que representa el mes (ej. "octubre").
     * @param anyo Número entero que representa el año (ej. 2025)
     * 
     * @return El número de días que tiene ese mes en ese año.
     */
    public static int diasMesAnyo (String mes, int anyo) {
        // VARS
        int dias=-1;
        
        // CUERPO
        
        // Modificamos la variable mes para ponerla en minusculas y ademas
        //    limpiar los posibles espacios que haya al principio o al final
        mes = mes.toLowerCase().trim();
        switch(mes) {
            case "enero":
            case "marzo":
            case "mayo":
            case "julio":
            case "agosto":
            case "octubre":
            case "diciembre":
                dias=31;
                break;
            case "abril":
            case "junio":
            case "septiembre":
            case "noviembre":
                dias=30;
                break;
            case "febrero":
                if (
                    (anyo % 400 == 0 )
                    || (
                        (anyo % 100 != 0)
                        && (anyo % 4 == 0)
                    )
                ) {
                    dias=29;
                }
                else {
                    dias=28;
                }
                break;
            default:
                System.err.println("El texto '"+ mes +"' no es un mes valido.");
                break;
        }
        
        // RETURNS
        return dias;
    }
}
