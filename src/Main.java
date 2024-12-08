
import java.util.ArrayList;

import graph.ssspp.using_bfs.on_graph_using_adjacency_matrix.Graph;
import graph.ssspp.using_bfs.on_graph_using_adjacency_matrix.GraphNode;


class Main {

	public static void main(String[] args) {
		// Graph -- Graph Representation -- using Adjacency Matrix

		// creating nodes for graph
		ArrayList<GraphNode> nodeList = new ArrayList<>();
		nodeList.add(new GraphNode("A", 0));
		nodeList.add(new GraphNode("B", 1));
		nodeList.add(new GraphNode("C", 2));
		nodeList.add(new GraphNode("D", 3));
		nodeList.add(new GraphNode("E", 4));
		nodeList.add(new GraphNode("F", 5));
		nodeList.add(new GraphNode("G", 6));

		// creating 'graph' from nodes 'nodeList' 
//		A ----- B
//		|       | \
//		|       |   \
//		|       |     \
//		C ----- D      G
//		|      	|	 /
//		|       |  /
//		E ----- F 

		Graph g = new Graph(nodeList);
		g.addUndirectedEdge(0, 1); // A - B
		g.addUndirectedEdge(0, 2); // A - C
		g.addUndirectedEdge(1, 3); // B - D
		g.addUndirectedEdge(1, 6); // B - G
		g.addUndirectedEdge(2, 3); // C - D
		g.addUndirectedEdge(2, 4); // C - E
		g.addUndirectedEdge(3, 5); // D - F
		g.addUndirectedEdge(4, 5); // E - F
		g.addUndirectedEdge(5, 6); // F - G

		System.out.println(g.toString());
		
		// considering node 'A' as 'SOURCE' node
		g.BFSForSSSPP(nodeList.get(0));
	}

}