/**
 * 
 */
package com.debajoy.ds.graph1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Debajoy
 *
 */
public class GraphAdj {
	/**
	 * @param args
	 */
	private int v;
	private List<Integer>[] graph;
	public GraphAdj(int v) {
		this.v = v;
		graph = new ArrayList[v];
		for(int i = 0; i<v;i++){
			graph[i] = new ArrayList<Integer>();
		}
	}
	public void addEdgeUndirected(int u, int v){
		graph[u].add(v);
		graph[v].add(u);
	}
	public void addEdgeDirected(int u, int v){
		graph[u].add(v);
	}
	public void bfs(int s, int v){
		boolean[] isVisited = new boolean[v];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		isVisited[s] = true;
		while(!queue.isEmpty()){
			int pop = queue.poll();
			System.out.print(pop + "->");
			for(int i = 0;i < graph[pop].size();i++){
				if(!isVisited[graph[pop].get(i)]){
					queue.add(graph[pop].get(i));
					isVisited[graph[pop].get(i)] = true;
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
			for(int i = 0;i < graph[pop].size();i++){
				if(!isVisited[graph[pop].get(i)]){
					stack.push(graph[pop].get(i));
					isVisited[graph[pop].get(i)] = true;
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
		for(int i = 0;i < graph[s].size();i++){
				if(!isVisisted[graph[s].get(i)]){
					dfsRec(graph[s].get(i), v, isVisisted);
				}	
		}
	}
	
	public boolean isCyclicDirected(){
		boolean[] isVisited = new boolean[this.v];
		for(int i = 0; i< v; i++){
			isVisited[i] = true;
			for(int j = 0; j < graph[i].size(); j++){
					if(isCyclicUtilDirected(graph[i].get(j),isVisited)){
						return true;
					}
			}
			isVisited[i] = false;
		}
		return false;
	}
	
	private boolean isCyclicUtilDirected(int i, boolean[] isVisited) {
		// TODO Auto-generated method stub
		if(isVisited[i]){
			return true;
		}
		isVisited[i]=true;
		for(int child = 0; child < graph[i].size(); child++){
			if(isCyclicUtilDirected(graph[i].get(child), isVisited)){
				return true;
			}
		}
		isVisited[i]=false;
		return false;
	}
	
	public boolean isCyclicUnDirected(){
		int[] isVisited = new int[v];
		for(int i = 0; i<v;i++){
			isVisited[i] = -1;
		}
		for(int i = 0; i <  v; i++){
			LinkedList<Integer> queue = new LinkedList<Integer>();
			if(isCyclicUnDirectedUtil(i,isVisited,queue)){
				return true;
			}
		}
		return false;
	}
	
	private boolean isCyclicUnDirectedUtil(int i, int[] isVisited, LinkedList<Integer> queue) {
		// TODO Auto-generated method stub
		queue.add(i);
		isVisited[i] = 0;
		while(!queue.isEmpty()){
			int pop = queue.poll();
			isVisited[pop] = 1;
			for(int j =0;j < graph[pop].size();j++){
				if(isVisited[graph[pop].get(j)] == 0){
					return true;
				}else if(isVisited[graph[pop].get(j)] == -1){
					queue.add(graph[pop].get(j));
					isVisited[graph[pop].get(j)] = 0;
				}
			}
		}
		return false;
	}
	private void graphColoring(int m){
		Integer[] vertices = new Integer[v];
		int level = 0;
		Integer[] mArray = new Integer[m];
		for(int i = 0; i< m ; i++){
			mArray[i] = i;
		}
		graphColoringRec(vertices,level,mArray);
	}
	
	private void graphColoringRec(Integer[] vertices, int level, Integer[] mArray) {
		// TODO Auto-generated method stub
		if(level >= v){
			Arrays.asList(vertices).forEach(s-> System.out.print(s+"->"));
			System.out.println();
			return;
		}else{
			for(int i =0;i<mArray.length;i++){
				if(condition(level,vertices,mArray[i])){
					vertices[level] = mArray[i];
					graphColoringRec(vertices, level+1, mArray);
					vertices[level] = null;
				}else{
					continue;
				}
			}
		}
	}
	private boolean condition(int level, Integer[] vertices, int m) {
		// TODO Auto-generated method stub
		for(int i = 0; i < graph[level].size(); i++){
			if(vertices[graph[level].get(i)] != null && vertices[graph[level].get(i)] == m){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v = 6;
		GraphAdj graphDirected = new GraphAdj(v);
		GraphAdj graphUnDirected = new GraphAdj(v);
		
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
		
		GraphAdj graphCyclicDirected = new GraphAdj(5);
		
		graphCyclicDirected.addEdgeDirected(0,1);
	//	graphCyclicDirected.addEdgeDirected(0,2);
		graphCyclicDirected.addEdgeDirected(2,1);
		graphCyclicDirected.addEdgeDirected(2,3);
		graphCyclicDirected.addEdgeDirected(3,4);
		graphCyclicDirected.addEdgeDirected(4,0);
		graphCyclicDirected.addEdgeDirected(4,2);
		System.out.println("Is Graph Cyclic ? "+graphCyclicDirected.isCyclicDirected());
		System.out.println();
		
		GraphAdj graphColoring = new GraphAdj(5);
		
		graphColoring.addEdgeUndirected(0,1);
		graphColoring.addEdgeUndirected(2,1);
		graphColoring.addEdgeUndirected(2,3);
		graphColoring.addEdgeUndirected(3,4);
		graphColoring.addEdgeUndirected(4,0);
		graphColoring.addEdgeUndirected(4,2);
		System.out.println();
		graphColoring.graphColoring(3);
		
		GraphAdj graphUndirectedCycle = new GraphAdj(6);
		
		graphUndirectedCycle.addEdgeUndirected(0,1);
		graphUndirectedCycle.addEdgeUndirected(0,2);
		graphUndirectedCycle.addEdgeUndirected(0,5);
		graphUndirectedCycle.addEdgeUndirected(1,3);
		graphUndirectedCycle.addEdgeUndirected(1,4);
		graphUndirectedCycle.addEdgeUndirected(3,5);
		System.out.println(graphUndirectedCycle.isCyclicUnDirected());

	}

}
