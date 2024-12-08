package graph.ssspp.using_bfs.on_graph_using_adjacency_list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

	public Graph(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
	}

	// adding an undirected edge between 2 nodes having index 'i' & 'j'
	public void addUndirectedEdge(int i, int j) {
		GraphNode first = nodeList.get(i);
		GraphNode second = nodeList.get(j);

		// adding these 'graph' nodes as 'neighbors' among them
		first.neighbors.add(second);
		second.neighbors.add(first);
	}

	// print adjacency list
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nodeList.size(); i++) {
			sb.append(nodeList.get(i).name + ": ");
			for (int j = 0; j < nodeList.get(i).neighbors.size(); j++) {
				if (j == nodeList.get(i).neighbors.size() - 1) {
					sb.append(nodeList.get(i).neighbors.get(j).name);

				} else {
					sb.append(nodeList.get(i).neighbors.get(j).name + " -> ");
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	// bfsVisit -- internal -- helper for bfs()
	private void bfsVisit(GraphNode node) {
		LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(node);

		while (!queue.isEmpty()) {

			GraphNode currentNode = queue.remove(0);
			currentNode.isVisited = true;
			System.out.print(currentNode.name + " ");

			// add all 'unvisited' neighbors of 'currentNode' in the queue
			for (GraphNode neighbor : currentNode.neighbors) {
				if (!neighbor.isVisited) {
					queue.add(neighbor);
					neighbor.isVisited = true;
				}
			}
		}
		System.out.println();
	}

	// bfs()
	public void bfs() {
		for (GraphNode node : nodeList) {
			if (!node.isVisited) {
				bfsVisit(node);
			}
		}
	}

	// dfsVisit() -- internal -- helper for dfs()
	private void dfsVisit(GraphNode node) {
		Stack<GraphNode> stack = new Stack<GraphNode>();

		stack.push(node);

		while (!stack.isEmpty()) {

			GraphNode currentNode = stack.pop();
			currentNode.isVisited = true;
			System.out.print(currentNode.name + " ");

			for (GraphNode neighbor : currentNode.neighbors) {
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
		GraphNode first = nodeList.get(i);
		GraphNode second = nodeList.get(j);

		first.neighbors.add(second);
	}

	// topologicalVisit -- helper function for topological()
	private void topologicalVisit(GraphNode node, Stack<GraphNode> stack) {
		for (GraphNode neighbor : node.neighbors) {
			if (!neighbor.isVisited) {
				// pushing the 'unvisited' neighbor into the same stack
				topologicalVisit(neighbor, stack);
			}
		}
		node.isVisited = true;
		stack.push(node);
	}

	// topological sort
	public void topologicSort() {
		Stack<GraphNode> stack = new Stack<GraphNode>();
		for (GraphNode node : nodeList) {
			if (!node.isVisited) {
				topologicalVisit(node, stack);
			}
		}
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

	public void BFSForSSSPP(GraphNode node) {
		LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(node);

		while (!queue.isEmpty()) {

			GraphNode currentNode = queue.remove(0);
			currentNode.isVisited = true;
			System.out.print("Printing path for node " + currentNode.name + ": ");
			pathPrint(currentNode);
			System.out.println();

			for (GraphNode neighbor : currentNode.neighbors) {
				if (!neighbor.isVisited) {
					queue.add(neighbor);
					neighbor.isVisited = true;
					neighbor.parent = currentNode;
				}
			}
		}
	}
}
