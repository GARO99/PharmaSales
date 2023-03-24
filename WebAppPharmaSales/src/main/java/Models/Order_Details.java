package Models;

/**
 *
 * @author PERSONAL
 */
public class Order_Details {
    int ID_ORDER_DETAIL;
    int QUANTITY;
    float COST;
    int FK_ID_ORDER;
    String FK_PRODUCT_CODE;

    public Order_Details() {
    }

    public Order_Details(int ID_ORDER_DETAIL, int QUANTITY, float COST, int FK_ID_ORDER, String FK_PRODUCT_CODE) {
        this.ID_ORDER_DETAIL = ID_ORDER_DETAIL;
        this.QUANTITY = QUANTITY;
        this.COST = COST;
        this.FK_ID_ORDER = FK_ID_ORDER;
        this.FK_PRODUCT_CODE = FK_PRODUCT_CODE;
    }

    public int getID_ORDER_DETAIL() {
        return ID_ORDER_DETAIL;
    }

    public void setID_ORDER_DETAIL(int ID_ORDER_DETAIL) {
        this.ID_ORDER_DETAIL = ID_ORDER_DETAIL;
    }

    public int getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(int QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    public float getCOST() {
        return COST;
    }

    public void setCOST(float COST) {
        this.COST = COST;
    }

    public int getFK_ID_ORDER() {
        return FK_ID_ORDER;
    }

    public void setFK_ID_ORDER(int FK_ID_ORDER) {
        this.FK_ID_ORDER = FK_ID_ORDER;
    }

    public String getFK_PRODUCT_CODE() {
        return FK_PRODUCT_CODE;
    }

    public void setFK_PRODUCT_CODE(String FK_PRODUCT_CODE) {
        this.FK_PRODUCT_CODE = FK_PRODUCT_CODE;
    }
    
    
}
