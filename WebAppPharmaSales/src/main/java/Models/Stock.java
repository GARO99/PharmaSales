package Models;

/**
 *
 * @author PERSONAL
 */
public class Stock {
    int ID_STOCK;
    int QUANTITY;
    String UPDATE_AT;
    String FK_PRODUCT_CODE;

    public Stock() {
    }

    public Stock(int ID_STOCK, int QUANTITY, String UPDATE_AT, String FK_PRODUCT_CODE) {
        this.ID_STOCK = ID_STOCK;
        this.QUANTITY = QUANTITY;
        this.UPDATE_AT = UPDATE_AT;
        this.FK_PRODUCT_CODE = FK_PRODUCT_CODE;
    }

    public int getID_STOCK() {
        return ID_STOCK;
    }

    public void setID_STOCK(int ID_STOCK) {
        this.ID_STOCK = ID_STOCK;
    }

    public int getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(int QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    public String getUPDATE_AT() {
        return UPDATE_AT;
    }

    public void setUPDATE_AT(String UPDATE_AT) {
        this.UPDATE_AT = UPDATE_AT;
    }

    public String getFK_PRODUCT_CODE() {
        return FK_PRODUCT_CODE;
    }

    public void setFK_PRODUCT_CODE(String FK_PRODUCT_CODE) {
        this.FK_PRODUCT_CODE = FK_PRODUCT_CODE;
    }
    
    
}
