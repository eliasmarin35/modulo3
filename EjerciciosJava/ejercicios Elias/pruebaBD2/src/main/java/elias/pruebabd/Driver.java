package elias.pruebabd;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.sql.*;


public class Driver {
    private final String url;
    private final String username;
    private final String pass;
    
    private static Driver instance = null;
    
    public static Driver getInstance() {
        if ( instance == null ) {
            instance = new Driver();
        }
        
        return instance;
    }
    
    private Driver() {
        // Leemos el fichero de propiedades
        Properties prop = new Properties();

        try (
            InputStream in = Driver.class.getClassLoader().getResourceAsStream("./config.properties");
        ) {
            prop.load(in);
        }
        catch (IOException e) {
            throw new RuntimeException("Error leyendo configuracion.\n"+e.getMessage());
        }
        
        // Cargamos las propiedades
        this.url = prop.getProperty("db.url");
        this.username = prop.getProperty("db.username");
        this.pass = prop.getProperty("db.password");
    }
    
    
    public Connection getConnection () throws SQLException {
        return DriverManager.getConnection(this.url, this.username, this.pass);
    }
    
    // OPCIONAL: método estático que da la conexión
    //     (nos ahorramos fuera el llamar a getInstance)
    public static Connection getConnectionStatic () throws SQLException {
        Driver drv = getInstance();
        return DriverManager.getConnection(drv.url, drv.username, drv.pass);
    }
}
