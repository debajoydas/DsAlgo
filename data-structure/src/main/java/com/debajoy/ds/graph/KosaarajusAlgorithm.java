/**
 * 
 */
package com.debajoy.ds.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Debajoy
 *
 */
public class KosaarajusAlgorithm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectedGraph g = new ConnectedGraph(5); 
	        g.addEdge(1, 0); 
	        g.addEdge(0, 2); 
	        g.addEdge(2, 1); 
	        g.addEdge(0, 3); 
	        g.addEdge(3, 4); 
	  
	        System.out.println("Following are strongly connected components "+ 
	                           "in given graph "); 
	        g.printSCCs();
	}

}

class ConnectedGraph{
	int V;
	LinkedList<Integer> adj[];
	
	public ConnectedGraph(int v) {
		super();
		V = v;
		adj = new LinkedList[V];
		for(int i=0; i<v; i++){
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void printSCCs() {
		// TODO Auto-generated method stub
		boolean[] isVisited = new boolean[this.V];
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i< V; i++){
			if(!isVisited[i]){
				fillStackByDFS(isVisited,stack,i);
			}
		}	
		
		ConnectedGraph graphTranspose = getTranspose();
		
		for(int i=0; i< V; i++){
			isVisited[i] = false;
		}
		
		while(stack.size() > 0){
			int itemPoped = stack.pop();
			if(!isVisited[itemPoped]){
				DFSUtil(itemPoped, stack, isVisited, graphTranspose);
			}		
			System.out.println();
		}
	}

	private void DFSUtil(int itemPoped, Stack<Integer> stack, boolean[] isVisited, ConnectedGraph graphTranspose) {
		    isVisited[itemPoped] = true; 
	        System.out.print(itemPoped + " "); 	  
	        int n; 
	        Iterator<Integer> itr =graphTranspose.adj[itemPoped].iterator(); 
	        while (itr.hasNext()) 
	        { 
	            n = itr.next(); 
	            if (!isVisited[n]) 
	                DFSUtil(n,stack, isVisited, graphTranspose); 
	        } 
	}

	private ConnectedGraph getTranspose() {
		// TODO Auto-generated method stub
		ConnectedGraph graphT = new ConnectedGraph(V);
		for(int i= 0; i<V;i++){
			Iterator<Integer> itr = adj[i].listIterator();
			while(itr.hasNext()){
				graphT.addEdge(itr.next(), i);
			}		
		}
		return graphT;
	}

	private void fillStackByDFS(boolean[] isVisited, Stack<Integer> stack, int i) {
		// TODO Auto-generated method stub
		isVisited[i] = true;
		Iterator<Integer> itr = adj[i].listIterator();
		while(itr.hasNext()){
			int n = itr.next();
			if(!isVisited[n]){
				fillStackByDFS(isVisited, stack, n);
			}
		}
		stack.push(i);
	}  

	public void addEdge(int u, int v){
		adj[u].add(v);
	}
}
