package DAO;
import Config.ConnectionDb;
import Models.Products;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author PERSONAL
 */
public class ProductsDAO {
    ConnectionDb cn = new ConnectionDb();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public ArrayList<Products> getProducts(){
        Products pt;
        ArrayList<Products> pts = new ArrayList<Products>();
        String query = "SELECT * FROM Products";
        
        try {
            con = cn.GetConnection();
            ps = con.prepareStatement(query);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                pt = new Products();
                pt.setPRODUCT_CODE(rs.getString("PRODUCT_CODE"));
                pt.setPRODUCT_NAME(rs.getString("PRODUCT_NAME"));
                pt.setSTOCKABLE(rs.getInt("STOCKABLE"));
                pt.setIVA_PERCENT(rs.getFloat("IVA_PERCENT"));
                pts.add(pt);
            }
        } catch(Exception e){
            System.out.println(e);
        }
        
        return pts;
    }
    
}
