
import java.util.ArrayList;

import graph.traversal.dfs_on_graph_using_adjacency_list.Graph;
import graph.traversal.dfs_on_graph_using_adjacency_list.GraphNode;

class Main {

	public static void main(String[] args) {
		// Graph -- Graph Representation -- using Adjacency Matrix
		
		// creating nodes for graph
		ArrayList<GraphNode> nodeList=new ArrayList<>();
		nodeList.add(new GraphNode("A", 0));
		nodeList.add(new GraphNode("B", 1));
		nodeList.add(new GraphNode("C", 2));
		nodeList.add(new GraphNode("D", 3));
		nodeList.add(new GraphNode("E", 4));
		
		// creating 'graph' from nodes 'nodeList'
//		A --- B
//		| \     \
//		|  \      E
//		|   \   /
//		C --- D 
		Graph g=new Graph(nodeList);
		g.addUndirectedEdge(0, 1); // A - B
		g.addUndirectedEdge(0, 2); // A - C
		g.addUndirectedEdge(0, 3); // A - D
		g.addUndirectedEdge(1, 4); // B - E
		g.addUndirectedEdge(2, 3); // C - D
		g.addUndirectedEdge(3, 4); // D - E
		
		
		System.out.println(g.toString());
		
		g.dfs();
	}

}