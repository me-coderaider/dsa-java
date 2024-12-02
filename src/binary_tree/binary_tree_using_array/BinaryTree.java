package binary_tree.binary_tree_using_array;

public class BinaryTree {
	String[] arr;
	int lastUsedIndex; // useful for us and for some other operations

	public BinaryTree(int size) {
		arr = new String[size + 1];
		this.lastUsedIndex = 0;
		System.out.println("Blank Tree of size " + size + " has been created.");
	}

	// isFull()
	public boolean isFull() {
		if (lastUsedIndex == arr.length - 1) {
			return true;
		} else {
			return false;
		}
	}

	// insert() method
	public void insert(String value) {
		if (!isFull()) {
			arr[lastUsedIndex + 1] = value;
			lastUsedIndex++;
			System.out.println("The value of " + value + " has been inserted");
		} else {
			System.out.println("The BT is full!");
		}
	}

	// preOrder() Traversal
	public void preOrder(int index) {
		if (index > lastUsedIndex) {
			return;
		}
		System.out.print(arr[index] + " ");
		preOrder(index * 2);
		preOrder(index * 2 + 1);
	}

	// inOrder() Traversal
	public void inOrder(int index) {
		if (index > lastUsedIndex) {
			return;
		}
		inOrder(index * 2);
		System.out.print(arr[index] + " ");
		inOrder(index * 2 + 1);
	}

	// postOrder() Traversal
	public void postOrder(int index) {
		if (index > lastUsedIndex) {
			return;
		}
		postOrder(index * 2);
		postOrder(index * 2 + 1);
		System.out.print(arr[index] + " ");
	}

	// levelOrder() traversal
	public void levelOrder() {
		for (int i = 1; i <= lastUsedIndex; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// search()
	public int search(String value) {
		for (int i = 1; i <= lastUsedIndex; i++) {
			if (arr[i].equals(value)) {
				System.out.println(value + " exists at the location: " + i);
				return i;
			}
		}
		System.out.println("Value does not exist!");
		return -1;
	}

	// delete() method
	public void delete(String value) {
		int location = search(value);
		if (location == -1) {
			return;
		} else {
			arr[location] = arr[lastUsedIndex];
			lastUsedIndex--;
			System.out.println("The node is successfully deleted!");
		}
	}

	// deleteBT()
	public void deleteBT() {
		try {
			arr = null;
			System.out.println("BT has been successfully deleted!!");
		} catch (Exception e) {
			System.out.println("There was an error while deleting the tree.");
		}
	}
}
