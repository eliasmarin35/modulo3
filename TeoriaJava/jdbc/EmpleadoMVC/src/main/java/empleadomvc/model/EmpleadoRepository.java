/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleadomvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jprof
 */
public class EmpleadoRepository {

    public List<Empleado> listAll() throws SQLException {
        List<Empleado> list = new ArrayList<>();

        String sql = "SELECT id, nombre, salario FROM empleados;";

        DriverDB driver = DriverDB.getInstance();

        // Se crean los recursos
        Connection conn = driver.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        // Se recorre el ResultSet
        while (rs.next()) {
            list.add(new Empleado(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getDouble(3)
            ));
        }
        
        // Se cierran los recursos
        rs.close();
        stmt.close();
        conn.close();

        return list;
    }

    public void insert(Empleado e) throws SQLException { 
        DriverDB driver = DriverDB.getInstance();
        Connection conn = driver.getConnection();
        
        // PreparedStatement controla la conversion de valores para rellenar
        //     los parámetros plantilla y además precompila la sentencia
        //     con lo que es más eficiente, sobre todo si vamos a insertar
        //     más de un dato.
        PreparedStatement stmt = conn.prepareStatement(
            "INSERT INTO empleados (nombre, salario) VALUES (?,?);"
        );
        
        stmt.setString(1,e.getNombre());
        stmt.setDouble(2,e.getSalario());
        
        stmt.executeUpdate();
        
        stmt.close();
        conn.close();
    }
}
