package Models;

/**
 *
 * @author PERSONAL
 */
public class Users {
    int ID_USERS;
    String EMAIL;
    String USERNAME;
    String PASSWORD;
    String FK_IDENTIFICATION_NUMBER_EMPLOYEE;

    public Users() {
    }

    public Users(int ID_USERS, String EMAIL, String USERNAME, String PASSWORD, String FK_IDENTIFICATION_NUMBER_EMPLOYEE) {
        this.ID_USERS = ID_USERS;
        this.EMAIL = EMAIL;
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
        this.FK_IDENTIFICATION_NUMBER_EMPLOYEE = FK_IDENTIFICATION_NUMBER_EMPLOYEE;
    }

    public int getID_USERS() {
        return ID_USERS;
    }

    public void setID_USERS(int ID_USERS) {
        this.ID_USERS = ID_USERS;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getFK_IDENTIFICATION_NUMBER_EMPLOYEE() {
        return FK_IDENTIFICATION_NUMBER_EMPLOYEE;
    }

    public void setFK_IDENTIFICATION_NUMBER_EMPLOYEE(String FK_IDENTIFICATION_NUMBER_EMPLOYEE) {
        this.FK_IDENTIFICATION_NUMBER_EMPLOYEE = FK_IDENTIFICATION_NUMBER_EMPLOYEE;
    }
    
    
}
