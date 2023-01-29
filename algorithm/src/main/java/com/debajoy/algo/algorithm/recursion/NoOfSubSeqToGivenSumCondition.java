/**
 * 
 */
package com.debajoy.algo.algorithm.recursion;

/**
 * @author Debajoy
 *
 */
public class NoOfSubSeqToGivenSumCondition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,3,6,8};
		int target = 10;
		System.out.println(numSubseq(nums, target));
	}
	
	 public static int numSubseq(int[] nums, int target) {
		 int min = -1;
		 int max = -1;
		 int index = 0;
		return numSubseqRec(nums,target,min,max,index);  
	 }

	private static int numSubseqRec(int[] nums, int target, int min, int max, int index) {
		// TODO Auto-generated method stub
		
		int count = 0;
		if(index >= nums.length){
			return 0;
		}
		if(min == -1 && max == -1){
			min = nums[index];
		}else if(min != -1 && max == -1){
			if(nums[index] > min){
				max = nums[index];
			}else{
				max = min;
				min = nums[index];
			}
		}else if(min == -1 && max != -1){
			if(nums[index] > max){
				min = max;
				max = nums[index];
			}else{
				min = nums[index];
			}		
		}
		
		if(nums[index] >= min && nums[index] <= max){
			if(min+max <= target){
				count++;
			}else{
				return 0;
			}
		}else if(nums[index] < min){
			min = nums[index];
			if(min+max <= target){
				count++;
			}else{
				return 0;
			}
		}else if(nums[index] > max){
			max = nums[index];
			if(min+max <= target){
				count++;
			}else{
				return 0;
			}
		}
		return count+ numSubseqRec(nums, target, min, max, index+1) + numSubseqRec(nums, target, min, max, index+2);
	}

}
