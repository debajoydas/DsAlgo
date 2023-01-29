/**
 * 
 */
package com.debajoy.ds.graph;

import java.util.LinkedList;

/**
 * @author Debajoy
 *
 */
public class DirectedGraph1 {
	
	LinkedList<Integer>[] graph;
	int n;
	
	public DirectedGraph1(int n) {
		this.n = n;
		for(int i = 0; i< n; i++){
			graph[0] = new LinkedList<>();
		}
	}
	public void add(int u, int v){
		graph[u].add(v);
	}
}
