
import java.util.ArrayList;

import graph.ssspp.using_bellman_ford.WeightedGraph;
import graph.ssspp.using_bellman_ford.WeightedNode;


class Main {

	public static void main(String[] args) {
		// Graph -- Graph Representation -- using Adjacency Matrix

		// creating nodes for graph
		ArrayList<WeightedNode> nodeList = new ArrayList<>();
		nodeList.add(new WeightedNode("A", 0));
		nodeList.add(new WeightedNode("B", 1));
		nodeList.add(new WeightedNode("C", 2));
		nodeList.add(new WeightedNode("D", 3));
		nodeList.add(new WeightedNode("E", 4));
		nodeList.add(new WeightedNode("F", 5));
		nodeList.add(new WeightedNode("G", 6));

		// creating 'graph' from nodes 'nodeList'
//		B ➡️ 3 ➡️ E
//	  ↗️	⬇️↘️       ↗️  ↘️  
//	 2	⬇️  1    4     9
//  ↗️	⬇️    ↘️↗️         ↘️
// A    6    D          G   
//	↘️	⬇️      		  ↗️
//	 5  ⬇️            7
//	  ↘️	⬇️           ↗️
//		C ➡️ 8 ➡️ F 

		WeightedGraph g = new WeightedGraph(nodeList);
		g.addWeightedEdge(0, 1, 2); // A - B
		g.addWeightedEdge(0, 2, 5); // A - C
		g.addWeightedEdge(1, 2, 6); // B - C
		g.addWeightedEdge(1, 3, 1); // B - D
		g.addWeightedEdge(1, 4, 3); // B - E
//		g.addWeightedEdge(4, 1, -6); // B - E // FOR NEGATIVE CYCLE TESTING
		g.addWeightedEdge(2, 5, 8); // C - F
		g.addWeightedEdge(3, 4, 4); // D - E
		g.addWeightedEdge(4, 6, 9); // E - G
		g.addWeightedEdge(5, 6, 7); // F - G

//		System.out.println(g.toString());

		// considering node 'A' as 'SOURCE' node
		System.out.println("Printing Bellman Ford from source: A");
		g.bellmanFord(nodeList.get(0));
	}

}