package binary_search_tree;

public class BinaryNode {
	public int value;
	public int height; // will be used to store the height of the 'node'
	public BinaryNode left;
	public BinaryNode right;
	
	@Override
	public String toString() {
		return value+" ";
	}
}
