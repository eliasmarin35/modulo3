package elias.pruebabd;

import java.sql.*;

public class PruebaBD {

    public static void main(String[] args) throws SQLException {
        
        //Configuramos conexion
        String url = "jdbc:postgresql://localhost:5432/academia";
        String usuario = "postgres";
        String contrasena = "1234";
        
        
        Connection conn = DriverManager.getConnection(url, usuario, contrasena);
        
        //Connection -> Statement
        Statement stmt = conn.createStatement();
        
        //SI ES CONSULTA SELECT : Statement -> Resulset
        String sql = "SELECT nombre FROM public.cursos";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {            
            String nom = rs.getString("nombre");
            System.out.println(nom);
        }
       //Consultas INSERT, UPDATE :  PreparedStatement
        
       
       //Finalización
       
       rs.close();
       stmt.close();
       conn.close();
    }
}
