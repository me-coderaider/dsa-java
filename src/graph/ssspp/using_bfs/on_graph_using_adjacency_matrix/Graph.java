package graph.ssspp.using_bfs.on_graph_using_adjacency_matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

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

	// dfsVisit() internal -- helper method for BFS
	private void dfsVisit(GraphNode node) {
		Stack<GraphNode> stack = new Stack<GraphNode>();
		stack.push(node);

		while (!stack.isEmpty()) {
			GraphNode currentNode = stack.pop();
			currentNode.isVisited = true;
			System.out.print(currentNode.name + " ");

			// getting 'neighbors' of currentNode
			ArrayList<GraphNode> neighbors = getNeighbors(currentNode);
			for (GraphNode neighbor : neighbors) {
				if (!neighbor.isVisited) {
					stack.push(neighbor);
					neighbor.isVisited = true;
				}
			}
		}
		System.out.println();
	}

	// dfs()
	public void dfs() {
		for (GraphNode node : nodeList) {
			if (!node.isVisited) {
				dfsVisit(node);
			}
		}
	}

	// TOPOLOGICAL SORT

	// addDirectedEdge -- to show dependencies we need 'directed' edge
	public void addDirectedEdge(int i, int j) {
		adjacencyMatrix[i][j] = 1;
	}

	// topologicalVisit -- helper function for topologicalSort()
	private void topologicalVisit(GraphNode node, Stack<GraphNode> stack) {
		ArrayList<GraphNode> neighbors = getNeighbors(node);
		for (GraphNode neighbor : neighbors) {
			if (!neighbor.isVisited) {
				topologicalVisit(neighbor, stack);
			}
		}
		node.isVisited = true;
		stack.push(node);
	}

	// topologicalSort()
	public void topologicalSort() {
		Stack<GraphNode> stack = new Stack<GraphNode>();
		for (GraphNode node : nodeList) {
			if (!node.isVisited) {
				topologicalVisit(node, stack);
			}
		}

		// printing topological sorting order
		while (!stack.isEmpty()) {
			System.out.print(stack.pop().name + " ");
		}
		System.out.println();
	}

	// SSSPP 'Single Source Shortest Path Problem' -- using BFS
	// pathPrint() -- helper method for BFSForSSSPP()
	// NOTE -- it is 'static' because inside this call, it should be called
	// automatically
	public static void pathPrint(GraphNode node) {
		if (node.parent != null) {
			pathPrint(node.parent);
		}
		System.out.print(node.name + " ");
	}

	// BFSForSSSPP()
	public void BFSForSSSPP(GraphNode node) {
		LinkedList<GraphNode> queue = new LinkedList<>();
		queue.add(node);

		while (!queue.isEmpty()) {

			GraphNode currentNode = queue.remove(0);
			currentNode.isVisited = true;
			System.out.print("Printing path for node " + currentNode.name + ": ");
			pathPrint(currentNode);
			System.out.println();

			// getting neighbors for the currentNode and adding them in queue
			ArrayList<GraphNode> neighbors = getNeighbors(currentNode);
			for (GraphNode neighbor : neighbors) {
				if (!neighbor.isVisited) {
					queue.add(neighbor);
					neighbor.isVisited = true;
					neighbor.parent = currentNode;
				}
			}
		}
	}
}
