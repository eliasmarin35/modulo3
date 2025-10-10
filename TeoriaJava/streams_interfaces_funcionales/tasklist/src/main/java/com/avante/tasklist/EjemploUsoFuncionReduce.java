/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.tasklist;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author jprof
 */
public class EjemploUsoFuncionReduce {
    public static void main (String[] args) {
        // 1- Reduce de enteros
        System.out.println("\n==> REDUCE DE ENTEROS");
        Integer[] misenteros = {1,2,3,4,5,6,7,8,9,10};
       
        int result = Arrays.asList(misenteros).stream()
            .filter( e -> e % 2 == 1 )
            .reduce( 0, ((suma,e) -> suma + e) );
        
        System.out.println(result);
        
        
        // 1- Reduce de cadenas
        System.out.println("\n==> REDUCE DE CADENAS");
        ArrayList<String> miscadenas = new ArrayList<>();
        
        miscadenas.add("HOLA");
        miscadenas.add(" ");
        miscadenas.add("QUE");
        miscadenas.add(" ");
        miscadenas.add("TAL");
        miscadenas.add(" ");
        miscadenas.add("ESTAS");
        
       
        String resultStr = miscadenas.stream()
            .reduce( "", ((buff,s) -> buff + s) );
        
        System.out.println(resultStr);
        
        
        
    }
}
