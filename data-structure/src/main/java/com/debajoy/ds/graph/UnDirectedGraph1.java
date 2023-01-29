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
public class UnDirectedGraph1 {

	LinkedList<Integer>[] graph;
	int n;
	
	public UnDirectedGraph1(int n) {
		this.n = n;
		graph = new LinkedList[n];
		for(int i = 0; i< n; i++){
			graph[i] = new LinkedList<>();
		}
	}
	public void addEdge(int u, int v){
		graph[u].add(v);
		graph[v].add(u);
	}
	public void BFS(int u){
		boolean[] isVisited = new boolean[n];
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(u);
		isVisited[u] = true;
		while(queue.size() > 0){
			int removed = queue.poll();
			System.out.println(removed);
			for(int i = 0; i < graph[removed].size(); i++){
				if(!isVisited[graph[removed].get(i)]){
					isVisited[graph[removed].get(i)] = true;
					queue.add(graph[removed].get(i));
				}
			}
		}
	}
	
	public void DFS(int u){
		boolean[] isVisited = new boolean[n];
		Stack<Integer> stack = new Stack<>();
		stack.add(u);
		isVisited[u] = true;
		while(stack.size() > 0){
			int removed = stack.pop();
			System.out.println(removed);
			Iterator<Integer> itr = graph[removed].listIterator();
			while(itr.hasNext()){
				int next = itr.next();
				if(!isVisited[next]){
					isVisited[next] = true;
					stack.push(next);
				}
			}
		}
	}
	
	public void DFSRecUtil(int u){
		boolean[] isVisited = new boolean[n];
		DFSRecursion(u, isVisited);
	}
	
	private void DFSRecursion(int u, boolean[] isVisited){
		isVisited[u] = true;
		System.out.println(u);
		for(int i = 0; i< graph[u].size(); i++){
			if(!isVisited[graph[u].get(i)]){
				DFSRecursion(graph[u].get(i), isVisited);
			}
		}
	}
	
	public boolean isCyclic(){
		return false;	
	}
	
	public static void main(String[] args) {
		UnDirectedGraph1 g = new UnDirectedGraph1(6);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);
        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 5)");

        g.BFS(5);
        
        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 5)");

        g.DFS(5);
        
        System.out.println("Following is Depth First Traversal Using Recursion "+
                "(starting from vertex 5)");

        g.DFSRecUtil(5);
	}
}
