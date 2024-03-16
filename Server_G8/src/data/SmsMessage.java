package data;


/**
 * Represents an SMS message, extending the Message class.
 * This class provides methods to create and manage SMS messages.
 * 
 * Each SMS message contains information about the recipient (to), the message content, and an optional reference to the original message it's replying to.
 * 
 * @author Netanel
 */
public class SmsMessage extends Message {
    private String to;
    private SmsMessage repliedTo;

    /**
     * Constructs an SmsMessege object with the specified recipient, message content, and order.
     * 
     * @param to       The recipient of the SMS message.
     * @param message  The content of the SMS message.
     * @param order    The associated order for the SMS message.
     */
    public SmsMessage(String to, String message, Order order) {
        super(message, order);
        this.to = to;
    }

    /**
     * Gets the recipient of the SMS message.
     * 
     * @return The recipient of the SMS message.
     */
    public String getTo() {
        return to;
    }

    /**
     * Sets the recipient of the SMS message.
     * 
     * @param to The recipient of the SMS message.
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * Reads the SMS message, including the recipient and message content.
     * 
     * @return The formatted string representation of the SMS message.
     */
    @Override
    public String read() {
        return "To: " + to + "\n" + super.read();
    }

    /**
     * Creates a return SMS message with the specified recipient and message content.
     * 
     * @param to       The recipient of the return SMS message.
     * @param message  The content of the return SMS message.
     * @return         The newly created return SMS message.
     */
    public SmsMessage replay(String to, String message) {
        SmsMessage replyMsg = new SmsMessage(to, message, this.getOrder());
        replyMsg.setRepliedTo(this);
        return replyMsg;
    }

    /**
     * Gets the SMS message that this message is replying to.
     * 
     * @return The SMS message that this message is replying to.
     */
    public SmsMessage getRepliedTo() {
        return repliedTo;
    }

    /**
     * Sets the SMS message that this message is replying to.
     * 
     * @param repliedTo The SMS message that this message is replying to.
     */
    public void setRepliedTo(SmsMessage repliedTo) {
        this.repliedTo = repliedTo;
    }
}
