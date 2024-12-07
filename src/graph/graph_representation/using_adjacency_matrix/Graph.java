package graph.graph_representation.using_adjacency_matrix;

import java.util.ArrayList;

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
}
