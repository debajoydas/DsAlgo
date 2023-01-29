/**
 * 
 */
package com.debajoy.ds.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author Debajoy
 *
 */
public class RemoveStonesToMinimize {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] piles = {5,4,9};
		int k = 2;
		System.out.println(minStoneSum(piles, k));
	}
	
    public static int minStoneSum(int[] piles, int k) {
    	PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
    	for(int i : piles){
    		queue.add(i);
    	}
    	while(k > 0){
    		int polled = queue.poll();
    		queue.add(polled-Math.floorDiv(polled, 2));
    		k--;
    	}
		return queue.stream().reduce(Integer::sum).get(); 
    }
}
