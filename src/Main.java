
import java.util.ArrayList;

import graph.apspp.using_floyd_warshall.WeightedGraph;
import graph.apspp.using_floyd_warshall.WeightedNode;

class Main {

	public static void main(String[] args) {
		// Graph -- Graph Representation -- using Adjacency Matrix

		// creating nodes for graph
		ArrayList<WeightedNode> nodeList = new ArrayList<>();
		nodeList.add(new WeightedNode("A", 0));
		nodeList.add(new WeightedNode("B", 1));
		nodeList.add(new WeightedNode("C", 2));
		nodeList.add(new WeightedNode("D", 3));

		// creating 'graph' from nodes 'nodeList'
//		A -> 8 ->  B
//	  	⬇️ ↖️      ↗️ ⬇️  
//		⬇️    ↖️ ↗️   ⬇️
//		1   2 ↖️    1
//  	⬇️  ↗️    4  ⬇️
//      D  -> 9 -> C

		WeightedGraph g = new WeightedGraph(nodeList);
		g.addWeightedEdge(0, 1, 8); // A - B
		g.addWeightedEdge(0, 3, 1); // A - D
		g.addWeightedEdge(1, 2, 1); // B - C
		g.addWeightedEdge(2, 0, 4); // C - A
		g.addWeightedEdge(3, 2, 9); // D - C
		g.addWeightedEdge(3, 1, 2); // D - B

//		System.out.println(g.toString());

		// considering node 'A' as 'SOURCE' node
		System.out.println("Printing Floyd Warshall algorithm from source: A");
		g.floydWarshall();
	}

}