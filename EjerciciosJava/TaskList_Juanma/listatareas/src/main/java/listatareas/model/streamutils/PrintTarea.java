/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listatareas.model.streamutils;

import listatareas.model.Task;
import java.util.function.Consumer;

/**
 *
 * @author jadmin
 */
public class PrintTarea implements Consumer<Task>{
    @Override
    public void accept(Task t) {
        System.out.println(t);
    }
}
