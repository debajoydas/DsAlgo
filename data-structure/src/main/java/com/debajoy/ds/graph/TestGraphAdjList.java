/**
 * 
 */
package com.debajoy.ds.graph;

/**
 * @author Debajoy
 *
 */
public class TestGraphAdjList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 5;
		GraphAdjList g = new GraphAdjList(V); 
		  
		g.addEdge(0, 1); 
		g.addEdge(0, 4); 
		g.addEdge(1, 2); 
		g.addEdge(1, 3); 
		g.addEdge(1, 4); 
		g.addEdge(2, 3); 
		g.addEdge(3, 4); 
		
		GraphAdjList g1 = new GraphAdjList(V); 
		  
		g1.addEdge(0, 1); 
		g1.addEdge(0, 2); 
		g1.addEdge(1, 3); 
		g1.addEdge(3, 0); 
		g1.addEdge(3, 2);  
 
        
        g.printGraph();
        System.out.println(g.isCycleExistOptimzed());
        System.out.println(g1.isCycleExistOptimzed());
    //    g.bfs(0);
    //    g.dfs(0);
	}

}
