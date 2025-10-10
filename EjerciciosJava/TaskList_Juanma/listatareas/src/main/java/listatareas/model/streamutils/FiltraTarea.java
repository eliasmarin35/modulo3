/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listatareas.model.streamutils;

import listatareas.model.Priority;
import listatareas.model.Task;
import java.util.function.Predicate;

/**
 *
 * @author jadmin
 */
public class FiltraTarea implements Predicate<Task>{
    private final Priority prioridad;
    
    public FiltraTarea(Priority p) {
        this.prioridad = p;
    }
    
    @Override
    public boolean test(Task t) {
        return this.prioridad == t.prioridad();
    }
}
