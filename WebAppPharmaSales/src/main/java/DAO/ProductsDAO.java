package DAO;

import Config.ConnectionDb;
import Models.Products;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author PERSONAL
 */
public class ProductsDAO {

    ConnectionDb cn = new ConnectionDb();    
    ProductCostDAO pcdao = new ProductCostDAO();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public Products getProduct(String productCode){
        Products product = new Products();
        String query = "SELECT p.*, pc.PRICE FROM Products p\n" +
                        "INNER JOIN product_cost pc ON pc.FK_PRODUCT_CODE = p.PRODUCT_CODE\n" +
                        "WHERE p.PRODUCT_CODE = ? AND pc.END_DATE IS NULL";
        try {
            con = cn.GetConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, productCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                product.setPRODUCT_CODE(rs.getString("PRODUCT_CODE"));
                product.setPRODUCT_NAME(rs.getString("PRODUCT_NAME"));
                product.setIVA_PERCENT(rs.getFloat("IVA_PERCENT"));
                product.setSTOCKABLE(rs.getBoolean("STOCKABLE"));
                product.setPRICE(rs.getFloat("PRICE"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return product;
    }

    public ArrayList<Products> getProducts() {
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
                pt.setSTOCKABLE(rs.getBoolean("STOCKABLE"));
                pt.setIVA_PERCENT(rs.getFloat("IVA_PERCENT"));
                pts.add(pt);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return pts;
    }

    public void addProducts(
            String code,
            String name,
            float iva,
            float price,
            Date beginDate,
            Date endDate,
            boolean stockeable) {

        String query = "INSERT INTO Products VALUES (?, ?, ?, ?)";

        try {
            con = cn.GetConnection();
            ps = con.prepareStatement(query);

            ps.setString(1, code);
            ps.setString(2, name);
            ps.setFloat(3, iva);
            ps.setBoolean(4, stockeable);

            ps.executeUpdate();
            
            pcdao.addProductCost(code, price, beginDate, endDate);
            
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
