/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.tasklist.test.task;

import com.avante.tasklist.model.PriorityEnum;
import com.avante.tasklist.model.Task;
import com.avante.tasklist.model.TaskList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 *
 * @author jprof
 */
public class TestTaskList2 {
    
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
        Consumer<Task> imprimeTask = t -> System.out.println(t);
       
        // 1- Recorro la lista con foreach
        System.out.println("\n====> 1 recorro con for each");
        tl.listStream()
                .forEach( imprimeTask );

        
        // 2- Filtro y me quedo solo con los de alta prioridad
        System.out.println("\n====> 2 filtro solo los de alta prioridad");
        tl.listStream()
                .filter( t -> t.priority() == PriorityEnum.HIGH )
                .forEach( imprimeTask );
        
        
        // 3- Filtron los de alta prioridad y los salvo en una lista
        System.out.println("\n====> 3 filtro solo los de alta prioridad y salvo en lista");
        
        List<Task> listaFiltrada = tl.listStream()
                .filter( t -> t.priority() == PriorityEnum.HIGH )
                .collect( Collectors.toList() );
        
        listaFiltrada.stream()
                .forEach(imprimeTask);
        
        
        // 4 - Filtro por LOW , y pongo el texto en mayusculas
        System.out.println("\n====> 3 filtro solo los de baja prioridad y salvo en lista");
        
        tl.listStream()
                .filter( t -> t.priority() == PriorityEnum.LOW )
                .map( t -> t.taskName().trim().toUpperCase() )
                .forEach( s -> System.out.printf("TASK: %s\n",s) );
    }
}
