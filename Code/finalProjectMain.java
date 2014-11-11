import java.io.*;
import java.util.*;

public class finalProjectMain {

	public static void main(String[] args) throws IOException{

		menu();
	}
	
	public static void menu() throws IOException
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
        int lengthOfString = 0, sizeOfList = 0, counterForDuplicates = 0;
		Scanner systemInInput = new Scanner(System.in);
		String fileName = "", word = "", line = "", currentSearchingString ="", currentString = "";

		LinkedList<String> fullString = new LinkedList();
		boolean fileContinue = true;
		loop:
		while(fileContinue == true)
		{
		try{    //getting file name
                        System.out.println("\nHello, please enter the file you want made into a fabulous tree");
			fileName = systemInInput.nextLine();
			
                       //opening file
                        BufferedReader fileInput = new BufferedReader(new FileReader(new File(fileName)));
			while((line = fileInput.readLine()) != null){ //Trying to find the end of the file 
                            lengthOfString = line.length();
                            line = line.toLowerCase();
                            //going char by char to add to a word until a space and then we bump
                            for(int i = 0; i<lengthOfString;i++)
                            {   
                                if((lengthOfString) <= i){
                                    System.out.println(word);
                                    fullString.add(word);
                                    word = "";   
                                    // throw new InputMismatchException();
                                }  
                                else if(line.charAt(i) == ' ')
                                {
                                    fullString.add(word);
                                    word = "";                          
                                }
                                else if(line.charAt(i) >= 97 && line.charAt(i) <= 122){
                                    word += line.charAt(i);
                                }
                               
                            }
                        
                        }
                        
                        //got to go through and check to make sure there's not repeating words otherwise throw an input mismatch error not working
			sizeOfList = fullString.size();
                        for(int i = 0; i<sizeOfList; i++)
                        {   counterForDuplicates = 0;
                            currentString = fullString.get(i);
                            System.out.println(currentString);
                            for(int y =0; y<sizeOfList;y++)
                            {
                                currentSearchingString = fullString.get(y);
                                 if(fullString.contains(currentString))
                                 {                                  
                                     counterForDuplicates +=1;
                                 }
                                 if(counterForDuplicates > 1)
                                 {
                                     System.out.println("Hey man, how are you");
                                     System.out.println("I DON'T ALLOW DUPLICATES BACK TO THE BEGGINING, OH HERE'S THE WORD " + currentString);
                                     continue loop;
                                 }
                            }
                        }
		}
                //the idea for this is supposed to throw whenever they put something wrong in. 
                catch(InputMismatchException x)
                {   
                    System.out.println("There was a problem with whatever you put in. I mean...you should probably check what you're putting in the file. \nDon't worry I'm gonna send you back to the part where you put in a file.\n");
                    continue loop;
                }
                catch(NoSuchElementException x)
                {
                    System.out.println("The end of the file was reached succesfully");
                }
		catch(EOFException x)
		{
			System.out.println("The end of the file has been reached, moving on to the next stage. ");
		}
		catch(IOException x){
			System.out.println("An error has occured, please try again by inputting the file again");
                        System.out.println("This was most likely a file not existing");
			continue loop;
		}
			
		}
		}
	}
