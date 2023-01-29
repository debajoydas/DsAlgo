/**
 * 
 */
package com.debajoy.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

import com.debajoy.ds.graph.BellManFordGraph.Edge;

/**
 * @author Debajoy
 *
 */
public class DijkstraGraph {

	private int V;
	private LinkedList<Node> arr[];
	
	public DijkstraGraph(int v, int[][] graph) {
		super();
		V = v;
		arr = new LinkedList[v];
		for(int i=0; i< v;i++){
			arr[i] = new LinkedList<Node>();
		}
		for(int i = 0; i< v; i++){
			for(int j = 0; j< v; j++){
				if(i != j && graph[i][j] > 0){
					arr[i].add(new Node(j, graph[i][j]));
				}
			}
		}
	}
	
	public int[] dikstraAlgorithm(int source, int[][] graph){
		
		boolean[] isVisited = new boolean[V];
		int[] distance = new int[V];
		for(int i = 0; i< V; i++){
			if(i == source){
				distance[i] = 0;
			}else{
				distance[i] = Integer.MAX_VALUE;
			}
		}
		for(int i = 0; i< V; i++){
			isVisited[i] = false;
		}
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(source);
		while(stack.size() > 0){
			int popedItem = stack.pop();
			isVisited[popedItem] = true;
			if(arr[popedItem].size() > 0){
				List<WeightByVertices> listOfWeight = new ArrayList<WeightByVertices>();
				for(int i = 0 ; i< arr[popedItem].size(); i++){
					if(!isVisited[arr[popedItem].get(i).getVertixExist()]){
						if(distance[popedItem]+arr[popedItem].get(i).getWeight() < distance[arr[popedItem].get(i).getVertixExist()]){
							distance[arr[popedItem].get(i).getVertixExist()] = distance[popedItem]+arr[popedItem].get(i).getWeight();
						}
						listOfWeight.add(new WeightByVertices(arr[popedItem].get(i).getVertixExist(), distance[arr[popedItem].get(i).getVertixExist()]));
					}
				}
				Collections.sort(listOfWeight,new ComparatorWeights());
				if(listOfWeight.size() > 0){
					stack.add(listOfWeight.get(0).vertex);
				}
			}
		}
		return distance;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 9;
		int source = 0;
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
            { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
            { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
            { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
            { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
            { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
            { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
            { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
            { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        
       DijkstraGraph dijkstraGraph = new DijkstraGraph(V, graph); 
       int[] dp = dijkstraGraph.dikstraAlgorithm(source, graph);
       for(int i : dp){
    	   System.out.println(i);
       }
	}

}
