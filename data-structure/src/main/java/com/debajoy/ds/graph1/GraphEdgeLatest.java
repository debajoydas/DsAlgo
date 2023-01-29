/**
 * 
 */
package com.debajoy.ds.graph1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author dasde
 *
 */
public class GraphEdgeLatest {

	private List<EdgeN>[] graph;
	private int v;
	
	public GraphEdgeLatest(int v) {
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
		GraphEdgeLatest graphEdgeLatest = createGraph1();
		isCyclicGraph(graphEdgeLatest.graph, graphEdgeLatest.v);
		System.out.println(SEPERATOR);
		
		GraphEdgeLatest graphEdgeLatest2 = createGraph2();
		findMinimumSpanningTree(graphEdgeLatest2.graph, graphEdgeLatest2.v);
		System.out.println(SEPERATOR);
		
		GraphEdgeLatest graphEdgeLatest3 = createGraph3();
		findStronglyConnectedComponents(graphEdgeLatest3.graph, graphEdgeLatest3.v);
		System.out.println(SEPERATOR);
		
		GraphEdgeLatest graphEdgeLatest4 = createGraph4();
		int source = 0;
		shortestPathFromSource(graphEdgeLatest4.graph, graphEdgeLatest4.v, source);
		System.out.println(SEPERATOR);
		shortestPathFromAllSources(graphEdgeLatest4.graph, graphEdgeLatest4.v);
		System.out.println(SEPERATOR);
		
		shortestPathFromAllSourcesFloydMarshal(graphEdgeLatest4.graph, graphEdgeLatest4.v);
		System.out.println(SEPERATOR);
	}
	
	private static void shortestPathFromAllSourcesFloydMarshal(List<EdgeN>[] graph, int v) {
		// TODO Auto-generated method stub
		System.out.println("Floyd Marshal Algorithm...");
		final int INF = 99999;
		int[][] distance = new int[v][v];
		for(int i = 0; i < v; i++) {
			for(int j = 0; j < v; j++) {
				if(i == j) {
					distance[i][j] = 0;
				}else {
					distance[i][j] = INF;
				}
			}
		}
		for(int i = 0; i < graph.length; i++) {
			for(int j = 0; j < graph[i].size(); j++) {
				EdgeN edge = graph[i].get(j);
				distance[edge.src][edge.dest] = edge.val; 
			}
		}
		for(int k = 0; k < v; k++) {
			for(int i = 0; i < v; i++) {
				for(int j = 0; j < v; j++) {
					distance[i][j] = (distance[i][k] < INF && distance[k][j] < INF) ? Math.min(distance[i][j], distance[i][k]+distance[k][j]) : distance[i][j];
				}
			}
		}
		for(int i = 0; i < v; i++) {
			System.out.println();
			for(int j = 0; j < v; j++) {
				System.out.println("Distance from Node-"+i+" to Node-"+j+" :=> "+(distance[i][j] < INF ? distance[i][j] : "Not Reachable"));
			}
		}
	}

	private static void shortestPathFromAllSources(List<EdgeN>[] graph, int v) {
		// TODO Auto-generated method stub
		System.out.println("BellmanFord Algorithm...");
		final int INF = 99999;
		for(int x = 0 ; x < v; x++) {
			System.out.println();
			int src = x;
			int[] distance = new int[v];
			Arrays.fill(distance, INF);
			distance[src] = 0;
			for(int i = 0; i < (v-1); i++) {
				for(int j = 0; j < graph.length; j++) {
					List<EdgeN> edges = graph[j];
					for(int k = 0; k < edges.size(); k++) {
						EdgeN edge = edges.get(k);
						if(distance[edge.src] < INF && distance[edge.src]+edge.val < distance[edge.dest]) {
							distance[edge.dest] = distance[edge.src]+edge.val;
						}
					}
				}
			}
			for(int i = 0; i < distance.length; i++) {
				System.out.println("Distance from Node-"+src+" to Node-"+i+" :=> "+(distance[i] < INF ? distance[i] : "Not Reachable"));
			}
		}
	}

	private static void shortestPathFromSource(List<EdgeN>[] graph, int v, int src) {
		// TODO Auto-generated method stub
		System.out.println("BellmanFord Algorithm...");
		final int INF = 99999;
		int[] distance = new int[v];
		Arrays.fill(distance, INF);
		distance[src] = 0;
		for(int i = 0; i < (v-1); i++) {
			for(int j = 0; j < graph.length; j++) {
				List<EdgeN> edges = graph[j];
				for(int k = 0; k < edges.size(); k++) {
					EdgeN edge = edges.get(k);
					if(distance[edge.src] < INF && distance[edge.src]+edge.val < distance[edge.dest]) {
						distance[edge.dest] = distance[edge.src]+edge.val;
					}
				}
			}
		}
		for(int i = 0; i < distance.length; i++) {
			System.out.println("Distance from Node-"+src+" to Node-"+i+" :=> "+(distance[i] < INF ? distance[i] : "Not Reachable"));
		}
	}

	private static void findStronglyConnectedComponents(List<EdgeN>[] graph, int v) {
		// TODO Auto-generated method stub
		List<List<Integer>> stronglyComponents = new ArrayList<List<Integer>>();
		boolean[] isVisited = new boolean[v];
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < v; i++) {
			if(!isVisited[i]) {
				dfsOrdering(i, graph, v, isVisited, stack);
			}
		}
		List<EdgeN>[] graphTranspose = getTransposeGraph(graph,v);
		isVisited = new boolean[v];
		while(!stack.isEmpty()) {
			int vertx = stack.pop();
			List<Integer> list = new ArrayList<Integer>();
			if(!isVisited[vertx]) {
				dfsUtil(vertx, graphTranspose, v, isVisited, list);
				stronglyComponents.add(list);
			}
		}
		System.out.println("Strongly Connected Components are :=> "+stronglyComponents);
		
	}
	
	private static List<EdgeN>[] getTransposeGraph(List<EdgeN>[] graph, int v) {
		// TODO Auto-generated method stub
		GraphEdgeLatest graphEdgeLatestT = new GraphEdgeLatest(v);
		for(int i = 0; i < graph.length; i++) {
			List<EdgeN> edges = graph[i];
			for(int j = 0; j < edges.size(); j++) {
				graphEdgeLatestT.addEdgeDirected(edges.get(j).dest, edges.get(j).src, edges.get(j).val);
			}
		}
		return graphEdgeLatestT.graph;
	}

	private static void dfsUtil(int src, List<EdgeN>[] graph, int v, boolean[] isVisited, List<Integer> list) {
		isVisited[src] = true;
		list.add(src);
		for(int i = 0; i < graph[src].size(); i++) {
			if(!isVisited[graph[src].get(i).dest]) {
				dfsUtil(graph[src].get(i).dest, graph, v, isVisited, list);
			}
		}
	}
	
	private static void dfsOrdering(int src, List<EdgeN>[] graph, int v, boolean[] isVisited, Stack<Integer> stack) {
		isVisited[src] = true;
		for(int i = 0; i < graph[src].size(); i++) {
			if(!isVisited[graph[src].get(i).dest]) {
				dfsOrdering(graph[src].get(i).dest, graph, v, isVisited, stack);
			}
		}
		stack.push(src);
	}
	
	private static GraphEdgeLatest createGraph4() {
		int v = 7;
		GraphEdgeLatest graphEdgeLatest = new GraphEdgeLatest(v);
		graphEdgeLatest.addEdgeDirected(0, 1, 6);
		graphEdgeLatest.addEdgeDirected(0, 2, 5);
		graphEdgeLatest.addEdgeDirected(0, 3, 5);
		graphEdgeLatest.addEdgeDirected(2, 1, -2);
		graphEdgeLatest.addEdgeDirected(3, 2, -2);
		graphEdgeLatest.addEdgeDirected(1, 4, -1);
		graphEdgeLatest.addEdgeDirected(2, 4, 1);
		graphEdgeLatest.addEdgeDirected(3, 5, -1);
		graphEdgeLatest.addEdgeDirected(5, 6, 3);
		graphEdgeLatest.addEdgeDirected(4, 6, 3);
		return graphEdgeLatest;
	}

	private static GraphEdgeLatest createGraph3() {
		int v = 7;
		GraphEdgeLatest graphEdgeLatest = new GraphEdgeLatest(v);
		graphEdgeLatest.addEdgeDirected(0, 1, 10);
		graphEdgeLatest.addEdgeDirected(1, 2, 10);
		graphEdgeLatest.addEdgeDirected(2, 0, 10);
		graphEdgeLatest.addEdgeDirected(1, 3, 10);
		graphEdgeLatest.addEdgeDirected(3, 4, 10);
		graphEdgeLatest.addEdgeDirected(4, 5, 10);
		graphEdgeLatest.addEdgeDirected(5, 6, 10);
		graphEdgeLatest.addEdgeDirected(6, 4, 10);
		return graphEdgeLatest;
	}
	
	private static GraphEdgeLatest createGraph2() {
		int v = 5;
		GraphEdgeLatest graphEdgeLatest = new GraphEdgeLatest(v);
		graphEdgeLatest.addEdgeUndirected(0, 1, 1);
		graphEdgeLatest.addEdgeUndirected(1, 3, 2);
		graphEdgeLatest.addEdgeUndirected(3, 2, 4);
		graphEdgeLatest.addEdgeUndirected(0, 2, 5);
		graphEdgeLatest.addEdgeUndirected(3, 4, 7);
		graphEdgeLatest.addEdgeUndirected(2, 4, 8);
		return graphEdgeLatest;
	}
	
	private static GraphEdgeLatest createGraph1() {
		int v = 3;
		GraphEdgeLatest graphEdgeLatest = new GraphEdgeLatest(v);
//		graphEdgeLatest.addEdgeDirected(4, 5, 10);
//		graphEdgeLatest.addEdgeDirected(0, 4, 10);
//		graphEdgeLatest.addEdgeDirected(0, 1, 10);
//		graphEdgeLatest.addEdgeDirected(1, 3, 10);
//		graphEdgeLatest.addEdgeDirected(3, 2, 10);
//		graphEdgeLatest.addEdgeDirected(2, 0, 10);
		graphEdgeLatest.addEdgeDirected(0, 1, 10);
		graphEdgeLatest.addEdgeDirected(1, 2, 10);
		graphEdgeLatest.addEdgeDirected(2, 0, 10);
		return graphEdgeLatest;
	}
	
	public static void findMinimumSpanningTree(List<EdgeN>[] graph, int v){
		int minimumCost = 0;
		int[] parent = new int[v];
		int[] rank = new int[v];
		List<EdgeN> edgeList = new ArrayList<EdgeN>();
		Arrays.fill(parent, -1);
		for(int i = 0; i < graph.length; i++) {
			edgeList.addAll(graph[i]);
		}
		Collections.sort(edgeList, new Comparator<EdgeN>() {
			@Override
			public int compare(EdgeN o1, EdgeN o2) {
				// TODO Auto-generated method stub
				return Integer.valueOf(o1.val).compareTo(Integer.valueOf(o2.val));
			}
		});
		for(EdgeN edge : edgeList) {
				int parentSrc = find(parent, edge.src);
				int parentDest = find(parent, edge.dest);
				if(parentSrc != parentDest) {
					minimumCost += edge.val;
					union(parent, rank, parentSrc, parentDest);
				}
		}
		System.out.println("Minimum Cost Spanning Tree :=> "+minimumCost);
	}
	private static int find(int[] parent, int element) {
		if(parent[element] == -1) {
			return element;
		}
		return find(parent, parent[element]);
	}
	private static void union(int[] parent, int[] rank, int element1, int element2) {
		int superParent1 = find(parent, element1);
		int superParent2 = find(parent, element2);
		if(rank[superParent1] >= rank[superParent2]) {
			parent[superParent2] = superParent1;
			rank[superParent1]++;
		}else {
			parent[superParent1] = superParent2;
			rank[superParent2]++;
		}
	}
	public static void isCyclicGraph(List<EdgeN>[] graph, int v){
		boolean circlexists = false;
		boolean[] isVisited = new boolean[v];
		boolean[] recStack = new boolean[v];	
		for(int i = 0; i < v; i++) {
			if(!isVisited[i]) {
				boolean flag = isCyclicGraphRec(graph, v, i, isVisited, recStack);
				if(flag) {
					circlexists = flag;
					break;
				}
			}
		}
		System.out.println("Find if the Directed Graph is cyclic := "+circlexists);
	}
	private static boolean isCyclicGraphRec(List<EdgeN>[] graph, int v, int src, boolean[] isVisited, boolean[] recStack) {
		if(recStack[src]) {
			return true;
		}
		recStack[src] = true;
		if(isVisited[src]) {
			return false;
		}	
		isVisited[src] = true;
		for(int i = 0; i < graph[src].size(); i++) {
			EdgeN edge = graph[src].get(i);
			boolean flag = isCyclicGraphRec(graph, v, edge.dest, isVisited, recStack);
			if(flag) {
				return flag;
			}
		}
		recStack[src] = false;
		return false;
	}

}

