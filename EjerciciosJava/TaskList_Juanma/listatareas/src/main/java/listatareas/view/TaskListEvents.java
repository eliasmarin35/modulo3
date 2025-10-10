/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listatareas.view;

import listatareas.model.Priority;

/**
 *
 * @author jadmin
 */
public interface TaskListEvents {
    public void add(Priority p, String t);
    public void poll();
    public void printList();
    public void printPriorities();
}
