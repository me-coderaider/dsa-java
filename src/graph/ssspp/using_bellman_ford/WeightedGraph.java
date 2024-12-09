package graph.ssspp.using_bellman_ford;

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
		for (int i = 0; i < nodeList.size()-1; i++) {
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
}
