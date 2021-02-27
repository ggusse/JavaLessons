/**An interface for use with a bag
 * @author Griffin Gusse
 */
public interface BagInterfaceMyType<T> {
	
	/**Adds a new item to the bag
	 * @param newEntry the item to be added
	 * @return true if add was successful, false if not
	 */
	public boolean add(T newEntry);
	
	/**Creates an array of all items in the bag
	 * @return the array with all items
	 */
	public T[] toArray();
	
	/**Tests whether or not the bag is full
	 * @return true if bag is full, false if not
	 */
	public boolean isFull();
}
