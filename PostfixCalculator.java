/**A calculator for postfix expression strings
 * @author Griffin Gusse
 */
import java.util.Stack;

public class PostfixCalculator {
	
	/**A method to calculate the result of an expression in postfix form
	 * @param An expression in postfix form represented as a string
	 * @return The final value of the expression after the operations have completed
	 */
	public static int calculate(String expression) {
		
		//instantiate all local methods
		Stack<Integer> stack = new Stack<Integer>();
		int numChars = expression.length();
		int i = 0;
		char nextChar = ' ';
		int operand1;
		int operand2;
		int result;
		
		//loop to parse the entire string passed to the method
		while(i< numChars) {
			
			//store the character for analysis
			nextChar = expression.charAt(i);
			
			//switch to handle characters
			switch(nextChar) {
			
			//case for addition
			case '+':
				operand1 = stack.pop();
				operand2 = stack.pop();
				result = operand2 + operand1;
				stack.push(result);
				break;
				
			//case for subtraction
			case '-':
				operand1 = stack.pop();
				operand2 = stack.pop();
				result = operand2 - operand1;
				stack.push(result);
				break;
			
			//case for multiplication
			case '*':
				operand1 = stack.pop();
				operand2 = stack.pop();
				result = operand2 * operand1;
				stack.push(result);
				break;
			
			//case for division
			case '/':
				operand1 = stack.pop();
				operand2 = stack.pop();
				result = operand2 / operand1;
				stack.push(result);
				break;
			
			//case for exponentiation
			case '^':
				operand1 = stack.pop();
				operand2 = stack.pop();
				result = (int)Math.pow(operand2, operand1);
				stack.push(result);
				break;
			
			//case to handle whitespace
			case ' ': break;
			
			//case for variables
			default:
				stack.push(Character.getNumericValue(nextChar));
				break;
			}
			
			//move to next index
			i++;
		}
		return stack.pop();
	}
}
