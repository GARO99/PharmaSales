package DAO;
import Config.ConnectionDb;
import Models.Employees;
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
    PreparedStatement psu;
    PreparedStatement pse;
    ResultSet rs;
    ResultSet rse;
    
    public Employees validate(String USER, String PWD){
        Employees em = new Employees();
        String query = "SELECT FK_IDENTIFICATION_NUMBER_EMPLOYEE FROM User WHERE USER=? AND PWD=?";
        String query2 = "SELECT * FROM Employee WHERE IDENTIFICATION_NUMBER_EMPLOYEE=? ";
        
        try {
            con = cn.GetConnection();
            psu = con.prepareStatement(query);
            pse = con.prepareStatement(query2);
            
            psu.setString(1, USER);
            psu.setString(2, PWD);
            
            rs = psu.executeQuery();
            
            pse.setString(1, rs.getString("FK_IDENTIFICATION_NUMBER_EMPLOYEE"));
            
            rse = pse.executeQuery();
            
            while (rs.next()) {
                em.setFIRSTNAME(rse.getString("FIRSTNAME"));
                em.setLASTNAME(rse.getString("LASTNAME"));
                em.setPHONE(rse.getString("PHONE"));
                em.setADDRESS(rse.getString("ADDRESS"));
                em.setIDENTIFICATION_NUMBER_EMPLOYEE(rse.getString("IDENTIFICATION_NUMBER_EMPLOYEE"));
                em.setFK_ID_IDENTIIFICATION_TYPE(rse.getShort("FK_ID_IDENTIIFICATION_TYPE"));
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
