package com.avante.ahorcado;

import java.util.Random;
import java.util.Set;
import java.util.HashSet;

public class Juego {

    // --- CONSTANTES DEL JUEGO ---
    private static final String[] DICCIONARIO = {
        "JAVA", "PROGRAMACION", "ORDENADOR", "INTELIGENCIA", "ALGORITMO",
        "DESARROLLO", "TECLADO", "ANDALUCIA", "SEVILLA", "GUADALQUIVIR"
    };

    private static final String[] DIBUJOS_AHORCADO = {
        " +---+\n |   |\n     |\n     |\n     |\n     |\n=======",
        " +---+\n |   |\n O   |\n     |\n     |\n     |\n=======",
        " +---+\n |   |\n O   |\n |   |\n     |\n     |\n=======",
        " +---+\n |   |\n O   |\n/|   |\n     |\n     |\n=======",
        " +---+\n |   |\n O   |\n/|\\  |\n     |\n     |\n=======",
        " +---+\n |   |\n O   |\n/|\\  |\n/    |\n     |\n=======",
        " +---+\n |   |\n O   |\n/|\\  |\n/ \\  |\n     |\n======="
    };

    // --- ESTADO DEL JUEGO ---
    private final String palabraSecreta;
    private final char[] palabraAdivinada;
    private int intentosRestantes;
    //en vez de array list esto controla que no pongas cada letra mas de uan vez automaticamente
    //lo he usado por recomendacion de IA es mas rapido y final permite proteger de asignaciones pero si modificarla aunque sea final
    private final Set<Character> letrasUsadas; 

    /**
     * Constructor que inicia una nueva partida.
     */
    public Juego() {
        Random rand = new Random();
        this.palabraSecreta = DICCIONARIO[rand.nextInt(DICCIONARIO.length)];
        this.intentosRestantes = 6;
        this.letrasUsadas = new HashSet<>();
        
        this.palabraAdivinada = new char[palabraSecreta.length()];
        for (int i = 0; i < this.palabraAdivinada.length; i++) {
            this.palabraAdivinada[i] = '_';
        }
    }

    /**
     * Devuelve una cadena con el estado visual actual del juego.
     * Incluye el dibujo, la palabra y las letras usadas.
     */
    public String getEstadoVisual() {
        StringBuilder sb = new StringBuilder();
        sb.append("=====================================\n");
        sb.append(DIBUJOS_AHORCADO[6 - this.intentosRestantes]).append("\n\n");
        sb.append("Palabra: ");
        for (char c : this.palabraAdivinada) {
            sb.append(c).append(" ");
        }
        sb.append("\n\nLetras usadas: ").append(this.letrasUsadas.toString()).append("\n");
        sb.append("Intentos restantes: ").append(this.intentosRestantes).append("\n");
        return sb.toString();
    }

    /**
     * Procesa la letra introducida por el jugador.
     * @param letra El carácter a comprobar.
     * @return Un mensaje indicando el resultado del intento.
     */
    public String procesarLetra(char letra) {
        letra = Character.toUpperCase(letra);

        if (letrasUsadas.contains(letra)) {
            return "Ya has usado la letra '" + letra + "'. Intenta con otra.";
        }

        letrasUsadas.add(letra);
        boolean acierto = false;

        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                palabraAdivinada[i] = letra;
                acierto = true;
            }
        }

        if (acierto) {
            return "¡BIEN! La letra '" + letra + "' está en la palabra.";
        } else {
            intentosRestantes--;
            return "¡Fallo! La letra '" + letra + "' no está en la palabra.";
        }
    }

    /**
     * Comprueba si el jugador ha ganado la partida.
     * @return true si ha adivinado la palabra, false en caso contrario.
     */
    public boolean haGanado() {
        return new String(palabraAdivinada).equals(palabraSecreta);
    }

    /**
     * Comprueba si el jugador ha perdido la partida.
     * @return true si se ha quedado sin intentos, false en caso contrario.
     */
    public boolean haPerdido() {
        return intentosRestantes <= 0;
    }

    /**
     * Devuelve la palabra secreta. Útil para mostrarla al final.
     */
    public String getPalabraSecreta() {
        return this.palabraSecreta;
    }
}