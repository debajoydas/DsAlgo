/**
 * 
 */
package com.debajoy.ds.graph;

/**
 * @author Debajoy
 *
 */
public class TestStronglyConnectedGraph {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 GraphAdjList g = new GraphAdjList(5); // 5 vertices numbered from 0 to 4
	        g.addEdge(1, 0);
	        g.addEdge(1, 2);
	        g.addEdge(3, 4);
	        System.out.println("Following are connected components");
	        g.stronglyConnectedComponents();
	}

}
