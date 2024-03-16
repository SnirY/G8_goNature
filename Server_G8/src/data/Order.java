package data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents an order made by a visitor.
 * This class encapsulates details of the order, such as visitor information, order type, price, etc.
 * Implements Serializable for object serialization.
 * 
 * @author Netanel
 */
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    private int visitorsNumber;
    private String orderEmail;
    private String orderPhone;
    private OrderType orderType;
    private double price; // before discount
    private double totalPrice; // after discount
    private String parkName;
    private String arrivedTime;
    private String memberId;
    private String ID;
    private int amountArrived;
    private int orderNumber;

    /**
     * Default constructor.
     * Constructs an empty Order object.
     */
    public Order() {
        // Default constructor
    }

    /**
     * Constructs an Order object for park employees to record visitor arrivals.
     * 
     * @param parkName The name of the park.
     * @param arrivedTime The time of arrival.
     * @param memberId The ID of the member.
     * @param ID The unique order ID.
     * @param amountArrived The number of visitors arrived.
     */
    public Order(String parkName, String arrivedTime, String memberId, String ID, int amountArrived) {
        this.parkName = parkName;
        this.arrivedTime = arrivedTime;
        this.amountArrived = amountArrived;
        this.memberId = memberId;
        this.ID = ID;
        this.orderEmail = null;
        this.orderPhone = null;
    }

    /**
     * Constructs an Order object for order creation.
     * 
     * @param visitorsNumber The number of visitors.
     * @param orderEmail The email associated with the order.
     * @param orderPhone The phone number associated with the order.
     * @param parkName The name of the park.
     * @param arrivedTime The time of arrival.
     * @param memberId The ID of the member.
     * @param ID The unique order ID.
     */
    public Order(int visitorsNumber, String orderEmail, String orderPhone, String parkName, String arrivedTime,
            String memberId, String ID) {
        this.visitorsNumber = visitorsNumber;
        this.orderEmail = orderEmail;
        this.orderPhone = orderPhone;
        this.parkName = parkName;
        this.arrivedTime = arrivedTime;
        this.memberId = memberId;
        this.ID = ID;
    }

    /**
     * Constructs an Order object from data retrieved from the database.
     * 
     * @param orderFromDB ArrayList of strings containing order data from the database.
     */
    public Order(ArrayList<String> orderFromDB) {
        this.visitorsNumber = Integer.parseInt(orderFromDB.get(0));
        this.orderEmail = orderFromDB.get(1);
        this.orderPhone = orderFromDB.get(2);
        this.orderType = OrderType.valueOf(orderFromDB.get(3).toUpperCase());
        this.price = Double.parseDouble(orderFromDB.get(4));
        this.totalPrice = Double.parseDouble(orderFromDB.get(5));
        this.parkName = orderFromDB.get(6);
        this.arrivedTime = orderFromDB.get(7);
        this.memberId = orderFromDB.get(8);
        this.ID = orderFromDB.get(9);
        this.amountArrived = Integer.parseInt(orderFromDB.get(10));
        this.orderNumber = Integer.parseInt(orderFromDB.get(11));
    }

    // Getters and Setters with comments...

    /**
     * Get the number of visitors associated with the order.
     * 
     * @return The number of visitors.
     */
    public int getVisitorsNumber() {
        return visitorsNumber;
    }

    /**
     * Set the number of visitors associated with the order.
     * 
     * @param visitorsNumber The number of visitors.
     */
    public void setVisitorsNumber(int visitorsNumber) {
        this.visitorsNumber = visitorsNumber;
    }

    /**
     * Get the email associated with the order.
     * 
     * @return The email associated with the order.
     */
    public String getOrderEmail() {
        return orderEmail;
    }

    /**
     * Set the email associated with the order.
     * 
     * @param orderEmail The email associated with the order.
     */
    public void setOrderEmail(String orderEmail) {
        this.orderEmail = orderEmail;
    }

    /**
     * Get the phone number associated with the order.
     * 
     * @return The phone number associated with the order.
     */
    public String getOrderPhone() {
        return orderPhone;
    }

    /**
     * Set the phone number associated with the order.
     * 
     * @param orderPhone The phone number associated with the order.
     */
    public void setOrderPhone(String orderPhone) {
        this.orderPhone = orderPhone;
    }

    /**
     * Get the type of the order.
     * 
     * @return The order type.
     */
    public OrderType getOrderType() {
        return orderType;
    }

    /**
     * Set the type of the order.
     * 
     * @param orderType The order type.
     */
    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    /**
     * Get the price of the order before any discounts.
     * 
     * @return The price of the order.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set the price of the order before any discounts.
     * 
     * @param price The price of the order.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Get the total price of the order after applying discounts.
     * 
     * @return The total price of the order.
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Set the total price of the order after applying discounts.
     * 
     * @param totalPrice The total price of the order.
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Get the name of the park associated with the order.
     * 
     * @return The name of the park.
     */
    public String getParkName() {
        return parkName;
    }

    /**
     * Set the name of the park associated with the order.
     * 
     * @param parkName The name of the park.
     */
    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    /**
     * Get the time when the visitor arrived.
     * 
     * @return The time of arrival.
     */
    public String getArrivedTime() {
        return arrivedTime;
    }

    /**
     * Set the time when the visitor arrived.
     * 
     * @param arrivedTime The time of arrival.
     */
    public void setArrivedTime(String arrivedTime) {
        this.arrivedTime = arrivedTime;
    }

    /**
     * Get the member ID associated with the order.
     * 
     * @return The member ID.
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * Set the member ID associated with the order.
     * 
     * @param memberId The member ID.
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    /**
     * Get the unique ID of the order.
     * 
     * @return The order ID.
     */
    public String getID() {
        return ID;
    }

    /**
     * Set the unique ID of the order.
     * 
     * @param iD The order ID.
     */
    public void setID(String iD) {
        ID = iD;
    }

    /**
     * Get the amount of visitors who arrived.
     * 
     * @return The amount of visitors arrived.
     */
    public int getAmountArrived() {
        return amountArrived;
    }

    /**
     * Set the amount of visitors who arrived.
     * 
     * @param amountArrived The amount of visitors arrived.
     */
    public void setAmountArrived(int amountArrived) {
        this.amountArrived = amountArrived;
    }

    /**
     * Get the order number.
     * 
     * @return The order number.
     */
    public int getOrderNumber() {
        return orderNumber;
    }

    /**
     * Set the order number.
     * 
     * @param orderNumber The order number.
     */
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * Convert order details to a string format suitable for database insertion.
     * 
     * @return The order details string.
     */
    public String toStringForDB() {
        String afterDiscount = Double.toString(getTotalPrice());
        String beforeDiscount = Double.toString(getPrice());
        return "'" + getVisitorsNumber() + "','" + getOrderEmail() + "','" + getOrderPhone() + "','"
                + getOrderType().toString() + "','" + beforeDiscount + "','" + afterDiscount + "','" + getParkName()
                + "','" + getArrivedTime() + "','" + getMemberId() + "','" + getID() + "','" + getAmountArrived()
                + "','" + getOrderNumber() + "'";
    }

    /**
     * Get a string representation of the order for displaying details to the user.
     * 
     * @return A string representing the order details.
     */
    public String messageString() {
        String details = "\n\tOrder Details:\n" + "Order Number:\t" + getOrderNumber() + "\nPark:\t\t\t" + getParkName()
                + "\nDate & Time:\t" + getArrivedTime() + "\nVisitors:\t\t" + getVisitorsNumber() + "\n\nPrice:\t\t"
                + getPrice() + "₪" + "\nDiscount:\t" + ((getPrice() - getTotalPrice()) / getPrice()) + "%"
                + "\nTotal:\t\t" + getTotalPrice() + "₪" + "\n\nID:\t" + getID() + "\nContact Details:\t"
                + getOrderEmail() + "\t" + getOrderPhone();
        return details;
    }

    /**
     * Check if the order is made by an occasional visitor (non-member).
     * 
     * @return True if the order is made by an occasional visitor, otherwise false.
     */
    public boolean isOccasional() {
        return orderEmail == null && orderPhone == null;
    }

}
