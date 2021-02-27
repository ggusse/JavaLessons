/**Class of items that would be carried by a boutique
 * @author Griffin Gusse
 */
public class ClothingItem {
	private String itemName;
	private double price;
	
	//default constructor
	public ClothingItem() {
		itemName = null;
		price = 0;
	}
	
	//parameterized constructor
	public ClothingItem(String newName, double newPrice) {
		itemName = newName;
		price = newPrice;
	}
	
	//returns itemName
	public String getName() {return itemName;}
	
	//alters itemName
	public void setName(String newName) {itemName = newName;}
	
	//returns price
	public double getPrice() {return price;}
	
	//alters itemName
	public void setPrice(double newPrice) {price = newPrice;}
	
	//returns item information as string
	@Override
	public String toString() {return this.itemName + " $" + this.price;}
}
