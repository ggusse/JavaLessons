/**A test class for the ClothingBag
 * @author Griffin Gusse
 */
public class BoutiqueBagDemo {
	
	//initialize the bag for testing
	public static ClothingBag<ClothingItem> testBag = new ClothingBag<ClothingItem>();
	
	//create some clothing items
	final static ClothingItem shirt1 = new ClothingItem("Purple T-Shirt", 7.99);
	final static ClothingItem shirt2 = new ClothingItem("Black T-Shirt", 5.99);
	final static ClothingItem shirt3 = new ClothingItem("White T-Shirt", 4.99);
	final static ClothingItem pants1 = new ClothingItem("Blue Jeans", 29.99);
	final static ClothingItem pants2 = new ClothingItem("Tan Jeans", 34.99);
	
	//test method to add items to the bag
	public static void testAdd1() {
		int counter = 0;
		while(counter < 6) {
			System.out.println(testBag.add(shirt1));
			System.out.println(testBag.add(shirt2));
			System.out.println(testBag.add(shirt3));
			System.out.println(testBag.add(pants1));
			System.out.println(testBag.add(pants2));
			counter++;
		}
	}
	
	//test method to display the items in the bag
	public static void displayBag(ClothingBag<ClothingItem> bag) {
		Object[] displayArray = bag.toArray();
		for (int i = 0; i < bag.length(); i++) {
			System.out.println(displayArray[i]);
		}
	}
	
	//MAIN METHOD
	public static void main(String[] args) {
		
		//run the add testing method
		testAdd1();
		
		//run the display testing method
		displayBag(testBag);
	}
}
