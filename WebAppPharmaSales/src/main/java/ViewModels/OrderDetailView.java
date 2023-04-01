package ViewModels;

/**
 *
 * @author Gustavo Andres Romero Ordoñez
 */
public class OrderDetailView {
    String FK_PRODUCT_CODE;
    String PRODUCT_NAME;
    float PRICE;
    float IVA;
    int QUANTITY;
    float SUB_TOTAL;
    float TOTAL;

    public OrderDetailView() {
    }

    public OrderDetailView(String FK_PRODUCT_CODE, String PRODUCT_NAME, float PRICE, float IVA, int QUANTITY, float SUB_TOTAL, float TOTAL) {
        this.FK_PRODUCT_CODE = FK_PRODUCT_CODE;
        this.PRODUCT_NAME = PRODUCT_NAME;
        this.PRICE = PRICE;
        this.IVA = IVA;
        this.QUANTITY = QUANTITY;
        this.SUB_TOTAL = SUB_TOTAL;
        this.TOTAL = TOTAL;
    }

    

    public String getFK_PRODUCT_CODE() {
        return FK_PRODUCT_CODE;
    }

    public void setFK_PRODUCT_CODE(String FK_PRODUCT_CODE) {
        this.FK_PRODUCT_CODE = FK_PRODUCT_CODE;
    }

    public String getPRODUCT_NAME() {
        return PRODUCT_NAME;
    }

    public void setPRODUCT_NAME(String PRODUCT_NAME) {
        this.PRODUCT_NAME = PRODUCT_NAME;
    }

    public float getPRICE() {
        return PRICE;
    }

    public void setPRICE(float PRICE) {
        this.PRICE = PRICE;
    }

    public float getIVA() {
        return IVA;
    }

    public void setIVA(float IVA) {
        this.IVA = IVA;
    }

    public int getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(int QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    public float getTOTAL() {
        return TOTAL;
    }

    public void setTOTAL(float TOTAL) {
        this.TOTAL = TOTAL;
    }

    public float getSUB_TOTAL() {
        return SUB_TOTAL;
    }

    public void setSUB_TOTAL(float SUB_TOTAL) {
        this.SUB_TOTAL = SUB_TOTAL;
    }
    
    
}
