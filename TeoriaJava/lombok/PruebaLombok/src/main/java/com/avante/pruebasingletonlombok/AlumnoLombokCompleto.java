/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.pruebasingletonlombok;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

/*
 * Lombok interpreta anotaciones en las clases, metodos y atributos.
 * Y en la fase de compilación inyecto código en función de dichas anotaciones.
 * Este código estará disponible para el resto de nuestras clases Java
 *    en forma de nuevos métodos, e implementaciones de interfaces.
 * 
 * En cada atributo se puede usar:
 *  @Getter -> crea un getter para el atributo
 *  @Setter -> crea un setter para el atributo
 * 
 *      (en ambos, getter y setter, se puede especificar un parametro con
 *          los siguientes valores:
 *              ACCESS_LEVEL.PRIVATE
 *              ACCESS_LEVEL.PACKAGE
 *              ACCESS_LEVEL.PUBLIC
 * 
 *          para indicar el modificador de visibilidad que tendrá el método
 *              generado
 *          )
 * 
 *  @NonNull -> Indica que el atributo no puede ser null (solo vale para
 *      atributos que sean objetos). Si en algún momento establecemos el
 *      atributo a null a través del setter, saltará una NullPointerException
 * 
 * 
 * En cada clase se puede usar:
 *  @ToString -> crea un método toString que mostrará todos los atributos
 *      ( añadiendo el parámetro exclude="campo", se excluye el campo indica
 *          de la respresentación textual que devuelve toString)
 *
 *  @NoArgsConstructor -> Crea un constructor sin parametros para nuestra clase
 *  @AllArgsConstructor -> Crea un constructor con todos los parametros
 *      necesarios para inicializar los atributos de nuestra clase.
 * 
 *  @EqualsAndHashCode -> Crea los métodos equals y hashCode para nuestra clase
 *
 *
 *  Cuando la clase que estamos modificando con Lombok se va a usar para
 *      mapear una tabla en una base de datos, son necesarios:
 *
 *      * el constructor sin parametros -> @NoArgsConstructor
 *      * los metodos equals y hashCode -> @EqualsAndHashCode
 *      * getters y setters para los atributos -> @Getter / @Setter
 *
 *
 */
@ToString(exclude="numero")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AlumnoLombokCompleto {
    @Getter()
    @Setter
    private int    numero;
    
    @Getter
    @Setter
    @NonNull
    private String nombre;
}
