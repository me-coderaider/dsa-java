package graph.traversal.dfs_on_graph_using_adjacency_list;

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

	// print adjacency matrix
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
}
