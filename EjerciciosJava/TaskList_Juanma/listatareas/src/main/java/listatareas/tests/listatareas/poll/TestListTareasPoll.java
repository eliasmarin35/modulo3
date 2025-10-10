/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listatareas.tests.listatareas.poll;

import listatareas.model.TaskList;
import listatareas.model.Task;
import listatareas.tests.listatareas.TestListaTareasBase;

/**
 *
 * @author jadmin
 */
public class TestListTareasPoll extends TestListaTareasBase {

    public static void main(String[] args) {
        new TestListTareasPoll().test();
    }

    @Override
    protected void process(TaskList tareas) {
        Task t;
        int   i=0;

        while (!tareas.isEmpty()) {
            System.out.printf("\n\n======================= %d\n",++i);

            // Muestra la lista
            System.out.println("\n===> COMO LISTA");
            tareas.listaStream()
                    .forEach(Task.print);

            // Muestra la lista por prioridad
            System.out.println("\n===> COMO PRIORIDADES");
            tareas.prioridadStream()
                    .forEach(Task.print);

            // Saca un elemento
            System.out.println("\n===> SACA 1 EL");
            System.out.println(tareas.poll());
        }
    }
}
