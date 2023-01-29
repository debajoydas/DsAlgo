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
public class DisjointSetCircleExist {

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
		
		int[] arr = new int[v];
		for(int i = 0; i< v;i++){
			arr[i] = -1;
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

	private static void unionSet(int[] arr, int parentSrc, int parentDest) {
		// TODO Auto-generated method stub
		int parentOfSrc = findParent(arr, parentSrc);
		int parentOfDest = findParent(arr, parentDest);
		arr[parentOfDest] = parentOfSrc;
	}

	private static int findParent(int[] arr, int i) {
		// TODO Auto-generated method stub
		if(arr[i] < 0){
			return i;
		}
		return findParent(arr, arr[i]);
	}

}

class Edges{
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edges other = (Edges) obj;
		if (src == other.src && dest == other.dest)
			return true;
		if (src == other.dest && dest == other.src)
			return true;
		return false;
	}
	int src;
	int dest;
	int cost;
	
	public int getSrc() {
		return src;
	}
	public void setSrc(int src) {
		this.src = src;
	}
	public int getDest() {
		return dest;
	}
	public void setDest(int dest) {
		this.dest = dest;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public Edges(int src, int dest, int cost) {
		super();
		this.src = src;
		this.dest = dest;
		this.cost = cost;
	}
}