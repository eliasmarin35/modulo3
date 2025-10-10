/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listatareas.model;

import java.util.LinkedHashSet;
import java.util.PriorityQueue;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 *
 * @author jadmin
 */
public class TaskList {
    private PriorityQueue<Task> prioT;
    private LinkedHashSet<Task> listaT;
    
    public TaskList () {
        this.prioT  = new PriorityQueue<>();
        this.listaT = new LinkedHashSet<>();
    }
    
    public void add(Task t) {
        this.prioT.add(t);
        this.listaT.add(t);
    }
    
    public void add(Priority p, String s) {
        this.add(new Task(p,s));
    }
    
    public Task poll() {
        Task t = null;
        
        if ( !this.prioT.isEmpty() ) {
             t = this.prioT.poll();
             this.listaT.remove(t);
        }
        
        return t;
    }
    
    public boolean isEmpty() {
        return this.prioT.isEmpty();
    }
    
    public int size() {
        return this.prioT.size();
    }
    
    // ======== ITERABLES
    public Iterable<Task> prioridadIterable() {
        return this.prioT;
    }
    
    public Iterable<Task> listaIterable() {
        return this.listaT;
    }
    
    // ======== STREAMS
    public Stream<Task> prioridadStream() {
        return this.prioT.stream();
    }
    
    public Stream<Task> listaStream() {
        return this.listaT.stream();
    }
}
