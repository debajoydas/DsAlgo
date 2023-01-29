/**
 * 
 */
package com.debajoy.ds.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Debajoy
 *
 */
public class GraphAdjList {

	int V; // total number of vertices
	LinkedList<Integer> arr[];
	
	public GraphAdjList(int V) {
		this.V = V;
		arr = new LinkedList[V];
		for(int i = 0; i< V; i++){
			arr[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int u, int v){
		arr[u].add(v);
	}
	
	public void printGraph(){
		if(arr == null){
			return;
		}
		for(int i = 0; i< arr.length; i++){
			System.out.print("Adjacency List of "+i+  ": ");
			for(int j = 0; j< arr[i].size(); j++){
				System.out.print(arr[i].get(j)+"->");
			}
			System.out.println();
		}
	}
	
	public void bfs(int start){
		System.out.println();
		System.out.println("-------------BFS--------------");
		boolean[] visited = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for(int i=0;i<V;i++){
			visited[i] = false;
		}
		queue.add(start);
		while(queue.size() > 0){
			int last =  queue.poll();
			if(!visited[last]){
				System.out.print(last+"->");
				visited[last] = true;
			}		
			for(int i = 0; i< arr[last].size(); i++){
				if(!visited[arr[last].get(i)]){
					queue.add(arr[last].get(i));
				}			
			}		
		}
	}
	
	public void dfs(int start){
		System.out.println();
		System.out.println("-------------DFS--------------");
		boolean[] visited = new boolean[V];
		for(int i = 0; i< V; i++){
			visited[i] = false;
		}
		Stack<Integer> stack = new Stack<Integer>();
		stack .add(start);
		while(stack.size() > 0){
			int last = stack.pop();
			if(!visited[last]){
				visited[last] = true;
				System.out.print(last+"->");
			}
			for(int j = 0; j<arr[last].size(); j++){
				if(!visited[arr[last].get(j)]){
					stack.add(arr[last].get(j));
				}			
			}
		}
	}
	
	// Optimized method to find out if circle does exist
	public boolean isCycleExistOptimzed(){
		boolean isCycleExist = false;
		for(int i = 0; i<V; i++){
			isCycleExist = isCycleExistStackOptimzed(i);
			if(isCycleExist){
				break;
			}
		}
		return isCycleExist;
	}
	
	private boolean isCycleExistStackOptimzed(int i) {
		// TODO Auto-generated method stub
		boolean result = false;
		Stack<Integer> stack = new Stack<Integer>();
		int[] status = new int[V];
		for(int j = 0;j<V; j++){
			status[j] = -1;
		}
		stack.add(i);
		while(stack.size() != 0){
			int last = stack.peek();
			status[last] = 0;
			
			if(arr[last].size() <= 0 || checkAllChildProcessed(arr[last],status)){
				int lastVerified = stack.pop();
				status[lastVerified] = 1;
			}else{
				for(int k = 0; k< arr[last].size(); k++){
					if(status[arr[last].get(k)] == 0){
						result = true;
						return result;
					}
					if(status[arr[last].get(k)] == -1){
						stack.add(arr[last].get(k));
					}			
				}
			}
			
			
		}
		return result;
	}

	private boolean checkAllChildProcessed(LinkedList<Integer> linkedList, int[] status) {
		// TODO Auto-generated method stub
		boolean result = false;
		int count = 0;
		if(linkedList != null && linkedList.size() > 0){
			for(int i = 0; i<linkedList.size(); i++ ){
				if(status[linkedList.get(i)] == 1){
					count++;
				}
			}
			if(count == linkedList.size()){
				result = true;
			}
		}
		return result;
	}

	public boolean isCycleExist(){
		boolean isCycleFound = false;
		for(int i = 0; i<V; i++){
			isCycleFound = isCyCleFoundForEachVertex(i);
			if(isCycleFound){
				break;
			}
		}
		
		
		for (int i = 0; i < V; i++) 
	       { 
	           for (int j = 0; j < V; j++) 
	           { 
	               for (int k=0; k<V; k++) 
	               { 

	               } 
	           } 
	       } 
	   
		
		return isCycleFound;
	}

	private boolean isCyCleFoundForEachVertex(int start) {
		// TODO Auto-generated method stub
		
		int[] statusArray = new int[V];
		for(int i = 0; i< V; i++){
			statusArray[i] = -1;
		}
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(start);
		
		while(stack.size() > 0){
			int last = stack.pop();
			statusArray[last] = 0;
			
			if(arr[last].size() <= 0){
				statusArray[last] = 1;
			}else{
				for(int j = 0; j< arr[last].size(); j++ ){
					if(statusArray[j] == -1){
						stack.add(arr[last].get(j));
					}else if(statusArray[j] == 0){
						return true;
					}
				}
			}
			
		}
		
		return false;
	}
	
	public void stronglyConnectedComponents(){
		
		boolean[] isVisited = new boolean[V];
		for(int i = 0; i < V; i++){
			if(!isVisited[i]){
				dfsUtil(i,isVisited);
				System.out.println();
			}
		}
	}

	private void dfsUtil(int i, boolean[] isVisited) {
		// TODO Auto-generated method stub
		isVisited[i] = true;
		System.out.print(i+" ");
		for(int k = 0; k < arr[i].size(); k++){
			if(!isVisited[arr[i].get(k)]){
				dfsUtil(arr[i].get(k), isVisited);
			}
		}
	}
}
