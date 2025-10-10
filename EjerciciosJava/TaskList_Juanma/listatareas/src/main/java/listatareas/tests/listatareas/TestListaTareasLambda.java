/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listatareas.tests.listatareas;

import listatareas.model.TaskList;
import listatareas.model.Priority;
import listatareas.model.Task;

import java.util.stream.Collectors;
import java.util.List;

/**
 *
 * @author jadmin
 */
public class TestListaTareasLambda extends TestListaTareasBase {
    public static void main (String[] args) {
        new TestListaTareasLambda().test();
    }
    
    @Override
    protected void process(TaskList tareas) {
        List<Task> filtrada;
        
        System.out.println("\n======> COMO LISTA");
        tareas.listaStream()
            .forEach(t -> System.out.println(t));
        
        
        System.out.println("\n======> COMO PRIORIDADES");
        tareas.prioridadStream()
            .forEach(t -> System.out.println(t));
        
        
        System.out.println("\n======> COMO LISTA, SOLO ALTA => Guardala");
        filtrada = tareas.listaStream()
            .filter(t -> t.prioridad() == Priority.ALTA)
            .collect(Collectors.toList());
        
        
        System.out.println("\n======> LA FILTRADA");
        filtrada.stream()
            .forEach( t -> System.out.println(t) );
        
        
        System.out.println("\n======> LA FILTRADA -> XFORM");
        filtrada.stream()
            .map( t -> t.texto() )
            .forEach( System.out::println );
    }
}
