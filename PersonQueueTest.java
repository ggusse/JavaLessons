/**A class to test the PersonQueue and Person classes
 * @author Griffin Gusse
 */
import java.util.Scanner;
public class PersonQueueTest {
	static Scanner input = new Scanner(System.in);
	
	/**Adds a person to the queue
	 */
	public static void addPerson() {
		System.out.print("Enter the person's \nFirst name:  ");
		String first = input.next();
		System.out.print("Last name:  ");
		String last = input.next();
		System.out.print("Age (in years):  ");
		int age = input.nextInt();
		System.out.println();
		
		Person newPerson = new Person(first, last, age);
		test.enqueue(newPerson);
	}
	
	//global queue for Person objects
	static PersonQueue test = new PersonQueue();
	
	//test method
	public static void main(String[] args) {
		
		//asks the user how many individuals will be added to the queue
		System.out.print("How many people would you like to add? ");
		int adding = input.nextInt();
		System.out.println();
		
		//adds the number of individuals the user instructed
		for(int i = 0; i < adding; i++) {
			addPerson();
		}
		
		//prints the queue in order of entry
		test.print();
		
		//sorts and prints the queue in descending order by age
		System.out.println("Sorted in descending order by age: ");
		test.sortByAge();
		test.print();
		
		//sorts and prints the queue in descending order by last name
		System.out.println("Sorted in descending order by last name: ");
		test.sortByName();
		test.print();
	}
}
