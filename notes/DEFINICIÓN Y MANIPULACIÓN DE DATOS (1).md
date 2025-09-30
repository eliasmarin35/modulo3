## 1. Instalación PostgreSQL v.17.x :

En este caso instalamos PostgreSQL para trabajar con base de datos, dejamos el puerto y usuario por defecto postgres que es el supe usuario, clave 1234.

Comprobamos que en 'Sistema' se ejecuta en segundo plano la base de datos, con nombre `postgress+version`. En algunos casos debemos configurar las variables de entorno en el panel de control o en consola `cmd`.

`psql -U postgres -h localhost` -> Inicia consola PostgreSQL en consola, situándonos en carpeta  `bin` del directorio de instalación.

`\l` ->  listado en consola de postgres.
`\d + nombre_tabla` -> mostrar estructura de la tabla en postgres.

## 2. Ejercicios y ejemplos SQL:

Para crear la tabla de primer ejercicio:
```sql

-- Database: videoclub

-- DROP DATABASE IF EXISTS videoclub;

CREATE DATABASE videoclub
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Spain.1252'
    LC_CTYPE = 'Spanish_Spain.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

COMMENT ON DATABASE videoclub
    IS 'Base de datos de ejercicio de E-R a Relacional, primer ejercicio de videoblub';
```    
Para agilizar y poder crear tablas, creamos un esquema vc para escribir menos en un futuro y que PostgreSQL nos deja crear tablas. Para crear esquema de vc :

```sql
-- SCHEMA: vc

-- DROP SCHEMA IF EXISTS vc ;

CREATE SCHEMA IF NOT EXISTS vc
    AUTHORIZATION postgres;

COMMENT ON SCHEMA vc
    IS 'esquema de videoclub con vc';
```

Los esquemas son un espacio de nombre que contienen objetos de base de datos como tablas, vistas, índices, funciones , etc. Una vez creado el esquema (schema) podemos crear las tablas y asi podemos hacer referencia en SQL con la sintaxis:

`nombre_esquema.tabla`

Creamos la tabla de prueba :

```sql
-- Table: vc.pruebas

-- DROP TABLE IF EXISTS vc.pruebas;

CREATE TABLE IF NOT EXISTS vc.pruebas
(
    col1 numeric(10,0) NOT NULL,
    nombre character(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pruebas_pkey PRIMARY KEY (col1),
    CONSTRAINT "nombre unico" UNIQUE (nombre)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS vc.pruebas
    OWNER to postgres;

COMMENT ON TABLE vc.pruebas
    IS 'tabla de pruebas';
```


>Esta tabla es de prueba, luego crearemos la tablas del ejercicio correspondiente para la base de datos de videoclub.


A continuación vamos a crear una tabla del ejercicio de E-R a Relacional del videoclub con PostgreSQL, copio los scripts para crear cada tabla en un esquema llamado `vc`.

Tabla de películas de nuestro videoclub:

```
CREATE TABLE IF NOT EXISTS vc.peliculas
	(
	cpeliculas NUMERIC(10,0),
	titulo VARCHAR(150) NOT NULL,
	genero VARCHAR(25) NOT NULL,
	duracion SMALLINT NOT NULL,
	anno NUMERIC(4,0) NOT NULL,
	
	-- Añadimos las constraints
	
	CONSTRAINT peliculas_pk PRIMARY KEY(cpeliculas),
	CONSTRAINT titulo_uq UNIQUE(titulo),
	CONSTRAINT genero_ck CHECK (genero IN ('Drama', 'Comedia', 'Accion', 'Terror', 'Indefinido')),
	CONSTRAINT duracion_ck CHECK (duracion < 0 AND duracion < 300),
	CONSTRAINT anno_ck CHECK (anno >= 1895)
	);
```
Tabla de protagonistas:

```
CREATE TABLE IF NOT EXISTS vc.protagonistas
	(
		prota VARCHAR(150) NOT NULL,
		nacionalidad varchar(50) NOT NULL,
		cprotagonistas SMALLSERIAL,
		
		
		CONSTRAINT cprotagoniastas_pk PRIMARY KEY(cprotagonistas),
		CONSTRAINT nacionalidad_ck CHECK(nacionalidad IN ('España','Rusia','America'))
	);
```

Tabla de Películas-Protagonistas para suplir la relación N-N que no contempla SQL en una 1:N:

```
CREATE TABLE IF NOT EXISTS vc.peliprota
	(
		cpelicula NUMERIC(10,0),
		cprotagonistas SMALLINT,

		CONSTRAINT peliprota_pk PRIMARY KEY(cprotagonistas, cpelicula),
		CONSTRAINT peliprota_pelicula_fk FOREIGN KEY(cpelicula) REFERENCES vc.peliculas(cpeliculas) ON DELETE CASCADE ON UPDATE CASCADE,
		CONSTRAINT peliprota_protagoniastas_fk FOREIGN KEY (cprotagonistas) REFERENCES vc.protagonistas(cprotagonistas) ON DELETE RESTRICT ON UPDATE CASCADE
	);

```

Tabla de socios :

```
CREATE  TABLE IF NOT EXISTS vc.socios
	(
		dni CHARACTER(9),
		nombresocio VARCHAR(30) NOT NULL,
		telefono CHARACTER(9) NOT NULL,
		email VARCHAR(20) NOT NULL,
		direccion VARCHAR(30) NOT NULL,
		fnac DATE,
		dni_avalista CHARACTER(9) NOT NULL,

		CONSTRAINT dni_pk PRIMARY KEY(dni),
		CONSTRAINT email_uq UNIQUE(email),
		CONSTRAINT dni_avalista_fk FOREIGN KEY (dni_avalista) REFERENCES vc.socios(dni)
	);
```

Tabla de multas (atributo multievaluado):

```
CREATE TABLE IF NOT EXISTS vc.multas
	(
		idmulta SERIAL,
		dnisocio CHARACTER(9) NOT NULL,
		descripcion VARCHAR(60) NOT NULL,
		importe DECIMAL(3,2),

		CONSTRAINT idmulta_pk PRIMARY KEY(idmulta),
		CONSTRAINT dnisocio_fk FOREIGN KEY(dnisocio) REFERENCES vc.socios(dni)
	);
```

Tabla de copias :

```
CREATE TABLE IF NOT EXISTS vc.copias
	(
		ncopia SMALLSERIAL,
		conservacion CHAR NOT NULL,
		alquilada BOOL,
		cpelicula NUMERIC(10,0) NOT NULL,

		CONSTRAINT ncopia_pk PRIMARY KEY(ncopia),
		CONSTRAINT conservacion_ck CHECK(conservacion IN('B','R','M')),
		CONSTRAINT cpeliculas_fk FOREIGN KEY(cpelicula) REFERENCES vc.peliculas(cpeliculas)
	);
```

Tabla de alquileres :

```
CREATE TABLE IF NOT EXISTS vc.alquila
	(
		ncopia SMALLINT,
		falq DATE,
		fdev DATE,
		dnisocio CHARACTER(9) NOT NULL,

		CONSTRAINT ncopia_alquila_pk PRIMARY KEY(ncopia,falq,dnisocio),
		CONSTRAINT ncopia_fk FOREIGN KEY(ncopia) REFERENCES vc.copias(ncopia) ON DELETE CASCADE ON UPDATE CASCADE,
		CONSTRAINT dnisocio_fk FOREIGN KEY(dnisocio) REFERENCES vc.socios(dni) ON DELETE CASCADE ON UPDATE CASCADE
		
	);
```
#### Creamos una base de datos Adventure Works para poder hacer practicas con la sentencia SELECT:

- Ejemplo básico de SELECT :

```
SELECT * FROM production.product;
```

- Ejemplos consultas SELECT del 06/08/2025 :

```

SELECT	* 
FROM	production.product;

SELECT	productid, name, productnumber
FROM	production.product;


SELECT	productid AS "Clave prod", name, productnumber
FROM	production.product;

SELECT 	productid AS "Clave", listprice AS "Precio", listprice * .20 AS "Descuento"
FROM 	production.product;

SELECT 	productid AS "Clave", listprice AS "Precio", listprice * .20 AS "Descuento"
FROM 	production.product
ORDER BY	"Precio";

SELECT 	productid AS "Clave", listprice AS "Precio", listprice * .20 AS "Descuento"
FROM 	production.product
ORDER BY	listprice;

SELECT 	productid AS "Clave", listprice AS "Precio", listprice * .20 AS "Descuento"
FROM 	production.product
ORDER BY	size;

SELECT 	productid AS "Clave", listprice AS "Precio", listprice * .20 AS "Descuento"
FROM 	production.product
ORDER BY	listprice, "Clave";

SELECT 	productid AS "Clave", listprice AS "Precio", listprice * .20 AS "Descuento"
FROM 	production.product
ORDER BY	listprice ASC, "Clave" DESC;

SELECT 	productid AS "Clave", listprice AS "Precio", listprice * .20 AS "Descuento"
FROM 	production.product
ORDER BY	2 ASC, 1 DESC;


SELECT productid AS "Clave", listprice AS "Precio", listprice * .20 AS "Descuento"
FROM 	production.product
LIMIT 15;


/* 
Nombres de los 15 productos mas caros ordenados de mayor a menor precio
*/

SELECT		name 			AS 	"Producto",
			listprice		AS	"Precio"
FROM		production.product
ORDER BY	LISTPRICE DESC, name ASC
LIMIT 		15


/* 
Nombres de los 15 productos mas baratos ordenados de menor a mayor precio
*/

SELECT		name 			AS 	"Producto",
			listprice		AS	"Precio"
FROM		production.product
ORDER BY	LISTPRICE ASC, name ASC
LIMIT 		15


/* 
Nombres de los 15 productos mas baratos ordenados de menor a mayor precio que no
sean de precio 0
*/

SELECT		name 			AS 	"Producto",
			listprice		AS	"Precio"
FROM		production.product
WHERE		"Precio" > 0
ORDER BY	LISTPRICE ASC, name ASC
LIMIT 		15

SELECT		name 			AS 	"Producto",
			listprice		AS	"Precio"
FROM		production.product
WHERE		listprice > 0
ORDER BY	LISTPRICE ASC, name ASC
LIMIT 		15
```

-  Ejemplos SELECT del día 07/08/2025 :

```
/* Identifica las 50 lineas de pedido de mayor importe teniendo en cuenta el descuento de las líneas cuyo precio 
unitario esta entre 25 y 50 EUROS */

SELECT salesorderid AS "Pedido",
salesorderdetailid AS "Linea",
unitprice * (1 - unitpricediscount) * orderqty AS "Importe"

FROM sales.salesorderdetail

WHERE unitprice >=25 AND unitprice <=50 
ORDER BY "Importe" DESC, "Pedido" ASC, "Linea" ASC 
LIMIT 50;


/* Codigo de peldidos y la revision de los epdidos en status = 4 o sea ENTREGADOS con el
total del pedido, vienod ademas la fecha de pedido y la fecha de envio
cuyo importe sea mayor de 5000 Euros */

SELECT purchaseorderid AS "Codigo",
	   revisionnumber "Numero revision",
	   orderdate AS "Fecha Pedido",
	   shipdate AS "Orden envio",
	   subtotal + taxamt + freight AS "Importe total"

FROM purchasing.purchaseorderheader

WHERE status = 4 AND subtotal + taxamt + freight > 5000

ORDER BY "Importe total", "Codigo";


/* Quiero una tabla para evaluar a mis proveedores que de un listado en el que aparezca el id de proveedor(vendor),
y los dias tardados en enviarme mi pedido */

SELECT vendorid AS "Numero de proveedor",
	   orderdate - shipdate AS "Dias difencia"

FROM purchasing.purchaseorderdetail

ORDER BY vendorid;
/* Lo mismo que antes pero con DISTINT para diferencia de valores en esta caso fechas en dias */
SELECT DISTINCT shipdate - orderdate AS "Plazo"
FROM purchasing.purchaseorderheader
ORDER BY "Plazo"

/* AÑADIR LO QUE FALTA DE IRME AL VETERINARIO */

/*Direccion de correo de las personas que son del tipo IN */


```

- Ejemplos SELECT + JOIN  (07/08/2025) :

```
*

JOINS clientes y datos personales

*/

  
  

SELECT  cli.personid,

        cli.customerid          AS "Cod. Cliente",

        per.businessentityid,

        per.title               AS "Saludo",

        per.firstname           AS "Nombre",

        per.middlename          AS "Inicial",

        per.lastname            AS "Apellido",

        cli.modifieddate        AS "Fec. Modificación"

FROM    sales.customer          AS  cli

            INNER JOIN

        person.person           AS  per ON cli.personid = per.businessentityid

  

ORDER BY "Nombre" ASC, "Apellido" ASC

  
  
  
  

/*

Listado de nombre y dirección de correo electronico de las prsonas que sean del tipo IN

*/

  
  

SELECT  per.title,

        per.firstname,

        per.lastname,

        eml.emailaddress

FROM    person.person           AS per

            INNER JOIN

        person.emailaddress     AS eml  ON per.businessentityid = eml.businessentityid

  

WHERE   per.persontype = 'IN'

  

ORDER BY per.firstname, per.lastname, eml.emailaddress

  
  
  
  

/*

obtener un listado de lon nombres de las categorías y los nombres de las subcategorías.

  

1 Identificar las tablas involucradas

  

2 Indetificar tabla padre y tabla hija

  

3 montar el join

  

        FROM    tblpadre    AS alias_pad

                    inner join

                tblhija     as alias_hij on alias_pad.pk_tblpadre = alias_hij.fk_tblhija

  

 tblpadre = production.productcategory              pk =  productcategoryid

 tblhija  = production.productsubcategory           fk = productcategoryid

*/

  

SELECT  cat.name    AS "Categoría",

        sub.name    AS "Subcategoría"

  

FROM    production.productcategory          AS cat

            INNER JOIN

        production.productsubcategory       AS sub  ON  cat.productcategoryid =

                                                        sub.productcategoryid

  

ORDER BY "Categoría", "Subcategoría"
```

- Ejemplos SELECT + JOIN  (08/08/2025):

```
/* Lista nombre subcategoria y nombre de los productos de esta */

SELECT sub.name AS "Categoria", prd.name "Producto"

FROM production.productsubcategory AS sub
	INNER JOIN
	production.product AS prd ON sub.productcategoryid = prd.productsubcategoryid

ORDER BY "Producto", "Categoria";


/* Muestra loginid, jobtittle empleado y codigo departamento actual */

SELECT emp.jobtitle AS "Empleo", emp.loginid "log", his.departmentid AS "Numero departamento"

FROM humanresources.employee AS emp
	INNER JOIN
	humanresources.employeedepartmenthistory AS his ON emp.businessentityid = his.businessentityid

WHERE his.enddate IS NULL

ORDER BY "Empleo", "Numero departamento", "log";


/* Listar los Id de los productos en inventario con el nombre de la ubicacion (almacen)
 em ña qie estam almacenaadas */



 SELECT alm."name", inv.productid, inv.quantity


FROM production."location" AS alm
	INNER JOIN
    production.productinventory AS inv ON alm.locationid = inv.locationid

ORDER BY 1, 2;

/* JOIN de 3 TABLAS

(tbl1 join tbl2) join tbl3
*/

/* Categorias, Subcategorias y Productos */
/* (cat join subcategria) join productos */


SELECT cat."name" AS "Categoria",
	   sub."name" AS Subcategoria,
	   prd."name" "Producto"

FROM production.productcategory AS cat
	INNER JOIN
	production.productsubcategory AS sub ON cat.productcategoryid = sub.productcategoryid
	INNER JOIN
	production.product AS prd ON sub.productsubcategoryid = prd.productsubcategoryid

ORDER BY 1,2,3;

/* Clientes pedidos lineas de pedidos customers orders lineas  (creo que es la solucion del profe preguntar si es asi o no */ 

SELECT	cli.customerid,ped.salesorderid,lin.productid, lin.orderqty
FROM	sales.customer				AS	cli
			INNER JOIN
		sales.salesorderheader		AS	ped		ON 	cli.customerid =
													ped.customerid
			INNER JOIN
		sales.salesorderdetail		AS	lin		ON ped.salesorderid = lin.salesorderid
ORDER BY 1,2,3

```

 - Ejercicios SELECT y JOIN y entramos en OUTER JOIN  (externos) (25/08/2025) :
 
```
 /* Repaso tras Vacaciones */

/*  REPASO
Nombre categoría, subcategoría , producto */



SELECT 	*
FROM	production.productcategory		AS c
			INNER JOIN
		production.productsubcategory	AS s	ON c.productcategoryid = s.productcategoryid
			INNER JOIN
		production.product				AS p 	ON s.productsubcategoryid = p.productsubcategoryid
ORDER BY c.productcategoryid, s.productsubcategoryid, p.productid




/* OUTER JOIN 
jOINS EXTERNOS, SACANFILAS DE LAS TABLAS AUNQUE NO TENGAN CORRESPONDENCIA 

CLIENTES Y NUMERO DE PEDIDO DE LOS CLIENTES INCLUYENDO LOS QUE NO ME HAN COMPRADO*/



SELECT		*
FROM		sales.customer				AS c
				LEFT OUTER JOIN  --INNER JOIN
			sales.salesorderheader		AS p	ON c.customerid = p.customerid
WHERE		p.salesorderid IS NULL
ORDER BY 	c.customerid

SELECT		*
FROM		sales.customer				AS c
				RIGHT OUTER JOIN  --INNER JOIN
			sales.salesorderheader		AS p	ON c.customerid = p.customerid
WHERE		c.customerid IS NULL
ORDER BY 	c.customerid

/* Para hacer un buen join, la receta es:

	1º Identificar las tablas que van a intervenir.
	2º Identificar tabla padre y tabla hija.
	3º Determinar el tipo de join (INNER, LEFT OUTER, RIGHT OUTER)
	4º Escribir el join
		FROM tabla_padre AS alias_padre
				{INNER | LEFT OUTER | RIGHT OUTER} JOIN
			 Tabla_hija  AS alias_hija ON alias_padre.pk_tabla_padre = 
			 							  alias_hija.fk_tabla_hija
	6º aplicar where si es necesario
	7º apliacr order BY
*/

/* Nombres de los productos que no se han vendedido 
	1. production.product  y sales.salesorderdetail
	2. padre - > production.product  hija->sales.salesorderdetail
	3. tipo -> LEFT OUTER JOIN */


SELECT 		p."name"	AS "Producto"
FROM		production.product			AS p
				LEFT OUTER JOIN
			sales.salesorderdetail		AS l ON p.productid = l.productid
WHERE		l.salesorderdetailid IS NULL
ORDER BY 	P.NAME


/* Nombre de las subcategorías, que no tengan asignodos productos

Para hacer un buen join, la receta es:

	1º Identificar las tablas que van a intervenir.
	2º Identificar tabla padre y tabla hija.
	3º Determinar el tipo de join (INNER, LEFT OUTER, RIGHT OUTER)
	4º Escribir el join
		FROM tabla_padre AS alias_padre
				{INNER | LEFT OUTER | RIGHT OUTER} JOIN
			 Tabla_hija  AS alias_hija ON alias_padre.pk_tabla_padre = 
			 							  alias_hija.fk_tabla_hija
	6º aplicar where si es necesario
	7º apliacr order BY
*/


SELECT		s."name", p.productid
FROM		production.productsubcategory	AS s
				LEFT OUTER JOIN
			production.product				AS p 	ON s.productsubcategoryid = p.productsubcategoryid
WHERE 		p.productid	IS NULL


/* Producto que no tiene asignada un subcategoría  */

SELECT		p."name", p.productid
FROM		production.productsubcategory	AS s
				RIGHT OUTER JOIN
			production.product				AS p 	ON s.productsubcategoryid = p.productsubcategoryid
WHERE 		s.productsubcategoryid	IS NULL



/* nombre subcategorías que no tienen ventas 

	1º Identificar las tablas que van a intervenir.
		production.productsubcategory
		sales.salesorderdetail
		Production.product
		
	2º Identificar tabla abuala, padre y tabla hija.
		production.productsubcategory --< Production.product --< sales.salesorderdetail
		                             left                    left
	3º Determinar el tipo de join (INNER, LEFT OUTER, RIGHT OUTER)
		   
	4º Escribir el join
		FROM tabla_padre AS alias_padre
				{INNER | LEFT OUTER | RIGHT OUTER} JOIN
			 Tabla_hija  AS alias_hija ON alias_padre.pk_tabla_padre = 
			 							  alias_hija.fk_tabla_hija
	6º aplicar where si es necesario
	7º apliacr order BY*/


SELECT		s."name"							AS "Subcategoría",
			p."name"							AS "Producto",
			d.salesorderdetailid				AS "Línea",
			d.orderqty							AS "Cantidad",
			d.unitprice							AS "Precio"
FROM		production.productsubcategory		AS s
				LEFT OUTER JOIN
		 	production.product 					AS p ON s.productsubcategoryid =
			 											p.productsubcategoryid
				LEFT OUTER JOIN
			sales.salesorderdetail				AS d ON p.productid = 
														d.productid
WHERE d.salesorderdetailid IS NULL	AND
	  p.productid IS NULL
ORDER BY 	1, 2, 3


/* 	Salespersonid que no han gestionado ningún pedido 

	1º Identificar las tablas que van a intervenir.
		sales.salesorderheader
		sales.salesperson
	2º Identificar tabla padre y tabla hija.
		sales.salesperson -----< sales.salesorderheader		
	3º Determinar el tipo de join (INNER, LEFT OUTER, RIGHT OUTER)  
		LEFT OUTER JOIN
*/

SELECT 	sp.businessentityid			AS "Persona"
FROM	sales.salesperson			AS sp
			LEFT OUTER JOIN
		sales.salesorderheader		AS sh ON sp.businessentityid = sh.salespersonid
WHERE	sh.salesorderid IS NULL

```

Normalmente si esta la base de datos bien hecha solo usaremos LEFT OUTER JOIN en vez de RIGHT OUTER JOIN, porque solemos leer de izquierda a derecha y este ultimo se usará para buscar errores o campos sin asignar o relacionados.

Con JOIN externos o OUTER JOIN mostraremos los datos que coincida y que no de una tabla, normalmente la tabla padre si usamos LEFT OUTER JOIN, por ejemplo una consulta que nos muestre los `salespersons` que tengas o no ventas.

Es importante a la hora de hacer JOIN seguir estas reglas :

1. Identificar las tablas que van a intervenir.
2. Identificar tabla padre y tabla hija.
3. Determinar el tipo de JOIN (INNER, LEFT OUTER, RIGHT OUTER).

Ejercicios y ejemplos del día 26/08/25 :

```
SELECT 	sp.businessentityid			AS "Persona",
		sh.salesorderid				AS "Pedido"
FROM	sales.salesperson			AS sp
			LEFT OUTER JOIN
		sales.salesorderheader		AS sh ON sp.businessentityid = sh.salespersonid
		
WHERE	sh.salesorderid IS NULL


/*

Numero de pedids salesorderid de los pedidos que no han sido gestionados por nadie 
Seria como el anterior pero con un RIGHT para ver coincidencias de tabla hija cambiando la condicion de where la relacion es igual

*/

SELECT 	sp.businessentityid			AS "Persona",
		sh.salesorderid				AS "Pedido"
FROM	sales.salesperson			AS sp
			RIGHT OUTER JOIN
		sales.salesorderheader		AS sh ON sp.businessentityid = sh.salespersonid
		
WHERE	sp.businessentityid IS NULL;

/* Evaluar el estado de la relacion entre categorias y subcategorias 

1 Categirua sin subcategoria
2 Subcategirua sin categoria.
*/

/* la parte 1*/

SELECT cat."name" AS "Categoria",
	   sub."name" AS "Subcategoria"

FROM production.productcategory AS cat

		LEFT OUTER JOIN

	production.productsubcategory AS sub ON  cat.productcategoryid = sub.productcategoryid

WHERE sub.productsubcategoryid IS NULL

/* la 2 parte */

SELECT cat."name" AS "Categoria",
	   sub."name" AS "Subcategoria"

FROM production.productcategory AS cat

		RIGHT OUTER JOIN

	production.productsubcategory AS sub ON  cat.productcategoryid = sub.productcategoryid

WHERE cat.productcategoryid IS NULL

/* con una unica consulta */

SELECT cat."name" AS "Categoria",
	   sub."name" AS "Subcategoria"

FROM production.productcategory AS cat

		FULL OUTER JOIN

	production.productsubcategory AS sub ON  cat.productcategoryid = sub.productcategoryid

WHERE sub.productsubcategoryid IS NULL OR cat.productcategoryid IS NULL

```

Existe el CROSS JOIN pero no se usa ya que mezcla tablas sin sentido y sin usar ON tengan o no relación alguna, desaconsejable totalmente salvo para test de rendimiento en la BBDD. Son un producto cartesiano de las dos tablas.


Los AGRUPAMIENTOS son una forma de ver la información mediante funciones de agrupamiento que reciben una lista de valores y devuelve un único valor sacado de esta lista.

Las funciones de agrupamientos son :
- COUNT()
- SUM()
- MIN()
- AVG() es la media aritmética
- MAX()

> Todas las funciones de agregación se salta los nulos.


Hay muchas mas puedes consultas las funciones útiles de PostgreSQL en :

[PostgreSQL: Documentation: 17: 9.3. Mathematical Functions and Operators](https://www.postgresql.org/docs/current/functions-math.html)

Ejemplos clases Agrupamientos  26/08/25 :

```
/* SUM */
SELECT SUM(l.orderqty * l.unitprice) AS "Ventas"

FROM sales.salesorderdetail AS l

/* AVG */

SELECT AVG(l.orderqty * l.unitprice) AS "Media"

FROM sales.salesorderdetail AS l
```

Siempre que haya agrupamientos en SELECT debe haber 2 tipos de columnas :

- las columnas afectadas por orden de agrupamientos.
- las columnas que están en GROUP BY.

```
/* usando la clausula ORDER BY*/
/*10  Productos mas vendidos ordenados de forma descendente*/

SELECT l.productid AS "Codigo Producto",
	   ROUND(SUM(l.orderqty * l.unitprice), 2) AS "Ventas"

FROM sales.salesorderdetail AS l

GROUP BY l.productid

ORDER BY "Ventas" DESC

LIMIT 10;


/* Importe de ventas por año - usaremos una funcion de la web que nos paso EXTRACT(YEAR FROM ..) */

--SELECT date_part('year', orderdate), orderdate from sales.salesorderheader


--- agrupamos: SUM(h.totaldue)
--- Agrupo por:  DATE_PART('year', orderdate)

SELECT ROUND(SUM(h.totaldue), 2) AS "Total",
	   DATE_PART('year', orderdate) AS "Año"

FROM sales.salesorderheader AS h

GROUP BY h.orderdate

ORDER BY "Año"

/* Quiero saber los empleados de mi empresa ordenador por sexo  */
--- porque voy a agrupar? gender
--- que agrupo? COUNT(businessentityid)

SELECT gender AS "Sexo",
	   COUNT(businessentityid) AS "Numero"
	   

FROM humanresources.employee

GROUP BY gender

ORDER BY "Sexo";

/* Tiempo medio de fabricación por código de subcategoria */

SELECT		productsubcategoryid		  		AS "Cod. Sub.",
			ROUND(AVG(daystomanufacture),1)		AS "Tiempo Med."
FROM		production.product
WHERE		productsubcategoryid IS NOT NULL
GROUP BY	productsubcategoryid
ORDER BY	productsubcategoryid


/* Tiempo medio de fabricación por nombre de la subcategoria */

-- PASO 1º EL join
SELECT 	s."name"				AS "Subcategoría",
		p.daystomanufacture		AS "Plazo"
FROM	production.productsubcategory	AS s
			INNER JOIN
		production.product				AS p	ON s.productsubcategoryid = p.productsubcategoryid

--PASO 2º La agrupación

SELECT 		s."name"								AS "Subcategoría",
			ROUND(AVG(p.daystomanufacture),1)		AS "Plazo"
FROM		production.productsubcategory	AS s
				INNER JOIN
			production.product				AS p	ON s.productsubcategoryid = p.productsubcategoryid
GROUP BY	s."name"
ORDER BY	s."name";


/* suma de importe de los pedido por salesterritory name */

SELECT		t."name"					AS "Territorio",
			ROUND(SUM(h.totaldue),2)    AS "Importe"
FROM		sales.salesterritory		AS t
				INNER JOIN 
			sales.salesorderheader		AS h	ON t.territoryid = h.territoryid
GROUP BY	t."name"
ORDER BY	t."name"

```

Podemos agrupar por mas de un criterio, hoy probaremos estos ejemplos para conocerlos, y también tenemos la opción de filtrado de grupos. 

- Ejemplos de día 27/08/2025 :

```
/* Numero de importe de pedidos por Salesreason (motivo de venta) */
/*
salesorderheader
salesreason
salesorderheadersalesreason

COUNT de pedido
*/

SELECT sr."name" AS "Razon",
	   COUNT(shr.salesreasonid) AS "Numero Pedidos"
FROM sales.salesreason AS sr
		-- si queremos ver los que no tiene cantidadLEFT OUTER JOIN
		INNER JOIN
	 sales.salesorderheadersalesreason AS shr ON sr.salesreasonid = shr.salesreasonid

GROUP BY sr.name
ORDER BY "Numero Pedidos" DESC;

/* AGRUPAMIENTOS POR MAS DE UNA COLUMNA */
/* Ventas agrupadas por año y mes */

SELECT DATE_PART('year',ord.orderdate) AS "Año",
	   DATE_PART('month',ord.orderdate) AS "Mes",
	   ROUND(SUM(ord.totaldue),2) AS "TOtal"

FROM sales.salesorderheader AS ord

GROUP BY "Año", "Mes"

ORDER BY "Año", "Mes" ASC


```

HAVING filtra grupos añadiendo la expresión que tengo agrupada:

```
/* Nombre de producto y sus ventas en el año 2012 aplicando el porcentaje de descuento */

SELECT		pr."name"					AS "Producto",
			l.orderqty * l.unitprice * 
			(1 - l.unitpricediscount)	AS "Importe"
FROM 		production.product			AS pr
				INNER JOIN
			sales.salesorderdetail		AS l	ON pr.productid  = l.productid
				INNER JOIN
			sales.salesorderheader		AS p	ON l.salesorderid = p.salesorderid
WHERE		DATE_PART('year',p.orderdate) = 2012




SELECT		pr."name"					AS "Producto",
			SUM(l.orderqty * l.unitprice * 
			(1 - l.unitpricediscount))	AS "Importe"
FROM 		production.product			AS pr
				INNER JOIN
			sales.salesorderdetail		AS l	ON pr.productid  = l.productid
				INNER JOIN
			sales.salesorderheader		AS p	ON l.salesorderid = p.salesorderid
WHERE		DATE_PART('year',p.orderdate) = 2012
GROUP BY	pr."name"
ORDER BY 	2 ASC


/* Filtrado de grupos */

/* Nombre de producto y sus ventas en el año 2012 aplicando el porcentaje de descuento solo 
cuando las ventas superen 15.000 € en el año y no lleguen a 30000 */

SELECT		pr."name"					AS "Producto",
			SUM(l.orderqty * l.unitprice * 
			(1 - l.unitpricediscount))	AS "Importe"
FROM 		production.product			AS pr
				INNER JOIN
			sales.salesorderdetail		AS l	ON pr.productid  = l.productid
				INNER JOIN
			sales.salesorderheader		AS p	ON l.salesorderid = p.salesorderid
WHERE		DATE_PART('year',p.orderdate) = 2012
GROUP BY	pr."name"
HAVING 		SUM(l.orderqty * l.unitprice * 
			(1 - l.unitpricediscount)) > 15000
				AND
			SUM(l.orderqty * l.unitprice * 
			(1 - l.unitpricediscount)) < 30000
ORDER BY 	2 ASC;



/*   Ventas por subcategorías   

Nombre sub           Import
----------------------------

production.productsubcategory (Abuelita)
production.product (padre)
sales.salesorderdetail  (hija)

*/

SELECT	s."name"							AS "Categoría",
		d.orderqty * d.unitprice			AS "Importe"
FROM	production.productsubcategory		AS s
			INNER JOIN
		production.product					AS p	ON s.productsubcategoryid = p.productsubcategoryid
			INNER JOIN
		sales.salesorderdetail				AS d	ON p.productid = d.productid;



SELECT	s."name"							AS "Categoría",
		SUM(d.orderqty * d.unitprice)		AS "Importe"
FROM	production.productsubcategory		AS s
			INNER JOIN
		production.product					AS p	ON s.productsubcategoryid = p.productsubcategoryid
			INNER JOIN
		sales.salesorderdetail				AS d	ON p.productid = d.productid
GROUP BY	s."name"
ORDER BY 1;


/* Apoyándonos en el ejercico anterior ventas por categoría y subcategoría */




SELECT	c."name"									AS "Categoría",
		s."name"									AS "Subcategoría",
		ROUND(SUM(d.orderqty * d.unitprice), 2)		AS "Importe"
FROM	production.productcategory			AS c
			INNER JOIN	
		production.productsubcategory		AS s	on c.productcategoryid = s.productcategoryid
			INNER JOIN
		production.product					AS p	ON s.productsubcategoryid = p.productsubcategoryid
			LEFT OUTER JOIN
		sales.salesorderdetail				AS d	ON p.productid = d.productid
GROUP BY	c."name", s."name"
ORDER BY  1,2

```

Ejemplos del día 28/08/2025  :

```

/* Importe de compras por categoria */

SELECT ct."name" AS "Categoria",
	   ROUND(SUM(lc.orderqty * lc.unitprice), 2) AS "Importe"

FROM		production.productcategory AS ct
				INNER JOIN
			production.productsubcategory AS sc ON ct.productcategoryid = sc.productcategoryid
				INNER JOIN
			production.product AS pr ON sc.productsubcategoryid = pr.productsubcategoryid
				INNER JOIN
			purchasing.purchaseorderdetail AS lc ON pr.productid = lc.productid

GROUP BY ct."name"
ORDER BY 1;

/* Importe de compras por categoria y subcategoria */

SELECT ct."name" AS "Categoria",
	   sc."name" AS "Subcategoria",
	   ROUND(SUM(lc.orderqty * lc.unitprice), 2) AS "Importe"

FROM		production.productcategory AS ct
				INNER JOIN
			production.productsubcategory AS sc ON ct.productcategoryid = sc.productcategoryid
				INNER JOIN
			production.product AS pr ON sc.productsubcategoryid = pr.productsubcategoryid
				INNER JOIN
			purchasing.purchaseorderdetail AS lc ON pr.productid = lc.productid

GROUP BY ct."name", sc."name"
ORDER BY 1;

/* Importe de compras por categoria, subcategoria y producto */

SELECT ct."name" AS "Categoria",
	   sc."name" AS "Subcategoria",
	   pr."name" AS "Producto",
	   ROUND(SUM(lc.orderqty * lc.unitprice), 2) AS "Importe"

FROM		production.productcategory AS ct
				INNER JOIN
			production.productsubcategory AS sc ON ct.productcategoryid = sc.productcategoryid
				INNER JOIN
			production.product AS pr ON sc.productsubcategoryid = pr.productsubcategoryid
				INNER JOIN
			purchasing.purchaseorderdetail AS lc ON pr.productid = lc.productid

GROUP BY ct."name", sc."name", pr."name"
ORDER BY 1;

```

El operador **`ROLLUP`** es una extensión de la cláusula `GROUP BY` que te permite generar subtotales y un total general para un conjunto de columnas de una manera muy sencilla. Piensa en él como una forma de crear múltiples niveles de agrupación en una sola consulta.

Vamos a usarlo en el ejemplo anterior ultimo :

```
SELECT ct."name" AS "Categoria",
	   sc."name" AS "Subcategoria",
	   pr."name" AS "Producto",
	   ROUND(SUM(lc.orderqty * lc.unitprice), 2) AS "Importe"

FROM		production.productcategory AS ct
				INNER JOIN
			production.productsubcategory AS sc ON ct.productcategoryid = sc.productcategoryid
				INNER JOIN
			production.product AS pr ON sc.productsubcategoryid = pr.productsubcategoryid
				INNER JOIN
			purchasing.purchaseorderdetail AS lc ON pr.productid = lc.productid

GROUP BY ROLLUP(ct."name", sc."name", pr."name")
ORDER BY 1,2,3;
```

![[Pasted image 20250828122055.png]]

El operador **`CUBE`** es una extensión de la cláusula `GROUP BY` que genera subtotales para **todas las combinaciones posibles** de las columnas que especifiques. Es la opción más completa para análisis, ya que no se limita a una jerarquía como `ROLLUP`.

Piensa en `CUBE` como si le pidieras a SQL: "dame los totales por cada columna, por cada par de columnas, por cada trío de columnas, y así sucesivamente, además del total general".

![[Pasted image 20250828122800.png]]

Las filas resaltadas son las que `CUBE` añade y `ROLLUP` no. `CUBE` te da no solo los subtotales por año, sino también los subtotales por ciudad a través de todos los años.

En resumen, **`CUBE` es perfecto para análisis multidimensional** donde quieres explorar los datos desde todas las perspectivas posibles, sin estar limitado a una única jerarquía. Es como obtener una tabla dinámica completa de tus datos con una sola consulta. 📊

Una **subconsulta**, también conocida como consulta anidada o interna, es simplemente una consulta `SELECT` que se encuentra dentro de otra consulta SQL principal. Piénsalo como una pregunta dentro de otra pregunta para obtener un dato que necesitas.

Imagina que quieres saber qué empleados trabajan en el departamento de "Ventas". Necesitas dos pasos:

1. Primero, averiguar cuál es el ID del departamento "Ventas".
    
2. Luego, buscar a todos los empleados con ese ID de departamento.
    

Una subconsulta te permite hacer esto en un solo paso. La consulta interna (la subconsulta) encuentra el ID, y la consulta externa (la principal) usa ese resultado para encontrar a los empleados.

Las subconsultas cuando el criterio no se puede dar de  forma absoluta, y por eso surgen las subconsultas. Aquí tenemos algunos ejemplos :

```
/*  S U B C O N S U L T A S */

/* Nombre y precio unitario de los productos cuyo precio unitario sea mayor que el precio medio de 
todos los productos  */

SELECT 	AVG(p1.listprice)
FROM	production.product	AS p1;


SELECT	p2."name"			AS "Producto",
		p2.listprice		AS "Precio"
FROM 	production.product	AS p2
WHERE	p2.listprice > (SELECT 	AVG(p1.listprice)
								FROM	production.product	AS p1)
ORDER BY 2;


/* Nombre del producto y dias de fabricación (daystomanufacture) de los productos cuyo plazo de 
fabricacion sea superior a la media de todos los productos más un dia */

SELECT 
    Name AS product_name,
    DaysToManufacture
FROM 
    Production.Product
WHERE 
    DaysToManufacture > (
        SELECT AVG(DaysToManufacture)
        FROM Production.Product) + 1;


/* numero de identificacion nacinal (nationalidnumber) y fecha de contratación de los 
empleados cuya edad este comprendida entre la edad media de la plantilla +10 y +15 años */

SELECT		nationalidnumber				AS "NIN",
			hiredate						AS "Contrato"
FROM		humanresources.employee
WHERE		DATE_PART('year', CURRENT_DATE) -
			DATE_PART('year', birthdate)		BETWEEN (SELECT		AVG(	DATE_PART('year', CURRENT_DATE) -
																			DATE_PART('year', birthdate)) + 10
														 FROM		humanresources.employee)						
																AND
													 	(SELECT		AVG(	DATE_PART('year', CURRENT_DATE) -
																			DATE_PART('year', birthdate)) + 15			
														 FROM		humanresources.employee)

/*
los cliente que no han  comprado se calcula restando a la lista del total 
*/

SELECT
    c.customerid
FROM
    sales.customer AS c

WHERE
    c.customerid NOT IN (SELECT customerid
        				 FROM sales.salesorderheader);
```

Ten en cuenta que el querry del SELECT interno de la subconsulta es independiente del SELECT externo.

Las consultas correlacionadas se identifican que el querry interno tengo que ejecutarlo mas de una vez, porque el querry interno depende de lo que se esta procesando en el querry externo. En este caso la consulta interna y externa no son independinentes sino todo lo contrario.

```
/* SUBCONSULTAS CORELACIONADAS */

/* Codigo de producto de los productos cuyo precio de lista es superior a precio medio de la subcategoria a la que pertenece */

/* aqui tenemos la consulta externa*/

SELECT pe."name" AS "Producto"
FROM production.product AS pe --pe de producto consulta externa
WHERE pe.listprice > 


/* aqui tenemos la consulta interna */

SELECT AVG(pi.listprice)
FROM production.product AS pi --producto interno
WHERE pi.productsubcategoryid = pe.productsubcategoryid

/* unimos en la subconsulta correlacionada */

SELECT pe."name" AS "Producto"
FROM production.product AS pe --pe de producto consulta externa
WHERE pe.listprice >(SELECT AVG(pi.listprice)
					 FROM production.product AS pi --producto interno
					 WHERE pi.productsubcategoryid = pe.productsubcategoryid)


```

- Ejemplo día 29/08/2025 :

```
/* productos con listtprice superior a la media de todos los productos  */

(SELECT		AVG(LISTPRICE)
FROM		production.product)



SELECT 		pe."name", pe.listprice
FROM		production.product	AS pe
WHERE		pe.listprice > (	SELECT		AVG(pi.LISTPRICE)
								FROM		production.product  AS pi)



/* customerid de los Clientes que no me han comprado, mediante subconsulta    */

SELECT	customerid
FROM	sales.customer
WHERE	customerid NOT IN (1,2,3)

/* clientes que me han com`prado */
(SELECT	DISTINCT customerid
FROM	sales.salesorderheader)


SELECT	ce.customerid
FROM	sales.customer		AS ce
WHERE	ce.customerid NOT IN (SELECT	DISTINCT ci.customerid
								FROM	sales.salesorderheader		AS ci);



SELECT 	ce.customerid			AS "Cliente"
FROM	sales.customer	AS ce
WHERE 	NOT EXISTS (SELECT pi.salesorderid
					FROM sales.salesorderheader pi
					WHERE pi.customerid = ce.customerid)

/* Cn antijoin */
SELECT	c.customerid				AS "Cliente" --,
		--p.salesorderid				AS "Pedido"
FROM	sales.customer				AS c
			LEFT OUTER JOIN
		sales.salesorderheader		AS p	ON c.customerid = p.customerid
where	p.salesorderid IS NULL



/* Subconsultas correlacionadas */

/*Nombre de producto y precio de los productos cuyo precio de lista es superior 
al precio medio de la subcategoria a la que pertenece  */

/* Consulta externa*/
SELECT 		pe."name"				AS "Producto"
FROM		production.product		AS pe
WHERE		pe.listprice > ???


/* Consulta interna -> 

precio medio de una subcategoría concreta , la subcategoria del producto
que estoy procesando en la consullta externa */

SELECT		AVG(pi.listprice)
FROM		production.product		AS pi
WHERE		pi.productsubcategoryid = pe.productsubcategoryid


/* COMPLETA */
SELECT 		pe."name"				AS "Producto"
FROM		production.product		AS pe
WHERE		pe.listprice > (SELECT		AVG(pi.listprice)
							FROM		production.product		AS pi
							WHERE		pi.productsubcategoryid = pe.productsubcategoryid);


/* Código del pedido, código del artículo, cantidad, precio, importe de las lineas
   cuyo precio sea inferior al precio medio del pedido   */



SELECT		le.salesorderid				AS "Pédido",
			le.productid				AS "Producto",
			le.orderqty					AS "Cantidad",
			le.unitprice				AS "Précio",
			(le.unitprice * 
			le.orderqty)				AS "Importe"
FROM		sales.salesorderdetail		AS le
WHERE		le.unitprice < (precio medio de articulo del pedido que pestoy procesando en la tabla externa)



/* precio medio de articulo del pedido que pestoy procesando en la tabla externa */

SELECT	AVG(li.unitprice)
FROM	sales.salesorderdetail		AS li
WHERE	li.salesorderid = le.salesorderid


/* todo junto */

SELECT		le.salesorderid				AS "Pédido",
			le.productid				AS "Producto",
			le.orderqty					AS "Cantidad",
			le.unitprice				AS "Précio",
			(le.unitprice * 
			le.orderqty)				AS "Importe"
FROM		sales.salesorderdetail		AS le
WHERE		le.unitprice < (SELECT	AVG(li.unitprice)
								FROM	sales.salesorderdetail		AS li
								WHERE	li.salesorderid = le.salesorderid);



/*Código del pedido, fecha del pedido, código del artículo, cantidad, precio, importe de las lineas
   cuyo precio sea inferior al precio medio del pedido   */


sales.salesorderheader
sales.salesorderdetail

SELECT		ce.salesorderid				AS "Pédido",
			ce.orderdate				AS "fecha ped",
			le.productid				AS "Producto",
			le.orderqty					AS "Cantidad",
			le.unitprice				AS "Précio",
			(le.unitprice * 
			le.orderqty)				AS "Importe"
FROM		sales.salesorderheader		AS ce
				INNER JOIN
			sales.salesorderdetail		AS le	ON ce.salesorderid = le.salesorderid
WHERE		le.unitprice < (SELECT	AVG(li.unitprice)
								FROM	sales.salesorderdetail		AS li
								WHERE	li.salesorderid = le.salesorderid);



/*  Numero de pedido e importe de la base imponible (Calculada como la suma de los productos de 
cantidad por el precio con descueto, de aquellos pedidos que tengan entre 2 y 4 líneas de pedido */


SELECT		le.salesorderid										AS "Pedido",
			SUM(le.orderqty * 
				le.unitprice * (1 - le.unitpricediscount))		AS "Importe"
FROM		sales.salesorderdetail		AS le
WHERE		le.salesorderid IN (SELECT 		li.salesorderid --,
											--COUNT(li.salesorderdetailid)
								FROM		sales.salesorderdetail	AS li
								GROUP BY	li.salesorderid
								HAVING 		COUNT(li.salesorderdetailid) BETWEEN 2 AND 4)
GROUP BY	le.salesorderid	
 		


/*numeros de pedidos de entre 2 y 4 líneas*/

SELECT 		li.salesorderid --,
			--COUNT(li.salesorderdetailid)
FROM		sales.salesorderdetail	AS li
GROUP BY	li.salesorderid
HAVING 		COUNT(li.salesorderdetailid) BETWEEN 2 AND 4



/* Otra versión */

SELECT  	le.salesorderid 			AS "Cod. pedido",
    		SUM(le.unitprice * le.orderqty * (1 - le.unitpricediscount)) AS "Importe"--,
			--COUNT(le.salesorderdetailid)				AS "Num lin"
FROM 		sales.salesorderdetail AS le
GROUP BY 	le.salesorderid
HAVING COUNT(le.salesorderdetailid) BETWEEN 2 AND 4
ORDER by 1;

```

Recuerda preguntarte para diferenciar una Subconsulta no correlacionada de una correlacionada, depende la consulta interna de la consulta externa? si es no es no correlacionada sino si que es correlacionada. Como dice Fermín es una mentira piadosa pero nos sirve para diferenciarla.

- Ejemplos de 01/09/2025 :

```
/* Empleados que cobrab mas que la media de la empres */

-- Salario medio de la empresa
-- esta es la interna

SELECT AVG(phi.rate)
FROM humanresources.employeepayhistory AS phi

-- la externa ahora
SELECT phe.businessentityid AS "BEID",
	 phe.rate AS "€/horas"
FROM humanresources.employeepayhistory AS phe
WHERE phe.rate >(salario medio) 

-- todo junto 

SELECT phe.businessentityid AS "BEID",
	 phe.rate AS "€/horas"
FROM humanresources.employeepayhistory AS phe
WHERE phe.rate > (SELECT AVG(phi.rate)
				  FROM humanresources.employeepayhistory AS phi)


/* Las subcnosultas pueden devlver varios valores, o sea lista de valores con el operador de listas IN  */

/* Clientes que no me han comprado  */

-- Clientes que me han comprado, sera la consulta en este caso lista de valores, como consulta interna

SELECT DISTINCT pi.customerid AS "Num Cliente"

FROM sales.salesorderheader AS pi

-- clientes que no me han comprado ABORT

SELECT ce.customerid AS "Cliente"

FROM sales.customer AS ce

WHERE ce.customerid NOT IN (SELECT DISTINCT pi.customerid AS "Num Cliente"

							FROM sales.salesorderheader AS pi)
							




```

**Se pueden poner consultas en el FRON : (busca en el archivo de fermin sobre este tema los ejemplos)**

**CTE o Common Table Expresion :**

```
-- CTE - COMMON TABLE EXPRESION
-- Numero medio de ordenes por vendedor (salespersonid) en el 2013


-- Primero consulta que da cantidad de ordenes de cada salepersonid en 2013
SELECT soh.salespersonid AS "Vendedor",
	   COUNT(soh.salesorderid) AS "Num. Pedidos"

FROM sales.salesorderheader AS soh

WHERE DATE_PART('year', soh.orderdate) = 2013 AND soh.salespersonid IS NOT NULL

GROUP BY soh.salespersonid

ORDER BY 2;

------

WITH opv AS (la consulta anterior)

-------------- TODO JUNTO AHORA (COMO SE LLAMA ESTA SUBCONSULTA CON WITH?)

WITH opv AS (SELECT soh.salespersonid AS "Vendedor",
	   		 COUNT(soh.salesorderid) AS "Num. Pedidos"

			 FROM sales.salesorderheader AS soh

			 WHERE DATE_PART('year', soh.orderdate) = 2013 AND soh.salespersonid IS NOT NULL

			 GROUP BY soh.salespersonid

			 ORDER BY 2)
SELECT AVG("Num. Pedidos")

FROM opv


-- Año y numero medio de pedidos por vendedor ----

SELECT DATE_PART('year', head.orderdate) AS "Año",
	   COUNT(head.salesorderid) AS "NumPedidos",
	   head.salespersonid AS "Vendedor"
FROM sales.salesorderheader AS head
WHERE head.salesorderid IS NOT NULL
GROUP BY head.salespersonid, DATE_PART('year', head.orderdate)


-- juntandolo todo --

WITH pav AS (SELECT DATE_PART('year', head.orderdate) AS año,
	   		COUNT(head.salesorderid) AS pedidos,
		    head.salespersonid AS "Vendedor"
			FROM sales.salesorderheader AS head
			WHERE head.salesorderid IS NOT NULL
			GROUP BY head.salespersonid, DATE_PART('year', head.orderdate))
SELECT año,
		AVG(pedidos)

FROM pav

GROUP BY año
```

Vistas, son consulta almacenadas, no se pueden modificar o al menos en los caos que si, son bastante restrictivas, las vistas no ocupan espacio y en el caso que  el administrador de la base de datos no nos de permisos para crear vistas usamos CTE:

```
CREATE VIEW sales.pav AS 
			SELECT DATE_PART('year', head.orderdate) AS año,
	   		COUNT(head.salesorderid) AS pedidos,
		    head.salespersonid AS "Vendedor"
			FROM sales.salesorderheader AS head
			WHERE head.salesorderid IS NOT NULL
			GROUP BY head.salespersonid, DATE_PART('year', head.orderdate)

CREATE VIEW production.vproductos AS 
SELECT cat."name" AS productcategoryname,
	   sub."name" AS productsubcategoryname,
	   p.* 
FROM production.productcategory AS cat
		INNER JOIN
	 production.productsubcategory AS sub ON cat.productcategoryid = sub.productcategoryid
	 	INNER JOIN
	 production.product AS p ON sub.productsubcategoryid = p.productsubcategoryid

```

>  En este ejemplo anterior se guarda la vista en el esquema usado Sales.

Las Vistas nos ayudan a tener almacenadas tablas que se suelen usar mucho con varios Joins y poder usar en futuras consultas de forma mas rápida y agilizar el flujo de trabajo.


## 3. Lenguaje de manipulación de la base de datos:

### Lenguaje de definición de datos (DDL):

Este Lenguaje nos permite y proporciona los medios para definir los elementos que integran la base de datos como las tablas, vistas, índices, etc. Comprende las sentencias `CREATE` , `ALTER` y `DROP`. Para entrar en este lenguaje vamos a dar un breve repaso sobre los tipos de datos que mas usaremos:

1. Tipo **BOOLEAN o BOOL**:  permite almacenar uno de los siguientes valores: true o false o null.
2. Tipos **numéricos**, nos permiten almacenar números de los cuales pueden ser enteros o reales, los más empleados son los siguientes:
     -  **SMALLINT** -> sirve para almacenar números enteros pequeños.
	 -  **INT o INTEGER** -> sirven para almacenar números enteros de tamaño normal.
	 -  **BIGINT** -> sirven para almacenar números enteros  grandes.
	 -  **SMALLSERIAL, SERIAL y BIGSERIAL** -> son un tipo de dato especial de PostgreSQL que generará el valor de un atributo automáticamente y se tratará de números correlativos empezando y de carácter autoincremental.
	 -  **NUMERIC (n,d) -> es un tipo estándar de SQL que sirve para almacenar números con decimales exactos
	 -  **DECIMAL(n,d)** -> es el equivalente a numeric.
	 - **REAL** -> sirve para almacenar en 4 bytes números con decimales aproximados de preción simple, se utilizan  cuando se trabajan con decimales muy grandes.
	 - **DOUBLE PRECISION** -> sirve para almacenar en 8 bytes números con decimales aproximados de doble precisión, también para decimales muy grandes.
3. Tipos de **fecha y hora:** nos permite almacenar fechas y horas, y sus tipos son:
	- **DATE** -> permite almacenar una fecha en el formato AAAA-MM-DD. se puede asignar como valor por defecto a un campo de este tipo el  valor CURRENT_DATE, que hace referencia a la fecha actual. 
	- **TIMESTAMP** -> permite almacenar una fecha y una hora en el formato AAAA-MM-DD HH:MM:SS, también tiene la opción de poner como defecto la actual con CURRENT_TIMESTAMP.
	- **TIME** -> permite almacenar una hora en el formato HH:MM:SS.mmm donde mmm hace referencia a los milisegundos, que se pueden omitir. Permite rango desde 00:00:00 a 24:00:00.
	- **INTERVAL** -> permite almacenar un intervalo de tiempo en años, meses, días, horas, minutos, segundos, etc.
4. Tipos de **cadenas de caracteres**: nos permite almacenar cadenas de caracteres, que incluye cualquier carácter incluido dentro del conjunto de caracteres correspondiente a la tabla. Sus tipos son:
	- CHARACTER(M) o CHAR(M) -> sir ven para almacenar cadenas de caracteres de longitud fija, esto es, cadenas que siempre ocupan el número de caracteres especificados en M. Si no se indica M se SQL presupone que reservas 1, como si escribieras CHAR(1).
	- CHARACTER VARYING(M) o VARCHAR(M) -> permite almacenar cadenas de  caracteres de longitud variable, siendo su longitud máxima permitida M.
	- TEXT -> permite almacenar cadenas de caracteres de cualquier longitud.
	- BYTEA -> permite almacenar objetos binarios de longitud variable.
5. Tipo XML: permite almacenar datos XML es un campo de tipo texto pero tiene unas  ventajas como que comprueba si los datos tienen una estructura correcta y, además existe en PostgreSQL funciones especificas para datos de este tipo que permite llevar a cabao operaciones seguras.


### Creación, modificación y borrado de base de datos :

#### Creación de base de datos y tablas:

Se usa la sentencia `CREATE DATABE` el formato de la instrucción :

```
CREATE DATABASE nombreBBDD
    WITH
    [OWNER = nombre_rol]
    [ENCODING = 'UTF8']
    LC_COLLATE = 'Spanish_Spain.1252'
    LC_CTYPE = 'Spanish_Spain.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
```

>Recuerda de `[]` indica opcionalidad.

De los atributos de esta sentencia que merece mencionar son :

`CONNECTION LIMIT` es es número de conexiones permitidas simultaneas a la base de dtos, si ponemos -1 es infinito.
`OWNER` es el usuario propietario de la base de datos.
`TABLESPACE` espacio de tabla por defecto `pg_default` en PostgreSQL
`IS TEMPLATE` indica con false o true si es plantilla o no, algunas sentencias pueden en vez de crear base de datos pueden hacer plantillas para crear un modelo de varias bases de datos en el futuro con una forma y estructura definida en una plantilla.

Para crear tablas usaremos la orden :

```
CREATE TABLE [IF NOT EXISTS] nombre_tabla

(columna, tipo_dato [DEFAULT valor_defecto] [COLLATE nombre_cotejamiento] [restricciones_columna])

(columna, tipo_dato [DEFAULT valor_defecto] [COLLATE nombre_cotejamiento] [restricciones_columna])

...

(columna, tipo_dato [DEFAULT valor_defecto] [COLLATE nombre_cotejamiento] [restricciones_columna])

[restriccion_tabla], [restriccion_tabla];
```

Definimos los atributos, intentaremos usar poner en minúsculas nombre de atributos y tablas y las variables o palabras reservadas en mayúsculas aunque no es obligatorio. En cuanto a las restricciones o constraint se puede definir en cada declaración de atributo pero es aconsejable y solemos hacerlo al final del comando.

Las constrains se declaran de la siguiente forma :

- CONSTRAINT 
#### Modificación de base de datos :

Para realizar modificaciones en una base de datos previamente creada, se usará la sentencia `ALTER DATABASE`

```
ALTER DATABASE nombre_BD WITH especificacion_alteracion;
especificacion_creacion:
	[ALLOR_CONNECTIONS = true | false]
	[CONNECTION LIMITE = numero]
	[IS_TEMPLATE = true | false ];
```

> Como dato adicional saber que se puede modificar el nombre de la base de datos con : 'ALTER DATABASE  nombre_BD RENAME TO nuevo_nombre'


También se puede modificar  el propietario de la base de datos con :

```
ALTER DATABASE nombre_BD OWNER TO
{nuevo_propietario | CURRENT_ROLE | CURRENT_USER | SESSION_USER};
```

Para modificar tablas usaremos la orden :

```
ALTER TABLE nombre_tabla
ADD [COLUMN] columna tipo_dato [DEFAULT valor_defecto]
		[COLLATE nombre_cotejamiento] [restriccions_columna]
```

Tras usar `ADD` debemos poner indicar el nombre del atributo que se desea añadir, su tipo y opcionalmente un valor por defecto y las restricciones de columna que se deseen.
#### Borrado de base de datos y tablas:

Para eliminar una base de datos usaremos la orden y formato :

`DROP DATABASE [IF EXISTS] nombre_BD`

Para borrar una tabla de una base de datos usaremos :

`DROP TABLE [IF EXISTS] tablax, tabla y, ...;`