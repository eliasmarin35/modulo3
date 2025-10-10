/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listatareas.view.console.scanner;

import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author jadmin
 */
public class ConsoleScanner<T> {

    private static final String CLEAR_SCREEN = "\u001B[2J\u001B[H";

    private Scanner scan;
    private ScannerGet<T> getter = new ScannerGet<>();
    private String header = null;
    private String prompt = null;
    private String errorText = null;
    private boolean cleanScreen = true;

    public ConsoleScanner(Scanner s) {
        this.scan = s;
    }
    
    public ConsoleScanner(Scanner s, Function<String,T> xform) {
        this(s);
        this.getter.setXform(xform);
    }
    
    public ConsoleScanner(Scanner s, Function<String,T> xform, Predicate<T> filter) {
        this(s,xform);
        this.getter.setFilter(filter);
    }

    public T next() {
        String text = null;
        TypeError<T> result = null;

        do {
            // Clean the screen
            if (this.cleanScreen) {
                this.cleanScreen();
            }

            // Header
            if (this.header != null) {
                System.out.println(this.header);
            } else {
                System.out.println("");
            }

            // Prompt
            if (this.prompt != null) {
                System.out.print(this.prompt);
            } else {
                System.out.print("> ");
            }

            // Scan
            text = this.scan.nextLine().trim();
            System.out.println("");

            // Check
            result = this.getter.apply(text);
            
            if (result.isError()) {
                if (this.errorText != null) {
                    System.out.println(this.errorText);
                    this.pressEnterPriv();
                }
            }
        } while (result.isError());
        
        return result.getValue();
    }
    
    private void pressEnterPriv() {
        System.out.println("Presiona Intro.");
        this.scan.nextLine();
    }
    
    public static void pressEnter(Scanner scan) {
        ConsoleScanner<String> scanGetter = new ConsoleScanner<>(
            scan
        );
        
        scanGetter.pressEnterPriv();
    }

    // ======== SETTERS 

    /**
     * @param header the header to set
     */
    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * @param prompt the prompt to set
     */
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    /**
     * @param errorText the errorText to set
     */
    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }

    /**
     * @param cleanScreen the cleanScreen to set
     */
    public void setCleanScreen(boolean cleanScreen) {
        this.cleanScreen = cleanScreen;
    }

    // ======== UTILITIES
    

    private void cleanScreen() {
        System.out.print(CLEAR_SCREEN);
    }
}
