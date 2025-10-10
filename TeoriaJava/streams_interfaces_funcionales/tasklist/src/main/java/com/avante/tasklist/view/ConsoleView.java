/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.tasklist.view;

import com.avante.tasklist.model.PriorityEnum;
import com.avante.tasklist.model.Task;
import com.avante.tasklist.model.TaskList;

import java.util.Scanner;

/**
 *
 * @author jprof
 */
public class ConsoleView {
    private static final String  CLEAR_SCREEN = "\u001B[2J\u001B[H";
    
    private static void clearScreen() {
        System.out.println(CLEAR_SCREEN);
    }
    
    public static void main(String[] args) {
        boolean menu   = true;
        Scanner scan   = new Scanner(System.in);
        int     opcion = 0;
        
        TaskList taskList = new TaskList();
        
        PriorityEnum prio;
        String       texto;
         
        while (menu) {
            System.out.println("""
                OPCIONES
                ========
                1) Crear Tarea
                2) Sacar Tarea
                3) Imprimir lista de tareas
                4) Imprimir lista de tareas por prioridad
                5) Salir
                """);
            
            opcion = scan.nextInt();
            
            switch(opcion) {
                case 1:
                    clearScreen();
                    prio = pidePrioridad(scan);
                    clearScreen();
                    texto = pideTexto(scan);
                    taskList.add(new Task(prio,texto));
                    break;
                case 2:
                    System.out.println(taskList.poll());
                    break;
                case 3:
                    taskList.listStream()
                         .forEach(t -> System.out.println(t));
                    break;
                case 4:
                    taskList.prioritiesStream()
                         .forEach(t -> System.out.println(t));
                    break;
                case 5:
                    menu = false;
                    break;
            }
        }
    }
    
    private static PriorityEnum pidePrioridad (Scanner scan) {
        int opcion; 
        
        System.out.println("""
                OPCIONES
                ========
                1) Alta
                2) Media
                3) Baja
                """);
        
        opcion = scan.nextInt();
        
        switch(opcion) {
            case 1:
                return PriorityEnum.HIGH;
            case 2:
                return PriorityEnum.MEDIUM;
            case 3:
                return PriorityEnum.LOW;
        }
        
        return null;
    }
    
    private static String pideTexto(Scanner scan) {
        System.out.println("Introduzca la Tarea");
        return scan.next();
    }
}
