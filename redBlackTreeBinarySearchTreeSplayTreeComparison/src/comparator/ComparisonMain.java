package comparator;
import java.util.Random;

import binarySearchTree.BinaryTree;
import tree.splay.splayTree;

//Class that compares the tree structures
public class ComparisonMain {

	public static void main(String[] args) {
		//create the array of seeds to use and n values 
		int[] seeds = {12321,45223,13577,99822,5683};
		int[] ns = {50000, 100000, 200000, 400000};
		//create a Random object
		Random rand = new Random();

		//1. Binary Search Tree
		System.out.println("Binary Search Tree");
		for(int n = 0; n < ns.length; n++) {
			//Loop for all seeds
			double sum = 0;
			for(int s = 0; s < seeds.length; s++) {
				//Set seed, initialize a new BST, start timer, produce n values and insert them into tree
				rand.setSeed(s);
				BinaryTree<Integer> bst = new BinaryTree<Integer>();
				long start = System.currentTimeMillis();
				for(int i = 0; i < ns[n]; i++) {
					bst.insert(rand.nextInt(4*ns[n])+1); //random number between 1 and 4n
				}
				//Stop timer and add result to sum of times
				sum += (System.currentTimeMillis() - start);
			}
			//after all seeds are tested, find average and print
			double avg = sum / seeds.length;
			System.out.printf("Average time for n = %d -> %.2f ms\n", ns[n], avg);
		}

		//2. Red Black Tree
		System.out.println("\nRed Black Tree");
		for(int n = 0; n < ns.length; n++) {
			//Loop for all seeds
			double sum = 0;
			for(int s = 0; s < seeds.length; s++) {
				//Set seed, initialize a new RBT, start timer, produce n values and insert them into tree
				rand.setSeed(s);
				redBlackTree tree = new redBlackTree();
				long start = System.currentTimeMillis();
				for(int i = 0; i < ns[n]; i++) {
					tree.insert(rand.nextInt(4*ns[n])+1); //random number between 1 and 4n
				}
				//Stop timer and add result to sum of times
				sum += (System.currentTimeMillis() - start);
			}
			//Once all seeds tested, find average and print it
			double avg = sum / seeds.length;
			System.out.printf("Average time for n = %d -> %.2f ms\n", ns[n], avg);
		}

		//3. Splay Tree
		System.out.println("\nSplay Tree");
		for(int n = 0; n < ns.length; n++) {
			//Loop for all seeds
			double sum = 0;
			for(int s = 0; s < seeds.length; s++) {
				//Set seed, initialize a new ST, start timer, produce n values and insert them into tree
				rand.setSeed(s);
				splayTree tree = new splayTree();
				long start = System.currentTimeMillis();
				for(int i = 0; i < ns[n]; i++) {
					tree.insert(rand.nextInt(4*ns[n])+1); //random number between 1 and 4n
				}
				//Stop timer and add result to sum of times
				sum += (System.currentTimeMillis() - start);
			}
			//after all seeds are tested, find average and print it
			double avg = sum / seeds.length;
			System.out.printf("Average time for n = %d -> %.2f ms\n", ns[n], avg);
		}
	}
}