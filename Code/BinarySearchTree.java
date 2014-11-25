
public class BinarySearchTree<E> {
    TreeNode<E> root; // Represents the whole tree
	protected int size = 0; // Size of the tree
	
	BinarySearchTree(){ // Constructor
		
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
