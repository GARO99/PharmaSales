package DAO;
import Config.ConnectionDb;
import Models.Employees;
import Models.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author PERSONAL
 */
public class UsersDAO {
    ConnectionDb cn = new ConnectionDb();
    Connection con;
    PreparedStatement psu;
    ResultSet rs;
    
    public Users validate(String USER, String PWD){
        Users us = new Users();
        String query = "SELECT * FROM USERS WHERE USERNAME=? AND PASSWORD=?";
        
        try {
            con = cn.GetConnection();
            psu = con.prepareStatement(query);
            
            psu.setString(1, USER);
            psu.setString(2, PWD);
            
            rs = psu.executeQuery();
            
            while (rs.next()) {
                us.setEMAIL(rs.getString("EMAIL"));
                us.setFK_IDENTIFICATION_NUMBER_EMPLOYEE(rs.getString("FK_IDENTIFICATION_NUMBER_EMPLOYEE"));
                us.setID_USERS(rs.getInt("ID_USERS"));
                us.setPASSWORD(rs.getString("PASSWORD"));
                us.setUSERNAME(rs.getString("USERNAME"));
            }
        } catch(Exception e){
            System.out.println(e);
        }
        
        return us;
    }
    
    
    public ArrayList<Users> getUsers(){
        Users us;
        ArrayList<Users> uss = new ArrayList<Users>();
        String query = "SELECT * FROM USERS";
        
        try {
            con = cn.GetConnection();
            psu = con.prepareStatement(query);
            
            rs = psu.executeQuery();
            while (rs.next()) {
                us = new Users();
                us.setEMAIL(rs.getString("EMAIL"));
                us.setFK_IDENTIFICATION_NUMBER_EMPLOYEE(rs.getString("FK_IDENTIFICATION_NUMBER_EMPLOYEE"));
                us.setID_USERS(rs.getInt("ID_USERS"));
                us.setPASSWORD(rs.getString("PASSWORD"));
                us.setUSERNAME(rs.getString("USERNAME"));
                uss.add(us);
            }
        } catch(Exception e){
            System.out.println(e);
        }
        
        return uss;
    }
    
    
}
