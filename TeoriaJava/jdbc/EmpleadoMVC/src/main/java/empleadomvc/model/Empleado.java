/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleadomvc.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jprof
 */

// @Data => getters y setters, toString, equals y hashCode
// POJO = Plain Old Java Object
//      * Clase con atributos privados, sin restricciones
//      * Sirve para mapear entidades
//      * No debe depender de ningún framework externo ni
//          implementar interfaces de estos
//
// Java Bean
//      * Ademas de ser un POJO
//      * Obligatorio:
//          * Constructor sin parametros
//          * getter y setters normalizados (que el nombre sea getCampo o setCampo)
//      * Recomendable:
//          * Implementar la interfaz Serializable
//
//  La interfaz serializable marca una clase indicando que sus objetos se pueden leer
//      y escribir de/en un flujo de bytes (un fichero, por ejemplo).
//  No tenemos que implementar nada, Java ya hará lo que tenga que hacer para
//      que esto sea posible.
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Empleado implements Serializable {
    private int id;
    private String nombre;
    private double salario;
}
