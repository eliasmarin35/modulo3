/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.avante.ppt;

import com.avante.ppt.logica.PPT;


/**
 *
 * @author Juan Manuel
 */
public class PartidaPiedraPapelTijera {
    
    private static String compruebaArgCadena(String miArgumento, String valorDefecto) {
        String resultado = valorDefecto;
        
        miArgumento=miArgumento.trim();
        
        if ( !miArgumento.equals("") ) {
            resultado = miArgumento;
        }
        
        return resultado;
    }
    
    private static int compruebaArgEntero(String miArgumento, int valorDefecto) {
        int resTemporal;
        int resultado = valorDefecto;
        
        miArgumento=miArgumento.trim();
        
        if ( !miArgumento.equals("") ) {
            try {
                resultado = Math.max(1, Integer.parseInt(miArgumento));                
            }
            catch (NumberFormatException e) {
                resultado = valorDefecto;
            }
        }
        
        return resultado;
    }

    public static void main(String[] args) {
        String[] args2 = {"Javier","Fernando","4"};
        
        String nombreJ1 = "J1";
        String nombreJ2 = "J2";
        int maxRondas = 3;
        
        if (args2.length > 0) {
            nombreJ1 = compruebaArgCadena(args2[0], nombreJ1);
  
            if (args2.length > 1) {
                nombreJ2 = compruebaArgCadena(args2[1], nombreJ2);

                if (args2.length > 2) {
                    maxRondas = compruebaArgEntero(args2[2], maxRondas);
                }
            }
        }

        PPT partida = new PPT(nombreJ1,nombreJ2,maxRondas);
        
        System.out.println(partida);
        
        partida.jugar();
    }
}
