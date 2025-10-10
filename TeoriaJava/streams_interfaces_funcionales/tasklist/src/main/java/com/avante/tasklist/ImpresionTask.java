/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.tasklist;

import com.avante.tasklist.model.Task;
import java.util.function.Consumer;

/**
 *
 * @author jprof
 */
public class ImpresionTask implements Consumer<Task>{
    @Override
    public void accept(Task t) {
        System.out.printf("________%s______\n", t);
    }
}
