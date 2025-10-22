/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.academia.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jprof
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alumno {
    private int id;
    private String nombre;
    private String apellidos;
    private String email;
    private int curso_id;
}
