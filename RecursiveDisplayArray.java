/**A class to display arrays using recursion
 * @author Griffin Gusse
 */
public class RecursiveDisplayArray {
	
	/**recursive method to print an array in reverse order
	 * @param array the array to print in reverse order
	 */
	public static <T> void reverse(T[] array) {
		int last = array.length - 1;
		
		//reverseRecursionSmall does not work reliably with larger arrays
		if (array.length < 2000) {
			reverseRecursionSmall(array, 0, last);
		}
		else {
			reverseRecursionLarge(array, 0, last);
		}
	}
	
	/**recursive method to print a small array in reverse order
	 * @param array the array to print in reverse
	 * @param first the index of the first element of the array
	 * @param last the index of the last element of the array
	 */
	private static <T> void reverseRecursionSmall(T[] array, int first, int last) {
		if (first <= last) {
		    System.out.print(array[last] + " ");
		    reverseRecursionSmall(array, first, last - 1);
		}
	}
	
	/**recursive method to print a large array in reverse order
	 * @param array the array to print in reverse
	 * @param first the index of the first element of the array
	 * @param last the index of the last element of the array
	 */
	private static <T> void reverseRecursionLarge(T[] array, int first, int last) {
		if(first == last) {
			System.out.print(array[last] + " ");
		}
		else {
			int mid = first + (last-first)/2;
			reverseRecursionLarge(array, mid + 1, last);
			reverseRecursionLarge(array, first, mid);
		}
	}
}
