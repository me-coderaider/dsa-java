package graph.traversal.bfs_on_graph_using_adjacency_matrix;

public class GraphNode {
	public String name;
	public int index;
	public boolean isVisited=false; // to save ourself from falling into 'infinite' loop
	
	public GraphNode(String name, int index) {
		this.name=name;
		this.index=index;
	}
}
