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
- `void`valor vacio

## 2. Estructuras de control :

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


Disponibilidad
Esta característica fue introducida como vista previa (preview) en Java 21 y Java 22, y es una característica estándar y definitiva a partir de Java 23. Ya no necesitas activar ningún flag de preview para usarla si estás en Java 23 o una versión superior.
## 4. Libre y clases de utilidades :

- libreria a declarar `javautils.Scanner`
- `new Scanner(...)`
- `sc.close()`

## 5. Argumentos de un programa :

`String[] args` este es el argumento que recibe
## 6. Punto de entrada de la ejecución :

 `public statitc void main (String[] args){...}`
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

__Visibilidad  :__

En Java, los **modificadores de visibilidad** (o de acceso) controlan qué partes de tu código pueden acceder a tus clases, atributos y métodos. Son esenciales para la **encapsulación**, que consiste en ocultar el funcionamiento interno de una clase y exponer solo lo necesario.

En Java, los **modificadores de visibilidad** (o de acceso) controlan qué partes de tu código pueden acceder a tus clases, atributos y métodos. Son esenciales para la **encapsulación**, que consiste en ocultar el funcionamiento interno de una clase y exponer solo lo necesario.

Existen cuatro niveles de visibilidad, del más abierto al más restrictivo:

---

## 1. `public` (Público) 🌍

Es el nivel más permisivo. Un miembro `public` es accesible desde **cualquier lugar**: desde cualquier otra clase en cualquier otro paquete.

- **Uso común**: Para métodos que forman la API principal de tu clase (como constructores, getters y setters) y para clases que deben ser usadas por todo el proyecto.
    

Java

```
public class Coche {
    public String marca; // Cualquiera puede ver y modificar la marca

    public void arrancar() { // Cualquiera puede arrancar el coche
        // ...
    }
}
```

---

## 2. `protected` (Protegido) 👨‍👩‍👧

Un miembro `protected` es accesible para:

1. Clases dentro del **mismo paquete**.
    
2. **Clases hijas (subclases)**, incluso si están en un paquete diferente.
    

- **Uso común**: Para atributos o métodos que no son públicos pero que necesitan ser accedidos o sobrescritos por clases que heredan de ella.
    

Java

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

---

## 3. `default` (o Package-Private) 🏠

Si **no escribes ningún modificador**, se aplica la visibilidad por defecto. Un miembro `default` solo es accesible para clases que están en el **mismo paquete**. No es accesible desde subclases en paquetes diferentes.

- **Uso común**: Para clases o métodos "ayudantes" que solo tienen sentido dentro del contexto de un paquete específico y no deben ser expuestos al resto de la aplicación.
    

Java

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

---

## 4. `private` (Privado) 🔒

Es el nivel más restrictivo. Un miembro `private` solo es accesible **dentro de la misma clase** donde fue declarado. Ni las clases del mismo paquete ni las subclases pueden acceder a él.

- **Uso común**: Es la opción preferida para los **atributos** para lograr una buena encapsulación. El acceso se gestiona a través de métodos públicos (`getters` y `setters`).
    

Java

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

---

## Tabla Resumen

Aquí tienes una tabla para verlo de forma más clara:

| Modificador     | Misma Clase | Mismo Paquete | Subclase (Otro Paquete) | Cualquier Lugar |
| --------------- | ----------- | ------------- | ----------------------- | --------------- |
| **`public`**    | ✅           | ✅             | ✅                       | ✅               |
| **`protected`** | ✅           | ✅             | ✅                       | ❌               |
| **`default`**   | ✅           | ✅             | ❌                       | ❌               |
| **`private`**   | ✅           | ❌             | ❌                       | ❌               |