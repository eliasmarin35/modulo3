/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listatareas.model.streamutils;

import listatareas.model.Task;
import java.util.function.Function;

/**
 *
 * @author jadmin
 */
public class XformTarea implements Function<Task,String>{
    @Override
    public String apply(Task t) {
        return t.getTexto();
    }
}
