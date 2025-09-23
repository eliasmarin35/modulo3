---
title: Fundamentos Java
created: '2025-09-23T06:54:42.066Z'
modified: '2025-09-23T08:39:22.890Z'
---

# 1. Fundamentos programación y programación orientada a objetos con Java:

En esta unidad formativa daremos lo básico de los fundamentos de la programación con Java y emperecemos a introducir el concepto del paradigma de programación orientada a objetos. Al principio en java debemos tener claro que usaremos Maven para la organización de carpetas de proyecto.

En un vistazo rápido la organización de un proyecto con Maven será así :

mi-proyecto-java/
├── .gitignore
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/
    │   │       └── miempresa/
    │   │           └── app/
    │   │               └── App.java
    │   └── resources/
    │       └── config.properties
    └── test/
        ├── java/
        │   └── com/
        │       └── miempresa/
        │           └── app/
        │               └── AppTest.java
        └── resources/
            └── test-data.csv

El esqueleto básico de una aplicación en java es :


## 1.1. Tipo de datos en Java :

### Las variables :

Las variables nos permiten almacenar datos en memoria diferentes valores útiles para el funcionamiento de nuestras aplicaciones durante su ejecución. Para la declaración de las funciones en Java o cualquier lenguaje de programación se acuerda unas reglas :

- El nombre de una variable empieza obligatoriamente por una letra.
- Puede contener letras, cifras o el caracter subrayado "_".
- Puede contener un número cualquiera  de caracterees (siempre limitados a un número razonable).
- Se hace distinción entre minúsculas y mayúsculas.
- Las palabras clave del lenguaje no deben  utilizarse como nombre de variable.
- Por convenio, los nombres de las  variables se ortografian con letras minúsculas salvo la primera de cada palabra si el nombre de la variable incluye varias palabras  ejemplo, edadDelAlumno).

### Tipos de Datos Primitivos

Son los datos más básicos y fundamentales. Representan valores simples y directos.

|Tipo|Descripción|Ejemplo de Código|
|---|---|---|
|**`int`**|Números enteros. Es el más común.|`int edad = 30;`|
|**`double`**|Números con decimales. Es el más usado para decimales.|`double precio = 19.99;`|
|**`boolean`**|Almacena únicamente dos valores: `true` o `false`.|`boolean esActivo = true;`|
|**`char`**|Una única letra o caracter. Usa comillas simples.|`char inicial = 'A';`|

**Ejemplo de uso en código:**

Java


public class TiposPrimitivos {
    public static void main(String[] args) {
        // Variable para almacenar la cantidad de vidas en un juego
        int vidas = 5;

        // Variable para almacenar la puntuación
        double puntuacion = 85.5;

        // Variable para saber si el juego ha terminado
        boolean juegoTerminado = false;

        System.out.println("Vidas restantes: " + vidas); // Salida: Vidas restantes: 5
        System.out.println("Puntuación: " + puntuacion);  // Salida: Puntuación: 85.5
    }
}
```

#### Los placeholders :

En Java, un **placeholder** es un símbolo o una marca dentro de un texto (como una cadena o una consulta) que se reserva para ser reemplazado por un valor real más adelante. Piensa en él como un "espacio en blanco" que llenas con datos dinámicos justo antes de usarlo.

El objetivo principal de los placeholders es **separar una plantilla de texto fija de los datos variables que la completan**. Esto mejora la seguridad, la legibilidad y la eficiencia del código.

---

## Usos Comunes de Placeholders

### 1. Formateo de Cadenas (Strings) ✍️

Es el uso más básico. Permite construir una cadena compleja insertando variables en puntos específicos.

- **`String.format()` o `System.out.printf()`**: Usan especificadores de formato como `%s` para strings, `%d` para enteros (decimal) o `%f` para números de punto flotante.
    
    Java
    
    ```
    String nombre = "Ana";
    int edad = 28;
    
    // Usando String.format() con placeholders %s y %d
    String mensaje = String.format("El nombre del usuario es %s y tiene %d años.", nombre, edad);
    
    System.out.println(mensaje);
    // Salida: El nombre del usuario es Ana y tiene 28 años.
    ```
    


#### Tipos de Datos de Referencia (Objetos)

Estos tipos son más complejos. En lugar de almacenar el valor directamente, la variable guarda una "referencia" o una dirección a la ubicación en memoria donde se encuentra el objeto completo. El más importante para empezar es **`String`**.

- **`String`**: Se utiliza para almacenar secuencias de caracteres, es decir, texto. A diferencia de `char`, usa **comillas dobles**.
-  Otros tipos de datos por referencia `(...)`


**Ejemplo de uso en código:**

Java

```
public class TipoString {
    public static void main(String[] args) {
        // Variable para almacenar el nombre de un jugador
        String nombreJugador = "Alex";

        String saludo = "¡Bienvenido al juego, " + nombreJugador + "!";

        System.out.println(saludo); // Salida: ¡Bienvenido al juego, Alex!
    }
}
```
## 1.2. Funciones y Procedimientos :

En Java, tanto las funciones como los procedimientos se llaman **métodos**. Un método es un bloque de código que realiza una tarea específica y que puedes "llamar" o ejecutar cuando lo necesites. Esto te ayuda a organizar tu código y a no repetir las mismas líneas una y otra vez.

La diferencia clave es:

- **Función (Método que devuelve un valor)**: Realiza un cálculo o una operación y te entrega un resultado. Utiliza la palabra clave `return`.
    
- **Procedimiento (Método que no devuelve valor)**: Simplemente ejecuta una serie de acciones (como imprimir algo en pantalla) pero no entrega ningún resultado. Se define usando la palabra clave `void`.
    

#### Estructura de un Método

Java

```
public tipoDeRetorno nombreDelMetodo(tipoParam1 nombreParam1, tipoParam2 nombreParam2) {
    // Cuerpo del método: aquí va el código que realiza la tarea
    // ...
    return resultado; // (Solo si devuelve un valor)
}
```

- `public`: Modificador de acceso (por ahora, usa siempre `public`).
    
- `tipoDeRetorno`: El tipo de dato del resultado que devolverá (`int`, `String`, etc.) o `void` si no devuelve nada.
    
- `nombreDelMetodo`: El nombre que le das, siempre empieza con minúscula (convención _camelCase_).
    
- `(...)`: Dentro de los paréntesis van los **parámetros**, que son los datos que el método necesita para trabajar.
    

#### Ejemplo 1: Método que devuelve un valor (Función)

Vamos a crear un método que sume dos números y nos devuelva el resultado.

Java

```
public class Calculadora {

    // Este es nuestro método (función)
    public int sumar(int numeroA, int numeroB) {
        int resultado = numeroA + numeroB;
        return resultado; // Devuelve el valor calculado
    }

    public static void main(String[] args) {
        Calculadora miCalculadora = new Calculadora();

        // Llamamos al método y guardamos el resultado en una variable
        int total = miCalculadora.sumar(10, 5);

        System.out.println("El resultado de la suma es: " + total); // Salida: El resultado de la suma es: 15
    }
}
```

#### Ejemplo 2: Método que no devuelve valor (Procedimiento)

Ahora, un método que simplemente muestre un saludo personalizado en la pantalla.

Java

```
public class Saludos {

    // Este es nuestro método (procedimiento)
    public void saludar(String nombre) {
        // Esta acción se ejecuta, pero no se devuelve ningún valor
        System.out.println("¡Hola, " + nombre + "! Que tengas un buen día.");
    }

    public static void main(String[] args) {
        Saludos misSaludos = new Saludos();

        // Llamamos al método para que ejecute su acción
        misSaludos.saludar("Maria"); // Salida: ¡Hola, Maria! Que tengas un buen día.
        misSaludos.saludar("Pedro"); // Salida: ¡Hola, Pedro! Que tengas un buen día.
    }
}
```
## 1.x Ejercicios de ejemplos Java :

- Factorial de un número:
```

```
- Secuencia de Fibonacci :

```
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
```
