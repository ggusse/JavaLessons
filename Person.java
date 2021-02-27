/**A class to represent a person
 * @author Griffin Gusse
 */
public class Person {
	
	private String firstName;
	private String lastName;
	private Integer age;
	
	//default constructor
	public Person() {
		firstName = null;
		lastName = null;
		age = null;
	}
	
	//parameterized constructor
	public Person(String first, String last, Integer age) {
		this.firstName = first;
		this.lastName = last;
		this.age = age;
	}
	
	//returns firstName
	public String getFirstName() {return this.firstName;}
	
	//alters firstName
	public void setFirstName(String newName) {this.firstName = newName;}
	
	//returns lastName
	public String getLastName() {return this.lastName;}
	
	//alters lastName
	public void setLastName(String newName) {this.lastName = newName;}
	
	//returns age
	public Integer getAge() {return this.age;}
	
	//alters age
	public void setAge(Integer newAge) {this.age = newAge;}
	
	//method to produce a string version of a person object
	public String toString() {
		return this.firstName + " " + this.lastName + ", " + this.age + " years old";
	}
	
	/**A method to compare this person's last name against another person's last name
	 * @param otherPerson the person whose last name will be compared against this person's
	 * @return -1 if this person's last name comes before other person's alphabetically, 1 if it comes after, 0 if neither
	 */
	public int compareName(Person otherPerson) {
		int value = 0;
		int length = 0;
		if (this.lastName.length() > otherPerson.lastName.length()) {length = otherPerson.lastName.length();}
		else {length = this.lastName.length();}
		for(int i = 0; i < length; i++) {
			if(this.lastName.charAt(i) != otherPerson.lastName.charAt(i)) {
				if(this.lastName.charAt(i) > otherPerson.lastName.charAt(i)) {value = 1;}
				if(this.lastName.charAt(i) < otherPerson.lastName.charAt(i)) {value = -1;}
				break;
			}
		}
		return value;
	}
	
	/**A method to compare this person's age to another person's age
	 * @param otherPerson the person whose age will be compared against this person's
	 * @return 1 if this person is older, -1 if this person is younger, 0 if they are the same age
	 */
	public int compareAge(Person otherPerson) {
		if(this.age > otherPerson.getAge()) {return 1;}
		else if(this.age < otherPerson.getAge()) {return -1;}
		else {return 0;}
	}
}
