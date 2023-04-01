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
public class EmployeesDAO {
    ConnectionDb cn = new ConnectionDb();
    Connection con;
    PreparedStatement pse;
    ResultSet rs;
    
    public Employees validate(String USER, String PWD){
        Employees em = new Employees();
        Users us = new Users();
        UsersDAO udao = new UsersDAO();
        String fk_id;
        
        String query = "SELECT * FROM Employees WHERE IDENTIFICATION_NUMBER_EMPLOYEE=?";
        
        try {
            us = udao.validate(USER, PWD);
            fk_id = us.getFK_IDENTIFICATION_NUMBER_EMPLOYEE();
            
            con = cn.GetConnection();
            pse = con.prepareStatement(query);
            
            pse.setString(1, fk_id);
            
            rs = pse.executeQuery();
            
            while (rs.next()) {
                em.setFIRSTNAME(rs.getString("FIRSTNAME"));
                em.setLASTNAME(rs.getString("LASTNAME"));
                em.setPHONE(rs.getString("PHONE"));
                em.setADDRESS(rs.getString("ADDRESS"));
                em.setIDENTIFICATION_NUMBER_EMPLOYEE(rs.getString("IDENTIFICATION_NUMBER_EMPLOYEE"));
                em.setFK_ID_IDENTIIFICATION_TYPE(rs.getShort("FK_ID_IDENTIFICATION_TYPE"));
            }
        } catch(Exception e){
            System.out.println(e);
        }
        
        return em;
    }
    
    
    public ArrayList<Employees> getEmployees(){
        Employees em;
        ArrayList<Employees> ems = new ArrayList<Employees>();
        String query = "SELECT * FROM Employees";
        
        try {
            con = cn.GetConnection();
            pse = con.prepareStatement(query);
            
            rs = pse.executeQuery();
            while (rs.next()) {
                em = new Employees();
                em.setFIRSTNAME(rs.getString("FIRSTNAME"));
                em.setLASTNAME(rs.getString("LASTNAME"));
                em.setPHONE(rs.getString("PHONE"));
                em.setADDRESS(rs.getString("ADDRESS"));
                em.setIDENTIFICATION_NUMBER_EMPLOYEE(rs.getString("IDENTIFICATION_NUMBER_EMPLOYEE"));
                em.setFK_ID_IDENTIIFICATION_TYPE(rs.getShort("FK_ID_IDENTIIFICATION_TYPE"));
                ems.add(em);
            }
        } catch(Exception e){
            System.out.println(e);
        }
        
        return ems;
    }
    
    
}
