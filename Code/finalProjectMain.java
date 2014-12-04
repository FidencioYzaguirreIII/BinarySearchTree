import java.io.*;
import java.util.*;

public class finalProjectMain {

	public static void main(String[] args) throws IOException
	{
		//Starts the menu
		menu();
	} 
	
	static void menu() throws IOException
	{
		//Declaring a scanner input
		Scanner systemInInput = new Scanner(System.in);
		
		//Setting menuInput to blank
		String menuInput = "";
		
		//Setting running to true
		boolean running = true;
		
		//Welcome message
		System.out.println("Hello, and welcome to the program with more trees then forests!");
		
		
		//Starting the loop, using a label
		loop:
		while(running == true)
		{
			//try-catch block for catching errors
			try
			{
				//prompting user for input
				System.out.println();
				System.out.println("---Choose an Option---");
				System.out.println("1) Create a new tree");
				System.out.println("2) Exit the program");
				System.out.println();
				System.out.print("Choice: ");
				menuInput = systemInInput.nextLine();
				
				//Using a switch for parsing user input
				switch(menuInput)
				{
					case "1":
						fileInput();
						break;
						
					case "2": // need to pay attention and figure out how to end the program without breaking everything
						System.out.println("Goodbye!");
						System.exit(0);
					default: 
						throw new InputMismatchException();
				}
				
			}
			catch(InputMismatchException x)
			{ 
				//Error message
				System.out.println("Invalid input, please try again");
				
				//Starts the loop from the beginning
				continue loop;
			}
		}
		systemInInput.close();
	}
	
	public static void fileInput () throws IOException
	{
		//Declaring new scanner for opening files
		Scanner systemInInput = new Scanner(System.in);
		
		//Filename by default is not declared
		String fileName = null;
		
		//Declaring new empty linked list
		LinkedList<String> fullString = null;
		
		//Holds the duplicate name
		String duplicate = null;
		
		
		
		boolean fileContinue = true;
		//The loop will stop when every element has been added
		loop:
		while(fileContinue == true)
		{
			//getting file name
			try
			{    
				//Creating the linked list to store everything
				fullString = new LinkedList<String>();
				
				System.out.println();
	            System.out.println("Please enter the location of the file you want made into a tree (E.g. C:\\folder\\inputFile.txt)");
	            System.out.print("Choice: ");
				fileName = systemInInput.nextLine();
				
	            //Using Scanner to open file
	            Scanner fileInput = new Scanner(new FileReader(new File(fileName)));
	            
	            //Trying to find the end of the file 
				while(fileInput.hasNext())
				{ 
					
					
					//adding the first element to the linked list if it is empty
					if(fullString.size() == 0)
					{
						fullString.addFirst(fileInput.next());
					}
					
					
					
					
					//adding the rest of the elements to the linked list if it is not empty
					else
					{
						//current string being read
						String string = fileInput.next();
						
						
						//checking every element for duplicates
						for(int count = 0; count < fullString.size(); count++)
						{
							if ((fullString.get(count).compareTo(string)) == 0)
							{
								//Saving the duplicate word
								duplicate = fullString.get(count);
								
								//throws only if duplicate is found
								throw new InputMismatchException();
							}
						}
						
						
						//Adding the current word to the end of the list.
						fullString.addLast(string);
					}
				}
				
				//Closing the scanner
				fileInput.close();
			}
			
	        //throws exception whenever a duplicate is found, starts the input loop all over again
	        catch(InputMismatchException x)
	        {   
	           System.out.println("Duplicate word detected: \""+duplicate+"\" - Please enter another file.");
	           continue loop;
	        }
			
	        catch(NoSuchElementException x)
	        {
	           System.out.println("The end of the file was reached succesfully!");
	        }
			catch(IOException x)
			{
				System.out.println("Error: Could not find file location. Please try again!");
				continue loop;
			}	
			
			fileContinue = false;
		}
		
		//Creating the BST
		BinarySearchTree<String> tree = new BinarySearchTree<>();
		
		//Adding each element to the BST one by one
		for(int count = 0; count < fullString.size(); count++)
		{
			tree.add(fullString.get(count));
		}
		
		
		tree.preorder(tree.root);			//Creating the preorder string
		tree.inorder(tree.root);			//Creating the inorder string
		tree.postorder(tree.root);			//Creating the postorder string
		
		//Calling the method to write results to .out files
		tree.traversalOrderFiles();
		
		
		System.out.println("Pre Order: "	+tree.preorderString);
		System.out.println("In Order: "		+tree.inorderString);
		System.out.println("Post Order: "	+tree.postorderString);
		
		System.out.println("\n\nEach element is displayed with a code to designate whether the left or right child for a parent node.");
		System.out.println("For example the code for the left child of the root would be lcp1 because it is the left child of the");
		System.out.println("root which is the first parent.");
		System.out.println("\nDisplaying tree now.... \n");
		tree.runDisplayTree();
	}
}
