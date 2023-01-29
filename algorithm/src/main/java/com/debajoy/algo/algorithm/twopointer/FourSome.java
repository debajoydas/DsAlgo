/**
 * 
 */
package com.debajoy.algo.algorithm.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Debajoy
 *
 */
public class FourSome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,0,-1,0,-2,2};
		int target = 0;
		List<List<Integer>> output = fourSum(nums,target);
		for(List<Integer> list : output){
			System.out.println("["+list.get(0)+"]"+"["+list.get(1)+"]"+"["+list.get(2)+"]"+"["+list.get(3)+"]");
		}
	}
	
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		int n = nums.length;
		int l = 0;
		int r = n-1;
		int c3 = 0;
		int c4 = 0;
		Arrays.sort(nums);
		
		while(c4 < n-3){
			c3 = c4+1;
			while(c3 < n-2){
				l = c3+1;
				r = n-1;
				while(l < r){
					if(nums[l]+nums[r]+nums[c3]+nums[c4] > target && l != r){
						r--;
					}else if(nums[l]+nums[r]+nums[c3]+nums[c4] < target  && l != r){
						l++;
					}else if(nums[l]+nums[r]+nums[c3]+nums[c4] == target && l != r){
						List<Integer> list = new ArrayList<Integer>();
						list.add(nums[l]);
						list.add(nums[r]);
						list.add(nums[c3]);
						list.add(nums[c4]);
						Collections.sort(list);
						if(!output.contains(list)){
							output.add(list);
						}
						l++;
						r--;					
					}
				}
				c3++;
			}
			c4++;
		}

		return output;
        
    }

}
