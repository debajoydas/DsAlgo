/**
 * 
 */
package com.debajoy.ds.heap;

import java.util.PriorityQueue;

/**
 * @author Debajoy
 *
 */
public class RopeMinCost {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			long[] arr = {1,2,6,8,4,6,4,6,9};
			minCost(arr, arr.length);
	}
    public static void minCost(long arr[], int n) {
        // your code here
    	long sum = 0;
    	if(arr == null){
    		return;
    	}else if(arr.length == 0){
    		return;
    	}
    	PriorityQueue<Long> ropeHeap = new PriorityQueue<Long>();
    	for(long value : arr){
    		ropeHeap.add(value);
    	}
		if(ropeHeap.size() == 1){
			System.out.println(0);
		}else if(ropeHeap.size() ==2){
			System.out.println(ropeHeap.poll()+ropeHeap.poll());
		}else{
			minCostCalculation(ropeHeap,sum);
		} 	
    }
	private static void minCostCalculation(PriorityQueue<Long> ropeHeap, long sum) {
		// TODO Auto-generated method stub
		if(ropeHeap.size() == 1){
			System.out.println(sum);
			return;
		}
		long firstMin = ropeHeap.poll();
		long secondMin = ropeHeap.poll();
		sum += firstMin+secondMin;
		ropeHeap.add(firstMin+secondMin);
		minCostCalculation(ropeHeap, sum);
	}
	
	private static void minCostCalculationOptimized(PriorityQueue<Long> ropeHeap, long sum) {
		// TODO Auto-generated method stub
		while(ropeHeap.size() > 1){
			long firstMin = ropeHeap.poll();
			long secondMin = ropeHeap.poll();
			sum += firstMin+secondMin;
			ropeHeap.add(firstMin+secondMin);
		}
		System.out.println(sum);
	}
}
