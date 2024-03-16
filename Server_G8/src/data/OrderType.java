package data;

/**
 * Represents the type of an order, such as regular, member, or group.
 * This enum provides constants for different types of orders and their labels.
 * Each constant is associated with a label that represents the order type.
 * 
 * @author Netanel
 */
public enum OrderType {
    /**
     * Regular order type.
     * Represents an order made by a visitor who is not a member and not part of a group.
     */
    REGULAR("regular"),
    
    /**
     * Member order type.
     * Represents an order made by a member who has a membership.
     */
    MEMBER("member"),
    
    /**
     * Group order type.
     * Represents an order made by a group with a guide.
     */
    GROUP("group");

    /**
     * The label associated with the order type.
     */
    public final String label;

    /**
     * Constructs an OrderType enum constant with the specified label.
     * 
     * @param label The label representing the order type.
     */
    private OrderType(String label) {
        this.label = label;
    }

    /**
     * Returns the label associated with the order type.
     * 
     * @return The label representing the order type.
     */
    @Override
    public String toString() {
        return this.label;
    }
}
