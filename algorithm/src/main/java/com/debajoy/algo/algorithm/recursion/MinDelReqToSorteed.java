/**
 * 
 */
package com.debajoy.algo.algorithm.recursion;

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
		int[] nums = {4,2,3,6,10,1,12};
	    System.out.println(findMinimumDeletions(nums));
	    nums = new int[]{-4,10,3,7,15};
	    System.out.println(findMinimumDeletions(nums));
	    nums = new int[]{3,2,1,0};
	    System.out.println(findMinimumDeletions(nums));
	}

	private static int findMinimumDeletions(int[] nums) {
		// TODO Auto-generated method stub
		if(nums == null || (nums != null && nums.length <= 0)){
			return 0;
		}
		int next = 1;
		int current = 0;
		int longestIncreasingSequence = findMinimumDeletionsRecursion(nums, current , next, 1);
		return (nums.length-longestIncreasingSequence);
	}

	private static int findMinimumDeletionsRecursion(int[] nums, int current, int next, int length) {
		// TODO Auto-generated method stub
		
		if(next >= nums.length){
			return length;
		}
		if(nums[next] > nums[current]){
			return findMinimumDeletionsRecursion(nums, current+1, next+1, length+1);
		}else{
			return Math.max(findMinimumDeletionsRecursion(nums, current, next+1, length), findMinimumDeletionsRecursion(nums, current+1, next+1, length));
		}
	}

}
