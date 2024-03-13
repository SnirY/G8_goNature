package controllers;

import java.sql.SQLException;

import commonData.Order;
/**
 *  Create OrderController controller 
 *
 * @author Snir Yehuda
 */
public class OrderController {
	public String validateOrderGroupVisitDate(String date, String NumberOfPeopleInGroup) throws SQLException {
        
        return "";
    }

    public boolean createOrder(Order order) throws SQLException {
        
        return false;
    }

    public boolean cancelOrderId(int orderId) throws SQLException {
        
        return false;
    }

    public String getDetailsorderId(String orderId) throws SQLException {
        
        return "";
    }

    public Order updateOrderId(Order order) throws SQLException {
        
        return null;
    }

    public void sendReminderOrder(Order order) throws SQLException {
        
    }
}
