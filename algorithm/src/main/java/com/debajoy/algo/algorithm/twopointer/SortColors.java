/**
 * 
 */
package com.debajoy.algo.algorithm.twopointer;

/**
 * @author Debajoy
 *
 */
public class SortColors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int nums[] = {2,0,2,1,1,0};
		sortColors(nums);
	}
	
	 public static void sortColors(int[] nums) {
		 if(nums == null || (nums != null && nums.length < 1)){
			 return;
		 }
		 int countOfZero = 0;
		 int countOfOne = 0;
		 int countOfTwo = 0;
		 for(int n : nums){
			 if(n == 0){
				 countOfZero++;
			 }else if(n == 1){
				 countOfOne++;
			 }else if(n == 2){
				 countOfTwo++;
			 }
		 }
		 int index = 0;

		 while(countOfZero > 0){
			nums[index] = 0;
			index++;
			countOfZero--;
		 }
		 while(countOfOne > 0){
			nums[index] = 1;
			index++;
			countOfOne--;
		 }
		 while(countOfTwo > 0){
			nums[index] = 2;
			index++;
			countOfTwo--;
		 }
		 for(int n : nums){
			 System.out.println(n);
		 }
	 }

}
