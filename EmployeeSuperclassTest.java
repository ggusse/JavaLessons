import java.util.Scanner;

public class EmployeeSuperclassTest {
	
	public static void main(String[] args) {
		
		String userInput = "";
		Scanner input = new Scanner(System.in);
		Manager newManager = new Manager();
		Employee newEmployee = new Employee();
		
		do {
			//asks user to choose command
			System.out.println("Enter a command to continue (\"quit\" to quit, " +
					"\"employee\" to add a basic employee, \"manager\" to add a manager, "
					+ "or \"print\" to print the employee's information): ");
			userInput = input.next();
			
			//adds new employee object information
			if(userInput.equals("employee")) {
				newEmployee.setFirstName();
				newEmployee.setLastName();
				newEmployee.setEmployeeID();
			}
			
			//adds new manager object information
			else if(userInput.equals("manager")) {
				newManager.setFirstName();
				newManager.setLastName();
				newManager.setEmployeeID();
				newManager.setDepartment();
			}
			
			//checks whether basic employee or manager has been added and prints info
			else if(userInput.equals("print")) {
				if(newManager.getDepartment() != null) {newManager.employeeSummary();}
				else if(newEmployee.getFirstName() != null) {newEmployee.employeeSummary();}
				else {System.out.println("No employee has been added. Please add employee before printing.");}
			}
			
		} while(!userInput.equals("quit"));		
		
		input.close();
		System.out.println("Program was quit.");
	}
}
