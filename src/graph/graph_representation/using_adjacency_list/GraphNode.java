package graph.graph_representation.using_adjacency_list;

import java.util.ArrayList;

public class GraphNode {
	public String name;
	public int index;

	public ArrayList<GraphNode> neighbors = new ArrayList<GraphNode>();

	public GraphNode(String name, int index) {
		this.name = name;
		this.index = index;
	}

}
