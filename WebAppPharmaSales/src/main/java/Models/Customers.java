package Models;

/**
 *
 * @author PERSONAL
 */
public class Customers {
    String IDENTIFICATION_NUMBER_CUSTOMER;
    String FIRSTNAME;
    String LASTNAME;
    String PHONE;
    String ADDRESS;
    int FK_ID_IDENTIFICATION_TYPE;

    public Customers() {
    }

    public Customers(String IDENTIFICATION_NUMBER_CUSTOMER, String FIRSTNAME, String LASTNAME, String PHONE, String ADDRESS, int FK_ID_IDENTIFICATION_TYPE) {
        this.IDENTIFICATION_NUMBER_CUSTOMER = IDENTIFICATION_NUMBER_CUSTOMER;
        this.FIRSTNAME = FIRSTNAME;
        this.LASTNAME = LASTNAME;
        this.PHONE = PHONE;
        this.ADDRESS = ADDRESS;
        this.FK_ID_IDENTIFICATION_TYPE = FK_ID_IDENTIFICATION_TYPE;
    }

    public String getIDENTIFICATION_NUMBER_CUSTOMER() {
        return IDENTIFICATION_NUMBER_CUSTOMER;
    }

    public void setIDENTIFICATION_NUMBER_CUSTOMER(String IDENTIFICATION_NUMBER_CUSTOMER) {
        this.IDENTIFICATION_NUMBER_CUSTOMER = IDENTIFICATION_NUMBER_CUSTOMER;
    }

    public String getFIRSTNAME() {
        return FIRSTNAME;
    }

    public void setFIRSTNAME(String FIRSTNAME) {
        this.FIRSTNAME = FIRSTNAME;
    }

    public String getLASTNAME() {
        return LASTNAME;
    }

    public void setLASTNAME(String LASTNAME) {
        this.LASTNAME = LASTNAME;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public int getFK_ID_IDENTIFICATION_TYPE() {
        return FK_ID_IDENTIFICATION_TYPE;
    }

    public void setFK_ID_IDENTIFICATION_TYPE(int FK_ID_IDENTIFICATION_TYPE) {
        this.FK_ID_IDENTIFICATION_TYPE = FK_ID_IDENTIFICATION_TYPE;
    }
    
    
    
}
