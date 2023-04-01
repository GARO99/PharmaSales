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
    
    public Customers getCustomer(String idNumber, String idType){
        Customers ct = new Customers();
        String query = "SELECT cu.*,it.ABBREVIATION as IDENTIFICATION_TYPE FROM Customers cu\n" +
                        "INNER JOIN identification_type it on it.ID_IDENTIFICATION_TYPE = cu.FK_ID_IDENTIFICATION_TYPE\n" +
                        "WHERE cu.IDENTIFICATION_NUMBER_CUSTOMER=? AND cu.FK_ID_IDENTIFICATION_TYPE=?";
        
        try {
            con = cn.GetConnection();
            ps = con.prepareStatement(query);
            
            ps.setString(1, idNumber);
            ps.setInt(2, Integer.parseInt(idType));
            
            rs = ps.executeQuery();
            while (rs.next()) {
                ct.setIDENTIFICATION_NUMBER_CUSTOMER(rs.getString("IDENTIFICATION_NUMBER_CUSTOMER"));
                ct.setIDENTIFICATION_TYPE(rs.getString("IDENTIFICATION_TYPE"));
                ct.setFK_ID_IDENTIFICATION_TYPE(rs.getInt("FK_ID_IDENTIFICATION_TYPE"));
                ct.setFIRSTNAME(rs.getString("FIRSTNAME"));
                ct.setLASTNAME(rs.getString("LASTNAME"));
                ct.setADDRESS(rs.getString("ADDRESS"));
                ct.setPHONE(rs.getString("PHONE"));
            }
        } catch(Exception e){
            System.out.println(e);
        }
        
        return ct;
    }
    
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
