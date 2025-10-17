/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleadomvc.controller;

import empleadomvc.model.Empleado;
import empleadomvc.model.EmpleadoRepository;
import empleadomvc.view.ConsoleView;
import java.sql.SQLException;

/**
 *
 * @author jprof
 */
public class EmpleadoController {

    private ConsoleView console;
    private EmpleadoRepository repository;

    public EmpleadoController() {
        console = new ConsoleView();
        repository = new EmpleadoRepository();
    }

    public void loop() {
        boolean exit = false;
        String option = null;

        while (!exit) {
            option = console.showMainMenu();

            switch (option) {
                case "LIST":
                    this.list();
                    break;
                case "INSERT":
                    this.insert();
                    break;
                case "EXIT":
                    exit = true;
                    break;
            }
        }

        console.close();
    }

    private void list() {
        try {
            this.console.list(this.repository.listAll());
        } catch (SQLException e) {
            System.err.println(
                    "Error obteniendo listado de empleados.\n" + e.getMessage()
            );
        }
    }

    private void insert() {
        String name;
        String salaryText;
        double salary;
        Empleado emp;

        // Recojo los datos faltantes (nombre y salario)
        name = console.askText("Introduzca el nombre.\n");
        salaryText = console.askText("Introduza el salario.\n");

        try {
            salary = Double.parseDouble(salaryText);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Error intentando crear el empleado.");
        }

        // Creo el empleado
        try {
            repository.insert(
                    Empleado.builder()
                            .nombre(name)
                            .salario(salary)
                            .build()
            );
        } catch (SQLException e) {
            throw new RuntimeException(
                    "Error insertando un empleado.\n" + e.getMessage());
        }
    }

}
