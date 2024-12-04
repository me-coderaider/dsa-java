import avl_tree.AVL;

class Main {

	public static void main(String[] args) {
		// AVL TREE
		AVL avl=new AVL();
		avl.insert(5);
		avl.insert(10);
		avl.insert(15);
		avl.insert(20);
		avl.levelOrder();
		
		avl.delete(5);
//		System.out.println();
		avl.levelOrder();
		
		avl.deleteAVL();
	}
}