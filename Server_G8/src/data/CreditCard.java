package data;

import java.io.Serializable;

/**
 * The CreditCard creating CreditCard object
*
 *
 * @author Netanel
 */

/**
 * The CreditCard class represents a credit card object.
 */
public class CreditCard implements Serializable {

    /** Serial version UID for serialization. */
    private static final long serialVersionUID = 1L;

    /** The card number. */
    private String cardNumber;

    /** The card holder's name. */
    private String cardHolderName;

    /** The expiration date of the card. */
    private String expirationDate;

    /** The Card Verification Code (CVC) of the card. */
    private int cvc;

    /** The order number associated with the card. */
    private int orderNumber;

    /**
     * Constructs a CreditCard object with specified details.
     * 
     * @param cardNumber      The card number.
     * @param cardHolderName  The card holder's name.
     * @param expirationDate  The expiration date of the card.
     * @param cvc             The Card Verification Code (CVC).
     * @param orderNumber     The order number associated with the card.
     */
    public CreditCard(String cardNumber, String cardHolderName, String expirationDate, int cvc, int orderNumber) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expirationDate = expirationDate;
        this.cvc = cvc;
        this.orderNumber = orderNumber;
    }

    /**
     * Constructs a CreditCard object with specified details.
     * 
     * @param cardNumber      The card number.
     * @param cardHolderName  The card holder's name.
     * @param expirationDate  The expiration date of the card.
     * @param cvc             The Card Verification Code (CVC).
     */
    public CreditCard(String cardNumber, String cardHolderName, String expirationDate, int cvc) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expirationDate = expirationDate;
        this.cvc = cvc;
    }

    /**
     * Gets the order number associated with the card.
     * 
     * @return The order number.
     */
    public int getOrderNumber() {
        return orderNumber;
    }

    /**
     * Sets the order number associated with the card.
     * 
     * @param orderNumber The order number to set.
     */
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * Gets the card number.
     * 
     * @return The card number.
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets the card number.
     * 
     * @param cardNumber The card number to set.
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * Gets the card holder's name.
     * 
     * @return The card holder's name.
     */
    public String getCardHolderName() {
        return cardHolderName;
    }

    /**
     * Sets the card holder's name.
     * 
     * @param cardHolderName The card holder's name to set.
     */
    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    /**
     * Gets the expiration date of the card.
     * 
     * @return The expiration date.
     */
    public String getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the expiration date of the card.
     * 
     * @param expirationDate The expiration date to set.
     */
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * Gets the Card Verification Code (CVC) of the card.
     * 
     * @return The CVC.
     */
    public int getCvc() {
        return cvc;
    }

    /**
     * Sets the Card Verification Code (CVC) of the card.
     * 
     * @param cvc The CVC to set.
     */
    public void setCvc(int cvc) {
        this.cvc = cvc;
    }
}