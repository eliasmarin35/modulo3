/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listatareas;

import listatareas.view.console.ConsoleView;
import listatareas.controller.TaskListController;
import listatareas.model.TaskList;

/**
 *
 * @author jadmin
 */
public class Console {
    public static void main(String[] args) {
        TaskList            modelo      = new TaskList();
        ConsoleView           vista       = new ConsoleView();
        TaskListController controlador = new TaskListController(modelo,vista);
        
        vista.setListener(controlador);
        controlador.run();
        controlador.close();
    }
}
