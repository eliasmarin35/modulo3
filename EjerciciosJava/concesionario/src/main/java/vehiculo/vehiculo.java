/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehiculo;

/**
 *
 * @author Curso Desarrollo
 */
public class vehiculo {
    
    private String matricula;
    private int deposito;
    
    
    void repostar(){
        System.out.println("Tu vehiculo con matricula " + this.getMatricula() + " esta lleno ahora");
        this.setDeposito(100);
    }
    
    void consumir(int porcentaje){
        System.out.println("Esta consumiendo 10");
        this.setDeposito(this.getDeposito() - 10);
    }
    
    void imprimeEstado(){
        System.out.println("El nivel de conbustible " + this.getDeposito());
        
    }

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the deposito
     */
    public int getDeposito() {
        return deposito;
    }

    /**
     * @param deposito the deposito to set
     */
    public void setDeposito(int deposito) {
        this.deposito = deposito;
    }

    
    
}
