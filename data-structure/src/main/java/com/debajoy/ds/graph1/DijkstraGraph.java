/**
 * 
 */
package com.debajoy.ds.graph1;

/**
 * @author Debajoy
 *
 */
public class DijkstraGraph {

	/**
	 * @param args
	 */
	public static void main(String[] args)
    {
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                                      { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                                      { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                                      { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                                      { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                                      { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                                      { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                                      { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                                      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
                                      
        DijkstraGraph dijkstraGraph= new DijkstraGraph();
        dijkstraGraph.dijkstra(graph, 0);
    }

	private void dijkstra(int[][] graph, int src) {
		// TODO Auto-generated method stub
		int v= graph.length;
		int[] dist = new int[v];
		dist[src] =0;
		for(int i = 0; i < v;i++){
			if(i!= src){
				dist[i] = Integer.MAX_VALUE;
			}
		}
		boolean[] isVisited =new boolean[v];
		for(int i = 0 ; i< (v-1); i++){
				int min_index = getMinIndex(dist,isVisited,src);
				isVisited[min_index] = true;
				for(int d = 0; d < v;d++){
					if(!isVisited[d] && graph[min_index][d] > 0 && dist[min_index] != Integer.MAX_VALUE 
							&& dist[min_index]+graph[min_index][d] < dist[d]){
						dist[d] = dist[min_index]+graph[min_index][d];
					}
				}
		}
		printSolution(dist);
	}
	
	void printSolution(int dist[])
    {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < dist.length; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

	private int getMinIndex(int[] dist, boolean[] isVisited, int src) {
		// TODO Auto-generated method stub
		int min_index = src;
		int min_Value = Integer.MAX_VALUE;
		for(int i = 0; i< dist.length; i++){
			if(!isVisited[i] && dist[i] < min_Value){
				min_Value = dist[i];
				min_index = i;
			}
		}
		return min_index;
	}

}
