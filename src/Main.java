import java.util.ArrayList;

import disjoint_set.DisjointSet;
import disjoint_set.WeightedNode;

class Main {

	public static void main(String[] args) {
		// DisjointSet
		ArrayList<WeightedNode> nodeList = new ArrayList<>();
		nodeList.add(new WeightedNode("A"));
		nodeList.add(new WeightedNode("B"));
		nodeList.add(new WeightedNode("C"));
		nodeList.add(new WeightedNode("D"));

		DisjointSet.makeSet(nodeList);
		WeightedNode firstNode = nodeList.get(0);
		WeightedNode secondNode = nodeList.get(1);

		DisjointSet output = DisjointSet.findSet(secondNode);
		output.printAllNodesofThisSet();
		
		DisjointSet.union(firstNode, secondNode);  
		output = DisjointSet.findSet(secondNode);
		output.printAllNodesofThisSet();
	}

}