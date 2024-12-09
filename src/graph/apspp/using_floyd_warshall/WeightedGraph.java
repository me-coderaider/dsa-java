package graph.apspp.using_floyd_warshall;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class WeightedGraph {
	ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();

	public WeightedGraph(ArrayList<WeightedNode> nodeList) {
		this.nodeList = nodeList;
	}

	// Dijkstra's Algorithm
	public void dijkstra(WeightedNode node) {
		PriorityQueue<WeightedNode> queue = new PriorityQueue<WeightedNode>();
		node.distance = 0;
		queue.addAll(nodeList); // adding all the nodes in the 'Priority Queue';
		while (!queue.isEmpty()) {

			WeightedNode currentNode = queue.remove();

			for (WeightedNode neighbor : currentNode.neighbors) {
				if (queue.contains(neighbor)) {
					if (neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
						neighbor.distance = currentNode.distance + currentNode.weightMap.get(neighbor);
						neighbor.parent = currentNode;
						// to refresh the 'PriorityQueue', we'll remove & add this 'neighbor' again
						queue.remove(neighbor);
						queue.add(neighbor);
					}
				}
			}
		}

		for (WeightedNode nodeToCheck : nodeList) {
			System.out.print("Node " + nodeToCheck + ", Distance: " + nodeToCheck.distance + ", Path: ");
			pathPrint(nodeToCheck);
			System.out.println();
		}

	}

	// pathPrint()
	public static void pathPrint(WeightedNode node) {
		if (node.parent != null) {
			pathPrint(node.parent);
		}
		System.out.print(node.name + " ");
	}

	// addWeightedEdge
	public void addWeightedEdge(int i, int j, int weight) {
		WeightedNode first = nodeList.get(i);
		WeightedNode second = nodeList.get(j);
		first.neighbors.add(second);// it's a directed-edge
		first.weightMap.put(second, weight); // adding weight to directed-edge
	}

	// Bellman Ford Algorithm for SSSPP and for dealing with '-ve cycle'
	public void bellmanFord(WeightedNode sourceNode) {
		sourceNode.distance = 0;
		// iterating 'V-1' times over nodeList
		for (int i = 0; i < nodeList.size() - 1; i++) {
			// iterating over all nodes's neighbor means to cover all the 'edges'
			for (WeightedNode currentNode : nodeList) {
				for (WeightedNode neighbor : currentNode.neighbors) {
					if (neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
						neighbor.distance = currentNode.distance + currentNode.weightMap.get(neighbor);
						neighbor.parent = currentNode;
					}
				}
			}
		}

		System.out.println("Checking for Negative Cycle...");
		for (WeightedNode currentNode : nodeList) {
			for (WeightedNode neighbor : currentNode.neighbors) {
				if (neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
					System.out.println("Negative Cycle found:");
					System.out.println("Vertex name: " + neighbor.name);
					System.out.println("Old cost: " + neighbor.distance);
					int newCost = currentNode.distance + currentNode.weightMap.get(neighbor);
					System.out.println("New cost: " + newCost);
					return;
				}
			}
		}
		System.out.println("Negative Cycle Not Found!!");

		for (WeightedNode nodeToCheck : nodeList) {
			System.out.print("Node " + nodeToCheck + ", Distance: " + nodeToCheck.distance + ", Path: ");
			pathPrint(nodeToCheck);
			System.out.println();
		}
	}

	// 'APSPP' -- All Pair Shortest Path Problem -- using 'Floyd Warshall' algorithm
	public void floydWarshall() {
		// creating a new matrix of size same as 'nodeList'
		int size = nodeList.size();
		int[][] V = new int[size][size];

		for (int i = 0; i < size; i++) {
			WeightedNode first = nodeList.get(i);
			for (int j = 0; j < size; j++) {
				WeightedNode second = nodeList.get(j);
				if (i == j) {
					V[i][j] = 0;
				} else if (first.weightMap.containsKey(second)) {
					V[i][j] = first.weightMap.get(second);
				} else {
					V[i][j] = Integer.MAX_VALUE / 10;
				}
			}
		}

		// floydWarshall() -- logic
		for (int k = 0; k < size; k++) { // iterating of nodesList
			for (int i = 0; i < size; i++) { // iterating the matrix with i & j
				for (int j = 0; j < size; j++) {
					if (V[i][j] > V[i][k] + V[k][j]) { // going i -> j via k
						V[i][j] = V[i][k] + V[k][j];
					}
				}
			}
		}

		// printing the shortest path
		for (int i = 0; i < size; i++) {
			System.out.print("Printing distance list for node " + nodeList.get(i) + ": ");
			for (int j = 0; j < size; j++) {
				System.out.print(V[i][j] + " ");
			}
			System.out.println();
		}
	}
}
