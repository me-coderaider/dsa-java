
import java.util.ArrayList;

import graph.topological_sort.on_graph_using_adjacency_matrix.Graph;
import graph.topological_sort.on_graph_using_adjacency_matrix.GraphNode;



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
		nodeList.add(new GraphNode("F", 5));
		nodeList.add(new GraphNode("G", 6));
		nodeList.add(new GraphNode("H", 7));
		
		// creating 'graph' from nodes 'nodeList'
//		A       B
//		⬇️     ↙️ ⬇️
//		⬇️   ↙️   ⬇️  
//		⬇️ ↙️     ⬇️
//		C       D
//		⬇️       ↙️
//		⬇️      ↙️
//		E     ↙️
//	   ↙️ ↘️	 ↙️
//	 ↙️	   ↘️↙️ 	
//	H		F → → → → G
			
		Graph g=new Graph(nodeList);
		g.addDirectedEdge(0, 2); // A - C
		g.addDirectedEdge(1, 2); // B - C
		g.addDirectedEdge(1, 3); // B - D
		g.addDirectedEdge(2, 4); // C - E
		g.addDirectedEdge(3, 5); // D - F
		g.addDirectedEdge(4, 7); // E - H
		g.addDirectedEdge(4, 5); // E - F
		g.addDirectedEdge(5, 6); // F - G
		
		
		System.out.println(g.toString());
		
		g.topologicalSort();
	}

}