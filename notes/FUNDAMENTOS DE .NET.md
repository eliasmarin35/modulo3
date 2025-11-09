# 1. ¿Qué Es .NET?

No es un lenguaje de programación en sí mismo, sino una **plataforma** (un ecosistema completo) creada por Microsoft. Es como una caja de herramientas gigante y un taller de construcción, todo en uno, que los programadores usan para crear aplicaciones.

**¿Qué tipo de aplicaciones? ¡Casi cualquiera!**

- Aplicaciones Web (como sitios de comercio electrónico o redes sociales).
    
- Aplicaciones de Escritorio (programas que instalas en tu PC o Mac).
    
- Aplicaciones Móviles (para iOS y Android).
    
- Juegos (¡especialmente con el motor Unity, que usa C#!).
    
- Servicios en la nube y mucho más.
    

**Las Piezas Clave de .NET (Conceptos básicos):**

1. **El "Runtime" (CLR - Common Language Runtime):** Piensa en esto como el "motor" de tu aplicación. Es un programa especial que se encarga de _ejecutar_ tu código. Traduce tus instrucciones a un lenguaje que la máquina entiende y gestiona cosas aburridas pero importantes, como la memoria (¡para que tu app no se "coma" todos los recursos!).
    
2. **Las Bibliotecas (SDK y Frameworks):** Estas son las "piezas prefabricadas". En lugar de tener que escribir código para, por ejemplo, conectarte a internet o dibujar un botón en la pantalla, .NET te da bibliotecas de código ya escrito (como `ASP.NET` para webs o `MAUI` para móviles) que puedes usar directamente. ¡Es como usar piezas de Lego en lugar de tener que fabricar cada ladrillo tú mismo!
    

>**Curiosidad:** Originalmente, .NET solo funcionaba en Windows (se llamaba .NET Framework). Pero ahora, la versión moderna (simplemente llamada ".NET", antes .NET Core) es **multiplataforma**, lo que significa que el código que escribes puede correr en Windows, macOS y Linux. ¡Una gran ventaja!

# 2. La Herramienta Principal C# :

Si .NET era el "taller" o la "cocina" (como vimos en el Tema 1), **C# es el idioma** en el que das las órdenes.

Es el lenguaje de programación que usarás para escribir tus "recetas" (programas) y decirle a la plataforma .NET _exactamente_ qué hacer. Es, por lejos, el lenguaje más usado y recomendado para todo el ecosistema .NET.

**¿Cómo es este idioma?**

1. **Es quisquilloso (¡en el buen sentido!):** C# se conoce como un lenguaje "**fuertemente tipado**".
    
    - **Analogía:** Imagina que tienes cajas de mudanza. C# te obliga a etiquetar _exactamente_ qué va en cada caja _antes_ de meter algo. Tendrás una caja solo para "Libros", otra solo para "Platos" y otra solo para "Números". C# no te deja, por accidente, meter un zapato en la caja de "Platos".
        
    - **¿Por qué es bueno?** Esto parece estricto al principio, pero en realidad previene _muchísimos_ errores a medida que tus programas crecen. Sabes exactamente qué tipo de datos estás manejando en todo momento.
        
2. **Es moderno y versátil:** Está diseñado para ser eficiente y te permite construir todo lo que mencionamos (web, móvil, juegos) usando una sintaxis muy parecida.
    

**Curiosidad (¡El nombre! 🎼)**

¿Por qué se llama C#? No es "C-hashtag" o "C-almohadilla". Es **"C-Sharp"** (Do Sostenido), ¡como la nota musical!

El chiste es que la nota "Sostenido" es medio tono más alta (más "aguda" o "afilada") que la nota natural. Así que C# es un "incremento" o una versión más "aguda" de los lenguajes C y C++. ¡Un pequeño chiste de programadores!

**¿Cómo se ve en la práctica?**

No te preocupes si no entiendes cada palabra aún, solo fíjate en la estructura. Este es el programa más famoso del mundo, el "¡Hola, Mundo!", escrito en C#:


```c#
// Esto le dice al sistema que queremos usar funciones de la "Consola"
using System;

// Definimos el punto de entrada principal de nuestro programa
class Program
{
    static void Main()
    {
        // La orden: "¡Escribe esta línea en la consola!"
        Console.WriteLine("¡Hola, Mundo!");
    }
}
```

La línea clave es `Console.WriteLine("¡Hola, Mundo!");`. Esa es la instrucción directa para mostrar texto en pantalla.

# 3. Los Ladrillos del Código : Variables y Operadores.

## Variable :

magina que estás cocinando (siguiendo nuestra analogía de C# como "idioma de recetas") y necesitas guardar ingredientes.

Una **variable** es simplemente un **contenedor** o una "caja etiquetada" donde guardas información (datos) mientras tu programa está funcionando.

Cada caja (variable) tiene dos cosas:

1. Un **Nombre:** Para que puedas encontrarla (ej. `edadUsuario` o `nombre`).
    
2. Un **Tipo:** Para saber qué _clase_ de cosas puedes guardar ahí (recuerda que C# es "quisquilloso").
    

**Los Tipos de Datos (Etiquetas) más comunes:**

- `string`: Para guardar texto. (Ej. `"¡Hola, Mundo!"` o `"Ana"`). Se escribe entre comillas dobles `""`.
    
- `int`: Para guardar números **enteros**. (Ej. `10`, `-5` o `2024`).
    
- `double`: Para guardar números con **decimales**. (Ej. `19.99` o `3.1416`).
    
- `bool`: Para guardar solo dos valores posibles: **verdadero** o **falso**. (Ej. `true` o `false`). Útil para preguntas de sí/no.
    

**¿Cómo se usa en C#?**

Es como etiquetar la caja y llenarla al mismo tiempo. A esto se le llama "declarar" e "inicializar" una variable.

```c#
// Sintaxis: tipo nombre = valor;

string nombreJugador = "AstroDeveloper";
int puntuacion = 1500;
double precioJuego = 59.99;
bool tieneLaLlave = true;
```

Ahora, en lugar de usar "AstroDeveloper", puedo simplemente usar la variable `nombreJugador`.

### Operadores 🔧

Los **operadores** son los "verbos" de tus datos. Son símbolos especiales que te permiten _hacer cosas_ con tus variables.

**1. El Operador de Asignación (=)**

- El signo `=` no significa "es igual a" (como en matemáticas).
    
- En C#, `=` significa **"asignar"** o **"guardar esto dentro de"**.
    
- `int x = 10;` se lee: "Asigna el valor 10 a la caja (variable) llamada x".
    

**2. Operadores Aritméticos (¡Los que ya conoces!)**

Son los que usas para hacer matemáticas:

- `+` (Suma)
    
- `-` (Resta)
    
- `*` (Multiplicación - ¡Usamos un asterisco!)
    
- `/` (División)
    

**Ejemplo en acción:**


```c#
int puntosExtra = 50;
int puntuacionActual = 100;

// Usamos el operador + para sumar dos variables
int puntuacionTotal = puntuacionActual + puntosExtra;

// ¿Qué valor tendría 'puntuacionTotal'? ¡Tendría 150!
Console.WriteLine(puntuacionTotal); // Esto imprimiría 150 en la consola
```

**3. Operadores de Comparación (¡El verdadero "igual a"!)**

Si quieres _preguntar_ si dos cosas son iguales, usas el **doble igual** `==`.

- `x == 10;` pregunta: "¿Es el valor de x _igual a_ 10?" (Esto devolvería `true` o `false`).

# 4. Condicionales :

## 4.1 La Sentencia `if`:

La sentencia `if` es la herramienta más fundamental para tomar decisiones en C#.

**Analogía: El Portero de la Discoteca 🕴️**

Imagina que la sentencia `if` es como un **portero** (un "bouncer") en la puerta de una discoteca. El portero tiene una **única regla** (la _condición_). Por ejemplo: "Solo entran los mayores de 18 años".

1. Tú llegas (eres el programa).
    
2. El portero mira tu carnet (evalúa la **condición**).
    
3. **Si** cumples la condición (es `true`), el portero te deja pasar al código que está dentro de las llaves `{ }`.
    
4. **Si no** la cumples (es `false`), el portero te ignora y el código dentro de las llaves `{ }` **no se ejecuta**. El programa simplemente sigue de largo.
    

**¿Cómo se ve en C#?**

La "condición" que comprueba el `if` casi siempre la escribimos usando los **operadores de comparación** que vimos antes (`==`, `!=`, `>`, `<`). El resultado de esa comparación _tiene_ que ser un `bool` (o sea, `true` o `false`).


```c#
// Sintaxis
if (condicion_que_sea_true_o_false)
{
    // Este código SÓLO se ejecuta si la 'condicion' es true
}
// El programa continúa aquí...
```

**Ejemplo Práctico:**

Vamos a usar la analogía del portero en código real:


```c#
int edadVisitante = 20;

// El 'if' comprueba la condición: ¿Es 20 mayor o igual que 18?
// El resultado es: true
if (edadVisitante >= 18)
{
    // Como fue 'true', esta línea SÍ se ejecuta.
    Console.WriteLine("¡Bienvenido! Puedes pasar.");
}


int edadVisitante2 = 15;

// El 'if' comprueba: ¿Es 15 mayor o igual que 18?
// El resultado es: false
if (edadVisitante2 >= 18)
{
    // Como fue 'false', esta línea se ignora por completo.
    Console.WriteLine("Lo siento, no puedes pasar.");
}
```


## 4.2 La Sentencia `else`:

La sentencia `else` (que significa "si no" o "de lo contrario") nos da un **"Plan B"**. Es la acción que se ejecuta _específicamente_ cuando la condición del `if` es `false`.

**Analogía: El Portero (Versión 2.0)**

- **`if` (El Plan A):** El portero comprueba la edad. Si es mayor de 18 (la condición es `true`), te dice: "Adelante, entra a la discoteca".
    
- **`else` (El Plan B):** Si la condición es `false` (eres menor de 18), el portero ya no te ignora. Ahora te dice: "Lo siento, no puedes entrar. Ve a la sala de refrescos de al lado".
    

**Importante:** El `else` _siempre_ va pegado a un `if` y **no lleva condición propia**. Solo se activa si el `if` falla. O se ejecuta el bloque del `if` (Plan A) o se ejecuta el bloque del `else` (Plan B). **Nunca los dos.**

### ¿Cómo se ve en C#?


```c#
// Sintaxis
if (condicion)
{
    // Bloque A: Se ejecuta si 'condicion' es TRUE
}
else
{
    // Bloque B: Se ejecuta si 'condicion' es FALSE
}
```

### Ejemplo Práctico:

Vamos a mejorar nuestro código del videojuego. Ahora, si el jugador _no_ tiene $1000$ puntos, le daremos un mensaje de consolación.


```c#
int puntuacionActual = 950;

// El 'if' comprueba: ¿Es 950 igual a 1000?
// El resultado es: false
if (puntuacionActual == 1000)
{
    // Bloque A: Esto se SALTA
    Console.WriteLine("¡Felicidades! ¡Has ganado un bonus!");
}
else
{
    // Bloque B: Como el 'if' fue false, ESTO SE EJECUTA
    Console.WriteLine("¡Casi! Sigue intentándolo.");
}

// Salida en consola: "¡Casi! Sigue intentándolo."
```

Si cambiáramos `puntuacionActual` a $1000$, la condición del `if` sería `true`, se ejecutaría el Bloque A ("¡Felicidades!...") y el Bloque B (`else`) sería completamente ignorado.

## 4.3 Sentencia `else if`:

El `else if` nos permite **encadenar** comprobaciones. Es como decir: "Comprueba el Plan A. Si falla, comprueba el Plan B. Si falla, comprueba el Plan C... y si todo lo demás falla, haz el Plan Z (`else`)".

**Analogía: La Clasificación de Notas 📝**

Imagina que estás calificando un examen:

1. **`if` (Plan A):** ¿La nota es mayor de 90? **Si es `true`**, le das una "A" y _dejas de comprobar_.
    
2. **`else if` (Plan B):** Si no fue "A" (el `if` fue `false`), entonces comprueba esto: ¿La nota es mayor de 80? **Si es `true`**, le das una "B" y dejas de comprobar.
    
3. **`else if` (Plan C):** Si no fue "B", comprueba esto: ¿La nota es mayor de 70? **Si es `true`**, le das una "C" y dejas de comprobar.
    
4. **`else` (El último recurso):** Si _nada_ de lo anterior fue `true`, le das una "F".
    

**Importante:** En una cadena `if / else if / else`, **solo uno** de los bloques se ejecutará. En cuanto el programa encuentra una condición `true`, ejecuta ese bloque y **salta el resto** de la cadena.

### ¿Cómo se ve en C#?


```c#
// Sintaxis
if (condicion_A)
{
    // Bloque A: Si A es TRUE
}
else if (condicion_B)
{
    // Bloque B: Si A es FALSE y B es TRUE
}
else if (condicion_C)
{
    // Bloque C: Si A y B son FALSE, y C es TRUE
}
else
{
    // Bloque D: Si A, B, y C son todas FALSE
}
```

### Ejemplo Práctico:

Vamos a usar la analogía de las notas en código real.


```c#
int notaExamen = 85;

if (notaExamen >= 90)
{
    Console.WriteLine("Calificación: A");
}
else if (notaExamen >= 80)
{
    // ¿Es 85 >= 90? False.
    // Pasamos al 'else if'. ¿Es 85 >= 80? True.
    // ESTE BLOQUE SE EJECUTA
    Console.WriteLine("Calificación: B");
}
else if (notaExamen >= 70)
{
    // Como el 'else if' anterior fue true, ESTO SE SALTA
    Console.WriteLine("Calificación: C");
}
else
{
    // Y ESTO TAMBIÉN SE SALTA
    Console.WriteLine("Calificación: F");
}

// Salida en consola: "Calificación: B"
```

El `else if` nos da el poder de crear "escaleras" lógicas para manejar múltiples escenarios de forma ordenada.

# 5. Los Bucles en C# :

## 5.1 El Bucle `while`

El bucle `while` hace exactamente eso:

1. **Comprueba la condición:** (¿Hay galletas?)
    
2. Si es `true` (¡Sí hay!), **ejecuta el bloque de código** (coge una galleta).
    
3. **Vuelve al paso 1** y comprueba la condición otra vez. (¿Quedan galletas?)
    
4. Repite esto hasta que la condición sea `false` (el tarro está vacío).
    
5. Cuando es `false`, el bucle se "salta" y el programa continúa.
    

### ¿Cómo se ve en C#?

Necesitamos tres cosas:

1. Una **variable de control** (el número de galletas).
    
2. El `while` con la **condición**.
    
3. **¡Actualizar la variable!** (comer la galleta) para que el bucle pueda terminar.
    

**Ejemplo Práctico (Un contador):**

Vamos a contar del 1 al 5.

```c#
int contador = 1; // 1. Empezamos nuestro contador en 1

// 2. Comprobamos la condición: "¿Es 'contador' (1) menor o igual a 5?" (Es True)
while (contador <= 5) 
{
    // 3. Ejecutamos la acción
    Console.WriteLine("El número actual es: " + contador);

    // 4. ¡¡LA PARTE MÁS IMPORTANTE!!
    // Actualizamos la variable para la *siguiente* vuelta.
    // Si no hacemos esto, ¡el bucle nunca terminará!
    contador = contador + 1; // El contador ahora valdrá 2, luego 3, 4, 5...
}

// 5. Cuando 'contador' llega a 6...
// La condición (6 <= 5) es FALSE. El bucle se detiene.
Console.WriteLine("¡Bucle terminado!");
```

**Salida de este código:**

```
El número actual es: 1
El número actual es: 2
El número actual es: 3
El número actual es: 4
El número actual es: 5
¡Bucle terminado!
```

**¡Curiosidad y Advertencia! (El Bucle Infinito 🌀)**

¿Qué pasaría si olvidamos la línea `contador = contador + 1;`?

- El `contador` _siempre_ valdría $1$.
    
- La condición `(1 <= 5)` _siempre_ sería `true`.
    
- El programa se quedaría atascado para siempre imprimiendo "El número actual es: 1". ¡Es la forma más rápida de "colgar" tu propio programa! 😂 Siempre debes asegurarte de que tu condición pueda volverse `false` en algún momento.
    

>En resumen: `while` repite _mientras_ una condición sea `true`, pero _tú_ eres responsable de asegurarte de que esa condición eventualmente cambie.

## 5.2 El Bucle "Contador" `for`

El bucle `for` es la herramienta **perfecta** (y la más usada) para repetir algo un **número exacto de veces**.

¿Por qué es mejor que el `while` para esto? Porque el `for` **agrupa las 3 partes clave** de un contador en una sola línea, haciéndolo súper limpio y difícil de olvidar (¡adiós, bucles infinitos accidentales!).

Las 3 partes que el `for` pone juntas son:

1. **La Inicialización:** (Ej. `int i = 1;`) Dónde empezamos a contar. ¡Ocurre **una sola vez** al inicio!
    
2. **La Condición:** (Ej. `i <= 5;`) La regla para seguir, se comprueba _antes_ de cada vuelta (igual que el `while`).
    
3. **El Incrementador:** (Ej. `i++`) Qué hacer _después_ de cada vuelta (normalmente, sumar 1).
    

**Curiosidad:** `i++` es la forma corta y súper común en C# (y muchos otros lenguajes) de decir `i = i + 1`. ¡Significan exactamente lo mismo!

### ¿Cómo se ve en C#?

**Sintaxis:**

```c#
for ( inicializacion ; condicion ; incrementador )
{
    // Código a repetir
}
```

**Ejemplo Práctico (Contar del 1 al 5, estilo `for`):**


```c#
// 1. i empieza en 1
// 2. Comprueba: ¿1 <= 5? (True)
// 3. ¡Ejecuta el código! -> Imprime "El número es: 1"
// 4. ¡Incrementa! -> i ahora vale 2
//
// 2. Comprueba: ¿2 <= 5? (True)
// 3. ¡Ejecuta! -> Imprime "El número es: 2"
// 4. ¡Incrementa! -> i ahora vale 3
// ...así hasta que...
// 2. Comprueba: ¿6 <= 5? (False)
// 5. ¡Se detiene!
for (int i = 1; i <= 5; i++)
{
    Console.WriteLine("El número es: " + i);
}

Console.WriteLine("¡Bucle for terminado!");
```

**Salida de este código:**

```
El número es: 1
El número es: 2
El número es: 3
El número es: 4
El número es: 5
¡Bucle for terminado!
```


> `for` Es el bucle que usarás el 90% del tiempo cuando sepas _cuántas veces_ quieres repetir algo.

## 5.3 Controlando el bucle `break` y `continue`

Ya sabes cómo _iniciar_ y _repetir_ bucles. Ahora aprenderás a _interrumpirlos_ a voluntad.

#### 1. La Salida de Emergencia: `break` 🛑

La palabra clave `break` (romper) hace exactamente eso: **rompe el bucle y se sale de él inmediatamente**.

No importa si la condición del `while` o `for` sigue siendo `true`. En cuanto el programa lee `break`, salta fuera del bucle y continúa con el resto del código.

**Analogía: La Alarma de Incendios 🔥** Estás en un bucle `for` que cuenta del 1 al 10 (vas a trabajar 10 horas). Pero en la hora 3, suena la alarma de incendios (un `if` detecta una emergencia). Tú no te quedas a terminar las 7 horas que faltan. Usas `break`: ¡sales del edificio (del bucle) _inmediatamente_!

**Ejemplo Práctico (Buscando un número):** Queremos contar hasta 20, pero parar _en cuanto_ encontremos el número 7.


```c#
for (int i = 1; i <= 20; i++)
{
    Console.WriteLine(i); // Imprime el número
    
    // Condición de emergencia
    if (i == 7)
    {
        Console.WriteLine("¡Encontré el 7! Saliendo...");
        break; // ¡Salida de emergencia!
    }
}

Console.WriteLine("Fin del programa.");
```

**Salida de este código:**

```
1
2
3
4
5
6
7
¡Encontré el 7! Saliendo...
Fin del programa. 
```

(Nota: Nunca llegó a 8, 9, 10...20. `break` lo detuvo).

---

#### 2. El "Saltar" Vuelta: `continue` ⏭️

La palabra clave `continue` (continuar) es diferente. No rompe el bucle, solo **se salta el resto de la vuelta (iteración) actual**.

Le dice al bucle: "Ya he terminado con esta vuelta, no ejecutes nada más de lo que hay debajo de mí. ¡Salta directamente a la siguiente comprobación/incremento!".

**Analogía: El Control de Calidad 🏭** Estás en un bucle `for` procesando 10 cajas en una cinta transportadora. En la caja 4, ves que está defectuosa (un `if` lo detecta). No quieres `break` (parar toda la fábrica). Usas `continue`: dejas esa caja 4 a un lado (te saltas el resto del proceso _para esa caja_) y pasas directamente a la caja 5.

**Ejemplo Práctico (Saltando los números pares):** Queremos imprimir números del 1 al 5, pero _saltarnos_ los pares.


```c#
for (int i = 1; i <= 5; i++)
{
    // Comprobamos si el número es par
    // (El % es el operador "módulo", da el resto de una división. 
    // i % 2 == 0 significa "si 'i' dividido por 2 tiene resto 0", o sea, es par)
    if (i % 2 == 0)
    {
        continue; // ¡Salta esta vuelta! Ve al siguiente 'i'
    }

    // Esta línea SÓLO se ejecuta si 'continue' no se activó
    Console.WriteLine(i);
}

Console.WriteLine("Fin del programa.");
```

**Salida de este código:**

```
1
3
5
Fin del programa.
```

(Cuando `i` valía 2 y 4, el `if` fue `true` y el `continue` hizo que el `Console.WriteLine` se saltara).

---

**En resumen:**

- `break`: ¡Para todo! Sal del bucle por completo. 🛑
    
- `continue`: ¡Salta! Termina esta vuelta y pasa a la siguiente. ⏭️
    

¡Y con eso, eres un maestro del control de bucles!

# 6. Métodos :

## 6.1 ¿Qué es un método?

Como dijimos, un **método** (o _función_) es simplemente una **receta de código** a la que le pones un nombre. Es un bloque de código que empaquetas para que realice _una tarea específica_.

**La Analogía (El Café ☕):**

Imagina que en tu cocina (tu programa) quieres hacer café. Los pasos son:

1. Coger una taza.
    
2. Poner café molido.
    
3. Verter agua caliente.
    
4. Añadir azúcar.
    

Si _cada vez_ que quisieras un café tuvieras que escribir esos 4 pasos, tu programa principal sería un lío.

En lugar de eso, tomas esos 4 pasos, los metes en una caja, y le pones una etiqueta: `PrepararCafe`.

**¿Por qué es esto maravilloso?**

1. **Organización:** Tu programa principal se vuelve súper limpio. En lugar de 4 líneas, solo tienes 1: `PrepararCafe();`.
    
2. **Reutilización (¡El Superpoder!):** Si quieres 5 cafés, ¿tienes que copiar los 4 pasos 5 veces (20 líneas de código)? ¡No! Simplemente _llamas_ a tu receta 5 veces:
    
    
    ```c#
    PrepararCafe();
    PrepararCafe();
    PrepararCafe();
    PrepararCafe();
    PrepararCafe();
    // (¡O mejor aún, un bucle 'for' que lo llame 5 veces!)
    ```
    

---

### ¿Cómo se ve en C#?

Hay dos partes: **Definir** la receta y **Llamar** a la receta.

**1. La Definición (La Receta):** (Esto lo escribimos _fuera_ de `Main`, pero dentro de la clase del programa).


```c#
/*
   "static": Por ahora, piénsalo como una etiqueta necesaria para que 'Main' pueda usarlo.
   "void": Significa "vacío". Es una promesa de que este método HACE cosas, 
           pero NO DEVUELVE ningún resultado (como un número o un texto).
   "Saludar()": ¡El nombre que inventamos para nuestra receta!
*/
static void Saludar()
{
    // Este es el bloque de código que se ejecutará
    Console.WriteLine("¡Hola! ¡Bienvenido a mi programa!");
    Console.WriteLine("Espero que te guste.");
}
```

**2. La Llamada (Usar la Receta):** (Esto lo escribimos _dentro_ de nuestro `Main`).


```c#
static void Main(string[] args)
{
    Console.WriteLine("El programa está empezando...");
    
    // ¡LA LLAMADA! Le decimos al programa: "¡Ejecuta la receta 'Saludar' AHORA!"
    Saludar();

    Console.WriteLine("----------------------------------");
    Console.WriteLine("Vamos a saludar de nuevo...");

    // ¡La reutilizamos!
    Saludar();

    Console.WriteLine("El programa ha terminado.");
}
```

**¿Cuál será la salida de este código?**

```
El programa está empezando...
¡Hola! ¡Bienvenido a mi programa!
Espero que te guste.
----------------------------------
Vamos a saludar de nuevo...
¡Hola! ¡Bienvenido a mi programa!
Espero que te guste.
El programa ha terminado.
```

¡Hemos empaquetado 2 líneas de código en un solo comando reutilizable!

## 6.2 Parámetros y Retorno

Este tema tiene dos partes geniales: cómo darle "ingredientes" a tu método y cómo hacer que te "devuelva" un resultado.

### Dando Ingredientes (Parámetros 🎁)

Nuestro método `Saludar()` de antes era un poco aburrido. Siempre decía lo mismo. ¿Y si quisiéramos que saludara a una persona _específica_?

Para eso, le pasamos un **parámetro**. Piensa en el parámetro como un "ingrediente" que la receta necesita para funcionar.

**1. La Definición (La Receta con "espacio" para el ingrediente):**

Fíjate cómo ahora, dentro de los paréntesis `()`, "anunciamos" que esperamos un `string` (texto) y le ponemos un nombre temporal: `nombre`.


```c#
// "string nombre" es el PARÁMETRO. 
// Es una variable que solo existe dentro de este método.
static void SaludarPersona(string nombre)
{
    Console.WriteLine("¡Hola, " + nombre + "! ¡Bienvenido!");
}
```

**2. La Llamada (Dándole el ingrediente):**

Ahora, cuando llamamos al método, estamos _obligados_ a pasarle un `string` dentro de los paréntesis.


```c#
static void Main(string[] args)
{
    // Le pasamos "Ana" como ingrediente.
    // "Ana" viaja y se copia dentro de la variable 'nombre' del método.
    SaludarPersona("Ana");

    // ¡La reutilizamos con un ingrediente diferente!
    SaludarPersona("Carlos");
}
```

**Salida de este código:**

```
¡Hola, Ana! ¡Bienvenido!
¡Hola, Carlos! ¡Bienvenido!
```

¡Ahora tenemos una receta flexible!

---

### Recibiendo un Resultado (Valores de Retorno 📬)

Hasta ahora, nuestros métodos han sido de tipo `void`. `void` significa "vacío"; es una promesa de que el método _hace_ cosas (como imprimir en pantalla), pero **no devuelve ningún valor**.

Pero, ¿y si queremos un método que _calcule_ algo y nos dé el resultado? Como una calculadora.

Para eso, **reemplazamos `void` por el tipo de dato que queremos devolver** (ej. `int` si devolverá un número, `string` si devolverá texto). Y luego, usamos la palabra clave `return` para "escupir" el resultado.

**1. La Definición (La Calculadora):**

Este método _promete_ devolver un `int`. Acepta dos "ingredientes" (`int num1`, `int num2`) y usa `return` para devolver la suma.


```c#
// Ya no es 'void', ¡ahora es 'int'!
static int Sumar(int num1, int num2)
{
    int resultado = num1 + num2;
    return resultado; // ¡Devuelve el valor y termina el método!
}
```

**2. La Llamada (Atrapando el resultado):**

Cuando llamamos a un método que devuelve algo, ¡tenemos que "atrapar" ese resultado en una variable!


```c#
static void Main(string[] args)
{
    // 1. Llamamos a Sumar(5, 3)
    // 2. El método calcula 8 y hace "return 8"
    // 3. El valor 8 "vuelve" y lo guardamos en la variable 'miSuma'
    int miSuma = Sumar(5, 3);

    Console.WriteLine("El resultado de la suma es: " + miSuma);

    // ¡Podemos reutilizarlo!
    int otraSuma = Sumar(100, 50);
    Console.WriteLine("Otro resultado: " + otraSuma);
}
```

**Salida de este código:**

```cmd
El resultado de la suma es: 8
Otro resultado: 150
```

**En resumen:**

- **Parámetros** (ej. `string nombre`): "Ingredientes" que le _das_ al método para que trabaje.
    
- **Valores de Retorno** (ej. `int` y `return`): El "resultado" que el método te _devuelve_ después de trabajar.
    

¡Con esto, tus métodos se vuelven increíblemente poderosos!

# 6. Almacenamiento de grupos : Arrays (Arreglos):

Un **array** (también llamado arreglo, vector o matriz) es la estructura de datos más básica para guardar una **colección de elementos del mismo tipo**.

**Analogía: El Pastillero Semanal o una Cajonera**

Piensa en un array como un **pastillero** de esos que tienen 7 días (Lunes, Martes...).

- Es un _solo_ contenedor (el pastillero).
    
- Tiene varios "espacios" (7).
    
- Cada espacio guarda algo (la pastilla).
    
- ¡Importante! Todos los espacios son del _mismo tamaño_ y guardan _el mismo tipo_ de cosa.
    

O piensa en una **cajonera**:

- La cajonera es el array (`string[] misAmigos`).
    
- Cada cajón individual es un **elemento**.
    
- Para saber qué hay en un cajón, necesitas su **número de cajón**.
    

#### La Regla de Oro: El Índice Cero (0-Indexed)

Aquí viene la parte más importante (¡y que confunde a todo el mundo al principio!): En programación, casi siempre empezamos a contar desde **CERO (0)**.

- El **primer** elemento está en la posición `0`.
    
- El **segundo** elemento está en la posición `1`.
    
- Si un array tiene 5 elementos, sus posiciones (índices) van del `0` al `4`.
    

---

### ¿Cómo se ve en C#?

Hay dos partes: "crear la cajonera" (declarar) y "usar los cajones" (acceder).

**1. Declarar e Inicializar un Array**

Puedes hacerlo de dos formas:

C#

```
// Opción 1: Sabes el tamaño, pero no los valores (Crea 5 cajones vacíos)
// Le decimos: "Quiero un array de 'int' llamado 'edades' con 5 espacios."
int[] edades = new int[5];

// Opción 2: Sabes los valores exactos al crearlo (Crea y llena los cajones)
// Le decimos: "Quiero un array de 'string' llamado 'dias' con estos valores."
// C# cuenta solo y sabe que tiene 7 espacios.
string[] dias = { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo" };
```

(Fíjate en los corchetes `[]` después del tipo de dato. Así se le dice a C# que es un array).

**2. Acceder y Modificar Elementos**

Usamos el nombre del array y los corchetes `[]` con el **número de índice** (la posición) que queremos ver o cambiar.


```c#
// Usando el array 'dias' que creamos arriba:
string[] dias = { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo" };

// ACCEDER (Leer): ¿Qué día está en la posición 0?
Console.WriteLine( dias[0] ); // Imprimirá "Lunes"

// ACCEDER (Leer): ¿Qué día está en la posición 3?
Console.WriteLine( dias[3] ); // Imprimirá "Jueves"

// MODIFICAR (Escribir): ¡Cambiemos el Sábado!
// El Sábado está en la posición 5 (recuerda: 0, 1, 2, 3, 4, 5)
dias[5] = "SÁBADO DE FIESTA";
Console.WriteLine( dias[5] ); // Ahora imprimirá "SÁBADO DE FIESTA"
```

**Curiosidad (¡Los Bucles y los Arrays!):** ¿Y si quieres imprimir _todos_ los días? ¡No escribes 7 `Console.WriteLine`! Usas un bucle `for`, que es el compañero perfecto de los arrays.

```c#
// Un array tiene una propiedad ".Length" que te dice cuántos elementos tiene.
// dias.Length es 7
for (int i = 0; i < dias.Length; i++)
{
    // i valdrá 0, luego 1, luego 2...
    Console.WriteLine( dias[i] ); 
}
```

---

**En resumen:** Un array es un contenedor (una cajonera) con un **tamaño fijo** que guarda una lista de elementos del **mismo tipo**, y accedes a cada elemento usando su número de posición (índice), **empezando desde 0**.

# 7. Programación Orientada a Objetos (POO):

Hasta ahora, hemos trabajado con los tipos de datos que C# nos da: `int` (para números), `string` (para texto), `bool` (para verdadero/falso) y `int[]` (cajoneras de números).

Pero, ¿qué pasa si quieres representar algo más complejo del mundo real? Como un **Coche**, un **Jugador**, o un **Producto**.

Un coche no es solo un número o un texto. Un coche tiene _varias_ cosas a la vez:

- Tiene un `string` (su color).
    
- Tiene un `int` (su año).
    
- Tiene un `bool` (¿está encendido?).
    
- Y también tiene _acciones_: puede `Arrancar()` o `Frenar()`.
    

La **Programación Orientada a Objetos (OOP)** es la forma de crear nuestros _propios tipos de datos_ (como `Coche`) que agrupan todos esos datos y acciones en un solo paquete.

## 7.1 ¿Qué es un objeto?

Para entender esto, necesitas conocer dos palabras clave que son el corazón de todo:

1. **La Clase (El Plano 📐):** Una `class` es el **plano**, el **molde** o la **receta**. La clase _no_ es el objeto, sino la _descripción_ de cómo será ese objeto. El plano de un coche define que "tendrá 4 ruedas, 1 motor y un color", pero el plano en sí no te lleva a ninguna parte.
    
2. **El Objeto (El Coche Real 🚗):** Un `object` es la **instancia** real construida a partir de ese plano. Es el coche físico que está en tu garaje. Puedes usar un solo plano (una `class`) para construir _muchos_ objetos (muchos coches). Tu coche rojo y mi coche azul son dos objetos diferentes, pero ambos vienen de la misma clase (plano).
    

---

### ¿Cómo se ve esto en C#?

Dividimos el proceso en dos pasos:

#### Paso 1: Definir el Plano (La `class`)

Primero, _fuera_ de nuestro método `Main`, definimos el "plano" de un Coche. (No te preocupes por la palabra `public` por ahora, solo piensa que significa "se puede ver/usar desde fuera").


```c#
// PASO 1: EL PLANO (LA CLASE)
// Esto es el "molde"
class Coche
{
    // 1. Propiedades (Los Datos que tendrá)
    public string color;
    public int año;

    // 2. Métodos (Las Acciones que podrá hacer)
    public void Arrancar()
    {
        // Puede usar sus propias propiedades
        Console.WriteLine("¡El coche " + color + " de año " + año + " hace Vrum-vrum!");
    }
}
```

¡Perfecto! Acabamos de crear un _nuevo tipo de dato_ en C# llamado `Coche`.

#### Paso 2: Construir y Usar Objetos (Las Instancias)

Ahora, _dentro_ de nuestro método `Main`, podemos usar ese plano para construir coches reales. La palabra clave `new` es la "fábrica" que toma el plano y construye el objeto.


```c#
static void Main(string[] args)
{
    // PASO 2: CONSTRUIR EL OBJETO (La Instancia)
    // "Quiero un nuevo Coche de fábrica, y lo guardaré en la variable 'miMercedes'"
    Coche miMercedes = new Coche();

    // Ahora le damos sus datos únicos usando el operador "."
    miMercedes.color = "Rojo";
    miMercedes.año = 2023;

    // ¡Y podemos usar sus acciones!
    miMercedes.Arrancar(); // Salida: ¡El coche Rojo de año 2023 hace Vrum-vrum!

    
    // ¡La magia es que podemos crear más!
    Coche tuFord = new Coche();
    tuFord.color = "Azul";
    tuFord.año = 2010;
    
    tuFord.Arrancar(); // Salida: ¡El coche Azul de año 2010 hace Vrum-vrum!
}
```

>**En resumen:**
>
>- La **Clase** (`class Coche`) es el plano 📐.
  >  
>- El **Objeto** (`miMercedes` o `tuFord`) es el coche real 🚗 construido con ese plano, usando la palabra `new`.
  >  

Acabas de crear "cajas" personalizadas (`Coche`) que contienen sus propias "cajas" internas (`color`, `año`) y sus propias "recetas" (`Arrancar`).

Sé que es un gran salto conceptual, ¡posiblemente el más grande! ¿Qué tal lo ves? ¿Se entiende la diferencia entre el "plano" (Clase) y la "cosa real" (Objeto)?

# 8. Los Constructores :

¿Recuerdas que para crear nuestro perro "Fido" hicimos esto?

```c#
Perro miMascota = new Perro(); // Paso 1: Crear
miMascota.nombre = "Fido";     // Paso 2: Asignar nombre
```

Es un poco molesto tener que crearlo y _luego_ asignarle el nombre. ¿Y si olvidamos asignarle el nombre? Tendríamos un perro sin nombre.

Aquí es donde entra el **Constructor**.

Un **constructor** es un **método especial** dentro de una clase que se **ejecuta automáticamente** (y solo una vez) en el momento exacto en que usas la palabra clave `new`.

**Su único trabajo es "construir" el objeto correctamente**, asegurándose de que tenga todos sus "ingredientes" (datos) básicos desde el primer segundo.

**Analogía: La Cadena de Montaje de Coches 🚗** Cuando pides un coche nuevo (usas `new Coche()`), no te dan un chasis vacío y luego te dicen "ahora ponle las ruedas y el motor tú mismo". ¡No! La fábrica (`new`) usa una "cadena de montaje" (el **constructor**) que le _pone_ el motor, el color y las ruedas _antes_ de entregártelo.

#### ¿Cómo se ve en C#?

Un constructor es fácil de identificar por dos reglas:

1. **Tiene el mismo nombre EXACTO que la clase**.
    
2. **NO tiene tipo de retorno** (¡ni siquiera `void`!).
    

Vamos a mejorar nuestro "plano" (`class`) del `Heroe` para que _requiera_ un nombre y vida al ser creado.


```c#
class Heroe
{
    // Propiedades (Datos)
    public string nombre;
    public int vida;

    // --- ¡EL CONSTRUCTOR! ---
    // Se ejecuta automáticamente cuando hacemos "new Heroe(...)"
    // Toma "ingredientes" (parámetros) para inicializar el objeto.
    public Heroe(string nombreInicial, int vidaInicial)
    {
        Console.WriteLine("¡Un nuevo héroe está siendo creado!");
        
        // Asigna los "ingredientes" a las propiedades del objeto
        nombre = nombreInicial;
        vida = vidaInicial;
        // (Por ahora, no incluimos estaVivo, lo haremos luego)
    }

    // Métodos (Acciones)
    public void Atacar()
    {
        Console.WriteLine(nombre + " lanza un ataque!");
    }
}
```

#### ¿Cómo se _usa_ ahora?

¡Fíjate qué limpio queda! Ahora hacemos todo en **un solo paso**.

```c#
static void Main(string[] args)
{
    // ¡LA NUEVA FORMA!
    // Le pasamos los "ingredientes" ("Link", 100)
    // directamente a la "fábrica" (new Heroe)
    Heroe miHeroe = new Heroe("Link", 100);

    // ¡Ya no necesitamos las líneas de asignación!
    // miHeroe.nombre = "Link";  <-- ¡Esto ya no es necesario!
    // miHeroe.vida = 100;     <-- ¡Esto tampoco!

    // El héroe ya está "listo" y con sus datos desde el inicio
    Console.WriteLine("El nombre de mi héroe es: " + miHeroe.nombre);
    miHeroe.Atacar();
}
```

**Salida de este código:**

```
¡Un nuevo héroe está siendo creado!
El nombre de mi héroe es: Link
Link lanza un ataque!
```

>**En resumen:** El **Constructor** es el "método especial" que se llama con `new` y sirve para inicializar las propiedades del objeto, asegurando que nazca completo y en un estado válido.

# 9. Encapsulación:

Este es uno de los pilares de la Programación Orientada a Objetos. La palabra suena complicada, pero la idea es simple:

**Encapsulación** significa **proteger** los datos importantes (propiedades) de una clase para que no sean modificados incorrectamente desde el exterior.

**Analogía: El Panel de Control del Coche 🚗** Piensa en un coche. El motor, los cables, la inyección... son increíblemente complejos y _peligrosos_ de tocar directamente. El fabricante no te deja un manojo de cables sueltos en el salpicadero.

En lugar de eso, te da un **panel de control seguro** (el volante, los pedales, la palanca de cambios). Estas son las herramientas públicas (`public`) que te permiten _interactuar_ con la maquinaria interna (`private`) de forma controlada.

¡No puedes poner el coche en marcha atrás a 100 km/h! El panel de control (la encapsulación) te lo impide.

#### El Problema: `public` es demasiado confiado

Hasta ahora, hemos escrito: `public int vida;`

Esto es como dejar los cables del motor al aire. Cualquiera (otro programador, o tú mismo por error) puede hacer esto desde `Main`: `miHeroe.vida = -500;` // ¡Ups! 😱 `miHeroe.vida = 9999999;` // ¡Ups! 😱

#### La Solución: `private` (El Escudo 🛡️)

Cambiamos la palabra `public` por `private`. `private` significa: "Esta variable **solo** puede ser vista o modificada desde _dentro_ de esta misma clase (dentro del `class Heroe { ... }`)".

```c#
class Heroe
{
    public string nombre;
    private int vida; // ¡Protegido!
    
    // ... constructor ...
}

// --- En el Main ---
miHeroe.nombre = "Link"; // OK (es public)
miHeroe.vida = 100;      // ¡ERROR! 'vida' es inaccesible/privado.
```

¡Genial! Hemos protegido la vida. Pero... ahora tenemos un problema: ¿cómo le _damos_ vida o _leemos_ su vida? ¡Ni siquiera nosotros podemos!

#### La Solución (Completa): Métodos de Acceso (Getters y Setters)

Creamos métodos **públicos** (`public`) que actúan como "guardianes" o "porteros" de la variable **privada** (`private`).

- **Getter (Obtener):** Un método público que _lee_ el valor privado y lo _devuelve_.
    
- **Setter (Establecer):** Un método público que _recibe_ un valor y, **con lógica de control**, decide si modificar o no la variable privada.
    

Vamos a implementar esto en nuestro `Heroe`:

```c#
class Heroe
{
    public string nombre;
    private int vida; // 1. El dato está PROTEGIDO

    public Heroe(string nombreInicial)
    {
        nombre = nombreInicial;
        vida = 100; // ¡Le damos 100 de vida al nacer!
    }

    // --- 2. EL GETTER (El "Lector") ---
    // Un método público que devuelve (lee) la vida.
    public int GetVida()
    {
        return vida;
    }

    // --- 3. EL SETTER (El "Guardián") ---
    // Un método público que recibe daño, pero CON LÓGICA
    public void RecibirDaño(int daño)
    {
        if (daño < 0) // ¡CONTROL! No permitimos daño negativo (curación)
        {
            Console.WriteLine("Error: El daño no puede ser negativo.");
            return; // No hagas nada más
        }

        // Si el daño es válido, lo aplicamos
        vida = vida - daño;

        // ¡MÁS CONTROL! No permitimos vida negativa
        if (vida < 0)
        {
            vida = 0; // El mínimo es 0
        }
        
        if (vida == 0)
        {
            Console.WriteLine(nombre + " ha sido derrotado.");
        }
    }
}
```

#### ¿Cómo se _usa_ ahora?

¡Fíjate qué seguro y limpio es ahora!


```c#
static void Main(string[] args)
{
    Heroe miHeroe = new Heroe("Link");

    // ¿Cómo leemos la vida? ¡Usando el Getter!
    // miHeroe.vida; <-- ERROR, es privado
    Console.WriteLine("Vida actual: " + miHeroe.GetVida()); // OK, imprime 100

    // ¿Cómo le hacemos daño? ¡Usando el Setter!
    // miHeroe.vida = miHeroe.vida - 30; <-- ERROR
    miHeroe.RecibirDaño(30);
    Console.WriteLine("Vida actual: " + miHeroe.GetVida()); // Imprime 70

    // ¿Qué pasa si intentamos hacer "trampa"?
    miHeroe.RecibirDaño(-50); // El "Guardián" actúa
    Console.WriteLine("Vida actual: " + miHeroe.GetVida()); // Sigue siendo 70
    
    // ¿Qué pasa si le damos demasiado daño?
    miHeroe.RecibirDaño(500); // Recibe 500 de daño
    Console.WriteLine("Vida actual: " + miHeroe.GetVida()); // Imprime 0 (no -430)
}
```


>**En resumen:** La **Encapsulación** es ocultar los datos (`private`) y exponer métodos (`public`) para controlarlos. ¡Así evitas que tu `vida` sea `-50`!

**Curiosidad (El atajo de C#):** C# tiene un atajo _súper_ común para esto llamado **Propiedades** (`get; set;`). Son una forma limpia de escribir Getters y Setters, pero la lógica que acabas de aprender (proteger lo privado, exponer lo público) es la misma.

# 10. La Herencia :

## 10.1 La herencia

La **Herencia** es un mecanismo que te permite crear una nueva clase (la "clase hija") que **reutiliza, extiende y modifica** el comportamiento de una clase ya existente (la "clase padre").

En C#, a la clase "padre" la llamamos **Clase Base** y a la clase "hija" la llamamos **Clase Derivada**.

**Analogía: La Familia 👪**

Piensa en esto literalmente como una familia:

- **Clase Base (`Heroe`):** Es el "Padre". Define las características comunes de la familia (ej. todos tienen un `nombre`, todos tienen `vida`, todos pueden `RecibirDaño()`).
    
- **Clase Derivada (`Mago`):** Es el "Hijo".
    
    - **Hereda** automáticamente todo lo que tiene el padre (el `nombre` y la `vida`). ¡No tiene que volver a definirlos!
        
    - Puede tener sus _propias_ cosas únicas (ej. una propiedad `int mana`).
        
    - Puede tener sus _propias_ acciones (ej. un método `LanzarHechizo()`).
        

Un `Mago` **ES UN** `Heroe`, pero un `Heroe` _no_ es necesariamente un `Mago`. (Igual que "un Dálmata ES UN Perro", pero "un Perro no es necesariamente un Dálmata").

### ¿Cómo se ve en C#?

¡La sintaxis es increíblemente simple! Usamos un **dos puntos (`:`)** después del nombre de la clase hija, seguido del nombre de la clase padre.

Se lee: `class Mago : Heroe` como "La clase Mago **hereda de** Heroe".

#### Paso 1: La Clase Base (El Padre)

Aquí está nuestro `Heroe` que ya conocemos. No cambia nada.

```c#
// --- LA CLASE BASE (PADRE) ---
class Heroe
{
    public string nombre;
    private int vida;

    // El constructor del padre
    public Heroe(string nombreInicial)
    {
        nombre = nombreInicial;
        vida = 100;
    }

    // Métodos públicos que los hijos podrán heredar
    public void RecibirDaño(int daño)
    {
        vida = vida - daño;
        if (vida < 0) vida = 0;
        Console.WriteLine(nombre + " tiene ahora " + vida + " de vida.");
    }

    public int GetVida()
    {
        return vida;
    }
}
```

#### Paso 2: La Clase Derivada (El Hijo)

Aquí está la magia. Fíjate en los dos puntos (`:`) y lo _vacía_ que está esta clase.

```c#
// --- LA CLASE DERIVADA (HIJA) ---
// Usamos ':' para heredar de Heroe
class Mago : Heroe
{
    // ... Por ahora la dejamos vacía ...

    // ¡Ups! Tenemos un pequeño error aquí...
    // El constructor del hijo necesita "llamar" al constructor del padre.
    // Lo vemos en el siguiente paso. Por ahora, imagina que esto funciona.
}
```

¡Y ya está! Solo con esa línea (`: Heroe`), la clase `Mago` **acaba de recibir** (invisiblemente) la propiedad `nombre`, la propiedad `vida`, el método `RecibirDaño()` y el método `GetVida()`.

**En resumen:** La herencia (con `:`) es la forma de decir "esta nueva clase es un tipo _especializado_ de esta otra clase y debe empezar con todo lo que esa clase padre ya tiene".

El "padre" (`Heroe`) tiene un constructor que _exige_ un `nombreInicial`. C# no deja que el "hijo" (`Mago`) nazca si no se cumple el requisito del padre.

El `Mago` también necesita su propio constructor (para recibir sus propios "ingredientes", como el `nombre` o el `mana`).

Para conectar los dos, usamos la palabra clave **`: base(...)`**.

`base` es la forma que tiene el "hijo" de referirse al "padre". Así, `: base(nombre)` significa: "Toma este `nombre` que acabo de recibir y **pásaselo al constructor de mi clase base (`Heroe`)**".

### Así se corrige el "plano" del Mago:

```c#
// --- LA CLASE DERIVADA (HIJA) - CORREGIDA ---
class Mago : Heroe // El Mago "es un" Heroe
{
    // 1. Propiedad ÚNICA del Mago
    public int mana; 

    // 2. EL CONSTRUCTOR DEL "HIJO"
    // Recibe ingredientes para ÉL (manaInicial) y para su PADRE (nombreInicial)
    public Mago(string nombreInicial, int manaInicial) 
        : base(nombreInicial) // <-- ¡LA MAGIA!
    {
        // 3. Pasa el 'nombreInicial' al constructor del 'Heroe'
        
        // 4. Asigna sus propias propiedades
        Console.WriteLine("¡Se está creando un Mago!");
        mana = manaInicial;
    }

    // (Más tarde añadiremos el método LanzarHechizo())
}
```

¡Y ya está! Ahora, cuando creemos un `new Mago("Gandalf", 150)`, el constructor del `Mago` se activará, llamará _inmediatamente_ al constructor del `Heroe` (pasándole "Gandalf") y luego asignará el `150` al `mana`.

---

Ahora que el plano está completo y funcional, pasemos a nuestro **Tema 2: Reutilizando Código**. ¡Vamos a ver la _magia_ de la herencia en acción!

>En Java, para hacer exactamente lo mismo (llamar al constructor de la clase padre), usarías la palabra clave `super(...)` dentro de la primera línea del constructor del hijo.

>En C#, la palabra equivalente es `: base(...)` y se pone _antes_ de que empiece el bloque `{}` del constructor del hijo.

>El concepto es _exactamente_ el mismo (llamar al constructor "de arriba"), pero la sintaxis es un poquito diferente. ¡Genial que tengas esa base de Java! Te va a ayudar muchísimo, ya que el 90% de los conceptos de OOP son idénticos.

## 10.2 La Reutilización del código

Aquí es donde vemos el beneficio _inmediato_ de la herencia.

Nuestro "plano" del `Mago` (la `class Mago`) está casi vacío. Solo le hemos añadido `mana` y su constructor. **No hemos escrito** un método `RecibirDaño()` ni `GetVida()` dentro de `class Mago`.

Pero como `Mago` **hereda de** `Heroe` (con `: Heroe`), ¡un objeto `Mago` puede usar _todos los métodos públicos_ de `Heroe` como si fueran suyos!

#### ¡Veámoslo en acción!

Este sería nuestro método `Main`:

```c#
static void Main(string[] args)
{
    // 1. Creamos un Mago.
    // Llama al constructor de Mago, que llama al constructor 'base' de Heroe.
    Mago gandalf = new Mago("Gandalf", 150); // Tiene nombre y 150 de mana

    // 2. Leemos su nombre (¡propiedad heredada de Heroe!)
    Console.WriteLine("Se ha creado: " + gandalf.nombre);

    // 3. Leemos su vida (¡método 'GetVida()' heredado de Heroe!)
    // Recuerda que 'vida' es private, pero 'GetVida()' es public.
    Console.WriteLine("Vida inicial: " + gandalf.GetVida()); // Imprimirá 100

    // 4. ¡¡LA MAGIA!!
    // Usamos un método que SÓLO existe en la clase 'Heroe',
    // ¡pero 'gandalf' (un Mago) puede usarlo!
    gandalf.RecibirDaño(30);

    // 5. Comprobamos el resultado...
    Console.WriteLine("Vida restante: " + gandalf.GetVida()); // Imprimirá 70
}
```

**Salida de este código:**

```cmd
¡Un nuevo héroe está siendo creado!
¡Se está creando un Mago!
Se ha creado: Gandalf
Vida inicial: 100
Gandalf tiene ahora 70 de vida.
Vida restante: 70
```

¡Fíjate! Hemos podido usar `.nombre`, `.GetVida()` y `.RecibirDaño()` en nuestro objeto `gandalf` (que es de tipo `Mago`) **ahorrándonos 100% del trabajo** de volver a escribir toda esa lógica de `vida` protegida.

>**En resumen:** La herencia nos da una reutilización de código masiva. La clase "hija" (Derivada) obtiene gratis todas las funcionalidades (métodos/propiedades públicas) de la clase "padre" (Base).

Pero la herencia no es solo para reutilizar. También es para **especializarse**.

## 10.3 Especialización de clases

Ya vimos que la herencia es genial para **reutilizar** (un `Mago` _es un_ `Heroe` y usa su `RecibirDaño()`).

Pero el verdadero poder es la **especialización**: un `Mago` puede hacer cosas que un `Heroe` genérico no puede. Puede tener sus propias propiedades y sus propios métodos.

Ya le dimos al `Mago` una propiedad única: `int mana`.

Ahora, ¡démosle un método único!

#### Añadiendo Métodos Específicos

Vamos a añadir el método `LanzarHechizo()` **solo** a la clase `Mago`.

```c#
// --- LA CLASE DERIVADA (HIJA) ---
class Mago : Heroe // El Mago "es un" Heroe
{
    // 1. Propiedad ÚNICA del Mago
    public int mana; 

    // 2. El Constructor del "hijo"
    public Mago(string nombreInicial, int manaInicial) 
        : base(nombreInicial) // Llama al constructor del Heroe
    {
        Console.WriteLine("¡Se está creando un Mago!");
        mana = manaInicial;
    }

    // --- 3. ¡¡EL MÉTODO DE ESPECIALIZACIÓN!! ---
    // Este método SÓLO existe en la clase Mago.
    public void LanzarHechizo()
    {
        if (mana >= 20)
        {
            // ¡Un Mago puede usar su 'nombre' (heredado) y su 'mana' (propio)!
            Console.WriteLine(nombre + " lanza una bola de fuego!");
            mana = mana - 20; // Gasta mana
        }
        else
        {
            Console.WriteLine(nombre + " intenta lanzar un hechizo, ¡pero no tiene mana!");
        }
    }
}
```

#### ¿Cómo se usa esto en `Main`?

Fíjate en la diferencia:

```c#
static void Main(string[] args)
{
    // Creamos un Mago (que ES UN Heroe)
    Mago gandalf = new Mago("Gandalf", 50);

    // Creamos un Heroe genérico (que NO es un Mago)
    Heroe conan = new Heroe("Conan");

    // --- ACCIONES DEL MAGO ---
    gandalf.RecibirDaño(10);     // ¡OK! Método heredado de Heroe.
    gandalf.LanzarHechizo();   // ¡OK! Método propio de Mago.

    // --- ACCIONES DEL HEROE ---
    conan.RecibirDaño(10);      // ¡OK! Método propio de Heroe.
    
    // ¡¡ERROR DE COMPILACIÓN!!
    // conan.LanzarHechizo();  
    // Da error porque 'conan' es un Heroe, no un Mago.
    // La clase 'Heroe' no tiene un método llamado 'LanzarHechizo()'.
}
```

>**En resumen:**
>
>- La **Clase Base** (`Heroe`) define el comportamiento _común_.
  >  
>- La **Clase Derivada** (`Mago`) **hereda** ese comportamiento Y **añade** el suyo _propio_ (`mana`, `LanzarHechizo()`).
    

¡Y con esto has completado los tres pilares de la Programación Orientada a Objetos: Encapsulación, Herencia y Polimorfismo (aunque no lo hemos llamado así, la idea de que un `Mago` _es un_ `Heroe` es la base del polimorfismo)!

¿Qué tal? ¿Se entiende cómo "especializamos" al `Mago` dándole habilidades que su "padre" `Heroe` no tiene?

# 11. Coleccion `List<T>` en .NET:

¡Dejamos atrás la OOP y volvemos a cómo manejamos _grupos_ de datos!

## 11.1 `List <T>` Nuestra mochila magica

Olvida la "cajonera" (`Array`) con un número fijo de cajones. Una **`List<T>`** (pronunciado "Lista de T") es como una **Mochila Mágica**.

- Puedes **meter cosas** (`.Add()`) y la mochila **crece sola**.
    
- Puedes **sacar cosas** (`.Remove()`) y la mochila **se encoge sola**.
    
- Puedes **preguntarle cuántas cosas tiene** (`.Count`) en cualquier momento.
    

Es la colección de datos _flexible_ por defecto en .NET.

### ¿Qué significa la `<T>`? (Genéricos)

La `<T>` es un marcador de posición para el **tipo** de dato que quieres guardar. Se llama **Genéricos**.

Cuando "creas" la mochila, le dices _exactamente_ qué tipo de cosas vas a guardar en ella, y solo te dejará guardar eso (recuerda que C# es "fuertemente tipado").

- `List<string>`: Una mochila mágica que **solo** guarda texto (`string`).
    
- `List<int>`: Una mochila mágica que **solo** guarda números enteros (`int`).
    
- `List<Heroe>`: ¡Una mochila mágica que **solo** guarda tus objetos `Heroe`!
    

Para poder usar `List<T>`, tienes que añadir una línea al principio de tu archivo (¡solo una vez!) para "importar" la caja de herramientas de colecciones de .NET: `using System.Collections.Generic;`

### ¿Cómo se crea?

Usas la palabra `new`, igual que con los objetos:

```c#
// Primero importamos la "caja de herramientas"
using System.Collections.Generic;

// ...

// Creamos una nueva mochila mágica vacía para guardar puntuaciones
List<int> puntuaciones = new List<int>();

// Creamos una lista de invitados, ¡y le añadimos 2 nombres al crearla!
List<string> invitados = new List<string> { "Ana", "Luis" };
```

>**En resumen:** `List<T>` es el "Array 2.0". Es una colección flexible que crece y se encoge sola, y le dices el tipo de dato que guardará usando los `< >` (ej. `List<string>`).

## 11.2 Los Comandos Clave (`.Add`, `.Count`, `.Remove`)

Imaginemos que tenemos nuestra "mochila" de puntuaciones, recién creada y vacía:

```c#
List<int> puntuaciones = new List<int>();
```

### 1. Añadir: `.Add(item)`

Este es el método que usas para **meter algo en la mochila**. El ítem siempre se añade al **final** de la lista.

```c#
// La mochila está vacía.
puntuaciones.Add(100);
// La mochila (lista) ahora contiene: [100]

puntuaciones.Add(80);
// La mochila (lista) ahora contiene: [100, 80]

puntuaciones.Add(95);
// La mochila (lista) ahora contiene: [100, 80, 95]
```

¡Fácil! La mochila ha crecido sola para guardar los 3 números.

### 2. Contar: `.Count` (¡Propiedad!)

Este es súper importante. **Ojo:** ¡No es un método con `()`! Es una **propiedad** (como `.Length` en los arrays) que te dice _cuántos ítems_ hay _ahora mismo_ en la mochila.

```c#
// Siguiendo el ejemplo anterior...
Console.WriteLine(puntuaciones.Count); 

// Salida en consola: 3
```

### 3. Eliminar: `.Remove(item)`

Este método te permite **sacar algo de la mochila**. Lo busca por su _valor_ y saca la _primera_ aparición que encuentra.

```c#
// La mochila contiene: [100, 80, 95]
puntuaciones.Remove(80); // ¡Busca el número 80 y sácalo!

// La mochila (lista) ahora contiene: [100, 95]
// La mochila se encogió sola.

Console.WriteLine(puntuaciones.Count); 
// Salida en consola: 2
```


>**En resumen:**
>
>- `.Add(valor)`: Mete un valor al final.
  >  
>- `.Count`: Te dice cuántos hay.
  >  
>- `.Remove(valor)`: Saca el valor (el primero que encuentre).
    

¡Con estos tres comandos ya puedes manejar la mayoría de las situaciones con listas!

## 11.3 Recorriendo la Lista (`foreach`)

Ya sabemos cómo _manipular_ la lista. Ahora, ¿cómo la _leemos_?

Si quisiéramos imprimir todos nuestros invitados, con lo que sabíamos _antes_, haríamos esto:

```c#
// LA FORMA "VIEJA" (con un bucle 'for')
// ¡Funciona, pero es un poco "ruidosa" y propensa a errores!
for (int i = 0; i < invitados.Count; i++)
{
    // Tenemos que manejar el índice 'i' y usar corchetes []
    Console.WriteLine(invitados[i]); 
}
```

(Sí, ¡las `List<T>` también se pueden acceder con `[i]` como los arrays! Pero casi nunca lo necesitarás).

Esta forma (con `for`) es manual. Tienes que inicializar `i`, comprobar `i < .Count` e incrementar `i++`. Es fácil cometer un error.

C# nos da una herramienta mucho mejor: el bucle **`foreach`** ("por cada").

**Analogía: El "Repartidor" 📦**

Un bucle `foreach` es como un repartidor de paquetes. Tú no le dices: "Ve al camión, coge el paquete 0. Luego ve, coge el paquete 1...". Tú solo le dices: "**Por cada** paquete en ese camión, tráemelo y déjalo en la puerta".

El `foreach` hace eso:

- Se encarga _él solo_ de ir a la colección.
    
- Saca el primer ítem y te lo da en una variable temporal.
    
- Ejecutas tu código con ese ítem.
    
- Luego _él solo_ va a por el siguiente, y el siguiente...
    
- ...hasta que no quedan más.
    

**No tienes que manejar índices (`i`), ni contadores (`.Count`), ni nada.** ¡Es a prueba de errores!

### ¿Cómo se ve en C#?

**Sintaxis:**

```c#
foreach (TipoDelItem variableTemporal in miColeccion)
{
    // Usa la 'variableTemporal' aquí
}
```

### Ejemplo Práctico (La Lista de Invitados)

Vamos a imprimir nuestra lista final de "Ana", "Lucía" y "Carlos".

```c#
List<string> invitados = new List<string> { "Ana", "Lucía", "Carlos" };

Console.WriteLine("--- Lista Final de Invitados ---");

// ¡LA FORMA MODERNA!
// Se lee: "Por cada 'nombre' (string) en la lista 'invitados'..."
foreach (string nombre in invitados)
{
    // En la 1ª vuelta, 'nombre' será "Ana"
    // En la 2ª vuelta, 'nombre' será "Lucía"
    // En la 3ª vuelta, 'nombre' será "Carlos"
    Console.WriteLine(nombre);
}
```

**Salida de este código:**

```cmd
--- Lista Final de Invitados ---
Ana
Lucía
Carlos
```

¡Mira qué limpio! Sin `i`, sin `[ ]`, sin `.Count`. Solo la intención: "Por cada nombre, imprímelo".

>**En resumen:** El `foreach` es tu herramienta preferida para **leer** (recorrer) cualquier colección (`List<T>`, `Arrays`, etc.) de principio a fin.

¡Y con esto, has dominado `List<T>`, la colección más importante de .NET!

# 12. LINQ

Pero, ¿Qué pasa si nuestra lista de héroes (`List<Heroe>`) tiene 1.000 héroes dentro? ¿Cómo encontramos _solo_ a los que tienen la vida por debajo de 50? ¿O cómo encontramos al héroe llamado "Gandalf"?

## 12.1 ¿Qué es LINQ? (El "Google" 🔎 de tus Listas)

**LINQ** son las siglas de **Language-Integrated Query** (Consulta Integrada en el Lenguaje).

Dicho de forma sencilla: LINQ es una **caja de herramientas** que te permite hacer **preguntas complejas** a tus colecciones (`List<T>`, `Arrays`, etc.) de forma muy simple y legible.

Es como tener un motor de búsqueda de Google integrado en C# para tus propios datos.

En lugar de escribir bucles `foreach` con `if` adentro para _encontrar_ cosas (lo cual es lento y verboso), LINQ te permite _describir_ lo que quieres, en una sola línea.

**Ejemplo de "antes" (Sin LINQ):** "Quiero una lista de todos los héroes con vida menor a 50."

```c#
List<Heroe> heroesDebiles = new List<Heroe>();
foreach (Heroe heroe in todosLosHeroes)
{
    if (heroe.GetVida() < 50)
    {
        heroesDebiles.Add(heroe);
    }
}
```

¡Esto son 5 líneas de código!

**Ejemplo de "ahora" (Con LINQ):**

```c#
var heroesDebiles = todosLosHeroes.Where(heroe => heroe.GetVida() < 50);
```

¡Una sola línea! 🚀

---

### La Única Regla: `using System.Linq;`

LINQ no viene "activado" por defecto. Es una caja de herramientas tan grande que debes "importarla" al principio de tu archivo (junto a los otros `using`).

Para usar `.Where()`, `.FirstOrDefault()`, etc., **debes** añadir esta línea en la parte superior de tu archivo `.cs`:

```c#
using System.Linq;
```

Si olvidas esto, C# no reconocerá los comandos de LINQ y te dará un error.

>**En resumen:** LINQ es un conjunto de métodos (como `.Where()`) que te da superpoderes para buscar, filtrar y ordenar colecciones, y solo necesitas recordar `using System.Linq;` para usarlos.

## 12.2 Filtrado de listas `.Where()`

El método `.Where()` es el caballo de batalla de LINQ. Es el **filtro**.

Toma una colección completa (como tu `List<Heroe>`) y te devuelve una _nueva_ colección (invisible por ahora) que **solo** contiene los elementos que pasaron tu "prueba".

**La "Expresión Lambda" (La "Prueba" ➡️)**

¿Cómo le dices a `.Where()` _cuál_ es la prueba? Usando algo que en C# se llama **expresión lambda** (¡que es idéntica a las lambdas de Java!).

Es esa sintaxis de flecha: `=>`

`heroe => heroe.GetVida() < 50`

- **`heroe`** (a la izquierda): Es un nombre de variable temporal. Es como decir: "Por cada ítem en la lista, llámalo `heroe` por un momento".
    
- **`=>`** (la flecha): Separa la variable del...
    
- **`heroe.GetVida() < 50`** (a la derecha): La **condición** o "prueba". Debe ser algo que devuelva `true` o `false`.
    

Todo junto, `miLista.Where(heroe => heroe.GetVida() < 50)` se lee: "En `miLista`, _filtra_ (Where) y dame solo los ítems donde (=>) la `vida` de ese `heroe` sea menor que 50."

### ¿Cómo se usa en C#?

Vamos a usar una lista simple de números primero.

```c#
// No olvides 'using System.Linq;' al inicio del archivo

List<int> numeros = new List<int> { 10, 4, 25, 3, 8, 50 };

// 1. LA CONSULTA (El Filtro)
// Usamos 'var' por comodidad. 'var' deja que C# adivine el tipo.
// "num" es la variable temporal (¡como en un foreach!)
// La prueba es: num > 10
var numerosGrandes = numeros.Where(num => num > 10);
// 'numerosGrandes' ahora contiene [25, 50]

// 2. USAMOS LOS RESULTADOS
// ¡Podemos usar un 'foreach' en el resultado de LINQ!
Console.WriteLine("Los números mayores que 10 son:");
foreach (int n in numerosGrandes)
{
    Console.WriteLine(n);
}
```

**Salida de este código:**

```cmd
Los números mayores que 10 son:
25
50
```

>**En resumen:** `.Where(variable => condicion)` es tu filtro. Recibe una lambda y devuelve una nueva colección solo con los ítems que dieron `true` en esa condición.

# 12.3 Buscando Un Elemento (`.FirstOrDefault()`) 🎯

Ya sabemos cómo "filtrar" una lista (`.Where()`) para obtener _todos_ los que cumplen una condición (ej. todos los productos baratos).

Pero, ¿Qué pasa si solo quieres **uno**? Por ejemplo, "Buscar el producto cuyo nombre sea 'Jamón'". Sabes que solo debería haber uno (¡o solo te importa el primero!).

Para esto, usamos **`.FirstOrDefault()`**.

Este método hace dos cosas, como su nombre indica:

1. **First (Primero):** Busca en la lista, ítem por ítem, y en cuanto encuentra el _primero_ que cumple tu condición `=>`, te lo devuelve y **para de buscar**.
    
2. **Default (Por Defecto):** Si recorre _toda_ la lista y **no encuentra ninguno** que cumpla la condición, no da un error. Simplemente te devuelve el valor "por defecto" de ese tipo.
    
    - Para Objetos (como `Producto` o `Heroe`): Devuelve `null`.
        
    - Para `int`: Devuelve `0`.
        
    - Para `bool`: Devuelve `false`.
        

¡Esto de `null` es súper importante, porque evita que tu programa se rompa si no encuentra algo!

### ¿Cómo se usa en C#?

Usa la misma sintaxis "lambda" (`=>`) que usaste con `.Where()`.

```c#
// No olvides 'using System.Linq;' al inicio del archivo

List<Producto> productos = new List<Producto> 
{
    new Producto { Nombre = "Leche", Precio = 60 },
    new Producto { Nombre = "Pan", Precio = 40 },
    new Producto { Nombre = "Jamón", Precio = 120 },
    new Producto { Nombre = "Queso", Precio = 90 }
};

// --- Ejemplo 1: Encontrando "Jamón" ---
var productoEncontrado = productos.FirstOrDefault(p => p.Nombre == "Jamón");

if (productoEncontrado != null) // ¡Siempre bueno comprobar!
{
    // 'productoEncontrado' NO es una lista, 
    // es el objeto Producto "Jamón"
    Console.WriteLine("Encontrado: " + productoEncontrado.Nombre + ", Precio: " + productoEncontrado.Precio);
}

// --- Ejemplo 2: Buscando "Pizza" (que no existe) ---
var pizza = productos.FirstOrDefault(p => p.Nombre == "Pizza");

if (pizza == null) // ¡Entrará aquí!
{
    Console.WriteLine("No se encontró el producto 'Pizza'.");
}
```

**Salida de este código:**

```cmd
Encontrado: Jamón, Precio: 120
No se encontró el producto 'Pizza'.
```


>**En resumen:**
>
>- **`.Where(p => ...)`**: Es un **filtro**. Te devuelve una **colección** (potencialmente muchos ítems).
  >  
>- **`.FirstOrDefault(p => ...)`**: Es un **buscador**. Te devuelve **un solo ítem** (o `null` si no lo encuentra).

# Introducción : Creación de App Web con Blazor :

## 1. ¿Qué es Blazor y cómo funciona?

Imagina que quieres construir una página web interactiva, como una tienda online o una red social. Tradicionalmente, para toda la parte "interactiva" (qué pasa cuando haces clic en un botón, cómo se actualizan los datos, etc.), el rey indiscutible era **JavaScript**.

**Blazor** es la forma que tiene Microsoft de decir: "¡Oye! ¿Y si pudieras hacer todo eso, pero usando **C#** y **.NET**?".

Así que, en esencia, Blazor te permite construir el "front-end" (la parte que ve el usuario en el navegador) usando el mismo lenguaje que quizás ya usas para el "back-end" (la lógica del servidor).

---

### ¿Cómo funciona? Los dos "sabores" de Blazor

Aquí es donde se pone interesante. Blazor no es una sola cosa, tiene dos modelos principales de alojamiento, es decir, dos formas de "correr" tu aplicación:

#### 🥑 Blazor Server

- **La analogía:** Piensa en esto como si estuvieras jugando a un videojuego en _streaming_ (como Google Stadia o Xbox Cloud Gaming). El juego corre en un servidor potente y tú solo ves el resultado en tu pantalla.
    
- **Cómo funciona:** Tu aplicación (todo tu código C#) vive y se ejecuta **en el servidor**.
    
- El navegador del usuario solo recibe el resultado (el HTML).
    
- Cuando el usuario hace clic en un botón, esa señal viaja al servidor. El servidor procesa el clic, ve qué cambió en la pantalla, y envía _solo la pequeña actualización_ de vuelta al navegador.
    
- Utiliza una tecnología llamada **SignalR** para esa comunicación súper rápida.
    
- **Pros:** La carga inicial es muy rápida (el navegador descarga poca cosa) y es ideal si la lógica de tu app debe permanecer segura en el servidor.
    
- **Contras:** Necesita una conexión a Internet constante y activa.
    

#### 🥝 Blazor WebAssembly (Wasm)

- **La analogía:** Piensa en esto como si _descargaras el juego completo_ en tu consola. Ocupa más al principio, pero una vez lo tienes, corre en tu máquina.
    
- **Cómo funciona:** Tu aplicación C# y una versión compacta del _runtime_ (el motor) de .NET se descargan **completamente al navegador** del usuario.
    
- ¡Tu código C# se ejecuta _directamente dentro_ del navegador!
    
- Esto es posible gracias a **WebAssembly** (de ahí el nombre "Wasm"), un estándar web que permite ejecutar código (como C#, C++, Rust...) a velocidades muy rápidas en el navegador.
    
- **Pros:** Una vez cargada, la aplicación es muy rápida (no hay viajes al servidor para la lógica de la UI) e ¡incluso puede funcionar sin conexión a Internet!
    
- **Contras:** La descarga inicial es más grande, por lo que la primera carga puede ser más lenta.
    

En resumen: **Blazor Server** ejecuta el código en el servidor y "transmite" la interfaz, mientras que **Blazor WebAssembly** ejecuta el código directamente en el navegador del usuario.

¡Perfecto! Entramos en el corazón de Blazor.

## 2. Componentes de Blazor

Todo en Blazor es un **componente**. Piensa en ellos como **piezas de LEGO** 🧱.

- Puedes tener piezas pequeñas (un botón, una caja de texto).
    
- Puedes juntar esas piezas pequeñas para hacer piezas medianas (un formulario de inicio de sesión).
    
- Puedes juntar esas piezas medianas para hacer piezas grandes (la página de perfil de usuario).
    
- Y finalmente, juntas todas esas piezas grandes para construir tu aplicación completa (tu castillo de LEGO).
    

Un componente de Blazor es un archivo (con extensión `.razor`) que contiene dos cosas, mezcladas de forma muy inteligente:

1. **El HTML (la vista):** Lo que ve el usuario.
    
2. **El C# (la lógica):** Lo que "da vida" a esa vista (qué pasa al hacer clic, qué datos mostrar, etc.).
    

La "magia" que los une es la sintaxis **Razor** (de ahí el nombre `.razor`), que se identifica con el símbolo **`@`**.

---

### Anatomía de un Componente

Mira este ejemplo súper básico. Imagina que creamos un archivo llamado `Saludo.razor`:

Razor CSHTML

```
<h3>¡Hola, @Nombre!</h3>
<p>¡Bienvenido a tu primer componente!</p>

@code {
    // Aquí va toda la lógica de C#
    private string Nombre = "Estudiante de Blazor";
}
```

Vamos a diseccionarlo:

- `<h3>¡Hola, @Nombre!</h3>`: Esto es mayormente HTML, pero fíjate en `@Nombre`. El `@` le dice a Blazor: "Oye, no escribas literalmente '@Nombre', busca una variable de C# llamada `Nombre` y pon su valor aquí".
    
- `@code { ... }`: Este bloque, siempre al final, es donde vive tu C#.
    
- `private string Nombre = ...`: Esta es la variable de C# que usamos arriba.
    

Cuando Blazor ejecute esto, el resultado en el navegador será:

> ### ¡Hola, Estudiante de Blazor!
> 
> ¡Bienvenido a tu primer componente!

Lo mejor de esto es que si cambias el valor de la variable `Nombre` (por ejemplo, con un botón), ¡Blazor **actualizará automáticamente** el `<h3>`! No tienes que decirle "Oye, ve y cambia el H3", Blazor lo sabe solo.

---

En resumen: **Los componentes son piezas reutilizables de UI (HTML + C#) que se pueden anidar unas dentro de otras.**

## 3. Eventos y Enlace de Datos (Data Binding)

Ya sabemos _mostrar_ datos (C# $\to$ HTML). Ahora veremos cómo _reaccionar_ a lo que hace el usuario (clics, escribir en un campo, etc.).

---

### Parte A: Eventos (¡Haciendo clic!)

Cuando un usuario hace algo (como un clic), eso es un **evento**. Blazor nos permite "escuchar" esos eventos de forma muy sencilla.

La sintaxis es `@on[evento]`. El más común es `@onclick`.

Veamos un ejemplo clásico: un contador.

Razor CSHTML

```
<h4>¡Contador de clics!</h4>

<p>Veces que has hecho clic: @conteoActual</p>

<button @onclick="IncrementarConteo">
    ¡Haz clic!
</button>

@code {
    private int conteoActual = 0;

    private void IncrementarConteo()
    {
        // Esta función se llama CADA VEZ que se hace clic
        conteoActual = conteoActual + 1;
        // O más corto: conteoActual++;
    }
}
```

**¿Qué está pasando aquí?**

1. Tenemos una variable `conteoActual` que empieza en 0.
    
2. El párrafo `<p>` muestra el valor de `@conteoActual`.
    
3. El botón `<button>` tiene la directiva `@onclick="IncrementarConteo"`.
    
4. Esto significa: "Cuando alguien haga clic en este botón, ejecuta el método de C# llamado `IncrementarConteo`".
    
5. El método `IncrementarConteo` simplemente suma 1 a la variable.
    
6. **¡Magia!** En cuanto `conteoActual` cambia, Blazor lo detecta y actualiza automáticamente el párrafo `<p>`. ¡No tienes que decirle que lo haga!
    

---

### Parte B: Enlace de Datos (Data Binding)

Esto es como un "pegamento" súper fuerte entre tu HTML y tu C#.

Ya hemos visto el enlace de un solo sentido:

<h3>@Nombre</h3>

Aquí, el valor de la variable Nombre va al H3. Pero si el H3 cambiara (que no puede), no cambiaría la variable.

Lo que nos falta es el enlace de doble sentido (Two-Way Data Binding).

Esto se usa principalmente con campos de formulario (como un <input>).

- Queremos que el valor de la variable C# aparezca en el `<input>`.
    
- Y también queremos que, si el usuario _escribe_ algo en el `<input>`, la variable de C# se actualice _automáticamente_.
    

Esto se logra con la directiva `@bind`.

Mira este ejemplo:

Razor CSHTML

```
<h3>¡Hola, @nombre!</h3>

<p>Escribe tu nombre:</p>
<input @bind="nombre" />

@code {
    private string nombre = "Visitante";
}
```

**¿Qué está pasando aquí?**

1. El `<h3>` muestra el valor de `nombre` (que empieza siendo "Visitante").
    
2. El `<input>` está _enlazado_ a la misma variable `nombre` usando `@bind="nombre"`.
    
3. Si ejecutas esto, verás: "¡Hola, Visitante!" y una caja de texto que dice "Visitante".
    
4. Si borras el texto de la caja y escribes "Ana", en el _mismo instante_ en que escribes, ¡el `<h3>` cambiará a "¡Hola, Ana!"!
    
5. La variable `nombre` y el `<input>` están sincronizados en ambas direcciones.
    

---

**En resumen:**

- **`@onclick`** (y otros `@on...`) $\to$ Ejecuta un método de C# cuando el usuario hace algo.
    
- **`@bind`** $\to$ Mantiene una variable de C# y un campo de formulario (como un `<input>`) perfectamente sincronizados.
    

Estos dos conceptos son el 90% de lo que harás en Blazor para crear interactividad.

¿Qué te parece? ¿Se entiende la diferencia entre `@onclick` (para una acción) y `@bind` (para sincronizar un valor)?