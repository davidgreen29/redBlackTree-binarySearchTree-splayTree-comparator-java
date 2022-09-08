package binarySearchTree;

import java.util.Scanner;
// BST main class which allows the user to interact with the tree 
public class bstMain {


	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int userOption = 0;
		int insert;
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
//while loop which asks for user input 
		while (true) {
			System.out.println("Please enter an action you'd like to take:");
			System.out.println("\t1) Enter a integer to insert in the binary search tree");
			System.out.println("\t2) Print inorder");
			System.out.println("\t3) print preorder");
			System.out.println("\t4) print BST");
			System.out.println("\t5) End");

			userOption = scanner.nextInt();
			scanner.nextLine();  

			switch (userOption){
			case 1:
				System.out.println("Please enter a integer to add");
				insert = scanner.nextInt();//ask the user to insert a value 
				tree.insert(insert);
				break;
			case 2:
				//print inorder
				tree.inOrder();
				break;
			case 3:
				//print preorder
				tree.preOrder();
				break;
			case 4:
				//print BST
				tree.printTreeDiagram();
			case 5:
				//End loop
				break;
			default:
				System.out.println("Sorry, thats not supported");
				break;//user input not supported 
			}
			//exit the program 
			if(userOption == 5) {
				System.out.println("the program has ended");
				break;
			}
		}
	}}
	