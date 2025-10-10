/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listatareas.tests.listatareas;

import listatareas.model.TaskList;
import listatareas.model.Priority;


/**
 *
 * @author jadmin
 */
public abstract class TestListaTareasBase {
    private TaskList tareas;
    
    protected void test() {
        this.tareas = new TaskList();
        
        this.tareas.add(Priority.BAJA, "Tarea 1");
        this.tareas.add(Priority.ALTA, "Tarea 2");
        this.tareas.add(Priority.BAJA, "Tarea 3");
        this.tareas.add(Priority.ALTA, "Tarea 4");
        this.tareas.add(Priority.MEDIA,"Tarea 5");
        this.tareas.add(Priority.BAJA, "Tarea 6");
        
       this.process( this.tareas );
    }
    
    protected abstract void process( TaskList t );
}
