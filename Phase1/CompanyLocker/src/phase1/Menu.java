package phase1;
import java.io.IOException;
import java.util.Scanner;
import java.util.SortedSet;

public class Menu {
	
		public void menu ()
		{
			int c=0;
			int d=0;
			Scanner choice = new Scanner(System.in);
			SortedSet<String> temp1;
			boolean check = true,check1 = true;
			// Do While has been used so that the menu only exits when the option 3 is inputted by
			// the user.
			do {
				System.out.println("Welcome to Company Lockers LTD");
				System.out.println("Developer : Luis Silva");
				System.out.println(" Main Menu ");
				System.out.println("1. Retrieve Files");
				System.out.println("2. Business Level Operations");
				System.out.println("3. Exit");
				// Inside the do While loop I define an object of type File Operations.
				FileOperations obj2 = new FileOperations ();
				// To Avoid the program to Exit with an exception if the user inputs a character instead
				// of an integer, I include the exception handling within a do While.
				do {
					try { 
						c = choice.nextInt();
						System.out.println("\n");
						// Exception handling for incorrect options - the system is expecting an integer
						// but this code handles if the user inputs a character, negative integer or <3
						if (c<0 || c>3 ) {
							System.out.println("Incorrect choice ! Please input 1-3 \n");
							}
						check = false;
						}
				catch (Exception e) {
					System.out.println("Incorrect Option! Enter a number!  \n");
					choice.nextLine();
				  }
				}while ( check);
				if (c==1) {
					temp1 = obj2.retrieveFiles();
					if (temp1.isEmpty()) {
						System.out.println("Directory is empty! \n");
					}else {
						System.out.println("List of Files in Alphabetical Order:");
						for (String value :temp1) {
							System.out.println(value);
						}
						System.out.println("\n");
					}
				}
				else if (c==2) {
					// I've included a sub menu for the operations with a file.
					do {
						System.out.println("Business Level Operations Menu");
						System.out.println("1. Add a File");
						System.out.println("2. Delete a File");
						System.out.println("3. Search a File");
						System.out.println("4. Return to Main Menu");
						do {
							// Same logic of Exception handling as in the Main menu
							try { 
								d = choice.nextInt();
								System.out.println("\n");
								if (d<0 || d>4 ) {
									System.out.println("Incorrect choice ! Please input 1-4 \n");
									}
								check1 = false;
								}
						catch (Exception e) {
							System.out.println("Incorrect Option! Enter a number!  \n");
							choice.nextLine();
						  }
						} while ( check1);
						if (d == 1) {
							//Exception handling for adding a file.
							try {
								obj2.addFile();
							} catch (IOException e) {
								e.printStackTrace();
								System.out.println("There was an issue adding the file, please retry");
							}	
						} else if (d ==2) {
							obj2.deleteFile();
						} else if (d==3){
							obj2.search();	
						}		
					} while (d != 4);			
				}
			    } while (c != 3);
			choice.close();
			
		}
 
}	

