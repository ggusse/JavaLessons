/**A class to test the PostfixCalculator module
 * @author Griffin Gusse
 */
public class PostfixCalculatorTest {

	public static void main(String[] args) {
		
		//Tests the first scenario as outlined in the critical thinking assignment
		System.out.println("Scenario 1: " + PostfixCalculator.calculate("12+3*4-"));
		
		//Tests the second scenario as outlined in the critical thinking assignment
		System.out.println("Scenario 2: " + PostfixCalculator.calculate("12*31-/45*+"));
		
		//Performs the calculation for exercise 8 part A from the textbook
		System.out.println("Exercise #8a: " + PostfixCalculator.calculate("23+4*5-"));
		
		//Performs the calculation for exercise 8 part B from the textbook
		System.out.println("Exercise #8b: " + PostfixCalculator.calculate("23*42-/56*+"));
		
		//Performs the calculation for exercise 8 part C from the textbook
		System.out.println("Exercise #8c: " + PostfixCalculator.calculate("24-3^5+"));
	}
}
