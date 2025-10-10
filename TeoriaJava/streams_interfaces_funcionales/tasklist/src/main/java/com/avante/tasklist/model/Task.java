/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.tasklist.model;

/**
 * Una tarea con prioridad y un texto que es el nombre de la tarea
 *
 * @author jprof
 */
public record Task(
        PriorityEnum priority,
        String taskName
        ) implements Comparable<Task> {

    /**
     * Representación textual de la tarea
     *
     * @return el texto de la tarea
     */
    @Override
    public String toString() {
        return String.format("<%s : %s>", this.priority, this.taskName);
    }

    /**
     * Compara la tarea con otra
     *
     * @param o la otra
     * @return 0 si las tareas son de la misma prioridad, >0 si this es mayor y
     * <0 si this es menor
     */
 
    @Override
    public int compareTo(Task o) {
        return this.priority.ordinal() - o.priority.ordinal();
    }
}
