package data;

import java.io.Serializable;
import javafx.scene.control.CheckBox;

/**
 * Represents a table view set containing information to display in a table.
 * This class includes details such as the park name, request type, request details, and a checkbox for marking.
 * 
 * This class implements Serializable to support serialization.
 * 
 * @author Netanel
 */
public class TableViewSet implements Serializable {

    private static final long serialVersionUID = 1L;
    private String reqType;
    private String reqDetails;
    private String parkName;
    private String idEmp;
    private CheckBox markCh;

    /**
     * Constructs a TableViewSet object with the specified park name, request type, and request details.
     * Initializes the checkbox with a default state.
     * 
     * @param parkName   The name of the park.
     * @param reqType    The type of request.
     * @param reqDetails The details of the request.
     */
    public TableViewSet(String parkName, String reqType, String reqDetails) {
        this.parkName = parkName;
        this.reqType = reqType;
        this.reqDetails = reqDetails;
        this.markCh = new CheckBox();
    }

    /**
     * Gets the name of the park.
     * 
     * @return The name of the park.
     */
    public String getParkName() {
        return parkName;
    }

    /**
     * Sets the name of the park.
     * 
     * @param parkName The name of the park.
     */
    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    /**
     * Gets the type of request.
     * 
     * @return The type of request.
     */
    public String getReqType() {
        return reqType;
    }

    /**
     * Sets the type of request.
     * 
     * @param reqType The type of request.
     */
    public void setReqType(String reqType) {
        this.reqType = reqType;
    }

    /**
     * Gets the details of the request.
     * 
     * @return The details of the request.
     */
    public String getReqDetails() {
        return reqDetails;
    }

    /**
     * Sets the details of the request.
     * 
     * @param reqDetails The details of the request.
     */
    public void setReqDetails(String reqDetails) {
        this.reqDetails = reqDetails;
    }

    /**
     * Gets the checkbox used for marking.
     * 
     * @return The checkbox used for marking.
     */
    public CheckBox getMarkCh() {
        return markCh;
    }

    /**
     * Sets the checkbox used for marking.
     * 
     * @param checkBox The checkbox used for marking.
     */
    public void setMarkCh(CheckBox checkBox) {
        this.markCh = checkBox;
    }

    /**
     * Gets the employee ID associated with the request.
     * 
     * @return The employee ID associated with the request.
     */
    public String getIdEmp() {
        return idEmp;
    }

    /**
     * Sets the employee ID associated with the request.
     * 
     * @param idEmp The employee ID associated with the request.
     */
    public void setIdEmp(String idEmp) {
        this.idEmp = idEmp;
    }
}
