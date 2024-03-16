package data;


/**
 * The EmailMessage class represents an email message and extends the Message class.
 * It contains information such as recipient, subject, and replied-to message.
 * 
 * @author netanel
 */
public class EmailMessage extends Message {
    private String to;
    private String subject;
    private EmailMessage repliedTo;

    /**
     * Constructs an EmailMessage object with the specified details.
     * 
     * @param to      The recipient of the email.
     * @param subject The subject of the email.
     * @param message The message content of the email.
     * @param order   The associated order object.
     */
    public EmailMessage(String to, String subject, String message, Order order) {
        super(message, order);
        this.to = to;
        this.subject = subject;
    }

    /**
     * Returns the content of the email message.
     * 
     * @return The formatted email content.
     */
    public String read() {
        return "To: " + to + "\n" + super.read();
    }

    /**
     * Creates and returns a reply email message.
     * 
     * @param to       The recipient of the reply email.
     * @param message  The content of the reply email.
     * @return         The reply email message.
     */
    public EmailMessage reply(String to, String message) {
        EmailMessage replyMsg = new EmailMessage(to, "Re: " + subject, message, this.getOrder());
        replyMsg.setRepliedTo(this);
        return replyMsg;
    }

    /**
     * Gets the email message to which this message is a reply.
     * 
     * @return The replied-to email message.
     */
    public EmailMessage getRepliedTo() {
        return repliedTo;
    }

    /**
     * Sets the email message to which this message is a reply.
     * 
     * @param repliedTo The replied-to email message to set.
     */
    public void setRepliedTo(EmailMessage repliedTo) {
        this.repliedTo = repliedTo;
    }

    /**
     * Gets the subject of the email.
     * 
     * @return The subject of the email.
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets the subject of the email.
     * 
     * @param subject The subject to set.
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Gets the recipient of the email.
     * 
     * @return The recipient of the email.
     */
    public String getTo() {
        return to;
    }
}
