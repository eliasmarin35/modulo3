
package modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;



@Entity
@Table(name="alumnos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alumno {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false, length=50)
    private String name;
    
    @Column(nullable = false, length = 100)
    private String apellidos;
    
    @Column(length = 100)
    private String email;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name=id, nullable=false)
    private Curso curso;
         
}
