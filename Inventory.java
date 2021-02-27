import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Inventory {
		
	public static void main(String[] args) throws IOException {
		
		PrintWriter outFS = null;
		FileWriter fstream = null;
		Scanner input = new Scanner(System.in);
		String userInput = "";
		
		System.out.println("Welcome to the vehicle inventory program.");
		
		Automobile newCar = new Automobile();
	
		System.out.println("Current vehicle attributes: ");
		Print(newCar);
		
		while(!userInput.equals("quit")) {			
			userInput = "";
			System.out.println("What would you like to do? (Enter \"quit\" when finished, \"add\" to add a vehicle,"
					+ "\"remove\" to erase vehicle data, \"update\" to update vehicle information, or \"list\" "
					+ "to list current vehicle attributes)");
			userInput = input.next();
		
			try {
				if(userInput.equals("quit")) {continue;}
				else if(userInput.equals("add")) {
				System.out.println(newCar.AddVehicle());
				continue;
				}
				else if(userInput.equals("remove")) {
				System.out.println(newCar.RemoveVehicle());
				continue;
				}
				else if(userInput.equals("update")) {
				System.out.println(newCar.UpdateVehicle());
				}
				else if(userInput.equals("list")) {
				Print(newCar);
				}
				else {throw new Exception("Invalid command.");}
			}
			catch(Exception excpt) {System.out.println(excpt.getMessage()); continue;}
		}
		
		
		while (!(userInput.equals("Y")||userInput.equals("N"))){
			System.out.println("Would you like to save this vehicle to a file? (Enter Y or N)");
			userInput = input.next();
			
			try {
				if(userInput.equals("Y")) {
					if(newCar.testDataEntry()) {
						fstream = new FileWriter("AutomobileInventory.txt", true);
						outFS = new PrintWriter(fstream);
						int i = -1;
						for(i = 0; i < 5; ++i) {outFS.append(newCar.arrayFormat()[i] + "\n");}
						outFS.append("\n");
						outFS.flush();
						System.out.println("Vehicle was saved successfully.");
						fstream.close();
					}
					else {throw new Exception("Vehicle information is incomplete and cannot be saved."
							+ " Rerun program to enter new vehicle.");
					}
				}
				else if(userInput.equals("N")) {
					System.out.println("Vehicle was not saved.");
				}
				else {throw new Exception("Invalid command, please enter valid command.");}
			}
			catch(Exception excpt) {System.out.println(excpt.getMessage()); continue;}
		}
		
		input.close();
		System.out.println("Program was closed.");
	}
	
	public static void Print(Automobile carToPrint) {
		int i = -1;
		for(i = 0; i < 5; ++i) {
			System.out.println(carToPrint.arrayFormat()[i]);
		}
	}
}
