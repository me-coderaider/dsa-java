package disjoint_set;

import java.util.ArrayList;

public class DisjointSet {
	// 'private' nodeList
	private ArrayList<WeightedNode> nodeList = new ArrayList<>();

	// 1. makeSet()  -- for now, this will create 'set' of individual nodes
	public static void makeSet(ArrayList<WeightedNode> nodeList) {
		for (WeightedNode node : nodeList) {
			DisjointSet set = new DisjointSet();
			set.nodeList.add(node);
			node.set = set;
		}
	}

	// 3. findSet()
	public static DisjointSet findSet(WeightedNode node) {
		return node.set;
	}

	// 2. union()
	public static DisjointSet union(WeightedNode node1, WeightedNode node2) {
		if (node1.set.equals(node2.set)) {
			return null;
		} else {
			DisjointSet set1 = node1.set;
			DisjointSet set2 = node2.set;

			if (set1.nodeList.size() > set2.nodeList.size()) {
				// adding 'set2' smaller set nodes in 'set1'
				ArrayList<WeightedNode> nodeSet2 = set2.nodeList;
				for (WeightedNode node : nodeSet2) {
					set1.nodeList.add(node);
				}
				return set1;
			} else {
				// adding 'set1' smaller set nodes in 'set2'
				ArrayList<WeightedNode> nodeSet1 = set1.nodeList;
				for (WeightedNode node : nodeSet1) {
					set2.nodeList.add(node);
				}
				return set2;
			}
		}
	}

	// helper function to print all sets
	public void printAllNodesofThisSet() {
		System.out.println("Printing all nodes of the set:");
		for (WeightedNode node : nodeList) {
			System.out.print(node + " ");
		}
		System.out.println();
	}
}
