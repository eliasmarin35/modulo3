/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.lecturaescrituraficheros.serializable;

import java.io.Serializable;

/**
 *
 * @author jprof
 */
// La interfaz Serializable marca una clase para que se pueda escribir o leer
//    a/de un archivo binario
public record Alumno (Integer num, String name) implements Serializable{}
