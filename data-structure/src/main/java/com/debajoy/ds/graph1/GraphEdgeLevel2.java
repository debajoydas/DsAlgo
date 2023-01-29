/**
 * 
 */
package com.debajoy.ds.graph1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Debajoy
 *
 */
public class GraphEdgeLevel2 {
	List<EdgeN>[] graph;
	int v;
	public GraphEdgeLevel2(int v) {
		this.graph = new LinkedList[v];
		this.v = v;
		for(int i = 0; i < v; i++){
			graph[i] = new ArrayList<>();
		}
	}
	public void addEdgeUndirected(int u, int v, int cost){
		graph[u].add(new EdgeN(u, v, cost));
		graph[v].add(new EdgeN(v, u, cost));
	}
	public void addEdgeDirected(int u, int v, int cost){
		graph[u].add(new EdgeN(u, v, cost));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String SEPERATOR ="**************************************************************************************";	
		System.out.println(SEPERATOR);
		int[][] icelandBridge = { {1,0,0,0,1},
				 				  {1,0,0,0,1},
				 				  {1,0,0,0,1},
				 				  {1,0,1,0,1},
				 				  {1,0,0,0,1},
				 				  {1,0,0,0,1}};
		getShortestBridgeVoid(icelandBridge);
		System.out.println(SEPERATOR);
		int[][] routes = {{1,2,7},{3,6,7}};
		int source = 1;
		int target = 6;
		System.out.println("Minimum Buses required to reach from Source to Destination :=> "+numBusesToDestination(routes, source, target));
		System.out.println(SEPERATOR);
		int[][] puzzle =  { {3,2,4},
		  		   			{1,5,0}
						  };
		int[][] puzzle1 = { {4,1,2},
				  			{5,0,3}};
		getMinMovesSlidingPuzzle(puzzle1);
		System.out.println(SEPERATOR);
		System.out.println(SEPERATOR);
		int[] swapArray = {6,4,2,14,8,10,12,16};	
		minimumNoOfSwapToSortArray(swapArray);
		int[] swapArray1 = {10,19,6,3,5};
		minimumNoOfSwapToSortArray(swapArray1);
		System.out.println(SEPERATOR);
		int src1 = 0; int dest1 = 6;
		GraphEdgeLevel2 graphEdgeLevel2 = createGraph6();
		getMinReversalEdges(graphEdgeLevel2.graph,graphEdgeLevel2.v,src1,dest1);
		System.out.println(SEPERATOR);
	}
	
	private static void getMinReversalEdges(List<EdgeN>[] graph, int v, int src1, int dest1) {
		// TODO Auto-generated method stub
		for(int i = 0; i < graph.length; i++){
			for(int j =0 ; j < graph[i].size(); j++){
				int src = graph[i].get(j).src;
				int dest = graph[i].get(j).dest;
				graph[dest].add(new EdgeN(dest, src, 1));				
			}
		}
		LinkedList<Dikstra> list = new LinkedList<>();
		int cost = 0;
		while(list.size() > 0){
			Dikstra rem = list.poll();
		}
	}
	class Dikstra{
		int v; 
		int cost;
		public Dikstra(int v, int cost) {
			super();
			this.v = v;
			this.cost = cost;
		}
	}
	private static GraphEdgeLevel2 createGraph6() {
		// TODO Auto-generated method stub
		int v = 7;
		GraphEdgeLevel2 graphEdgeLevel2 = new GraphEdgeLevel2(v);
		graphEdgeLevel2.addEdgeDirected(0, 1, 0);
		graphEdgeLevel2.addEdgeDirected(5, 1, 0);
		graphEdgeLevel2.addEdgeDirected(2, 1, 0);
		graphEdgeLevel2.addEdgeDirected(2, 3, 0);
		graphEdgeLevel2.addEdgeDirected(4, 5, 0);
		graphEdgeLevel2.addEdgeDirected(6, 4, 0);
		graphEdgeLevel2.addEdgeDirected(6, 3, 0);
		return graphEdgeLevel2;
	}
	
	private static void minimumNoOfSwapToSortArray(int[] arr) {
		// TODO Auto-generated method stub
		Swap[] swapArr = new Swap[arr.length];
		int totalSwapp = 0;
		for(int i = 0; i < arr.length; i++){
			swapArr[i] = new Swap(arr[i], i);
		}
		Arrays.sort(swapArr);
		boolean[] isVisited = new boolean[arr.length];
		for(int i = 0; i < arr.length; i++){
			if(isVisited[i]){
				continue;
			}
			int j = i;
			int count = 0;
			while(!isVisited[j]){
				isVisited[j] = true;
				j = swapArr[j].idx;
				count++;
			}
			totalSwapp += count-1;
		}
		System.out.println("Minimum No. of Swaps required to sort an Array:=> "+totalSwapp);
	}
	private static void getMinMovesSlidingPuzzle(int[][] puzzle) {
		int posi = 0;
		int posj = 0;
		for(int i = 0; i < puzzle.length; i++){
			for(int j = 0; j < puzzle[0].length;j++){
				if(puzzle[i][j] == 0){
					posi = i;
					posj = j;
					break;
				}
			}
		}
		Set<String> set = new HashSet<>();
		int counter = 0;
		AtomicInteger min = new AtomicInteger(Integer.MAX_VALUE);
		callDFSPuzzle(posi,posj,-1,-1,puzzle,set,counter,min);
		System.out.println("Minimum No. of moves for sliding puzzle:=> "+min.get());
	}

	private static void callDFSPuzzle(int i, int j,int oldi, int oldj, int[][] puzzle, Set<String> set, int counter, AtomicInteger min) {
		if(i < 0 || j < 0 || i >= puzzle.length || j >= puzzle[0].length || set.contains(i+"-"+j)){
			return;
		}
		set.add(i+"-"+j);
		if(!(oldi == -1 && oldj == -1)){
			int temp = puzzle[i][j];
			puzzle[i][j] = puzzle[oldi][oldj];
			puzzle[oldi][oldj] = temp;
		}
		if(i == 1 && j == 2){
			if(puzzleSolved(puzzle)){
				min.set(Math.min(min.get(), counter));
				set.remove(i+"-"+j);
				return;
			}
		}
		callDFSPuzzle(i+1, j, i, j, puzzle, set, counter+1, min);
		callDFSPuzzle(i-1, j, i, j, puzzle, set, counter+1, min);
		callDFSPuzzle(i, j+1, i, j, puzzle, set, counter+1, min);
		callDFSPuzzle(i, j-1, i, j, puzzle, set, counter+1, min);
		set.remove(i+"-"+j);
	}
	private static boolean puzzleSolved(int[][] puzzle) {
		return puzzle[0][0] == 1 && puzzle[0][1] == 2 && puzzle[0][2] == 3 && puzzle[1][0] == 4 && puzzle[1][1] == 5;
	}
	public static int numBusesToDestination(int[][] routes, int source, int target) {
	    int level = 0;
	    boolean isPossible = false;
	    Set<Integer> busVisited = new HashSet<>();
	    Set<Integer> busStopVisited = new HashSet<>();
	    Map<Integer,HashSet<Integer>> mapRoute = new HashMap<Integer,HashSet<Integer>>();
	    ArrayDeque<Integer> queue = new ArrayDeque<>();
	    queue.add(source);
	    for(int i = 0; i < routes.length; i++){
	    	for(int j = 0; j < routes[i].length; j++){
	    		int busStop = routes[i][j];
	    		if(mapRoute.get(busStop) == null){
	    			HashSet<Integer> set = new HashSet<>();
	    			set.add(i);
	    			mapRoute.put(busStop, set);
	    		}else{
	    			mapRoute.get(busStop).add(i);
	    		}
	    	}
	    }
	    while(queue.size() > 0){
	    	int size = queue.size();
	    	while(size > 0){
	    		size--;
	    		int busStop = queue.poll();
	    		if(busStop == target){
	    			isPossible = true;
	    			return level;
	    		}
	    		HashSet<Integer> buses = mapRoute.get(busStop);
	    		for(int bus : buses){
	    			if(busVisited.contains(bus)){
	    				continue;
	    			}
	    			int[] route = routes[bus];
	    			for(int eachRoute : route){
	    				if(busStopVisited.contains(eachRoute)){
	    					continue;
	    				}
	    				busStopVisited.add(eachRoute);
	    				queue.add(eachRoute);
	    			}
	    			busVisited.add(bus);
	    		}
	    	}
	    	level++;
	    }
	    return isPossible ? level:-1;
	}
	private static void getShortestBridgeVoid(int[][] iceland) {
		System.out.println("Shortest Bridge is :=> "+getShortestBridge(iceland));
	}
	private static int getShortestBridge(int[][] iceland) {
		ArrayDeque<Bridge> queue = new ArrayDeque<>();
		boolean[][] isVisited = new boolean[iceland.length][iceland[0].length];
		boolean isOneFound= false;int srci = 0; int srcj = 0;
		int shortestBridge = -1;
		for(int i = 0; i <  iceland.length; i++){
			if(isOneFound){
				break;
			}
			for(int j = 0; j < iceland[0].length; j++){
				if(iceland[i][j] == 1){
					isOneFound = true;
					srci = i; srcj = j;
					break;
				}
			}
		}
		callDFSBridge(srci,srcj,isVisited,iceland,queue);
		int initialQueSize = queue.size();
		int counter = 0;
		while(queue.size() > 0){
			Bridge rem = queue.remove();
			counter++;
			if(isVisited[rem.i][rem.j] && counter > initialQueSize){
				continue;
			}
			if(iceland[rem.i][rem.j] == 1 && counter > initialQueSize){
				shortestBridge = rem.level-1;
				return shortestBridge;
			}
			isVisited[rem.i][rem.j] = true;
			int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
			for(int i = 0; i < dir.length; i++){
				int row = rem.i + dir[i][0];
				int col = rem.j + dir[i][1];
				if(row >=0 && col >= 0 && row < iceland.length && col < iceland[0].length && !isVisited[row][col]){
					queue.add(new Bridge(row,col,rem.level+1));
				}
			}
		}
		return shortestBridge;
	}
	private static void callDFSBridge(int i, int j, boolean[][] isVisited, int[][] iceland,ArrayDeque<Bridge> queue) {
		if(i < 0 || j < 0 || i >= iceland.length || j >= iceland[0].length || iceland[i][j] == 0 || isVisited[i][j]){
			return;
		}
		isVisited[i][j] = true;
		queue.add(new Bridge(i, j, 0));
		callDFSBridge(i+1, j, isVisited, iceland, queue);
		callDFSBridge(i-1, j, isVisited, iceland, queue);
		callDFSBridge(i, j+1, isVisited, iceland, queue);
		callDFSBridge(i, j-1, isVisited, iceland, queue);	
	}

}

class Swap implements Comparable<Swap>{
	int i;
	int idx;
	public Swap(int i, int idx) {
		super();
		this.i = i;
		this.idx = idx;
	}
	@Override
	public int compareTo(Swap o) {
		// TODO Auto-generated method stub
		return Integer.valueOf(this.i).compareTo(Integer.valueOf(o.i));
	}
}

class Puzzle{
	int i;
	int j;
	public Puzzle(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}
	
}

class Bridge{
	int i;
	int j;
	int level;
	public Bridge(int i, int j, int level) {
		super();
		this.i = i;
		this.j = j;
		this.level = level;
	}
}