package comparator;
////Class that represents a RBT
public class redBlackTree {
	private Node root;
	private Node NULL;
	//Preorder helper 
	private void preOrderHelper(Node node) {
		if (node != NULL) {
			//Print data and color 
			System.out.print(node.data);
			if(node.color == 0) {
				System.out.print("(Black) ");
			} else {
				System.out.print("(Red) ");
			}
			preOrderHelper(node.left);
			preOrderHelper(node.right);
		}
	}

	// Inorder helper 
	private void inOrderHelper(Node node) {
		if (node != NULL) {
			inOrderHelper(node.left);
			//Print data and color 
			System.out.print(node.data);
			if(node.color == 0) {
				System.out.print("(Black) ");
			} else {
				System.out.print("(Red) ");
			}
			inOrderHelper(node.right);
		}
	}
	//Balances the node after insertion
	private void balanceInsert(Node z) {
		Node u;
		while (z.parent.color == 1) {
			if (z.parent == z.parent.parent.right) {
				u = z.parent.parent.left;
				if (u.color == 1) {
					u.color = 0;
					z.parent.color = 0;
					z.parent.parent.color = 1;
					z = z.parent.parent;
				} else {
					if (z == z.parent.left) {
						z = z.parent;
						rightRotate(z);
					}
					z.parent.color = 0;
					z.parent.parent.color = 1;
					leftRotate(z.parent.parent);
				}
			} else {
				u = z.parent.parent.right;

				if (u.color == 1) {
					u.color = 0;
					z.parent.color = 0;
					z.parent.parent.color = 1;
					z = z.parent.parent;
				} else {
					if (z == z.parent.right) {
						z = z.parent;
						leftRotate(z);
					}
					z.parent.color = 0;
					z.parent.parent.color = 1;
					rightRotate(z.parent.parent);
				}
			}
			if (z == root) {
				break;
			}
		}
		root.color = 0;
	}
//print helper to print the tree structure 
	private void printHelper(Node root, String indent, boolean last) {
		if (root != NULL) {
			System.out.print(indent);
			if (last) {
				System.out.print("Right---");
				indent += "   ";
			} else {
				System.out.print("Left--");
				indent += "|  ";
			}
			String sColor = root.color == 1 ? "Red" : "Black";
			System.out.println(root.data + "(" + sColor + ")");
			printHelper(root.left, indent, false);
			printHelper(root.right, indent, true);
		}
	}

	public redBlackTree() {
		NULL = new Node();
		NULL.color = 0;
		NULL.left = null;
		NULL.right = null;
		root = NULL;
	}
//print preorder
	public void preorder() {
		preOrderHelper(this.root);
	}
//print inorder 
	public void inorder() {
		inOrderHelper(this.root);
	}
	
	
//rotate left
	public void leftRotate(Node x) {
		Node y = x.right;
		x.right = y.left;
		if (y.left != NULL) {
			y.left.parent = x;
		}
		y.parent = x.parent;
		if (x.parent == null) {
			this.root = y;
		} else if (x == x.parent.left) {
			x.parent.left = y;
		} else {
			x.parent.right = y;
		}
		y.left = x;
		x.parent = y;
	}
//rotate right
	public void rightRotate(Node x) {
		Node y = x.left;
		x.left = y.right;
		if (y.right != NULL) {
			y.right.parent = x;
		}
		y.parent = x.parent;
		if (x.parent == null) {
			this.root = y;
		} else if (x == x.parent.right) {
			x.parent.right = y;
		} else {
			x.parent.left = y;
		}
		y.right = x;
		x.parent = y;
	}
//insert method
	public void insert(int key) {
		Node node = new Node();
		node.parent = null;
		node.data = key;
		node.left = NULL;
		node.right = NULL;
		node.color = 1;

		Node y = null;
		Node x = this.root;

		while (x != NULL) {
			y = x;
			if (node.data < x.data) {
				x = x.left;
			} else {
				x = x.right;
			}
		}

		node.parent = y;
		if (y == null) {
			root = node;
		} else if (node.data < y.data) {
			y.left = node;
		} else {
			y.right = node;
		}

		if (node.parent == null) {
			node.color = 0;
			return;
		}

		if (node.parent.parent == null) {
			return;
		}

		balanceInsert(node);
	}
//getter return root
	public Node getRoot() {
		return this.root;
	}
//prints the RBT
	public void printTree() {
		printHelper(this.root, "", true);
	}
}