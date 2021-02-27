/**A class to test the recursive display array class methods
 * @author Griffin Gusse
 */


public class DisplayArrayTest {

	
	public static void main(String[] args) {
		
		//instantiate some arrays for testing
		Integer[] intTest1 = new Integer[1000];
		for(int i = 0; i < 1000; i++) {
		intTest1[i] = i + 1;
		}
		Integer[] intTest2 = new Integer[6000];
		for(int i = 0; i < 6000; i++) {
		intTest2[i] = i + 1;
		}
		String[] stringTest1 = new String[1000];
		for(int i = 0; i < 1000; i++) {
			stringTest1[i] = "" + (i + 1);
		}
		String[] stringTest2 = new String[6000];
		for(int i = 0; i < 6000; i++) {
			stringTest2[i] = "" + (i + 1);
		}
	
		//reverse the first integer test array and report runtime
		long startTime = System.nanoTime();
		System.out.print("Integer Test #1: ");
		RecursiveDisplayArray.reverse(intTest1);
		System.out.println();
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("Runtime: " + totalTime + " ns\n");
		
		//reverse the second integer test array and report runtime
		startTime = System.nanoTime();
		System.out.print("Integer Test #2: ");
		RecursiveDisplayArray.reverse(intTest2);
		System.out.println();
		endTime   = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println("Runtime: " + totalTime + " ns\n");
		
		//reverse the first string test array and report runtime
		startTime = System.nanoTime();
		System.out.print("String Test #1: ");
		RecursiveDisplayArray.reverse(stringTest1);
		System.out.println();
		endTime   = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println("Runtime: " + totalTime + " ns\n");
		
		//reverse the second string test array and report runtime
		startTime = System.nanoTime();
		System.out.print("String Test #2: ");
		RecursiveDisplayArray.reverse(stringTest2);
		System.out.println();
		endTime   = System.nanoTime();
		totalTime = endTime - startTime;
		System.out.println("Runtime: " + totalTime + " ns\n");
	}
}
