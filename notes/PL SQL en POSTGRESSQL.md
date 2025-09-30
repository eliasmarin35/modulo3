
**PL/SQL (Procedural Language/Structured Query Language)** es una extensión de **SQL** desarrollada por Oracle.

Es un lenguaje de programación procedimental que se integra con SQL para permitir a los desarrolladores crear lógica de aplicación directamente en la base de datos. Mientras que SQL es un lenguaje declarativo para la manipulación de datos (consultas, inserciones, etc.), PL/SQL añade estructuras de control de flujo como **condicionales** (`IF-THEN-ELSE`), **bucles** (`FOR`, `WHILE`) y la capacidad de declarar **variables**.

#### Funcionalidades Clave de este lenguaje :

- **Bloques Anónimos:** Permite escribir código para ser ejecutado una sola vez.
    
- **Procedimientos y Funciones:** Permite encapsular y reutilizar la lógica de negocio en la base de datos, lo que mejora el rendimiento y la seguridad.
    
- **Manejo de Errores:** Incluye un bloque `EXCEPTION` para gestionar y manejar errores de tiempo de ejecución de manera controlada.
    

En resumen, PL/SQL es la herramienta principal para la programación en bases de datos Oracle, utilizada para crear aplicaciones robustas y eficientes al combinar las capacidades de SQL con el poder de un lenguaje procedimental. A continuación veremos las funcionalidades mas usadas.

### Vistas y CTEs :

Las **Vistas** y las **Common Table Expressions (CTEs)** son dos herramientas de PostgreSQL que te permiten organizar y simplificar consultas complejas. Aunque ambas ayudan a mejorar la legibilidad del código, tienen propósitos y comportamientos distintos.

#### Vistas (Views)

Una **Vista** es una consulta SQL guardada como un objeto en la base de datos. Piénsalo como una "tabla virtual" basada en el resultado de una consulta. No almacena datos por sí misma, sino que muestra los datos de las tablas subyacentes cada vez que se consulta.

- **Persistencia:** Una vez que creas una vista, esta persiste en la base de datos hasta que la eliminas (`DROP VIEW`). Puedes consultarla en cualquier momento, desde cualquier sesión o aplicación.
    
- **Reutilización:** Son ideales para consultas que se usan con frecuencia, ya que simplifican el acceso a datos comunes y complejos.
    
- **Seguridad y simplicidad:** Puedes dar permisos de acceso a una vista en lugar de a las tablas originales, controlando qué datos pueden ver los usuarios.
    


#### CTEs (Common Table Expressions)

Una **CTE** es un conjunto de resultados temporal y nombrado que solo existe durante la ejecución de una única sentencia. Se define con la cláusula `WITH`. Es útil para dividir una consulta compleja en partes más pequeñas y legibles.

- **Temporalidad:** Las CTEs solo existen durante la ejecución de la consulta a la que pertenecen. Una vez que la consulta termina, la CTE se descarta.
    
- **Legibilidad:** Permiten organizar lógicamente consultas que de otra manera serían muy largas y difíciles de leer, como aquellas que implican múltiples `JOINs` o subconsultas.
    
- **Recursividad:** Son la herramienta principal para realizar consultas recursivas en PostgreSQL, como recorrer un árbol de empleados o una jerarquía de categorías.
    

En resumen, usa **Vistas** cuando necesitas una consulta persistente y reutilizable a largo plazo. Usa **CTEs** cuando necesitas una consulta temporal para estructurar y simplificar una única y compleja sentencia SQL.

### Ejemplo de Vista (View)

Supongamos que tienes una tabla de `empleados` y quieres crear una "tabla virtual" que muestre solo los empleados del departamento de ventas.

SQL

```sql
CREATE VIEW empleados_ventas AS
SELECT id, nombre, apellido, email
FROM empleados
WHERE departamento = 'Ventas';
```

Ahora puedes consultar la vista como si fuera una tabla normal:

SQL

```sql
SELECT * FROM empleados_ventas;
```

Esta consulta te devolverá solo los empleados del departamento de ventas. La vista `empleados_ventas` se almacena en la base de datos y puedes consultarla en cualquier momento sin tener que reescribir la condición `WHERE`.


### Ejemplo de CTE (Common Table Expression)

Imagina que quieres encontrar el salario promedio de los empleados y, en la misma consulta, listar a los empleados que ganan más que ese promedio.

SQL

```
WITH salario_promedio AS (
    SELECT AVG(salario) AS avg_sal
    FROM empleados
)
SELECT nombre, apellido, salario
FROM empleados, salario_promedio
WHERE empleados.salario > salario_promedio.avg_sal;
```

- La cláusula `WITH` define la CTE llamada `salario_promedio`.
    
- Esta CTE calcula el salario promedio de todos los empleados.
    
- La consulta principal (`SELECT`) utiliza la CTE como si fuera una tabla temporal para comparar el salario de cada empleado con el salario promedio.
    

La CTE `salario_promedio` solo existe durante la ejecución de esta consulta. No se almacena en la base de datos y no puedes usarla en una consulta posterior. Es perfecta para dividir la lógica de una sola consulta compleja.
### Funciones incorporadas :

Son funciones predefinidas en PostgreSQL para ayudarnos a la hora de programar en la Base de datos, para ampliar conocimientos consulta la documentacion de PostgreSQL o el motor de base de datos que utilices :

Operaciones matemáticas :

`ABS(x), ROUND(x,n), POWER(x,y), RANDOM()`

Operaciones con fecha, días, minutos, etc :

`NOW(), CURRENT_DATE, EXTRACT(YEAR FROM fecha), DATE_TRUNC('month', fecha)`

Operaciones con cadenas de caracteres :

`LENGTH(), UPPER(), LOWER(), TRIM(), SUBSTRING(), CONCAT(), REPLACE()`

Funciones JSONB:

```
'{"a":1}'::jsonb->'a'
'{"a":1}'::jsonb->>'a'
```

Utilidades :

`COALESCE(), NULLIF(), GREATEST(), LEAST()`

### Procedimientos y Funciones  almacenados :

#### Funciones ✍️

Una **función** en PostgreSQL está diseñada para **devolver un valor**. Su principal propósito es calcular y retornar un resultado, similar a las funciones en la mayoría de los lenguajes de programación. Las funciones se pueden utilizar en consultas `SELECT`, cláusulas `WHERE`, y otras expresiones SQL.

####  Características:

- **Retornan un valor**: Siempre deben retornar un valor de un tipo de dato específico (o `SETOF` para múltiples valores).
    
- **Transaccionalidad**: Se ejecutan dentro de una transacción. No pueden iniciar o confirmar transacciones por sí mismas.
    
- **Permiten `SELECT`**: Pueden ser llamadas dentro de una sentencia `SELECT`.
    
```
CREATE OR REPLACE FUNCTION sumar(a INT, b INT)
RETURNS INT AS $$
BEGIN
RETURN a+b;
END;
$$ LANGUAGE plpgsql;
```

#### Procedimientos ⚙️

Un **procedimiento** (o **procedimiento almacenado**) se utiliza para ejecutar un conjunto de comandos SQL, a menudo para realizar una serie de operaciones o una tarea. A diferencia de las funciones, los procedimientos no están obligados a devolver un valor. Su principal uso es para operaciones de manipulación de datos (`INSERT`, `UPDATE`, `DELETE`) o para controlar la lógica de la transacción.

### Características:

- **No retornan un valor**: No están diseñados para devolver un valor. En su lugar, pueden tener parámetros `INOUT` o `OUT` para pasar datos.
    
- **Control transaccional**: Pueden ejecutar comandos `COMMIT` y `ROLLBACK` para gestionar transacciones, lo cual es su diferencia más importante con las funciones. Esto les permite manejar transacciones complejas que las funciones no pueden.
    
- **No se usan en `SELECT`**: No pueden ser llamados directamente desde una sentencia `SELECT` como si fueran una columna. Se ejecutan con el comando `CALL`.

```
CREATE OR REPLACE PROCEDURE transferir(
origen INT, destino INT, cantidad NUMERIC
) AS $$
BEGIN
UPDATE cuentas SET saldo=saldo-cantidad WHERE id=origen;
UPDATE cuentas SET saldo=saldo+cantidad WHERE id=destino;
END;
$$ LANGUAGE plpgsql;

CALL transferir(1,2,100);

```
### Excepciones :

La gestión de excepciones en PostgreSQL se implementa utilizando un bloque `BEGIN...END`. La lógica normal del programa se coloca entre `BEGIN` y `EXCEPTION`. Si ocurre un error dentro de este bloque, la ejecución salta a la sección `EXCEPTION`, donde se puede especificar una acción para cada tipo de error. Si no se maneja la excepción, el error se propaga a un nivel superior o detiene la ejecución.

La estructura básica es:

SQL

```
BEGIN
    -- Lógica del programa
EXCEPTION
    WHEN tipo_de_excepcion THEN
        -- Acciones a realizar cuando ocurre el error
    WHEN otro_tipo_de_excepcion THEN
        -- Otras acciones
    WHEN OTHERS THEN
        -- Maneja cualquier otro error no especificado
END;
```

#### Ejemplos 💡

El manejo de excepciones es útil para evitar errores comunes, como la inserción de datos duplicados o la división por cero.

#### Ejemplo 1: Manejo de datos duplicados

Este ejemplo muestra cómo manejar un error de violación de clave única (`unique_violation`) al intentar insertar un usuario que ya existe.

SQL

```
DO $$
BEGIN
    INSERT INTO usuarios (id, nombre) VALUES (1, 'Juan');
    RAISE NOTICE 'Usuario insertado correctamente.';
EXCEPTION
    WHEN unique_violation THEN
        RAISE NOTICE 'Error: El usuario con el ID 1 ya existe.';
END;
$$ LANGUAGE plpgsql;
```

#### Ejemplo 2: Manejo de división por cero

Aquí se maneja un error de división por cero (`division_by_zero`) para evitar que la operación falle.

SQL

```
DO $$
DECLARE
    dividendo INTEGER := 10;
    divisor INTEGER := 0;
    resultado NUMERIC;
BEGIN
    resultado := dividendo / divisor;
    RAISE NOTICE 'El resultado es: %', resultado;
EXCEPTION
    WHEN division_by_zero THEN
        RAISE NOTICE 'Error: No se puede dividir por cero.';
END;
$$ LANGUAGE plpgsql;
```


### Tablas en memoria :

En PostgreSQL, el concepto de "tablas en memoria" no se maneja de forma nativa y explícita como en otros sistemas de bases de datos. No existe un tipo de tabla dedicado llamado "en memoria" que se defina con una sintaxis específica. Sin embargo, se pueden lograr efectos similares al mantener datos en memoria RAM para un acceso más rápido.

El gestor de PostgreSQL carga automáticamente en el **buffer cache** del sistema de memoria principal del servidor los bloques de datos de las tablas y los índices que se utilizan con frecuencia. Esto permite que las consultas futuras a esos datos sean mucho más rápidas, ya que no requieren accesos al disco duro.

#### Implementación y estrategias para optimizar la memoria

Aunque no hay un comando directo para crear una tabla que resida permanentemente en RAM, se pueden usar varias técnicas para asegurar que los datos estén en memoria la mayor parte del tiempo:

- **Ajuste del `shared_buffers`**: El parámetro de configuración `shared_buffers` determina la cantidad de memoria que PostgreSQL destina al caché de datos. Aumentar este valor permite que el sistema mantenga más bloques de tablas e índices en memoria, lo que mejora el rendimiento para cargas de trabajo intensivas en lectura.
    
- **Creación de `unlogged tables`**: Las tablas sin registro (`unlogged tables`) no escriben en el log de transacciones (WAL). Esto las hace mucho más rápidas para operaciones de inserción y actualización, ya que la sobrecarga de escritura en el disco se reduce significativamente. Sin embargo, son **volátiles**; si el servidor se cae, el contenido de estas tablas se pierde. Son ideales para almacenar datos temporales o de trabajo.
    
#### Ventajas y desventajas de las tablas en memoria

#### Ventajas ✅

- **Alto rendimiento**: La lectura de datos es extremadamente rápida, ya que se evitan las latencias del disco duro.
    
- **Velocidad en operaciones**: Las operaciones de inserción, actualización y borrado en `unlogged tables` son notablemente más rápidas.
    

#### Desventajas ❌

- **Volatilidad**: Si el servidor se apaga de forma inesperada, los datos en las `unlogged tables` se perderán.
    
- **Consumo de RAM**: Mantener grandes conjuntos de datos en memoria puede consumir una cantidad significativa de RAM del servidor.
    
- **Escalabilidad**: No es una solución viable para bases de datos muy grandes que superan la capacidad de la memoria del servidor, ya que el sistema operativo podría comenzar a usar el disco de intercambio (swap), lo que anularía el beneficio de velocidad.

```
-- TEMP: solo durante la sesión
CREATE TEMP TABLE tmp_usuarios (
id SERIAL,
nombre TEXT
);
INSERT INTO tmp_usuarios (nombre)
VALUES ('Juan');
-- UNLOGGED: permanentes, sin WAL
CREATE UNLOGGED TABLE IF NOT EXISTS cache (
clave TEXT PRIMARY KEY,
valor JSONB,
creado TIMESTAMPTZ DEFAULT now()
);
```

### Transacciones :

En PostgreSQL, una **transacción** es una secuencia de una o más operaciones de bases de datos que se ejecutan como una única unidad atómica. Esto significa que o bien todas las operaciones dentro de la transacción se completan con éxito (se "confirman"), o si alguna falla, todas las operaciones se deshacen (se "revierten") dejando la base de datos en su estado original. Este comportamiento garantiza la **integridad** y la **consistencia** de los datos.

#### Principio de ACID 🧪

El concepto de transacciones en bases de datos relacionales se basa en el principio **ACID**, un acrónimo que resume las propiedades que garantizan la fiabilidad de las transacciones:

- **Atomicidad (Atomicity)**: La transacción se trata como una unidad indivisible. Todas sus operaciones se ejecutan por completo o ninguna de ellas. No hay estados intermedios.
    
- **Consistencia (Consistency)**: La transacción lleva la base de datos de un estado válido a otro, cumpliendo todas las reglas y restricciones (como las claves foráneas y únicas).
    
- **Aislamiento (Isolation)**: Las transacciones concurrentes se ejecutan de forma independiente unas de otras. Una transacción en progreso no puede ver los cambios no confirmados de otra.
    
- **Durabilidad (Durability)**: Una vez que una transacción ha sido confirmada, sus cambios son permanentes y persisten incluso en caso de fallos del sistema, como un corte de energía.
    


#### Comandos de transacciones ✍️

El flujo de una transacción en PostgreSQL se controla con los siguientes comandos SQL:

- **`BEGIN` o `START TRANSACTION`**: Inicia una nueva transacción.
    
- **`COMMIT`**: Confirma la transacción. Todos los cambios realizados se guardan de forma permanente.
    
- **`ROLLBACK`**: Revierte la transacción. Todos los cambios realizados se deshacen, como si la transacción nunca hubiera ocurrido.
    

#### Ejemplo de uso:

SQL

```
BEGIN; -- Inicia la transacción

INSERT INTO cuentas (id_cuenta, balance) VALUES (1, 100);
INSERT INTO cuentas (id_cuenta, balance) VALUES (2, 50);

-- Si ambas inserciones son exitosas, se confirma la transacción
COMMIT;
```

Si por ejemplo la segunda inserción fallara, se podría usar `ROLLBACK` para deshacer la primera también. Esto garantiza que la base de datos no quede en un estado inconsistente.

```

BEGIN;
UPDATE cuentas
SET saldo=saldo-100
WHERE id=1;
SAVEPOINT s1;
UPDATE cuentas
SET saldo=saldo+100
WHERE id=2;
-- Revertir parcialmente
ROLLBACK TO SAVEPOINT s1;
COMMIT;
-- Cambiar nivel de aislamiento
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;

```

### Cursores :

Un cursor es un objeto en base de datos  que permite tratar fila a fila el resultado de una consulta, debemos declararlo como una variable en un procedimiento y función cómo si  fura un variable mas:

```
....

DECLARE
	-- declaramos el cursos
	r_song RECORD;
	c_song CURSOR FOR
		SELECT xx FROM XX;
BEGIN
	OPEN c_song -- lo inicializa
	
	-- uso del cursor
	
	FETCH c_song INTO r_song; -- guarda la fila siguiente en la variable r_song
	
	
	CLOSE c_song -- lo cerramos
	
END $$;
```

Una vez declarado en el proceso o procedimiento se inicializa con `OPEN nombre_cursor` y se cierra con `CLOSE nombre_cursor`. 

Para acceder a los valores del cursos tenemos  varias formas, pero generalmente se usa el  comando `FETCH`, con fetch capturamos el elemento del cursor , la fila y lo mete en una variable en este caso del ejemplo la llamamos r_song.

> Hasta ahora hemos usado INSERT INTO 
### Índices :

Un **índice** en PostgreSQL es una estructura de datos que mejora la velocidad de las operaciones de recuperación de datos de una tabla. Actúa como un índice de un libro 📖, permitiendo al motor de base de datos encontrar rápidamente filas específicas sin tener que revisar cada una de ellas de forma secuencial.
#### ¿Cómo funcionan? ⚙️

Cuando se crea un índice sobre una o varias columnas, PostgreSQL construye una estructura de datos (generalmente un **árbol B-tree**) que almacena los valores de esas columnas junto con **punteros** a las filas correspondientes en la tabla.

Al ejecutar una consulta `SELECT` con una cláusula `WHERE` sobre una columna indexada, el optimizador de consultas utiliza el índice para localizar la ubicación física de las filas de forma eficiente, lo que reduce drásticamente el tiempo de búsqueda, especialmente en tablas grandes.


#### Tipos de índices más comunes 📊

PostgreSQL soporta varios tipos de índices, cada uno optimizado para diferentes tipos de cargas de trabajo:

- **B-tree**: Es el tipo de índice por defecto y el más común. Es adecuado para la mayoría de los casos de uso, como búsquedas por igualdad (`=`), rangos (`>`, `<`), y coincidencias de prefijos (`LIKE 'A%'`).
    
- **Hash**: Útil para búsquedas de igualdad. Sin embargo, no se recomienda su uso debido a sus limitaciones y a que B-tree ofrece un mejor rendimiento en la mayoría de los casos.
    
- **GiST (Generalized Search Tree)**: Un tipo de índice versátil que se usa para indexar datos complejos como tipos de datos espaciales (geografía), datos de texto (`full-text search`) y datos geométricos.
    
- **SP-GiST (Space-Partitioned GiST)**: Similar a GiST, es ideal para datos que se pueden particionar en el espacio, como árboles de búsqueda y datos geográficos.
    
- **BRIN (Block Range Index)**: Un índice más pequeño y compacto, diseñado para tablas grandes donde los datos están ordenados de forma natural. Indexa rangos de bloques de datos en lugar de filas individuales.
    

#### Creación y uso ✍️

Para crear un índice, se utiliza el comando `CREATE INDEX`.

SQL

```
CREATE INDEX idx_nombre_cliente ON clientes (nombre_cliente);
```

>Es importante no indexar todas las columnas, ya que los índices consumen espacio en disco y ralentizan las operaciones de escritura (`INSERT`, `UPDATE`, `DELETE`) porque la base de datos debe mantener tanto la tabla como el índice actualizados. Los índices deben crearse estratégicamente en las columnas que se usan con frecuencia en las cláusulas `WHERE`, `JOIN` y `ORDER BY`.

### Triggers :

Un **trigger** en PostgreSQL es un objeto de la base de datos que se dispara (o ejecuta) automáticamente en respuesta a un evento específico, como una operación `INSERT`, `UPDATE` o `DELETE` sobre una tabla. Su principal función es automatizar tareas y mantener la integridad de los datos sin la necesidad de que la aplicación cliente ejecute comandos adicionales.

#### ¿Cómo funcionan? ⚙️

Un trigger se compone de dos partes principales:

1. **El evento**: La acción que lo activa. Esto puede ser un `INSERT`, `UPDATE` o `DELETE` que ocurre en una tabla determinada.
    
2. **La función del trigger**: El código (escrito en PL/pgSQL u otro lenguaje) que se ejecuta cuando el evento ocurre.
    

Se puede especificar cuándo debe ejecutarse la función: **antes (`BEFORE`)** o **después (`AFTER`)** del evento. Por ejemplo, un trigger `BEFORE INSERT` puede validar o modificar los datos antes de que se inserten, mientras que un trigger `AFTER INSERT` puede registrar un evento en otra tabla después de que la inserción se haya completado.

#### Usos comunes ✍️

Los triggers son muy útiles para:

- **Auditoría**: Registrar quién, cuándo y qué se modificó en una tabla, guardando esta información en una tabla de `logs`.
    
- **Validación de datos**: Asegurar que los datos que se insertan o actualizan cumplen ciertas reglas de negocio antes de que la operación se complete.
    
- **Mantenimiento de la integridad**: Sincronizar automáticamente datos entre tablas o actualizar campos calculados.
    
- **Automatización de tareas**: Por ejemplo, un trigger puede enviar una notificación por correo electrónico cuando se añade una nueva reserva a una tabla.
    

#### Ejemplo de concepto 💡

Imagina que tienes una tabla de `productos` y una de `inventario`. Podrías crear un trigger `AFTER INSERT` en la tabla de `ventas` que, después de cada nueva venta, actualice automáticamente la cantidad disponible en la tabla de `inventario`. De esta forma, el stock se mantiene siempre actualizado sin que la aplicación tenga que ejecutar una segunda consulta.

Ejemplos  de trigger en función :

```
CREATE OR REPLACE FUNCTION registrar_cambio_salario()
RETURNS TRIGGER AS $$
BEGIN
    -- Solo actuar si el salario realmente ha cambiado
    IF NEW.salario <> OLD.salario THEN
        INSERT INTO log_salarios(empleado_id, salario_antiguo, salario_nuevo, modificado_por, fecha_modificacion)
        VALUES(OLD.id, OLD.salario, NEW.salario, session_user, NOW());
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;
```
Ejercicio de Agencia de viajes Relación :


![[Pasted image 20250912165011.png]]

```
-- Crea tabla de clientes

CREATE TABLE clientes (
    cliente_id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    telefono VARCHAR(50)
);

-- Crea tabla paquetes

CREATE TABLE paquetes (
    paquete_id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    coste_total DECIMAL(10, 2) DEFAULT 0.00
);

-- Creo tabla reservas, que conecta mediante sus FK a la tabla de clientes y paquetes

CREATE TABLE reservas (
    reserva_id SERIAL PRIMARY KEY,
    paquete_id INT NOT NULL,
    cliente_id INT NOT NULL,
    fecha_reserva TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    numero_personas INT NOT NULL,
    FOREIGN KEY (paquete_id) REFERENCES paquetes(paquete_id),
    FOREIGN KEY (cliente_id) REFERENCES clientes(cliente_id)
);

-- Tabla de item_paquete, que sera la padre

CREATE TABLE item_paquete (
    item_id SERIAL PRIMARY KEY,
    paquete_id INT NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    costo DECIMAL(10, 2) NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE,
    orden INT NOT NULL,
    FOREIGN KEY (paquete_id) REFERENCES paquetes(paquete_id),
    CONSTRAINT CHK_tipo CHECK (tipo IN ('vuelo', 'hotel', 'atraccion'))
);

-- Subtablas hijas de item_paquete que heredan sus atributos y añaden los suyos propios de su tipo (tabla vuelo, hotel y atraccion)

CREATE TABLE vuelo (
    origen VARCHAR(100) NOT NULL,
    destino VARCHAR(100) NOT NULL,
    aerolinea VARCHAR(100) NOT NULL,
    hora_salida TIME,
    hora_llegada TIME
) INHERITS (item_paquete);

CREATE TABLE hotel (
    nombre_hotel VARCHAR(255) NOT NULL,
    ciudad VARCHAR(100) NOT NULL,
    numero_noches INT NOT NULL
) INHERITS (item_paquete);

CREATE TABLE atraccion (
    nombre_atraccion VARCHAR(255) NOT NULL,
    ciudad VARCHAR(100) NOT NULL,
    duracion_estimada INTERVAL
) INHERITS (item_paquete);

```

Datos de ejemplo :

```
-- Insertar algunos clientes de ejemplo
INSERT INTO clientes (nombre, apellidos, email, telefono) VALUES
('Juan', 'García', 'juan.garcia@example.com', '600123456'),
('Ana', 'López', 'ana.lopez@example.com', '600987654'),
('Carlos', 'Sánchez', 'carlos.sanchez@example.com', '600112233');


-- Insertar paquetes de ejemplo
INSERT INTO paquetes (nombre, descripcion) VALUES
('Viaje a la Costa de España', 'Un paquete de sol y playa por las mejores costas de España.'),
('Aventura en los Alpes', 'Paquete para los amantes de la montaña y el senderismo.'),
('Cultura en Roma', 'Una escapada para conocer los principales monumentos de la capital italiana.'),
('Crucero por el Caribe', 'Un lujoso crucero de 7 días por las aguas cristalinas del Caribe.');


-- Insertar ítems para el paquete 'Viaje a la Costa de España' (paquete_id 1)
INSERT INTO vuelo (paquete_id, tipo, costo, fecha_inicio, fecha_fin, orden, origen, destino, aerolinea, hora_salida, hora_llegada) VALUES
(1, 'vuelo', 150.00, '2023-08-10', '2023-08-10', 1, 'Madrid', 'Málaga', 'Iberia', '08:00:00', '09:00:00');

INSERT INTO hotel (paquete_id, tipo, costo, fecha_inicio, fecha_fin, orden, nombre_hotel, ciudad, numero_noches) VALUES
(1, 'hotel', 200.00, '2023-08-10', '2023-08-13', 2, 'Hotel Sol y Mar', 'Málaga', 3);

INSERT INTO atraccion (paquete_id, tipo, costo, fecha_inicio, orden, nombre_atraccion, ciudad, duracion_estimada) VALUES
(1, 'atraccion', 25.00, '2023-08-11', 3, 'Visita a la Alcazaba', 'Málaga', '2 hours');

-- Insertar ítems para el paquete 'Cultura en Roma' (paquete_id 3)
INSERT INTO vuelo (paquete_id, tipo, costo, fecha_inicio, fecha_fin, orden, origen, destino, aerolinea, hora_salida, hora_llegada) VALUES
(3, 'vuelo', 250.00, '2023-10-05', '2023-10-05', 1, 'Barcelona', 'Roma', 'Vueling', '14:00:00', '16:00:00');

INSERT INTO hotel (paquete_id, tipo, costo, fecha_inicio, fecha_fin, orden, nombre_hotel, ciudad, numero_noches) VALUES
(3, 'hotel', 300.00, '2023-10-05', '2023-10-08', 2, 'Hotel Plaza del Coliseo', 'Roma', 3);

INSERT INTO atraccion (paquete_id, tipo, costo, fecha_inicio, orden, nombre_atraccion, ciudad, duracion_estimada) VALUES
(3, 'atraccion', 40.00, '2023-10-06', 3, 'Entrada al Coliseo', 'Roma', '3 hours'),
(3, 'atraccion', 30.00, '2023-10-07', 4, 'Visita guiada al Vaticano', 'Roma', '4 hours');


-- Insertar reservas de ejemplo
INSERT INTO reservas (paquete_id, cliente_id, numero_personas) VALUES
(1, 1, 2), -- Juan García reserva 'Viaje a la Costa de España'
(3, 2, 1), -- Ana López reserva 'Cultura en Roma'
(1, 3, 4); -- Carlos Sánchez reserva 'Viaje a la Costa de España'
```

Asi seria para duplicar o crear paquete :

```
-- PROCEDURE: public.crear_o_duplicar_paquete(character varying, text, integer)

-- DROP PROCEDURE IF EXISTS public.crear_o_duplicar_paquete(character varying, text, integer);

CREATE OR REPLACE PROCEDURE public.crear_o_duplicar_paquete(
	-- No se porque pero tras pelearme este OUT solo se puede poner al principio en vez del final de los parametros de procedimiento
	-- se pone a NULL y luego al final del proceso se envia valor
	OUT nuevo_paquete_id integer,
	-- Variables o parametros de entrada
	IN nombre_nuevo_paquete character varying,
	IN descripcion_paquete text,
	IN paquete_base_id integer DEFAULT NULL::integer)
LANGUAGE 'plpgsql'
AS $$
DECLARE
    id_creado INT;
    item_record RECORD;
BEGIN
    -- Caso 1: Duplicar un paquete existente
    IF paquete_base_id IS NOT NULL THEN
        -- Insertar el nuevo paquete con los datos del paquete base
        INSERT INTO paquetes (nombre, descripcion, coste_total)
        SELECT 
            nombre_nuevo_paquete,
            descripcion_paquete,
            coste_total
        FROM paquetes
        WHERE paquete_id = paquete_base_id
        RETURNING paquete_id INTO id_creado;

        -- Duplicar todos los ítems del paquete base
        FOR item_record IN
            SELECT
				-- Atributos de paquete base (item_paquete base)
                tipo, costo, fecha_inicio, fecha_fin, orden,
                -- Atributos específicos de tipo de items
                origen, destino, aerolinea, hora_salida, hora_llegada,
                nombre_hotel, ciudad, numero_noches,
                nombre_atraccion, duracion_estimada
            FROM item_paquete
            WHERE paquete_id = paquete_base_id
        LOOP
            CASE item_record.tipo
                WHEN 'vuelo' THEN
                    INSERT INTO vuelo (paquete_id, tipo, costo, fecha_inicio, fecha_fin, orden, origen, destino, aerolinea, hora_salida, hora_llegada)
                    VALUES (id_creado, 'vuelo', item_record.costo, item_record.fecha_inicio, item_record.fecha_fin, item_record.orden, item_record.origen, item_record.destino, item_record.aerolinea, item_record.hora_salida, item_record.hora_llegada);
                WHEN 'hotel' THEN
                    INSERT INTO hotel (paquete_id, tipo, costo, fecha_inicio, fecha_fin, orden, nombre_hotel, ciudad, numero_noches)
                    VALUES (id_creado, 'hotel', item_record.costo, item_record.fecha_inicio, item_record.fecha_fin, item_record.orden, item_record.nombre_hotel, item_record.ciudad, item_record.numero_noches);
                WHEN 'atraccion' THEN
                    INSERT INTO atraccion (paquete_id, tipo, costo, fecha_inicio, fecha_fin, orden, nombre_atraccion, ciudad, duracion_estimada)
                    VALUES (id_creado, 'atraccion', item_record.costo, item_record.fecha_inicio, item_record.fecha_fin, item_record.orden, item_record.nombre_atraccion, item_record.ciudad, item_record.duracion_estimada);
            END CASE;
        END LOOP;

    -- Caso 2: Crear un paquete completamente nuevo
    ELSE
        INSERT INTO paquetes (nombre, descripcion)
        VALUES (nombre_nuevo_paquete, descripcion_paquete)
        RETURNING paquete_id INTO id_creado;

    END IF;

    -- Asignar el ID del nuevo paquete a la variable de salida OUT del procedimiento
    nuevo_paquete_id := id_creado;
END;
$$;

```

![[Pasted image 20250915103456.png]]

