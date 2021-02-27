import java.util.Scanner;

public class LoopingWithFloatingPointNumbers {
	
	public static void main(String args[]) {
		
		Scanner scnr = new Scanner(System.in);
		
		char userChar = 'a';
		String userInput = "";
		
		while (userChar != 'q' && userChar != 'Q') {
			System.out.println("Enter a value (\"e\" to execute, \"q\" to quit): ");
			userInput = scnr.next();
			userChar = userInput.charAt(0);
			int i = 0;
			
			if (userChar == 'e' || userChar == 'E') {
				
				double[] values = new double[5];
				double total = 0.0;
				double maximum = 0.0;
				double minimum = 0.0;
				
				System.out.println("Enter 5 values separated by spaces: ");
				values[0] = scnr.nextDouble();
				values[1] = scnr.nextDouble();
				values[2] = scnr.nextDouble();
				values[3] = scnr.nextDouble();
				values[4] = scnr.nextDouble();
				
				total = values[0] + values[1] + values[2] + values[3] + values[4];
				
				maximum = values[0];
				for(i = 1; i <= 4; ++i) {
					if (values[i] > maximum) {maximum = values[i];}
				}
				
				minimum = values[0];
				for(i = 1; i <= 4; ++i) {
					if (values[i] < minimum) {minimum = values[i];}
				}
				
				System.out.println("Total = " + total);
				System.out.println("Average = " + (total / 5.0));
				System.out.println("Maximum = " + maximum);
				System.out.println("Maximum = " + minimum);
				System.out.println("Total with 20% interest = " + (total * 1.2));
			}
		}
			
		System.out.println("Program was quit.");
	}

}
