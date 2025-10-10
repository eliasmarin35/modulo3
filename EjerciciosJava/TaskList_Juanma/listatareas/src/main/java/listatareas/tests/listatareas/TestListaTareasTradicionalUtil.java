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
public class TestListaTareasTradicionalUtil extends TestListaTareasBase{
    public static void main (String[] args) {
        new TestListaTareasTradicionalUtil().test();
    }
    
    @Override
    protected void process(TaskList tareas) {
        List<Task> filtrada;
        
        
        System.out.println("\n======> COMO LISTA");
        tareas.listaStream()
            .forEach(Task.printT());
        
        
        System.out.println("\n======> COMO PRIORIDADES");
        tareas.prioridadStream()
            .forEach(Task.printT());
        
        
        System.out.println("\n======> COMO LISTA, SOLO ALTA ==> GUARDA");
        filtrada = tareas.listaStream()
            .filter(Task.filterT(Priority.ALTA))
            .collect(Collectors.toList());
        
        
        System.out.println("\n======> FILTRADA");
        filtrada.stream()
            .forEach(Task.printT());
        
        
        System.out.println("\n======> FILTRADA XFORM");
        filtrada.stream()
            .map(Task.xformT())
            .forEach(Task.printStringT());
    }
}
