package mySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class mysqlConnection {
	
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		//Connect to mySQL Connection Drive
		try 
		{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            System.out.println("Driver definition succeed");
        } catch (Exception ex) {
        	/* handle the error*/
        	 System.out.println("Driver definition failed");
         }
        
        try 
        {
            Connection connectionSQL = DriverManager.getConnection("jdbc:mysql://localhost/gonature?serverTimezone=IST","root","Aa12345");
            System.out.println("goNature SQL connection succeed");
            createTableFlights(connectionSQL);
            //printFlights(conn);
            //updateArrivalTimeForFlightKU101(conn);
            //printFlights(conn);
            //updateArrivalTimeForFlightFromParis(conn);
            printFlights(connectionSQL);
            //updateArrivalTimeForSeveralFlightsManually(conn, scanner);
            //printFlights(conn);
     	} catch (SQLException ex) 
     	    {/* handle any errors*/
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        scanner.close();
   	}
	
	public static void printFlights(Connection con)
	{
		Statement stmt;
		try 
		{
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM gonature.order;");
	 		while(rs.next())
	 		{
				 // Print out the values
				 System.out.println(rs.getString(1)+ " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5));
			} 
			rs.close();
			System.out.println();
			//stmt.executeUpdate("UPDATE course SET semestr=\"W08\" WHERE num=61309");
		} catch (SQLException e) {e.printStackTrace();}
	}

	
	public static void createTableFlights(Connection con) {
		Statement statement;
		try {
			statement = con.createStatement();
			statement.executeUpdate("CREATE TABLE Flights(scheduled VARCHAR(6), flight VARCHAR(7), fromCity VARCHAR(20), delay VARCHAR(20), terminal INT);");
			statement.executeUpdate("load data local infile \"arrived_flights.txt\" into table Flights");
		} catch(SQLException exception) {
			exception.printStackTrace();
		}
	}
	
	public static void updateArrivalTimeForFlightKU101(Connection con) {
		Statement statement;
		try {
			statement = con.createStatement();
			statement.executeUpdate("UPDATE Flights SET scheduled = \"14:00\" WHERE flight = \"KU101\";");
		} catch(SQLException exception) {
			exception.printStackTrace();
		}
	}
	
	public static void updateArrivalTimeForFlightFromParis(Connection con) {
		Statement statement;
		try {
			statement = con.createStatement();
			statement.executeUpdate("UPDATE Flights SET scheduled = \"15:00\" WHERE fromCity = \"Paris\";");
		} catch(SQLException exception) {
			exception.printStackTrace();
		}
	}
	
	public static void updateArrivalTimeForSeveralFlightsManually(Connection con, Scanner scanner) {
		PreparedStatement preparedStatement;
		System.out.println();
		String scheduled, flight;
		try {
			for(int times = 0; times < 3; times++) {
				System.out.println("Please enter the new arrival time and flight:");
				scheduled = scanner.next();
				flight = scanner.next();
				preparedStatement = con.prepareStatement("UPDATE Flights SET scheduled = ? WHERE flight = ?;");
				preparedStatement.setString(1, scheduled);
				preparedStatement.setString(2, flight);
				preparedStatement.executeUpdate();
			}
		} catch(SQLException exception) {
			exception.printStackTrace();
		}
	}
	
}
