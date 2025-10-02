import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Diccionario {

    private List<String> palabras;
    private Random random = new Random();

    /**
     * Constructor que carga las palabras desde un archivo de texto.
     * @param rutaArchivo La ruta al archivo .txt que contiene las palabras.
     */
    public void SelectorPalabras(String rutaArchivo) {
        try {
            // Files.readAllLines lee todas las líneas del archivo y las devuelve como una Lista de Strings.
            // Usamos UTF-8 para asegurar la compatibilidad con acentos y caracteres especiales.
            this.palabras = Files.readAllLines(Paths.get(rutaArchivo), StandardCharsets.UTF_8);
            
            // Opcional: Eliminar palabras vacías si el archivo las tuviera.
            this.palabras.removeIf(String::isEmpty);

            // Opcional: Comprobar si la lista está vacía después de cargar.
            if (this.palabras.isEmpty()) {
                System.err.println("Advertencia: El archivo de palabras está vacío o no se encontraron palabras válidas.");
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo de palabras: " + e.getMessage());
            // En caso de error, inicializamos una lista vacía para evitar fallos.
            this.palabras = List.of(); // Lista inmutable vacía
        }
    }

    /**
     * Devuelve una palabra aleatoria de la lista cargada.
     * @return Una palabra en mayúsculas o null si no hay palabras cargadas.
     */
    public String obtenerPalabraAleatoria() {
        if (palabras == null || palabras.isEmpty()) {
            return null; // O lanzar una excepción, dependiendo de cómo quieras manejar el error.
        }
        
        // 1. Generamos un índice aleatorio.
        //    random.nextInt(N) devuelve un número entre 0 (incluido) y N (excluido).
        int indiceAleatorio = random.nextInt(palabras.size());
        
        // 2. Obtenemos la palabra de la lista usando ese índice.
        String palabraSeleccionada = palabras.get(indiceAleatorio);
        
        // 3. (Recomendado para el Ahorcado) Devolvemos la palabra en mayúsculas para simplificar las comparaciones.
        return palabraSeleccionada.toUpperCase();
    }

    // --- Ejemplo de cómo usar esta clase ---
    public static void main(String[] args) {
        // Asegúrate de que la ruta al archivo es correcta.
        // Si está en la raíz del proyecto, solo necesitas el nombre del archivo.
        String ruta = "palabras.txt";
        
        SelectorPalabras selector = new SelectorPalabras(ruta);
        
        String palabraParaJugar = selector.obtenerPalabraAleatoria();
        
        if (palabraParaJugar != null) {
            System.out.println("¡Vamos a jugar al Ahorcado!");
            System.out.println("La palabra seleccionada es: " + palabraParaJugar);
        } else {
            System.out.println("No se pudo cargar una palabra para jugar. Revisa el archivo.");
        }
        
        // Puedes llamar al método varias veces para ver cómo cambia la palabra.
        System.out.println("Otra palabra aleatoria: " + selector.obtenerPalabraAleatoria());
        System.out.println("Y otra: " + selector.obtenerPalabraAleatoria());
    }
}