/**A class to store Person objects in a sortable queue
 * @author Griffin Gusse
 */
public final class PersonQueue {
	private int frontIndex;
	private int backIndex;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
	private Person[] personArray;
	
	//default constructor
	public PersonQueue() {
		this(DEFAULT_CAPACITY);
	}
	
	//parameterized constructor
	public PersonQueue(int initialCapacity) {
		Person[] tempArray = new Person[initialCapacity + 1];
		personArray = tempArray;
		frontIndex = 0;
		backIndex = initialCapacity;
	}
	
	/**adds a person to the queue
	 * @param newPerson Person to be added to the queue
	 */
	public void enqueue(Person newPerson) {
		ensureCapacity();
		backIndex = (backIndex + 1) % personArray.length;
		personArray[backIndex] = newPerson;
	}
	
	/**returns the head of the queue without removing it
	 * @return Person that is at the head of the queue
	 */
	public Person peek() {
		if(isEmpty()) {return null;}
		else {return personArray[frontIndex];}
	}
	
	/**removes and returns the head of the queue
	 * @return Person that is at the head of the queue
	 */
	public Person dequeue() {
		if(isEmpty()) {return null;}
		else {
			Person front = personArray[frontIndex];
			personArray[frontIndex] = null;
			frontIndex = (frontIndex + 1) % personArray.length;
			return front;
		}
	}
	
	/**expands the array if the queue is full
	 */
	private void ensureCapacity() {
	   if (frontIndex == ((backIndex + 2) % personArray.length) && personArray.length < MAX_CAPACITY) {
	      Person[] oldArray = personArray;
	      int oldSize = oldArray.length;
	      int newSize = 2 * oldSize;
	      Person[] tempArray = new Person[newSize];
	      personArray = tempArray;
	      for (int index = 0; index < oldSize - 1; index++)
	      {
	         personArray[index] = oldArray[frontIndex];
	         frontIndex = (frontIndex + 1) % oldSize;
	      }
	      frontIndex = 0;
	      backIndex = oldSize - 2;
	   }
	} 
	
	/**returns whether the array is empty
	 * @return true if queue is empty, false if not
	 */
	public boolean isEmpty() {
		return frontIndex == ((backIndex + 1) % personArray.length);
	}
	
	/**prints the contents of the queue in order
	 */
	public void print() {
		int tempFrontIndex = frontIndex;
		while(!(tempFrontIndex == ((backIndex + 1) % personArray.length))) {
			System.out.println(personArray[tempFrontIndex].toString());
			tempFrontIndex = (tempFrontIndex + 1) % personArray.length;
		}
		System.out.println();
	}
	
	/**sorts the contents of the queue in descending order by age
	 */
	public void sortByAge() {
		
		//creates a non-circular array of the items in the queue for sorting
		Person[] sortable = new Person[(frontIndex + backIndex + 1) % personArray.length];
		
		//copies items from queue into sortable array
		int i = frontIndex;
		int j = 0;
		while(i % personArray.length <= backIndex) {
			sortable[j] = personArray[i];
			i++;
			j++;
		}
		
		//sorts array
		quickSortByAge(sortable, 0, sortable.length - 1);
		
		//moves sorted array back into queue
		i = frontIndex;
		j = 0;
		while(i % personArray.length <= backIndex) {
			personArray[i] = sortable[j];
			i++;
			j++;
		}
	}
	
	/**performs a quick sort on an array containing Person objects by age
	 * @param array the array to be sorted
	 * @param first the index of the first element in the array
	 * @param last the index of the last element in the array
	 */
	private void quickSortByAge(Person[] array, int first, int last) {
		
		//sets the pivot as the middle element in the array
		int pivotIndex = first + (last - first) / 2;
		Person pivotValue = array[pivotIndex];
		
		//checks elements from either direction against the pivot
		int indexFromLeft = first;
		int indexFromRight = last;
		while (indexFromLeft <= indexFromRight) {
			while (array[indexFromLeft].compareAge(pivotValue) > 0) {
				indexFromLeft++;
			}
			while (array[indexFromRight].compareAge(pivotValue) < 0) {
				indexFromRight--;
			}
			
			//swaps elements to their correct sides of the pivot
			if (indexFromLeft <= indexFromRight) {
				swap(array, indexFromLeft, indexFromRight);
				indexFromLeft++;
				indexFromRight--;
			}
		}
		
		//recursively perform further quick sorts on smaller sub arrays
		if(first < indexFromRight) {
			quickSortByAge(array, first, indexFromRight);
		}
		if(last > indexFromLeft) {
			quickSortByAge(array, indexFromLeft, last);
		}
	}
	
	/**sorts the contents of the queue in descending order by last name
	 */
	public void sortByName() {
		
		//creates a non-circular array of the items in the queue for sorting
		Person[] sortable = new Person[(frontIndex + backIndex + 1) % personArray.length];
		
		//copies items from queue into sortable array
		int i = frontIndex;
		int j = 0;
		while(i % personArray.length <= backIndex) {
			sortable[j] = personArray[i];
			i++;
			j++;
		}
		
		//sorts array
		quickSortByName(sortable, 0, sortable.length - 1);
		
		//moves sorted array back into queue
		i = frontIndex;
		j = 0;
		while(i % personArray.length <= backIndex) {
			personArray[i] = sortable[j];
			i++;
			j++;
		}
	}
	
	/**performs a quick sort on an array containing Person objects by last name
	 * @param array the array to be sorted
	 * @param first the index of the first element in the array
	 * @param last the index of the last element in the array
	 */
	private void quickSortByName(Person[] array, int first, int last) {
		
		//sets the pivot as the middle element in the array
		int pivotIndex = first + (last - first) / 2;
		Person pivotValue = array[pivotIndex];
		
		//checks elements from either direction against the pivot
		int indexFromLeft = first;
		int indexFromRight = last;
		while (indexFromLeft <= indexFromRight) {
			while (array[indexFromLeft].compareName(pivotValue) > 0) {
				indexFromLeft++;
			}
			while (array[indexFromRight].compareName(pivotValue) < 0) {
				indexFromRight--;
			}
			
			//swaps elements to their correct sides of the pivot
			if (indexFromLeft <= indexFromRight) {
				swap(array, indexFromLeft, indexFromRight);
				indexFromLeft++;
				indexFromRight--;
			}
		}
		
		//recursively perform further quick sorts on smaller sub arrays
		if(first < indexFromRight) {
			quickSortByName(array, first, indexFromRight);
		}
		if(last > indexFromLeft) {
			quickSortByName(array, indexFromLeft, last);
		}
	}
	
	//swaps the places of two Person objects in an array
	private void swap(Person[] array, int a, int b) {
		Person temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
