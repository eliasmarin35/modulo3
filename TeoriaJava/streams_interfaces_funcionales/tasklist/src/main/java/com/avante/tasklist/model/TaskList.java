/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.tasklist.model;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;
import java.util.stream.Stream;

/**
 * Una estructura que almacena tareas en forma de cola de prioridad
 *
 * @author jprof
 */
public class TaskList {

    private PriorityQueue<Task> prioritiesList;
    private LinkedHashSet<Task> taskList;

    /**
     * Constructor por defecto, inicializa la cola de prioridad
     */
    public TaskList() {
        this.prioritiesList = new PriorityQueue<>();
        this.taskList = new LinkedHashSet<>();
    }

    /**
     * Añade una tarea a la estructura
     *
     * @param t objecto Task que se va a añadir
     */
    public void add(Task t) {
        this.prioritiesList.add(t);
        this.taskList.add(t);
    }

    /**
     * Saca el siguiente elemento de la cola de prioridad, sacara el primero que
     * llego con prioridad maxima.
     *
     * @return
     */
    public Task poll() {
        Task t = this.prioritiesList.poll();
        this.taskList.remove(t);
        
        return t;
    }

    /**
     * Devuelve un iterador para nuestra cola de prioridad
     *
     * @return el iterador
     */
    public Iterable<Task> prioritiesIterable() {
        return this.prioritiesList;
    }
    
    /**
     * Devuelve un iterador que recorre los elementos en el orden de entrada
     *
     * @return el iterador
     */
    public Iterable<Task> listIterable() {
        return this.taskList;
    }
    
    /**
     * Devuelve un stream para nuestra cola de prioridad
     *
     * @return el stream
     */
    public Stream<Task> prioritiesStream() {
        return this.prioritiesList.stream();
    }
    
    /**
     * Devuelve un stream que recorre los elementos en el orden de entrada
     *
     * @return el stream
     */
    public Stream<Task> listStream() {
        return this.taskList.stream();
    }
    
    
}
