/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listatareas.view.console;

import listatareas.model.Priority;

/**
 *
 * @author jadmin
 */
public enum ConsolePriority {
    BAJA("0", Priority.BAJA),
    MEDIA("1", Priority.MEDIA),
    ALTA("2", Priority.ALTA),
    SALIR("q"),
    ERROR;
    
    private final String   code;
    private final Priority prio;

    ConsolePriority(String c, Priority p) {
        this.code = c;
        this.prio = p;
    }
    
    ConsolePriority(String c) {
        this(c,null);
    }
    
    ConsolePriority() {
        this(null);
    }
    
    public Priority getPriority() {
        return this.prio;
    }
    
    public static ConsolePriority parse(String s) {
        s = s.trim().toLowerCase();
        return switch (s) {
            case "0" -> ConsolePriority.BAJA;
            case "1" -> ConsolePriority.MEDIA;
            case "2" -> ConsolePriority.ALTA;
            case "q" -> ConsolePriority.SALIR;
            default  -> ConsolePriority.ERROR;
        };
    }
}
