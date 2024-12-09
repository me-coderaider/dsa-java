package graph.ssspp.using_dijkstras;

import java.util.ArrayList;
import java.util.HashMap;

// creating this 'WeightedNode' class for solving 'SSSPP' using 'Weighted' graph
// making 'comparable' as we'll be using 'PriorityQueue'
public class WeightedNode implements Comparable<WeightedNode> {
	public String name;
	public ArrayList<WeightedNode> neighbors = new ArrayList<WeightedNode>();
	public HashMap<WeightedNode, Integer> weightMap = new HashMap<>(); // key;WeightedNode, value=cost of node
	public boolean isVisited = false;
	public WeightedNode parent;

	public int distance;
	public int index;

	public WeightedNode(String name, int index) {
		this.name = name;
		distance = Integer.MAX_VALUE;
		this.index = index;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(WeightedNode o) {
		return this.distance - o.distance;
	}

}
