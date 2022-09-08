package tree.splay;
////Class that represents a splay tree
public class splayTree {

	private splayNode root;

	public splayTree() {
		root = null;
	}
//prints the tree structure
	private void printHelper(splayNode root, String indent, boolean last) {
		
		if (root != null) {
			System.out.print(indent);
			if (last) {
				System.out.print("Right--");
				indent += "     ";
			} else {
				System.out.print("Left--");
				indent += "|    ";
			}

			System.out.println(root.data);

			printHelper(root.left, indent, false);
			printHelper(root.right, indent, true);
		}
	}
	
	
	// prints the tree structure
		public void PrintSplayTree() {
			printHelper(this.root, "", true);
		}

	// rotate left 
	private void leftRotate(splayNode x) {
		splayNode y = x.right;
		x.right = y.left;
		if (y.left != null) {
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

	// rotate right 
	private void rightRotate(splayNode x) {
		splayNode y = x.left;
		x.left = y.right;
		if (y.right != null) {
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

	// Splay to move x to the root
	private void splay(splayNode x) {
		while (x.parent != null) {
			if (x.parent.parent == null) {
				if (x == x.parent.left) {
					// zig rotation
					rightRotate(x.parent);
				} else {
					// zag rotation
					leftRotate(x.parent);
				}
			} else if (x == x.parent.left && x.parent == x.parent.parent.left) {
				// zig-zig rotation
				rightRotate(x.parent.parent);
				rightRotate(x.parent);
			} else if (x == x.parent.right && x.parent == x.parent.parent.right) {
				// zag-zag rotation
				leftRotate(x.parent.parent);
				leftRotate(x.parent);
			} else if (x == x.parent.right && x.parent == x.parent.parent.left) {
				// zig-zag rotation
				leftRotate(x.parent);
				rightRotate(x.parent);
			} else {
				// zag-zig rotation
				rightRotate(x.parent);
				leftRotate(x.parent);
			}
		}
	}

	//helper for printing in preorder 
	private void preOrderHelper(splayNode node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preOrderHelper(node.left);
			preOrderHelper(node.right);
		} 
	}
	//helper for printing inorder 
	private void inOrderHelper(splayNode node) {
		if (node != null) {
			inOrderHelper(node.left);
			System.out.print(node.data + " ");
			inOrderHelper(node.right);
		} 
	}
//displays preorder
	public void preorder() {
		preOrderHelper(this.root);
	}
//displays inorder 
	public void inorder() {
		inOrderHelper(this.root);
	}
	
	// insert the key 
	public void insert(int key) {
		splayNode node = new splayNode(key);
		splayNode y = null;
		splayNode x = this.root;

		while (x != null) {
			y = x;
			if (node.data < x.data) {
				x = x.left;
			} else {
				x = x.right;
			}
		}

		// y is parent of x
		node.parent = y;
		if (y == null) {
			root = node;
		} else if (node.data < y.data) {
			y.left = node;
		} else {
			y.right = node;
		}

		// splay node
		splay(node);
	}
}
