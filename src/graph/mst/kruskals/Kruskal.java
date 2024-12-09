package graph.mst.kruskals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Kruskal {
	ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();
	ArrayList<UndirectedEdge> edgeList = new ArrayList<UndirectedEdge>();

	public Kruskal(ArrayList<WeightedNode> nodeList) {
		this.nodeList = nodeList;
	}

	// adding 'weighted undirected' edge
	public void addWeightedUndirectedEdge(int firstIndex, int secondIndex, int weight) {
		UndirectedEdge edge = new UndirectedEdge(nodeList.get(firstIndex), nodeList.get(secondIndex), weight);
		WeightedNode first = edge.first;
		WeightedNode second = edge.second;

		first.neighbors.add(second);
		second.neighbors.add(first);

		first.weightMap.put(second, weight);
		second.weightMap.put(first, weight);

		edgeList.add(edge);

	}

	// creating 'disjoinSet()' of 'nodeList'
	public void kruskal() {
		DisjointSet.makeSet(nodeList);

		// using comparator to sort the edges
		Comparator<UndirectedEdge> comparator = new Comparator<UndirectedEdge>() {
			@Override
			public int compare(UndirectedEdge o1, UndirectedEdge o2) {
				return o1.weight - o2.weight;
			}
		};

		Collections.sort(edgeList, comparator);
		int cost = 0;
		for (UndirectedEdge edge : edgeList) {
			WeightedNode first = edge.first;
			WeightedNode second = edge.second;

			if (!DisjointSet.findSet(first).equals(DisjointSet.findSet(second))) {
				DisjointSet.union(first, second);
				cost += edge.weight;
				System.out.println("Taken " + edge);
			}
		}

		System.out.println("Total cost of MST: " + cost);
	}

}
