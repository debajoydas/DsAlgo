/**
 * 
 */
package com.debajoy.ds.graph1;

/**
 * @author dasde
 *
 */
public class DisjointSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v = 7;
		doUnionAndFind(v);
	}

	private static void doUnionAndFind(int v) {
		// TODO Auto-generated method stub
		int[] arr = new int[v];
		for(int i = 0; i < v; i++) {
			arr[i] = i;
		}
	}
	
	private static void unionSet(int[] parent, int element1, int element2) {
		int parent1 = findParent(parent, element1);
		int parent2 = findParent(parent, element2);
		parent[parent1] = parent2;
	}

	private static int findParent(int[] parent, int element) {
		if(parent[element] == element) {
			return element;
		}
		return findParent(parent, parent[element]);
	}
	

}
