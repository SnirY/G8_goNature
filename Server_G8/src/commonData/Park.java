package commonData;

import java.time.LocalDateTime;

/**
 *  Create Park 
 *
 * @author Snir Yehuda
 */

public class Park {
    private int parkID;
    private int maxParkCapacity;
    private int estimatedVisitTime;
    private int currentVisitors;

    public void updateMaxCapacity(int newCapacity) {
    	maxParkCapacity = newCapacity;
    }

    public void updateEstimatedVisitTime(int newVisitTime) {
    	estimatedVisitTime = newVisitTime;
    }

    /////throw DB?
    public boolean getAvailability(LocalDateTime time) {
    	int Availability = maxParkCapacity - currentVisitors; 
        if(Availability<=0) {
        	return false;
        }
        return true;
    }

    public int getNumberPark() {
    	return parkID;
    }

    public int getEstimatedPark() {
        return estimatedVisitTime;
    }

}