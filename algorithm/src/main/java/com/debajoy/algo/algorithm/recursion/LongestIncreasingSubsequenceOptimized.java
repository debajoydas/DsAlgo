/**
 * 
 */
package com.debajoy.algo.algorithm.recursion;

/**
 * @author Debajoy
 *
 */
public class LongestIncreasingSubsequenceOptimized {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,2,3,6,10,1,12};
	    System.out.println(findLISLength(nums));
	    nums = new int[]{-4,10,3,7,15};
	    System.out.println(findLISLength(nums));
	}

	private static int findLISLength(int[] nums) {
		// TODO Auto-generated method stub
		if(nums == null){
			return 0;
		}
		int currentIndex = 0;
		int prevIndex = -1;
		return findLISLengthRecursion(nums, currentIndex, prevIndex);
	}

	private static int findLISLengthRecursion(int[] nums, int currentIndex, int prevIndex) {
		// TODO Auto-generated method stub
		if(currentIndex >= nums.length){
			return 0;
		}
		
		int c1 = 0;
		if(prevIndex == -1){
			c1 = 1 + findLISLengthRecursion(nums, currentIndex+1, currentIndex);
		}else if(nums[currentIndex] >= nums[prevIndex]){
			c1 = 1 + findLISLengthRecursion(nums, currentIndex+1, currentIndex);
		}
		int c2 = findLISLengthRecursion(nums, currentIndex+1, prevIndex);
		return Math.max(c1, c2);
	}

}
