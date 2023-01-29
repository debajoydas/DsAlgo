/**
 * 
 */
package com.debajoy.algo.algorithm.dp;

/**
 * @author Debajoy
 *
 */
public class MaxSumIncreasingSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,1,2,6,10,1,12};
	    System.out.println(findMSIS(nums));
	    nums = new int[]{-4,10,3,7,15};
	    System.out.println(findMSIS(nums));
	    nums = new int[]{1,3,8,4,14,6,14,1,9,4,13,3,11,17,29};
	    System.out.println(findMSIS(nums));
	}

	private static int findMSIS(int[] nums) {
		// TODO Auto-generated method stub
		if(nums == null){
			return 0;
		}
		int[] MIS = new int[nums.length];
		MIS[0] = nums[0];
		for(int i =1 ;i<nums.length; i++){
			MIS[i] = nums[i];
			for(int j = 0; j<i; j++){
				if(nums[j] < nums[i] && MIS[i] < (MIS[j]+nums[i])){
					MIS[i] = MIS[j]+nums[i];
				}
			}
		}
		return MIS[nums.length-1];
	}

}
