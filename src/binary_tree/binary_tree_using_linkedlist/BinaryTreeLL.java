package binary_tree.binary_tree_using_linkedlist;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLL {
	public BinaryNode root;

	public BinaryTreeLL() {
		root = null;
	}

	// PreOrder Traversal
	public void preOrder(BinaryNode node) {
		if (node == null) { // base condition for recursion
			return;
		}
		System.out.print(node.value + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	// InOrder Traversal
	public void inOrder(BinaryNode node) {
		if (node == null) { // base condition for recursion
			return;
		}
		inOrder(node.left);
		System.out.print(node.value + " ");
		inOrder(node.right);
	}

	// PostOrder Traversal
	public void postOrder(BinaryNode node) {
		if (node == null) { // base condition for recursion
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value + " ");
	}

	// LevelOrder Traversal
	public void levelOrder() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
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
	}

	// Search Node
	public void search(String value) {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);

		while (!queue.isEmpty()) {

			BinaryNode parentNode = queue.remove();

			if (parentNode.value == value) {
				System.out.println(value + " node is present in the tree");
				return;
			} else {
				if (parentNode.left != null) {
					queue.add(parentNode.left);
				}
				if (parentNode.right != null) {
					queue.add(parentNode.right);
				}
			}

		}
		System.out.println(value + " node does not exist!");
	}

	// Insert Method
	public void insert(String value) {
		BinaryNode newNode = new BinaryNode();
		newNode.value = value;

		if (root == null) {
			root = newNode;
			System.out.println("Inserted new-node at the Root");
			return;
		}
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode parent = queue.remove();
			if (parent.left == null) {
				parent.left = newNode;
				System.out.println("Successfully inserted!!");
				break;
			} else if (parent.right == null) {
				parent.right = newNode;
				System.out.println("Successfully inserted!!");
				break;
			} else {
				queue.add(parent.left);
				queue.add(parent.right);
			}
		}
	}

	// method1() -- Get Deepest node
	public BinaryNode getDeepestNode() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);

		BinaryNode parent = null; // this will HOLD the deepest node of the BinaryTree
		while (!queue.isEmpty()) {

			parent = queue.remove();

			if (parent.left != null) {
				queue.add(parent.left);
			}
			if (parent.right != null) {
				queue.add(parent.right);
			}

		}
		return parent;
	}

	// method2() -- Delete deepest node
	public void deleteDeepestNode() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);

		BinaryNode previousNode = null;
		BinaryNode presentNode = null;
		while (!queue.isEmpty()) {

			previousNode = presentNode;
			presentNode = queue.remove();
			if (presentNode.left == null) {
				previousNode.right = null;
				return;
			} else if (presentNode.right == null) {
				presentNode.left = null;
				return;
			}
			queue.add(presentNode.left);
			queue.add(presentNode.right);
		}
	}

	// method3() -- Delete given Node
	public void deleteNode(String value) {
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			BinaryNode parent = queue.remove();

			if (parent.value == value) {
				parent.value = getDeepestNode().value; // replacing the value of node to be deleted with deepest-node
				deleteDeepestNode(); // deleting the deepest node
				System.out.println("The node is deleted!");
				return;
			} else {
				if (parent.left != null) {
					queue.add(parent.left);
				}
				if (parent.right != null) {
					queue.add(parent.right);
				}
			}
		}
		System.out.println("The given Node does not exist!");
	}

	// Delete Binary Tree
	public void deleteBT() {
		root = null;
		System.out.println("Binary Tree has been successfully deleted!");
	}
}
