/**
 * 
 */
package com.debajoy.ds.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Debajoy
 *
 */
public class TopologicalSorting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TopologicalGraph g = new TopologicalGraph(6); 
	    g.addEdge(5, 2); 
	    g.addEdge(5, 0); 
	    g.addEdge(4, 0); 
	    g.addEdge(4, 1); 
	    g.addEdge(2, 3); 
	    g.addEdge(3, 1); 
	  
	    System.out.println("Following is a Topological " + "sort of the given graph"); 
	    g.topologicalSort(); 

	}

}

class TopologicalGraph{
	
	int V;
	LinkedList[] adjList;
	
	public TopologicalGraph(int v) {
		super();
		V = v;
		adjList = new LinkedList[V];
		for(int i = 0; i< V; i++){
			adjList[i] = new LinkedList<Integer>();
		}
	}
	
	public void topologicalSort() {
		// TODO Auto-generated method stub
		boolean[] isVisited = new boolean[V];	
		List<Stack<Integer>> stackTopologyList = new ArrayList<Stack<Integer>>();
		for(int x = 0 ; x < V; x++){
			for(int i = 0; i < V; i++){
				isVisited[i] = false;
			}
			Stack<Integer> stackTopology = new Stack<Integer>();
			for(int i = 0; i < V; i++){
				if(!isVisited[i]){
					topologicalSortUtil(i,isVisited,stackTopology);
				}
			}
			if(!stackTopology.isEmpty()){
				stackTopologyList.add(stackTopology);
			}
		}		
		printTopologyList(stackTopologyList);
	}

	private void printTopologyList(List<Stack<Integer>> stackTopologyList) {
		// TODO Auto-generated method stub
		stackTopologyList.forEach((list) -> printlist(list));
	}

	private void printlist(Stack<Integer> list) {
		// TODO Auto-generated method stub
		System.out.println();
		while(!list.isEmpty()){
			System.out.print(list.pop()+ " -> ");
		}
	}

	private void topologicalSortUtil(int u, boolean[] isVisited, Stack<Integer> stackTopology) {
		// TODO Auto-generated method stub
		isVisited[u] = true;
		Iterator<Integer> itr = adjList[u].listIterator();
		while(itr.hasNext()){
			int v = itr.next();
			if(!isVisited[v]){
				topologicalSortUtil(v, isVisited, stackTopology);
			}
		}
		stackTopology.push(u);
	}

	public void addEdge(int u, int v){
		adjList[u].add(v);
	}
}
