/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.tasklist;

import com.avante.tasklist.model.PriorityEnum;
import com.avante.tasklist.model.Task;
import com.avante.tasklist.model.TaskList;
import java.util.function.Consumer;

/**
 *
 * @author jprof
 */
public class EjemplosDeUsoInterfacesFuncionales_Streams {
    
    public static void imprimeEstatico(Task t) {
        System.out.printf("........%s.......\n", t);
    }
    
    public static void main (String[] args) {
        TaskList tl = new TaskList();
        
        tl.add(new Task(PriorityEnum.LOW, "Nombre1"));
        tl.add(new Task(PriorityEnum.HIGH, "Alta1 "));
        tl.add(new Task(PriorityEnum.LOW, "Nombre32"));
        tl.add(new Task(PriorityEnum.HIGH, "Alta2"));
        tl.add(new Task(PriorityEnum.LOW, "Nombre15"));
        tl.add(new Task(PriorityEnum.HIGH, "Alta1546"));
        tl.add(new Task(PriorityEnum.LOW, "Nombre320909"));
        tl.add(new Task(PriorityEnum.HIGH, "Alta2567"));
       
        
        /// ====== streams
       
        /// Consumers
        /*
            Los Consumers hacen "algo" con los datos del stream.
        */
        
        // 1- Con Lambda function
        System.out.println("\n 1- Foreach con lambda");
        tl.listStream()
            .forEach( t -> System.out.println(t) );
        
        System.out.println("\n\n");
        
        
        
        // 2- Foreach con el lambda en una variable
        System.out.println("\n 2- Foreach con la lambda en una funcion");
        Consumer<Task> imprime =  t -> System.out.printf("--T:%s\n",t);
        tl.listStream()
            .forEach( imprime );
        
        
        // 3- Usando un metodo estatico con el operador ::
        System.out.println("\n 3- Foreach con un metodo estatico");
        tl.listStream()
            .forEach( EjemplosDeUsoInterfacesFuncionales_Streams::imprimeEstatico );
        
        // 3.5- Con un metodo estatico que ya exista
        System.out.println("\n 3.5 - Foreach con system.out.println");
        tl.listStream()
            .forEach( System.out::println );
        
        System.out.println("\n\n");
        
        
        // 4- Usando una clase anonima
        System.out.println("\n 3- Foreach con una clase anonima");
        tl.listStream()
            .forEach( new Consumer<Task>() {
                @Override
                public void accept(Task t) {
                    System.out.printf("**********%s***********\n",t);
                } 
            } );
        
        
        // 5- Usando herencia de Java tradicional
        System.out.println("\n 5- Foreach con clases tradicionales");
        tl.listStream()
            .forEach( new ImpresionTask() );
        
    }
}
