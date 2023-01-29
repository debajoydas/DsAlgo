/**
 * 
 */
package com.debajoy.ds.graph;

import java.util.Arrays;

/**
 * @author Debajoy
 *
 */
public class BellManFordGraph {

	private int V;
	private int E;
	private Edge[] edge;
	
	public BellManFordGraph(int v, int e) {
		super();
		V = v;
		E = e;
		this.edge = new Edge[E];
		for(int i = 0; i < e; i++){
			edge[i] = new Edge(); 
		}
	}
	
	class Edge{
		
		private int src;
		private int dest;
		private int weight;
		
		public Edge(int src, int dest, int weight) {
			super();
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
		public Edge() {
		}
	}
	
	private static void getShortestPathBellManFord(BellManFordGraph graph, int E, int V, int source) {
		// TODO Auto-generated method stub
		int[] shoertestDistanceArray = new int[V];
		for(int i = 0; i<V; i++){
			if(i == source){
				shoertestDistanceArray[i] = 0;
			}else{
				shoertestDistanceArray[i] = Integer.MAX_VALUE;
			}
		}
		
		for(int i = 0; i< (V-1); i++){
			for(int j = 0; j < E; j++){
				if(shoertestDistanceArray[graph.edge[j].src] + graph.edge[j].weight < shoertestDistanceArray[graph.edge[j].dest]){
					shoertestDistanceArray[graph.edge[j].dest] = shoertestDistanceArray[graph.edge[j].src] + graph.edge[j].weight;
				}	
			}
		}
		printShortestPath(shoertestDistanceArray, source);
	}

	private static void printShortestPath(int[] shoertestDistanceArray, int source) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < shoertestDistanceArray.length; i++){
			System.out.println(source+ " to " +i +" : " +shoertestDistanceArray[i]);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int V = 5;  // Number of vertices in graph
	      int E = 8;  // Number of edges in graph
	      int source = 0;

	        BellManFordGraph graph = new BellManFordGraph(V, E);

	        // add edge 0-1 (or A-B in above figure)
	        graph.edge[0].src = 0;
	        graph.edge[0].dest = 1;
	        graph.edge[0].weight = -1;

	        // add edge 0-2 (or A-C in above figure)
	        graph.edge[1].src = 0;
	        graph.edge[1].dest = 2;
	        graph.edge[1].weight = 4;

	        // add edge 1-2 (or B-C in above figure)
	        graph.edge[2].src = 1;
	        graph.edge[2].dest = 2;
	        graph.edge[2].weight = 3;

	        // add edge 1-3 (or B-D in above figure)
	        graph.edge[3].src = 1;
	        graph.edge[3].dest = 3;
	        graph.edge[3].weight = 2;

	        // add edge 1-4 (or A-E in above figure)
	        graph.edge[4].src = 1;
	        graph.edge[4].dest = 4;
	        graph.edge[4].weight = 2;

	        // add edge 3-2 (or D-C in above figure)
	        graph.edge[5].src = 3;
	        graph.edge[5].dest = 2;
	        graph.edge[5].weight = 5;

	        // add edge 3-1 (or D-B in above figure)
	        graph.edge[6].src = 3;
	        graph.edge[6].dest = 1;
	        graph.edge[6].weight = 1;

	        // add edge 4-3 (or E-D in above figure)
	        graph.edge[7].src = 4;
	        graph.edge[7].dest = 3;
	        graph.edge[7].weight = -3;
	        
	        getShortestPathBellManFord(graph, E, V, source);
	}

}
