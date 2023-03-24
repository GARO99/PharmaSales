package DAO;
import Config.ConnectionDb;
import Models.Customers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author PERSONAL
 */
public class CustomersDAO {
    ConnectionDb cn = new ConnectionDb();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public ArrayList<Customers> getCustomers(){
        Customers ct;
        ArrayList<Customers> cts = new ArrayList<Customers>();
        String query = "SELECT * FROM Customers";
        
        try {
            con = cn.GetConnection();
            ps = con.prepareStatement(query);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                ct = new Customers();
                ct.setIDENTIFICATION_NUMBER_CUSTOMER(rs.getString("IDENTIFICATION_NUMBER_CUSTOMER"));
                ct.setFK_ID_IDENTIFICATION_TYPE(rs.getInt("FK_ID_IDENTIFICATION_TYPE"));
                ct.setFIRSTNAME(rs.getString("FIRSTNAME"));
                ct.setLASTNAME(rs.getString("LASTNAME"));
                ct.setADDRESS(rs.getString("ADDRESS"));
                ct.setPHONE(rs.getString("PHONE"));
                cts.add(ct);
            }
        } catch(Exception e){
            System.out.println(e);
        }
        
        return cts;
    }
    
}
