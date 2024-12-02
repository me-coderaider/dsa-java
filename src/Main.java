import binary_search_tree.BinarySearchTree;

class Main {

	public static void main(String[] args) {
		// BinarySearchTree using LinkedList

		BinarySearchTree newBST = new BinarySearchTree();
		newBST.insert(70);
		newBST.insert(50);
		newBST.insert(90);
		newBST.insert(30);
		newBST.insert(60);
		newBST.insert(80);
		newBST.insert(100);
		newBST.insert(20);
		newBST.insert(40);

//		newBST.preOrder(newBST.root);
//		System.out.println();
//
//		newBST.inOrder(newBST.root);
//		System.out.println();
//
//		newBST.postOrder(newBST.root);
//		System.out.println();
//		
//		newBST.levelOrder(newBST.root);
		
//		newBST.search(newBST.root, 41);
		newBST.levelOrder(newBST.root);
		System.out.println();
		newBST.deleteNode(newBST.root, 90);
		newBST.levelOrder(newBST.root);
		
		newBST.deleteBST();
	}
}