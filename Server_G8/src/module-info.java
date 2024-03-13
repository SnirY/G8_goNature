/**
 * 
 */
/**
 * 
 */
module Server_G8 {
	requires java.sql;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.controls;
	requires mysql.connector.java;
	
	
	exports server;
	exports mySQL;
    exports gui;
    opens gui to javafx.fxml;
    
}