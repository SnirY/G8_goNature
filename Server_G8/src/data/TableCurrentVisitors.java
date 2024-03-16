package data;

/**
 * Represents the current visitors for a park.
 * This class holds information about the park's name, current number of visitors, and maximum number of visitors.
 * 
 * It provides methods to retrieve and update these values.
 * 
 * @author Netanel
 */
public class TableCurrentVisitors {
    private String parkNameVis;
    private String currentAmount;
    private String maxVisitors;

    /**
     * Constructs a TableCurrentVisitors object with the specified park name and current number of visitors.
     * 
     * @param parkName      The name of the park.
     * @param currentAmount The current number of visitors in the park.
     */
    public TableCurrentVisitors(String parkName, String currentAmount) {
        this.parkNameVis = parkName;
        this.currentAmount = currentAmount;
    }

    /**
     * Gets the name of the park.
     * 
     * @return The name of the park.
     */
    public String getParkNameVis() {
        return parkNameVis;
    }

    /**
     * Sets the name of the park.
     * 
     * @param parkName The name of the park.
     */
    public void setParkNameVis(String parkName) {
        this.parkNameVis = parkName;
    }

    /**
     * Gets the current number of visitors in the park.
     * 
     * @return The current number of visitors in the park.
     */
    public String getCurrentAmount() {
        return currentAmount;
    }

    /**
     * Sets the current number of visitors in the park.
     * 
     * @param currentAmount The current number of visitors in the park.
     */
    public void setCurrentAmount(String currentAmount) {
        this.currentAmount = currentAmount;
    }

    /**
     * Gets the maximum number of visitors allowed in the park.
     * 
     * @return The maximum number of visitors allowed in the park.
     */
    public String getMaxVisitors() {
        return maxVisitors;
    }

    /**
     * Sets the maximum number of visitors allowed in the park.
     * 
     * @param maxVisitors The maximum number of visitors allowed in the park.
     */
    public void setMaxVisitors(String maxVisitors) {
        this.maxVisitors = maxVisitors;
    }
}
