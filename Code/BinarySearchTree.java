// Fidencio Yzaguirre III Adam Carr Austin Briggs
//Section 001
//Program runs by running finalProjectMain.java as a java application.

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class BinarySearchTree<E> 
{
    TreeNode<E> root; // Represents the whole tree
	protected int size = 0; // Size of the tree
	protected double maxDepth = 0;
	protected int searchDepth = 0;
	protected String inorderString = "";
	protected String preorderString = "";
	protected String postorderString = "";
	protected int parentNumber = 2;
	
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
		inorderString += (node.element + " "); 
		
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
		postorderString += (node.element + " "); 
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
		preorderString += (node.element + " "); 
		
		// Calls  left branch of node recursively.
		preorder(node.leftBranch); 
		
		// Calls right branch of node recursively.
		preorder(node.rightBranch); 
	}
	
	// Prints our files to represent all of the traversal methods of the search tree
	public void traversalOrderFiles(String name) throws IOException
	{ 
	    // Create components to write to for inorder.out file
		File inorderFile = new File("inorder.out");
		FileWriter fileWriter = new FileWriter(inorderFile, true);
		BufferedWriter buffer = new BufferedWriter(fileWriter);
		PrintWriter printWriter = new PrintWriter(buffer);
		
		//Write to and close inorder.out
		printWriter.println(name);
		printWriter.println();
		printWriter.println(inorderString);
		printWriter.println();
		printWriter.println();
		printWriter.close();
		
		// Create components to write to for preorder.out file
		File preorderFile = new File("preorder.out");
		fileWriter = new FileWriter(preorderFile, true);
		buffer = new BufferedWriter(fileWriter);
		printWriter = new PrintWriter(buffer);
		
		//Write to and close preorder.out
		printWriter.println(name);
		printWriter.println();
		printWriter.println(preorderString);
		printWriter.println();
		printWriter.println();
		printWriter.close();
		
		// Create components to write to for postorder.out file
		File postorderFile = new File("postorder.out");
		fileWriter = new FileWriter(postorderFile, true);
		buffer = new BufferedWriter(fileWriter);
		printWriter = new PrintWriter(buffer);
		
		//Write to and close postorder.out
		printWriter.println(name);
		printWriter.println();
		printWriter.println(postorderString);
		printWriter.println();
		printWriter.println();
		printWriter.close();
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
		
			if (node == null)
			{ 
				return;
			}
			
			// Prints the element of the current node.
			if (searchDepth == node.depth)
			{
				if (searchDepth == 0){
					System.out.print(node.element +"(" + node.pn +") ");
				}
				else{
					System.out.print(node.element +"(" + node.status +"p" + node.cn +","+node.pn +") ");
				}
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
			System.out.println();
			//adding one to searchDepth
			searchDepth ++;
			
			//prints a line and prints next depth level
			System.out.println();
			runDisplayTree();
		}
		
	}

	
	
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
		
		// Helps in identifying relations of nodes.
		String status = null;
		int pn = 1;
		int cn = 1;
		
		// Constructor for node.
		public TreeNode(E e)
		{ 
			element = e;
		}
	}

}

