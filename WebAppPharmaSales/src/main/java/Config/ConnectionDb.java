/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
            this.Connection = DriverManager.getConnection(Url, User, Password);
        } catch (SQLException ex){
        }
        
        return Connection;
    }
}
