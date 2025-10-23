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