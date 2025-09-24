/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package avante.concesionario;
/**
 *
 * @author Curso Desarrollo
 */

/* Crear un proyecto con una clase padre y sus hjos :
clase : VEHICULO - matricula, deposito / getter y setter void repostar, void consumir(int porcentaje), void imprimeestado()
clases MOTOS COCHES TRACTOR
*/
public class Concesionario {

    public static void main(String[] args) {
        
        System.out.println("Hello Concesionario");
        coche miCoche = new coche("1234ABC",80);
        miCoche.consumir(35);
        vechiculo miVehiculo = new vehiculo("adasdadas", 40);
        
    }
}
