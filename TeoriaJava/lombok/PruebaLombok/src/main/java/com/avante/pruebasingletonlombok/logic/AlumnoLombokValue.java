/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.pruebasingletonlombok.logic;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

/*
 La anotación @Value es lo mismo que @Data:
 
    * Para todos los atributos
        * @Getter y @Setter

    * En la clase
        * @ToString @EqualsAndHashCode y @RequiredArgsConstructor

  Con el agregado de convertir al objeto de la clase en inmutable.
  Es decir, una vez establecidos los atributos de la clase, no podrán cambiarse
  En el fondo lo que hace es hacerlos final
 */
@Value
public class AlumnoLombokValue {
    private int    numero;
    private String nombre;
}
