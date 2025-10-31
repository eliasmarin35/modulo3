/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.avante.usersrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author jprof
 */

/*
    @SpringBootApplication
        es un atajo equivalente a incluir las tres anotaciones siguientes

    ...

    @Configuration
        marca la clase como la que va a configurar spring boot mediante la
            posibilidad de agregar JavaBeans marcados con @Bean
    
    @EnableAutoConfiguration
        configura el comportamiento de springboot y que clases va a cargar
            dependiendo de las dependencias que encuentre en el classpath
               (por ejemplo las que hayamos añadido en el pom)
    
    @ComponentScan
        le dice a spring que escanee el paquete donde se encuentra esta clase
            y sus descendientes buscando beans para registrar (@Component,
            @Service, @Repository, @Controller, etc).
*/

@SpringBootApplication
public class UsersRestApp {

    public static void main(String[] args) {
        SpringApplication.run(UsersRestApp.class, args);
    }
}
