/**
 * 
 */
package com.debajoy.ds.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Debajoy
 *
 */
public class PrimsMinimumSpanningTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
            { 2, 0, 3, 8, 5 },
            { 0, 3, 0, 0, 7 },
            { 6, 8, 0, 0, 9 },
            { 0, 5, 7, 9, 0 } };
        int V = graph.length;

        primMST(graph,V);
	}

	private static void primMST(int[][] graph, int v) {
		// TODO Auto-generated method stub
		EdgeComparator comparator = new EdgeComparator();
		List<Edge> mst = new ArrayList<Edge>();
		boolean[] isVisited = new boolean[v];
		
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>(comparator);
		
		int[] keyValues = new int[v];
		keyValues[0] = 0;
		for(int i = 1; i<v; i++){
			keyValues[i] = Integer.MAX_VALUE;
		}
		for(int i = 0; i<v; i++){
			if(graph[0][i] > 0){
				queue.add(new Edge(0, i, graph[0][i]));
			}
		}
		isVisited[0] = true;
		while(queue.size() > 0){
			Edge poped = queue.poll();
			if(!isVisited[poped.dest]){
				mst.add(poped);
			}			
			isVisited[poped.dest] = true;
			int dest = poped.dest;
			for(int i = 0; i < v; i++){
				if(!isVisited[i] && graph[dest][i] > 0 ){
					queue.add(new Edge(dest, i, graph[dest][i]));
				}
			}
		}
		 
		mst.forEach(s -> System.out.println(s.src +" to "+ s.dest+ " : "+ s.cost));
		System.out.println("Total Min Cost :" + mst.stream().mapToInt(m -> m.cost).sum());
		
	}

}

class EdgeComparator implements Comparator<Edge>{

	@Override
	public int compare(Edge o1, Edge o2) {
		// TODO Auto-generated method stub
		return Integer.valueOf(o1.cost).compareTo(Integer.valueOf(o2.cost));
	}
	
}

class Edge{
	
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
	public Edge(int src, int dest, int cost) {
		super();
		this.src = src;
		this.dest = dest;
		this.cost = cost;
	}
}