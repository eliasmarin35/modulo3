/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package avante.fibonacci;

/**
 * 
 * @author Elias
 * @version 1.1
 * @param 
 */

public class Fibonacci {

    public static void main(String[] args) {
        int n = 10; // Queremos los primeros 10 números de la secuencia

        System.out.println("Secuencia de Fibonacci (primeros " + n + " numeros):");

        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }
        // Salida: Secuencia de Fibonacci (primeros 10 números): 0 1 1 2 3 5 8 13 21 34
    }

    /**
     * Calcula el número de Fibonacci en la posición n de forma iterativa.
     * @param n La posición en la secuencia (empezando desde 0).
     * @return El número de Fibonacci en esa posición.
     */
    public static int fib(int n) {
        if (n <= 1) {
            return n; // Casos base: fib(0) = 0, fib(1) = 1
        }

        int a = 0;
        int b = 1;
        int resultado = 0;

        // Empezamos desde 2 porque ya conocemos los casos 0 y 1
        
        for (int i = 2; i <= n; i++) {
            resultado = a + b; // El siguiente número es la suma de los dos anteriores
            a = b;             // a toma el valor de b
            b = resultado;     // b toma el nuevo valor calculado
        }

        return b; // Devolvemos el último valor calculado
    }
}