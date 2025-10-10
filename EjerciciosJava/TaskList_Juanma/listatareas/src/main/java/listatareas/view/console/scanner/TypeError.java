/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listatareas.view.console.scanner;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author jadmin
 */
public class TypeError<T> {
    private boolean isError = true;
    private T       value   = null;

    public TypeError() {}
    
    public void setError() {
        this.isError = true;
        this.value   = null;
    }
    
    public boolean isError() {
        return this.isError;
    }
    
    public void setValue(T v) {
        this.isError = false;
        this.value = v;
    }
    
    public T getValue() {
        return this.value;
    }    
}
