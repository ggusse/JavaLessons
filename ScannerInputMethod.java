import java.util.Scanner;

public class ScannerInputMethod {

	public static String scannerInput() {
		
		Scanner scnr = new Scanner(System.in);
				
		try {
			System.out.println("Enter first string (Must be less than 20 characters): ");
			String userString1 = scnr.nextLine();
			
			System.out.println("Enter second string (Must be less than 20 characters): ");
			String userString2 = scnr.nextLine();
			
			System.out.println("Enter third string (Must be less than 20 characters): ");
			String userString3 = scnr.nextLine();
			
			if(userString1.contentEquals("") || userString2.contentEquals("") || userString3.contentEquals("")) {
				throw new Exception("Empty string.");				
			}
			else if(userString1.length() > 20 && userString2.length() > 20 && userString3.length() > 20) {
				throw new Exception("Multiple strings too long.");
			}
			else if(userString1.length() > 20) {
				throw new Exception("First string too long.");
			}
			else if(userString2.length() > 20) {
				throw new Exception("Second string too long.");
			}
			else if(userString3.length() > 20) {
				throw new Exception("Third string too long.");
			}
			else {
				System.out.println("User strings are " + userString1 + ", " + userString2 + ", and " + userString3 + ".");
				return "Success";
			}
		}
		
		catch (Exception excpt) {
			System.out.println(excpt.getMessage());
			return "Failure";
		}
	}
	
	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		String userInput = "a";
		
		while(userInput.charAt(0) != 'q') {
			System.out.println("Would you like to run the program? (Enter\"c\" to continue or \"q\" to quit)");
			userInput = scnr.next();
			
			if(userInput.charAt(0) == 'q') {
				continue;
			}
			else if(userInput.charAt(0) == 'c') {
				String sOrF = scannerInput();		
				System.out.println(sOrF);
			}
			else {
				System.out.println("Invalid command.");
			}
		}
		System.out.println("Program was quit.");		
		return;
	}
}
