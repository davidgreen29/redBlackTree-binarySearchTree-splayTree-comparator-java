package binarySearchTree;


import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

//Class that represents a BST
public class BinaryTree<E extends Comparable<E>> implements Serializable {

	//Default serialization UID
	private static final long serialVersionUID = 1L;

	//Fields of the class
	private BinaryTreeNode<E> root;

	//Constructor of the BST
	public BinaryTree() {
		root = null;
	}

	//Method that adds a new Node into the BST
	public void addNode(BinaryTreeNode<E> node) {
		//check if the root is null or not
		if(root == null) {
			//If null, place it at the root
			root = node;
		} else {
			//If not null, traverse the tree to find the right place for it
			BinaryTreeNode<E> curr = root;
			while(true) {
				//Check if greater or equal than current node's value
				if(curr.getData().compareTo(node.getData()) > 0) {
					//Go to left as the next to check or replace it if it does not exist
					if(curr.getLeftChild() == null) {
						curr.setLeftChild(node);
						break;
					} else {
						curr = curr.getLeftChild();
					}
				} else {
					//Go to right as the next to check or replace it if it does not exist
					if(curr.getRightChild() == null) {
						curr.setRightChild(node);
						break;
					} else {
						curr = curr.getRightChild();
					}
				}
			}
		}
	}

	//Method that inserts a new value into the tree
	public void insert(E val) {
		//Calls insert with the new node
		addNode(new BinaryTreeNode<E>(val));
	}





	//Method that prints the tree diagram from top to bottom, with the needed spaces
	public void printTreeDiagram() {
		//if root is null, print a message saying the tree is empty
		if(root == null) {
			System.out.println("The tree is empty!");
			return;
		}

		int pageWidth = 60; 
		//creates the Queue to hold all the nodes to print
		Queue<PrintNode<E>> queue = new LinkedList<>();
		//adds the first node to the queue, the root
		PrintNode<E> first = new PrintNode<>(root, 1, pageWidth / 2); 
		queue.offer(first);
		//loop as long as the queue has values still to print
		int level = 1; //Starting level
		String currentLevel = ""; //String representing the current level info for the nodes
		while(queue.size() > 0) {
			//dequeue the next value from the queue,prints given its level and information and
			//enqueue back its children
			PrintNode<E> node = queue.poll();
			//If equal to the current level, print normally
			if(level == node.getLevel()) {
				currentLevel = updateCurrentLevel(currentLevel, node);
			}
			//If not the same level, new level
			else {
				// print the old level before reseting the values
				System.out.println(currentLevel);
				//update the level int and reset the String for the current level
				level++;
				currentLevel = "";
				//update the current level with the current node
				currentLevel = updateCurrentLevel(currentLevel, node);
			}
			// node is printed, adds its children to the queue with the respective
			//level and their respective positions
			addChildrenToPrint(node, queue, pageWidth);
		}
		//while ends, didn't get to new level, print the last current level String
		System.out.println(currentLevel);
	}

	//Method that returns the new String for a current level given the node to print and its position
	private String updateCurrentLevel(String currentLevel, PrintNode<E> node) { 
		//use its position to add it to the current String for the level
		int numChars = currentLevel.length();
		int whitespaces = node.getPosition() - numChars;
		//adds as many whitespaces as needed to get to the correct position before adding the value
		currentLevel += String.format("%"+whitespaces+"s%s"," ",node.getData().toString());
		return currentLevel;
	}

	//Method that adds the children of the current PrintNode to the queue with the respective values
	private void addChildrenToPrint(PrintNode<E> node, Queue<PrintNode<E>> queue, int pageWidth) {
		//calculate the new level and the offset of the children
		int level = node.getLevel() + 1;
		int offset = (int)(pageWidth / (Math.pow(2, level)));
		//check first the left child. If not null, add it
		if(node.getNode().getLeftChild() != null) {
			//The position of the left child is position of parent minus offset
			int position = node.getPosition() - offset;
			PrintNode<E> left = new PrintNode<>(node.getNode().getLeftChild(), level, position);
			queue.offer(left);
		}
		//for the right child. If not null, add it to the queue
		if(node.getNode().getRightChild() != null) {
			//The position of the right child is position of parent plus offset
			int position = node.getPosition() + offset;
			PrintNode<E> right = new PrintNode<>(node.getNode().getRightChild(), level, position);
			queue.offer(right);
		}
	}

	//Method that returns the inorder traversal
	public void inOrder() {
		System.out.println(inOrderTraversal(root));
	}

	//Helper method that performs an in-order traversal starting at given node
	private String inOrderTraversal(BinaryTreeNode<E> node) {
		//If current node is null, return an empty string
		if(node == null) {
			return "";
		}
		//visit the left child
		String str = inOrderTraversal(node.getLeftChild());
		//add the current node's data
		str += node.getData().toString()+" ";
		//visit the right child
		str += inOrderTraversal(node.getRightChild());
		//return the str
		return str;
	}

	//Method that returns the pre-order traversal
	public void preOrder() {
		System.out.println(preOrderTraversal(root));
	}

	//Helper method that performs a pre-order traversal starting at given node
	private String preOrderTraversal(BinaryTreeNode<E> node) {
		//If current node is null, return an empty string
		if(node == null) {
			return "";
		}
		//add the current node's data
		String str = node.getData().toString()+" ";
		//visit the left child
		str += preOrderTraversal(node.getLeftChild());
		//visit the right child
		str += preOrderTraversal(node.getRightChild());
		//return the str
		return str;
	}

	//toString representation of the tree
	public String toString() {
		//return a String representing the in-order traversal
		return inOrderTraversal(root);
	}

	//Nested class that represents a Node to print
	private static class PrintNode<E> {
		BinaryTreeNode<E> node;
		int nodeLevel = 0;
		int position = 0;

		//Constructor of the PrintNode object
		public PrintNode(BinaryTreeNode<E> node, int nodeLevel, int position) {
			this.node = node;
			this.nodeLevel = nodeLevel;
			this.position = position;
		}

		//Getters for the values of the current node
		public E getData() {
			return node.getData();
		}
		public int getLevel() {
			return nodeLevel;
		}
		public int getPosition() {
			return position;
		}
		public BinaryTreeNode<E> getNode() {
			return node;
		}
	}
}

