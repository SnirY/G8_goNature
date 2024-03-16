package data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents a request made by a park manager.
 * This class encapsulates various types of requests, such as changes in park capacity, discounts, etc.
 * Implements Serializable for object serialization.
 * 
 * @author Netanel
 */
public class ManagerRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private int employeeID;
    private String requestType; // {discount, max_c, max_o}
    private int maxCapacity;
    private int ordersCapacity;
    private String discount;
    private String fromDate;
    private String toDate;
    private String parkName;

    /**
     * Returns a string representation of the ManagerRequest object.
     * 
     * @return A string containing information about the request.
     */
    @Override
    public String toString() {
        return "ManagerRequest [employeeID=" + employeeID + ", requestType=" + requestType + ", maxCapacity="
                + maxCapacity + ", ordersCapacity=" + ordersCapacity + ", discount=" + discount + ", fromDate="
                + fromDate + ", toDate=" + toDate + ", parkName=" + parkName + "]";
    }

    /**
     * Constructs a ManagerRequest object with specified park name, employee ID, and request type.
     * 
     * @param parkName The name of the park associated with the request.
     * @param employeeID The ID of the park manager making the request.
     * @param requestType The type of request being made.
     */
    public ManagerRequest(String parkName, int employeeID, String requestType) {
        this.parkName = parkName;
        this.employeeID = employeeID;
        this.requestType = requestType;
    }

    /**
     * Constructs a ManagerRequest object from database records.
     * 
     * @param managerRequestFromDB ArrayList containing request information fetched from the database.
     */
    public ManagerRequest(ArrayList<String> managerRequestFromDB) {
        this.employeeID = Integer.parseInt(managerRequestFromDB.get(0));
        this.requestType = managerRequestFromDB.get(1);
        this.maxCapacity = Integer.parseInt(managerRequestFromDB.get(2));
        this.ordersCapacity = Integer.parseInt(managerRequestFromDB.get(3));
        this.discount = managerRequestFromDB.get(4);
        this.fromDate = managerRequestFromDB.get(5);
        this.toDate = managerRequestFromDB.get(6);
        this.parkName = managerRequestFromDB.get(7);
    }

    /**
     * Constructs a ManagerRequest object with specified attributes.
     * 
     * @param employeeID The ID of the park manager making the request.
     * @param requestType The type of request being made.
     * @param maxCapacity The maximum capacity of the park.
     * @param ordersCapacity The maximum capacity for orders.
     * @param discount The discount associated with the request.
     * @param fromDate The start date of the request validity.
     * @param toDate The end date of the request validity.
     * @param parkName The name of the park associated with the request.
     */
    public ManagerRequest(int employeeID, String requestType, int maxCapacity, int ordersCapacity, String discount,
            String fromDate, String toDate, String parkName) {
        this.employeeID = employeeID;
        this.requestType = requestType;
        this.maxCapacity = maxCapacity;
        this.ordersCapacity = ordersCapacity;
        this.discount = discount;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.parkName = parkName;
    }

    /**
     * Returns the employee ID associated with the request.
     * 
     * @return The employee ID.
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * Sets the employee ID associated with the request.
     * 
     * @param employeeID The employee ID to set.
     */
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * Returns the type of request.
     * 
     * @return The request type.
     */
    public String getRequestType() {
        return requestType;
    }

    /**
     * Sets the type of request.
     * 
     * @param requestType The request type to set.
     */
    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    /**
     * Returns the maximum capacity of the park.
     * 
     * @return The maximum capacity.
     */
    public int getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * Sets the maximum capacity of the park.
     * 
     * @param maxCapacity The maximum capacity to set.
     */
    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    /**
     * Returns the maximum capacity for orders.
     * 
     * @return The maximum orders capacity.
     */
    public int getOrdersCapacity() {
        return ordersCapacity;
    }

    /**
     * Sets the maximum capacity for orders.
     * 
     * @param ordersCapacity The maximum orders capacity to set.
     */
    public void setOrdersCapacity(int ordersCapacity) {
        this.ordersCapacity = ordersCapacity;
    }

    /**
     * Returns the discount associated with the request.
     * 
     * @return The discount.
     */
    public String getDiscount() {
        return discount;
    }

    /**
     * Sets the discount associated with the request.
     * 
     * @param discount The discount to set.
     */
    public void setDiscount(String discount) {
        this.discount = discount;
    }

    /**
     * Returns the start date of the request validity.
     * 
     * @return The start date.
     */
    public String getFromDate() {
        return fromDate;
    }

    /**
     * Sets the start date of the request validity.
     * 
     * @param fromDate The start date to set.
     */
    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    /**
     * Returns the end date of the request validity.
     * 
     * @return The end date.
     */
    public String getToDate() {
        return toDate;
    }

    /**
     * Sets the end date of the request validity.
     * 
     * @param toDate The end date to set.
     */
    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    /**
     * Returns the name of the park associated with the request.
     * 
     * @return The park name.
     */
    public String getParkName() {
        return parkName;
    }

    /**
     * Sets the name of the park associated with the request.
     * 
     * @param parkName The park name to set.
     */
    public void setParkName(String parkName) {
        this.parkName = parkName;
    }
}
