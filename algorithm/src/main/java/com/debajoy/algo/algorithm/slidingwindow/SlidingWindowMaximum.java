/**
 * 
 */
package com.debajoy.algo.algorithm.slidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author Debajoy
 *
 */
public class SlidingWindowMaximum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[] = { 12, 1, 78, 90, 57, 89, 56 }; 
	     int k = 3;
	     int[] outputArr = slidingWindowMaximum(arr, k);
	     Arrays.stream(outputArr).forEach(System.out::println);

	}

	private static int[] slidingWindowMaximum(int[] arr, int k) {
		// TODO Auto-generated method stub
		int n = arr.length;
		int[] slidingWindowArray = new int[n-k+1];
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		int index = 0;
		for(int i = 0; i< n; i++){
			
			while(queue.size() > 0 && queue.peek() < (i-k+1)){
				queue.poll();
			}
			while(queue.size() > 0 && arr[i] > arr[queue.peekLast()]){
				queue.pollLast();
			}
			queue.offer(i);
			if(i >= k-1){
				slidingWindowArray[index] = arr[queue.peek()];
				index++;
			}
		}
		return slidingWindowArray;
	}
	
	private static int[] slidingWindowMaximumMax(int[] arr, int k) {
		int index = 0;
		int n = arr.length;
		int[] slidingWindowArray = new int[n-k+1];
		ArrayDeque<Integer> dequeue = new ArrayDeque<>();
		for(int i = 0; i < n; i++){
			while(dequeue.size() > 0 && dequeue.peek() < (i-k+1)){
				dequeue.poll();
			}
			while(dequeue.size() > 0 && arr[i] > arr[dequeue.peekLast()]){
				dequeue.pollLast();
			}
			dequeue.offer(i);
			if(i >=  k-1){
				slidingWindowArray[index] = arr[dequeue.peek()];
				index++;
			}
		}
		return slidingWindowArray;
		
	}

}
