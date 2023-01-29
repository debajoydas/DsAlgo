/**
 * 
 */
package com.debajoy.algo.algorithm.slidingwindow;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author Debajoy
 *
 */
public class LongestContinSubarAbsDiff {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,2,2,4,4,2,5,5,5,5,5,2};
	//	int[] nums = {10,1,2,4,7,2};
		int limit = 2;	
		System.out.println(longestSubarray(nums, limit));
	}
	
	public static int longestSubarray(int[] nums, int limit) {
		
		if(nums == null || (nums != null && nums.length == 0)){
			return 0;
		}
		
		if(nums.length == 1){
			return 1;
		}
		
		int left = 0;
		int right = 1;
		while(right < nums.length){
			if(Math.abs(nums[right] -nums[left]) <= limit){
				break;
			}else{
				left++;right++;
			}
		}
		int min; 
		int max;
		int minPos;
		int maxPos;
		int maxLength = 0;
		if(nums[right] > nums[left]){
			min = nums[left];
			minPos = left;
			max = nums[right];
			maxPos = right;
		}else{
			min = nums[right];
			minPos = right;
			max = nums[left];
			maxPos = left;
		}
		maxLength = Math.max(maxLength, right-left+1);
		right++;
		
		while(right < nums.length){
			if(nums[right] >= min && nums[right] <= max){
				maxLength = Math.max(maxLength, right-left+1);
				right++;
			}else if(nums[right] < min){
				if(Math.abs(max-nums[right]) <= limit){
					min = nums[right];
					minPos = right;
					maxLength = Math.max(maxLength, right-left+1);
					right++;
				}else{
					left = maxPos + 1;
					right = left+1;
					while(right < nums.length){
						if(Math.abs(nums[right] -nums[left]) <= limit){
							break;
						}else{
							left++;right++;
						}
					}
					if(right < nums.length){
						if(nums[right] > nums[left]){
							min = nums[left];
							minPos = left;
							max = nums[right];
							maxPos = right;
						}else{
							min = nums[right];
							minPos = right;
							max = nums[left];
							maxPos = left;
						}
						right++;
					}else{
						break;
					}
				}
			}else  if(nums[right] > max){
				if(Math.abs(nums[right]-min) <= limit){
					max = nums[right];
					maxPos = right;
					maxLength = Math.max(maxLength, right-left+1);
					right++;
				}else{
					left = minPos + 1;
					right = left+1;
					while(right < nums.length){
						if(Math.abs(nums[right] -nums[left]) <= limit){
							break;
						}else{
							left++;right++;
						}
					}
					if(right < nums.length){
						if(nums[right] > nums[left]){
							min = nums[left];
							minPos = left;
							max = nums[right];
							maxPos = right;
						}else{
							min = nums[right];
							minPos = right;
							max = nums[left];
							maxPos = left;
						}
						right++;	
					}else{
						break;
					}
				}
			}
		}
		return maxLength;
	}

}
