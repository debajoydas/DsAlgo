/**
 * 
 */
package com.debajoy.ds.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dasde
 *
 */
public class MajorityElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1,2,3,7,8,1,6,9};
		System.out.println(majorityElement(nums));
	}

	 public static List<Integer> majorityElement(int[] nums) {
		  	List<Integer> answers = new ArrayList<Integer>();
		  	int k = nums.length/3;
	        Integer majorityElement1  = null;
	        int netCount1 = 0;
	        
	        Integer majorityElement2  = null;
	        int netCount2 = 0;
	        
	        for(int i = 0; i < nums.length; i++){
	            if(majorityElement1 == null){
	                netCount1 = 1;
	                majorityElement1 = nums[i];
	            }else if(majorityElement2 == null){
	                netCount1 = 2;
	                majorityElement2 = nums[i];
	            }else if(nums[i] == majorityElement1){
	                netCount1++;
	            }else if(nums[i] == majorityElement2){
	                netCount2++;
	            }else if(nums[i] != majorityElement1 && netCount1 == 0){
	                majorityElement1 = nums[i];
	                netCount1 = 1;
	            }else if(nums[i] != majorityElement2 && netCount2 == 0){
	                majorityElement2 = nums[i];
	                netCount2 = 1;
	            }else {
	            	netCount1--;
	            	netCount2--;
	            }
	        }
	        int count1 = 0; 
	        int count2 = 0;
	        for(int i = 0; i < nums.length; i++) {
	        	if(majorityElement1 != null && nums[i] == majorityElement1) {
	        		count1++;
	        	}else if(majorityElement2 != null && nums[i] == majorityElement2) {
	        		count2++;
	        	}
	        }
	        if(count1 > k) {
	        	answers.add(majorityElement1);
	        }
	        if(count2 > k) {
	        	answers.add(majorityElement2);
	        }
	        
	        return answers;
	    }
}
