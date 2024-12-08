package graph.traversal.dfs_on_graph_using_adjacency_list;

import java.util.ArrayList;

public class GraphNode {
	public String name;
	public int index;
	public boolean isVisited=false; // to save ourself from falling into 'infinite' loop
	
	public ArrayList<GraphNode> neighbors=new ArrayList<GraphNode>();
	
	public GraphNode(String name, int index) {
		this.name=name;
		this.index=index;
	}
}
