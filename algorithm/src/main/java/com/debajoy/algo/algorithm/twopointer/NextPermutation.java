package com.debajoy.algo.algorithm.twopointer;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2};
		nextPermutation(nums);
	}
	
	   public static void nextPermutation(int[] nums) {
	        if(nums == null || (nums != null && (nums.length == 0 || nums.length == 1))){
	            return;
	        }
	        boolean isExtreme = true;
	        int right = nums.length-1;
	        int left = right-1;
	        int intersec = 0;
	        int swap = 0;
	        while(left >= 0 && right >= 0){
	        	if(nums[left] >= nums[right]){
	        		left--;
	        		right--;
	        	}else{
	        		intersec = left;
	        		isExtreme = false;
	        		break;
	        	}
	        }
	        if(!isExtreme){
		        for(int i = nums.length-1; i > intersec; i--){
		        	if(nums[i]  > nums[intersec]){
		        		swap = i;
		        		break;
		        	}
		        }
		        //swap nums[inter] & nums[swap]
		        int temp = nums[intersec];
		        nums[intersec] = nums[swap];
		        nums[swap] = temp;
		        left = intersec+1;
		        right = nums.length-1;
	        }else{
	        	left = 0; right = nums.length-1;
	        }
	        while(left < right){
	            int temp1 = nums[right];
	            nums[right] = nums[left];
	            nums[left] = temp1;
	            left++;
	            right--;
	        }
	        display(nums);
	    }

	private static void display(int[] nums) {
		// TODO Auto-generated method stub
		for(int a : nums){
			System.out.print(a+"->");
		}
	}

}
