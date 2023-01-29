/**
 * 
 */
package com.debajoy.ds.graph1;

import java.util.ArrayDeque;
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
import java.util.stream.Collectors;

/**
 * @author Debajoy
 *
 */
public class GraphEdgeNew {

	private List<EdgeN>[] graph;
	private int v;
	
	public GraphEdgeNew(int v) {
		super();
		this.v = v;
		this.graph = new LinkedList[v];
		for(int i = 0; i < v; i++){
			graph[i] = new LinkedList<EdgeN>();
		}
	}
	
	public void addEdgeDirected(int u, int v, int w){
		graph[u].add(new EdgeN(u,v,w));
	}	
	public void addEdgeUndirected(int u, int v, int w){
		graph[u].add(new EdgeN(u,v,w));
		graph[v].add(new EdgeN(v,u,w));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String SEPERATOR ="**************************************************************************************";	
		GraphEdgeNew graphEdgeNew = createGraph1();
		System.out.println(SEPERATOR);
		int source = 0; int destination  = 6;
		System.out.println("Has a Path from Source("+source+") to ("+destination+")"
				+ " => "+hasAPath(graphEdgeNew.graph,graphEdgeNew.v,source,destination));
		System.out.println(SEPERATOR);
		printAllPaths(graphEdgeNew.graph,graphEdgeNew.v,source,destination);
		System.out.println(SEPERATOR);
		GraphEdgeNew graphEdgeNew2 = createGraph2();
		int number = 40;
		getSmallestLargestFloorCeil(graphEdgeNew2.graph,graphEdgeNew2.v,source,destination, number);
		System.out.println(SEPERATOR);
		GraphEdgeNew graphEdgeNew3 = createGraph3();
		getConnectedComponents(graphEdgeNew3.graph,graphEdgeNew3.v);
		isGraphConnected(graphEdgeNew3.graph,graphEdgeNew3.v);
		System.out.println(SEPERATOR);
		getConnectedComponents(graphEdgeNew2.graph,graphEdgeNew2.v);
		isGraphConnected(graphEdgeNew2.graph,graphEdgeNew2.v);
		System.out.println(SEPERATOR);
		int[][] iceland = { {0,0,1,1,1,0,0,0},
							{0,0,1,1,1,1,1,1},
							{1,1,1,1,1,1,1,0},
							{1,1,0,0,0,0,0,0},
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
		GraphEdgeNew graphEdgeNew4 = createGraph4();
		printHamiltonianPathCycle(graphEdgeNew4.graph,graphEdgeNew4.v,source);
		System.out.println(SEPERATOR);
		int[][] arr = new int[5][5];
		int rStrt = 2; int colStart = 4;
		knightTour(arr, rStrt, colStart);
		System.out.println(SEPERATOR);	
		bfs(graphEdgeNew4.graph,graphEdgeNew4.v,source);
		System.out.println(SEPERATOR);	
		dfsIterative(graphEdgeNew.graph,graphEdgeNew.v,source);
		System.out.println(SEPERATOR);	
		isCyclicGraph(graphEdgeNew4.graph,graphEdgeNew4.v,source);
		GraphEdgeNew graphEdgeNew5 = createGraph5();
		isCyclicGraph(graphEdgeNew5.graph,graphEdgeNew5.v,source);
		System.out.println(SEPERATOR);
		GraphEdgeNew graphEdgeNew6 = createGraph6();
		isBipartieGraph(graphEdgeNew4.graph,graphEdgeNew4.v);
		isBipartieGraph(graphEdgeNew6.graph,graphEdgeNew6.v);
		System.out.println(SEPERATOR);	
		int t = 3;
		int src = 0;
		countOfSpreadInfection(graphEdgeNew4.graph,graphEdgeNew4.v, t, src);
		System.out.println(SEPERATOR);	
		GraphEdgeNew graphEdgeNew7 = createGraph7();
		dikstra(graphEdgeNew7.graph,graphEdgeNew7.v,source);
		System.out.println(SEPERATOR);	
		GraphEdgeNew graphEdgeNew8 = createGraph8();
		topologicalSort(graphEdgeNew8.graph,graphEdgeNew8.v);
		System.out.println(SEPERATOR);
		GraphEdgeNew graphEdgeNew9 = createGraph9();
		findMinimumSpanningTree(graphEdgeNew9.graph,graphEdgeNew9.v);
		System.out.println(SEPERATOR);
		int[][] enclaves = {{0,0,1,1,0},
	 			 			{0,1,1,0,0},
	 			 			{0,1,0,0,1},
	 			 			{0,0,1,1,0},
	 			 			{0,1,1,0,0},
	 			 			{0,0,0,0,0}};
		getNoOfEnclaves(enclaves);
		System.out.println(SEPERATOR);
		int[][] icelands = { {1,1,0,0,0},
							 {1,1,0,0,0},
							 {0,0,0,1,1},
							 {0,0,0,1,1},
							 {1,1,0,0,0},
							 {1,1,0,0,0}};
		getNoOfDistinctIceLands(icelands);
		System.out.println(SEPERATOR);
		int[][] rotton = {  {2,0,1,0,0},
				  			{1,1,1,0,0},
				  			{0,0,0,0,0},
				  			{0,0,1,1,1},
				  			{0,1,1,2,0}};
		int[][] rotton1 = { {2,1,1},
							{0,1,1},
							{0,0,1}};
		getTimeToRottonOrrange(rotton1);
		System.out.println(SEPERATOR);	
		int[][] zeroOne = { {0,0,0},
							{0,1,0},
							{1,1,1} };
		nearestDistanceZeroOne(zeroOne);	
		System.out.println(SEPERATOR);	
		int[][] icelandFar = {  {1,0,1,0,1},
				  				{1,0,1,0,1},
				  				{1,0,0,0,1},
				  				{1,0,0,0,1},
				  				{1,0,0,0,1},
				  				{1,0,0,0,1}};
		getAsFarFromLandPossible(icelandFar);
		System.out.println(SEPERATOR);
	}

	private static void getAsFarFromLandPossible(int[][] arr) {
		System.out.print("Farthest distance from the 0 to the nearest 1 :=> ");
		int fartestDistance = 0;
		ArrayDeque<Farthest> queue = new ArrayDeque<>();
		for(int i  = 0; i < arr.length; i++){
			for(int j = 0; j < arr[0].length; j++){
				if(arr[i][j] == 1){
					queue.add(new Farthest(i, j, 0));
				}
			}
		}
		boolean[][] isVisisted = new boolean[arr.length][arr[0].length];
		while(queue.size() > 0){
			Farthest rem = queue.remove();
			if(isVisisted[rem.i][rem.j]){
				continue;
			}
			isVisisted[rem.i][rem.j] = true;
			fartestDistance = Math.max(fartestDistance, rem.level);
			int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
			for(int i = 0; i < dir.length; i++){
				int row = rem.i+dir[i][0];
				int col = rem.j+dir[i][1];
				if(row >= 0 && col >= 0 && row < arr.length && col < arr[0].length && arr[row][col] == 0 && !isVisisted[row][col]){
					queue.add(new Farthest(row, col, rem.level+1));
				}
			}		
		}
		System.out.print(fartestDistance);
		System.out.println();
	}

	private static GraphEdgeNew createGraph1() {
		int v = 7;
		GraphEdgeNew graphEdgeNew = new GraphEdgeNew(v);
		graphEdgeNew.addEdgeUndirected(0, 1, 10);
		graphEdgeNew.addEdgeUndirected(0, 3, 10);
		graphEdgeNew.addEdgeUndirected(1, 2, 10);
		graphEdgeNew.addEdgeUndirected(2, 3, 10);
		graphEdgeNew.addEdgeUndirected(3, 4, 10);
		graphEdgeNew.addEdgeUndirected(4, 5, 10);
		graphEdgeNew.addEdgeUndirected(5, 6, 10);
		graphEdgeNew.addEdgeUndirected(4, 6, 10);
		return graphEdgeNew;
	}
	private static GraphEdgeNew createGraph2() {
		int v = 7;
		GraphEdgeNew graphEdgeNew = new GraphEdgeNew(v);
		graphEdgeNew.addEdgeUndirected(0, 1, 10);
		graphEdgeNew.addEdgeUndirected(0, 3, 40);
		graphEdgeNew.addEdgeUndirected(1, 2, 10);
		graphEdgeNew.addEdgeUndirected(2, 3, 10);
		graphEdgeNew.addEdgeUndirected(3, 4, 2);
		graphEdgeNew.addEdgeUndirected(4, 5, 3);
		graphEdgeNew.addEdgeUndirected(5, 6, 3);
		graphEdgeNew.addEdgeUndirected(4, 6, 8);
		return graphEdgeNew;
	}
	private static GraphEdgeNew createGraph3() {
		int v = 7;
		GraphEdgeNew graphEdgeNew = new GraphEdgeNew(v);
		graphEdgeNew.addEdgeUndirected(0, 1, 10);
		graphEdgeNew.addEdgeUndirected(2, 3, 40);
		graphEdgeNew.addEdgeUndirected(4, 5, 10);
		graphEdgeNew.addEdgeUndirected(4, 6, 10);
		return graphEdgeNew;
	}
	private static GraphEdgeNew createGraph4() {
		int v = 7;
		GraphEdgeNew graphEdgeNew = new GraphEdgeNew(v);
		graphEdgeNew.addEdgeUndirected(0, 1, 10);
		graphEdgeNew.addEdgeUndirected(0, 3, 10);
		graphEdgeNew.addEdgeUndirected(1, 2, 12);
		graphEdgeNew.addEdgeUndirected(2, 3, 13);
		graphEdgeNew.addEdgeUndirected(2, 5, 3);
		graphEdgeNew.addEdgeUndirected(3, 4, 5);
		graphEdgeNew.addEdgeUndirected(4, 5, 2);
		graphEdgeNew.addEdgeUndirected(4, 6, 7);
		graphEdgeNew.addEdgeUndirected(5, 6, 8);
		return graphEdgeNew;
	}
	private static GraphEdgeNew createGraph5() {
		int v = 7;
		GraphEdgeNew graphEdgeNew = new GraphEdgeNew(v);
		graphEdgeNew.addEdgeUndirected(0, 1, 10);
		graphEdgeNew.addEdgeUndirected(0, 3, 10);
		graphEdgeNew.addEdgeUndirected(1, 2, 12);
		graphEdgeNew.addEdgeUndirected(2, 5, 3);
		graphEdgeNew.addEdgeUndirected(3, 4, 5);
		graphEdgeNew.addEdgeUndirected(4, 5, 5);
		graphEdgeNew.addEdgeUndirected(4, 6, 7);
		graphEdgeNew.addEdgeUndirected(5, 6, 8);
		return graphEdgeNew;
	}
	private static GraphEdgeNew createGraph6() {
		int v = 7;
		GraphEdgeNew graphEdgeNew = new GraphEdgeNew(v);
		graphEdgeNew.addEdgeUndirected(0, 1, 10);
		graphEdgeNew.addEdgeUndirected(0, 3, 10);
		graphEdgeNew.addEdgeUndirected(1, 2, 12);
		graphEdgeNew.addEdgeUndirected(2, 3, 13);
		graphEdgeNew.addEdgeUndirected(2, 5, 3);
		graphEdgeNew.addEdgeUndirected(3, 4, 5);
		graphEdgeNew.addEdgeUndirected(4, 5, 2);
		graphEdgeNew.addEdgeUndirected(5, 6, 8);
		return graphEdgeNew;
	}
	private static GraphEdgeNew createGraph7() {
		int v = 7;
		GraphEdgeNew graphEdgeNew = new GraphEdgeNew(v);
		graphEdgeNew.addEdgeUndirected(0, 1, 10);
		graphEdgeNew.addEdgeUndirected(0, 3, 40);
		graphEdgeNew.addEdgeUndirected(1, 2, 10);
		graphEdgeNew.addEdgeUndirected(2, 3, 10);
		graphEdgeNew.addEdgeUndirected(3, 4, 2);
		graphEdgeNew.addEdgeUndirected(4, 6, 8);
		graphEdgeNew.addEdgeUndirected(4, 5, 3);
		graphEdgeNew.addEdgeUndirected(5, 6, 3);
		return graphEdgeNew;
	}
	private static GraphEdgeNew createGraph8() {
		int v = 7;
		GraphEdgeNew graphEdgeNew = new GraphEdgeNew(v);
		graphEdgeNew.addEdgeDirected(0, 1, 10);
		graphEdgeNew.addEdgeDirected(0, 3, 10);
		graphEdgeNew.addEdgeDirected(1, 2, 12);
		graphEdgeNew.addEdgeDirected(2, 3, 13);
		graphEdgeNew.addEdgeDirected(4, 3, 3);
		graphEdgeNew.addEdgeDirected(4, 5, 5);
		graphEdgeNew.addEdgeDirected(4, 6, 2);
		graphEdgeNew.addEdgeDirected(5, 6, 2);
		return graphEdgeNew;
	}
	private static GraphEdgeNew createGraph9() {
		int v = 7;
		GraphEdgeNew graphEdgeNew = new GraphEdgeNew(v);
		graphEdgeNew.addEdgeUndirected(0, 1, 10);
		graphEdgeNew.addEdgeUndirected(0, 3, 25);
		graphEdgeNew.addEdgeUndirected(1, 2, 10);
		graphEdgeNew.addEdgeUndirected(2, 3, 10);
		graphEdgeNew.addEdgeUndirected(3, 4, 2);
		graphEdgeNew.addEdgeUndirected(4, 6, 8);
		graphEdgeNew.addEdgeUndirected(4, 5, 3);
		graphEdgeNew.addEdgeUndirected(5, 6, 3);
		return graphEdgeNew;
	}
	private static boolean hasAPath(List<EdgeN>[] graph, int v, int src, int dest) {
		// TODO Auto-generated method stub
		boolean[] isvisited = new boolean[v];
		return hasAPathRec(graph,v,src,dest,isvisited);
	}
	private static boolean hasAPathRec(List<EdgeN>[] graph, int v, int src, int dest,boolean[] isvisited) {
		// TODO Auto-generated method stub
		if(src == dest){
			return true;
		}
		isvisited[src] = true;
		for(int i = 0; i < graph[src].size(); i++){
			if(!isvisited[graph[src].get(i).dest]){
				boolean childVisited = hasAPathRec(graph, v, graph[src].get(i).dest, dest, isvisited);
				if(childVisited){
					return true;
				}
			}
		}
		return false;
	}
	private static void printAllPaths(List<EdgeN>[] graph, int v, int src, int dest) {
		// TODO Auto-generated method stub
		System.out.println("Print All Path from Source("+src+") to ("+dest+") => ");
		boolean[] isvisited = new boolean[v];
		String pathSOfar = src+"->";
		printAllPathsRec(graph,v,src,dest,isvisited,pathSOfar);
	}
	private static void printAllPathsRec(List<EdgeN>[] graph, int v, int src, 
			int dest,boolean[] isvisited,String pathSOfar) {
		// TODO Auto-generated method stub
		if(src == dest){
			System.out.println(pathSOfar);
			return;
		}
		isvisited[src] = true;
		for(int i = 0; i < graph[src].size(); i++){
			if(!isvisited[graph[src].get(i).dest]){
				printAllPathsRec(graph, v, graph[src].get(i).dest, dest, isvisited, pathSOfar+graph[src].get(i).dest+"->");
			}
		}
		isvisited[src] = false;
	}
	private static List<List<Integer>> getConnectedComponents(List<EdgeN>[] graph, int v) {
		System.out.println("All the Connected Components of the Graph :=> ");
		List<List<Integer>> components = new ArrayList<List<Integer>>();
		boolean[] isVisited = new boolean[v];
		for(int i=0; i< v; i++){
			List<Integer> component = new ArrayList<>();
			if(!isVisited[i]){
				callConnectedComponetRec(i,graph,v,isVisited,component);
				components.add(component);
			}
		}
		System.out.println(components);
		return components;
	}
	private static void callConnectedComponetRec(int src, List<EdgeN>[] graph, int v, boolean[] isVisited,List<Integer> component) {
		isVisited[src] = true;
		component.add(src);
		for(int i = 0; i < graph[src].size(); i++){
			if(!isVisited[graph[src].get(i).dest]){
				callConnectedComponetRec(graph[src].get(i).dest, graph, v, isVisited, component);
			}
		}
	}

	private static void isGraphConnected(List<EdgeN>[] graph, int v) {
		List<List<Integer>> components = getConnectedComponents(graph, v);
		System.out.println("Is Graph Connected :=> "+((components.size() == 1) ? true : false));
	}
	private static void getNoOfIceLands(int[][] iceland) {
		// TODO Auto-generated method stub
		int count = 0;
		boolean[][] isVisited = new boolean[iceland.length][iceland[0].length];
		for(int i = 0; i < iceland.length; i++){
			for(int j = 0; j < iceland[0].length; j++){
				if(!isVisited[i][j] && iceland[i][j] == 0){
					callIceLandRec(i,j,iceland,isVisited);
					count++;
				}
			}
		}
		System.out.println("No of Icelands :=> "+count);
	}
	private static void callIceLandRec(int i, int j, int[][] iceland, boolean[][] isVisited) {
		if(i < 0 || j < 0 || i >= iceland.length || j >=iceland[0].length || iceland[i][j] == 1 || isVisited[i][j]){
			return;
		}
		isVisited[i][j] = true;
		callIceLandRec(i+1,j, iceland, isVisited);
		callIceLandRec(i-1,j, iceland, isVisited);
		callIceLandRec(i,j+1, iceland, isVisited);
		callIceLandRec(i,j-1, iceland, isVisited);
	}
	private static void getNoOfPerfectFriendsPair(int v, int e, int[][] pair) {
		// TODO Auto-generated method stub
		int pairCount = 0;
		GraphEdgeNew graphEdgeNewFriends = new GraphEdgeNew(v);
		for(int[] p : pair){
			graphEdgeNewFriends.addEdgeUndirected(p[0], p[1], 1);
		}
		List<List<Integer>> components = getConnectedComponents(graphEdgeNewFriends.graph, v);
		if(components.size() <= 1){
			System.out.println("Total no of Friends' Pair :=> "+pairCount);
		}else{
			for(int i = 0 ; i < components.size(); i++){
				for(int j = i+1; j < components.size(); j++){
					pairCount += components.get(i).size()*components.get(j).size();
				}
			}
			System.out.println("Total no of Friends' Pair :=> "+pairCount);
		}
	}
	private static void printHamiltonianPathCycle(List<EdgeN>[] graph, int v, int source) {
		System.out.println("Print All Hamiltonian path and Cycle from Source("+source+") => ");
		Set<Integer> isVisited = new HashSet<>();
		String psf = source+"->";
		callHamiltonianPathCycleRec(source,source,v,graph,isVisited,psf);
	}

	private static void callHamiltonianPathCycleRec(int src, int orgSrc, int v, List<EdgeN>[] graph,Set<Integer> isVisited, String psf) {
		// TODO Auto-generated method stub
		if(isVisited.size() == v-1){
			boolean isCycle = false;
			for(int i = 0; i < graph[src].size(); i++){
				if(graph[src].get(i).dest == orgSrc){
					isCycle = true;
					break;
				}
			}
			if(isCycle){
				psf = psf + " @Cycle";
			}else{
				psf = psf + " @Path";
			}
			System.out.println(psf);
		}
		isVisited.add(src);
		for(int i = 0; i < graph[src].size(); i++){
			if(!isVisited.contains(graph[src].get(i).dest)){
				callHamiltonianPathCycleRec(graph[src].get(i).dest, orgSrc, v, graph, isVisited, psf+graph[src].get(i).dest+"->");
			}
		}
		isVisited.remove(src);
	}
	private static void knightTour(int[][] arr, int rStrt, int colStart) {
		// TODO Auto-generated method stub
		int item = 1;
		knightTourRec(rStrt,colStart,arr,item);
	}
	private static void knightTourRec(int r, int c, int[][] arr, int item) {
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
		knightTourRec(r+2, c-1, arr, item+1);
		knightTourRec(r+2, c+1, arr, item+1);
		knightTourRec(r-2, c-1, arr, item+1);
		knightTourRec(r-2, c+1, arr, item+1);
		knightTourRec(r+1, c-2, arr, item+1);
		knightTourRec(r+1, c+2, arr, item+1);
		knightTourRec(r-1, c-2, arr, item+1);
		knightTourRec(r-1, c+2, arr, item+1);
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
	public static void isCyclicGraph(List<EdgeN>[] graph, int v, int src){
		System.out.println("Find if the Graph is cyclic := "+isCyclicGraphRec(graph,v,src));
	}
	private static boolean isCyclicGraphRec(List<EdgeN>[] graph, int v, int src) {
		boolean[] isVisited = new boolean[v];
		ArrayDeque<BFSPairN> queue = new ArrayDeque<>();
		queue.add(new BFSPairN(src, src+"->"));
		while(queue.size() > 0){
			BFSPairN rem = queue.poll();
			if(isVisited[rem.v]){
				return true;
			}
			isVisited[rem.v] = true;
			for(int i = 0; i < graph[rem.v].size(); i++){
				if(!isVisited[graph[rem.v].get(i).dest]){
					queue.add(new BFSPairN(graph[rem.v].get(i).dest, rem.psf+graph[rem.v].get(i).dest+"->"));
				}
			}
		}
		return false;
	}
	private static void bfs(List<EdgeN>[] graph, int v, int src) {
		boolean[] isVisited = new boolean[v];
		for(int i = 0; i < v; i++){
			if(!isVisited[i]){
				bfsRec(graph, v, i, isVisited);
			}
		}
	}
	private static void bfsRec(List<EdgeN>[] graph, int v, int src, boolean[] isVisited) {
		ArrayDeque<BFSPairN> queue = new ArrayDeque<>();
		queue.add(new BFSPairN(src, src+"->"));
		while(queue.size() > 0){
			BFSPairN rem = queue.poll();
			if(isVisited[rem.v]){
				continue;
			}
			isVisited[rem.v] = true;
			System.out.println(rem.v+" @Path >"+rem.psf);
			for(int i = 0; i < graph[rem.v].size(); i++){
				if(!isVisited[graph[rem.v].get(i).dest]){
					queue.add(new BFSPairN(graph[rem.v].get(i).dest, rem.psf+graph[rem.v].get(i).dest+"->"));
				}
			}
		}
	}
	private static void dfsIterative(List<EdgeN>[] graph, int v, int src) {
		System.out.println("Iterative DFS of a Graph :->");
		boolean[] isVisited = new boolean[v];
		for(int i = 0; i < v; i++){
			if(!isVisited[i]){
				dfsIterativeRec(graph, v, i, isVisited);
			}
		}
	}
	private static void dfsIterativeRec(List<EdgeN>[] graph, int v, int src, boolean[] isVisited) {
		Stack<BFSPairN> stack = new Stack<>();
		stack.add(new BFSPairN(src, src+"->"));
		while(stack.size() > 0){
			BFSPairN rem = stack.pop();
			if(isVisited[rem.v]){
				continue;
			}
			isVisited[rem.v] = true;
			System.out.println(rem.v+" @Path >"+rem.psf);
			for(int i = 0; i < graph[rem.v].size(); i++){
				if(!isVisited[graph[rem.v].get(i).dest]){
					stack.push(new BFSPairN(graph[rem.v].get(i).dest, rem.psf+graph[rem.v].get(i).dest+"->"));
				}
			}
		}
	}
	private static void countOfSpreadInfection(List<EdgeN>[] graph, int v, int t, int src) {
		// TODO Auto-generated method stub
		System.out.print("Total count of Infected Nodes :=> ");
		LinkedList<BFSPairN> queue = new LinkedList<>();
		queue.add(new BFSPairN(src, "",1));
		int[] isVisited = new int[v];
		int count = 0;
		while(queue.size() > 0){
			BFSPairN rem = queue.poll();
			if(isVisited[rem.v] > 0){
				continue;
			}
			if(rem.time > t){
				break;
			}
			isVisited[rem.v] = rem.time;
			count++;
			for(int i =0; i < graph[rem.v].size(); i++){
				if(isVisited[graph[rem.v].get(i).dest] <= 0){
					queue.add(new BFSPairN(graph[rem.v].get(i).dest, "", rem.time+1));
				}
			}
		}
		System.out.print(count);
		System.out.println();
	}
	private static void isBipartieGraph(List<EdgeN>[] graph, int v) {
		// TODO Auto-generated method stub
		System.out.print("Is this Graph Bipartiite ? :=> ");
		boolean isGraphBiPartie = true;
		int[] isVisited = new int[v];
		Arrays.fill(isVisited, -1);
		for(int i = 0; i < v; i++){
			if(!isGraphBiPartie){
				break;
			}
			if(isVisited[i] == -1){
				if(!checkIfBipartieGraphRec(i,v,graph,isVisited)){
					isGraphBiPartie = false;
					break;
				}
			}
		}
		System.out.println(isGraphBiPartie);
		System.out.println();
	}
	private static boolean checkIfBipartieGraphRec(int src, int v, List<EdgeN>[] graph, int[] isVisited) {
		ArrayDeque<BFSPairN> queue = new ArrayDeque<>();
		queue.add(new BFSPairN(src, 0));
		while(queue.size() > 0){
			BFSPairN rem = queue.poll();
			if(isVisited[rem.v] != -1){
				if(isVisited[rem.v] != rem.level){
					return false;
				}else{
					continue;
				}
			}
			isVisited[rem.v] = rem.level;
			for(int i = 0; i < graph[rem.v].size(); i++){
				if(isVisited[graph[rem.v].get(i).dest] == -1){
					queue.add(new BFSPairN(graph[rem.v].get(i).dest, rem.level+1));
				}
			}
		}
		return true;
	}
	private static void dikstra(List<EdgeN>[] graph, int v, int src) {
		System.out.println("Dikstra Algorithm Single Source Shortest Path :=> ");
		// TODO Auto-generated method stub
		PriorityQueue<BFSPairN> queue = new PriorityQueue<>(new Comparator<BFSPairN>() {
			@Override
			public int compare(BFSPairN e1, BFSPairN e2) {
				// TODO Auto-generated method stub
				return Integer.valueOf(e1.wsf).compareTo(Integer.valueOf(e2.wsf));
			}
		});
		boolean[] isVisited = new boolean[v];
		queue.add(new BFSPairN(src, src+"->",0,0));
		while(queue.size() > 0){
			BFSPairN rem = queue.poll();
			if(isVisited[rem.v]){
				continue;
			}
			isVisited[rem.v] = true;
			System.out.println("Source("+src+") to Destination("+rem.v+") via Path@ "+ rem.psf+ " with Cost@ "+rem.wsf);
			for(int i = 0; i < graph[rem.v].size(); i++){
				if(!isVisited[graph[rem.v].get(i).dest]){
					queue.add(new BFSPairN(graph[rem.v].get(i).dest, rem.psf+graph[rem.v].get(i).dest+"->", rem.wsf+graph[rem.v].get(i).val, 0));
				}
			}
		}
	}
	private static void getSmallestLargestFloorCeil(List<EdgeN>[] graph, int v, int src, int dest,int number) {
		// TODO Auto-generated method stub
		boolean[] isvisited = new boolean[v];
		List<Pair> pathWithCostList = new ArrayList<Pair>();
		String pathSOfar = src+"->";
		int sum = 0;
		getSmallestLargestFloorCeilRec(graph,v,src,dest,isvisited,pathSOfar,sum,pathWithCostList);
		Collections.sort(pathWithCostList,new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				return Integer.valueOf(o1.cost).compareTo(Integer.valueOf(o2.cost));
			}
		});
		System.out.println("Path with Smallest Cost from Source("+src+") to ("+dest+") => "+pathWithCostList.get(0).path+" @"+pathWithCostList.get(0).cost);
		System.out.println("Path with Largest Cost from Source("+src+") to ("+dest+") => "+pathWithCostList.get(pathWithCostList.size()-1).path+" @"+pathWithCostList.get(pathWithCostList.size()-1).cost);
		System.out.println("Path with 3rd Largest Cost from Source("+src+") to ("+dest+") => "+pathWithCostList.get(0).path+" @"+pathWithCostList.get(pathWithCostList.size()-3).cost);
		List<Pair> pathWithCostCeil =pathWithCostList.stream().filter(pair -> pair.cost > number).collect(Collectors.toList());
		List<Pair> pathWithCostFloor =pathWithCostList.stream().filter(pair -> pair.cost < number).collect(Collectors.toList());
		System.out.println("Ceil of Number("+number+") => "+pathWithCostCeil.get(0).path+" @"+pathWithCostCeil.get(0).cost);
		System.out.println("Floor of Number("+number+") => "+pathWithCostFloor.get(pathWithCostFloor.size()-1).path+" @"+pathWithCostFloor.get(pathWithCostFloor.size()-1).cost);
		
	}
	private static void getSmallestLargestFloorCeilRec(List<EdgeN>[] graph, int v, int src, int dest,boolean[] isvisited, String pathSOfar,int sum, List<Pair> pathWithCostList) {
		// TODO Auto-generated method stub
		if(src == dest){
			pathWithCostList.add(new Pair(pathSOfar, sum));
			return;
		}
		isvisited[src] = true;
		for(int i = 0; i < graph[src].size();i++){
			if(!isvisited[graph[src].get(i).dest]){
				getSmallestLargestFloorCeilRec(graph, v, graph[src].get(i).dest, dest, isvisited, pathSOfar+graph[src].get(i).dest+"->", sum+graph[src].get(i).val, pathWithCostList);
			}
		}
		isvisited[src]= false;
	}
	private static void topologicalSort(List<EdgeN>[] graph, int v) {
		System.out.println("Topological Sort of the Graph :=> ");
		Stack<Integer> stack = new Stack<>();
		boolean[] isVisited = new boolean[v];
		for(int i = 0; i < v; i++){
			if(!isVisited[i]){
				callDFSTopologicalSort(i,v,isVisited,graph,stack);
			}
		}
		while(stack.size() > 0){
			System.out.print(stack.pop()+"->");
		}
		System.out.println();
	}
	private static void callDFSTopologicalSort(int src, int v, boolean[] isVisited, List<EdgeN>[] graph, Stack<Integer> stack) {
		isVisited[src] = true;
		for(int i = 0; i < graph[src].size(); i++){
			if(!isVisited[graph[src].get(i).dest]){
				callDFSTopologicalSort(graph[src].get(i).dest, v, isVisited, graph, stack);
			}
		}
		stack.push(src);
	}
	public static void getNoOfEnclaves(int[][] enclave) {
		// TODO Auto-generated method stub
		int count = 0;
		boolean[][] isVisisted = new boolean[enclave.length][enclave[0].length];
		for(int i = 0; i < enclave.length; i++){
			for(int j = 0; j < enclave[0].length; j++){
				if(i == 0 || i == enclave.length-1 || j == 0 || j == enclave[0].length-1){
					if(enclave[i][j] == 1 && !isVisisted[i][j])
					callDFSEnclave(i,j,enclave,isVisisted);
				}
			}
		}
		for(int i = 0; i < enclave.length; i++){
			for(int j = 0; j < enclave[0].length; j++){
				if(enclave[i][j] == 1){
					count += 1;
				}
			}
		}
		System.out.println("No of Total Enclaves :=> "+count);
	}

	private static void callDFSEnclave(int i, int j, int[][] enclave, boolean[][] isVisisted) {
		if(i < 0 || j < 0 || i >= enclave.length || j >= enclave[0].length || isVisisted[i][j] || enclave[i][j] == 0){
			return;
		}
		isVisisted[i][j] = true;
		enclave[i][j] = 0;
		callDFSEnclave(i+1, j, enclave, isVisisted);
		callDFSEnclave(i-1, j, enclave, isVisisted);
		callDFSEnclave(i, j+1, enclave, isVisisted);
		callDFSEnclave(i, j-1, enclave, isVisisted);
 	}
	private static void nearestDistanceZeroOne(int[][] arr) {
		System.out.println("Nearest distance to Zero in a Zero Sum Matrix :");
	   boolean[][] isVIsited = new boolean[arr.length][arr[0].length];
	   ArrayDeque<Rottons> queue = new ArrayDeque<>();
	   for(int i = 0; i < arr.length; i++){
		   for(int j = 0 ; j < arr[0].length; j++){
			   if(arr[i][j] == 0){
				   queue.add(new Rottons(i, j, 0));
			   }
		   }
	   }
	   while(queue.size() > 0){
		   Rottons rem = queue.poll();   
		   if(isVIsited[rem.i][rem.j]){
			   continue;
		   }
		   if(arr[rem.i][rem.j] == 1){
			   arr[rem.i][rem.j] = rem.time;
		   }
		   isVIsited[rem.i][rem.j]= true;
		   int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
		   for(int i = 0; i < dir.length; i++){
			   int row = rem.i + dir[i][0];
			   int col = rem.j + dir[i][1];
			   if(row >= 0 && col >= 0 && row < arr.length && col < arr[0].length && !isVIsited[row][col] && arr[row][col] == 1){
				   queue.add(new Rottons(row, col, rem.time+1));
			   }
		   }
	   }
		displayArray(arr);
	}
	private static void getTimeToRottonOrrange(int[][] rotton) {
		// TODO Auto-generated method stub
		int noOFOne = 0;
		int noOfTwo = 0;
		int time  = 0;
		int reconOne = 0;
		boolean[][] isVisited = new boolean[rotton.length][rotton[0].length];
		ArrayDeque<Rottons> queue = new ArrayDeque<Rottons>();
		for(int i = 0;  i < rotton.length; i++){
			for(int j = 0; j < rotton[0].length; j++){
				if(rotton[i][j] == 1){
					noOFOne += 1;
				}else if(rotton[i][j] == 2){
					noOfTwo +=1;
					queue.add(new Rottons(i, j, time));
				}
			}
		}
		while(queue.size() > 0){
			Rottons rem = queue.poll();
			int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
			if(isVisited[rem.i][rem.j]){
				continue;
			}
			isVisited[rem.i][rem.j] = true;
			for(int i = 0; i < dir.length; i++){
					int row = rem.i+dir[i][0];
					int col = rem.j+dir[i][1];
					if(row >= 0 && col >= 0 && row < rotton.length && col < rotton[0].length && rotton[row][col] == 1 && !isVisited[row][col]){
						rotton[row][col] = 2;
						reconOne++;
						time = rem.time+1;
						queue.add(new Rottons(row, col, rem.time+1));						
					}
			}
		}
		if(noOFOne != reconOne){
			System.out.println("Not Possible to rot all the Frsh Oranges");
		}else{
			System.out.println("Time taken to rot all the Frsh Oranges :=> "+time);
		}
	}
	public static void getNoOfDistinctIceLands(int[][] iceland) {
		// TODO Auto-generated method stub
		int count = 0;
		Set<String> distinctCount = new HashSet<String>();
		boolean[][] isVisited = new boolean[iceland.length][iceland[0].length];
		for(int i = 0; i < iceland.length; i++){
			for(int j = 0; j < iceland[0].length; j++){
				if(iceland[i][j] == 1 && !isVisited[i][j]){
					StringBuilder sb = new StringBuilder("");
					callDFSIceland(i,j,iceland,isVisited,sb);
					count++;
					distinctCount.add(sb.toString());
				}
			}
		}
		System.out.println("No of Total Icelands :=> "+count);
		System.out.println("No of Distinct Icelands :=> "+distinctCount.size());
		
	}
	private static void callDFSIceland(int i, int j, int[][] iceland, boolean[][] isVisited, StringBuilder sb) {
		// TODO Auto-generated method stub
		if(i < 0 || j < 0 || i >= iceland.length || j >= iceland[0].length || iceland[i][j] == 0 || isVisited[i][j]){
			return;
		}
		isVisited[i][j] = true;
		callDFSIceland(i+1, j, iceland, isVisited, sb.append(1));
		callDFSIceland(i-1, j, iceland, isVisited, sb.append(2));
		callDFSIceland(i, j+1, iceland, isVisited, sb.append(3));
		callDFSIceland(i, j-1, iceland, isVisited, sb.append(4));
	}

	private static void findMinimumSpanningTree(List<EdgeN>[] graph, int v) {
		System.out.println("Find Minimum Spanning Tree using Prims Algorithm :=");
		PriorityQueue<Prims> queue = new PriorityQueue<>(new Comparator<Prims>() {
			@Override
			public int compare(Prims o1, Prims o2) {
				// TODO Auto-generated method stub
				return Integer.valueOf(o1.cost).compareTo(Integer.valueOf(o2.cost));
			}
		});
		int totalcost=0;
		queue.add(new Prims(0, -1, 0+"->", 0));
		boolean[] isVisited = new boolean[v];
		while(queue.size() > 0){
			Prims rem = queue.poll();
			if(isVisited[rem.v]){
				continue;
			}
			isVisited[rem.v] = true;
			if(rem.adj != -1){
				System.out.println("Edge =>"+rem.adj+"->"+rem.v+" @cost="+rem.cost);
				totalcost += rem.cost;
			}
			for(int i = 0; i < graph[rem.v].size(); i++){
				if(!isVisited[graph[rem.v].get(i).dest]){
					queue.add(new Prims(graph[rem.v].get(i).dest, rem.v, rem.path+graph[rem.v].get(i).dest, graph[rem.v].get(i).val));
				}
			}
		}
		System.out.println("Cost of Minimum Spanning Tree := "+totalcost);
	}
}

class EdgeN{
	int src;
	int dest;
	int val;
	public EdgeN(int src, int dest, int val) {
		super();
		this.src = src;
		this.dest = dest;
		this.val = val;
	}
}
class BFSPairN{
	int v;
	String psf;
	int time;
	int level;
	int wsf;
	public BFSPairN(int v, String psf) {
		super();
		this.v = v;
		this.psf = psf;
	}
	public BFSPairN(int v, String psf, int time) {
		super();
		this.v = v;
		this.psf = psf;
		this.time = time;
	}
	public BFSPairN(int v, int level) {
		super();
		this.v = v;
		this.level = level;
	}
	public BFSPairN(int v, String psf, int wsf, int time) {
		super();
		this.v = v;
		this.psf = psf;
		this.wsf = wsf;
		this.time = time;
	}
}

class Prims{
	int v;
	int adj;
	String path;
	int cost;
	public Prims(int v, int adj, String path, int cost) {
		super();
		this.v = v;
		this.adj = adj;
		this.path = path;
		this.cost = cost;
	}
}

class Rottons{
	int i;
	int j;
	int time;
	public Rottons(int i, int j, int time) {
		super();
		this.i = i;
		this.j = j;
		this.time = time;
	}
}

class Farthest{
	int i;
	int j;
	int level;
	public Farthest(int i, int j, int level) {
		super();
		this.i = i;
		this.j = j;
		this.level = level;
	}
}