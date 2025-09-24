---
title: 'Fundamentos Programación en Java:'
created: '2025-09-23T08:40:25.066Z'
modified: '2025-09-23T10:11:30.290Z'
---

# Fundamentos Programación en Java:

## 1. Tipos de datos :

- Enteros `int`, `integer`
- booleanos `bool`
- decimales o flotantes `float`
- caracteres `char`
- `void`valor vacío
---
## 2. Estructuras de control :

Son las herramientas que tenemos para controlar el flujo de programa, iteraciones, controles de salida, etc, estos son los más usados :

- __Bucles:__

`while{...}`
`do{..} while`
`for(i=0;i<x;i++){..}`

- __Condicionales:__

`if`
`ifelse`
`elseif`

- **Excepciones:** principalmente se usa con el bloque  `try-catch-finally`:
`try` - aquí se pone el código "peligroso" que puede lanzar la excepción.
`catch` - si se produce una excepción en el bloque `try` el programa saltará el bloque, aqui puedes definir como responder al error y puede haber varios bloques de `catch` para distintos tipos de excepciones.
`finally` - es opcional, y se ejecuta siempre, tanto si hubo una excepcion como si no, es ideal para limpieza como cerrar una base de datos o un archivo asegurando que no queden recursos abiertos.
- `return`también es una estructura de control porque modifica el flujo del programa.
- `break`, `continue`- rompe el bucle o lo continúan  y no sigue con la iteración por tanto es otra opcion para controlar el flujo.
---
## 3.Template String:

Los **String Templates** (o plantillas de cadena) son una característica moderna de Java diseñada para hacer que la creación de cadenas de texto sea mucho más fácil, legible y segura.

Permiten incrustar variables y expresiones directamente dentro de una cadena de texto de una manera limpia, similar a como se hace en otros lenguajes como Python (f-strings) o JavaScript (template literals).

**El Problema: Las Formas Antiguas :**

Antes de los String Templates, en Java tenías principalmente tres formas de construir cadenas con variables, y todas tenían sus desventajas:

Concatenación con +: Simple para cosas pequeñas, pero se vuelve ilegible y es ineficiente si se usa en bucles.

```
`String name = "Maria";
int unreadMessages = 12;
String message = "Hola " + name + ", tienes " + unreadMessages + " mensajes sin leer.";
StringBuilder: Más eficiente que la concatenación, pero muy verboso y aparatoso.
```

```

StringBuilder sb = new StringBuilder();
sb.append("Hola ");
sb.append(name);
sb.append(", tienes ");
sb.append(unreadMessages);
sb.append(" mensajes sin leer.");
String message = sb.toString();
String.format(): Potente para formatear, pero separa las variables de la cadena, lo que dificulta la lectura y puede causar errores si el tipo o el orden de los argumentos no coincide.


String message = String.format("Hola %s, tienes %d mensajes sin leer.", name, unreadMessages);
La Solución: String Templates ✨
Los String Templates introducen una sintaxis mucho más intuitiva y segura. Funcionan usando un procesador de plantillas seguido de una cadena de texto.

El procesador más común es STR. La sintaxis es: STR."texto con \{variable}"

Veamos el mismo ejemplo de antes usando esta nueva forma:

Java

String name = "Maria";
int unreadMessages = 12;

// ¡Así de simple!
String message = STR."Hola \{name}, tienes \{unreadMessages} mensajes sin leer.";

System.out.println(message);
// Salida: Hola Maria, tienes 12 mensajes sin leer.
```


**¿Cómo funciona?**

Procesador (STR.): Es el prefijo que le dice a Java cómo debe procesar la plantilla. STR es el procesador estándar para crear una cadena.

Plantilla ("..."): Es la cadena de texto que contiene el texto fijo y los marcadores de posición.

Marcadores de posición (\{...}): Dentro de la cadena, cualquier cosa que pongas entre \{ y } es una expresión de Java que se evaluará y su resultado se insertará en esa posición. Puede ser una variable (\{name}), una operación matemática (\{x + y}), o incluso una llamada a un método (\{user.getName()}).

**Principales Ventajas**

💡 Mucho más legible: El código es más fácil de leer y entender porque las variables están justo donde aparecerán en el resultado final. Es casi como leer una frase normal.

🔒 Más seguro: A diferencia de la simple concatenación, los procesadores de plantillas como STR están diseñados para ser seguros. Por ejemplo, si estuvieras construyendo una consulta SQL, podrías usar un procesador específico que sanea automáticamente las variables para prevenir ataques de inyección SQL.

⚙️ **Flexible y Extensible**: Java no solo proporciona el procesador STR. También hay otros, como:

FMT: Permite usar las reglas de formato de String.format() dentro de la plantilla.

```
double price = 19.99;
// Formatea el precio a dos decimales
String formattedPrice = FMT."El precio es %.2f\{price}€"; 
// "El precio es 19,99€"
RAW: Crea un objeto de plantilla sin procesar, para usos más avanzados.
```


>**Disponibilidad :** Esta característica fue introducida como vista previa (preview) en Java 21 y Java 22, y es una característica estándar y definitiva a partir de Java 23. Ya no necesitas activar ningún flag de preview para usarla si estás en Java 23 o una versión superior.

---
## 4. Librería y clases de utilidades :

El paquete `java.util` es una de las librerías fundamentales en el entorno de desarrollo de Java. Proporciona una amplia colección de clases e interfaces de utilidad que son de propósito general y esenciales para el día a día de la programación en Java. Este paquete incluye desde estructuras de datos complejas hasta herramientas para manejar fechas y expresiones regulares.

A continuación, se describen algunas de las herramientas más utilizadas de este paquete.

### **Framework de Colecciones (Collections Framework)**

Es el corazón del paquete `java.util` y ofrece un conjunto unificado de interfaces y clases para representar y manipular grupos de objetos.

- **`ArrayList`**: Es una implementación de una lista dinámica que permite almacenar elementos de cualquier tipo. A diferencia de los arrays tradicionales, un `ArrayList` puede crecer y decrecer en tamaño de forma automática. Es ideal cuando se necesita acceso rápido a los elementos a través de su índice.
    
    
    ```
    ArrayList<String> nombres = new ArrayList<>();
    nombres.add("Juan");
    nombres.add("María");
    System.out.println(nombres.get(0)); // Imprime "Juan"
    ```
    
- **`HashMap`**: Implementa la interfaz `Map` y se utiliza para almacenar pares de clave-valor. No mantiene un orden específico de los elementos y ofrece un rendimiento muy alto para la inserción, eliminación y búsqueda de elementos a través de su clave.
    

    
    ```
    HashMap<String, Integer> edades = new HashMap<>();
    edades.put("Juan", 25);
    edades.put("María", 30);
    System.out.println(edades.get("Juan")); // Imprime 25
    ```
    
- **`HashSet`**: Se utiliza para almacenar una colección de elementos únicos, es decir, no permite duplicados. No garantiza el orden de los elementos.
    
    
    ```
    HashSet<String> unicos = new HashSet<>();
    unicos.add("Lunes");
    unicos.add("Martes");
    unicos.add("Lunes"); // Este elemento no se añadirá de nuevo
    System.out.println(unicos.size()); // Imprime 2
    ```
    

### **Utilidades de Entrada/Salida**

- **`Scanner`**: Es una clase muy útil para leer datos de entrada desde diversas fuentes, como el teclado, ficheros o cadenas de texto. Proporciona métodos sencillos para leer diferentes tipos de datos como enteros, cadenas o booleanos.
    
    
    ```
    Scanner scanner = new Scanner(System.in);
    System.out.print("Introduce tu nombre: ");
    String nombre = scanner.nextLine();
    System.out.println("Hola, " + nombre);
    ```
    


### **Manejo de Fechas y Horas**

- **`Date`**: Representa un instante específico en el tiempo, con una precisión de milisegundos. Aunque ha sido en gran parte reemplazada por la API `java.time` en versiones más recientes de Java, todavía se encuentra en código antiguo.
    
- **`Calendar`**: Es una clase abstracta que proporciona métodos para convertir entre un instante de tiempo y un conjunto de campos de calendario como año, mes, día, hora, etc. Permite realizar operaciones aritméticas con fechas.
    

### **Otras Utilidades Relevantes**

- **`Random`**: Se utiliza para generar números pseudoaleatorios de diferentes tipos (enteros, dobles, etc.).
    
- **`Properties`**: Permite gestionar un conjunto de propiedades (pares clave-valor de tipo `String`) que pueden ser leídas o escritas desde un fichero, siendo muy útil para ficheros de configuración.
    

Estas herramientas son solo una pequeña muestra del poder y la flexibilidad que el paquete `java.util` ofrece a los desarrolladores de Java, simplificando una gran variedad de tareas de programación comunes.

---
## 5. Argumentos de un programa :

`String[] args` este es el argumento que recibe el método principal.

---
## 6. Punto de entrada de la ejecución :

 `public statitc void main (String[] args){...}`

---
## 7. Recursividad :

Se trata de la capacidad de una función a ejecutarse a si misma por ejemplo :

```
public class EjemploRecursividad {

    /**
     * Calcula el factorial de un número entero no negativo de forma recursiva.
     *
     * @param n El número para calcular el factorial.
     * @return El resultado del factorial.
     */
    public static long factorial(int n) {
        // Caso base: si n es 0, el factorial es 1.
        // Esto detiene la recursividad.
        if (n == 0) {
            return 1;
        }
        // Paso recursivo: n * factorial de (n-1).
        else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        int numero = 5;
        long resultado = factorial(numero);
        System.out.println("El factorial de " + numero + " es: " + resultado);
        // Salida: El factorial de 5 es: 120
    }
}
```

---
## 8. Clases :

La programación orientada a objetos o POO, aqui movemos la responsabilidad de ejecución a cada clase no como en la programación estructuradas que una ejecución de arriba a abajo y dependiendo íntegramente de los controles de flujo esta ejecución estructurada.

En la POO tenemos clases con atributos y métodos, podemos considerar las clases como una plantilla para plasmar o modelar una realidad en nuestro programa, imagina que vamos a modelar una clase Perro.

- Clase Perro tendría :

```
package com.avante.veterinaria;

class Perro{
  
  // atributos, podemos dar por defecto String nombre = 'nombrePerro'

  String nombre;
  String raza;
  int peso;
  String color;

  //Métodos
  
  /* Este método escribe por la salida estandar un saludo al perro con su nombre */
  void saludo(){
	  System.out.println("Hola " + this.nombre);
  }
 // Metodo que devuelve el diminutivo del nombre
  String obtenerDiminutivo(){
	  
	  return
  }
  
}
```

> **La palabra reservada `this` es muy útil para referir una clase a si misma.**

El `main` que incluye la clase perro en su código :

```
package com.avante.veterinaria;

pubic class veterinaria {

  public static void main(String[] args){
  
  // debemos instanciar o construir la clase
  Perro miPerro = new Perro();
  Perro tuPerro = new Perro();
  
  //Le damos nombre
  miPerro.nombre = 'Luecera';
  tuPerro.nombre = 'Bobby';
  
  
  //Imprimimos los nombres
  System.out.println("MI perro se llama" + miPerro.nombre +'');
  System.out.println("Tu perro se llama" + tuPerro.nombre +'');
  
  //Lamando al metodo 
  miPerro.saludo();
  tuPerro.saludo();
  
  //Muestra el diminutivo
  String miDIminutivo = miPerro.obtenerDiminutivo();
  String miDIminutivo = miPerro.obtenerDiminutivo();
  
  }
}
```

> Las clases normalmente deben cerrarse tras ser usadas como por ejemplo la clase Scanner con el comando `close.Scanner();` en este caso la clase Perro porque no hemos creado un método `close()` y porque ya de por si Java tiene el método `finalice()` de la clase objetos.

---

## __9. Visibilidad  :__

En Java, los **modificadores de visibilidad** (o de acceso) controlan qué partes de tu código pueden acceder a tus clases, atributos y métodos. Son esenciales para la **encapsulación**, que consiste en ocultar el funcionamiento interno de una clase y exponer solo lo necesario.

En Java, los **modificadores de visibilidad** (o de acceso) controlan qué partes de tu código pueden acceder a tus clases, atributos y métodos. Son esenciales para la **encapsulación**, que consiste en ocultar el funcionamiento interno de una clase y exponer solo lo necesario.

> En los ejemplos de clase recuerda mirar los de la clase Perro y sus modificaciones.


Existen cuatro niveles de visibilidad, del más abierto al más restrictivo:
### 1. `public` (Público) 🌍

Es el nivel más permisivo. Un miembro `public` es accesible desde **cualquier lugar**: desde cualquier otra clase en cualquier otro paquete.

- **Uso común**: Para métodos que forman la API principal de tu clase (como constructores, getters y setters) y para clases que deben ser usadas por todo el proyecto.
    

```
public class Coche {
    public String marca; // Cualquiera puede ver y modificar la marca

    public void arrancar() { // Cualquiera puede arrancar el coche
        // ...
    }
}
```

### 2. `protected` (Protegido) 👨‍👩‍👧

Un miembro `protected` es accesible para:

1. Clases dentro del **mismo paquete**.
    
2. **Clases hijas (subclases)**, incluso si están en un paquete diferente.
    

- **Uso común**: Para atributos o métodos que no son públicos pero que necesitan ser accedidos o sobrescritos por clases que heredan de ella.
    

```
public class Vehiculo {
    protected int velocidad; // Accesible por Vehiculo y sus subclases
}

// En otro paquete
public class Moto extends Vehiculo {
    public void acelerar() {
        velocidad += 10; // Correcto, Moto hereda de Vehiculo
    }
}
```

### 3. `default` (o Package-Private) 🏠

Si **no escribes ningún modificador**, se aplica la visibilidad por defecto. Un miembro `default` solo es accesible para clases que están en el **mismo paquete**. No es accesible desde subclases en paquetes diferentes.

- **Uso común**: Para clases o métodos "ayudantes" que solo tienen sentido dentro del contexto de un paquete específico y no deben ser expuestos al resto de la aplicación.
    

```
// En el paquete com.transporte
class Motor { // Sin modificador, es 'default'
    void encender() {
        // ...
    }
}

// En el mismo paquete com.transporte
public class Coche {
    private Motor miMotor = new Motor();
    public void arrancar() {
        miMotor.encender(); // Correcto, están en el mismo paquete
    }
}
```

### 4. `private` (Privado) 🔒

Es el nivel más restrictivo. Un miembro `private` solo es accesible **dentro de la misma clase** donde fue declarado. Ni las clases del mismo paquete ni las subclases pueden acceder a él.

- **Uso común**: Es la opción preferida para los **atributos** para lograr una buena encapsulación. El acceso se gestiona a través de métodos públicos (`getters` y `setters`).
    

```
public class Persona {
    private String nombre; // Solo accesible dentro de la clase Persona

    public String getNombre() { // Método público para leer el nombre
        return this.nombre;
    }

    public void setNombre(String nombre) { // Método público para cambiar el nombre
        this.nombre = nombre;
    }
}
```

### Tabla Resumen

Aquí tienes una tabla para verlo de forma más clara:

| Modificador     | Misma Clase | Mismo Paquete | Subclase (Otro Paquete) | Cualquier Lugar |
| --------------- | ----------- | ------------- | ----------------------- | --------------- |
| **`public`**    | ✅           | ✅             | ✅                       | ✅               |
| **`protected`** | ✅           | ✅             | ✅                       | ❌               |
| **`default`**   | ✅           | ✅             | ❌                       | ❌               |
| **`private`**   | ✅           | ❌             | ❌                       | ❌               |


---
## 10. Getter y Setter :

Llos métodos **getter** y **setter** son dos tipos de métodos públicos que se utilizan para acceder y modificar, respectivamente, el valor de las variables de instancia privadas de una clase. Su uso es una parte fundamental del principio de **encapsulamiento**, que consiste en ocultar el estado interno de un objeto y exponer solo lo necesario a través de una interfaz pública.

### Getters (Métodos de acceso)

Un método **getter** se utiliza para _obtener_ o _leer_ el valor de una variable privada. Por convención, su nombre comienza con `get` seguido del nombre de la variable (en formato camelCase).

**Características:**

- Es **público**.
    
- Devuelve el tipo de dato de la variable que lee.
    
- No recibe ningún parámetro.
    

Por ejemplo, para una variable `private String nombre;`, el getter sería:


```
public String getNombre() {
    return nombre;
}
```

---

### Setters (Métodos de modificación)

Un método **setter** se utiliza para _establecer_ o _modificar_ el valor de una variable privada. Por convención, su nombre comienza con `set` seguido del nombre de la variable (en formato camelCase).

**Características:**

- Es **público**.
    
- Generalmente, no devuelve ningún valor (`void`).
    
- Recibe un parámetro del mismo tipo que la variable que va a modificar.
    

Para la misma variable `private String nombre;`, el setter sería:


```
public void setNombre(String nuevoNombre) {
    this.nombre = nuevoNombre;
}
```

Dentro del setter se pueden añadir **validaciones** para asegurar que el nuevo valor sea correcto antes de asignarlo.

> __encapsulación__ En programación, esto significa que los datos importantes de un objeto se mantienen "privados" y solo se pueden modificar o leer usando los métodos que el programador ha creado para ello. Esto evita que otras partes del código los manipulen por error y causen problemas.


### ¿Por qué usarlos?

La idea principal es tener un control total sobre cómo se accede y se modifica el estado de un objeto.

- **Seguridad:** Impiden que el valor de una variable sea modificado directamente con un dato inválido. Por ejemplo, un `setEdad` podría impedir que se asigne un número negativo.
    
- **Flexibilidad:** Permiten cambiar la implementación interna de la clase sin que afecte al código que la utiliza.
    
- **Encapsulamiento:** Cumplen con uno de los pilares de la programación orientada a objetos, ocultando los detalles internos y exponiendo solo una interfaz segura.
    

En resumen, en lugar de hacer esto (que es una mala práctica):


```
// Acceso directo (no recomendado)
coche.velocidad = 200;
System.out.println(coche.velocidad);
```

Se utiliza esto:


```
// Acceso controlado mediante métodos
coche.setVelocidad(200);
System.out.println(coche.getVelocidad());
```

---
## 11. Herencia :

Mediante la palabra reservada `extends` :

```
public class Animal {

}

private class Perro extends Animal {

}

// (Mejorar y rellenar mañana)
```

Todo clase hija hereda los atributos y métodos del padre, 