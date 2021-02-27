import java.util.Scanner;

public class Employee {

	protected String firstName;
	protected String lastName;
	protected int employeeID;
	protected double salary;
	Scanner input = new Scanner(System.in);
	
	//default constructor for employees
	public Employee() {
		firstName = null;
		lastName = null;
		employeeID = 0;
		salary = 0.0;
	}
	
	//sets employee's first name
	public void setFirstName() {
		System.out.println("Enter employee's first name: ");
		firstName = input.next();
	}
	
	//sets employee's last name
	public void setLastName() {
		System.out.println("Enter employee's last name: ");
		lastName = input.next();
	}
	
	//sets employee ID number
	public void setEmployeeID() {
		System.out.println("Enter employee's ID number: ");
		employeeID = input.nextInt();
	}
	
	//returns employee's first name
	public String getFirstName() {return firstName;}
	
	//returns employee's last name
	public String getLastName() {return lastName;}
	
	//returns employee ID number
	public int getEmployeeID() {return employeeID;}
	
	//prints employee information
	public void employeeSummary() {
		System.out.println("First name: " + firstName);
		System.out.println("Last name: " + lastName);
		System.out.println("Employee ID: " + employeeID);
	}
}
