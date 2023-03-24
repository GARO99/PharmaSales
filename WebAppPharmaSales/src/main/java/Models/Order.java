package Models;

/**
 *
 * @author PERSONAL
 */
public class Order {
    int ID_ORDER;
    String FK_IDENTIFICATION_NUMBER_EMPLOYEE;
    String FK_IDENTIFICATION_NUMBER_CUSTOMER;
    String DATE_ORDER;
    float SUBTOTAL;
    float TOTAL;

    public Order() {
    }

    public Order(int ID_ORDER, String FK_IDENTIFICATION_NUMBER_EMPLOYEE, String FK_IDENTIFICATION_NUMBER_CUSTOMER, String DATE_ORDER, float SUBTOTAL, float TOTAL) {
        this.ID_ORDER = ID_ORDER;
        this.FK_IDENTIFICATION_NUMBER_EMPLOYEE = FK_IDENTIFICATION_NUMBER_EMPLOYEE;
        this.FK_IDENTIFICATION_NUMBER_CUSTOMER = FK_IDENTIFICATION_NUMBER_CUSTOMER;
        this.DATE_ORDER = DATE_ORDER;
        this.SUBTOTAL = SUBTOTAL;
        this.TOTAL = TOTAL;
    }

    public int getID_ORDER() {
        return ID_ORDER;
    }

    public void setID_ORDER(int ID_ORDER) {
        this.ID_ORDER = ID_ORDER;
    }

    public String getFK_IDENTIFICATION_NUMBER_EMPLOYEE() {
        return FK_IDENTIFICATION_NUMBER_EMPLOYEE;
    }

    public void setFK_IDENTIFICATION_NUMBER_EMPLOYEE(String FK_IDENTIFICATION_NUMBER_EMPLOYEE) {
        this.FK_IDENTIFICATION_NUMBER_EMPLOYEE = FK_IDENTIFICATION_NUMBER_EMPLOYEE;
    }

    public String getFK_IDENTIFICATION_NUMBER_CUSTOMER() {
        return FK_IDENTIFICATION_NUMBER_CUSTOMER;
    }

    public void setFK_IDENTIFICATION_NUMBER_CUSTOMER(String FK_IDENTIFICATION_NUMBER_CUSTOMER) {
        this.FK_IDENTIFICATION_NUMBER_CUSTOMER = FK_IDENTIFICATION_NUMBER_CUSTOMER;
    }

    public String getDATE_ORDER() {
        return DATE_ORDER;
    }

    public void setDATE_ORDER(String DATE_ORDER) {
        this.DATE_ORDER = DATE_ORDER;
    }

    public float getSUBTOTAL() {
        return SUBTOTAL;
    }

    public void setSUBTOTAL(float SUBTOTAL) {
        this.SUBTOTAL = SUBTOTAL;
    }

    public float getTOTAL() {
        return TOTAL;
    }

    public void setTOTAL(float TOTAL) {
        this.TOTAL = TOTAL;
    }
    
    
}
