import java.util.*;

public class BinarySearchTree<E> {
    TreeNode<E> root; // Represents the whole tree
	protected int size = 0; // Size of the tree
	protected String inorderString = "";
	protected String preorderString = "";
	protected String postorderString = "";
	
	BinarySearchTree(){ // Constructor
		
	}
	
	public void inorder(TreeNode<E> node){ // Traverses tree with the inorder method.
		if (node == null){ // Checks to see if the node is null so it can return.
			return;
		}
		inorder(node.leftBranch); // Calls  left branch of node recursively.
		inorderString += (node.element + " "); // Prints the element of the current node.
		inorder(node.rightBranch); // Calls right branch of node recursively.
	}
	
	public void postorder(TreeNode<E> node){ // Traverses tree with the postorder method.
		if (node == null){ // Checks to see if the node is null so it can return.
			return;
		} 
		postorder(node.leftBranch); // Calls  left branch of node recursively.
		postorder(node.rightBranch); // Calls right branch of node recursively.
		postorderString += (node.element + " "); // Prints the element of the current node.
	}
	
	public void preorder(TreeNode<E> node){ // Traverses tree with the preorder method.
		if (node == null){ // Checks to see if the node is null so it can return.
			return;
		}
		preorderString += (node.element + " "); // Prints the element of the current node.
		preorder(node.leftBranch); // Calls  left branch of node recursively.
		preorder(node.rightBranch); // Calls right branch of node recursively.
	}
	
	public void traversalOrderFiles(){ // Prints our files to represent all of the traversal methods of the search tree
		Formatter inorderFile = null;
		Formatter preorderFile = null;
		Formatter postorderFile = null;
		
		try{ // open inorder file
			inorderFile = new Formatter("inorder.out");
		}
		catch(Exception e){
			
		}
		
		inorderFile.format("%s", inorderString); // input the inorder in the inorder file
		
		try{ // open preorder file
			preorderFile = new Formatter("preorder.out");
		}
		catch(Exception e){
			
		}
		
		preorderFile.format("%s", preorderString); // Input the preorder in the inorder file
		
		try{ // open postorder file
			postorderFile = new Formatter("postorder.out");
		}
		catch(Exception e){
			
		}
		
		postorderFile.format("%s", postorderString); // Input the postorderi in the postorder file
		
		inorderFile.close(); // Close all formatters
		preorderFile.close();
		postorderFile.close();
	}
	
	public void add(E e){ // adds new node to tree
		if (size == 0){
			root = new TreeNode<E>(e); // Adds new node to create tree
			size ++;
		}
		else{
			TreeNode<E> placement = root;
			boolean placed = false;
			while(!placed){
				if((e.toString()).compareTo((placement.element).toString()) > 0){ // Checks to see if the node should go to the right side.
					if (placement.rightBranch == null){ // Checks to see if the right branch is empty.
						placement.rightBranch = new TreeNode<E>(e); // Puts the new node in the right node.
						size ++;
						placed = true;
					}
					placement = placement.rightBranch; // Goes to the right branch
				}
				else if((e.toString()).compareTo((placement.element).toString()) < 0){ // Checks to see if the node should go to the left side.
					if (placement.leftBranch == null){ // Checks to see if the left branch is empty.
						placement.leftBranch = new TreeNode<E>(e); // Put the new node in the left branch.
						size ++;
						placed = true;
					}
					placement = placement.leftBranch; // Goes to the left branch
				}
			}
		}
		
	}

	protected static class TreeNode<E> {
		E element; // The value inside the node
		TreeNode<E> leftBranch;  // These are the sub tree nodes
		TreeNode<E> rightBranch;
		
		public TreeNode(E e){ // Constructor for node.
			element = e;
		}
	}

}
