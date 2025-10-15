/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.pruebasingletonlombok.logic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 * 
 * 
 * @author jprof
 */
@AllArgsConstructor
@ToString
@Builder
public class AlumnoLombokBuilder {
    @Getter
    private int    numero;
    
    @Getter
    private String nombre;
}
