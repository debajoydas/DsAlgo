/**
 * 
 */
package com.debajoy.ds.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Debajoy
 *
 */
public class GraphArticulationPoint {

	int V;
	LinkedList<Integer>[] E;
	int time = 0;
	
	public GraphArticulationPoint(int v) {
		this.V = v;
		E = new LinkedList[V];
		for(int i =0; i< V; i++){
			E[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int U, int V){
		E[U].add(V);
		E[V].add(U);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Articulation points in graph ");
		GraphArticulationPoint graph = new GraphArticulationPoint(8);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(1, 6);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        graph.addEdge(6, 7);
        graph.addEdge(1, 7);
        graph.AP();
	}

	private void AP() {
		// TODO Auto-generated method stub
		
		boolean[] isVisited = new boolean[V];
		int[] parent = new int[V];
		int[] low = new int[V];
		int[] disc = new int[V];
		boolean[] artPoint = new boolean[V];
		
		for(int i = 0; i < V; i++){
			parent[i] = -1;
			isVisited[i] = false;
		}
		
		for(int i = 0 ; i< V; i++){
			if(!isVisited[i]){
				APUtil(i,parent,isVisited,low,disc,artPoint);
			}
		}
		
		for(int i = 0; i< artPoint.length; i++){
			if(artPoint[i]){
				System.out.println("Articulation Point Vertice : "+i);
			}
		}
		
	}

	private void APUtil(int u, int[] parent, boolean[] isVisited, int[] low, int[] disc, boolean[] artPoint) {
		// TODO Auto-generated method stub
		isVisited[u] = true;
		disc[u] = ++time;
		low[u] = disc[u];
		int children = 0;
		
		Iterator<Integer> itr = E[u].listIterator();
		while(itr.hasNext()){
			int v = itr.next();
			if(!isVisited[v]){
				children++;
				parent[v] = u;
				APUtil(v, parent, isVisited, low, disc, artPoint);
				low[u] = Math.min(low[u], low[v]);
				if(children > 1 && parent[u] == -1){
					artPoint[u] = true;
				}
				if(parent[u] != -1 && disc[u] <= low[v] ){
					artPoint[u] = true;
				}
			}else if(parent[v] != u){
				low[u] = Math.min(low[u], disc[v]);
			}
		}
		
	}

}
