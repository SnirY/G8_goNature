package mySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class mysqlConnection {
	
	public static void main(String[] args) 
	{
//		Scanner scanner = new Scanner(System.in);
		//Connect to mySQL Connection Drive
		try 
		{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            System.out.println("Driver definition succeed");
        } catch (Exception ex) {
        	/* handle the error*/
        	 System.out.println("Driver definition failed");
         }
//        
//        try 
//        {
//            Connection connectionSQL = DriverManager.getConnection("jdbc:mysql://localhost/dbtest?serverTimezone=IST","root","Aa12345");
//            System.out.println("goNature SQL connection succeed");
//            //createTableFlights(conn);
//            //printFlights(conn);
//            //updateArrivalTimeForFlightKU101(conn);
//            //printFlights(conn);
//            //updateArrivalTimeForFlightFromParis(conn);
//            printFlights(connectionSQL);
//            //updateArrivalTimeForSeveralFlightsManually(conn, scanner);
//            //printFlights(conn);
//     	} catch (SQLException ex) 
//     	    {/* handle any errors*/
//            System.out.println("SQLException: " + ex.getMessage());
//            System.out.println("SQLState: " + ex.getSQLState());
//            System.out.println("VendorError: " + ex.getErrorCode());
//        }
//        scanner.close();
		
//		String url = "jdbc:mysql://localhost:3306/dbtest?serverTimezone=IST";
//        String user = "root";
//        String password = "Aa12345";
//        try {
//        	Connection con = DriverManager.getConnection(url, user, password);
//            //createTableEmployee(con);
//        	insertEmployee(con,"Snir", "Yehuda", "308450154", "CEO", "snir@gmail.com");
//        	System.out.println("goNature SQL connection succeed");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
   	}
	
	public static void createTableEmployee(Connection con) {
        try {
            // Your table creation code
            Statement statement = con.createStatement();
            statement.executeUpdate("CREATE TABLE Employee(firstName VARCHAR(6), lastName VARCHAR(7), ID VARCHAR(20), role VARCHAR(20), email VARCHAR(20));");
        } catch(SQLException exception) {
            exception.printStackTrace();
        }
    }
	
	public static void insertEmployee(Connection con, String firstName, String lastName, String id, String role, String email) {
String sql = "INSERT INTO Employee (firstName, lastName, ID, role, email) VALUES (?, ?, ?, ?, ?)";

try {
PreparedStatement statement = con.prepareStatement(sql);

if (firstName != null) {
statement.setString(1, firstName);
} else {
statement.setNull(1, Types.VARCHAR);
}

if (lastName != null) {
statement.setString(2, lastName);
} else {
statement.setNull(2, Types.VARCHAR);
}

if (id != null) {
statement.setString(3, id);
} else {
statement.setNull(3, Types.VARCHAR);
}

if (role != null) {
statement.setString(4, role);
} else {
statement.setNull(4, Types.VARCHAR);
}

if (email != null) {
statement.setString(5, email);
} else {
statement.setNull(5, Types.VARCHAR);
}

int rowsInserted = statement.executeUpdate();
if (rowsInserted > 0) {
System.out.println("succase");
}
} catch (SQLException e) {
e.printStackTrace();
}
}
	
	
	
	public static void printFlights(Connection con)
	{
		Statement stmt;
		try 
		{
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Employee;");
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
			statement.executeUpdate("CREATE TABLE Employee(firstName VARCHAR(6), lastName VARCHAR(7), ID VARCHAR(20), role VARCHAR(20), email VARCHAR(20));");
			//statement.executeUpdate("load data local infile \"arrived_flights.txt\" into table Flights");
		} catch(SQLException exception) {
			exception.printStackTrace();
		}
	}
	
	public static void updateArrivalTimeForFlightKU101(Connection con) {
		Statement statement;
		try {
			statement = con.createStatement();
			statement.executeUpdate("UPDATE employee SET firstName = ? WHERE flight = \"KU101\";");
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


	public static Connection connectToDB() {
		String url = "jdbc:mysql://localhost:3306/dbtest?serverTimezone=IST";
        String user = "root";
        String password = "Aa12345";
        try {
        	Connection con = DriverManager.getConnection(url, user, password);
            //createTableEmployee(con);
        	System.out.println("goNature SQL connection succeed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return null;
	}

	public static void saveTravellerToDB(Connection con, ArrayList<String> studentDetails) {
		PreparedStatement preparedStatement;
		System.out.println(studentDetails);
		Iterator<String> detailsIterator = studentDetails.iterator();
	  	String firstName = detailsIterator.next();
	  	String lastName = detailsIterator.next();
	  	String ID = detailsIterator.next();
	  	String role = detailsIterator.next();
	  	String email = detailsIterator.next();
		try {
				preparedStatement = con.prepareStatement("INSERT INTO Emlpoyee VALUES(?, ?, ?, ?, ?);");
				preparedStatement.setString(1, firstName);
				preparedStatement.setString(2, lastName);
				preparedStatement.setString(3, ID);
				preparedStatement.setString(4, role);
				preparedStatement.setString(4, email);
				preparedStatement.executeUpdate();
		} catch(SQLException exception) {
			exception.printStackTrace();
		}
	}


	
}
