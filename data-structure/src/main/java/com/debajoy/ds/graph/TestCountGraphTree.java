package com.debajoy.ds.graph;

public class TestCountGraphTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(10);  		  
        g.addEdge(0, 1);  
        g.addEdge(0, 2);  
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(8, 9);
        System.out.println("Count of Tree : " +g.getCount(0));
	}

}
