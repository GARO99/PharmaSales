package Models;

/**
 *
 * @author PERSONAL
 */
public class Identification_Type {
    int ID_IDENTIFICATION_TYPE;
    String DESCRIPTION;
    String ABBREVIATION;

    public Identification_Type() {
    }

    public Identification_Type(int ID_IDENTIFICATION_TYPE, String DESCRIPTION, String ABBREVIATION) {
        this.ID_IDENTIFICATION_TYPE = ID_IDENTIFICATION_TYPE;
        this.DESCRIPTION = DESCRIPTION;
        this.ABBREVIATION = ABBREVIATION;
    }

    public int getID_IDENTIFICATION_TYPE() {
        return ID_IDENTIFICATION_TYPE;
    }

    public void setID_IDENTIFICATION_TYPE(int ID_IDENTIFICATION_TYPE) {
        this.ID_IDENTIFICATION_TYPE = ID_IDENTIFICATION_TYPE;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getABBREVIATION() {
        return ABBREVIATION;
    }

    public void setABBREVIATION(String ABBREVIATION) {
        this.ABBREVIATION = ABBREVIATION;
    }
    
    
}
