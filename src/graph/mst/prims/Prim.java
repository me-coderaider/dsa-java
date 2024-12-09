package graph.mst.prims;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prim {
	ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();

	public Prim(ArrayList<WeightedNode> nodeList) {
		this.nodeList = nodeList;
	}

	// adding 'weighted undirected' edge
	public void addWeightedUndirectedEdge(int i, int j, int weight) {

		WeightedNode first = nodeList.get(i);
		WeightedNode second = nodeList.get(j);

		first.neighbors.add(second);
		second.neighbors.add(first);

		first.weightMap.put(second, weight);
		second.weightMap.put(first, weight);
	}

	// Prim's Algorithm
	public void prims(WeightedNode node) {

		for (int i = 0; i < nodeList.size(); i++) {
			nodeList.get(i).distance = Integer.MAX_VALUE;
		}

		node.distance = 0;
		PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
		queue.addAll(nodeList);

		while (!queue.isEmpty()) {
			WeightedNode currentNode = queue.remove();

			for (WeightedNode neighbor : currentNode.neighbors) {
				if (queue.contains(neighbor)) {
					// if current-weight > current-edge
					if (neighbor.distance > currentNode.weightMap.get(neighbor)) {
						neighbor.distance = currentNode.weightMap.get(neighbor);
						neighbor.parent = currentNode;
						// refreshing the queue
						queue.remove(neighbor);
						queue.add(neighbor);
					}
				}
			}
		}

		int cost = 0;
		for (WeightedNode nodeToCheck : nodeList) {
			System.out
					.println("Node " + nodeToCheck + ", Key " + nodeToCheck.distance + " Parent " + nodeToCheck.parent);
			cost += nodeToCheck.distance;
		}

		System.out.println("Total cost of MST: " + cost);
	}

}
