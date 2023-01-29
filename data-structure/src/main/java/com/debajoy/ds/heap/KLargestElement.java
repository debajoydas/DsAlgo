/**
 * 
 */
package com.debajoy.ds.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Stream;import javax.management.Query;

/**
 * @author Debajoy
 *
 */
public class KLargestElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {3 ,5, 4, 2, 9};
		int k = 7;
		
		int[] arr1 = {4, 3, 7, 6, 5};
		int k1 = 5;
		System.out.println(KthLargest(arr1, arr1.length, k1));
	}
	
	public static int KthLargest(int arr[], int n, int k) {
        if(arr == null){
        	return 0;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i : arr){
        	maxHeap.add(i);
        }
        if(maxHeap.size() >= k){
        	while(k > 1){
        		maxHeap.poll();
        		k--;
        	}
        	return maxHeap.poll();
        }
        return 0;
    }

}
