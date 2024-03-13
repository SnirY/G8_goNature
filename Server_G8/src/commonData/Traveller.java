package commonData;

import java.time.LocalDateTime;

/**
 *  Create Traveller 
 *
 * @author Snir Yehuda
 */

public class Traveller {
	private String id;
    private String orderId;
    private String email;
    private String name;
    private String phoneNumber;
    private int numOfVisitors;
    private Park park;
    private Status status;
    private String arrivalDate;
    private LocalDateTime arrivalTime;
    private OrderType orderType;

    public void confirmOrder() {
        
    }

    public void cancelOrder() {
        
    }

    public void setTravelerInviterId(Traveller traveler) {
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
