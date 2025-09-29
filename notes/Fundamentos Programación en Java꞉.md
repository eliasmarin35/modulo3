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
```
String s1 = new String("HOLA");
String s2 = new String("HOLA");

System.out.println((s1 == s2)); // DA FALSE porque compara las referencias en memoria de los objetos

System.out.println(s1.equals(s2)); // DA TRUE porque el metodo equals en la clase String compara el valor de las cadenas.
```

Desde Java7 se permite hacer un switch con cadenas de texto de manera simplificada.

```
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

### 1.3. Clases Objetos
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
    * Pero podría crear un nuevo objeto de dicha clase y usarlo como si fuera código externo a la clase.
  * Un método _normal_, si puede acceder a los métodos y atributos estáticos de la clase.  

## 2. Estructuras de control:

Son las herramientas que tenemos para controlar el flujo de programa, iteraciones, controles de salida, etc, estos son los más usados :

- __Bucles:__

```
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

```
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


```
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
## 7. Clases :

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

## __8. Visibilidad  :__

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

También se puede escribir literalmentela palabra clave `default` o `package`.

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
## 9. Getter y Setter :

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


```
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


```
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

```
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


```
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

---

## **Características Clave**

- **100% Métodos Abstractos (por defecto):** Tradicionalmente, todos los métodos de una interfaz son `abstract`, lo que significa que no tienen cuerpo (código). Solo se define su firma (nombre, parámetros y tipo de retorno). La clase que implementa la interfaz está obligada a proporcionar el código para estos métodos.
    
- **No se pueden crear objetos:** No puedes hacer `new` de una interfaz directamente. Solo se pueden crear objetos de las clases que la implementan.
    
- **Implementación Múltiple:** Una clase en Java solo puede heredar de una superclase (`extends`), pero puede implementar múltiples interfaces (`implements`). Esta es una de las principales razones de su existencia, ya que soluciona la falta de herencia múltiple.
    
- **`default` y `static` methods:** Versiones más modernas de Java permiten que las interfaces tengan métodos con implementación (`default` methods) para añadir nueva funcionalidad sin romper las clases que ya la implementan.
    

---

## **Ejemplo Práctico**

Imaginemos que queremos definir el comportamiento "volador" para diferentes entidades en un juego.

- ** Definimos la Interfaz `Volador`**

Este es nuestro contrato. Cualquier cosa que sea un "Volador" debe ser capaz de despegar, volar y aterrizar.


```
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


```
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


```
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



```
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


```
// Superclase
class Figura {
    public void dibujar() {
        System.out.println("Dibujando una figura genérica.");
    }
}
```

Ahora, creamos subclases que **sobrescriben** (`@Override`) este método para proporcionar su propio comportamiento.


```
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


```
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


```
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

## Static:

## Arrays :
