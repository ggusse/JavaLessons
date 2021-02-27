import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
	
public class StudentLinkedList {
	
	public static void sortByRollNo(LinkedList<Student> studentList, int i, int j, int k){
		
		int mergedSize = k - i + 1;       // Size of merged partition
		LinkedList<Student> newList = new LinkedList<Student>(); //temporary list for merged students
		int mergePos;                     // Position to insert merged student
		int leftPos;                      // Position of elements in left partition
		int rightPos;                     // Position of elements in right partition

		mergePos = 0;
		leftPos = i;                      // Initialize left partition position
		rightPos = j + 1;                 // Initialize right partition position

		// Add smallest element from left or right partition to new list
		while (leftPos <= j && rightPos <= k) {
			if (studentList.get(leftPos).getName().compareTo(studentList.get(rightPos).getName()) < 0) {
				newList.add(mergePos, studentList.get(leftPos));
				++leftPos;
			} 
			else {
				newList.add(mergePos, studentList.get(rightPos));
				++rightPos;
			}
		++mergePos;
		}

		// If left partition is not empty, add remaining elements to new list
		while (leftPos <= j) {
			newList.add(mergePos, studentList.get(leftPos));
			++leftPos;
			++mergePos;
		}

		// If right partition is not empty, add remaining elements to new list
		while (rightPos <= k) {
			newList.add(mergePos, studentList.get(rightPos));
			++rightPos;
			++mergePos;
		}

		// Copy new list back to student list
		for (mergePos = 0; mergePos < mergedSize; ++mergePos) {
			studentList.set(i + mergePos, newList.get(mergePos));
		}
	}
	
	public static void mergeSort(LinkedList<Student> studentList, int i, int k) {
		int j;

		if (i < k) {
			j = (i + k) / 2;  // Find the midpoint in the partition

		    // Recursively sort left and right partitions
		    mergeSort(studentList, i, j);
		    mergeSort(studentList, j + 1, k);

		    // Merge left and right partitions
		    sortByRollNo(studentList, i, j, k);
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		//initialize variables
		LinkedList<Student> studentList = new LinkedList<Student>();
		int i;
		char userInput = 'a';
		Scanner input = new Scanner(System.in);
		
		
		while(userInput != 'q') {
			
			//get user command
			System.out.println("Enter \"a\" to add a student or \"q\" to quit and export student list to file: ");
			userInput = input.next().charAt(0);
			System.out.println(userInput);
			
			try {
				
				//throw error if user input is not acceptable
				if(userInput != 'a' && userInput != 'q') {throw new Exception("Invalid Command");}
				
				//condition to add new student
				if(userInput == 'a') {
					
					//generate temporary student and its variables
					Student tempStudent = new Student();
					String userString = null;
					double userDouble = 0.0;
					
					System.out.println("Enter student information: ");
					
					//record student name
					System.out.println("Student Name: ");
					input.nextLine();
					userString = input.nextLine();
					tempStudent.setName(userString);
					
					//record student address
					System.out.println("Student Address: ");
					userString = input.nextLine();
					tempStudent.setAddress(userString);
					
					//record student GPA
					while(tempStudent.getGPA() < 0.0) {
						System.out.println("Student GPA: ");
						userDouble = input.nextDouble();
						if(userDouble <= 4.0 && userDouble >= 0.0) {
							tempStudent.setGPA(userDouble);
						}
						else {
							System.out.println("Invalid GPA. Enter valid GPA.");
						}
					}
					
					//add student to linked list
					studentList.add(tempStudent);
					System.out.println("Successfully added student.");
				}
			}
			catch(Exception e) {
				System.out.println("Error: " + e.getMessage());
				continue;
			}
		}
		
		//close scanner
		input.close();	
		
		//alphabetically sort students
		mergeSort(studentList, 0, studentList.size() - 1);
		
		//print student list to file
		FileWriter fstream = new FileWriter("StudentInformation.txt", true);
		PrintWriter outFS = new PrintWriter(fstream);
		for(i = 0; i < studentList.size(); ++i) {
			outFS.append(studentList.get(i).toString() + "\n");
			outFS.flush();
		}
		fstream.close();
		System.out.println("Students successfully saved to file.");
		
		System.out.println("Program terminated");
	}
}