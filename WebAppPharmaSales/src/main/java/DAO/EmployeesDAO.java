package DAO;
import Config.ConnectionDb;
import Models.Employees;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author PERSONAL
 */
public class EmployeesDAO {
    ConnectionDb cn = new ConnectionDb();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public Employees validate(String USER, String IDENTIFICATION_NUMBER_EMPLOYEE){
        Employees em = new Employees();
        String query = "SELECT * FROM Employee WHERE USER=? AND IDENTIFICATION_NUMBER_EMPLOYEE=?";
        
        try {
            con = cn.GetConnection();
            ps = con.prepareStatement(query);
            
            ps.setString(1, USER);
            ps.setString(2, IDENTIFICATION_NUMBER_EMPLOYEE);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                em.setFIRSTNAME(rs.getString("FIRSTNAME"));
                em.setLASTNAME(rs.getString("LASTNAME"));
                em.setPHONE(rs.getString("PHONE"));
                em.setUSER(rs.getString("USER"));
                em.setADDRESS(rs.getString("ADDRESS"));
                em.setIDENTIFICATION_NUMBER_EMPLOYEE(rs.getString("IDENTIFICATION_NUMBER_EMPLOYEE"));
                em.setFK_ID_IDENTIIFICATION_TYPE(rs.getShort("FK_ID_IDENTIIFICATION_TYPE"));
            }
        } catch(Exception e){
            
        }
        
        return em;
    }
    
}
