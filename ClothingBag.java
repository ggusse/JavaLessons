/**A bag to hold clothing items for a boutique
 * @author Griffin Gusse
 */
public class ClothingBag<T> implements BagInterfaceMyType<T>{
	private final T[] myBag;
	private int numberOfProducts;
	private static final int DEFAULT_CAPACITY = 25;
	private boolean integrityOk = false;
	
	//default constructor for an empty bag
	public ClothingBag() {
		//cast is safe as all array entries are null
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[])new Object[DEFAULT_CAPACITY];//unchecked cast
		myBag = tempBag;
		numberOfProducts = 0;
		integrityOk = true;
	}
	
	//method to check that bag was properly initialized
	private void checkIntegrity() {
		if(!integrityOk) throw new SecurityException ("ClothingBag object is corrupt.");
	}
	
	/**Adds a new item to the bag
	 * @param newEntry the item to be added
	 * @return true if add was successful, false if not
	 */
	public boolean add(T newEntry) {
		checkIntegrity();
		boolean result = true;
		if(isFull()) {
			result = false;
		}
		else {
			myBag[numberOfProducts] = newEntry;
			numberOfProducts++;
		}		
		return result;
	};
	
	/**Creates an array of all items in the bag
	 * @return the the array with all items
	 */
	public T[] toArray() {
		checkIntegrity();
		//cast is safe as entries are null
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfProducts];//unchecked cast
		for(int i = 0; i < numberOfProducts; i++) {
			result[i] = myBag[i];
		}
		return result;
	};
	
	/**Tests whether or not the bag is full
	 * @return true if bag is full, false if not
	 */
	public boolean isFull() {
		return numberOfProducts >= myBag.length;
	};
	
	/**Returns the number of items in the bag
	 * @return number of items in the bag
	 */
	public int length() {
		return numberOfProducts;
	}
}
