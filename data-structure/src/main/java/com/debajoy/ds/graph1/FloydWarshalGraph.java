package com.debajoy.ds.graph1;

public class FloydWarshalGraph {
	int v;
	int[][] graph;
	final int INF = 9999;
	
	public FloydWarshalGraph(int v) {
		this.v = v;
	}
	public FloydWarshalGraph(int v, int[][] graph) {
		this.v = v;
		this.graph = graph;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int V = 4;
		int[][] graph = { {0, 5, 0, 10},  
                {0, 0, 3, 0},  
                {0, 0, 0, 1},  
                {0, 0, 0, 0}  
            };  
		FloydWarshalGraph a = new FloydWarshalGraph(V,graph);
		// Print the solution
		a.floydWarshall();
	//	a.floydWarshallOld();
	}
	private void printfloydWarshallShortestDistance(int[][] graph) {
		// TODO Auto-generated method stub
		for(int i = 0; i< v; i++){
			for(int j =0; j< v;j++){
				if(i != j){
					if(graph[i][j] >= INF){
						graph[i][j] = -1;
					}
					System.out.print("Distance from "+i+" to " +j+" : "+graph[i][j]+" ; ");	
				}
			}
			System.out.println();
		}	
	}
	
	private void floydWarshallOld() {
		// TODO Auto-generated method stub
		for(int i = 0; i< v; i++){
			for(int j =0; j< v; j++){
				if(i != j && graph[i][j] == 0){
					graph[i][j] = INF;
				}
			}
		}
		for(int k = 0; k< v; k++){
			for(int i=0; i < v; i++){
				for(int j = 0; j < v; j++){
						graph[i][j] = Math.min(graph[i][j],graph[i][k]+graph[k][j]);		
				}
			}
		}
		printfloydWarshallShortestDistance(graph);
	}

	private void floydWarshall() {
		// TODO Auto-generated method stub
		for(int k = 0; k < v; k++){
			for(int i = 0; i < v; i++){
				for(int j = 0; j<v; j++){
						graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);					
				}
			}
		}
		printfloydWarshallShortestDistance(graph);
	}

}
