/**
 * 
 */
package com.debajoy.algo.algorithm.twopointer;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Debajoy
 *
 */
public class RemoveElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1};
		int val = 1;
		System.out.println(removeElement(nums, val));
	}
	
	 public static int removeElementOptimized(int[] nums, int val) {
		 int validIdx = 0;
		 for(int i = 0; i < nums.length; i++){
			 if(nums[i] != val){
				 nums[validIdx] = nums[i];
				 validIdx++;
	         }  
		 }
		 return validIdx;
	 }
	
	   public static int removeElement(int[] nums, int val) {
	        int output = -1;
	        Queue<Integer> queue = new ArrayDeque<Integer>();
	        for(int i = 0; i < nums.length; i++){
	            if(nums[i] != val){
	                queue.add(nums[i]);
	            }        
	        }
	        for(int i = 0; i < nums.length; i++){
	            if(queue.size() <= 0){
	                break;
	            }
	            nums[i] = queue.poll();
	            output = i;
	        }
	        return output < 0 ? 0 : output+1;
	    }

}
