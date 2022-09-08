package comparator;

import java.util.Scanner;
//main class of the red black tree 
public class redBlackTreeMain {

	public static void main(String[] args) {
		

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int userOption = 0;
		int insert;
		redBlackTree rbt = new redBlackTree();
//while loop to ask the user for a command 
		while (true) {
			System.out.println("Please enter an action you'd like to take:");
			System.out.println("\t1) Enter a integer to insert in the red black tree");
			System.out.println("\t2) Print inorder");
			System.out.println("\t3) Print preorder");
			System.out.println("\t4 print RBT");
			System.out.println("\t5) End");

			userOption = scanner.nextInt();
			scanner.nextLine(); 

			switch (userOption){
			case 1:
				System.out.println("Please enter a integer to add");
				insert = scanner.nextInt();//asks the user for an input
				rbt.insert(insert);
				break;
			case 2:
				rbt.inorder();
				System.out.println();//print inorder
				break;
			case 3:
				rbt.preorder();
				System.out.println();//print in preorder
				break;
			case 4:
				rbt.printTree();//print rbt 
				
			case 5:
				//End loop
				break;
			default:
				System.out.println("Sorry, thats not supported");
				break;//user input not supported 
			}
//exit the program 
			if (userOption == 5){
				System.out.println("the program has ended");
				break;
			}
		}
	}
}