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
public class SelfDimishingColorBall {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inventory = {3,5}; 
		int orders = 6;
		System.out.println(maxProfit(inventory, orders));
	}
	
    public static int maxProfit(int[] inventory, int orders) {
    	PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
    	for(int inv: inventory){
    		queue.add(inv);
    	}
    	int max = 0;
    	while(orders > 0){
    		int polled = queue.poll();
    		max += polled;
    		polled -= 1;
    		if(polled > 0){
    			queue.add(polled);
    		}
    		orders--;
    	}
		return max;      
    }
    
    public static int maxProfitOptimized(int[] inventory, int orders) {
		return orders;	
    }

}
