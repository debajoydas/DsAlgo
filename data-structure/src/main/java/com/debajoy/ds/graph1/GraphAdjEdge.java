/**
 * 
 */
package com.debajoy.ds.graph1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @author Debajoy
 *
 */
public class GraphAdjEdge {

	/**
	 * @param args
	 */
	private int v;
	private List<Edge>[] graph;
	final static int INF = 99999;
	
	public GraphAdjEdge(int v) {
		super();
		this.v = v;
		this.graph = new ArrayList[v];
		for(int i = 0; i < v; i++){
			graph[i] = new ArrayList<Edge>();
		}
	}
	public void addEdgeUndirected(int u, int v, int edge){
		graph[u].add(new Edge(u,v,edge));
		graph[v].add(new Edge(v,u,edge));
	}
	public void addEdgeDirected(int u, int v, int edge){
		graph[u].add(new Edge(u,v,edge));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String SEPERATOR ="**************************************************************************************";	
		GraphAdjEdge graphAdjEdge = createGraph1();
		System.out.println(SEPERATOR);
		int source = 0; int destination  = 6;
		System.out.println("Has a Path from Source("+source+") to ("+destination+") => "+hasAPath(graphAdjEdge.graph,graphAdjEdge.v,source,destination));
		System.out.println(SEPERATOR);
		printAllPaths(graphAdjEdge.graph,graphAdjEdge.v,source,destination);
		System.out.println(SEPERATOR);
		GraphAdjEdge graphAdjEdge1 = createGraph2();
		int number = 40;
		getSmallestLargestFloorCeil(graphAdjEdge1.graph,graphAdjEdge1.v,source,destination, number);
		System.out.println(SEPERATOR);
		GraphAdjEdge graphAdjEdge3 = createGraph3();
		getConnectedComponents(graphAdjEdge3.graph,graphAdjEdge3.v);
		isGraphConnected(graphAdjEdge3.graph,graphAdjEdge3.v);
		System.out.println(SEPERATOR);
		int[][] iceland = { {0,0,1,1,1,0,0,0},
							{0,0,1,1,1,1,1,1},
							{1,1,1,1,1,1,1,0},
							{1,1,0,0,0,1,1,0},
							{1,1,1,1,0,1,1,0},
							{1,1,1,1,0,1,1,0},
							{1,1,1,1,1,1,1,0},
							{1,1,1,1,1,1,1,0},
						 };
		getNoOfIceLands(iceland);
		System.out.println(SEPERATOR);
		int v1= 7; int e1 = 5;
		int[][] pair = {{0,1},
						{2,3},
						{4,5},
						{5,6},
						{4,6}};
		getNoOfPerfectFriendsPair(v1,e1,pair);
		System.out.println(SEPERATOR);
		GraphAdjEdge graphAdjEdge4 = createGraph4();
		printHamiltonianPathCycle(graphAdjEdge4.graph,graphAdjEdge4.v,source);
		System.out.println(SEPERATOR);
		int[][] arr = new int[5][5];
		int rStrt = 2; int colStart = 4;
	//	knightTour(arr, rStrt, colStart);
		System.out.println(SEPERATOR);	
		bfs(graphAdjEdge4.graph,graphAdjEdge4.v,source);
		System.out.println(SEPERATOR);	
		isCyclicGraph(graphAdjEdge4.graph,graphAdjEdge4.v,source);
		isCyclicGraph(graphAdjEdge.graph,graphAdjEdge.v,source);
		System.out.println(SEPERATOR);	
		dikstra(graphAdjEdge4.graph,graphAdjEdge4.v,source);
		System.out.println(SEPERATOR);	
		GraphAdjEdge graphAdjEdge5 = createGraph5();
		topologicalSort(graphAdjEdge5.graph,graphAdjEdge5.v);
		System.out.println(SEPERATOR);	
		isBipartieGraph(graphAdjEdge4.graph,graphAdjEdge4.v);
		System.out.println(SEPERATOR);	
		int t = 3;
		int src = 0;
		countOfSpreadInfection(graphAdjEdge4.graph,graphAdjEdge4.v, t, src);
		System.out.println(SEPERATOR);	
		int[][] icelands = { {1,1,0,0,0},
							 {1,1,1,0,0},
							 {0,0,0,1,1},
							 {0,0,1,1,1},
							 {1,1,0,0,0},
							 {1,1,1,0,0}};
		getNoOfDistinctIceLands(icelands);
		System.out.println(SEPERATOR);	
		int[][] enclaves = { {0,0,1,1,0},
				 			 {0,1,1,0,0},
				 			 {0,1,0,0,1},
				 			 {0,0,1,0,0},
				 			 {0,1,1,0,0},
				 			 {0,0,0,0,0}};
		getNoOfEnclaves(enclaves);
		System.out.println(SEPERATOR);	
		int[][] rotton = {{2,0,1,0,0},
						  {1,1,1,0,0},
						  {0,0,0,0,0},
						  {0,0,1,1,1},
						  {0,1,1,2,0}};
		int[][] rotton1 = {{1},
							{2}};
		getTimeToRottonOrrange(rotton1);
		System.out.println(SEPERATOR);	
		floydWarshall(graphAdjEdge4.graph,graphAdjEdge4.v);
		System.out.println(SEPERATOR);
		int[][] icelandBridge = { {1,0,0,0,1},
				 				  {1,0,0,0,1},
				 				  {1,0,0,0,1},
				 				  {1,0,1,0,1},
				 				  {1,0,0,0,1},
				 				  {1,0,0,0,1}};
		getShortestBridge(icelandBridge);
		System.out.println(SEPERATOR);
		int[][] puzzle = {{4,1,2},
						  {5,0,3}};
		int[][] puzzle1 = {{3,2,4},
				  		   {1,5,0}};
		getMinMovesSlidingPuzzle(puzzle);
		System.out.println(SEPERATOR);
		int[] swapArray = {6,4,2,14,8,10,12,16};	
		minimumNoOfSwapToSortArray(swapArray);
		int[] swapArray1 = {10,19,6,3,5};
		minimumNoOfSwapToSortArray(swapArray1);
		System.out.println(SEPERATOR);
		int src1 = 0; int dest1 = 6;
		GraphAdjEdge graphAdjEdge6 = createGraph6();
		getMinReversalEdges(graphAdjEdge6.graph,graphAdjEdge6.v,src1,dest1);
		System.out.println(SEPERATOR);
	}

	private static GraphAdjEdge createGraph3() {
		int v = 7;
		GraphAdjEdge graphAdjEdge = new GraphAdjEdge(v);
		graphAdjEdge.addEdgeUndirected(0, 1, 10);
		graphAdjEdge.addEdgeUndirected(2, 3, 40);
		graphAdjEdge.addEdgeUndirected(4, 5, 10);
		graphAdjEdge.addEdgeUndirected(4, 6, 10);
		return graphAdjEdge;
	}
	private static GraphAdjEdge createGraph2() {
		int v = 7;
		GraphAdjEdge graphAdjEdge = new GraphAdjEdge(v);
		graphAdjEdge.addEdgeUndirected(0, 1, 10);
		graphAdjEdge.addEdgeUndirected(0, 3, 40);
		graphAdjEdge.addEdgeUndirected(1, 2, 10);
		graphAdjEdge.addEdgeUndirected(2, 3, 10);
		graphAdjEdge.addEdgeUndirected(3, 4, 2);
		graphAdjEdge.addEdgeUndirected(4, 5, 3);
		graphAdjEdge.addEdgeUndirected(5, 6, 3);
		graphAdjEdge.addEdgeUndirected(4, 6, 8);
		return graphAdjEdge;
	}
	public static GraphAdjEdge createGraph1(){
		int v = 7;
		GraphAdjEdge graphAdjEdge = new GraphAdjEdge(v);
		graphAdjEdge.addEdgeUndirected(0, 1, 10);
		graphAdjEdge.addEdgeUndirected(0, 3, 10);
		graphAdjEdge.addEdgeUndirected(1, 2, 10);
		graphAdjEdge.addEdgeUndirected(2, 3, 10);
		graphAdjEdge.addEdgeUndirected(3, 4, 10);
		graphAdjEdge.addEdgeUndirected(4, 5, 10);
		graphAdjEdge.addEdgeUndirected(5, 6, 10);
		graphAdjEdge.addEdgeUndirected(4, 6, 10);
		return graphAdjEdge;
	}
	public static GraphAdjEdge createGraph4(){
		int v = 7;
		GraphAdjEdge graphAdjEdge = new GraphAdjEdge(v);
		graphAdjEdge.addEdgeUndirected(0, 1, 10);
		graphAdjEdge.addEdgeUndirected(0, 3, 10);
		graphAdjEdge.addEdgeUndirected(1, 2, 12);
		graphAdjEdge.addEdgeUndirected(2, 3, 13);
		graphAdjEdge.addEdgeUndirected(2, 5, 3);
		graphAdjEdge.addEdgeUndirected(3, 4, 5);
		graphAdjEdge.addEdgeUndirected(4, 5, 2);
		graphAdjEdge.addEdgeUndirected(4, 6, 7);
		graphAdjEdge.addEdgeUndirected(5, 6, 8);
		return graphAdjEdge;
	}	
	public static GraphAdjEdge createGraph5(){
		int v = 7;
		GraphAdjEdge graphAdjEdge = new GraphAdjEdge(v);
		graphAdjEdge.addEdgeDirected(0, 1, 10);
		graphAdjEdge.addEdgeDirected(0, 3, 10);
		graphAdjEdge.addEdgeDirected(1, 2, 12);
		graphAdjEdge.addEdgeDirected(2, 3, 13);
		graphAdjEdge.addEdgeDirected(4, 3, 3);
		graphAdjEdge.addEdgeDirected(4, 5, 5);
		graphAdjEdge.addEdgeDirected(4, 6, 2);
		graphAdjEdge.addEdgeDirected(5, 6, 2);
		return graphAdjEdge;
	}	
	private static GraphAdjEdge createGraph6() {
		// TODO Auto-generated method stub
		int v = 7;
		GraphAdjEdge graphAdjEdge = new GraphAdjEdge(v);
		graphAdjEdge.addEdgeDirected(0, 1, 0);
		graphAdjEdge.addEdgeDirected(5, 1, 0);
		graphAdjEdge.addEdgeDirected(2, 1, 0);
		graphAdjEdge.addEdgeDirected(2, 3, 0);
		graphAdjEdge.addEdgeDirected(4, 5, 0);
		graphAdjEdge.addEdgeDirected(6, 4, 0);
		graphAdjEdge.addEdgeDirected(6, 3, 0);
		return graphAdjEdge;
	}
	
	public static boolean hasAPath(List<Edge>[] graph, int v, int s, int d){
		boolean[] isVisited= new boolean[v];
		return hasAPath(graph, v, s, d, isVisited);
	}
	
	private static boolean hasAPath(List<Edge>[] graph, int v, int s, int d, boolean[] isVisited) {
		// TODO Auto-generated method stub
		if(s == d){
			return true;
		}
		isVisited[s] =  true;
		for(int i = 0; i < graph[s].size(); i++){
			if(!isVisited[graph[s].get(i).dest]){
				if(hasAPath(graph, v, graph[s].get(i).dest, d, isVisited)){
					return true;
				}
			}
		}
		return false;
	}
	
	public static void printAllPaths(List<Edge>[] graph, int v, int s, int d){
		System.out.println("Print All Path from Source("+s+") to ("+d+") => ");
		boolean[] isVisited= new boolean[v];
		String path = new String(s+"->");
		printAllPathsRec(graph, v, s, d, isVisited, path);
	}
	private static void printAllPathsRec(List<Edge>[] graph, int v, int s, int d, boolean[] isVisited,String path) {
		// TODO Auto-generated method stub
		if(s == d){
			System.out.println(path);
		}
		isVisited[s] = true;
		for(int i = 0; i < graph[s].size(); i++){
			if(!isVisited[graph[s].get(i).dest]){
				printAllPathsRec(graph, v, graph[s].get(i).dest, d, isVisited, path+graph[s].get(i).dest+"->");
			}
		}
		isVisited[s] = false;
	}
	
	public static void getSmallestLargestFloorCeil(List<Edge>[] graph, int v, int s, int d, int number) {
		// TODO Auto-generated method stub
		boolean[] isVisited= new boolean[v];
		List<Pair> pathWithCostList = new ArrayList<Pair>();
		String path = new String(s+"->");
		int sum = 0;
		getSmallestLargestFloorCeilRec(graph, v, s, d, isVisited, path, pathWithCostList, sum);		
		Collections.sort(pathWithCostList,new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				return Integer.valueOf(o1.cost).compareTo(Integer.valueOf(o2.cost));
			}
		});
		System.out.println("Path with Smallest Cost from Source("+s+") to ("+d+") => "+pathWithCostList.get(0).path+" @"+pathWithCostList.get(0).cost);
		System.out.println("Path with Largest Cost from Source("+s+") to ("+d+") => "+pathWithCostList.get(0).path+" @"+pathWithCostList.get(pathWithCostList.size()-1).cost);
		System.out.println("Path with 3rd Largest Cost from Source("+s+") to ("+d+") => "+pathWithCostList.get(0).path+" @"+pathWithCostList.get(pathWithCostList.size()-3).cost);
		pathWithCostList.stream().filter(pair -> pair.cost > number).collect(Collectors.toList()).get(0);
		System.out.println("Ceil of Number("+number+") => "+pathWithCostList.stream().filter(pair -> pair.cost > number).collect(Collectors.toList()).get(0).cost);
		List<Pair> pathWithCostFloor = pathWithCostList.stream().filter(pair -> pair.cost < number).collect(Collectors.toList());
		System.out.println("Floor of Number("+number+") => "+pathWithCostFloor.get(pathWithCostFloor.size()-1).cost);		
	}
	
	private static void getSmallestLargestFloorCeilRec(List<Edge>[] graph, int v, int s, int d, boolean[] isVisited, String path, List<Pair> pathWithCostList, int sum) {
		// TODO Auto-generated method stub
		if(s == d){
			pathWithCostList.add(new Pair(path,sum));
		}
		isVisited[s] = true;		
		for(int i = 0; i < graph[s].size(); i++){
			if(!isVisited[graph[s].get(i).dest]){
				getSmallestLargestFloorCeilRec(graph, v, graph[s].get(i).dest, d, isVisited, path+graph[s].get(i).dest+"->", pathWithCostList, sum+graph[s].get(i).edge);
			}
		}
		isVisited[s] = false;
	}
	
	public static List<List<Integer>> getConnectedComponents(List<Edge>[] graph, int v) {
		System.out.println("All the COnnected Components of the Graph :=> ");
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		boolean[] isVisited = new boolean[v];
		for(int i = 0; i < v; i++){
			List<Integer> list = new ArrayList<>();
			if(!isVisited[i]){
				dfs(i,graph,v,list,isVisited);
				lists.add(list);
			}			
		}
		System.out.println(lists);
		return lists;
	}
	private static void dfs(int src, List<Edge>[] graph, int v, List<Integer> list, boolean[] isVisited) {
		// TODO Auto-generated method stub
		isVisited[src] = true;
		list.add(src);
		for(int i = 0; i < graph[src].size(); i++){
			if(!isVisited[graph[src].get(i).dest]){
				dfs(graph[src].get(i).dest, graph, v, list, isVisited);
			}
		}
	}
	
	public static void isGraphConnected(List<Edge>[] graph, int v) {
		boolean result =  getConnectedComponents(graph, v).size() > 1 ? false : true;
		System.out.println("Is Graph Connected :=> "+result);
	}
	
	public static void getNoOfIceLands(int[][] iceland) {
		// TODO Auto-generated method stub
		int count = 0;
		boolean[][] isVisited =  new boolean[iceland.length][iceland[0].length];
		for(int i = 0; i < iceland.length; i++){
			for(int j = 0; j < iceland[0].length; j++){
				if(!isVisited[i][j] && iceland[i][j] == 0){
					dfsIceLands(i, j, iceland,isVisited);
					count++;
				}
			}
		}
		System.out.println("No of Icelands :=> "+count);
	}
	private static void dfsIceLands(int i, int j, int[][] iceland, boolean[][] isVisited) {
		// TODO Auto-generated method stub
		if(i < 0 || j < 0 || i >= iceland.length || j >= iceland[0].length || isVisited[i][j] || iceland[i][j] == 1){
			return;
		}
		isVisited[i][j] = true;
		dfsIceLands(i+1, j, iceland, isVisited);
		dfsIceLands(i-1, j, iceland, isVisited);
		dfsIceLands(i, j+1, iceland, isVisited);
		dfsIceLands(i, j-1, iceland, isVisited);
	}
	
	public static void getNoOfPerfectFriendsPair(int v, int e, int[][] pair) {
		// TODO Auto-generated method stub
		int pairCount = 0;
		GraphAdjEdge graphFriends = new GraphAdjEdge(v);
		for(int[] p : pair){
			graphFriends.addEdgeUndirected(p[0], p[1], 0);
		}
		List<List<Integer>> lists = getConnectedComponents(graphFriends.graph, graphFriends.v);
		for(int i = 0; i < lists.size(); i++){
			for(int j = i+1; j < lists.size(); j++){
				pairCount += lists.get(i).size()*lists.get(j).size();
			}
		}
		System.out.println("Total no of Friends' Pair :=> "+pairCount);
	}
	
	public static void printHamiltonianPathCycle(List<Edge>[] graph, int v, int src){
		System.out.println("Print All Hamiltonian path and Cycle from Source("+src+") => ");
		String path = src + "->";
		HashSet<Integer> set = new HashSet<>();
		getHamiltonianPathCycleRec(graph, v, src, src, set, path);
	}
	private static void getHamiltonianPathCycleRec(List<Edge>[] graph, int v, int src, int origSrc, HashSet<Integer> set, String path) {
		// TODO Auto-generated method stub
		if(set.size() == v-1){
			boolean isCycle = false;
			for(int i = 0; i < graph[origSrc].size(); i++){
				if(graph[origSrc].get(i).dest == src){
					isCycle = true;
				}
			}
			if(isCycle){
				path = path + " @Cycle";
			}else{
				path = path + " @Path";
			}
			System.out.println(path);
		}
		set.add(src);
		for(int i = 0; i < graph[src].size(); i++){
			if(!set.contains(graph[src].get(i).dest)){
				getHamiltonianPathCycleRec(graph, v, graph[src].get(i).dest, origSrc, set, path + graph[src].get(i).dest+"->");
			}
		}
		set.remove(src);
	}
	
	public static void knightTour(int[][] arr, int row, int col){
		System.out.println("Knight Tour from starting point["+row+"]["+col+"] :=> ");
		String path = ""; 
		int item = 1;
		knightTourRec(arr, row, col, path, item);	
	}
	private static void knightTourRec(int[][] arr, int r, int c, String path, int item) {
		// TODO Auto-generated method stub
		if(r < 0 || c < 0 || r >= arr.length || c >= arr[0].length || arr[r][c] != 0){
			return;
		}else if(item == arr.length*arr[0].length){
			arr[r][c] = item;
			displayArray(arr);
			arr[r][c] = 0;
			return;
		}
		arr[r][c] = item;
		knightTourRec(arr, r+2, c-1, path+arr[r][c]+"->", item+1);
		knightTourRec(arr, r+2, c+1, path+arr[r][c]+"->", item+1);
		knightTourRec(arr, r-2, c-1, path+arr[r][c]+"->", item+1);
		knightTourRec(arr, r-2, c+1, path+arr[r][c]+"->", item+1);
		knightTourRec(arr, r-2, c-1, path+arr[r][c]+"->", item+1);
		knightTourRec(arr, r+1, c-2, path+arr[r][c]+"->", item+1);
		knightTourRec(arr, r+1, c+2, path+arr[r][c]+"->", item+1);
		knightTourRec(arr, r-1, c-2, path+arr[r][c]+"->", item+1);
		knightTourRec(arr, r-1, c+2, path+arr[r][c]+"->", item+1);
		arr[r][c] = 0;
	}
	private static void displayArray(int[][] arr) {
		System.out.println("Printing Knight Array[][] :");
		 for (int i = 0; i < arr.length; i++){
	            for (int j = 0; j < arr[i].length; j++){
	            	System.out.print(arr[i][j] + " ");
	            }
	            System.out.println();
		 }	                
	}
	
	public static void bfs(List<Edge>[] graph, int v, int src){
		System.out.println("BFS Traversal Path of Graph from Source("+src+") := >");
		LinkedList<BFSPair> queue = new LinkedList<BFSPair>();
		String path = "";
		queue.add(new BFSPair(src, path+src+"->"));
		boolean[] isVisisted = new boolean[v];
		while(queue.size() > 0){
			BFSPair poped = queue.poll();
			if(isVisisted[poped.node]){
				continue;
			}
			isVisisted[poped.node] = true;
			System.out.println(poped.node+" @Path >"+poped.path);
			for(int i = 0; i < graph[poped.node].size(); i++){
				if(!isVisisted[graph[poped.node].get(i).dest]){
					queue.add(new BFSPair(graph[poped.node].get(i).dest, poped.path+graph[poped.node].get(i).dest+"->"));
				}
			}
		}
		System.out.println(path);
	}
	
	public static void isCyclicGraph(List<Edge>[] graph, int v, int src){
		System.out.println("Find if the Graph is cyclic := "+isCyclicGraphUtil(graph,v,src));
	}
	
	private static boolean isCyclicGraphUtil(List<Edge>[] graph, int v, int src) {
		LinkedList<BFSPair> queue = new LinkedList<BFSPair>();
		String path = "";
		queue.add(new BFSPair(src, path));
		boolean[] isVisisted = new boolean[v];
		while(queue.size() > 0){
			BFSPair poped = queue.poll();
			if(isVisisted[poped.node]){
				return true;
			}
			isVisisted[poped.node] = true;
			for(int i = 0; i < graph[poped.node].size(); i++){
				if(!isVisisted[graph[poped.node].get(i).dest]){
					queue.add(new BFSPair(graph[poped.node].get(i).dest, path));
				}
			}
		}
		return false;
	}
	
	public static void dikstra(List<Edge>[] graph, int v, int src){
		System.out.println("Dikstra Algorithm Single Source Shortest Path :=> ");
		PriorityQueue<Dikstra> queue = new PriorityQueue<Dikstra>(new Comparator<Dikstra>() {
			@Override
			public int compare(Dikstra o1, Dikstra o2) {
				// TODO Auto-generated method stub
				return Integer.valueOf(o1.weight).compareTo(Integer.valueOf(o2.weight));
			}
		});
		queue.add(new Dikstra(src, src+"->", 0));
		boolean[] isVisisted = new boolean[v];
		while(queue.size() > 0){
			Dikstra popped = queue.poll();
			if(isVisisted[popped.node]){
				continue;
			}
			isVisisted[popped.node] = true;
			System.out.println("Source("+src+") to Destination("+popped.node+") via Path@ "+ popped.path+ " with Cost@ "+popped.weight);
			for(int i = 0; i < graph[popped.node].size(); i++){
				if(!isVisisted[graph[popped.node].get(i).dest]){
					queue.add(new Dikstra(graph[popped.node].get(i).dest, popped.path+graph[popped.node].get(i).dest+"->",popped.weight+graph[popped.node].get(i).edge));
				}
			}
		}
	}
	public static void primsAlgorithm(List<Edge>[] graph, int v, int src){
		System.out.println("Prims Algorithm To find Minimum Spanning Tree :=> ");
		PriorityQueue<SpanningTree> queue = new PriorityQueue<SpanningTree>(new Comparator<SpanningTree>() {
			@Override
			public int compare(SpanningTree o1, SpanningTree o2) {
				// TODO Auto-generated method stub
				return Integer.valueOf(o1.edge).compareTo(Integer.valueOf(o2.edge));
			}
			
		});
		PriorityQueue<SpanningTree> mst = new PriorityQueue<SpanningTree>(new Comparator<SpanningTree>() {
			@Override
			public int compare(SpanningTree o1, SpanningTree o2) {
				// TODO Auto-generated method stub
				return Integer.valueOf(o1.edge).compareTo(Integer.valueOf(o2.edge));
			}
		});
		for(int i = 0; i < graph.length; i++){
			for(int j = 0; j < graph[i].size(); j++){
				if(graph[i].get(j).dest > graph[i].get(j).source){
					queue.add(new SpanningTree(graph[i].get(j).source, graph[i].get(j).dest, graph[i].get(j).edge));
				}			
			}
		}
		mst.add(queue.poll());
		boolean[] isVisited = new boolean[v];
		while(mst.size() > 0){
			SpanningTree popped= mst.poll();
			if(isVisited[popped.source]){
				
			}
		}
	}
	
	public static void topologicalSort(List<Edge>[] graph, int v){
		System.out.println("Topological Sort of the Graph :=> ");
		boolean[] isVisited = new boolean[v];
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < v; i++){
			if(!isVisited[i]){
				dfsTopological(graph,i,stack,isVisited);
			}
		}
		while(stack.size() > 0){
			System.out.print(stack.pop()+"->");
		}
		System.out.println();
	}
	private static void dfsTopological(List<Edge>[] graph, int src, Stack<Integer> stack, boolean[] isVisited) {
		// TODO Auto-generated method stub
		isVisited[src] = true;
		for(int i = 0; i < graph[src].size(); i++){
			if(!isVisited[graph[src].get(i).dest]){
				dfsTopological(graph, graph[src].get(i).dest, stack, isVisited);
			}		
		}
		stack.add(src);
	}
	
	public static void isBipartieGraph(List<Edge>[] graph, int v){
		System.out.println("Is this Graph Bipartiite ? :=> ");
		boolean isBipartitePossible = true;
		int[] isVisited = new int[v];
		Arrays.fill(isVisited, -1);
		for(int i = 0; i < v; i++){
			if(isVisited[i] != -1){
				if(!checkIfBiPartitie(graph,i,isVisited)){
					isBipartitePossible = false;
					break;
				}
			}
		}
		System.out.print(isBipartitePossible);
		System.out.println();
	}
	private static boolean checkIfBiPartitie(List<Edge>[] graph, int src, int[] isVisited) {
		// TODO Auto-generated method stub
		LinkedList<BiPartite> queue =  new LinkedList<>();
		queue.add(new BiPartite(src, src+"->", 0));
		while(queue.size() > 0){
			BiPartite popped = queue.poll();
			if(isVisited[popped.v] != -1){
				if(isVisited[popped.v] != popped.level){
					return false;
				}
			}else{
				isVisited[popped.v] = popped.level;
			}
			for(int i = 0; i < graph[popped.v].size(); i++){
				if(isVisited[graph[popped.v].get(i).dest] != -1){
					queue.add(new BiPartite(graph[src].get(i).dest, popped.psf+graph[popped.v].get(i).dest+"->", popped.level+1));
				}
			}
		}
		return false;
	}
	
	public static void countOfSpreadInfection(List<Edge>[] graph, int v, int t, int src){
		System.out.println("Total count of Infected Nodes :=> ");
		boolean[] isVisited = new boolean[v];
		LinkedList<SpreadInfection> list = new LinkedList<>();
		list.add(new SpreadInfection(src, 1));
		int count = countOfSpreadInfectionRec(graph, v, t, src, list, isVisited);
		System.out.print(count);
		System.out.println();
	}
	private static int countOfSpreadInfectionRec(List<Edge>[] graph, int v, int t, int src, LinkedList<SpreadInfection> list, boolean[] isVisited) {
		// TODO Auto-generated method stub
		int count = 0;
		while(list.size() > 0){
			SpreadInfection popped = list.poll();
			if(isVisited[popped.v]){
				continue;
			}
			isVisited[popped.v] = true;
			if(popped.t > t){
				break;
			}
			count++;
			for(int i = 0; i < graph[popped.v].size(); i++){
				if(!isVisited[graph[popped.v].get(i).dest]){
					list.add(new SpreadInfection(graph[popped.v].get(i).dest, popped.t+1));
				}
			}	
		}
		return count;
	}
	
	public static void getNoOfDistinctIceLands(int[][] iceland) {
		// TODO Auto-generated method stub
		int count = 0;
		boolean[][] isVisited =  new boolean[iceland.length][iceland[0].length];
		Set<String> icelandSets = new HashSet<>();
		for(int i = 0; i < iceland.length; i++){
			for(int j = 0; j < iceland[0].length; j++){
				if(!isVisited[i][j] && iceland[i][j] == 1){
					StringBuilder islandStruct = new StringBuilder("");
					dfsDistinctIceLands(i, j, iceland, isVisited, 0, islandStruct);
					icelandSets.add(islandStruct.toString());
					count++;
				}
			}
		}
		System.out.println("No of Total Icelands :=> "+count);
		System.out.println("No of Distinct Icelands :=> "+icelandSets.size());
		
	}
	private static void dfsDistinctIceLands(int i, int j, int[][] iceland, boolean[][] isVisited, int k, StringBuilder islandStruct ) {
		// TODO Auto-generated method stub
		if(i < 0 || j < 0 || i >= iceland.length || j >= iceland[0].length || isVisited[i][j] || iceland[i][j] == 0){
			return;
		}
		if(k == 0){
			islandStruct.append("iceland");
		}else{
			islandStruct.append(k).append("iceland");
		}
		isVisited[i][j] = true;
		dfsDistinctIceLands(i+1, j, iceland, isVisited, 1, islandStruct);
		dfsDistinctIceLands(i-1, j, iceland, isVisited, 2, islandStruct);
		dfsDistinctIceLands(i, j+1, iceland, isVisited, 3, islandStruct);
		dfsDistinctIceLands(i, j-1, iceland, isVisited, 4, islandStruct);
	}
	
	public static void getNoOfEnclaves(int[][] enclave) {
		// TODO Auto-generated method stub
		int count = 0;
		boolean[][] isVisited =  new boolean[enclave.length][enclave[0].length];
		for(int i = 0; i < enclave.length; i++){
			for(int j = 0; j < enclave[0].length; j++){
				if(!isVisited[i][j] && enclave[i][j] == 1){
					AtomicBoolean isEnClave = new AtomicBoolean(true);
					AtomicInteger countEnclaves = new AtomicInteger(0);
					dfsEnclaves(i, j, enclave, isVisited, isEnClave, countEnclaves);
					if(isEnClave.get()){
						count+= countEnclaves.get();
					}			
				}
			}
		}
		System.out.println("No of Total Enclaves :=> "+count);
	}
	private static void dfsEnclaves(int i, int j, int[][] enclave, boolean[][] isVisited, AtomicBoolean isEnClave, AtomicInteger countEnclaves) {
		// TODO Auto-generated method stub
		if(i < 0 || j < 0 || i >= enclave.length || j >= enclave[0].length || isVisited[i][j] || enclave[i][j] == 0){
			return;
		}
		isVisited[i][j] = true;
		countEnclaves.getAndIncrement();
		if(i == 0 || i == enclave.length-1 || j == 0 || j ==enclave[0].length-1){
			isEnClave.set(false);;
		}
		dfsEnclaves(i+1, j, enclave, isVisited, isEnClave, countEnclaves);
		dfsEnclaves(i-1, j, enclave, isVisited, isEnClave, countEnclaves);
		dfsEnclaves(i, j+1, enclave, isVisited, isEnClave, countEnclaves);
		dfsEnclaves(i, j-1, enclave, isVisited, isEnClave, countEnclaves);
	}
	
	public static void getTimeToRottonOrrange(int[][] enclave) {
		LinkedList<Rotton> queue = new LinkedList<>();
		boolean[][] isVisited = new boolean[enclave.length][enclave[0].length];
		int countFresh = 0;
		for(int i = 0; i < enclave.length; i++ ){
			for(int j = 0; j < enclave[0].length; j++){
				if(enclave[i][j] == 2){
					queue.add(new Rotton(i, j, 0));
				}else if(enclave[i][j] == 1){
					countFresh += 1;
				}
			}
		}
		int rootonCount = 0;
		int t = 0;
		while(queue.size() > 0){
			Rotton popped = queue.poll();
			t = popped.t;
			if(isVisited[popped.i][popped.j]){
				continue;
			}
			isVisited[popped.i][popped.j] = true;
			if(popped.i+1 < enclave.length && popped.i+1 >= 0 && enclave[popped.i+1][popped.j] == 1){
				enclave[popped.i+1][popped.j] = 2;
				queue.add(new Rotton(popped.i+1, popped.j, popped.t+1));
				rootonCount++;
			}
			if(popped.i-1 < enclave.length && popped.i-1 >= 0 && enclave[popped.i-1][popped.j] == 1){
				enclave[popped.i-1][popped.j] = 2;
				queue.add(new Rotton(popped.i-1, popped.j, popped.t+1));
				rootonCount++;
			}
			if(popped.j+1 < enclave[0].length && popped.j+1 >= 0 && enclave[popped.i][popped.j+1] == 1){
				enclave[popped.i][popped.j+1] = 2;
				queue.add(new Rotton(popped.i, popped.j+1, popped.t+1));
				rootonCount++;
			}
			if(popped.j-1 < enclave[0].length && popped.j-1 >= 0 && enclave[popped.i][popped.j-1] == 1){
				enclave[popped.i][popped.j-1] = 2;
				queue.add(new Rotton(popped.i, popped.j-1, popped.t+1));
				rootonCount++;
			}
			
		}
		if(countFresh != rootonCount){
			System.out.println("Not Possible to rot all the Frsh Oranges");
		}else{
			System.out.println("Time taken to rot all the Frsh Oranges :=> "+t);
		}
	}
	
	public static void floydWarshall(List<Edge>[] graph, int v) {
		System.out.println("Shortest Path Beteen All Pairs :=> ");
		int[][] graphShortest = new int[v][v];
		for(int i = 0; i < graph.length; i++){
			for(int j = 0; j < graph[i].size(); j++){
					graphShortest[graph[i].get(j).source][graph[i].get(j).dest] = graph[i].get(j).edge;
			}			
		}
		for(int i = 0; i < v; i++){
			for(int j = 0; j < v; j++){
				if(i != j && graphShortest[i][j] == 0){
					graphShortest[i][j] = INF;
				}
			}
		}
		for(int k = 0; k< v; k++){
			for(int i=0; i < v; i++){
				for(int j = 0; j < v; j++){
					graphShortest[i][j] = Math.min(graphShortest[i][j],graphShortest[i][k]+graphShortest[k][j]);		
				}
			}
		}
		printfloydWarshallShortestDistance(graphShortest, v);
		System.out.println();
	}
	private static void printfloydWarshallShortestDistance(int[][] graph, int V) {
		// TODO Auto-generated method stub
		for(int i = 0; i< V; i++){
			for(int j =0; j< V;j++){
				if(i != j){
					if(graph[i][j] == INF){
						graph[i][j] = -1;
					}
					System.out.print("Distance from "+i+" to " +j+" : "+graph[i][j]+" ; ");	
				}
			}
			System.out.println();
		}	
	}
	
	public static void getShortestBridge(int[][] iceland) {
		// TODO Auto-generated method stub
		int ShortestBridge = 0;
		boolean[][] isVisited =  new boolean[iceland.length][iceland[0].length];
		int srcI = 0;int srcj = 0;
		LinkedList<ShortestBridge> list = new LinkedList<>();
		for(int i = 0; i < iceland.length; i++){
			if(list.size() == 1){
				break;
			}
			for(int j = 0; j < iceland[0].length; j++){
				if(iceland[i][j] == 1){
					srcI =i; srcj = j;
					break;
				}
			}
		}
		getFirstIceLand(srcI, srcj, iceland, list, isVisited);
		while(list.size() > 0){
			ShortestBridge popped = list.poll();
			if(iceland[popped.i][popped.j] == 1 && popped.l > 0){
				ShortestBridge = popped.l-1;
				break;
			}
			System.out.println("i ="+popped.i+" && j ="+popped.j + " && l = "+popped.l);
			getConnecteLandOrWater(popped.i+1, popped.j, iceland, list, isVisited, popped.l);
			getConnecteLandOrWater(popped.i-1, popped.j, iceland, list, isVisited, popped.l);
			getConnecteLandOrWater(popped.i, popped.j+1, iceland, list, isVisited, popped.l);
			getConnecteLandOrWater(popped.i, popped.j-1, iceland, list, isVisited, popped.l);
		}
		System.out.println("The length of Shortest Bridge:=> "+(ShortestBridge));
	}
	private static void getConnecteLandOrWater(int i, int j, int[][] iceland, LinkedList<ShortestBridge> list, boolean[][] isVisited, int l) {
		// TODO Auto-generated method stub
		if(i < 0 || j < 0 || i >= iceland.length || j >= iceland[0].length || isVisited[i][j]){
			return;
		}
		isVisited[i][j] = true;
		list.add(new ShortestBridge(i, j, l+1));
	}
	private static void getFirstIceLand(int i, int j, int[][] iceland, LinkedList<ShortestBridge> list, boolean[][] isVisited) {
		// TODO Auto-generated method stub
		if(i < 0 || j < 0 || i >= iceland.length || j >= iceland[0].length || isVisited[i][j] || iceland[i][j] == 0){
			return;
		}
		isVisited[i][j] = true;
		list.add(new ShortestBridge(i, j, 0));
		getFirstIceLand(i+1, j, iceland, list, isVisited);
		getFirstIceLand(i-1, j, iceland, list, isVisited);
		getFirstIceLand(i, j+1, iceland, list, isVisited);
		getFirstIceLand(i, j-1, iceland, list, isVisited);
	}
	
	public static void getMinMovesSlidingPuzzle(int[][] puzzle) {
		// TODO Auto-generated method stub
		AtomicInteger minNoOfMoves = new AtomicInteger(Integer.MAX_VALUE);
		Set<String> isVisited = new HashSet<>();
		int zeroi =0; int zeroj = 0;
		for(int i = 0; i < puzzle.length; i++){
			for(int j = 0; j < puzzle[0].length; j++){
				if(puzzle[i][j] == 0){
					zeroi = i; zeroj = j;
				}
			}
		}
		moveSlidingPuzzleRec(zeroi, zeroj, -1, -1, isVisited, puzzle, 0, minNoOfMoves);
		System.out.println("Minimum No. of moves for sliding puzzle:=> "+minNoOfMoves);
	}
	
	private static void moveSlidingPuzzleRec(int i, int j, int oldi, int oldj, Set<String> isVisited, int[][] puzzle, int move,AtomicInteger minNoOfMoves) {
		if(i < 0 || j < 0 || i >= puzzle.length || j >= puzzle[0].length || isVisited.contains(String.valueOf(i)+String.valueOf(j))){
			return;
		}
		if(isVisited.contains(String.valueOf(i)+String.valueOf(j)) || isVisited.size() == 6){
			return;
		}
		isVisited.add(String.valueOf(i)+String.valueOf(j));
		if(oldi != -1 || oldj != -1){
			puzzle[oldi][oldj] = puzzle[i][j];
			puzzle[i][j] = 0;			
		}
		if((i == 1 && j == 0 && oldi == 1 && oldj ==1) || (i == 0 && j == 0 && oldi == 1 && oldj ==0) || (i == 0 && j == 1 && oldi == 0 && oldj ==0) 
				|| (i == 0 && j == 2 && oldi == 0 && oldj ==1) || (i == 1 && j == 2 && oldi == 0 && oldj ==2)){
			displayArray(puzzle);
			
		}
		int countr= 1;
		boolean isDone = true;
		for(int m =0; m < puzzle.length; m++){
			if(!isDone){
				break;
			}
			for(int n =0; n < puzzle[0].length; n++){
				if(m == 1  && n == 2){
					if(!(puzzle[m][n] == 0)){
						isDone = false;
						break;
					}
				}else if(!(puzzle[m][n] == countr)){
					isDone = false;
					break;
				}
				countr++;
			}
		}
		if(isDone){
			if(minNoOfMoves.get() > move){
				minNoOfMoves.set(move);
			}
		}
		moveSlidingPuzzleRec(i+1, j, i, j, isVisited, puzzle, move+1, minNoOfMoves);
		moveSlidingPuzzleRec(i-1, j, i, j, isVisited, puzzle, move+1, minNoOfMoves);
		moveSlidingPuzzleRec(i, j+1, i, j, isVisited, puzzle, move+1, minNoOfMoves);
		moveSlidingPuzzleRec(i, j-1, i, j, isVisited, puzzle, move+1, minNoOfMoves);
		isVisited.remove(String.valueOf(i)+String.valueOf(j));
		if(oldi != -1 || oldj != -1){
			puzzle[i][j] = puzzle[oldi][oldj];
			puzzle[oldi][oldj] = 0;	
		}	
	}
	
	public static void minimumNoOfSwapToSortArray(int[] arr) {
		// TODO Auto-generated method stub
		// int[] arr = {6,4,2,14,8,10,12,16};	
		SortPair[] pair = new SortPair[arr.length];
		for(int i = 0; i < arr.length; i++){
			pair[i] = new SortPair(arr[i], i);
		}
		Arrays.sort(pair);
		boolean[] isVisited = new boolean[arr.length];
		int swaps = 0;
		for(int i = 0; i < pair.length; i++){
			if(isVisited[i] || pair[i].idx == i){
				continue;
			}
			int cicle = 0;
			int j = i;
			while(!isVisited[j]){
				isVisited[j] = true;
				cicle += 1;
				j = pair[j].idx;
			}
			swaps += cicle-1;
		}
		System.out.println("Minimum No. of Swaps required to sort an Array:=> "+swaps);
	}
	
	public static void getMinReversalEdges(List<Edge>[] graph, int v, int src, int dest) {
		// TODO Auto-generated method stub
		for(int i = 0; i < graph.length; i++){
			for(int j = 0; j < graph[i].size(); j++){
				int src1 = graph[i].get(j).source;
				int dest1 = graph[i].get(j).dest;
				graph[dest1].add(new Edge(dest1, src1, 1));
			}
		}
		System.out.println("Minimum Cost of Reversal Edges in the Graph :=> "+bfs01(graph, v, src, dest));
	}
	
	private static int bfs01(List<Edge>[] graph, int v, int src, int dest){		
		LinkedList<Dikstra> queue = new LinkedList<Dikstra>();
		String path = "";
		queue.addLast(new Dikstra(src, path+src+"->", 0));
		boolean[] isVisisted = new boolean[v];
		while(queue.size() > 0){
			Dikstra poped = queue.removeFirst();
			if(poped.node == dest){
				return poped.weight;
			}
			if(isVisisted[poped.node]){
				continue;
			}
			isVisisted[poped.node] = true;
			for(int i = 0; i < graph[poped.node].size(); i++){
				if(!isVisisted[graph[poped.node].get(i).dest]){
					int newWeight = graph[poped.node].get(i).edge+poped.weight;
					if(graph[poped.node].get(i).edge == 0){
						queue.addFirst(new Dikstra(graph[poped.node].get(i).dest, poped.path+graph[poped.node].get(i).dest+"->", newWeight));
					}else{
						queue.addLast(new Dikstra(graph[poped.node].get(i).dest, poped.path+graph[poped.node].get(i).dest+"->", newWeight));
					}
					
				}
			}
		}
		return 0;
	}
}

class SortPair implements Comparable<SortPair>{
	int n;
	int idx;
	public SortPair(int n, int idx) {
		super();
		this.n = n;
		this.idx = idx;
	}
	@Override
	public int compareTo(SortPair o) {
		// TODO Auto-generated method stub
		return Integer.valueOf(this.n).compareTo(Integer.valueOf(o.n));
	}
}

class SlidingPuzzle{
	int i;
	int j;
	int l;
	public SlidingPuzzle(int i, int j, int l) {
		super();
		this.i = i;
		this.j = j;
		this.l = l;
	}
}

class ShortestBridge{
	int i;
	int j;
	int l;
	public ShortestBridge(int i, int j, int l) {
		super();
		this.i = i;
		this.j = j;
		this.l = l;
	}
}

class Rotton{
	int i; 
	int j;
	int t;
	public Rotton(int i, int j, int t) {
		super();
		this.i = i;
		this.j = j;
		this.t = t;
	}
}
class SpreadInfection{
	int v;
	int t;
	public SpreadInfection(int v, int t) {
		super();
		this.v = v;
		this.t = t;
	}
}

class BiPartite{
	int v; 
	String psf;
	int level;
	public BiPartite(int v, String psf, int level) {
		super();
		this.v = v;
		this.psf = psf;
		this.level = level;
	}
	
}

class SpanningTree{
	int source;
	int dest;
	int edge;
	public SpanningTree(int source, int dest, int edge) {
		super();
		this.source = source;
		this.dest = dest;
		this.edge = edge;
	}
}
class Dikstra{
	int node;
	String path;
	int weight;
	public Dikstra(int node, String path, int weight) {
		super();
		this.node = node;
		this.path = path;
		this.weight = weight;
	}
}
class BFSPair{
	int node;
	String path;
	public BFSPair(int node, String path) {
		super();
		this.node = node;
		this.path = path;
	}
}
class Pair{
	String path;
	int cost;
	public Pair(String path, int cost) {
		super();
		this.path = path;
		this.cost = cost;
	}
}

class Edge{
	Integer source;
	Integer dest;
	Integer edge;
	public Edge(Integer source,Integer dest,Integer edge) {
		super();
		this.source = source;
		this.dest = dest;
		this.edge = edge;
	}
	public Edge(){
	}
}
