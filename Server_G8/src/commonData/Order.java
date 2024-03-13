package commonData;
/**
 *  Create Order 
 *
 * @author Snir Yehuda
 */
public class Order {
    private String orderId;
    private int numOfVisitors = 1;
    private Park park;
    private Status status;
    private Traveller traveller;
	private String arrivalDate;
    private String arrivalTime;
    private OrderType orderType;
    private String email;
    
    public Order(String orderId, int numOfVisitors, Park park, Status status, Traveller traveller, String email, 
    		OrderType orderType ,String arrivalTime, String arrivalDate){
    	
    	this.park=park;
    	this.orderType = orderType;
    	this.email = email;
    	this.orderId=orderId;
    	this.numOfVisitors=numOfVisitors;
    	this.traveller = traveller;
    	this.status = status;
    	this.arrivalDate = arrivalDate;
    	this.arrivalTime = arrivalTime;
    	
    }
    
    
    public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getNumOfVisitors() {
		return numOfVisitors;
	}

	public void setNumOfVisitors(int numOfVisitors) {
		this.numOfVisitors = numOfVisitors;
	}

	public Park getPark() {
		return park;
	}

	public void setPark(Park park) {
		this.park = park;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Traveller getTraveller() {
		return traveller;
	}

	public void setTraveller(Traveller traveller) {
		this.traveller = traveller;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}
    
    public void confirmOrder() {
    	
    }
    
    public void cancelOrder() {
    	
    }
    
    
    
}