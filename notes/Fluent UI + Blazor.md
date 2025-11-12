
# Componentes Importantes:

## DataGrid :

### 1. El Concepto Básico: Activar las Cabeceras como Menús

Por defecto, hacer clic en una cabecera solo sirve para ordenar (si `Sortable="true"`). Para cambiar este comportamiento y hacer que la cabecera actúe como un botón que abre un menú, necesitas hacer dos cosas:

1. **En el `<FluentDataGrid>`:** Añadir el atributo `HeaderCellAsButtonWithMenu="true"`.
    
2. **En la `<PropertyColumn>` (o `TemplateColumn`):** Añadir un componente hijo `<ColumnOptions>`.
    

Cuando el `FluentDataGrid` tiene `HeaderCellAsButtonWithMenu="true"`, al hacer clic en una cabecera, el grid busca si esa columna tiene un bloque `<ColumnOptions>` dentro. Si lo encuentra, muestra el contenido de ese bloque como un menú desplegable.

---

### 2. El Atributo: `HeaderCellAsButtonWithMenu="true"`

Este es el interruptor global para la cuadrícula. Sin él, nada de esto funciona.

**Ejemplo de código:**


```html
<FluentDataGrid Items="@FilteredItems"
                HeaderCellAsButtonWithMenu="true"
                @ref="grid">
    
    </FluentDataGrid>
```

- **`HeaderCellAsButtonWithMenu="true"`**: Le dice al grid: "Prepárate, las cabeceras de tus columnas pueden abrir menús".
    
- **`@ref="grid"`**: Es **muy importante** en este ejemplo. Como veremos, nos permite llamar a métodos del grid, como "Cerrar el menú".
    

---

### 3. El Contenedor del Menú: `<ColumnOptions>`

Este componente es el "lienzo" de tu menú. Todo lo que pongas dentro de él aparecerá en el popup. Se anida _dentro_ de la columna que quieres que tenga el menú.

**Ejemplo de código (la columna "Name" del ejemplo):**


```html
<PropertyColumn Property="@(c => c.Name)" 
                Sortable="true" 
                Filtered="@(!string.IsNullOrWhiteSpace(nameFilter))">
    
    <ColumnOptions>
        <div class="search-box">
            <FluentSearch Autofocus="true" 
                          @bind-Value="nameFilter" 
                          @oninput="HandleCountryFilter" 
                          @onkeydown="HandleCloseFilterAsync" 
                          @bind-Value:after="HandleClear" 
                          Placeholder="Country name..." 
                          Style="width: 100%;" 
                          Label="Filter" />
        </div>
    </ColumnOptions>

</PropertyColumn>
```

---

### 4. Explicación Detallada de ese Bloque

Desglosemos las partes clave de ese ejemplo de columna, porque cada línea es importante.

#### 4.1. El Atributo `Filtered`


```html
<PropertyColumn ... Filtered="@(!string.IsNullOrWhiteSpace(nameFilter))">
```

- **`Filtered="..."`**: Este atributo es un **feedback visual** para el usuario.
    
- **`@(!string.IsNullOrWhiteSpace(nameFilter))`**: Esta es una expresión C#. `nameFilter` es la variable que guarda el texto del filtro.
    
- **Traducción:** "Si la variable `nameFilter` NO está vacía (es decir, si hay un filtro activo), pon `Filtered="true"`".
    
- **Efecto:** Cuando es `true`, el `FluentDataGrid` muestra el icono de filtro (un embudo) en la cabecera de la columna con un color distintivo, indicando al usuario que esa columna está siendo filtrada.
    

#### 4.2. El Contenido de `<ColumnOptions>`


```html
<ColumnOptions>
    <div class="search-box">
        <FluentSearch Autofocus="true" 
                      @bind-Value="nameFilter" 
                      @oninput="HandleCountryFilter" 
                      @onkeydown="HandleCloseFilterAsync" 
                      @bind-Value:after="HandleClear" 
                      ... />
    </div>
</ColumnOptions>
```

Dentro del menú, el ejemplo coloca un componente `<FluentSearch>`. Aquí es donde ocurre la magia del enlace de datos (data-binding):

- **`Autofocus="true"`**: Cuando el menú aparece, el cursor se pone automáticamente en la caja de búsqueda. Es genial para la usabilidad.
    
- **`@bind-Value="nameFilter"`**: Esta es la conexión principal. El texto de la barra de búsqueda está **enlazado bidireccionalmente** a la variable `nameFilter` en tu bloque `@code`. Cuando el usuario escribe, `nameFilter` se actualiza.
    
- **`@oninput="HandleCountryFilter"`**: (Opcional) Si quieres reaccionar _mientras_ el usuario escribe (en lugar de esperar a que `bind-Value` se actualice), puedes llamar a una función.
    
- **`@onkeydown="HandleCloseFilterAsync"`**: ¡Muy importante! Llama a la función C# `HandleCloseFilterAsync` cada vez que el usuario presiona una tecla. Esto se usa para detectar "Enter" o "Escape".
    
- **`@bind-Value:after="HandleClear"`**: (Opcional) Llama a la función `HandleClear` _después_ de que el valor haya cambiado.
    

---

### 5. El Código C# (`@code`) de Soporte

Todo el HTML anterior no funciona sin su contraparte en C#. El ejemplo de la web necesita estas piezas:

#### 5.1. Variables de Estado

Necesitas almacenar la referencia al grid, el estado de la paginación, los datos y, lo más importante, el valor del filtro.


```c#
@code {
    // 1. Referencia al Grid (para llamar a sus métodos)
    FluentDataGrid<Country>? grid; 

    // 2. La lista completa de items (viene de un servicio)
    IQueryable<Country>? items;

    // 3. El "cerebro" de la paginación
    PaginationState pagination = new PaginationState { ItemsPerPage = 10 };

    // 4. La variable CLAVE para el filtro
    string nameFilter = string.Empty;

    // 5. La propiedad que REALMENTE usa el grid
    IQueryable<Country>? FilteredItems
    {
        get
        {
            var result = items; // Empieza con todo

            // Si hay un filtro, aplica un .Where()
            if (result is not null && !string.IsNullOrEmpty(nameFilter))
            {
                result = result.Where(c => c.Name.Contains(nameFilter, StringComparison.CurrentCultureIgnoreCase));
            }
            
            return result; // Devuelve la lista filtrada
        }
    }
}
```

**Explicación de `FilteredItems`:** Esta es la parte más inteligente. El `<FluentDataGrid>` **no** está enlazado a la lista completa `items`, está enlazado a `FilteredItems` (`Items="@FilteredItems"`).

`FilteredItems` es una **propiedad calculada** (un "getter"). Cada vez que Blazor necesita redibujar (porque `nameFilter` cambió), vuelve a ejecutar este código: coge la lista completa y le aplica el filtro `nameFilter` al vuelo.

#### 5.2. Manejadores de Eventos (Cerrar el Menú)

El usuario espera poder cerrar el popup de filtro presionando "Enter" (para confirmar) o "Escape" (para cancelar).


```c#
@code {
    // ... (variables de antes) ...

    // Esta función se llama desde el @onkeydown del FluentSearch
    private async Task HandleCloseFilterAsync(KeyboardEventArgs args)
    {
        // Si la tecla es "Escape"
        if (args.Key == "Escape")
        {
            nameFilter = string.Empty; // Limpia el filtro
        }

        // Si la tecla es "Enter" O "Escape", y el grid existe
        if ((args.Key == "Enter" || args.Key == "Escape") && grid is not null)
        {
            // Llama al método del grid para CERRAR el popup
            await grid.CloseColumnOptionsAsync();
        }
    }
}
```

**Explicación:** Aquí es donde usamos el `@ref="grid"`.

1. El `@onkeydown` en el `FluentSearch` captura la tecla.
    
2. La función `HandleCloseFilterAsync` se ejecuta.
    
3. Comprueba si la tecla es "Enter" o "Escape".
    
4. Si lo es, le da la orden al grid: `await grid.CloseColumnOptionsAsync()`.
    
5. El grid obedece y cierra el menú de opciones que esté abierto.
    

### Resumen de la Característica

Para crear un menú en la cabecera (como un filtro), necesitas:

1. Poner `HeaderCellAsButtonWithMenu="true"` en el `<FluentDataGrid>`.
    
2. Poner un `@ref="grid"` en el `<FluentDataGrid>`.
    
3. Anidar un bloque `<ColumnOptions>` dentro de tu `<PropertyColumn>`.
    
4. Poner tus controles de filtro (ej. `<FluentSearch>`) dentro de `<ColumnOptions>`.
    
5. Crear una variable C# (ej. `nameFilter`) y enlazarla con `@bind-Value` a tu control.
    
6. Crear una propiedad calculada (ej. `FilteredItems`) que use tu variable de filtro para filtrar la lista.
    
7. Enlazar el `Items` del DataGrid a esa propiedad calculada.
    
8. (Opcional pero recomendado) Añadir un manejador `@onkeydown` que llame a `grid.CloseColumnOptionsAsync()` para cerrar el menú con el teclado.


