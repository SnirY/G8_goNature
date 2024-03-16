package data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



/**
 * The Message class represents a message containing text, sent time, and attachments.
 * It is used as a base class for specific message types like EmailMessage.
 * 
 * @author Netanel
 */
public class Message {
    private String message;
    private Date sentTime;
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private ArrayList<Object> attachments;
    private Order order;

    /**
     * Constructs a Message object with the specified message content and associated order.
     * 
     * @param message The content of the message.
     * @param order   The associated order object.
     */
    public Message(String message, Order order) {
        setMessage(message);
        sentTime = new Date();
        this.order = order;
    }

    /**
     * Returns a formatted string representation of the message, including the sent time.
     * 
     * @return A string representing the message and sent time.
     */
    public String read() {
        return ("Sent time: " + formatter.format(sentTime) + "\n" + message + "\n");
    }

    /**
     * Gets the message content.
     * 
     * @return The message content.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message content.
     * 
     * @param message The message content to set.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the sent time of the message.
     * 
     * @return The sent time of the message.
     */
    public Date getSentTime() {
        return sentTime;
    }

    /**
     * Gets the formatted sent time of the message for database storage.
     * 
     * @return The formatted sent time of the message.
     */
    public String getSentTimeDB() {
        return formatter.format(sentTime);
    }

    /**
     * Calculates and returns the time limit for waitlist based on the sent time.
     * 
     * @return The time limit for waitlist.
     */
    public String getLimitForWaitlist() {
        return formatter.format(new Date(sentTime.getTime() + 60 * 60 * 1000)); // Send time plus 1 hour
    }

    /**
     * Calculates and returns the time limit for 24-hour period based on the sent time.
     * 
     * @return The time limit for 24-hour period.
     */
    public String getLimitFor24() {
        return formatter.format(new Date(sentTime.getTime() + 120 * 60 * 1000)); // Send time plus 2 hours
    }

    /**
     * Gets the attachments associated with the message.
     * 
     * @return The attachments associated with the message.
     */
    public ArrayList<Object> getAttachments() {
        return attachments;
    }

    /**
     * Sets the attachments associated with the message.
     * 
     * @param attachments The attachments to set.
     */
    public void setAttachments(ArrayList<Object> attachments) {
        this.attachments = attachments;
    }

    /**
     * Gets the order associated with the message.
     * 
     * @return The order associated with the message.
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Sets the order associated with the message.
     * 
     * @param order The order to set.
     */
    public void setOrder(Order order) {
        this.order = order;
    }
}
