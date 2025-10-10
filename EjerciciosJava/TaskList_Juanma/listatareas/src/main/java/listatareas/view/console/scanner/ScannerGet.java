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
public class ScannerGet<T> implements Function<String,TypeError<T>>{
    private Function<String,T> xform = s -> (T) s;
    private Predicate<T>       filter = v -> true;
    
    @Override
    public TypeError<T> apply(String input) {
        T value = null;
        boolean isError = false;
                
        TypeError<T> te = new TypeError<>();
        
        try {
            value = this.xform.apply(input);
        }
        catch (Exception e){
            isError = true;
        }
        
        if (! isError ) {
            if ( ! filter.test(value) ) {
                isError = true;
            }
        }
        
        if (isError) {
            te.setError();
        }
        else {
            te.setValue(value);
        }
        
        return te;
    }

    /**
     * @param xform the xform to set
     */
    public void setXform(Function<String,T> xform) {
        this.xform = xform;
    }

    /**
     * @param filter the filter to set
     */
    public void setFilter(Predicate<T> filter) {
        this.filter = filter;
    }
    
}
