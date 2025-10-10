/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listatareas.tests.listatareas;

import listatareas.model.TaskList;
import listatareas.model.Priority;
import listatareas.model.Task;
import listatareas.model.streamutils.FiltraTarea;
import listatareas.model.streamutils.PrintString;
import listatareas.model.streamutils.PrintTarea;
import listatareas.model.streamutils.XformTarea;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author jadmin
 */
public class TestListaTareasClasesUtil extends TestListaTareasBase {
    public static void main (String[] args) {
        new TestListaTareasClasesUtil().test();
    }
    
    protected void process(TaskList tareas) {
        List<Task> filtrada;
        
        System.out.println("\n======> COMO LISTA");
        tareas.listaStream()
            .forEach(new PrintTarea());
        
        
        System.out.println("\n======> COMO PRIORIDADES");
        tareas.prioridadStream()
                .forEach(new PrintTarea());
        
        
        System.out.println("\n======> COMO LISTA, SOLO ALTA ==> GUARDADA");
        filtrada = tareas.listaStream()
            .filter(new FiltraTarea(Priority.ALTA))
            .collect(Collectors.toList());
        
        
        System.out.println("\n======> FILTRADA");
        filtrada.stream()
            .forEach(new PrintTarea());
        
        
        System.out.println("\n======> FILTRADA XFORM");
        filtrada.stream()
            .map(new XformTarea())
            .forEach(new PrintString());
    }
}
