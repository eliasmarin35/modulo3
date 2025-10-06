/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.clasesgenericas_dos.logica;

/*
    OJO !!!!!

    Esta clase se creó para recordar lon queb eran los record y no se usa en el
        resto del proyecto.

    Si estás leyendo esto porque estás repasando clases genéricas, puedes
        ignorar este archivo.
*/



/**
 *
 * @author Juanma
 */

/*
    Podria ser que este record representara una fila de una supuesta tabla
      "Usuarios" en una base de datos.
    En ese caso, cada campo del record representaría un atributo de la tabla.

    En el caso de esta implementación (UsuarioRecord), la tabla podría ser la
       siguiente:

    CREATE TABLE IF NOT EXISTS "Usuarios" (
        nombreUsuario VARCHAR(500) PRIMARY KEY,
        contrasenya   VARCHAR(500) NOT NULL,
        email         VARCHAR(500) NOT NULL
    );

    Nuestro codigo Java en algún momento podría hacer una consulta a la base
      de datos:

    SELECT nombreUsuario, contrasenya, email FROM "Usuarios";

    Y almacenar cada fila devuelta como un objeto record UsuarioRecord (en
       un array o algún tipo de colección (como Listas o Conjuntos)).
*/
public record UsuarioRecord (
        String nombreUsuario,
        String contrasenya,
        String email
) {}
