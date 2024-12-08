package graph.traversal.bfs_on_graph_using_adjacency_matrix;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
	int[][] adjacencyMatrix;

	public Graph(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
		adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
	}

	// adding an undirected edge between 2 nodes having index 'i' & 'j'
	public void addUndirectedEdge(int i, int j) {
		adjacencyMatrix[i][j] = 1;
		adjacencyMatrix[j][i] = 1;
	}

	// print adjacency matrix
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("   ");
		for (int i = 0; i < nodeList.size(); i++) {
			sb.append(nodeList.get(i).name + " ");
		}
		sb.append("\n");
		for (int i = 0; i < nodeList.size(); i++) {
			sb.append(nodeList.get(i).name + ": ");
			for (int j : adjacencyMatrix[i]) {
				sb.append(j + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	// get Neighbors -- helper method for BFS
	public ArrayList<GraphNode> getNeighbors(GraphNode node) {
		ArrayList<GraphNode> neighbors = new ArrayList<GraphNode>();
		int nodeIndex = node.index;

		for (int i = 0; i < adjacencyMatrix.length; i++) {
			if (adjacencyMatrix[nodeIndex][i] == 1) {
				neighbors.add(nodeList.get(i));
			}
		}
		return neighbors;
	}

	// BFS internal -- helper method for BFS
	private void bfsVisit(GraphNode node) {
		LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(node);

		while (!queue.isEmpty()) {

			GraphNode currentNode = queue.remove(0);
			currentNode.isVisited = true;

			System.out.print(currentNode.name + " ");

			ArrayList<GraphNode> neighbors = getNeighbors(currentNode); // getting neighbors of current node
			for (GraphNode neighbor : neighbors) {
				if (!neighbor.isVisited) {
					queue.add(neighbor);
					neighbor.isVisited = true;
				}
			}
		}
		System.out.println();
	}

	public void bfs() {
		for (GraphNode node : nodeList) {
			if (!node.isVisited) { // applying bfs on every node as 'graph' can have unconnected components
				bfsVisit(node);
			}
		}
	}
}