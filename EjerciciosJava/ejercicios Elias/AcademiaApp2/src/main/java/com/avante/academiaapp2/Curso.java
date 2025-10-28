
package com.avante.academiaapp2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;




@Entity
@Table(name="cursos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Curso implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    
    @Column(nullable=false, length=100)
    private String nombre;
    
    
    @Column(nullable=false)
    private LocalDate fecha_inicio;
    
    
    @Column(nullable=false)
    private LocalDate fecha_fin;
    
    
}
