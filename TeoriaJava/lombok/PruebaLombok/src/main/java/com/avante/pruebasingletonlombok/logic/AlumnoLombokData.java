/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.pruebasingletonlombok.logic;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
 La anotación @Data es lo mismo que haber puesto:
 
    * Para todos los atributos
        * @Getter y @Setter

    * En la clase
        * @ToString @EqualsAndHashCode y @RequiredArgsConstructor
 */
@AllArgsConstructor
@Data
public class AlumnoLombokData {
    private int    numero;
    private String nombre;
}
