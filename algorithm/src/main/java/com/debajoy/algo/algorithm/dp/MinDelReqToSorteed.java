/**
 * 
 */
package com.debajoy.algo.algorithm.dp;

/**
 * @author Debajoy
 *
 */
public class MinDelReqToSorteed {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		int[] nums = {4,2,3,6,10,1,12};
	    System.out.println(findMinimumDeletions(nums));
	    nums = new int[]{-4,10,3,7,15};
	    System.out.println(findMinimumDeletions(nums));
	    nums = new int[]{3,2,1,0};
	    System.out.println(findMinimumDeletions(nums));
	
	}

	private static int findMinimumDeletions(int[] nums) {
		// TODO Auto-generated method stub
		int[] LIS = new int[nums.length];
		if(nums == null || (nums != null && nums.length <= 0)){
			return 0;
		}
		for(int i = 0; i < nums.length; i++){
			LIS[i] = 1;
			for(int j = 0; j<i; j++){
				if(nums[j] < nums[i] && LIS[i] < 1+LIS[j]){
					LIS[i] = 1+LIS[j];
				}
			}
		}
		return (nums.length-LIS[nums.length-1]);
	}

}
