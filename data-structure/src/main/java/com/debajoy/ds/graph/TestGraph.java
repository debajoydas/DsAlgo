package com.debajoy.ds.graph;

public class TestGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 4;
		Graph g = new Graph(V); 
		  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        System.out.println("Following is Breadth First Traversal "+ 
                           "(starting from vertex 2)"); 
  
 //       g.BFS(2); 
        System.out.println("Following is Depth First Traversal "+ 
                "(starting from vertex 2)"); 
 //      g.DFS(2);
        System.out.println("Count of Tree : " +g.getCount(2));
        
        g.printGraph(V);
	}

}
