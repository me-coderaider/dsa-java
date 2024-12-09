
import java.util.ArrayList;

import graph.mst.prims.Prim;
import graph.mst.prims.WeightedNode;



class Main {

	public static void main(String[] args) {
		// Graph

		// creating nodes for graph
		ArrayList<WeightedNode> nodeList = new ArrayList<>();
		nodeList.add(new WeightedNode("A"));
		nodeList.add(new WeightedNode("B"));
		nodeList.add(new WeightedNode("C"));
		nodeList.add(new WeightedNode("D"));
		nodeList.add(new WeightedNode("E"));

		// creating 'graph' from nodes 'nodeList'
//		A --- 5 --- B
//	 15 |       /   |  
//	/	|    10     |
//E		13   /      8
// \ 20	|  /       |
//      C  -- 6 -- D

		Prim graph=new Prim(nodeList);
		graph.addWeightedUndirectedEdge(0, 1, 5); // A - B
		graph.addWeightedUndirectedEdge(0, 2, 13); // A - C
		graph.addWeightedUndirectedEdge(0, 4, 15); // A - E
		graph.addWeightedUndirectedEdge(1, 2, 10); // B - C
		graph.addWeightedUndirectedEdge(1, 3, 8); // B - D
		graph.addWeightedUndirectedEdge(2, 3, 6); // C - D
		graph.addWeightedUndirectedEdge(2, 4, 20); // E - C

//		System.out.println(g.toString());

		System.out.println("Running Prim's Algo on the graph: ");
		graph.prims(nodeList.get(4));
	}

}