/**
 * 
 */
package com.debajoy.ds.graph;

/**
 * @author Debajoy
 *
 */
public class HamiltonianCycle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int graph1[][] = {{0, 1, 0, 1, 0}, 
	            {1, 0, 1, 1, 1}, 
	            {0, 1, 0, 0, 1}, 
	            {1, 1, 0, 0, 1}, 
	            {0, 1, 1, 1, 0}, 
	        }; 
		System.out.println("Graph 1 ------------>");
		hamCycle(graph1);
		int graph2[][] = {{0, 1, 1, 0, 1}, 
	            {1, 0, 1, 1, 1}, 
	            {1, 1, 0, 1, 0}, 
	            {0, 1, 1, 0, 1}, 
	            {1, 1, 0, 1, 0}, 
	        }; 
		System.out.println();
		System.out.println("Graph 2 ------------>");
		hamCycle(graph2);
	}

	private static void hamCycle(int[][] graph1) {
		// TODO Auto-generated method stub
		int n = graph1.length;
		int[] hamilArray = new int[n];
		int source = 0;
		for(int i = 0; i < n; i++){
			if(i == 0){
				hamilArray[i] = 0;
				source = hamilArray[i];
			}else{
				hamilArray[i] = -1;
			}	
		}
		hamiltonianCycleUtil(graph1,hamilArray, 1, n, source);
	}

	private static void hamiltonianCycleUtil(int[][] graph, int[] hamilArray, int k, int n, int source) {
		// TODO Auto-generated method stub
		if(k >= n){
			System.out.println("Hamiltonian Graph exists");
			for(int i : hamilArray){
				System.out.print(i + " -> ");
			}
			System.out.print(source);
			System.out.println();
			hamilArray[k-1] = -1;
		}
		if(k >= n){
			return;
		}
		for(int j = 1; j < n; j++){
			hamilArray[k] = j;
			for(int i = 0; i <k; i++){
				if(hamilArray[i] == hamilArray[k]){
					hamilArray[k] = -1;
					break;
				}
			}
			if(hamilArray[k] != -1){
				if((k < (n-1) && graph[hamilArray[k-1]][hamilArray[k]] != 0) || (k == (n-1) && graph[hamilArray[k-1]][hamilArray[k]] != 0 && graph[hamilArray[k]][hamilArray[0]] != 0)){
					hamiltonianCycleUtil(graph, hamilArray, k+1, n, source);
				}else{
					hamilArray[k] = -1;
				}
			}
		}
	}

}
