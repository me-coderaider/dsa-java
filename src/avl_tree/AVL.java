package avl_tree;

import java.util.LinkedList;
import java.util.Queue;

public class AVL {
	BinaryNode root;

	public AVL() {
		root = null;
	}

	// preOrder Traversal
	public void preOrder(BinaryNode node) {
		if (node == null) {
			return;
		}
		System.out.print(node);
		preOrder(node.left);
		preOrder(node.right);
	}

	// inOrder Traversal
	public void inOrder(BinaryNode node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node);
		inOrder(node.right);
	}

	// postOrder Traversal
	public void postOrder(BinaryNode node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node + " ");
	}

	// levelOrder Traversal
	public void levelOrder() {
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);

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
		System.out.println();
	}

	// search() method -- recursive manner
	public BinaryNode search(BinaryNode node, int value) {
		if (node == null) { // base condition 1
			System.out.println("Value: " + value + " not found in BST.");
			return null;
		} else if (node.value == value) { // base condition 2
			System.out.println("Value: " + value + " found in BST.");
			return node;
		} else if (value < node.value) {
			return search(node.left, value);
		} else {
			return search(node.right, value);
		}
	}

// getHeight() -- helper function for insert()
	public int getHeight(BinaryNode node) {
		if (node == null) {
			return 0;
		}
		return node.height;
	}

// rotateRight() -- helper function for insert()
	private BinaryNode rotateRight(BinaryNode imbalancedNode) {
		BinaryNode newRoot = imbalancedNode.left;
		imbalancedNode.left = imbalancedNode.left.right;
		newRoot.right = imbalancedNode;

		// as we've changed 2 nodes(imbalanced-node, newRoot) after ROTATION, so we'll
		// be updating their heights
		imbalancedNode.height = 1 + Math.max(getHeight(imbalancedNode.left), getHeight(imbalancedNode.right));
		newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));

		return newRoot;
	}

// rotateLeft() -- helper function for insert()
	private BinaryNode rotateLeft(BinaryNode imbalancedNode) {
		BinaryNode newRoot = imbalancedNode.right;
		imbalancedNode.right = imbalancedNode.right.left;
		newRoot.left = imbalancedNode;

		// as we've changed 2 nodes(imbalanced-node, newRoot) after ROTATION, so we'll
		// be updating their heights
		imbalancedNode.height = 1 + Math.max(getHeight(imbalancedNode.left), getHeight(imbalancedNode.right));
		newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));

		return newRoot;
	}

// getBalance() -- helper function for insert()
	public int getBalance(BinaryNode node) {
		if (node == null) {
			return 0;
		}
//		return Math.abs(getHeight(node.left) - getHeight(node.right));
		return getHeight(node.left) - getHeight(node.right); // difference 'sign' will determine the the type of
																// rotation
	}

// insertNode() -- helper function for insert()
	private BinaryNode insertNode(BinaryNode node, int nodeValue) {
		// considering both if ROTATION required or not.
		if (node == null) { // base condition for recursive case
			BinaryNode newNode = new BinaryNode();
			newNode.value = nodeValue;
			newNode.height = 1;
			return newNode;
		} else if (nodeValue < node.value) {
			node.left = insertNode(node.left, nodeValue);
		} else {
			node.right = insertNode(node.right, nodeValue);
		}

		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

		int balance = getBalance(node);

		if (balance > 1 && nodeValue < node.left.value) { // Left-Left Condition
			return rotateRight(node);
		}

		if (balance > 1 && nodeValue > node.left.value) { // Left-Right Condition
			node.left = rotateLeft(node.left);
			return rotateRight(node);
		}

		if (balance < -1 && nodeValue > node.right.value) { // Right Right condition
			return rotateLeft(node);
		}

		if (balance < -1 && nodeValue < node.right.value) { // Right Left condition
			node.right = rotateRight(node.right);
			return rotateLeft(node);
		}
		return node;
	}

// insert()
	public void insert(int value) {
		root = insertNode(root, value);
	}

	// getMinimum() -- to get minimum node from right-subtree, 'SUCCESSOR' -- helper
	// function for delete()
	// will be called with 'root.right' value
	public static BinaryNode minimumNode(BinaryNode root) {
		if (root.left == null) {
			return root;
		}
		return minimumNode(root.left);
	}

	// deleteNode() -- helper function for delete()
	private BinaryNode deleteNode(BinaryNode node, int value) {
		// considering both if ROTATION required or not.
		if (node == null) {
			System.out.println("Value not found in AVL tree.");
			return node;
		}
		if (value < node.value) {
			node.left = deleteNode(node.left, value);
		} else if (value > node.value) {
			node.right = deleteNode(node.right, value);
		} else {
			// 3 cases, if node is leaf, 1 or 2 children
			if (node.left != null && node.right != null) { // 2 children
				BinaryNode temp = node;
				BinaryNode minNodeForRight = minimumNode(temp.right);
				node.value = minNodeForRight.value;
				node.right = deleteNode(node.right, minNodeForRight.value);
			} else if (node.left != null) { // 1 child
				node = node.left;
			} else if (node.right != null) { // 1 child
				node = node.right;
			} else { // 0 child
				node = null;
			}
		}

		// checking if BALANCING is required or not after deletion
		int balance = getBalance(node);

		if (balance > 1 && getBalance(node.left) >= 0) { // Left Left condition
			return rotateRight(node);
		}

		if (balance > 1 && getBalance(node.left) < 0) { // Left Right condition
			node.left = rotateLeft(node.left);
			return rotateRight(node);
		}

		if (balance < -1 && getBalance(node.right) <= 0) { // Right Right condition
			return rotateLeft(node);
		}

		if (balance < -1 && getBalance(node.right) > 0) { // Right Left condition
			node.right = rotateRight(node.right);
			return rotateLeft(node);
		}
		return node;
	}

	public void delete(int value) {
		root = deleteNode(root, value);
	}

	// deleteAVL() -- delete entire tree
	public void deleteAVL() {
		root = null;
		System.out.println("AVL Tree has been deleted successfully.");
	}
}
