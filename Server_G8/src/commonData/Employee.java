package commonData;

/**
 *  Create Employee
 *
 * @author Snir Yehuda
 */

public class Employee {
	//check
	private String firstName;
    private String lastName;
	private String employeeNumber;
    private String email;
    private String role;
    private int numberOfPark;
    private String username;
    private String password;
    
    public String getLastName() {
		return lastName;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getRole() {
		return role;
	}

	public int getNumberOfPark() {
		return numberOfPark;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

    public String getFirstName() {
        return firstName;
    }

}
