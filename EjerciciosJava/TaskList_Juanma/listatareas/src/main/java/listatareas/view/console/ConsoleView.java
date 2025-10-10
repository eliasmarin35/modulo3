/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listatareas.view.console;

import listatareas.model.Task;
import java.util.Scanner;
import java.util.stream.Stream;
import listatareas.view.TaskListEvents;
import listatareas.model.TaskListListener;
import listatareas.view.console.scanner.ConsoleScanner;

/**
 *
 * @author jadmin
 */
public class ConsoleView implements TaskListListener{

    private static final String  CLEAR_SCREEN = "\u001B[2J\u001B[H";
    private        final Scanner scan;
    
    private int            size = 0;
    private TaskListEvents listener;
    

    public ConsoleView() {
        this.scan = new Scanner(System.in);
    }
    
    public void setListener(TaskListEvents l) {
        this.listener = l;
    }

    public void close() {
        this.scan.close();
    }

    private void clearScreen() {
        System.out.println(CLEAR_SCREEN);
    }
    
    private ConsoleOperation askOperation() {
        ConsoleScanner <ConsoleOperation> scanGetter = new ConsoleScanner<>(
            this.scan,
            s -> ConsoleOperation.parseOperation(s),
            o -> o != ConsoleOperation.ERROR
        );
        
        scanGetter.setCleanScreen(true);
        
        scanGetter.setHeader(String.format("""
            LISTA DE TAREAS (%03d tareas)
            ===============
                           
            a) Añadir Tarea
            s) Sacar Tarea
            l) Imprimir lista de tareas
            p) Imprimir lista de tareas como lista de prioridad
            q) Salir (quit)
            """,
                this.size));
        
        scanGetter.setPrompt(" (aslpq) > ");
        scanGetter.setErrorText("Opción incorrecta.");
        
        return scanGetter.next();
    }

    private ConsolePriority askPriority() {
        ConsoleScanner<ConsolePriority> scanGetter = new ConsoleScanner<>(
            this.scan,
            s -> ConsolePriority.parse(s),
            p -> p != ConsolePriority.ERROR
        );
        
        scanGetter.setCleanScreen(true);
        
        scanGetter.setHeader("""
            SELECCIONE LA PRIORIDAD
            ===============
                           
            0) BAJA
            1) MEDIA
            2) ALTA
                          
            q) CANCELAR
            """
        );
        
        scanGetter.setPrompt(" (012q) > ");
        scanGetter.setErrorText("La prioridad no es correcta.");
        
        return scanGetter.next();
    }
    
    private String askText() {
        ConsoleScanner<String> scanGetter = new ConsoleScanner<>(
            this.scan,
            s -> s,
            s -> !s.isEmpty()
        );
        
        scanGetter.setCleanScreen(true);
        scanGetter.setHeader("Escriba el texto de la tarea:");
        scanGetter.setPrompt(" > ");
        scanGetter.setErrorText("El texto no puede estar vacío.");
        
        return scanGetter.next();
    }

    private boolean operacion(ConsoleOperation op) {
        boolean isEnd = false;

        switch (op) {
            case ConsoleOperation.ADD ->
                opAdd();
            case ConsoleOperation.POLL ->
                opPoll();
            case ConsoleOperation.LIST ->
                opList();
            case ConsoleOperation.PRIORITIES ->
                opPriorities();
            case ConsoleOperation.ERROR ->
                opError();
            case ConsoleOperation.QUIT ->
                isEnd = true;
        }

        return isEnd;
    }

    public void run() {
        ConsoleOperation op = ConsoleOperation.ERROR;
        boolean isEnd = false;
        
        clearScreen();

        while (!isEnd) {
            op = askOperation();
            clearScreen();
            isEnd = operacion(op);
            clearScreen();
        }
    }

    // ======= OPERATIONS
    private void opError() {
        System.out.print("Operación inválida.");
    }

    private void opAdd() {
        ConsolePriority p = null;
        String          t = "";
        
        p = askPriority();
        
        if (p != ConsolePriority.SALIR) {
            t = askText();
            
            listener.add(p.getPriority(),t);
        }
    }

    private void opPoll() {
        clearScreen();
        listener.poll();
        System.out.println("");
        ConsoleScanner.pressEnter(this.scan);
    }

    private void opList() {
        clearScreen();
        listener.printList();
        System.out.println("");
        ConsoleScanner.pressEnter(this.scan);
    }

    private void opPriorities() {
        clearScreen();
        listener.printPriorities();
        System.out.println("");
        ConsoleScanner.pressEnter(this.scan);
    }

    // OBSERVADOR
    @Override
    public void printElement(Task t) {
        System.out.println(t);
    }
    
    @Override
    public void printNoElements() {
        System.out.println("No hay elementos.");
    }
    
    @Override
    public void updateList(Stream<Task> s) {}
    
    @Override
    public void updatePriorities(Stream<Task> s) {}

    @Override
    public void updateSize(int t) {
        this.size = t;
    }
}
