
package com.avante.academiaapp2;

import modelo.Curso;
import modelo.CursosRepository;
import modelo.HibernateUtil;
import java.time.LocalDate;
import java.time.Month;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AcademiaApp2 {

    
    private static final Logger logger = LoggerFactory.getLogger(AcademiaApp2.class);
    
    public static void main(String[] args) {
        
        Curso curso = Curso.builder()
                .id(3)
                .nombre("El curso 1 de Elias")
                .fecha_inicio(LocalDate.of(2018, Month.MARCH, 8))
                .fecha_fin(LocalDate.of(2019, Month.DECEMBER, 20))
                .build();
        
        CursosRepository repo = new CursosRepository();
        //repo.insert(curso);
        
        //Curso curso = repo.retrieve(2);
        //System.out.println(curso);
        //repo.update(curso);
        //repo.remove(curso);
        repo.listAll().stream().forEach(System.out::println);
        HibernateUtil.getInstance().shutdown();

   }
    
   
   
   
}
