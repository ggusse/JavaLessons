import java.util.Scanner;

public class Automobile {
	
	Scanner thisInput = new Scanner(System.in);
	private String make;
	private String model;
	private String color;
	private int year;
	private int mileage;
	
	public Automobile() {
		this.make = "unknown";
		this.model = "unknown";
		this.color = "unknown";
		this.year = 0;
		this.mileage = -1;
	}
	
	public Automobile(String autoMake, String autoModel, String autoColor, int autoYear, int autoMileage) {
		this.make = autoMake;
		this.model = autoModel;
		this.color = autoColor;
		this.year = autoYear;
		this.mileage = autoMileage;
	}
	
	private void setMake(String newMake) {
		this.make = newMake;
	}
	private void setModel(String newModel) {
		this.model = newModel;
	}
	private void setColor(String newColor) {
		this.color = newColor;
	}
	private void setYear(int newYear) {
		this.year = newYear;
	}
	private void setMileage(int newMileage) {
		this.mileage = newMileage;
	}
	
	private String getMake() {return this.make;}
	private String getModel() {return this.model;}
	private String getColor() {return this.color;}
	private int getYear() {return this.year;}
	private int getMileage() {return this.mileage;}
	
	
	public String[] arrayFormat() {
		return new String[] {"Make: " + this.getMake(),
				"Model: " + this.getModel(),
				"Color: " + this.getColor(),
				"Year: " + this.getYear(),
				"Mileage: " + this.getMileage()};
	}
	
	public String AddVehicle() {	
		System.out.println("Enter make of vehicle: ");
		setMake(thisInput.next());
		System.out.println("Enter model of vehicle: ");
		setModel(thisInput.next());
		System.out.println("Enter color of vehicle: ");
		setColor(thisInput.next());
		System.out.println("Enter year of vehicle: ");
		setYear(thisInput.nextInt());
		System.out.println("Enter current mileage of vehicle: ");
		setMileage(thisInput.nextInt());
		
		try {
			if(this.testDataEntry()) {
				return "Successfully added vehicle.";
			}
			else {throw new Exception("Not all fields were properly entered.");}
		} 
		catch(Exception excpt) {
			System.out.println(excpt.getMessage());
			return "Failed to add vehicle.";}
	}
	
	public String RemoveVehicle() {
		setMake("unknown");
		setModel("unknown");
		setColor("unknown");
		setYear(0);
		setMileage(-1);
		
		return "Successfully removed vehicle.";
	}
	
	public String UpdateVehicle() {
		String userInput = "";
		System.out.println("Type which field you would like to update: ");
		userInput = thisInput.next();
		
		try {
			if (userInput.equals("Make")) {
				System.out.println("Enter make of vehicle: ");
				setMake(thisInput.next());
				return "Successfully updated field.";
			}
			else if (userInput.equals("Model")) {
				System.out.println("Enter model of vehicle: ");
				setModel(thisInput.next());
				return "Successfully updated field.";
			}
			else if (userInput.equals("Color")) {
				System.out.println("Enter color of vehicle: ");
				setColor(thisInput.next());
				return "Successfully updated field.";
			}
			else if(userInput.equals("Year")) {
				System.out.println("Enter year of vehicle: ");
				setYear(thisInput.nextInt());
				return "Successfully updated field.";
			}
			else if(userInput.equals("Mileage")) {
				System.out.println("Enter current mileage of vehicle: ");
				setMileage(thisInput.nextInt());
				return "Successfully updated field.";
			}
			else {throw new Exception("Invalid command.");}
		}
		catch(Exception excpt) {
			System.out.println(excpt.getMessage());
			return "Failed to update field.";
		}
	}
	
	public boolean testDataEntry() {
		if(!this.getMake().equals("unknown") && !this.getModel().equals("unknown")
			&& !this.getColor().equals("unknown") && this.getYear() != 0
			&& this.getMileage() != -1) {return true;}
		else {return false;}
	}
}

