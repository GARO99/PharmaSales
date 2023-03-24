package Models;

/**
 *
 * @author PERSONAL
 */
public class Products {
    String PRODUCT_CODE;
    String PRODUCT_NAME;
    float IVA_PERCENT;
    int STOCKABLE;

    public Products() {
    }

    public Products(String PRODUCT_CODE, String PRODUCT_NAME, float IVA_PERCENT, int STOCKABLE) {
        this.PRODUCT_CODE = PRODUCT_CODE;
        this.PRODUCT_NAME = PRODUCT_NAME;
        this.IVA_PERCENT = IVA_PERCENT;
        this.STOCKABLE = STOCKABLE;
    }

    public String getPRODUCT_CODE() {
        return PRODUCT_CODE;
    }

    public void setPRODUCT_CODE(String PRODUCT_CODE) {
        this.PRODUCT_CODE = PRODUCT_CODE;
    }

    public String getPRODUCT_NAME() {
        return PRODUCT_NAME;
    }

    public void setPRODUCT_NAME(String PRODUCT_NAME) {
        this.PRODUCT_NAME = PRODUCT_NAME;
    }

    public float getIVA_PERCENT() {
        return IVA_PERCENT;
    }

    public void setIVA_PERCENT(float IVA_PERCENT) {
        this.IVA_PERCENT = IVA_PERCENT;
    }

    public int getSTOCKABLE() {
        return STOCKABLE;
    }

    public void setSTOCKABLE(int STOCKABLE) {
        this.STOCKABLE = STOCKABLE;
    }
    
    
    
}
