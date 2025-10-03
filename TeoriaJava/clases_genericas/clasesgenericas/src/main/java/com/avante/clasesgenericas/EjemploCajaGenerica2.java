/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.clasesgenericas;

import com.avante.clasesgenericas.logica.CajaGen2;
import com.avante.clasesgenericas.logica.PersonaRecord;

/**
 *
 * @author jprof
 */
public class EjemploCajaGenerica2 {

    public static void main(String[] args) throws Exception {
        CajaGen2<PersonaRecord, Integer> caja = new CajaGen2<>();
        caja.setContenido1(new PersonaRecord("Pepe", 34));
        caja.setContenido2(65);
    }

}
