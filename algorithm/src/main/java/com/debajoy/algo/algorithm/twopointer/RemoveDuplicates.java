/**
 * 
 */
package com.debajoy.algo.algorithm.twopointer;

/**
 * @author Debajoy
 *
 */
public class RemoveDuplicates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,0,1,1,1,1,2,3,3};
		int l = removeDuplicates(nums);
		for(int i = 0; i< l; i++){
			System.out.print(nums[i]+",");
		}
	}
	
	 public static int removeDuplicates(int[] nums) {
		 int prev = Integer.MIN_VALUE;
		 int prevCount = 0;
		 int outputlength = 0;
		 for(int i = 0 ; i< nums.length; i++){
			 if(i == 0){
				 prev = nums[i];
				 prevCount++;
				 outputlength += 1;
			 }else{
				 if(nums[i] == prev){
					 prevCount++;
					 if(prevCount > 2){
						 continue;
					 }				 
					 outputlength += 1;
					 nums[outputlength-1] =  nums[i];
					 
				 }else{
					 prevCount = 1;
					 prev = nums[i];
					 outputlength += 1;
					 nums[outputlength-1] = nums[i];
				 }
			 }
		 }
		return outputlength;
	 }

}
