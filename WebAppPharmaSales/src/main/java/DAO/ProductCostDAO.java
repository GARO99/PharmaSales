package DAO;

import Config.ConnectionDb;
import Models.Product_Cost;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author PERSONAL
 */
public class ProductCostDAO {

    ConnectionDb cn = new ConnectionDb();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public ArrayList<Product_Cost> getProductCosts() {
        Product_Cost pc;
        ArrayList<Product_Cost> pcs = new ArrayList<Product_Cost>();
        String query = "SELECT * FROM Product_cost";

        try {
            con = cn.GetConnection();
            ps = con.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                pc = new Product_Cost();
                pc.setID_PRODUCT_COST(rs.getInt("ID_PRODUCT_COST"));
                pc.setPRICE(rs.getFloat("PRICE"));
                pc.setSTART_DATE(rs.getDate("START_DATE"));
                pc.setEND_DATE(rs.getDate("END_DATE"));
                pc.setFK_PRODUCT_CODE(rs.getString("FK_PRODUCT_CODE"));
                pcs.add(pc);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return pcs;
    }

    public void addProductCost(
            String code,
            float price,
            Date beginDate,
            Date endDate) {

        String query = "INSERT INTO Product_cost (PRICE, `START_DATE`, END_DATE, FK_PRODUCT_CODE) VALUES (?, ?, ?, ?)";

        try {
            con = cn.GetConnection();
            ps = con.prepareStatement(query);

            ps.setFloat(1, price);
            ps.setDate(2, beginDate);
            ps.setDate(3, endDate);
            ps.setString(4, code);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
