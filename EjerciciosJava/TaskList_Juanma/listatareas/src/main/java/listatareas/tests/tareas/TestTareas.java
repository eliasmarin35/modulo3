/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package listatareas.tests.tareas;

import listatareas.model.Priority;
import listatareas.model.Task;

/**
 *
 * @author jadmin
 */
public class TestTareas {

    public static void main(String[] args) {
        Task t1 = new Task(Priority.BAJA, "Limpiar");
        Task t2 = new Task(Priority.MEDIA, "Dormir");
        Task t3 = new Task(Priority.ALTA, "Trabajar");
        Task t4 = new Task(Priority.ALTA, "Estudiar");
         
        System.out.printf("%s comp %s = %d\n",t1,t2,t1.compareTo(t2));
        System.out.printf("%s comp %s = %d\n",t1,t3,t1.compareTo(t3));
        System.out.printf("%s comp %s = %d\n",t2,t3,t2.compareTo(t3));
        System.out.println("");
        System.out.printf("%s comp %s = %d\n",t3,t4,t3.compareTo(t4));
        System.out.println("");
        System.out.printf("%s comp %s = %d\n",t3,t2,t3.compareTo(t2));
        System.out.printf("%s comp %s = %d\n",t3,t1,t3.compareTo(t1));
        System.out.printf("%s comp %s = %d\n",t2,t1,t2.compareTo(t1));
    }
}
