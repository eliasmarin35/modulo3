---
title: 'Fundamentos Programación en Java:'
created: '2025-09-23T08:40:25.066Z'
modified: '2025-09-23T10:11:30.290Z'
---

# Fundamentos Programación en Java:

En esta unidad formativa daremos lo básico de los fundamentos de la programación con Java y emperecemos a introducir el concepto del paradigma de programación orientada a objetos. Al principio en java debemos tener claro que usaremos MavSi no escribes ningún modificador, se aplica la visibilidad por defecto. Un miembro default solo es accesible para clases que están en el mismo paquete. No es accesible desde subclases en paquetes diferentes.

en para la organización de carpetas de proyecto.

En un vistazo rápido la organización de un proyecto con Maven será así :

```
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
```


## 1 Tipos de datos
### 1.1 Tipos de datos básicos:

- Enteros con signo:
  - Enteros: `int`, `integer` _4 bytes_
  - Enteros cortos: `short` _2 bytes_
  - Byte: `byte` _1 bytes_
  - Enteros Largos: `long`  _8 bytes_
- Decimales (de coma flotante) con signo:
  - Decimal: `float` _4 bytes_
  - Largos: `double` _8 bytes_
- Texto
  - Caracteres: `char` _2 bytes_
  - Cadenas de texto: `String`
- Booleanos o lógicos: `boolean` _1 byte_Si no escribes ningún modificador, se aplica la visibilidad por defecto. Un miembro default solo es accesible para clases que están en el mismo paquete. No es accesible desde subclases en paquetes diferentes.
  - Valores posibles: _true_ o _false_
- Valor vacío: `void`
  - no es un tipo de dato al uso, ya que no podemos declarar variables de tipo `void`, nos sirve como una marca para indicar que un método no devuelve nada
---

Por cada tipo básico hay una clase (llamada clase _wrapper_) que lo modela y además nos proporciona métodos para trabajar con el tipo.

| TIPO BASE | WRAPPER |
|-----------|----------|
| int       | Integer |
| long      | Long |
| double    | Double |
| char      | Character |
| boolean   | Boolean |

### 1.2. Cadenas de Caracteres

No es un tipo básico, sino un objeto, se puede interpretar como un array de caracteres (aunque formalmente no es un array).

Como es un objeto, al usar el operador `==` o `!=` lo que se compara es la referencia al objeto, y no el valor de las cadenas en sí.
Para poder compararlas, debemos usar el método de la clase `Object` `public boolean equals(Object o2)`.
```java
String s1 = new String("HOLA");
String s2 = new String("HOLA");

System.out.println((s1 == s2)); // DA FALSE porque compara las referencias en memoria de los objetos

System.out.println(s1.equals(s2)); // DA TRUE porque el metodo equals en la clase String compara el valor de las cadenas.
```

Desde Java7 se permite hacer un switch con cadenas de texto de manera simplificada.

```java
String diaSemana = "jueves";
int numDia = 0;

switch (diaSemana) {
	case "lunes":
		numDia=1;
		break;
	case "martes":
		numDia=2;
		break;
	case "miercoles":
		numDia=3;
		break;
	case "jueves":
		numDia=4;
		break;
	case "viernes":
		numDia=5;
		break;
	case "sabado":
		numDia=6;
		break;
	case "domingo":
		numDia=7;
		break;
}

System.out.println(numDia); // Esto imprimira por pantalla 4

```

### 1.3. Clases y Objetos
En Java se pueden definir clases con la palabra reservada `class`.
Una clase es la definición de la estructura de una entidad que queremos representar en nuestro programa Java.

Para utilizar una clase tenemos dos opciones:
* Instanciar un objeto de dicha clase
  * Un objeto es la materialización de un _individuo_ de dicha clase: `String s = new String()`.
  * Cada objeto tendrá sus propios valores en los atributos de la clase.
* Utilizar sus métodos estáticos
  * Son aquellos que se declaran con la palabra reservada `static`.
  * Se invocan con el nombre de la clase, punto y el nombre del método: `Clase.metodoEstatico()`.
  * Un método estático solo puede acceder a otros métodos estáticos y atributos estáticos de la clase.
    * El método estático no puede usar la palabra reservada `this`, en su lugar podría usar el nombre de la clase. 
    * Pero podría crear un nuevo objeto de dicha clase y usarlo como si fuera código externo a la clase.
  * Un método _normal_, si puede acceder a los métodos y atributos estáticos de la clase.

#### 1.3.1 Variables y atributos _final_

Una variable (o un atributo de clase (estático) o de instancia (no estático)) puede ser declarado con la palabra reservada `final` al principio.
Esto convierte a la variable en una _constante_, es decir, un dato que, una vez inicializado, no puede cambiar su valor.
Si intentamos cambiar el valor de una variable _final_, obtendremos un error en tiempo de compilación o de ejecución.

## 2. Estructuras de control:

Son las herramientas que tenemos para controlar el flujo de programa, iteraciones, controles de salida, etc, estos son los más usados :

- __Bucles:__

```java
// WHILE: Bucle con condicion
//   (puede no ejecutarse ni siquiera una vez si la condición no se cumple al principio)
//   MUCHO OJO CON CREAR BUCLES INFINITOS (que siempre cumplan la condición, y por tanto no salgan)
//
while (condicion) {...}

// DO WHILE: Bucle con condicion que se ejecuta al menos una vez siempre
//   La condición se evalú al final de cada iteración, con lo cual siempre hará la primera
//   MUCHO OJO CON CREAR BUCLES INFINITOS (que siempre cumplan la condición, y por tanto no salgan)
//   PUNTO Y COMA AL FINAL !!!!!
//
do { ... } while ();

// FOR: Es una abreviatura de un bucle WHILE. Tiene tres parámetros:
//     1- INICIALIZACION: aqui ponemos lo que hay que inicializar
//            en un WHILE sería lo que va ANTES de entrar en el bucle
//            Lo común es darle un valor inical a una variable numerioca (contador)
//                 que será la que evaluemos en la condición del bucle
//
//     2- CONDICION DEL BUCLE: aqui escribimos la condición tal y como lo haríamos en un WHILE
//            Lo común es comprobar si nuestro contador ha llegado a cierta candtidad
//            Dependiendo de sin contamos hacia arriba o hacia abajo podremos hacer cosas como:
//                 contador > 0         contador >= 0
//                 contador < maximo    contador <= 0Si no escribes ningún modificador, se aplica la visibilidad por defecto. Un miembro default solo es accesible para clases que están en el mismo paquete. No es accesible desde subclases en paquetes diferentes.


//
//     3- FINAL DE ITERACION: lo que se hace al final de una iteración, para entrar en la siguiente o salir.
//            Lo común es incrementar o decrementar la variable contador, ya sea sumando/restando 1 u otro vale
//            ej: incrementar uno
//                 contador = contador + 1
//                 contador += 1
//                 contador++
//
//            ej: decrementar uno
//                 contador = contador - 1
//                 contador -= 1
//                 contador--
//
//            ej: incrementar dos
//                 contador = contador + 2
//                 contador += 2
//Si no escribes ningún modificador, se aplica la visibilidad por defecto. Un miembro default solo es accesible para clases que están en el mismo paquete. No es accesible desde subclases en paquetes diferentes.


//            ej: decrementar dos
//                 contador = contador - 2
//                 contador -= 2

for ( INICIALIZACION ; CONDICION ; FINAL IT) {...}

ej:
for (contador=0 ; contador < 100 ; contador ++) {...}

// esto seria equivalente al siguiente bucle WHILE
contador = 0;
while ( contador < 100 ) {
	...
	contador++;
}

// Si la variable de iteración no existe, se puede declarar dentro del for
//     PERO ENTONCES NO EXISTIRA FUERA DEL FOR

for (int i=0; i < 100; i+=2 ) {...}

// en este código la varible i se puede usar dentro del FOR pero no fuera, porque está declarada en el propio FOR

```


- __Condicionales:__

`if`
`ifelse`
`elseif`

switch(valor){
case 1 :
	...
case 2 :
	
}
### **Excepciones:** principalmente se usa con el bloque  `try-catch-finally`:

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

```java
`String name = "Maria";
int unreadMessages = 12;
String message = "Hola " + name + ", tienes " + unreadMessages + " mensajes sin leer.";
StringBuilder: Más eficiente que la concatenación, pero muy verboso y aparatoso.
```

```java

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



String name = "Maria";
int unreadMessages = 12;

// ¡Así de simple!
String message = STR."Hola \{name}, tienes \{unreadMessages} mensajes sin leer.";

System.out.println(message);Si no escribes ningún modificador, se aplica la visibilidad por defecto. Un miembro default solo es accesible para clases que están en el mismo paquete. No es accesible desde subclases en paquetes diferentes.


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

```java
double price = 19.99;
// Formatea el precio a dos decimales
String formattedPrice = FMT."El precio es %.2f\{price}€"; 
// "El precio es 19,99€"
RAW: Crea un objeto de plantilla sin procesar, para usos más avanzados.
```


>**Disponibilidad :** Esta característica fue introducida como vista previa (preview) en Java 21 y Java 22, y es una característica estándar y definitiva a partir de Java 23. Ya no necesitas activar ningún flag de preview para usarla si estás en Java 23 o una versión superior.


### Tabla de Placeholders para `printf`

|Placeholder|Tipo de Dato|Descripción|
|---|---|---|
|**Números Enteros**|||
|`%d`|`byte`, `short`, `int`, `long`|Formatea el número como un entero en base decimal.|
|`%o`|`byte`, `short`, `int`, `long`|Formatea el número como un entero en base octal.|
|`%x`, `%X`|`byte`, `short`, `int`, `long`|Formatea el número como un entero en base hexadecimal (minúsculas o mayúsculas).|
|**Números Decimales**|||
|`%f`|`float`, `double`|Formatea el número como un valor de punto flotante (decimal).|
|`%e`, `%E`|`float`, `double`|Formatea el número en notación científica (minúsculas o mayúsculas).|
|`%g`, `%G`|`float`, `double`|Usa `%f` o `%e` según cuál sea más corto.|
|**Caracteres y Strings**|||
|`%c`, `%C`|`char`|Formatea un único carácter (la versión mayúscula lo convierte a mayúscula).|
|`%s`, `%S`|`String`|Formatea una cadena de texto (la versión mayúscula la convierte a mayúscula).|
|**Booleanos**|||
|`%b`, `%B`|`boolean`|Formatea como `"true"` o `"false"` (la versión mayúscula lo convierte a mayúscula).|
|**Otros / Especiales**|||
|`%n`|(ninguno)|Inserta un salto de línea específico para el sistema operativo.|
|`%%`|(ninguno)|Inserta un símbolo de porcentaje literal (`%`).|


### Ejemplo de Uso

Un ejemplo práctico te ayudará a verlo en acción:


```java
String nombre = "Alex";
int edad = 28;
double salario = 1950.758;

// Usamos printf para formatear una salida limpia
System.out.printf("Empleado: %s (%d años).%n", nombre, edad);
System.out.printf("Su salario es de %.2f €.%n", salario);

/*
Salida en la consola:
Empleado: Alex (28 años).
Su salario es de 1950.76 €.
*/
```

Como ves en el ejemplo, también puedes añadir **modificadores** para controlar la precisión y el ancho:

- `%.2f`: Limita un número decimal a **2** cifras después de la coma (y lo redondea).
    
- `%10d`: Reserva **10** espacios para un número entero, alineándolo a la derecha.
    
- `%-10s`: Reserva **10** espacios para un String, alineándolo a la izquierda (por el guion `-`).
---
## 4. Librería y clases de utilidades :

El paquete `java.util` es una de las librerías fundamentales en el entorno de desarrollo de Java. Proporciona una amplia colección de clases e interfaces de utilidad que son de propósito general y esenciales para el día a día de la programación en Java. Este paquete incluye desde estructuras de datos complejas hasta herramientas para manejar fechas y expresiones regulares.

A continuación, se describen algunas de las herramientas más utilizadas de este paquete.

### **Colección de herramientas destacadas :**

Es el corazón del paquete `java.util` y ofrece un conjunto unificado de interfaces y clases para representar y manipular grupos de objetos.

- **`ArrayList`**: Es una implementación de una lista dinámica que permite almacenar elementos de cualquier tipo. A diferencia de los arrays tradicionales, un `ArrayList` puede crecer y decrecer en tamaño de forma automática. Es ideal cuando se necesita acceso rápido a los elementos a través de su índice.
    
    
    ```java
    ArrayList<String> nombres = new ArrayList<>();
    nombres.add("Juan");
    nombres.add("María");
    System.out.println(nombres.get(0)); // Imprime "Juan"
    ```
    
- **`HashMap`**: Implementa la interfaz `Map` y se utiliza para almacenar pares de clave-valor. No mantiene un orden específico de los elementos y ofrece un rendimiento muy alto para la inserción, eliminación y búsqueda de elementos a través de su clave.
    

    
    ```java
    HashMap<String, Integer> edades = new HashMap<>();
    edades.put("Juan", 25);
    edades.put("María", 30);
    System.out.println(edades.get("Juan")); // Imprime 25
    ```
    
- **`HashSet`**: Se utiliza para almacenar una colección de elementos únicos, es decir, no permite duplicados. No garantiza el orden de los elementos.
    
    
    ```java
    HashSet<String> unicos = new HashSet<>();
    unicos.add("Lunes");
    unicos.add("Martes");
    unicos.add("Lunes"); // Este elemento no se añadirá de nuevo
    System.out.println(unicos.size()); // Imprime 2
    ```
    

### **Utilidades de Entrada/Salida**

- **`Scanner`**: Es una clase muy útil para leer datos de entrada desde diversas fuentes, como el teclado, ficheros o cadenas de texto. Proporciona métodos sencillos para leer diferentes tipos de datos como enteros, cadenas o booleanos.
    
    
    ```java
    Scanner scanner = new Scanner(System.in);
    System.out.print("Introduce tu nombre: ");
    String nombre = scanner.nextLine();
    System.out.println("Hola, " + nombre);
    scanner.close();
    ```
    
> Recuerda que una vez usado y no necesites la clase Scanner, cierralo con el comando `scanner.close()` para ahorrar recursos.

### **Manejo de Fechas y Horas**

- **`Date`**: Representa un instante específico en el tiempo, con una precisión de milisegundos. Aunque ha sido en gran parte reemplazada por la API `java.time` en versiones más recientes de Java, todavía se encuentra en código antiguo.
    
- **`Calendar`**: Es una clase abstracta que proporciona métodos para convertir entre un instante de tiempo y un conjunto de campos de calendario como año, mes, día, hora, etc. Permite realizar operaciones aritméticas con fechas.
    

### **Otras Utilidades Relevantes**

- **`Random`**: Se utiliza para generar números pseudoaleatorios de diferentes tipos (enteros, dobles, etc.).
    
- **`Properties`**: Permite gestionar un conjunto de propiedades (pares clave-valor de tipo `String`) que pueden ser leídas o escritas desde un fichero, siendo muy útil para ficheros de configuración.
    

Estas herramientas son solo una pequeña muestra del poder y la flexibilidad que el paquete `java.util` ofrece a los desarrolladores de Java, simplificando una gran variedad de tareas de programación comunes.


---Si no escribes ningún modificador, se aplica la visibilidad por defecto. Un miembro default solo es accesible para clases que están en el mismo paquete. No es accesible desde subclases en paquetes diferentes.


## 5. Punto de entrada de la ejecución :

El archivo del proyecto main es el punto de entrada en la ejecución del mismo, y es necesario en cualquier aplicación aunque luego haya otras clases o funciones que entren en acción en la ejecución :

 `public statitc void main (String[] args){...}`

El argumento `String[] args` que recibe método principal o `main`, podemos usar estos argumentos mediante consola del sistema y accediendo a sus argumentos mediante `args[0]`, como si accediéramos a un array.

---
## 6. Recursividad :

Se trata de la capacidad de una función a ejecutarse a si misma por ejemplo :

```java
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
## 7. Clases :

La programación orientada a objetos o POO, aqui movemos la responsabilidad de ejecución a cada clase no como en la programación estructuradas que una ejecución de arriba a abajo y dependiendo íntegramente de los controles de flujo esta ejecución estructurada.

En la POO tenemos clases con atributos y métodos, podemos considerar las clases como una plantilla para plasmar o modelar una realidad en nuestro programa, imagina que vamos a modelar una clase Perro.

- Clase Perro tendría :

```java
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

```java
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

## __8. Visibilidad  :__

En Java, los **modificadores de visibilidad** (o de acceso) controlan qué partes de tu código pueden acceder a tus clases, atributos y métodos. Son esenciales para la **encapsulación**, que consiste en ocultar el funcionamiento interno de una clase y exponer solo lo necesario.

En Java, los **modificadores de visibilidad** (o de acceso) controlan qué partes de tu código pueden acceder a tus clases, atributos y métodos. Son esenciales para la **encapsulación**, que consiste en ocultar el funcionamiento interno de una clase y exponer solo lo necesario.

> En los ejemplos de clase recuerda mirar los de la clase Perro y sus modificaciones.


Existen cuatro niveles de visibilidad, del más abierto al más restrictivo:
### 1. `public` (Público) 🌍

Es el nivel más permisivo. Un miembro `public` es accesible desde **cualquier lugar**: desde cualquier otra clase en cualquier otro paquete.

- **Uso común**: Para métodos que forman la API principal de tu clase (como constructores, getters y setters) y para clases que deben ser usadas por todo el proyecto.
    

```java
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
    

```java
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

También se puede escribir literalmentela palabra clave `default` o `package`.

- **Uso común**: Para clases o métodos "ayudantes" que solo tienen sentido dentro del contexto de un paquete específico y no deben ser expuestos al resto de la aplicación.
    

```java
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
    

```java
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
## 9. Getter y Setter :

Llos métodos **getter** y **setter** son dos tipos de métodos públicos que se utilizan para acceder y modificar, respectivamente, el valor de las variables de instancia privadas de una clase. Su uso es una parte fundamental del principio de **encapsulamiento**, que consiste en ocultar el estado interno de un objeto y exponer solo lo necesario a través de una interfaz pública.

### Getters (Métodos de acceso)

Un método **getter** se utiliza para _obtener_ o _leer_ el valor de una variable privada. Por convención, su nombre comienza con `get` seguido del nombre de la variable (en formato camelCase).

**Características:**

- Es **público**.
    
- Devuelve el tipo de dato de la variable que lee.
    
- No recibe ningún parámetro.
    

Por ejemplo, para una variable `private String nombre;`, el getter sería:


```java
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


```java
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


```java
// Acceso directo (no recomendado)
coche.velocidad = 200;
System.out.println(coche.velocidad);
```

Se utiliza esto:

```java
// Acceso controlado mediante métodos
coche.setVelocidad(200);
System.out.println(coche.getVelocidad());
```

---
## 10. Herencia :

La **herencia** es uno de los pilares de la Programación Orientada a Objetos (POO). Permite que una clase (llamada **subclase** o clase hija) adquiera los atributos y métodos de otra clase (llamada **superclase** o clase padre). La principal ventaja es la **reutilización de código** y la creación de una jerarquía lógica entre las clases. En Java, la herencia se implementa usando la palabra clave `extends`.


### **Conceptos Clave**

- **Superclase (Clase Padre):** Es la clase de la que se hereda. Contiene los atributos y métodos comunes.
    
- **Subclase (Clase Hija):** Es la clase que hereda de la superclase. Añade sus propios atributos y métodos específicos o modifica los heredados.
    
- **`extends`:** Es la palabra clave que se utiliza para que una clase herede de otra.
    
- **`super`:** Es una palabra clave que se usa dentro de una subclase para llamar a métodos o constructores de la superclase.
    
### **Ejemplo Práctico**

Imaginemos que queremos modelar diferentes tipos de animales. Podemos crear una clase general `Animal` y luego clases más específicas como `Perro` y `Gato` que hereden de ella. 🐕🐈

**1. Superclase: `Animal`**

Esta clase tiene propiedades y comportamientos que todos los animales comparten, como un nombre y el método de comer.


```java
// Clase Padre o Superclase
class Animal {
    String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public void comer() {
        System.out.println(nombre + " está comiendo.");
    }

    public void dormir() {
        System.out.println(nombre + " está durmiendo. Zzz...");
    }
}
```

**2. Subclase: `Perro`**

La clase `Perro` **hereda** de `Animal`. Tendrá acceso a `nombre`, `comer()` y `dormir()`. Además, añadimos un método exclusivo para los perros: `ladrar()`.


```java
// Clase Hija o Subclase
class Perro extends Animal {

    public Perro(String nombre) {
        // Llama al constructor de la superclase (Animal)
        super(nombre);
    }

    // Método específico de la clase Perro
    public void ladrar() {
        System.out.println("¡Guau! ¡Guau!");
    }
}
```

**3. Subclase: `Gato`**

La clase `Gato` también hereda de `Animal` y añade su propio método: `maullar()`.

```java
// Otra Clase Hija o Subclase
class Gato extends Animal {

    public Gato(String nombre) {
        // Llama al constructor de la superclase (Animal)
        super(nombre);
    }

    // Método específico de la clase Gato
    public void maullar() {
        System.out.println("¡Miau!");
    }
}
```

**4. Poniéndolo en práctica**

Ahora, podemos crear objetos de estas clases y ver cómo funciona la herencia.


```java
public class Zoologico {
    public static void main(String[] args) {
        // Creamos un objeto de la clase Perro
        Perro miPerro = new Perro("Fido");
        miPerro.comer();   // Método heredado de Animal
        miPerro.dormir();  // Método heredado de Animal
        miPerro.ladrar();  // Método propio de Perro

        System.out.println("--------------------");

        // Creamos un objeto de la clase Gato
        Gato miGato = new Gato("Misi");
        miGato.comer();    // Método heredado de Animal
        miGato.maullar();  // Método propio de Gato
    }
}
```

**Salida del programa:**

```
Fido está comiendo.
Fido está durmiendo. Zzz...
¡Guau! ¡Guau!
--------------------
Misi está comiendo.
¡Miau!
```

Como puedes ver, tanto `miPerro` como `miGato` pueden usar el método `comer()` porque lo heredaron de `Animal`, pero cada uno tiene su propio comportamiento específico (`ladrar()` y `maullar()`). Esto evita repetir el código de `comer()` y `dormir()` en cada clase.

## 11. Interfaces :

En Java, una **interfaz** es como un **contrato** o un plano que define un conjunto de métodos que una clase debe implementar. 📜 Establece _qué_ debe hacer una clase, pero no _cómo_ lo hace.

Piensa en los botones de un control remoto de TV. Todos los controles remotos (sin importar la marca) tienen botones como "encender", "subir volumen" y "cambiar canal". La interfaz sería el conjunto de esos botones (las acciones que se pueden realizar). Cada fabricante (Sony, Samsung, etc.) decide cómo implementa internamente esa funcionalidad, pero todos cumplen con el contrato de ofrecer esos botones.

## **Características Clave**

- **100% Métodos Abstractos (por defecto):** Tradicionalmente, todos los métodos de una interfaz son `abstract`, lo que significa que no tienen cuerpo (código). Solo se define su firma (nombre, parámetros y tipo de retorno). La clase que implementa la interfaz está obligada a proporcionar el código para estos métodos.
    
- **No se pueden crear objetos:** No puedes hacer `new` de una interfaz directamente. Solo se pueden crear objetos de las clases que la implementan.
    
- **Implementación Múltiple:** Una clase en Java solo puede heredar de una superclase (`extends`), pero puede implementar múltiples interfaces (`implements`). Esta es una de las principales razones de su existencia, ya que soluciona la falta de herencia múltiple.
    
- **`default` y `static` methods:** Versiones más modernas de Java permiten que las interfaces tengan métodos con implementación (`default` methods) para añadir nueva funcionalidad sin romper las clases que ya la implementan.
    

## **Ejemplo Práctico**

Imaginemos que queremos definir el comportamiento "volador" para diferentes entidades en un juego.

- ** Definimos la Interfaz `Volador`**

Este es nuestro contrato. Cualquier cosa que sea un "Volador" debe ser capaz de despegar, volar y aterrizar.


```java
// La interfaz define QUÉ se debe hacer
interface Volador {
    void despegar();
    void volar();
    void aterrizar();
}
```

- **Creamos Clases que Implementan la Interfaz**

Ahora creamos clases que "firman" este contrato usando la palabra clave `implements`. Cada clase proporciona su propia implementación de los métodos.

**Clase `Pajaro`** 🐦


```java
class Pajaro implements Volador {

    @Override
    public void despegar() {
        System.out.println("El pájaro bate sus alas para despegar.");
    }

    @Override
    public void volar() {
        System.out.println("El pájaro planea en el cielo.");
    }

    @Override
    public void aterrizar() {
        System.out.println("El pájaro aterriza en una rama.");
    }
}
```

**Clase `Avion`** ✈️


```java
class Avion implements Volador {

    @Override
    public void despegar() {
        System.out.println("El avión acelera en la pista y despega.");
    }

    @Override
    public void volar() {
        System.out.println("El avión surca los cielos a gran velocidad.");
    }

    @Override
    public void aterrizar() {
        System.out.println("El avión despliega el tren de aterrizaje y aterriza.");
    }
}
```

- **Uso en el Código Principal**

Gracias a la interfaz, podemos tratar a un `Pajaro` y a un `Avion` de la misma manera: como algo que es `Volador`. Esto es un ejemplo de **polimorfismo**.



```java
public class SimuladorVuelo {
    public static void main(String[] args) {
        Volador miPajaro = new Pajaro();
        Volador miAvion = new Avion();

        System.out.println("--- Acciones del Pájaro ---");
        miPajaro.despegar();
        miPajaro.volar();
        miPajaro.aterrizar();

        System.out.println("\n--- Acciones del Avión ---");
        miAvion.despegar();
        miAvion.volar();
        miAvion.aterrizar();
    }
}
```

**Salida del programa:**

```
--- Acciones del Pájaro ---
El pájaro bate sus alas para despegar.
El pájaro planea en el cielo.
El pájaro aterriza en una rama.

--- Acciones del Avión ---
El avión acelera en la pista y despega.
El avión surca los cielos a gran velocidad.
El avión despliega el tren de aterrizaje y aterriza.
```

En resumen, las interfaces son un mecanismo fundamental en Java para lograr la **abstracción**, definir comportamientos comunes y habilitar el **polimorfismo**, permitiendo un código más flexible y desacoplado.

## 12. Polimorfismo :

El **polimorfismo** en Java es un principio de la programación orientada a objetos que permite que un objeto pueda tomar muchas formas. En términos prácticos, significa que puedes referirte a objetos de diferentes clases a través de una referencia de una clase común (una superclase o una interfaz). Esto permite que una misma acción (un método) se comporte de manera diferente según el objeto que la esté ejecutando.

La palabra viene del griego "poli" (muchos) y "morfos" (formas). 🐾 Piensa en un animal: un objeto `Animal` podría ser en realidad un `Perro` o un `Gato`. Si le pides que haga un sonido, el perro ladrará y el gato maullará. La acción es la misma ("hacer sonido"), pero el resultado es diferente.

## **Tipos de Polimorfismo**

Existen dos tipos principales de polimorfismo en Java:

### **1. Polimorfismo en Tiempo de Ejecución (Method Overriding)**

Este es el concepto más común de polimorfismo. Ocurre cuando una subclase proporciona una implementación específica de un método que ya está definido en su superclase. La decisión de qué método ejecutar se toma en tiempo de ejecución.

**Ejemplo Práctico:**

Primero, creamos una superclase `Figura` con un método `dibujar()`.


```java
// Superclase
class Figura {
    public void dibujar() {
        System.out.println("Dibujando una figura genérica.");
    }
}
```

Ahora, creamos subclases que **sobrescriben** (`@Override`) este método para proporcionar su propio comportamiento.


```java
// Subclase Círculo
class Circulo extends Figura {
    @Override
    public void dibujar() {
        System.out.println("Dibujando un círculo. ⚪");
    }
}

// Subclase Cuadrado
class Cuadrado extends Figura {
    @Override
    public void dibujar() {
        System.out.println("Dibujando un cuadrado. ⬜");
    }
}
```

Finalmente, vemos el polimorfismo en acción. Usamos una referencia de tipo `Figura` para apuntar a objetos de sus subclases.


```java
public class Lienzo {
    public static void main(String[] args) {
        Figura miFigura1 = new Circulo(); // Objeto Circulo, referencia Figura
        Figura miFigura2 = new Cuadrado(); // Objeto Cuadrado, referencia Figura

        miFigura1.dibujar(); // Llama al método de Circulo
        miFigura2.dibujar(); // Llama al método de Cuadrado
    }
}
```

**Salida del programa:**

```
Dibujando un círculo. ⚪
Dibujando un cuadrado. ⬜
```

Aunque ambas variables son de tipo `Figura`, Java sabe en tiempo de ejecución qué método `dibujar()` específico debe llamar.

### **2. Polimorfismo en Tiempo de Compilación (Method Overloading)**

Esto ocurre cuando múltiples métodos en la misma clase tienen el mismo nombre pero **diferentes parámetros** (ya sea en número de parámetros o en el tipo de dato de los mismos). El compilador decide qué método llamar basándose en los argumentos que se le pasan.

**Ejemplo Práctico:**


```java
class Calculadora {

    // Método sumar con dos enteros
    public int sumar(int a, int b) {
        return a + b;
    }

    // Método sumar con tres enteros (SOBRECARGA)
    public int sumar(int a, int b, int c) {
        return a + b + c;
    }

    // Método sumar con dos dobles (SOBRECARGA)
    public double sumar(double a, double b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        
        System.out.println(calc.sumar(5, 10));         // Llama al primer método
        System.out.println(calc.sumar(5, 10, 20));     // Llama al segundo método
        System.out.println(calc.sumar(3.5, 2.5));      // Llama al tercer método
    }
}
```

**Salida del programa:**

```
15
35
6.0
```

En resumen, el polimorfismo es una herramienta clave para escribir código flexible, reutilizable y fácil de mantener.
<<<<<<< HEAD

## 13 . Clases abstractas :

Una **clase abstracta** es como una plantilla o un esqueleto para otras clases. No puedes crear un objeto directamente a partir de ella, sino que la usas como base para crear otras clases más específicas (clases "hijas").

Piensa en ella como el concepto "vehículo". Sabes que un vehículo debe tener ciertas características (como `color` o `velocidad`) y comportamientos (como `acelerar()` o `frenar()`), pero "vehículo" es una idea general, no algo concreto que puedas usar. No conduces un "vehículo", conduces un "coche", una "moto" o un "camión".

### Características Principales

- **No se puede instanciar:** No puedes crear un objeto de una clase abstracta. Siguiendo el ejemplo, no puedes hacer `miVehiculo = new Vehiculo()`.
    
- **Contiene métodos abstractos:** Son métodos que se declaran pero no se implementan en la clase abstracta. Obligan a las clases hijas a que ellas mismas los definan. Por ejemplo, el método `tocarClaxon()` sería abstracto en "vehículo", porque un coche, una moto y un camión lo hacen de forma diferente.
    
- **Puede tener métodos normales:** También puede tener métodos con su lógica ya definida que las clases hijas simplemente heredan y usan tal cual, como `acelerar()`.
    

En resumen, una clase abstracta define un conjunto de reglas y comportamientos comunes que otras clases deben seguir y/o implementar, asegurando que todas tengan una estructura similar.
## Constantes:

## La palabra reservada `static`:

La palabra clave `static` significa que algo pertenece a la **clase misma** y no a una **instancia** (un objeto) de esa clase.

Imagina una clase `Coche` 🚗.

- Una variable normal (no estática) como `color` es única para cada coche que creas. Tienes un coche rojo, otro azul... cada uno tiene su propio color.
    
- Una variable `static` como `numeroDeCochesFabricados` sería **una sola variable compartida por todos los objetos** `Coche`. Si fabricas un coche nuevo, este contador aumenta para la clase entera, no solo para ese coche.
    

### ## Variables estáticas (o de clase)

Son **compartidas** por todos los objetos de la clase. Solo existe una copia de esta variable, sin importar cuántos objetos crees.


```java
class Coche {
    public static int contadorDeCoches = 0; // Variable estática
    public String color; // Variable de instancia

    public Coche() {
        contadorDeCoches++; // Se incrementa el contador de la CLASE
    }
}

// En el main:
System.out.println("Coches creados: " + Coche.contadorDeCoches); // Imprime 0
Coche miCocheAzul = new Coche();
Coche miCocheRojo = new Coche();
System.out.println("Coches creados: " + Coche.contadorDeCoches); // Imprime 2
```

### ## Métodos estáticos

Se pueden llamar **directamente desde la clase, sin necesidad de crear un objeto**. Son como herramientas o utilidades generales que no dependen de los datos de un objeto particular. 🔧

El ejemplo perfecto son los métodos de la clase `Math`:


```java
// No necesitas crear un objeto "Math" para usar sus métodos

double raiz = Math.sqrt(25); // Llamada directamente desde la clase Math

```

**Regla clave:** Un método `static` no puede usar variables o métodos que no sean `static`, porque no está asociado a ningún objeto en concreto y no sabría de qué objeto tomar esos datos.

El método `main` es el ejemplo más famoso, ya que Java necesita poder llamarlo para iniciar el programa antes de que se cree cualquier objeto.

### ## En resumen

✅ **Pertenece a la clase, no al objeto.** ✅ **Es compartido:** Para variables, hay una sola copia para todos los objetos. ✅ **No necesita un objeto:** Se accede usando el nombre de la clase (ej: `NombreClase.miMetodoEstatico()`).

## Clases enumeradas :

Los enumerados (o `enum`) son un tipo de dato especial que permite definir un **conjunto fijo de constantes con nombre**.

Imagina que quieres representar los días de la semana. En lugar de usar números (`1` para lunes, `2` para martes) o Strings (`"Lunes"`, `"Martes"`), que pueden llevar a errores, creas un enumerado. 🗓️

### ## ¿Por qué usarlos?

Principalmente por dos razones:

1. **Seguridad de tipos:** Una variable de tipo `DiaDeLaSemana` solo puede valer `LUNES`, `MARTES`, etc. No puedes asignarle un `9` o un `"Juernes"`. Esto evita errores en tiempo de ejecución.
    
2. **Claridad y legibilidad:** El código es mucho más fácil de leer y entender. `if (dia == DiaDeLaSemana.LUNES)` es infinitamente más claro que `if (dia == 1)`.
    
### ## Ejemplo básico

Así se declara y se usa un enumerado en un lenguaje como Java:


```java
// 1. Declaramos el conjunto de constantes
public enum DiaDeLaSemana {
    LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO;
}

// 2. Lo usamos en nuestro código
public class Calendario {
    public static void main(String[] args) {
        DiaDeLaSemana hoy = DiaDeLaSemana.LUNES;

        if (hoy == DiaDeLaSemana.LUNES) {
            System.out.println("¡Ánimo, empieza la semana!");
        }

        // También son muy útiles en estructuras de control como switch
        switch (hoy) {
            case SABADO:
            case DOMINGO:
                System.out.println("Es fin de semana.");
                break;
            default:
                System.out.println("Es un día laboral.");
                break;
        }
    }
}
```


Los métodos más comunes se dividen en dos categorías:

1. **Métodos estáticos proporcionados por Java**: Son métodos que el compilador añade automáticamente a cada `enum`.
    
2. **Métodos de instancia**: Métodos que cada constante del `enum` puede invocar.
    
3. **Métodos personalizados**: Métodos que puedes añadir tú mismo para extender la funcionalidad.
    

#### ## En resumen

✅ Un **enumerado** es una lista de **constantes predefinidas**. ✅ Aportan **seguridad** al no permitir valores incorrectos. ✅ Hacen el código mucho más **legible** y fácil de mantener. ✅ Pueden ser tan **simples** o **complejos** (con métodos y atributos) como necesites.
### 1. Métodos Estáticos (Proporcionados por el compilador)

Estos son los métodos más importantes y usados para trabajar con enumerados de forma general.

#### `values()`

Es, sin duda, el método más utilizado. Devuelve un **array** que contiene todas las constantes del enumerado, en el orden en que fueron declaradas.

Es perfecto para iterar sobre todas las opciones disponibles.

**Sintaxis:** `NombreDelEnum.values()`

**Ejemplo:**


```java
public enum DiaSemana {
    LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO;
}

public class TestEnum {
    public static void main(String[] args) {
        // Iterar sobre todos los días de la semana
        for (DiaSemana dia : DiaSemana.values()) {
            System.out.println(dia);
        }
    }
}
```

**Salida:**

```
LUNES
MARTES
MIÉRCOLES
JUEVES
VIERNES
SÁBADO
DOMINGO
```

#### `valueOf(String nombre)`

Este método estático devuelve la constante del enumerado que corresponde exactamente con el `String` proporcionado. Es sensible a mayúsculas y minúsculas.

Es muy útil para convertir una cadena de texto (por ejemplo, recibida de un formulario o una API) a su valor de enumerado correspondiente.

**Sintaxis:** `NombreDelEnum.valueOf(String)`

**Ejemplo:**

```java
public class TestEnum {
    public static void main(String[] args) {
        String diaRecibido = "MARTES";
        DiaSemana dia = DiaSemana.valueOf(diaRecibido);

        System.out.println("El día seleccionado es: " + dia); // Imprime: El día seleccionado es: MARTES

        // ¡Cuidado! Si el String no coincide, lanzará una excepción
        try {
            DiaSemana.valueOf("martes"); // Esto fallará
        } catch (IllegalArgumentException e) {
            System.out.println("Error: No existe una constante con ese nombre.");
        }
    }
}
```

### 2. Métodos de Instancia (Heredados de `java.lang.Enum`)

Cada constante de un enumerado es una instancia de la clase `Enum`, por lo que hereda los siguientes métodos.

#### `name()`

Devuelve el nombre de la constante del `enum` **exactamente como fue declarada** en el código. Es un método `final`, por lo que no se puede sobrescribir.

**Sintaxis:** `instanciaEnum.name()`

**Ejemplo:**


```java
DiaSemana primerDiaLaboral = DiaSemana.LUNES;
System.out.println(primerDiaLaboral.name()); // Salida: LUNES
```

#### `toString()`

Por defecto, `toString()` se comporta igual que `name()`, devolviendo el nombre de la constante. Sin embargo, a diferencia de `name()`, **puedes sobrescribir `toString()`** para proporcionar una representación más amigable.

**Sintaxis:** `instanciaEnum.toString()`

**Ejemplo con `toString()` sobrescrito:**


```java
public enum EstadoPedido {
    PROCESANDO,
    ENVIADO,
    ENTREGADO;

    @Override
    public String toString() {
        // Devuelve el nombre capitalizado (primera en mayúscula, resto en minúscula)
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
}

public class TestEnum {
    public static void main(String[] args) {
        EstadoPedido estado = EstadoPedido.PROCESANDO;
        System.out.println(estado.name());      // Salida: PROCESANDO
        System.out.println(estado.toString());  // Salida: Procesando
    }
}
```

#### `ordinal()`

Devuelve la posición (índice) de la constante en la declaración del enumerado, comenzando desde `0`.

**Sintaxis:** `instanciaEnum.ordinal()`

**Advertencia:** No es recomendable basar la lógica de tu programa en el `ordinal`, ya que si se reordena la declaración de las constantes, los valores cambiarán y podrían introducir errores difíciles de detectar. Es mejor usar campos personalizados (ver más abajo).

**Ejemplo:**

```java
System.out.println(DiaSemana.LUNES.ordinal());    // Salida: 0
System.out.println(DiaSemana.MARTES.ordinal());   // Salida: 1
System.out.println(DiaSemana.DOMINGO.ordinal());  // Salida: 6
```

#### `compareTo(E o)`

Compara el enumerado con otro objeto del mismo tipo basándose en su `ordinal()`. Devuelve un número negativo si la instancia actual va antes, cero si son iguales, o un número positivo si va después.

**Sintaxis:** `instanciaEnum1.compareTo(instanciaEnum2)`

**Ejemplo:**

```java
DiaSemana lunes = DiaSemana.LUNES;
DiaSemana viernes = DiaSemana.VIERNES;

// lunes (ordinal 0) vs viernes (ordinal 4)
System.out.println(lunes.compareTo(viernes)); // Salida: un número negativo (-4)
```

### 3. Métodos Personalizados (Definidos por el usuario)

Aquí es donde los `enum` muestran todo su potencial. Puedes añadirles atributos, constructores y tus propios métodos para asociar más lógica y datos a cada constante.

**Ejemplo Completo:** Un `enum` para tipos de planeta con atributos y métodos personalizados.


```java
public enum TipoPlaneta {
    // Cada constante llama al constructor con sus propios valores
    TERRESTRE("Rocoso", 5.51),
    GIGANTE_GASEOSO("Gaseoso", 1.33),
    GIGANTE_HELADO("Helado", 1.64),
    ENANO("Sólido", 2.0);

    // 1. Atributos (campos)
    private final String composicion;
    private final double densidadMedia;

    // 2. Constructor (siempre es privado por defecto)
    TipoPlaneta(String composicion, double densidadMedia) {
        this.composicion = composicion;
        this.densidadMedia = densidadMedia;
    }

    // 3. Métodos "getter" para acceder a los atributos
    public String getComposicion() {
        return composicion;
    }

    public double getDensidadMedia() {
        return densidadMedia;
    }

    // 4. Método personalizado con lógica propia
    public boolean esDenso() {
        return this.densidadMedia > 3.0;
    }
}

public class TestPlanetas {
    public static void main(String[] args) {
        TipoPlaneta tierra = TipoPlaneta.TERRESTRE;

        System.out.println("Planeta: " + tierra.name());
        System.out.println("Composición: " + tierra.getComposicion()); // Método personalizado
        System.out.println("Densidad media (g/cm³): " + tierra.getDensidadMedia()); // Método personalizado
        System.out.println("¿Es un planeta denso? " + tierra.esDenso()); // Método personalizado

        System.out.println("---");

        TipoPlaneta jupiter = TipoPlaneta.GIGANTE_GASEOSO;
        System.out.println("Planeta: " + jupiter); // Usa el name() por defecto
        System.out.println("¿Es un planeta denso? " + jupiter.esDenso());
    }
}
```

**Salida:**

```
Planeta: TERRESTRE
Composición: Rocoso
Densidad media (g/cm³): 5.51
¿Es un planeta denso? true
---
Planeta: GIGANTE_GASEOSO
¿Es un planeta denso? false
```

### Resumen de los Métodos Más Usados con Enumerados

| Método                     | Tipo      | ¿Para qué sirve?                                         | Caso de uso común                                                   |
| -------------------------- | --------- | -------------------------------------------------------- | ------------------------------------------------------------------- |
| **`values()`**             | Estático  | Obtener un array con todas las constantes.               | Iterar sobre todas las opciones (e.g., para llenar un `JComboBox`). |
| **`valueOf(String)`**      | Estático  | Convertir un `String` a una constante del `enum`.        | Procesar entradas de usuario o datos externos.                      |
| **`name()`**               | Instancia | Obtener el nombre de la constante como `String`.         | Logging, depuración, almacenamiento en base de datos.               |
| **`toString()`**           | Instancia | Obtener una representación en `String` (sobrescribible). | Mostrar el valor en una interfaz de usuario de forma amigable.      |
| **`ordinal()`**            | Instancia | Obtener el índice numérico de la constante.              | Comparaciones simples (con precaución).                             |
| **Métodos personalizados** | Instancia | Añadir lógica y datos específicos a cada constante.      | Modelar conceptos complejos y asociar comportamiento.               |
|                            |           |                                                          |                                                                     |


>Una de sus principales utilidades de los enumerados . Puedes usar enumerados en cualquier estructura de control que requiera una comparación, como `if`, `else if`, `else` y `switch`.

### ## Enumerados un poco más avanzados

Los enumerados no son solo listas de nombres; pueden tener **atributos y métodos**, como una clase normal. Esto los hace increíblemente potentes. 🚦

Por ejemplo, un semáforo donde cada color tiene una acción asociada:

```java

public enum Semaforo {
    
    ROJO("Detenerse"),
    AMARILLO("Precaución"),
    VERDE("Avanzar");

    private final String accion; // Atributo

    // Constructor privado
    Semaforo(String accion) {
        this.accion = accion;
    }

    // Método público
    public String getAccion() {
        return accion;
    }
}

// Cómo se usaría:

Semaforo miLuz = Semaforo.ROJO;
System.out.println(miLuz); // Imprime ROJO
System.out.println("Acción a realizar: " + miLuz.getAccion()); // Imprime "Acción a realizar: Detenerse"

```

## Arrays :

Un **array** (también conocido como arreglo, vector o matriz) es una de las estructuras de datos más fundamentales en programación. Imagina un archivador o una estantería con un número fijo de casillas numeradas: eso es un array.

Es una colección de elementos donde cada uno se almacena en una posición específica y se identifica por un número llamado **índice**.

### ### ⚙️ Características Clave

1. **Tamaño Fijo:** Cuando creas un array, debes definir su tamaño, y este **no puede cambiar** después. Si creas un array para 10 elementos, siempre tendrá espacio para exactamente 10.
    
2. **Mismo Tipo de Dato:** Todos los elementos dentro de un array deben ser del **mismo tipo**. No puedes mezclar números enteros con texto en el mismo array (por ejemplo, o todos son `int` o todos son `String`).
    
3. **Acceso por Índice:** Se accede a cada elemento directamente a través de su índice. Los índices **siempre empiezan en 0**. Por lo tanto, en un array de 10 elementos, los índices van del 0 al 9.
    
4. **Memoria Contigua:** Los elementos de un array se almacenan uno al lado del otro en la memoria del ordenador. Esta organización es lo que permite un acceso tan rápido a sus elementos.
    

### ### ✅ Ventajas y ❌ Desventajas

- **✅ Ventaja Principal: Rapidez de Acceso.** El punto fuerte de los arrays es el **acceso directo** a sus elementos. Saber el índice te permite ir instantáneamente al dato que buscas (lo que se conoce como complejidad `O(1)`), sin importar si el array tiene 10 o un millón de elementos.
    
- **❌ Desventaja Principal: Poca Flexibilidad.** Su **tamaño fijo** es su mayor debilidad. Si no sabes cuántos datos vas a guardar de antemano, o si la cantidad de datos cambia constantemente, los arrays no son la mejor opción. Además, insertar o eliminar elementos en medio del array es una operación lenta porque obliga a desplazar al resto de elementos.
    
	
### ### 💻 Ejemplo Práctico en Java

Vamos a ver un ejemplo sencillo: guardar y manipular las notas de 5 estudiantes.


```java
public class EjemploArray {

    public static void main(String[] args) {
        // 1. DECLARACIÓN Y CREACIÓN
        // Creamos un array de tipo 'int' con un tamaño fijo de 5.
        // Las casillas se inicializan a 0 por defecto.
        int[] notas = new int[5];

        // 2. ASIGNACIÓN DE VALORES (usando el índice)
        // Los índices van de 0 a 4.
        notas[0] = 10; // Primera posición
        notas[1] = 7;
        notas[2] = 9;
        notas[3] = 5;
        notas[4] = 8; // Última posición

        // 3. ACCESO A UN VALOR
        // Obtenemos la nota del tercer estudiante (índice 2).
        int notaDelTercerAlumno = notas[2];
        System.out.println("La nota del tercer alumno es: " + notaDelTercerAlumno);

        // 4. MODIFICACIÓN DE UN VALOR
        // Cambiamos la nota del cuarto estudiante (índice 3).
        System.out.println("La nota antigua del cuarto alumno era: " + notas[3]);
        notas[3] = 6;
        System.out.println("La nota nueva del cuarto alumno es: " + notas[3]);

        // 5. RECORRIDO DEL ARRAY
        // Usamos un bucle 'for' para mostrar todas las notas.
        System.out.println("\n--- Listado de todas las notas ---");
        for (int i = 0; i < notas.length; i++) {
            // 'notas.length' nos da el tamaño del array (en este caso, 5).
            System.out.println("Nota del alumno " + (i + 1) + ": " + notas[i]);
        }
    }
}
```

**Salida del programa:**

```
La nota del tercer alumno es: 9
La nota antigua del cuarto alumno era: 5
La nota nueva del cuarto alumno es: 6

--- Listado de todas las notas ---
Nota del alumno 1: 10
Nota del alumno 2: 7
Nota del alumno 3: 9
Nota del alumno 4: 6
Nota del alumno 5: 8
```

### Funciones o métodos mas usados para manipular Arrays :

la mayoría de las funciones útiles para arrays se encuentran en la clase de utilidad `java.util.Arrays`. Aquí tienes las más importantes y prácticas.

## **Ordenar y Buscar** 🔍

Estas son las operaciones más comunes: ordenar los elementos y luego buscar dentro de ellos.

- **`Arrays.sort(array)`**: Ordena un array en **orden ascendente**. Funciona para tipos primitivos (como `int`, `double`) y para objetos que implementan la interfaz `Comparable` (como `String`). Es extremadamente eficiente, usando un algoritmo de Doble Pivote Quicksort.
    
    
    ```java
    int[] numeros = {5, 2, 8, 1, 9};
    Arrays.sort(numeros); // ahora numeros es {1, 2, 5, 8, 9}
    ```
    
- **`Arrays.parallelSort(array)`**: Similar a `sort()`, pero utiliza un **algoritmo de ordenamiento en paralelo**. Puede ser más rápido en sistemas con múltiples procesadores para arrays muy grandes.
    
- **`Arrays.binarySearch(array, clave)`**: Busca un elemento (`clave`) en un array **previamente ordenado** usando el algoritmo de búsqueda binaria. Es mucho más rápido que una búsqueda lineal. Devuelve el índice del elemento si lo encuentra, o un número negativo si no.
    
    
    ```java
    int[] numerosOrdenados = {1, 2, 5, 8, 9};
    int indice = Arrays.binarySearch(numerosOrdenados, 5); // indice es 2
    int noEncontrado = Arrays.binarySearch(numerosOrdenados, 3); // devuelve un valor negativo
    ```
    

## **Copiar y Manipular** ✂️

Crear copias o sub-secciones de un array es fundamental para no modificar los datos originales.

- **`Arrays.copyOf(original, nuevoTamaño)`**: Crea una **copia** de un array. Puedes especificar un nuevo tamaño. Si el nuevo tamaño es mayor, los espacios extra se rellenan con el valor por defecto (0 para `int`, `null` para objetos).
    
    
    ```java
    String[] mascotas = {"Perro", "Gato", "Pez"};
    String[] copiaMascotas = Arrays.copyOf(mascotas, 3); // copiaMascotas es {"Perro", "Gato", "Pez"}
    ```
    
- **`Arrays.copyOfRange(original, desde, hasta)`**: Copia una **porción** de un array, desde un índice inicial (incluido) hasta un índice final (excluido).
    
    
    ```java
    int[] numeros = {10, 20, 30, 40, 50};
    int[] rango = Arrays.copyOfRange(numeros, 1, 4); // rango es {20, 30, 40}
    ```
    
- **`Arrays.fill(array, valor)`**: **Rellena** todo el array con un valor específico. Es útil para inicializar arrays con un valor constante.
    
    
    ```java
    int[] miArray = new int[5];
    Arrays.fill(miArray, 100); // miArray es {100, 100, 100, 100, 100}
    ```
    

## **Comparar y Convertir** ↔️

Estas funciones te ayudan a verificar si dos arrays son iguales o a representarlos de forma legible.

- **`Arrays.equals(array1, array2)`**: Compara si dos arrays son **iguales**. Devuelve `true` si ambos tienen el mismo tamaño y todos sus elementos son idénticos y están en el mismo orden.
    
    
    ```java
    int[] a = {1, 2, 3};
    int[] b = {1, 2, 3};
    boolean sonIguales = Arrays.equals(a, b); // true
    ```
    
- **`Arrays.deepEquals(array1, array2)`**: Se usa para comparar arrays que contienen **otros arrays** (arrays multidimensionales o de objetos). Compara el contenido de los sub-arrays de forma recursiva.
    
- **`Arrays.toString(array)`**: Devuelve una **representación en formato `String`** del contenido del array. Es increíblemente útil para depurar y ver qué contiene un array sin tener que iterar sobre él manualmente.
    
        
    ```java
    String[] nombres = {"Ana", "Luis", "Marta"};
    System.out.println(Arrays.toString(nombres)); // Imprime "[Ana, Luis, Marta]"
    ```
    
- **`Arrays.deepToString(array)`**: Similar a `toString()`, pero para arrays **multidimensionales**.
    

## **Uso con Streams (Java 8+)** 💧

A partir de Java 8, puedes convertir un array en un `Stream` para usar una API funcional muy potente.

- **`Arrays.stream(array)`**: Convierte un array en un `Stream`. Esto te permite encadenar operaciones como `filter`, `map`, `reduce`, etc., de una manera muy expresiva y concisa.
    
        
    ```java
    int[] numeros = {1, 2, 3, 4, 5, 6};
    // Sumar solo los números pares
    int sumaPares = Arrays.stream(numeros)
                          .filter(n -> n % 2 == 0) // Filtra los pares {2, 4, 6}
                          .sum();                   // Suma los elementos
    System.out.println(sumaPares); // Imprime 12
    ```
    

Estas funciones de la clase `Arrays` cubren la gran mayoría de las operaciones que necesitarás al trabajar con arrays en Java.
## `if`ternario :

Como dijimos las expresiones devuelven un valor, los `if`  ternarios son una expresión que no es numérica ni lógica es todo a la vez  y  se usa de la siguiente forma :

```java
condición ? valor_si_verdadero : valor_si_falso;
```

En resumen, se compone de 3 partes, una condición un valor si es verdadera y un valor si es falsa.

- **`condición`**: La expresión a evaluar (devuelve `true` o `false`).
    
- **`?`**: Separa la condición del valor si es `true`.
    
- **`:`**: Separa el valor si es `true` del valor si es `false`.

### ¿Cuándo usarlo?

👍 **Ideal para:** Asignaciones condicionales simples y claras, donde la lógica es muy directa. Mejora la legibilidad en casos sencillos.

👎 **Evítalo para:** Condiciones muy complejas o anidadas (un `if` dentro de otro `if`). En esos casos, un `if-else` tradicional es mucho más fácil de leer y mantener.

Un ejemplo en código de su uso sería :

```java
double precio = 100.0;

double precioFinal = (precio > 50.0) ? precio * 0.90 : precio; 

// precioFinal ahora es 90.0
```

## Operador unario : postincremento y preincremento :

Tanto el operador de **preincremento (`++variable`)** como el de **postincremento (`variable++`)** tienen el mismo objetivo final: aumentar el valor de una variable numérica en una unidad. Sin embargo, la diferencia fundamental entre ellos radica en el **momento exacto en que se realiza la operación de incremento** en relación con la evaluación de la expresión en la que se encuentran.

#### 1. Operador de Preincremento (`++variable`)

El operador de preincremento sigue la lógica de **"incrementa y luego usa"**.

- **Funcionamiento:**
    
    1. Primero, el valor de la variable se incrementa en 1.
        
    2. Después, el nuevo valor (ya incrementado) es el que se utiliza en la expresión circundante.
        
- **Ejemplo:**
    
    
    ```java
    int a = 5;
    int b = ++a; // Preincremento
    ```
    
    En esta operación:
    
    1. `a` se incrementa primero. Su valor pasa de 5 a 6.
        
    2. El nuevo valor de `a` (que es 6) se asigna a `b`.
        
    
    - **Resultado:** `a` es `6` y `b` es `6`.
        

#### 2. Operador de Postincremento (`variable++`)

El operador de postincremento sigue la lógica de **"usa y luego incrementa"**.

- **Funcionamiento:**
    
    1. Primero, el valor original de la variable se utiliza en la expresión circundante.
        
    2. Después de que la expresión ha sido evaluada, el valor de la variable se incrementa en 1.
        
- **Ejemplo:**
    
    
    ```java
    int a = 5;
    int b = a++; // Postincremento
    ```
    
    En esta operación:
    
    1. El valor original de `a` (que es 5) se asigna primero a `b`.
        
    2. Después, `a` se incrementa. Su valor pasa de 5 a 6.
        
    
    - **Resultado:** `a` es `6` y `b` es `5`.
        

### Resumen clave

|Operador|Nombre|Lógica|Valor devuelto en la expresión|
|---|---|---|---|
|**`++variable`**|Preincremento|Incrementa y luego usa|El valor **después** del incremento.|
|**`variable++`**|Postincremento|Usa y luego incrementa|El valor **antes** del incremento.|


Aunque en bucles simples como `for (int i = 0; i < 10; i++)` la diferencia funcional es nula, entender este comportamiento es crucial cuando los operadores forman parte de expresiones más complejas, como asignaciones, comparaciones o parámetros de funciones, ya que el resultado puede variar drásticamente.

> Aunque hemos hablado de incremento esta operación es idéntica para el decremento `--i` o `i++` pero no para multiplicación, división y resto de operaciones.

## Números expresados en otros formatos :

Normalmente representamos los números enteros en base 10 o sea   :

`0 1 2 3 4 5 6 7 8 9`

Representación de otras base de números en java :

```java
public class Representaciones {

	int numBase2;
	int numBase8;
	int numBase16;
	
	//se indican con 0b delante
	// 1001 = 9
	
	numBase2 = 0b1001;
	
	System.out.printf("El numero binario es %b es %d", numBase2, numBase2);
	
	// completar con codigo de Juanma
}
```




## La clase `record`

La clase `record` en Java, introducida en la versión 14, es una forma especial y concisa de crear clases que actúan como simples contenedores de datos inmutables. Piensa en ellas como una manera rápida de definir "registros" de información, como las coordenadas de un punto o los datos de un usuario.

### ## Teoría de la Clase `record`

Antes de los `records`, si querías crear una clase para almacenar datos (por ejemplo, `Punto` con `x` e `y`), tenías que escribir mucho código repetitivo (_boilerplate_):

- Campos privados (`private final int x;`).
    
- Un constructor para inicializar los campos.
    
- Métodos "getters" para cada campo (ej. `getX()`).
    
- Los métodos `equals()`, `hashCode()` y `toString()` para que la clase se comportara correctamente en colecciones y al imprimirla.
    

Todo esto hacía que el código fuera largo y propenso a errores.

Un **`record`** automatiza todo eso. Al declarar un `record`, el compilador de Java genera automáticamente por ti:

1. **Campos `private` y `final`**: Los componentes que declaras en la cabecera del `record` se convierten en campos privados y finales. Esto garantiza que el objeto sea **inmutable** (sus datos no pueden cambiar una vez creado).
    
2. **Constructor canónico**: Un constructor público que acepta todos los componentes en el mismo orden en que los declaraste.
    
3. **Métodos de acceso públicos**: Para cada componente, genera un método con el mismo nombre (por ejemplo, si tienes un componente `x`, crea un método `x()`). ¡Ojo! No sigue el convenio `getX()`.
    
4. **Implementaciones de `equals()` y `hashCode()`**: Compara dos `records` basándose en el valor de sus componentes, no en su referencia en memoria.
    
5. **Implementación de `toString()`**: Genera una representación en texto útil que muestra el nombre del `record` y sus componentes.
    

En resumen, un `record` te da una clase inmutable y centrada en los datos con el mínimo código posible.

### ## Pequeño Ejemplo

Imaginemos que queremos representar un producto simple con un nombre y un precio.

#### **La forma tradicional (antes de `record`)**

```java
import java.util.Objects;

public final class ProductoClasico {
    private final String nombre;
    private final double precio;

    public ProductoClasico(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoClasico that = (ProductoClasico) o;
        return Double.compare(that.precio, precio) == 0 && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, precio);
    }

    @Override
    public String toString() {
        return "ProductoClasico[" +
               "nombre='" + nombre + '\'' +
               ", precio=" + precio +
               ']';
    }
}
```

Como puedes ver, es mucho código para algo tan simple.

#### **La forma moderna (usando `record`)**

Ahora, mira cómo se hace lo mismo con un `record`:


```java
public record Producto(String nombre, double precio) {}
```

¡Y ya está! 🎉 Esta única línea de código genera una clase con la misma funcionalidad que el ejemplo anterior.

#### **Cómo se usa**

Puedes usarlo de la siguiente manera:


```java
public class Main {
    public static void main(String[] args) {
        // Creas una instancia como si fuera una clase normal
        Producto libro = new Producto("El Quijote", 25.99);
        Producto taza = new Producto("Taza de café", 12.50);
        Producto libroRepetido = new Producto("El Quijote", 25.99);

        // Accedes a los datos con los métodos generados
        System.out.println("Nombre del producto: " + libro.nombre());
        System.out.println("Precio: €" + libro.precio());

        // El método toString() ya está implementado
        // Imprime: Producto[nombre=El Quijote, precio=25.99]
        System.out.println(libro);

        // El método equals() compara el valor de los datos
        System.out.println("¿Es 'libro' igual a 'taza'? " + libro.equals(taza)); // false
        System.out.println("¿Es 'libro' igual a 'libroRepetido'? " + libro.equals(libroRepetido)); // true
    }
}
```

Como ves, la clase `record` simplifica enormemente la creación de clases de datos, haciendo tu código más limpio, legible y menos propenso a errores.

> Los `record` no pueden ser hijos de nadie, porque ya son hijos de una clase genérica interna.

## Clases genéricas :

En Java, una **clase genérica** es una clase que puede trabajar con cualquier tipo de dato. Piensa en ella como una especie de plantilla que te permite definir una clase con un "marcador de posición" para el tipo de objeto que va a manejar. Este tipo se especifica cuando se crea una instancia de la clase.

La característica de los genéricos fue introducida en Java 5 (J2SE 5.0) para aumentar la flexibilidad, la reutilización y la seguridad del código.

### ¿Para qué sirven y cuáles son sus beneficios?

El uso de clases genéricas aporta ventajas muy importantes en el desarrollo:

- **Seguridad de tipos (Type Safety):** 🔒 El principal beneficio es que el compilador de Java puede verificar los tipos en tiempo de compilación. Si intentas usar un tipo de dato incorrecto, el programa no compilará, evitando errores inesperados en tiempo de ejecución (como el temido `ClassCastException`).
    
- **Reutilización de código:** ♻️ En lugar de crear múltiples clases que hacen lo mismo pero con diferentes tipos de datos (por ejemplo, una lista para `Integer`, otra para `String`, etc.), puedes crear una única clase genérica. Esto reduce la duplicación y facilita el mantenimiento del código.
    
- **Eliminación de "castings":** Se elimina la necesidad de hacer conversiones explícitas de tipo (casting). Al recuperar un objeto de una colección genérica, el compilador ya sabe de qué tipo es, lo que hace el código más limpio y legible.
    

### Sintaxis de una Clase Genérica

La sintaxis para crear una clase genérica es sencilla. Se utilizan los corchetes angulares (`<>`), también conocidos como "operador diamante", para declarar uno o más parámetros de tipo. Por convención, se suelen usar letras mayúsculas como `T` (Type), `E` (Element), `K` (Key) y `V` (Value).

Aquí tienes la estructura básica:


```java
public class NombreClase<T> {
    // La variable "t" será del tipo que se especifique al crear el objeto.
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}
```

En este ejemplo, `T` es el parámetro de tipo que será reemplazado por un tipo de dato real cuando se cree un objeto de `NombreClase`.


### Ejemplo práctico: una clase "Caja"

Imagina que necesitas una clase `Caja` para guardar un objeto de cualquier tipo. Sin genéricos, tendrías que usar `Object`, lo cual es inseguro y requiere casting.

**Enfoque sin genéricos (no recomendado):**


```java
public class CajaSinGenericos {
    private Object objeto;

    public void guardar(Object objeto) {
        this.objeto = objeto;
    }

    public Object obtener() {
        return objeto;
    }
}

// Uso
CajaSinGenericos miCaja = new CajaSinGenericos();
miCaja.guardar("Hola Mundo");
String miTexto = (String) miCaja.obtener(); // ¡Se necesita un casting!

miCaja.guardar(123); // Esto es válido, pero peligroso
// String otroTexto = (String) miCaja.obtener(); // ¡Error en tiempo de ejecución! ClassCastException
```

Ahora, veamos la versión con genéricos, mucho más segura y limpia.

**Enfoque con clase genérica (recomendado):**


```java
public class Caja<T> {
    private T contenido;

    public void guardar(T contenido) {
        this.contenido = contenido;
    }

    public T obtener() {
        return contenido;
    }
}

// Uso
// Creamos una caja que SÓLO contendrá Strings
Caja<String> cajaDeTexto = new Caja<>();
cajaDeTexto.guardar("Hola Mundo Genérico");
String textoObtenido = cajaDeTexto.obtener(); // No se necesita casting
// cajaDeTexto.guardar(123); // ¡Error de compilación! El compilador nos protege.

System.out.println(textoObtenido);

// Creamos una caja que SÓLO contendrá Integers
Caja<Integer> cajaDeEnteros = new Caja<>();
cajaDeEnteros.guardar(42);
Integer numeroObtenido = cajaDeEnteros.obtener();

System.out.println(numeroObtenido);
```

Como puedes ver, el ejemplo con genéricos es mucho más robusto. El compilador se asegura de que solo puedas guardar y obtener los tipos de datos correctos, haciendo tu código más seguro y fiable desde el principio. Las colecciones más comunes en Java, como `ArrayList`, `HashMap` o `LinkedList`, son ejemplos perfectos del poder de los genéricos.

## Colecciones :
### Colección : clase par :

