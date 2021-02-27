import java.util.Scanner;

public class MPGCalculator {

	public static void main(String args[]){
		Scanner scnr = new Scanner(System.in);
		String carMake = "";
		String carModel = "";
		int carYear = 0;
		int odometerStart = 0;
		int odometerEnd = 0;
		double gallonsUsed = 0.0;
		double estimatedMPG = 0.0;
		
		System.out.println("Enter make of car: ");
		carMake = scnr.nextLine();
		System.out.println("Enter model of car: ");
		carModel = scnr.nextLine();
		System.out.println("Enter year of car: ");
		carYear = scnr.nextInt();
		System.out.println("Enter starting odometer reading: ");
		odometerStart = scnr.nextInt();
		System.out.println("Enter ending odometer reading: ");
		odometerEnd = scnr.nextInt();
		System.out.println("Enter gallons used: ");
		gallonsUsed = scnr.nextDouble();
		
		estimatedMPG = (odometerEnd - odometerStart) / gallonsUsed;
		
		System.out.println("Make: " + carMake);
		System.out.println("Model: " + carModel);
		System.out.println("Year: " + carYear);
		System.out.println("Starting Odometer Reading: " + odometerStart);
		System.out.println("Ending Odometer Reading: " + odometerEnd);
		System.out.println("Gallons Used: " + gallonsUsed);
		System.out.println("MPG: " + estimatedMPG);
		
		return;
		
	}
}
