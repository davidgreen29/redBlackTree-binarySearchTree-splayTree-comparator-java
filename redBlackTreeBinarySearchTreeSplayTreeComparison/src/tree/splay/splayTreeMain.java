package tree.splay;

import java.util.Scanner;
//main class to allow a user to interact with the splay tree
public class splayTreeMain {

	public static void main(String[] args) {
		

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int userOption = 0;
		int insert;
		splayTree tree = new splayTree();

		while (true) {
			System.out.println("Please enter an action you'd like to take:");
			System.out.println("\t1) Enter a integer to insert in the splay tree");
			System.out.println("\t2) Print inorder");
			System.out.println("\t3) Print preorder");
			System.out.println("\t4 print splay tree");
			System.out.println("\t5) End");

			userOption = scanner.nextInt();
			scanner.nextLine();  

			switch (userOption){
			case 1:
				System.out.println("Please enter a integer to add");
				insert = scanner.nextInt();//ask the user for an input
				tree.insert(insert);
				break;
			case 2:
				tree.inorder();//print inorder
				System.out.println();
				break;
			case 3:
				tree.preorder();//print in preorder
				System.out.println();
				break;
			case 4:
				tree.PrintSplayTree();//print the tree 
				break;
			case 5:
				//End loop
				break;
			default:
				System.out.println("Sorry, thats not supported");
				break;// user entered unsupported input
			}
//exit the program 
			if (userOption == 5){
				System.out.println("the program has ended");
				break;
			}
		}
	}
}
