package data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents a park with its attributes such as name, capacity, and entry price.
 * This class provides methods to create and manage parks.
 * Parks can have a maximum capacity of visitors and orders.
 * 
 * Each park object is serializable, allowing it to be stored and retrieved from files.
 * 
 * @author Netanel
 */
public class Park implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String name;
    private int maximumCapacityInPark = 0;
    private int currentAmount = 0;
    private int maxAmountOrders = 0;
    private int entryPrice;
    private double managerDiscount;

    /**
     * Constructs a Park object with the specified name, maximum amount of orders, 
     * maximum capacity in the park, and current amount of visitors.
     * 
     * @param name                  The name of the park.
     * @param maxAmountOrders       The maximum amount of orders allowed in the park.
     * @param maximumCapacityInPark The maximum capacity of visitors allowed in the park.
     * @param currentAmount         The current amount of visitors in the park.
     */
    public Park(String name, int maxAmountOrders, int maximumCapacityInPark, int currentAmount) {
        this.name = name;
        this.maxAmountOrders = maxAmountOrders;
        this.maximumCapacityInPark = maximumCapacityInPark;
        this.currentAmount = currentAmount;
        if (!check()) {
            System.out.println("Orders capacity is bigger than the Park Capacity!");
        }
    }

    /**
     * Constructs a Park object from data retrieved from a database.
     * 
     * @param parkFromDB The data retrieved from the database to construct the park.
     */
    public Park(ArrayList<String> parkFromDB) {
        this.name = parkFromDB.get(0);
        this.currentAmount = Integer.parseInt(parkFromDB.get(1));
        this.maximumCapacityInPark = Integer.parseInt(parkFromDB.get(2));
        this.maxAmountOrders = Integer.parseInt(parkFromDB.get(3));
        this.entryPrice = Integer.parseInt(parkFromDB.get(4));
        this.managerDiscount = Double.parseDouble(parkFromDB.get(5));
    }

    /**
     * Checks if the maximum amount of orders is smaller than the maximum capacity in the park.
     * 
     * @return True if the maximum amount of orders is smaller than the maximum capacity in the park, otherwise false.
     */
    public boolean check() {
        return maxAmountOrders <= maximumCapacityInPark;
    }

    /**
     * Gets the entry price of the park.
     * 
     * @return The entry price of the park.
     */
    public int getEntryPrice() {
        return entryPrice;
    }

    /**
     * Sets the entry price of the park.
     * 
     * @param entryPrice The entry price of the park.
     */
    public void setEntryPrice(int entryPrice) {
        this.entryPrice = entryPrice;
    }

    /**
     * Gets the manager discount for the park.
     * 
     * @return The manager discount for the park.
     */
    public double getManagerDiscount() {
        return managerDiscount;
    }

    /**
     * Sets the manager discount for the park.
     * 
     * @param managerDiscount The manager discount for the park.
     */
    public void setManagerDiscount(double managerDiscount) {
        this.managerDiscount = managerDiscount;
    }

    /**
     * Gets the maximum amount of orders allowed in the park.
     * 
     * @return The maximum amount of orders allowed in the park.
     */
    public int getMaxAmountOrders() {
        return maxAmountOrders;
    }

    /**
     * Sets the maximum amount of orders allowed in the park.
     * 
     * @param maxAmountOrders The maximum amount of orders allowed in the park.
     */
    public void setMaxAmountOrders(int maxAmountOrders) {
        this.maxAmountOrders = maxAmountOrders;
    }

    /**
     * Gets the maximum capacity of visitors allowed in the park.
     * 
     * @return The maximum capacity of visitors allowed in the park.
     */
    public int getMaximumCapacityInPark() {
        return maximumCapacityInPark;
    }

    /**
     * Sets the maximum capacity of visitors allowed in the park.
     * 
     * @param maximumCapacityInPark The maximum capacity of visitors allowed in the park.
     */
    public void setMaximumCapacityInPark(int maximumCapacityInPark) {
        this.maximumCapacityInPark = maximumCapacityInPark;
    }

    /**
     * Gets the name of the park.
     * 
     * @return The name of the park.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the park.
     * 
     * @param name The name of the park.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the current amount of visitors in the park.
     * 
     * @return The current amount of visitors in the park.
     */
    public int getCurrentAmount() {
        return currentAmount;
    }

    /**
     * Sets the current amount of visitors in the park.
     * 
     * @param currentAmount The current amount of visitors in the park.
     */
    public void setCurrentAmount(int currentAmount) {
        this.currentAmount = currentAmount;
    }
}
