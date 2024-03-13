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

/**
 * The mysqlConnection class provides methods for managing connections to a MySQL database.
 */
public class mysqlConnection {
    private static Connection con2 = null;
    private static boolean DBup = false;

    /**
     * Attempts to connect to the MySQL database using the provided connection details.
     * 
     * @param str An ArrayList containing the database connection details: [host, port, database name, username, password].
     * @return The Connection object if the connection is successful, null otherwise.
     */
    public static Connection connectToDB(ArrayList<String> str) {
        String dburl = "jdbc:mysql://" + str.get(0) + ":" + str.get(1) + "/" + str.get(2) + "?serverTimezone=IST";
        String username = str.get(3);
        String password = str.get(4);

        try {
            con2 = DriverManager.getConnection(dburl, username, password);
            setMsg("DB " + str.get(2) + " Connected successfully on port " + str.get(1));
            DBup = true;
        } catch (SQLException e) {
            setMsg("Could not connect to DB");
            e.printStackTrace();
        }
        return con2;
    }

    /**
     * Creates the Employee table in the database.
     * 
     * @param con The Connection object.
     */
    public static void createTableEmployee(Connection con) {
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate("CREATE TABLE Employee(firstName VARCHAR(6), lastName VARCHAR(7), ID VARCHAR(20), role VARCHAR(20), email VARCHAR(20));");
        } catch(SQLException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Inserts an employee record into the Employee table.
     * 
     * @param con       The Connection object.
     * @param firstName The first name of the employee.
     * @param lastName  The last name of the employee.
     * @param id        The ID of the employee.
     * @param role      The role of the employee.
     * @param email     The email of the employee.
     */
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
                System.out.println("Success");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints the records from the Employee table.
     * 
     * @param con The Connection object.
     */
    public static void printEmployees(Connection con) {
        Statement stmt;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Employee;");
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5));
            }
            rs.close();
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets a message.
     * 
     * @param msg The message to be set.
     */
    private static void setMsg(String msg) {
        // This method is not implemented
    }

    /**
     * Saves traveler details to the database.
     * 
     * @param con            The Connection object.
     * @param studentDetails The details of the traveler.
     */
    public static void saveTravellerToDB(Connection con, ArrayList<String> studentDetails) {
        PreparedStatement preparedStatement;
        Iterator<String> detailsIterator = studentDetails.iterator();
        String firstName = detailsIterator.next();
        String lastName = detailsIterator.next();
        String ID = detailsIterator.next();
        String role = detailsIterator.next();
        String email = detailsIterator.next();
        try {
            preparedStatement = con.prepareStatement("INSERT INTO Employee VALUES(?, ?, ?, ?, ?);");
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, ID);
            preparedStatement.setString(4, role);
            preparedStatement.setString(5, email);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Disconnects from the database.
     */
    public static void disconnectFromDB() {
        try {
            if (con2 != null) {
                con2.close();
                System.out.println("Disconnected from DB successfully");
                DBup = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks if the database connection is up.
     * 
     * @return True if the database connection is up, false otherwise.
     */
    public static boolean isDBup() {
        return DBup;
    }
    /**
     * Returns the connection to the database.
     *
     * @return The Connection object.
     */
    public static Connection getConnection() {
        return con2;
    }

}
