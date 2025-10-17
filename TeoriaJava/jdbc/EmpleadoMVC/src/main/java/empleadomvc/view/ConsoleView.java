/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleadomvc.view;

import empleadomvc.model.Empleado;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jprof
 */
public class ConsoleView {

    private static final String CLEAR_SCREEN = "\033[H\033[2J";

    private Scanner scan;

    public ConsoleView() {
        scan = new Scanner(System.in);
    }

    public void close() {
        scan.close();
    }

    public String showMainMenu() {
        String text=null;
        String option=null;

        while (option == null) {

            System.out.print(CLEAR_SCREEN);
            System.out.println(
            """
                  MANTENIMIENTO DE EMPLEADOS
                ==============================
            
                1) Listar todos los empleados
                2) Insertar un nuevo empleado
            
                Q) Salir
                -------------------------------
            """
            );

            // Pide la opcion
            System.out.print("> ");
            text = this.scan.nextLine().trim().toUpperCase();
            System.out.println("");

            // Devuelve la opcion pulsada
            switch (text) {
                case "1":
                    option = "LIST";
                    break;
                case "2":
                    option = "INSERT";
                    break;
                case "Q":
                    option = "EXIT";
                    break;
                default:
                    option = null;
                    break;
            }
        }
        
        return option;
    }
    
    public String askText (String prompt) {
        String text=null;
        
        do {
            System.out.println(prompt);
            System.out.println("> ");
            text = this.scan.nextLine().trim();
            System.out.println("");
            
            if (text.isEmpty()) {
                text = null;
                System.out.println("\nRepita el dato.\n\n");
            }
        }
        while (text==null);
        
        return text;
    }
    
    public void list(List<Empleado> elements) {
        System.out.print(CLEAR_SCREEN);
        System.out.println("Listado de emplados:");
        elements.forEach(System.out::println);
        
        System.out.println("\n\nPulse intro para continuar.");
        this.scan.nextLine();
    }
}
