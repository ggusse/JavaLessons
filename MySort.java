/**A class to implement sorting algorithms on arrays of comparable types
 * @author Griffin Gusse
 */
public class MySort {
	
	/**A method to sort an array
	 * @param <T> type of the elements in the array
	 * @param array the array to be sorted
	 */
	public static <T extends Comparable<? super T>> void shell(T[] array) {
		
		//instantiate variables for spacing and length
		int numEntries = array.length;
		int space;
		
		//set spacing equal to half the length of the array
		space = numEntries / 2;

		//repeatedly perform spaced insertion sort until spacing cannot shrink further
		while(space > 0) {
			for(int i = 0; i < space; i++) {
				incremetalInsertionSort(array, 0, numEntries, space);
			}
			space = space / 2;
		}
	}
	
	/**A private method to perform the insertion for shell sort at each spacing
	 * @param <T> type of the elements in the array
	 * @param array the array to be sorted
	 * @param first the index of the first value in the array
	 * @param last the index of the last value in the array
	 * @param space the spacing of the elements on this pass
	 */
	private static <T extends Comparable<? super T>> void incremetalInsertionSort(T[] array, int first, int last, int space) {
		
		//loop through spaced values
		for(int unsorted = first + space; unsorted < last; unsorted += space) {
			
			//grab the next value in the spacing sequence
			T nextToInsert = array[unsorted];
			
			// move to next index
			int index = unsorted - space;
			
			//sort all equally spaced values
			while(index >= first && nextToInsert.compareTo(array[index]) < 0) {
				array[index + space] = array[index];
				index = index - space;
			}
			array[index + space] = nextToInsert;
		}
	}
	
	public static void main(String[] args) {
		
		//instantiate an array for testing
		Integer[] testArray = {47, 345, 264, 346, 267, 45, 443, 346, 267, 468, 66, 46, 345, 678, 23};
		
		//print unsorted array
		System.out.print("Unsorted Array: ");
		for(int element: testArray) {
			System.out.print(element + " ");
		}
		System.out.println();
		
		//sort array
		MySort.shell(testArray);
		
		//print sorted array
		System.out.print("Sorted Array: ");
		for(int element: testArray) {
			System.out.print(element + " ");
		}
	}
}
