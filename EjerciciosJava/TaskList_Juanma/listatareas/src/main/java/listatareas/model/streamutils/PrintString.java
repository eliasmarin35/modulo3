/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listatareas.model.streamutils;


import java.util.function.Consumer;

/**
 *
 * @author jadmin
 */
public class PrintString implements Consumer<String>{
    @Override
    public void accept(String t) {
        System.out.println(t);
    }
}
