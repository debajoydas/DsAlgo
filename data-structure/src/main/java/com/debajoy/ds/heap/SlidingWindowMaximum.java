/**
 * 
 */
package com.debajoy.ds.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;import javax.management.Query;
import javax.swing.text.Position;

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
		
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		
		int[] nums1 = {1,-1};
		int k1 = 1;
		
		int[] arr = maxSlidingWindow(nums, k);
		for(int i : arr){
			System.out.println(i);
		}
			
	}
	
    public static int[] maxSlidingWindow(int[] nums, int k) {
        
    	int[] resultArray;
    	int index = 0;
    	if(nums == null){
    		return null;
    	}else if(k > nums.length){
    		return null;
    	}else{
    		resultArray = new int[nums.length-k+1];
    	}
    	int max = Integer.MIN_VALUE;
    	int start = 0;
    	int maxPosition = 0;
    	
    	for(int i = start; i < (nums.length-k+1); i++){
    		for(int j = i ; j < (i+k); j++){
    			if(maxPosition >= i){
    				if(max <= nums[j]){
        				max = nums[j];
        				maxPosition = j;
        			}
    			}else{
    				max =Integer.MIN_VALUE;
    				if(max <= nums[j]){
        				max = nums[j];
        				maxPosition = j;
        			}
    			}
    			
    		}
    		resultArray[index] = max;
    		index++;
    	}

    	return resultArray;
    }

}
