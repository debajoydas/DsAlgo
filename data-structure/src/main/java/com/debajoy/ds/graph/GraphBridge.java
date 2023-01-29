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
public class GraphBridge {
	
	int V;
	LinkedList<Integer>[] E;
	int time = 0;
	
	public GraphBridge(int v) {
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
		System.out.println("Bridges in first graph "); 
		GraphBridge g1 = new GraphBridge(5); 
        g1.addEdge(1, 0); 
        g1.addEdge(0, 2); 
        g1.addEdge(2, 1); 
        g1.addEdge(0, 3); 
        g1.addEdge(3, 4); 
        g1.bridge(); 
        System.out.println(); 
  
        System.out.println("Bridges in Second graph"); 
        GraphBridge g2 = new GraphBridge(4); 
        g2.addEdge(0, 1); 
        g2.addEdge(1, 2); 
        g2.addEdge(2, 3); 
        g2.bridge(); 
        System.out.println(); 
  
        System.out.println("Bridges in Third graph "); 
        GraphBridge g3 = new GraphBridge(7); 
        g3.addEdge(0, 1); 
        g3.addEdge(1, 2); 
        g3.addEdge(2, 0); 
        g3.addEdge(1, 3); 
        g3.addEdge(1, 4); 
        g3.addEdge(1, 6); 
        g3.addEdge(3, 5); 
        g3.addEdge(4, 5); 
        g3.bridge(); 
	}

	private void bridge() {
		// TODO Auto-generated method stub
		boolean[] isVisited = new boolean[V];
		int[] disc = new int[V];
		int[] low = new int[V];
		int[] parent = new int[V];
		
		for(int i = 0; i < V; i++){
			parent[i] = -1;
			isVisited[i] = false;
		}
		
		for(int i = 0; i < V; i++){
			if(!isVisited[i]){
				bridgeUtil(i,disc,low,parent,isVisited);
			}
		}
	}

	private void bridgeUtil(int u, int[] disc, int[] low, int[] parent, boolean[] isVisited) {
		// TODO Auto-generated method stub
		isVisited[u] = true;
		disc[u] = low[u] = ++time;
		Iterator<Integer> itr = E[u].iterator();
		while(itr.hasNext()){
			int v = itr.next();
			if(!isVisited[v]){
				parent[v] = u;
				bridgeUtil(v, disc, low, parent, isVisited);
				low[u] = Math.min(low[u], low[v]);
				if(low[v] > disc[u]){
					System.out.println("Bridge exists : "+u +"<--->"+v);
				}
			}else if(v != parent[u]){
				low[u] = Math.min(low[u], disc[v]);
			}
		}
	}

}
