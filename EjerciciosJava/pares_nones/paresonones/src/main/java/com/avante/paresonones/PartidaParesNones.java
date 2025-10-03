/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.avante.paresonones;

import com.avante.paresonones.logica.ParesNones;

/**
 *
 * @author jprof
 */
public class PartidaParesNones {

    public static void main(String[] args) {
        // Crea la partida
        ParesNones pn = new ParesNones();
        
        // Juega
        pn.jugar();
        
        // Cierra los recursos asociados a la partida
        pn.close();
    }
}
