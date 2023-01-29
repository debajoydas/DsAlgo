/**
 * 
 */
package com.debajoy.ds.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dasde
 *
 */
public class LongestConsecutiveSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {100,4,200,1,3,2};
		System.out.println(longestConsecutive(nums));
		System.out.println(2/5);
		System.out.println(2%5);
		System.out.println(7/5);
		System.out.println(7%5);
	}
	  public static int longestConsecutive(int[] nums) {
	        Map<Integer,Boolean> map = new HashMap<Integer,Boolean>();
	        int length = nums.length;
	        int maxlength = 0;
	        for(int i = 0; i < length; i++){
	            map.put(nums[i],false);
	        }
	        for(int i = 0; i < length; i++){
	            if(!map.get(nums[i])){
	                int seq = 1;
	                map.put(nums[i],true);
	                int next = nums[i]+1;
	                int previous = nums[i]-1;
	                while(map.get(next) != null && !map.get(next)){
	                    map.put(next,true);
	                    seq++;
	                    next = next + 1;
	                }
	                while(map.get(previous) != null && !map.get(previous)){
	                    map.put(previous,true);
	                    seq++;
	                    previous = previous - 1;
	                }
	                maxlength = Math.max(maxlength,seq);
	            }
	        }
	        return maxlength;
	    }
}
