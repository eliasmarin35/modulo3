/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listatareas.tests.listatareas;

import listatareas.model.TaskList;
import listatareas.model.Priority;
import listatareas.model.Task;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author jadmin
 */
public class TestListaTareas extends TestListaTareasBase {
    public static void main (String[] args) {
        new TestListaTareas().test();
    }
    
    protected void process(TaskList tareas){
        List<Task> filtrada;
        
        
        System.out.println("\n======> COMO LISTA");
        tareas.listaStream()
            .forEach(Task.print);
        
        
        System.out.println("\n======> COMO PRIORIDADES");
        tareas.prioridadStream()
                .forEach(Task.print);
        
        
        System.out.println("\n======> COMO LISTA, SOLO ALTA => GUARDALO");
        filtrada = tareas.listaStream()
            .filter(Task.filter(Priority.ALTA))
            .collect(Collectors.toList());
        
        
        System.out.println("\n======> Filtrada");
        filtrada.stream()
            .forEach(Task.print);
        
        
        System.out.println("\n======> Filtrada XFORM");
        filtrada.stream()
            .map(Task.xform)
            .forEach(Task.printString);
    }
}
