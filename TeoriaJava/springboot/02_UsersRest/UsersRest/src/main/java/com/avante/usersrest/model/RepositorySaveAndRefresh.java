/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.avante.usersrest.model;

/**
 * Esta interfaz la necesitamos porque vamos a cambiar el comportamiento del
 *    método save del JPARepository para el repositorio de usuarios. Esto es
 *    necesario para que el valor de creationTimestamp se actualize al
 *    insertar un User en la base de datos. creationTimestamp en la base de
 *    datos tiene una restricción DEFAULT y por tanto lo hemos excluido del
 *    insert si es null. Pero entonces al insertar nos quedamos con un objeto
 *    que no sabe que válor tiene currentTimestamp (lo ha asignado postgresql
 *    automáticamente como hace con los ids). La solución es hacer un refresh
 *    después de save, para asegurarse que los datos del objeto Java se
 *    actualizan con los valores que hay en la base de datos.
 * 
 * Como el código de la implementación lo genera spring y no queremos escribir
 *    todo el código del repositorio, hacemos una interfaz solo con el método
 *    que vamos a modificar.
 * 
 * También crearemos una clase concreta UserRepositorySaveImplementation para
 *    implementar el código.
 * 
 * Después cuando se cree la interfaz del repositorio UserRepository esta
 *    interfaz heredará de JPARepository y también de esta interfaz en este
 *    archivo. (En JAVA las clases solo pueden tener 1 padre, pero las
 *    interfaces pueden tener todos los que se quiera).
 * 
 * Cuando Spring genere la implementación del repositorio, al ver que también
 *    hereda de esta clase y al saber que esta clase tiene una implementación
 *    que hemos hecho nosotros, las combinará, sobreescribiendo el método save
 *    por nuestra versión.
 * 
 * @author jprof
 */

public interface RepositorySaveAndRefresh<T> {
    T save(T entity);
}
