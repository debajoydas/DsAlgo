/**
 * 
 */
package com.debajoy.ds.graph1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dasde
 *
 */
public class FindEventualSafeStates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<Integer> eventualSafeNodes(int[][] graph) {
    	List<Integer> answer = new ArrayList<Integer>();
        int v =  graph.length;
        boolean[] terminal = new boolean[v];
        for(int i = 0; i < graph.length; i++){
            int[] edges = graph[i];
            if(edges.length <= 0) {
            	terminal[i] = true;
            }
        }
        for(int i = 0; i < graph.length; i++){
            int[] edges = graph[i];
            boolean isSafeNode = true;
            for(int j = 0; j < edges.length; j++) {
            	if(!terminal[edges[j]]) {
            		isSafeNode = false;
            	}
            }
            if(isSafeNode) {
            	answer.add(i);
            }
        }
        return answer;
    }

}
