/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listatareas.tests.listatareas;

import listatareas.model.TaskList;
import listatareas.model.Priority;
import listatareas.model.Task;

/**
 *
 * @author jadmin
 */
public class TestListaTareasIterator extends TestListaTareasBase {
    public static void main (String[] args) {
        new TestListaTareasIterator().test();
    }
    
    @Override
    protected void process(TaskList tareas) {        
        System.out.println("\n======> FOR-EACH LISTA");
        for (Task t : tareas.listaIterable()) {
            System.out.println(t);
        }
        
        
        System.out.println("\n======> FOR-EACH PRIORITY");
        for (Task t : tareas.prioridadIterable()) {
            System.out.println(t);
        }
    }
}
