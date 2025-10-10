/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listatareas.controller;

import listatareas.model.TaskList;
import listatareas.model.Priority;
import listatareas.model.Task;
import listatareas.view.TaskListEvents;
import listatareas.model.TaskListListener;

/**
 *
 * @author jadmin
 */
public class TaskListController implements TaskListEvents {

    private TaskListListener vista;
    private TaskList modelo;

    public TaskListController(TaskList t, TaskListListener v) {
        this.modelo = t;
        this.vista = v;
    }

    public void run() {
        updateSize();
        this.vista.run();
    }

    public void close() {
        this.vista.close();
    }

    private void updateSize() {
        this.vista.updateSize(this.modelo.size());
    }

    private boolean checkPrintNoEls() {
        boolean result = true;

        if (this.modelo.isEmpty()) {
            this.vista.printNoElements();
            result = false;
        }

        return result;
    }

    @Override
    public void add(Priority p, String t) {
        this.modelo.add(p, t);
        this.vista.updateSize(this.modelo.size());
    }

    @Override
    public void poll() {
        if (this.checkPrintNoEls()) {
            Task t = this.modelo.poll();
            this.vista.printElement(t);
            this.vista.updateSize(this.modelo.size());
        }
    }

    @Override
    public void printList() {
        if (this.checkPrintNoEls()) {
            this.modelo.listaStream()
                    .forEach(t -> this.vista.printElement(t));
        }
    }

    @Override
    public void printPriorities() {
        if (this.checkPrintNoEls()) {
            this.modelo.prioridadStream()
                    .forEach(t -> this.vista.printElement(t));
        }
    }
}
