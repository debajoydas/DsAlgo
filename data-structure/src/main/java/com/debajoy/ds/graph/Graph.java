package com.debajoy.ds.graph;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import com.debajoy.ds.queue.QueueLinkedList;

public class Graph {
	
	private int V;
	private LinkedList<Integer> arr[];
	
	public Graph(int v) {		
		V = v;
		arr = new LinkedList[v];
		for(int i=0; i< v;i++){
			arr[i] = new LinkedList<Integer>();
		}
	}
	
	public void printGraph(int V){
		if(arr == null){
			return;
		}
		for(int i = 0; i< arr.length; i++){
			System.out.print("Adjacency List is : ");
			for(int j = 0; j< arr[i].size(); j++){
				System.out.print(arr[i].get(j)+"->");
			}
			System.out.println();
		}
	}
	
	public void addEdge(int V, int W){
		arr[V].add(W);
	}
	
	public void BFS(int node){
		
		boolean[] visited = new boolean[V];
		visited[node] = true;
		LinkedList<Integer> queue = new LinkedList<Integer>(); 
		queue.add(node);
		
		while(queue != null){
			if(queue.size() > 0){
				int poll = queue.poll();
				System.out.println(poll);
				Iterator<Integer> i = arr[poll].listIterator(); 
				 while (i.hasNext()) 
		            { 
		                int n = i.next(); 
		                if (!visited[n]) 
		                { 
		                    visited[n] = true; 
		                    queue.add(n);
		                } 
		            } 
			}
		}
	}
	
	public void DFS(int node){
		
		boolean[] visited = new boolean[V];
		for(int i=0;i< V;i++){
			visited[i] = false;
		}
		Stack<Integer> stackBFS = new Stack<Integer>();
		stackBFS.push(node);
		
		while(stackBFS != null){
			if(!stackBFS.isEmpty()){
				int popedItem = stackBFS.pop();
				System.out.print(popedItem+" -> ");
				visited[popedItem] = true;
					
				Iterator<Integer> iterator = arr[popedItem].listIterator();
				while(iterator.hasNext()){
					int i = iterator.next();
					if(!visited[i]){
						visited[i] =  true;
						stackBFS.push(i);
					}
					
				}
			}					
		}	
	}

	public Integer getCount(int node){
	
		boolean[] visited = new boolean[V];
		Integer countOfTree = 0;
		Stack<Integer> stackBFSTree = new Stack<Integer>();
		for(int i=0;i< V;i++){
			visited[i] = false;
			stackBFSTree.add(i);
		}
		
		Stack<Integer> stackBFS = new Stack<Integer>();
		stackBFS.push(node);
		
		while(stackBFSTree != null && !stackBFSTree.isEmpty()){
			if(stackBFS.isEmpty()){
				System.out.println();
				int popTree = stackBFSTree.firstElement();
				stackBFS.push(popTree);
			}else{
				while(stackBFS != null && !stackBFS.isEmpty()){
						int popedItem = stackBFS.pop();
						stackBFSTree.remove(new Integer(popedItem));
						System.out.print(popedItem+" -> ");
						visited[popedItem] = true;
							
						Iterator<Integer> iterator = arr[popedItem].listIterator();
						
						while(iterator.hasNext()){
							int i = iterator.next();
							if(!visited[i]){
								visited[i] =  true;
								stackBFS.push(i);
							}
							
						}				
				}
				countOfTree++;
			}	
		}
		return countOfTree;
	}
	
	public int[] dikstraAlgorithm(int source){
		
		boolean[] isIncludedArray = new boolean[V];
		for(int i = 0; i< V; i++){
			isIncludedArray[i] = false;
		}
		int[] aggregatedDistArray = new int[V];
		aggregatedDistArray[source] = 0;
		for(int i = 0; i< V; i++){
			if(i != source){
				aggregatedDistArray[i] = Integer.MAX_VALUE;
			}
		}
		ThreadLocal locale = new ThreadLocal<>();
		locale.set(aggregatedDistArray);
		PriorityQueue<Integer> popedQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
			Integer[] aggregatedDistArray = (Integer[]) locale.get();
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub		
				return aggregatedDistArray[o1].compareTo(aggregatedDistArray[o2]);
			}
		});
		popedQueue.add(source);
		while(popedQueue.size() > 0){
			int popedItem = popedQueue.poll();
			if(source == popedItem){
				isIncludedArray[popedItem]  = true;
				Iterator<Integer> iterator = arr[popedItem].iterator();
				while(iterator.hasNext()){
					if(!isIncludedArray[iterator.next()]){
						popedQueue.add(iterator.next());
					}
				}
				if(popedQueue.size() > 0){
					int popedItemChild = popedQueue.poll();
					
				}
			}
		}
		return null;
		
	
	}

	public void AP() {
		// TODO Auto-generated method stub
		
	}
	
}
  