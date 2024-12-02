package binary_search_tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
	public BinaryNode root;

	public BinarySearchTree() {
		root = null;
	}

	// insert() Method -- HELPER method for insert
	private BinaryNode insert(BinaryNode currentNode, int value) {
		if (currentNode == null) { // Base condition for our recursive scenario
			BinaryNode newNode = new BinaryNode();
			newNode.value = value;
			System.out.println("The value is successfully inserted!");
			return newNode;
		} else if (value <= currentNode.value) {
			currentNode.left = insert(currentNode.left, value);
			return currentNode;
		} else {
			currentNode.right = insert(currentNode.right, value);
			return currentNode;
		}
	}

	public void insert(int value) {
		root = insert(root, value);
	}

	// preOrder Traversal
	public void preOrder(BinaryNode node) {
		if (node == null) {
			return;
		}
		System.out.print(node.value + " ");
//		System.out.print(node + " "); // BinaryNode class's 'toString()' will be used to print node
		preOrder(node.left);
		preOrder(node.right);
	}

	// inOrder Traversal
	public void inOrder(BinaryNode node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.value + " ");
//		System.out.print(node + " "); // BinaryNode class's 'toString()' will be used to print node
		inOrder(node.right);
	}

	// postOrder Traversal
	public void postOrder(BinaryNode node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value + " ");
//		System.out.print(node + " "); // BinaryNode class's 'toString()' will be used to print node
	}

	// levelOrder Traversal
	public void levelOrder(BinaryNode node) {
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(node);

		while (!queue.isEmpty()) {

			BinaryNode parent = queue.remove();
			System.out.print(parent.value + " ");
			if (parent.left != null) {
				queue.add(parent.left);
			}
			if (parent.right != null) {
				queue.add(parent.right);
			}
		}
	}

	// search() -- using RECURSION
	public BinaryNode search(BinaryNode node, int value) {
		if (node == null) { // Base Condition 1
			System.out.println("Value: " + value + " not found in BST");
			return null;
		} else if (node.value == value) { // Base Condition 2
			System.out.println("Value: " + value + " found in BST");
			return node;
		} else if (value < node.value) {
			return search(node.left, value);
		} else {
			return search(node.right, value);
		}
	}

	// SUCCESSOR node -- minimum in right-tree
	public static BinaryNode minimumNode(BinaryNode root) {
		if (root.left == null) { // Base condition
			return root;
		} else {
			return minimumNode(root.left);
		}
	}

	// delete node
	public BinaryNode deleteNode(BinaryNode root, int value) {
		if (root == null) {
			System.out.println("Value not found in BST");
			return null;
		}
		if (value < root.value) {
			root.left = deleteNode(root.left, value);
		} else if (value > root.value) {
			root.right = deleteNode(root.right, value);
		} else {
			// we've to implement those 3 deletion cases here::
			if (root.left != null && root.right != null) { // node has 2 children
				BinaryNode temp = root;
				BinaryNode minNodeForRight = minimumNode(temp.right);
				root.value = minNodeForRight.value;
				root.right = deleteNode(root.right, minNodeForRight.value);

			} else if (root.left != null) { // node has 1 children
				root = root.left;
			} else if (root.right != null) { // node has 1 children
				root = root.right;
			} else { // node is leaf-node or has 0 children
				root = null;
			}
		}
		return root;
	}
	
	// deleteBST()
	public void deleteBST() {
		root=null;
		System.out.println("BST has been deleted Successfully");
	}
}
