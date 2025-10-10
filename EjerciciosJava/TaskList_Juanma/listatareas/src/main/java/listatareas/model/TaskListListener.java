/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listatareas.model;

import java.util.stream.Stream;
import listatareas.model.Task;

/**
 *
 * @author jadmin
 */
public interface TaskListListener {
    public void run();
    public void close();
    public void printElement(Task t);
    public void printNoElements();
    public void updateList(Stream<Task> s);
    public void updatePriorities(Stream<Task> s);
    public void updateSize(int t);
}
