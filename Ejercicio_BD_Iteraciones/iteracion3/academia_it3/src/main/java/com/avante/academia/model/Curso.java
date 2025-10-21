/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.academia.model;

import java.io.Serializable;
import java.time.LocalDate;
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
public class Curso implements Serializable {
    private int id;
    private String nombre;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
}
