package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gustavo Andres Romero Ordoñez
 */
public class ConnectionDb {

    Connection Connection;
    String Url = "jdbc:mysql://127.0.0.1:3306/PHARMASALES";
    String User = "root";
    String Password = "";

    public Connection GetConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.Connection = DriverManager.getConnection(Url, User, Password);
        } catch (ClassNotFoundException| SQLException ex){
        }

        return Connection;
    }
}
