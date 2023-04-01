package Models;

import java.sql.Date;

/**
 *
 * @author PERSONAL
 */
public class Product_Cost {
    int ID_PRODUCT_COST;
    float PRICE;
    Date START_DATE;
    Date END_DATE;
    String FK_PRODUCT_CODE;

    public Product_Cost() {
    }

    public Product_Cost(int ID_PRODUCT_COST, float PRICE, Date START_DATE, Date END_DATE, String FK_PRODUCT_CODE) {
        this.ID_PRODUCT_COST = ID_PRODUCT_COST;
        this.PRICE = PRICE;
        this.START_DATE = START_DATE;
        this.END_DATE = END_DATE;
        this.FK_PRODUCT_CODE = FK_PRODUCT_CODE;
    }

    public int getID_PRODUCT_COST() {
        return ID_PRODUCT_COST;
    }

    public void setID_PRODUCT_COST(int ID_PRODUCT_COST) {
        this.ID_PRODUCT_COST = ID_PRODUCT_COST;
    }

    public float getPRICE() {
        return PRICE;
    }

    public void setPRICE(float PRICE) {
        this.PRICE = PRICE;
    }

    public Date getSTART_DATE() {
        return START_DATE;
    }

    public void setSTART_DATE(Date START_DATE) {
        this.START_DATE = START_DATE;
    }

    public Date getEND_DATE() {
        return END_DATE;
    }

    public void setEND_DATE(Date END_DATE) {
        this.END_DATE = END_DATE;
    }

    public String getFK_PRODUCT_CODE() {
        return FK_PRODUCT_CODE;
    }

    public void setFK_PRODUCT_CODE(String FK_PRODUCT_CODE) {
        this.FK_PRODUCT_CODE = FK_PRODUCT_CODE;
    }
    
    
}
