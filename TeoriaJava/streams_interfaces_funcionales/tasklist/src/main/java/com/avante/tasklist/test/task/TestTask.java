/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.tasklist.test.task;

import com.avante.tasklist.model.PriorityEnum;
import com.avante.tasklist.model.Task;

/**
 *
 * @author jprof
 */
public class TestTask {
    public static void main(String[] args) {
        Task t1 = new Task(PriorityEnum.LOW, "Mi tarea");
        
        System.out.println(t1);
    }
}
