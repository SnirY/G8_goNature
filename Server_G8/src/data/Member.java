package data;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Represents a member of the system.
 * Contains information about the member, such as name, contact details, and payment status.
 * Implements Serializable for object serialization.
 * 
 * @author Netanel
 */
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;
    private String memberID;
    private String memberFirstName;
    private String memberLastName;
    private String memberPhoneNumber;
    private String memberEmail;
    private String memberPaymentType; // "Yes" indicates having a credit card, "No" otherwise
    private OrderType memberOrderType;
    private String memberAmount;

    /**
     * Constructs a Member object from database records.
     * 
     * @param memberFromDB ArrayList containing member information fetched from the database.
     */
    public Member(ArrayList<String> memberFromDB) {
        this.memberID = memberFromDB.get(0);
        this.memberFirstName = memberFromDB.get(1);
        this.memberLastName = memberFromDB.get(2);
        this.memberPhoneNumber = memberFromDB.get(3);
        this.memberEmail = memberFromDB.get(4);
        this.memberPaymentType = memberFromDB.get(5);
        this.memberOrderType = OrderType.valueOf(memberFromDB.get(6).toUpperCase());
        this.memberAmount = memberFromDB.get(7);
    }

    /**
     * Constructs a Member object with specified attributes.
     * 
     * @param memberID         The unique identifier of the member.
     * @param memberFirstName  The first name of the member.
     * @param memberLastName   The last name of the member.
     * @param memberPhoneNumber The phone number of the member.
     * @param memberEmail      The email address of the member.
     * @param memberOrderType  The type of orders the member places.
     * @param memberAmount     The total amount spent by the member.
     */
    public Member(String memberID, String memberFirstName, String memberLastName, String memberPhoneNumber,
            String memberEmail, OrderType memberOrderType, String memberAmount) {
        this.memberID = memberID;
        this.memberFirstName = memberFirstName;
        this.memberLastName = memberLastName;
        this.memberPhoneNumber = memberPhoneNumber;
        this.memberEmail = memberEmail;
        this.memberOrderType = memberOrderType;
        this.memberAmount = memberAmount;
        this.memberPaymentType = null;
    }

    /**
     * Returns the unique identifier of the member.
     * 
     * @return The member's ID.
     */
    public String getMemberID() {
        return memberID;
    }

    /**
     * Sets the unique identifier of the member.
     * 
     * @param memberID The member's ID to set.
     */
    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    /**
     * Returns the first name of the member.
     * 
     * @return The member's first name.
     */
    public String getMemberFirstName() {
        return memberFirstName;
    }

    /**
     * Sets the first name of the member.
     * 
     * @param memberFirstName The member's first name to set.
     */
    public void setMemberFirstName(String memberFirstName) {
        this.memberFirstName = memberFirstName;
    }

    /**
     * Returns the last name of the member.
     * 
     * @return The member's last name.
     */
    public String getMemberLastName() {
        return memberLastName;
    }

    /**
     * Sets the last name of the member.
     * 
     * @param memberLastName The member's last name to set.
     */
    public void setMemberLastName(String memberLastName) {
        this.memberLastName = memberLastName;
    }

    /**
     * Returns the phone number of the member.
     * 
     * @return The member's phone number.
     */
    public String getMemberPhoneNumber() {
        return memberPhoneNumber;
    }

    /**
     * Sets the phone number of the member.
     * 
     * @param memberPhoneNumber The member's phone number to set.
     */
    public void setMemberPhoneNumber(String memberPhoneNumber) {
        this.memberPhoneNumber = memberPhoneNumber;
    }

    /**
     * Returns the email address of the member.
     * 
     * @return The member's email address.
     */
    public String getMemberEmail() {
        return memberEmail;
    }

    /**
     * Sets the email address of the member.
     * 
     * @param memberEmail The member's email address to set.
     */
    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    /**
     * Returns the payment type of the member.
     * 
     * @return The member's payment type.
     */
    public String getMemberPaymentType() {
        return memberPaymentType;
    }

    /**
     * Sets the payment type of the member.
     * 
     * @param memberPaymentType The member's payment type to set.
     */
    public void setMemberPaymentType(String memberPaymentType) {
        this.memberPaymentType = memberPaymentType;
    }

    /**
     * Returns the order type of the member.
     * 
     * @return The member's order type.
     */
    public OrderType getMemberOrderType() {
        return memberOrderType;
    }

    /**
     * Sets the order type of the member.
     * 
     * @param memberOrderType The member's order type to set.
     */
    public void setMemberOrderType(OrderType memberOrderType) {
        this.memberOrderType = memberOrderType;
    }

    /**
     * Returns the amount spent by the member.
     * 
     * @return The total amount spent by the member.
     */
    public String getMemberAmount() {
        return memberAmount;
    }

    /**
     * Sets the amount spent by the member.
     * 
     * @param memberAmount The total amount spent by the member to set.
     */
    public void setMemberAmount(String memberAmount) {
        this.memberAmount = memberAmount;
    }

}
