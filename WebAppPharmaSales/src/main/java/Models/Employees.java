package Models;

/**
 *
 * @author PERSONAL
 */
public class Employees {

    String IDENTIFICATION_NUMBER_EMPLOYEE;
    String FIRSTNAME;
    String LASTNAME;
    String PHONE;
    String ADDRESS;
    int FK_ID_IDENTIIFICATION_TYPE;

    public Employees() {
    }

    public Employees(String IDENTIFICATION_NUMBER_EMPLOYEE, String FIRSTNAME, String LASTNAME, String PHONE, String ADDRESS, int FK_ID_IDENTIIFICATION_TYPE) {
        this.IDENTIFICATION_NUMBER_EMPLOYEE = IDENTIFICATION_NUMBER_EMPLOYEE;
        this.FIRSTNAME = FIRSTNAME;
        this.LASTNAME = LASTNAME;
        this.PHONE = PHONE;
        this.ADDRESS = ADDRESS;
        this.FK_ID_IDENTIIFICATION_TYPE = FK_ID_IDENTIIFICATION_TYPE;
    }

    public String getIDENTIFICATION_NUMBER_EMPLOYEE() {
        return IDENTIFICATION_NUMBER_EMPLOYEE;
    }

    public void setIDENTIFICATION_NUMBER_EMPLOYEE(String IDENTIFICATION_NUMBER_EMPLOYEE) {
        this.IDENTIFICATION_NUMBER_EMPLOYEE = IDENTIFICATION_NUMBER_EMPLOYEE;
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

    public int getFK_ID_IDENTIIFICATION_TYPE() {
        return FK_ID_IDENTIIFICATION_TYPE;
    }

    public void setFK_ID_IDENTIIFICATION_TYPE(int FK_ID_IDENTIIFICATION_TYPE) {
        this.FK_ID_IDENTIIFICATION_TYPE = FK_ID_IDENTIIFICATION_TYPE;
    }

    public Object getUSER() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
