/**
 * 
 */
package com.debajoy.ds.graph;

/**
 * @author Debajoy
 *
 */
public class FloydWarshalGraph {
	private int V;
	private int E;
	final static int INF = 99999;
	public FloydWarshalGraph(int v) {
		// TODO Auto-generated constructor stub
		this.V = v;
	}

	public static void main(String[] args) {
		
		int[][] graph = { {0, 5, 0, 10},  
                {0, 0, 3, 0},  
                {0, 0, 0, 1},  
                {0, 0, 0, 0}  
            };  
		
		int V = 4;
		FloydWarshalGraph floydWarshalGraph = new FloydWarshalGraph(V);
		floydWarshalGraph.floydWarshall(graph);  
	}

	private void floydWarshall(int[][] graph) {
		// TODO Auto-generated method stub
		for(int i = 0; i< V; i++){
			for(int j =0; j< V; j++){
				if(i != j && graph[i][j] == 0){
					graph[i][j] = INF;
				}
			}
		}
		for(int k = 0; k< V; k++){
			for(int i=0; i < V; i++){
				for(int j = 0; j < V; j++){
						graph[i][j] = Math.min(graph[i][j],graph[i][k]+graph[k][j]);		
				}
			}
		}
		printfloydWarshallShortestDistance(graph);
	}

	private void printfloydWarshallShortestDistance(int[][] graph) {
		// TODO Auto-generated method stub
		for(int i = 0; i< V; i++){
			for(int j =0; j< V;j++){
				if(i != j){
					if(graph[i][j] == INF){
						graph[i][j] = -1;
					}
					System.out.print("Distance from "+i+" to " +j+" : "+graph[i][j]+" ; ");	
				}
			}
			System.out.println();
		}	
	}

}
