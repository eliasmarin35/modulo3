/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package empleadomvc;

import empleadomvc.controller.EmpleadoController;
import empleadomvc.model.DriverDB;
import empleadomvc.model.Empleado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jprof
 */
public class App {
    public static void main(String[] args) {
        EmpleadoController controller = new EmpleadoController();
        controller.loop();
    }
}
