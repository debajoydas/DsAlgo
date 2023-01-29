/**
 * 
 */
package com.debajoy.ds.graph1;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Debajoy
 *
 */
public class Graph {
	/**
	 * @param args
	 */
	int v;
	private int[][] graph;
	public Graph(int v) {
		this.v = v;
		this.graph = new int[v][v];
	}
	public void addEdgeUndirected(int u, int v){
		graph[u][v] = 1;
		graph[v][u] = 1;
	}
	public void addEdgeDirected(int u, int v){
		graph[u][v] = 1;
	}
	
	public void bfs(int s, int v){
		boolean[] isVisited = new boolean[v];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		isVisited[s] = true;
		while(!queue.isEmpty()){
			int pop = queue.poll();
			System.out.print(pop + "->");
			for(int i = 0;i < v;i++){
				if(graph[pop][i] != 0 && !isVisited[i]){
					queue.add(i);
					isVisited[i] = true;
				}
			}
		}
	}
	
	public void dfs(int s, int v){
		boolean[] isVisited = new boolean[v];
		Stack<Integer> stack = new Stack<>();
		stack.push(s);
		isVisited[s] = true;
		while(!stack.isEmpty()){
			int pop = stack.pop();
			System.out.print(pop+"->");
			for(int i = 0; i<v ; i++){
				if(graph[pop][i] != 0 && !isVisited[i]){
					stack.push(i);
					isVisited[i] = true;
				}
			}
		}
	}
	
	public void dfsRecursive(int s, int v){
		boolean[] isVisisted = new boolean[v];
		dfsRec(s,v,isVisisted);
	}
	
	private void dfsRec(int s, int v, boolean[] isVisisted) {
		// TODO Auto-generated method stub
		isVisisted[s] = true;
		System.out.print(s+"->");
		for(int i = 0; i<v ; i++){
			if(graph[s][i] != 0 && !isVisisted[i]){
				dfsRec(i, v, isVisisted);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v = 6;
		Graph graphDirected = new Graph(v);
		Graph graphUnDirected = new Graph(v);
		
		graphDirected.addEdgeDirected(0,1);
		graphDirected.addEdgeDirected(0,2);
		graphDirected.addEdgeDirected(1,3);
		graphDirected.addEdgeDirected(1,4);
		graphDirected.addEdgeDirected(2,4);
		graphDirected.addEdgeDirected(3,4);
		graphDirected.addEdgeDirected(3,5);
		graphDirected.addEdgeDirected(4,5);
		System.out.println("<-- BFS for Directed Graph -->");
		graphDirected.bfs(0, v);
		System.out.println();
		System.out.println();
		
		System.out.println("<-- DFS for Directed Graph -->");
		graphDirected.dfs(0, v);
		System.out.println();
		System.out.println();
		
		System.out.println("<-- Recursive DFS for Directed Graph -->");
		graphDirected.dfsRecursive(0, v);
		System.out.println();
		System.out.println();
		
		
		graphUnDirected.addEdgeUndirected(0,1);
		graphUnDirected.addEdgeUndirected(0,2);
		graphUnDirected.addEdgeUndirected(1,3);
		graphUnDirected.addEdgeUndirected(1,4);
		graphUnDirected.addEdgeUndirected(2,4);
		graphUnDirected.addEdgeUndirected(3,4);
		graphUnDirected.addEdgeUndirected(3,5);
		graphUnDirected.addEdgeUndirected(4,5);
		
		System.out.println("<-- BFS for Un-Directed Graph -->");
		graphUnDirected.bfs(0, v);
		System.out.println();
		System.out.println();
		
		System.out.println("<-- DFS for Un-Directed Graph -->");
		graphUnDirected.dfs(0, v);
		System.out.println();
		System.out.println();
		
		System.out.println("<-- Recursive DFS for Un-Directed Graph -->");
		graphUnDirected.dfsRecursive(0, v);
		System.out.println();
		System.out.println();
		

	}

}
