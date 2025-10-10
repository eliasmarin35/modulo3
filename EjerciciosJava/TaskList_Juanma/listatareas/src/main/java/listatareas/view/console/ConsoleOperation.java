/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listatareas.view.console;

/**
 *
 * @author jadmin
 */
public enum ConsoleOperation {
    ADD("a"),
    POLL("s"),
    LIST("l"),
    PRIORITIES("p"),
    QUIT("q"),
    ERROR;

    private final String  code;
    private final boolean isError;

    ConsoleOperation(String c, boolean e) {
        this.code = c;
        this.isError = e;
    }
    
    ConsoleOperation(String c) {
        this(c,true);
    }
    
    ConsoleOperation() {
        this("",true);
    }
    
    public boolean isError() {
        return this.isError;
    }
    
    public static ConsoleOperation init() {
        return ConsoleOperation.ERROR;
    }
    
    public static ConsoleOperation parseOperation(String c) {
        ConsoleOperation op = ConsoleOperation.ERROR;

        c = c.trim().toLowerCase();

        for (ConsoleOperation o : ConsoleOperation.values()) {
            if (c.equals(o.code)) {
                op = o;
                break;
            }
        }

        return op;
    }
}
