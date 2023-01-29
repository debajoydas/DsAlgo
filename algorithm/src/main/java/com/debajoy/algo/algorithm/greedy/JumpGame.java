/**
 * 
 */
package com.debajoy.algo.algorithm.greedy;

import java.util.Calendar;

/**
 * @author Debajoy
 *
 */
public class JumpGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,2,1,0,4};
		int[] nums1 = {2,3,1,1,4};
		System.out.println(canJump(nums));
		System.out.println(canJump(nums1));

	}

	public static boolean canJump(int[] nums) {
		if(nums == null || (nums != null && nums.length <= 0)){
			return false;
		}else{
			int maxReachability = 0;
			for(int i = 0; i< nums.length; i++){
				if(i > maxReachability){
					return false;
				}else{
					maxReachability = Math.max(maxReachability, i + nums[i]);
					if(maxReachability >= nums.length){
						return true;
					}
				}
			}
		}
		
		return true;
        
    }
}
