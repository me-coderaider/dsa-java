package avl_tree;

public class BinaryNode {
	public int value;
	public int height;
	public BinaryNode left;
	public BinaryNode right;

	public BinaryNode() {
		this.height = 0;
	}

	@Override
	public String toString() {
		return " " + value;
	}
}
