/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listatareas.model;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author jadmin
 */
public record Task(
        Priority prioridad,
        String texto
) implements Comparable<Task> {

    @Override
    public String toString() {
        return String.format(
                "[%s %s]",
                this.prioridad.getSimbolo(),
                this.texto
        );
    }

    public String getTexto() {
        return this.texto;
    }

    public String getPrioridadTexto() {
        return this.prioridad.getDescripcion();
    }

    @Override
    public int compareTo(Task t) {
        return this.prioridad.compareTo(t.prioridad);
    }

    // ======= UTILIDADES PARA STREAMS (tradicionales)
    // Consumer -> consume elementos
    public static Consumer<Task> printT() {
        return new Consumer<Task>() {
            @Override
            public void accept(Task t) {
                System.out.println(t);
            }
        };
    }
    
    public static Consumer<String> printStringT() {
        return new Consumer<String>() {
            @Override
            public void accept(String t) {
                System.out.println(t);
            }
        };
    }

    // Function -> transforma elementos
    public static Function<Task, String> xformT() {
        return new Function<Task, String>() {
            @Override
            public String apply(Task t) {
                return t.texto;
            }
        };
    }

    // Predicate --> filtra elementos
    public static Predicate<Task> filterT(Priority p) {
        return new Predicate<Task>() {
            @Override
            public boolean test(Task t) {
                return t.prioridad == p;
            }
        };
    }

    // ======= UTILIDADES PARA STREAMS (lambda)
    // Consumer -> consume elementos
    public static Consumer<Task>        print = t -> System.out.println(t);
    public static Consumer<String> printString = System.out::println;

    // Function -> transforma elementos
    public static Function<Task, String> xform = t -> t.texto;

    // Predicate --> filtra elementos
    public static Predicate<Task> filter(Priority p) {
        return t -> t.prioridad == p;
    }
}
