/**
 * 
 */
package com.debajoy.ds.array;

import java.util.Stack;

/**
 * @author dasde
 *
 */
public class NonDecreasingSteps {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5,3,4,4,7,3,6,11,8,5,11};
		System.out.println(totalSteps(nums));
	}
    public static int totalSteps(int[] nums) {
        int i = 0;
        int j = 1;
        int count = 0;
        int ans = 0;
        Stack<Integer> stack = new Stack<Integer>();
        while(i < nums.length && j < nums.length){
            count = 0;
            int src = i;
            boolean isDecreasingExist = false;
            while(i < nums.length && src < nums.length &&j < nums.length && nums[j] < nums[src]){
                if(nums[j] < nums[i]){
                    j++;
                    i++;
                    isDecreasingExist = true;
                }else{
                    i++;
                    j++;
                    count++;
                }
            }
            if(isDecreasingExist){
                count += 1;
            }
            ans = Math.max(ans,count);
            src = j;
            i = src;
            j = i + 1;
        }
        return ans;
    }

}
