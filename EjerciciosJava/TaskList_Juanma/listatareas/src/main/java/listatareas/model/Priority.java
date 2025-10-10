/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listatareas.model;

/**
 *
 * @author jadmin
 */
public enum Priority {
    ALTA  ("alta",  "!"),
    MEDIA ("media", "+"),
    BAJA  ("baja",  "-");
    
    private final String descripcion;
    private final String simbolo;
    
    
    private Priority(String desc, String sim) {
        this.descripcion = desc;
        this.simbolo = sim;
    }

   
    // ======= GETTERS ========
    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @return the simbolo
     */
    public String getSimbolo() {
        return simbolo;
    }
}
