/**
 * 
 */
package com.debajoy.algo.algorithm.twopointer;

import java.util.Arrays;

/**
 * @author Debajoy
 *
 */
public class MinSizeSubArraySum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,2,3,4,5};
		int s = 15;
		System.out.println(minSubArrayLen(s, nums));
	}

	public static int minSubArrayLen(int s, int[] nums) {
		int count = 1;
		if(nums == null || (nums != null && nums.length < 1)){
			return 0;
		}else if(nums != null && nums.length == 1){
			if(nums[0] >= s){
				return 1;
			}
		}else if(nums != null && nums.length > 1)
		Arrays.sort(nums);
		boolean isPossible = false;
		if(nums[nums.length-1] >= s){
			return 1;
		}else{
			int r = nums.length-1;
			int l = nums.length-2;
			int sum = nums[r];
			while(l >= 0){
				if(sum >= s){
					isPossible = true;
					break;
				}else{
					sum += nums[l];
					count++;
					l = l-1;
				}
				
			}	
			if(sum >= s){
				isPossible = true;
			}
		}
		if(isPossible){
			return count;
		}else {
			return 0;
		}
        
    }
}
