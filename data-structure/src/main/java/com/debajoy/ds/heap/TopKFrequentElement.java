/**
 * 
 */
package com.debajoy.ds.heap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Debajoy
 *
 */
public class TopKFrequentElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1,1,1,2,2,3};
		int k = 2;
		
		int[] nums1 = {1,2};
		int k1 = 2;
		
		int[] result = topKFrequent(nums1, k1);
		for(int i : result){
			System.out.println(i);
		}
	}

    public static int[] topKFrequent(int[] nums, int k) {
     
    	Set<Integer> set = new HashSet<Integer>();
    	if(nums == null){
    		return null;
    	}
    	PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    	for(int i : nums){
    		queue.add(i);
    	}
    	int prev = Integer.MIN_VALUE;
    	int count = 0;
    	while( queue.size() > 0){
    		
    		int ele = queue.poll();
    		if(ele == prev){
    			count++;
    		}else{
    			count = 1;
    			prev =  ele;
    		}	
/*    		if(count >= 0 || count <= k){
    			set.add(prev);
    		}else if(count > k){
    			set.remove(prev);
    		}
    		*/
    		if(count >= k){
    			set.add(prev);
    		}
    	}
    	
    	int[] arr =  new int [set.size()];
    	int index = 0;
    	for(int i : set){
    		arr[index] = i;
    		index++;
    	}
    	return arr;
    }
}
