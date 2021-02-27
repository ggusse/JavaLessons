import java.text.DecimalFormat;

public class Student {

	//instantiate variables
	private double GPA;
	public String name = null;
	public String address = null;
	DecimalFormat df = new DecimalFormat("#.00");
	
	//class constructor
	public Student() {
		GPA = -1.0;
		name = "";
		address = "";
	}
	
	//parameterized constructor
	public Student(double newGPA, String newN, String newA) {
		this.GPA = newGPA;
		this.name = newN;
		this.address = newA;
	}
	
	//set methods for local variables
	public void setGPA(double newGPA) {
		this.GPA = newGPA;
	}
	public void setName(String newName) {
		this.name = newName;
	}
	public void setAddress(String newAddress) {
		this.address = newAddress;
	}
	
	//get methods for local variables
	public double getGPA() {return this.GPA;}
	public String getName() {return this.name;}
	public String getAddress() {return this.address;}
	
	//overrides the toString method
	@Override
	public String toString() {
		return "Student Name: " + this.getName() + ", Address: "
				+ this.getAddress() + ", GPA: "
				+ df.format(this.getGPA());
	}
}