import java.util.Scanner;

public class Manager extends Employee {

	private String department = null;
	Scanner input = new Scanner(System.in);
	
	//sets manager's department
	public void setDepartment() {
		System.out.println("Enter name of department this employee manages: ");
		department = input.next();
	}
	
	//returns manager's department
	public String getDepartment() {return department;}
	
	//prints manager's information
	@Override
	public void employeeSummary() {
		super.employeeSummary();
		System.out.println("Department: " + department);
	}
}
