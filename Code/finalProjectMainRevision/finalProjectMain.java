import java.io.*;
import java.util.*;

public class finalProjectMain {

	public static void main(String[] args) throws IOException{
		menu();
	} 
	
	static void menu() throws IOException
	{
		Scanner systemInInput = new Scanner(System.in);
		String menuInput = "";
		boolean running = true;
		System.out.println("Hello, and welcome to the program with more trees then forests!");
		
		loop:
		while(running == true)
		{
		try{
			System.out.println("Press 1 to make a tree press 0 to leave this place and never return");
			menuInput = systemInInput.nextLine();
			
			switch(menuInput)
			{
			case "1":
				fileInput();
				break;
				
			case "0": // need to pay attention and figure out how to end the probram without brekaing everything
				running = false;
				continue loop;
			default: 
				throw new InputMismatchException();
			}
			
		}
		catch(InputMismatchException x){ 
			System.out.println("Invalid input, please try again");
			continue loop;	
		
		}
		}
		systemInInput.close();
	}
	
	public static void fileInput () throws IOException
	{
		Scanner systemInInput = new Scanner(System.in);
		String fileName = null;
		LinkedList<String> fullString = null;
		boolean fileContinue = true;
		loop:
		while(fileContinue == true)
		{
			try{    //getting file name
				fullString = new LinkedList<String>();
	            System.out.println("\nHello, please enter the file you want made into a fabulous tree");
				fileName = systemInInput.nextLine();
				
	                       //opening file
	            Scanner fileInput = new Scanner(new FileReader(new File(fileName)));
				while(fileInput.hasNext()){ //Trying to find the end of the file 
					if(fullString.size() == 0){
						fullString.addFirst(fileInput.next());
					}
					else{
						String string = fileInput.next();
						for(int count = 0; count < fullString.size(); count++){
							if ((fullString.get(count).compareToIgnoreCase(string)) == 0){
								throw new InputMismatchException();
							}
						}
						fullString.addLast(string);
					}
				}
				fileInput.close();
			}
	        //the idea for this is supposed to throw whenever they put something wrong in. 
	        catch(InputMismatchException x)
	        {   
	           System.out.println("There can not be a duplicate string in the tree. You will be allowed to input another file");
	           continue loop;
	        }
	        catch(NoSuchElementException x)
	        {
	           System.out.println("The end of the file was reached succesfully");
	        }
			catch(IOException x){
				System.out.println("An error has occured, please try again by inputting the file again");
	                        System.out.println("This was most likely a file not existing");
				continue loop;
			}	
			
			fileContinue = false;
		}
		
		
		BinarySearchTree<String> tree = new BinarySearchTree<>();
		for(int count = 0; count < fullString.size(); count++){
			tree.add(fullString.get(count));
		}
		tree.preorder(tree.root);
		tree.inorder(tree.root);
		tree.postorder(tree.root);
		tree.traversalOrderFiles();
	}
}
