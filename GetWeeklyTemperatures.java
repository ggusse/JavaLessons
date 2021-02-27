import java.util.Scanner;

public class GetWeeklyTemperatures {

	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		double[] temps = new double[7];
		String userInput = "";
		int i = 0;
		int userIndex = -1;
		
		for (i = 0; i < days.length; ++i) {
			System.out.println("Enter the temperature on " + days[i] + ": ");
			temps[i] = scnr.nextDouble();
		}
		userInput = scnr.nextLine();
		
		while (!userInput.contentEquals("quit")) {
			
			System.out.println("Type a day to get its temperature, \" week\" to get all temperatures for the week, or \"quit\" to quit: ");
			userInput = scnr.nextLine();
			
			for (i = 0; i < days.length; ++i) {if (userInput.equals(days[i])) {userIndex = i;}}
			
			if (userIndex >= 0) {
				System.out.println("The temperature on " + days[userIndex] + " was " + temps[userIndex] + " degrees");
			}
			else if (userInput.contentEquals("week")) {
				for (i = 0; i < days.length; ++i) {
					System.out.println("The temperature on " + days[i] + " was " + temps[i] + " degrees");
				}
			}
			userIndex = -1;
		}
		System.out.println("Program was quit.");
	}
}
