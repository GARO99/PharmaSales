package DAO;

import Config.ConnectionDb;
import Models.Order;
import Models.Order_Details;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

/**
 *
 * @author Gustavo Andres Romero Ordoñez
 */
public class OrderDAO {
    ConnectionDb cn = new ConnectionDb();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public int IdOrder(){
        int Id = 1;
        String query = "SELECT MAX(ID_ORDER) as ID FROM `order`;";
        try {
            con = cn.GetConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                Id = rs.getInt("ID");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return Id;
    }
    
    public void SaveOrder(Order order){
        String query =  "INSERT INTO `order`(`FK_IDENTIFICATION_NUMBER_EMPLOYEE`, `FK_IDENTIFICATION_NUMBER_CUSTOMER`, `DATE_ORDER`, `SUBTOTAL`, `TOTAL`) VALUES (?,?,?,?,?)";
        try {
            con = cn.GetConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, order.getFK_IDENTIFICATION_NUMBER_EMPLOYEE());
            ps.setString(2, order.getFK_IDENTIFICATION_NUMBER_CUSTOMER());
            ps.setDate(3, new Date(order.getDATE_ORDER().getTime()));
            ps.setFloat(4, order.getSUBTOTAL());
            ps.setFloat(5, order.getTOTAL());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void SaveDatailOrder(Order_Details detail){
        String query = "INSERT INTO `order_details`(`QUANTITY`, `COST`, `FK_ID_ORDER`, `FK_PRODUCT_CODE`) VALUES (?,?,?,?)";
        try {
            con = cn.GetConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, detail.getQUANTITY());
            ps.setFloat(2, detail.getCOST());
            ps.setInt(3, detail.getFK_ID_ORDER());
            ps.setString(4, detail.getFK_PRODUCT_CODE());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
