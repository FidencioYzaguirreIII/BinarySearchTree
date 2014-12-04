import java.util.*;
import java.math.*;

public class BinarySearchTree<E> 
{
    TreeNode<E> root; // Represents the whole tree
	protected int size = 0; // Size of the tree
	protected double maxDepth = 0;
	protected int searchDepth = 0;
	protected String inorderString = "";
	protected String preorderString = "";
	protected String postorderString = "";
	protected int parentNumber = 1;
	
	//Default Constructor
	BinarySearchTree()
	{ 
		
	}
	
	
	
	
	
	
	/*
	 * 	Traverses tree with the "inorder" method.
	 */
	public void inorder(TreeNode<E> node)
	{ 
		// Checks to see if the node is null so it can return.
		if (node == null)
		{ 
			return;
		}
		
		// Calls  left branch of node recursively.
		inorder(node.leftBranch); 
		
		// Prints the element of the current node.
		inorderString += (node.element + "("+node.depth+") "); 
		
		// Calls right branch of node recursively.
		inorder(node.rightBranch); 
	}
	
	
	
	
	
	
	/*
	 * 	Traverses tree with the "postorder" method.
	 */
	public void postorder(TreeNode<E> node)
	{ 
		
		// Checks to see if the node is null so it can return.
		if (node == null)
		{ 
			return;
		} 
		// Calls  left branch of node recursively.
		postorder(node.leftBranch);
		
		// Calls right branch of node recursively.
		postorder(node.rightBranch);
		
		// Prints the element of the current node.
		postorderString += (node.element + "("+node.depth+") "); 
	}
	
	
	/*
	 * 	Traverses tree with the "preorder" method.
	 */
	public void preorder(TreeNode<E> node)
	{ 
		// Checks to see if the node is null so it can return.
		if (node == null)
		{ 
			return;
		}
		
		// Prints the element of the current node.
		preorderString += (node.element + "("+node.depth+") "); 
		
		// Calls  left branch of node recursively.
		preorder(node.leftBranch); 
		
		// Calls right branch of node recursively.
		preorder(node.rightBranch); 
	}
	
	public void breadthOrder(TreeNode<E> node)
	{
		
	}
	
	
	
	
	
	// Prints our files to represent all of the traversal methods of the search tree
	public void traversalOrderFiles()
	{ 
		Formatter inorderFile = null;
		Formatter preorderFile = null;
		Formatter postorderFile = null;
		
		
		// open inorder file
		try
		{ 
			inorderFile = new Formatter("inorder.out");
		}
		catch(Exception e)
		{
			
		}
		// input the inorder in the inorder file
		inorderFile.format("%s", inorderString); 
		
		
		
		
		// open preorder file
		try
		{ 
			preorderFile = new Formatter("preorder.out");
		}
		catch(Exception e)
		{
			
		}
		// Input the preorder in the inorder file
		preorderFile.format("%s", preorderString); 
		
		
		
		
		// open postorder file
		try
		{ 
			postorderFile = new Formatter("postorder.out");
		}
		catch(Exception e)
		{
			
		}
		// Input the postorder in the postorder file
		postorderFile.format("%s", postorderString); 
		
		
		
		
		
		// Close all formatters
		inorderFile.close();
		preorderFile.close();
		postorderFile.close();
	}
	
	
	
	// adds new node to tree
	public void add(E e)
	{ 
		
		// Adds new node to create tree
		if (size == 0)
		{
			root = new TreeNode<E>(e); 
			size++;
		}
		
		
		else
		{
			//Creating new node called "placement"'
			//This is the new node being added
			TreeNode<E> placement = root;
			
			//Setting placed to false (because it hasnt been placed yet)
			boolean placed = false;
			
			//Loop will stop once new node is added
			while(!placed)
			{
				
				// Checks to see if the node should go to the right side.
				if((e.toString()).compareTo((placement.element).toString()) > 0)
				{ 
					// Checks to see if the right branch is empty.
					if (placement.rightBranch == null)
					{ 
						// Puts the new node in the right node.
						placement.rightBranch = new TreeNode<E>(e); 
						(placement.rightBranch).depth = placement.depth +1;
						if((placement.rightBranch).depth > maxDepth)
						{
							maxDepth = (placement.rightBranch).depth;
						}
						size ++;
						
						placement.rightBranch.status = "rc";
						placement.rightBranch.pn = parentNumber;
						parentNumber ++;
						placement.rightBranch.cn = placement.pn;
						placed = true;
					}
					
					// Goes to the right branch
					placement = placement.rightBranch; 
				}
				
				
				// Checks to see if the node should go to the left side.
				else if((e.toString()).compareTo((placement.element).toString()) < 0)
				{ 
					
					// Checks to see if the left branch is empty.
					if (placement.leftBranch == null)
					{ 
						// Put the new node in the left branch.
						placement.leftBranch = new TreeNode<E>(e);
						(placement.leftBranch).depth = placement.depth +1;
						if((placement.leftBranch).depth > maxDepth)
						{
							maxDepth = (placement.leftBranch).depth;
						}
						
						size ++;
						
						placement.leftBranch.status = "lc";
						placement.leftBranch.pn = parentNumber;
						parentNumber ++;
						placement.leftBranch.cn = placement.pn;
						placed = true;
					}
					
					// Goes to the left branch
					placement = placement.leftBranch; 
				}
			}
		}
	}

	
	public void displayTree(TreeNode<E> node)
	{
		/*
		int wordLength;
		int height = (int) (2*maxDepth);
		int length = (int) Math.pow(2.0,maxDepth);
		
		Point[][] grid = consoleGUI.createGrid(height, length);
		
		System.out.println();
		System.out.println("Printing tree...");
		consoleGUI.displayGrid(grid, height, length);
		*/
		
		//consoleGUI.addWord(grid, ((length/2) - ), (), root.element);
		
		// Checks to see if the node is null so it can return.
		

			if (node == null)
			{ 
				return;
			}
			
			// Prints the element of the current node.
			if (searchDepth == node.depth)
			{
				System.out.print(node.element +"(" + node.status +"p" + node.cn +","+node.pn +") ");
			}
			
			
			// Calls  left branch of node recursively.
			displayTree(node.leftBranch); 
			
			// Calls right branch of node recursively.
			displayTree(node.rightBranch); 
	
	}
	
	
	
	public void runDisplayTree()
	{
		if (searchDepth <= maxDepth)
		{
			//Running display method by giving it the root node
			displayTree(root);
			
			//adding one to searchDepth
			searchDepth ++;
			
			//prints a line and prints next depth level
			System.out.println();
			runDisplayTree();
		}
		
	}
	
	
	
	public void GUItree()
	{
		int wordLength;
		int height = (int) (2*maxDepth);
		int length = (int) Math.pow(2.0,maxDepth);
	}
	
	
	
	
	
	
	//String[][] contents= new String[(int) (2*maxDepth)][(int) Math.pow(2.0,maxDepth)];
	
	
	/*
	 * Overarching treenode class, used to compose all tree nodes
	 * 
	 */
	protected static class TreeNode<E> 
	{
		// The value inside the node
		E element; 
		
		// These are the sub tree nodes
		TreeNode<E> leftBranch; 
		TreeNode<E> rightBranch;
		
		//current depth of node
		int depth = 0;
		
		String status = null;
		int pn = 0;
		int cn = 1;
		
		// Constructor for node.
		public TreeNode(E e)
		{ 
			element = e;
		}
	}

}
