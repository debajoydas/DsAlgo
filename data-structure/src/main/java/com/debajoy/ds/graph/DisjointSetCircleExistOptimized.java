/**
 * 
 */
package com.debajoy.ds.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Debajoy
 *
 */
public class DisjointSetCircleExistOptimized {

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

        if(isCircleExist(graph,V) == 1){
        	System.out.println("Circle exists");
        }else{
        	System.out.println("Circle doesn't exist");
        }

	}

	private static int isCircleExist(int[][] graph, int v) {
		// TODO Auto-generated method stub
		List<Edges> set = new ArrayList<Edges>();
		for(int i = 0; i< v; i++){
			for(int j = 0;j < v;j++){
				if(graph[i][j] > 0){
					Edges e = new Edges(j, i, graph[i][j]);
					if(!set.contains(e)){
						e.setSrc(i);
						e.setDest(j);
						set.add(e);
					}
				}
			}
		}
		
		Rank[] arr = new Rank[v];
		for(int i = 0; i< v;i++){
			arr[i] = new Rank(-1, 0);
		}
		
		for(Edges edge : set){
			int parentSrc = findParent(arr, edge.src);
			int parentDest = findParent(arr, edge.dest);
			
			if(parentSrc == parentDest){
				return 1;
			}
			unionSet(arr, parentSrc, parentDest);
		}
		return 0;
		
	}

	private static void unionSet(Rank[] arr, int parentSrc, int parentDest) {
		// TODO Auto-generated method stub
		int parentOfSrc = findParent(arr, parentSrc);
		int parentOfDest = findParent(arr, parentDest);
		
		if(arr[parentOfSrc].rank > arr[parentOfDest].rank){
			arr[parentOfDest].parent = parentOfSrc;
			arr[parentOfSrc].rank++;
		}else if(arr[parentOfSrc].rank < arr[parentOfDest].rank){
			arr[parentOfSrc].parent = parentOfDest;
			arr[parentOfDest].rank++;
		}else{
			arr[parentOfDest].parent = parentOfSrc;
			arr[parentOfSrc].rank++;
		}
	}

	private static int findParent(Rank[] arr, int i) {
		// TODO Auto-generated method stub
		if(arr[i].parent == -1){
			return i;
		}
		return findParent(arr, arr[i].parent);
	}

}

class Rank{
	int parent;
	int rank;
	public Rank(int parent, int rank) {
		super();
		this.parent = parent;
		this.rank = rank;
	}
}
