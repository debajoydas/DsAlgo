/**
 * 
 */
package com.debajoy.ds.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import org.omg.CORBA.UnionMember;

/**
 * @author Debajoy
 *
 */
public class KrushkalsAlgorithmMinSpanningTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
            { 2, 0, 3, 8, 5 },
            { 0, 3, 0, 0, 7 },
            { 6, 8, 0, 0, 9 },
            { 0, 5, 7, 9, 0 } };
        int V = graph.length;

        KruskalsMinSpanTree(graph,V);

	}

	private static void KruskalsMinSpanTree(int[][] graph, int v) {
		// TODO Auto-generated method stub
		List<Edges> mst = new ArrayList<Edges>();
		PriorityQueue<Edges> set = new PriorityQueue<Edges>(new Comparator<Edges>() {
			@Override
			public int compare(Edges o1, Edges o2) {
				// TODO Auto-generated method stub
				return Integer.valueOf(o1.cost).compareTo(Integer.valueOf(o2.cost));
			}
			
		});
		for(int i = 0; i < v; i++){
			for(int j = 0; j < v; j++){
				if(graph[i][j] > 0){
					Edges e = new Edges(i, j, graph[i][j]);
					if(!set.contains(e)){
						set.add(e);
					}
				}
			}
		}
		 
		DisjointNode[] arr = new DisjointNode[v];
		for(int i = 0; i < v;  i++){
			arr[i] = new DisjointNode();
			arr[i].parent = i;
			arr[i].rank = 0;
		}
		while(set.size() > 0){
			Edges edge = set.poll();
			int src = edge.src;
			int dest = edge.dest;
			
			int srcParent = findParent(arr, src);
			int destParent = findParent(arr, dest);
			
			if(srcParent != destParent){
				mst.add(edge);
				unionMember(arr, srcParent, destParent);
				
			}
		}
		
		mst.forEach(s -> System.out.println(s.src +" to "+ s.dest+ " : "+ s.cost));
		System.out.println("Total Min Cost :" + mst.stream().mapToInt(m -> m.cost).sum());
		 
	}

	private static void unionMember(DisjointNode[] arr, int src, int dest) {
		// TODO Auto-generated method stub
		int srcParent = findParent(arr, src);
		int destParent = findParent(arr, dest);
		if(arr[srcParent].rank > arr[destParent].rank ){
			arr[destParent].parent = srcParent;
			arr[srcParent].rank++;
		}else if(arr[srcParent].rank < arr[destParent].rank ){
			arr[srcParent].parent = destParent;
			arr[destParent].rank++;
		}else{
			arr[destParent].parent = srcParent;
			arr[srcParent].rank++;
		}
		
	}

	private static int findParent(DisjointNode[] arr, int src) {
		// TODO Auto-generated method stub
		if(arr[src].parent == src){
			return src;
		}
		return findParent(arr, arr[src].parent);
	}

}

class DisjointNode{
	int parent;
	int rank;
}