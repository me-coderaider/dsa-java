import binary_tree.binary_tree_using_array.BinaryTree;

class Main {

	public static void main(String[] args) {
		// BinaryTree using Array
		
		BinaryTree newBinaryTree=new BinaryTree(9);
		newBinaryTree.insert("N1");
		newBinaryTree.insert("N2");
		newBinaryTree.insert("N3");
		newBinaryTree.insert("N4");
		newBinaryTree.insert("N5");
		newBinaryTree.insert("N6");
		newBinaryTree.insert("N7");
		newBinaryTree.insert("N8");
		newBinaryTree.insert("N9");
		
//		newBinaryTree.preOrder(1);
//		newBinaryTree.search("N11");
//		newBinaryTree.preOrder(1);
//		System.out.println();
//		newBinaryTree.inOrder(1);
//		System.out.println();
//		newBinaryTree.postOrder(1);
//		System.out.println();
		newBinaryTree.levelOrder();
		newBinaryTree.delete("N5");
		newBinaryTree.levelOrder();
		
		newBinaryTree.deleteBT();
	}
}