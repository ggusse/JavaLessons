/**A class to display sorting algorithms step by step
 * @author Griffin Gusse
 */
public class SortDisplaySteps {
	
	/**A selection sort that displays the array after each pass
	 * @param <T> the type of objects in the array
	 * @param array the array to be sorted
	 */
	public static <T extends Comparable<? super T>> void selection(T[] array) {
		
		//loop through the array
		for(int i = 0; i < array.length - 1; i++) {
			
			//instantiate variables for temporary minimum and its index
			T min = array[i];
			int iMin = i;
			
			//loop to compare the unsorted values and find the minimum
			for(int j = i + 1; j < array.length; j++) {
				if(array[j].compareTo(min) < 0) {
					min = array[j];
					iMin = j;
				}
			}
			
			//swap values if necessary
			if(array[i] != min) {
				array[iMin] = array[i];
				array[i] = min;
			}
			
			//print full array at the end of the pass
			System.out.print("Pass " + (i + 1) + ": ");
			for(T element: array) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		//the array from exercise #1
		Integer[] testArray = {5, 7, 4, 9, 8, 5, 6, 3};
		
		//run the sort
		selection(testArray);
	}
}
