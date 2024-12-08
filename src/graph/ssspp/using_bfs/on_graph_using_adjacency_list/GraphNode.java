package graph.ssspp.using_bfs.on_graph_using_adjacency_list;

import java.util.ArrayList;

public class GraphNode {
	public String name;
	public int index;
	public boolean isVisited=false; // to save ourself from falling into 'infinite' loop
	public GraphNode parent; // saving the 'parent' node info 	
	
	public ArrayList<GraphNode> neighbors=new ArrayList<GraphNode>();
	
	public GraphNode(String name, int index) {
		this.name=name;
		this.index=index;
	}
}
