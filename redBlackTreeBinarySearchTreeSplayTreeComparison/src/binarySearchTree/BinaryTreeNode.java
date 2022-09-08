package binarySearchTree;

import java.io.Serializable;

public class BinaryTreeNode<E> implements Serializable {

	//Default serialization UID
	private static final long serialVersionUID = 1L;

	//Fields of the class
	private E data;
	private BinaryTreeNode<E> leftChild;
	private BinaryTreeNode<E> rightChild;

	//Constructor of the class
	public BinaryTreeNode(E data) {
		this.data=data;
	}

	//Getter for data
	public E getData() {
		return data;
	}

	//Setter for data
	public void setData(E data) {
		this.data = data;
	}

	//Getter for left child
	public BinaryTreeNode<E> getLeftChild() {
		return leftChild;
	}

	//Setter for left child
	public void setLeftChild(BinaryTreeNode<E> leftChild) {
		this.leftChild = leftChild;
	}

	//Getter for right child
	public BinaryTreeNode<E> getRightChild() {
		return rightChild;
	}

	//Setter for right child
	public void setRightChild(BinaryTreeNode<E> rightChild) {
		this.rightChild = rightChild;
	}

}